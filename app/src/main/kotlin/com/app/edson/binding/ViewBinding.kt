package com.app.edson.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.card.MaterialCardView

object ViewBinding {
    @JvmStatic
    @BindingAdapter("paletteImage", "paletteText", "paletteCard")
    fun bindLoadImagePalette(view: AppCompatImageView, url: String, paletteText: AppCompatTextView, paletteCard: MaterialCardView) {
        Glide.with(view.context)
                .load(url)
                .listener(
                        GlidePalette.with(url)
                                .use(BitmapPalette.Profile.MUTED_LIGHT)
                                .intoCallBack { palette ->
                                    val rgb = palette?.dominantSwatch?.rgb
                                    if (rgb != null) {
                                        paletteCard.setCardBackgroundColor(rgb)
                                    }
                                    val textColor = palette?.lightMutedSwatch?.titleTextColor
                                    if (textColor != null) {
                                        paletteText.setTextColor(textColor)
                                    }
                                }.crossfade(true)
                ).into(view)
    }
}