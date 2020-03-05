package com.rtr.moviesdemo.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rtr.moviesdemo.R
import com.rtr.moviesdemo.model.HomeDataModel
import com.rtr.moviesdemo.model.Result
import com.rtr.moviesdemo.ui.home.CorosalAdapter
import com.rtr.moviesdemo.ui.home.HomeDataAdapter
import com.rtr.moviesdemo.ui.home.MovieAdapter
import com.rtr.moviesdemo.util.BindingUtils.runnable


object BindingUtils {
    lateinit var runnable:Runnable
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
    @BindingAdapter("android:imageUrlCorosal")
    fun setImageUrlCorosal(imageView: ImageView, url: String?) {
        Glide
            .with(imageView.context)
            .load("https://image.tmdb.org/t/p/w300/" + url)
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


    @JvmStatic
    @BindingAdapter("android:carousel")
    fun setCarouselData(
        viewPager: ViewPager2,
        moviesList: ArrayList<Result>?) {
        moviesList?.let {
            val movieAdapter = viewPager.adapter as CorosalAdapter
            movieAdapter.setCorosalData(it)
            delayedScroll(viewPager,0,moviesList)

        }
    }
}

 fun delayedScroll(viewPager: ViewPager2, i: Int, moviesList: ArrayList<Result>) {

      runnable = Runnable() {
         viewPager.setCurrentItem(i, true)
         delayedScroll(viewPager, i + 1, moviesList)
         Log.d("***data",i.toString()+"value")
         if (i == moviesList.size - 1) {
             viewPager.handler.removeCallbacks(runnable)
             delayedScroll(viewPager, 0, moviesList)
         }
     }

     viewPager.postDelayed(runnable, 5000)


     /*viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

     })*/


 }

