package com.example.myweather.utils

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment

fun Fragment.goTo(directions: NavDirections) {
    NavHostFragment.findNavController(this).navigate(directions)
}