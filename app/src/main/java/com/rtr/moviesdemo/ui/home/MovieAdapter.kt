package com.rtr.moviesdemo.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rtr.moviesdemo.databinding.ItemMovieBinding
import com.rtr.moviesdemo.model.Movie

class MovieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var movieArrayList: ArrayList<Movie>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int = movieArrayList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }


    class ContentViewHolder(
        private val binding:ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(movie:Movie){

        }
    }

}