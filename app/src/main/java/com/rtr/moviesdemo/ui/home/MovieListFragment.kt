package com.rtr.moviesdemo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.google.android.material.tabs.TabLayoutMediator

import com.rtr.moviesdemo.R
import com.rtr.moviesdemo.databinding.FragmentMovieListBinding
import org.koin.android.viewmodel.ext.android.viewModel


class MovieListFragment : Fragment() {
    private lateinit var fragmentMovieListBinding: FragmentMovieListBinding
    private val homeViewModel: HomeViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieListBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        fragmentMovieListBinding.viewmodel = homeViewModel
        initRecycleView()
        homeViewModel.getMoviesData()
        return fragmentMovieListBinding.root
    }


    private fun initRecycleView() {
        val adapter = HomeDataAdapter()
        val layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adapter.setHasStableIds(true)
        fragmentMovieListBinding.rvUpcomingMovies.layoutManager = layoutManager
        fragmentMovieListBinding.rvUpcomingMovies.adapter = adapter



        val corosalAdapter = CorosalAdapter(this)
        fragmentMovieListBinding.rvCorosal.adapter = corosalAdapter

        /*TabLayoutMediator(fragmentMovieListBinding.intoTabLayout, fragmentMovieListBinding.rvCorosal)
        { tab, position ->}.attach()*/
    }

}
