package com.rtr.moviesdemo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dates(
    val maximum: String?= null,
    val minimum: String?=null
):Parcelable