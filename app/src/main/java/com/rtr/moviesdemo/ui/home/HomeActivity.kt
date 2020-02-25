package com.rtr.moviesdemo.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtr.moviesdemo.R
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {
    val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeViewModel.getMoviesData()

    }
}
