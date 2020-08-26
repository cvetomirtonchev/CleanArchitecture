package com.tsvetomir.tonchev.breakingbad.ui.util

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object ImageHelper {

    fun loadCircleImage(imageView: ImageView, uri: Uri) {
        Glide.with(imageView.context)
            .load(uri)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }

    fun loadImage(imageView: ImageView, uri: Uri) {
        Glide.with(imageView.context)
            .load(uri)
            .apply(RequestOptions.fitCenterTransform())
            .into(imageView)

    }
}