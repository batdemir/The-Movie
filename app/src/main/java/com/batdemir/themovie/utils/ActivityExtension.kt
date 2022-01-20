package com.batdemir.themovie.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.batdemir.themovie.R
import com.batdemir.themovie.ui.MainActivity

fun Activity.move(
    to: Class<*>,
    isKeepHistory: Boolean = false,
    bundle: Bundle? = null
) {
    val intent = Intent(this, to)
    if (bundle != null) intent.putExtras(bundle)
    this.startActivity(intent)
    this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    if (!isKeepHistory) finish()
}

fun Activity.reset() {
    val intent = Intent(this, MainActivity::class.java)
    this.startActivity(intent)
    this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    this.finishAffinity()
}