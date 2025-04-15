package com.faruk.miwok.util

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("imageResCompat")
fun setImageResCompat(view: ImageView, resId: Int) {
    if (resId != 0) {
        view.setImageDrawable(ContextCompat.getDrawable(view.context, resId))
    } else {
        view.setImageDrawable(null)
    }
}

@BindingAdapter("backgroundColorInt")
fun setBackgroundColor(view: View, color: Int) {
    view.setBackgroundColor(color)
}
