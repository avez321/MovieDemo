package com.rtr.moviesdemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rtr.moviesdemo.Constants
import com.rtr.moviesdemo.R
import com.rtr.moviesdemo.databinding.ItemCorosalBinding
import com.rtr.moviesdemo.model.Result
import kotlinx.coroutines.*

class CorosalAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
   private  var  listOfPagerContents: ArrayList<Result>?= null

    override fun getItemCount(): Int = listOfPagerContents?.size?:0

    override fun createFragment(position: Int): Fragment {
        val fragment = ViewPagerContentFragment()
        fragment.arguments = Bundle().apply {
            putParcelable(Constants.RESULT, listOfPagerContents?.get(position))
        }
        return fragment

    }

    fun setCorosalData(listOfPagerContents: ArrayList<Result>){
        this.listOfPagerContents = listOfPagerContents
        notifyDataSetChanged()
    }
}