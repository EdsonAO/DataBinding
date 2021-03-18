package com.app.edson.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import androidx.recyclerview.widget.DiffUtil
import com.app.edson.BR
import com.app.edson.R
import com.app.edson.data.ApiResult
import com.app.edson.data.models.Pokemon
import com.app.edson.repository.PokemonRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.tatarka.bindingcollectionadapter2.OnItemBind
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    app: Application,
    private val pokemonRepository: PokemonRepositoryImpl
) : AndroidViewModel(app) {
    
    val onItemBind: OnItemBind<Pokemon> =
            OnItemBind { itemBinding, _, _ ->
                itemBinding.set(BR.pokemon, R.layout.pokemon_item)
            }

    val pagedList: LiveData<PagedList<Pokemon>> = LivePagedListBuilder(object : DataSource.Factory<Int, Pokemon>() {
        override fun create(): DataSource<Int, Pokemon> = object : PositionalDataSource<Pokemon>() {
            override fun loadInitial(
                params: LoadInitialParams,
                callback: LoadInitialCallback<Pokemon>
            ) { fetchRemoteData(initialCallback = callback, limit = params.pageSize, offset = 0) }

            override fun loadRange(
                params: LoadRangeParams,
                callback: LoadRangeCallback<Pokemon>
            ) { fetchRemoteData(rangeCallback = callback, limit = params.loadSize, offset = params.startPosition) }
        }
    }, PAGE_SIZE).build()

    val diffItemCallback = object : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }

    private fun fetchRemoteData(
        initialCallback: PositionalDataSource.LoadInitialCallback<Pokemon>? = null,
        rangeCallback: PositionalDataSource.LoadRangeCallback<Pokemon>? = null,
        offset: Int,
        limit: Int
    ) {
        viewModelScope.launch {
            when (val remoteCall = pokemonRepository.getPokes(limit = limit, offset = offset)) {
                is ApiResult.Success -> {
                    initialCallback?.onResult(remoteCall.data.results, offset, remoteCall.data.count)
                    rangeCallback?.onResult(remoteCall.data.results)
                }
                is ApiResult.Error -> {
                    Log.e(TAG, "Message: ${remoteCall.exception.message}")
                }
            }
        }
    }

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
        private const val PAGE_SIZE = 20
    }
}