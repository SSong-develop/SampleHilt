package com.example.samplehilt.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:bindImage")
    fun bindImage(view : ImageView , imageUrl : String){
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }

}