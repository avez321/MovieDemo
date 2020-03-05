package com.rtr.moviesdemo.util

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Context.showtoast(msg: String, lenght: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, lenght).show()
}