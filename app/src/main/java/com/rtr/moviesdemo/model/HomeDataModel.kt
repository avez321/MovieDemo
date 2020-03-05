package com.rtr.moviesdemo.model

import android.view.View

data class HomeDataModel(
    val id: Long = 0,
    val category: String,
    var dataArrayList: ArrayList<Result>?,
    var progressVisibility: Int = View.VISIBLE,
    var url: String
)