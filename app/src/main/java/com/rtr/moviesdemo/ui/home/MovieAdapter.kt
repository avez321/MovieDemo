package com.rtr.moviesdemo.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rtr.moviesdemo.R
import com.rtr.moviesdemo.databinding.ItemMovieBinding
import com.rtr.moviesdemo.model.Result

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ContentViewHolder>() {
    private var movieArrayList: ArrayList<Result>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val movieBinding = DataBindingUtil.inflate<ItemMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )

        return ContentViewHolder(movieBinding)
    }

    override fun getItemCount(): Int = movieArrayList?.size ?: 0


    override fun onBindViewHolder(contentViewHolder: ContentViewHolder, position: Int) {
        contentViewHolder.bind(movieArrayList?.get(position))
    }


    fun setData(movieArrayList: ArrayList<Result>) {
        this.movieArrayList = movieArrayList
        notifyDataSetChanged()
    }

    class ContentViewHolder(
        val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(movie: Result?) {
            binding.movie = movie
        }
    }

}