package com.example.changerscodechallenge.bindingadapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.changerscodechallenge.R

object BindingAdapters {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = it.toUri()

            Glide.with(imgView.context)
                .load(imgUri)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imgView)
        }
    }
}