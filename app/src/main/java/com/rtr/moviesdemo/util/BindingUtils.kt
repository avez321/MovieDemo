package com.rtr.moviesdemo.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rtr.moviesdemo.R
import com.rtr.moviesdemo.model.HomeDataModel
import com.rtr.moviesdemo.model.Result
import com.rtr.moviesdemo.ui.home.HomeDataAdapter
import com.rtr.moviesdemo.ui.home.MovieAdapter

object BindingUtils {
    @JvmStatic
    @BindingAdapter("android:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide
            .with(imageView.context)
            .load("https://image.tmdb.org/t/p/w500/" + url)
            .placeholder(R.drawable.loading_wait_time)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(imageView);
    }


    @JvmStatic
    @BindingAdapter("android:moviesData")
    fun setData(recyclerView: RecyclerView, movieArrayList: ArrayList<Result>?) {
        movieArrayList?.let {
            val movieAdapter = recyclerView.adapter as MovieAdapter
            movieAdapter.setData(it)
        }
    }

    @JvmStatic
    @BindingAdapter("android:homeData")
    fun setHomeData(recyclerView: RecyclerView, homeDataModelList: ArrayList<HomeDataModel>?) {
        homeDataModelList?.let {
            val movieAdapter = recyclerView.adapter as HomeDataAdapter
            movieAdapter.setData(it)
        }
    }
}
