package com.rtr.moviesdemo.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rtr.moviesdemo.R
import com.rtr.moviesdemo.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel


class HomeActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var activityMainBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.viewmodel = homeViewModel
        initRecycleView()
        homeViewModel.getMoviesData()

    }


    private fun initRecycleView() {
        val adapter = HomeDataAdapter()
        val layoutManager =
            LinearLayoutManager(this, GridLayoutManager.VERTICAL, false)

        adapter.setHasStableIds(true)
        activityMainBinding.rvUpcomingMovies.layoutManager = layoutManager
        activityMainBinding.rvUpcomingMovies.adapter = adapter
    }
}
