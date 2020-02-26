package com.rtr.moviesdemo.ui.home

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.rtr.moviesdemo.model.HomeDataModel
import com.rtr.moviesdemo.model.Result
import com.rtr.moviesdemo.model.MoviesResponse
import com.rtr.moviesdemo.network.ResultWrapper
import com.rtr.moviesdemo.repository.RepositoryImp
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeViewModel(application: Application) : AndroidViewModel(application), KoinComponent {
    private val repositoryImp: RepositoryImp by inject()
    private val homeDataObservableField : ObservableField<ArrayList<HomeDataModel>?> = ObservableField()
    private val progressObservableField:ObservableField<Int> = ObservableField(View.VISIBLE)
    private var homeDataArrayList = ArrayList<HomeDataModel>()


    init {
        homeDataArrayList.add(HomeDataModel(category = "Now Playing Movies", dataArrayList = null))
        homeDataArrayList.add(HomeDataModel(category = "Upcoming Movies", dataArrayList = null))
    }

    fun getMoviesData() {
        homeDataObservableField.set(homeDataArrayList)
        GlobalScope.launch {
            val resultWarraper = repositoryImp.getUpcomingMovie()
            withContext(Dispatchers.Main) {
                when (resultWarraper) {
                    is ResultWrapper.NetworkError -> showNetworkError()
                    is ResultWrapper.GenericError -> showGenericError(resultWarraper)
                    is ResultWrapper.Success -> showSuccess(resultWarraper.value)
                }
            }
        }
    }

    fun getNowPlayingMovies() {
        GlobalScope.launch {
            val resultWarraper = repositoryImp.getNowPlayingMovies()
            withContext(Dispatchers.Main) {
                when (resultWarraper) {
                    is ResultWrapper.NetworkError -> showNetworkError()
                    is ResultWrapper.GenericError -> showGenericError(resultWarraper)
                    is ResultWrapper.Success -> showNowPlayingSuccess(resultWarraper.value)
                }
            }
        }

    }

    private fun showNowPlayingSuccess(moviesResponse: MoviesResponse) {
        homeDataArrayList[0].dataArrayList = moviesResponse.results
        homeDataArrayList[0].progressVisibility = View.GONE
        val homeList = ArrayList<HomeDataModel>()
        homeList.addAll(homeDataArrayList)
        homeDataObservableField.set(homeList)
    }

    fun getHomeDataObservableField() = homeDataObservableField


    private fun showSuccess(moviesResponse: MoviesResponse) {
        homeDataArrayList[1].dataArrayList = moviesResponse.results
        homeDataArrayList[1].progressVisibility = View.GONE
        val homeList = ArrayList<HomeDataModel>()
        homeList.addAll(homeDataArrayList)
        homeDataObservableField.set(homeList)

        getNowPlayingMovies()
    }


    private fun showGenericError(redditResponse: Any) {
        Toast.makeText(getApplication(), redditResponse.toString(), Toast.LENGTH_SHORT).show()

    }

    private fun showNetworkError() {
        Toast.makeText(getApplication(), "network error", Toast.LENGTH_SHORT).show()
    }
}

