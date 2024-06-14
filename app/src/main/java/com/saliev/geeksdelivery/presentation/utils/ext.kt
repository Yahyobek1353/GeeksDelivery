package com.saliev.geeksdelivery.presentation.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageURL(url: String?) {
    Glide.with(this).load(url).centerCrop().into(this)
}