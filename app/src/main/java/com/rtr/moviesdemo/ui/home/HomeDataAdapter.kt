package com.rtr.moviesdemo.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rtr.moviesdemo.R
import com.rtr.moviesdemo.databinding.ItemHomeDataBinding
import com.rtr.moviesdemo.model.HomeDataModel

class HomeDataAdapter : RecyclerView.Adapter<HomeDataAdapter.HomeDataViewHolder>() {
    private var homedataArrayList: ArrayList<HomeDataModel>? = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDataViewHolder {
        val homedataBinding = DataBindingUtil.inflate<ItemHomeDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_data,
            parent,
            false
        )
        return HomeDataViewHolder(homedataBinding)
    }

    override fun getItemCount(): Int = homedataArrayList?.size ?: 0


    override fun onBindViewHolder(contentViewHolder: HomeDataViewHolder, position: Int) {
        contentViewHolder.binding.rvUpcomingMovies.layoutManager = LinearLayoutManager(
            contentViewHolder.binding.txtCategoryname.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        contentViewHolder.binding.rvUpcomingMovies.adapter = MovieAdapter()

        contentViewHolder.bind(homedataArrayList?.get(position))
    }

    fun setData(homedataArrayList: ArrayList<HomeDataModel>?) {
        this.homedataArrayList = homedataArrayList
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return homedataArrayList?.get(position)?.id?:0
    }


    class HomeDataViewHolder(
        val binding: ItemHomeDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(homeData: HomeDataModel?) {
            binding.homedata = homeData
        }
    }

}