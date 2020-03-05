package com.rtr.moviesdemo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import com.rtr.moviesdemo.Constants

import com.rtr.moviesdemo.R
import com.rtr.moviesdemo.databinding.FragmentViewPagerContentBinding
import com.rtr.moviesdemo.model.Result

class ViewPagerContentFragment : Fragment() {
    private lateinit var fragmentViewPagerContentBinding:FragmentViewPagerContentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentViewPagerContentBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager_content, container, false)

        val movie:Result? = arguments?.getParcelable(Constants.RESULT)
        fragmentViewPagerContentBinding.movie = movie
        return fragmentViewPagerContentBinding.root
    }

}
