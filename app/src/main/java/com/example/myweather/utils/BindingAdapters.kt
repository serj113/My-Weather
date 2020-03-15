package com.example.myweather.utils

import android.view.View
import android.view.animation.Animation
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["animating", "animationSource"])
fun setAnimation(view: View, animating: Boolean?, animation: Animation?) {
    if(animation != null && animating != null && animating) {
        view.startAnimation(animation)
    }
}