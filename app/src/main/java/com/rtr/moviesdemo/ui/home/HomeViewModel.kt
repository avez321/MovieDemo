package com.rtr.moviesdemo.ui.home

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.rtr.moviesdemo.Constants
import com.rtr.moviesdemo.model.HomeDataModel
import com.rtr.moviesdemo.model.MoviesResponse
import com.rtr.moviesdemo.model.Result
import com.rtr.moviesdemo.network.ResultWrapper
import com.rtr.moviesdemo.repository.RepositoryImp
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeViewModel(application: Application) : AndroidViewModel(application), KoinComponent {
    private val repositoryImp: RepositoryImp by inject()
    private val homeDataObservableField: ObservableField<ArrayList<HomeDataModel>?> =
        ObservableField()

    private val corosalObservableField: ObservableField<ArrayList<Result>?> =
        ObservableField()



    fun getMoviesData() {
        homeDataObservableField.set(Constants.homeDataArrayList.filter {
            it.id!=1L
        } as ArrayList<HomeDataModel>)
        Constants.homeDataArrayList.forEach { homedata ->
            GlobalScope.launch {
                val resultWarraper = repositoryImp.getMovies(homedata.url)
                withContext(Dispatchers.Main) {
                    when (resultWarraper) {
                        is ResultWrapper.NetworkError -> showNetworkError()
                        is ResultWrapper.GenericError -> showGenericError(resultWarraper)
                        is ResultWrapper.Success ->
                            showSuccess(resultWarraper.value, homedata)
                    }
                }
            }
        }

    }

    fun getHomeDataObservableField() = homeDataObservableField

    fun getCorosalObservableField() = corosalObservableField


    private fun showSuccess(moviesResponse: MoviesResponse, homedata: HomeDataModel) {
        homedata.dataArrayList = moviesResponse.results
        homedata.progressVisibility = View.GONE

        val homeList = ArrayList<HomeDataModel>()
        homeList.addAll(Constants.homeDataArrayList)


        for (i in 0 until Constants.homeDataArrayList.size) {

            if(homedata.id ==1L) {
                corosalObservableField.set(homedata.dataArrayList)
            } else if (Constants.homeDataArrayList[i].id == homedata.id) {
                homeList[i].dataArrayList = homedata.dataArrayList
                homeDataObservableField.set(homeList.filter { it.id!=1L } as ArrayList<HomeDataModel>)
            }
        }

    }


    private fun showGenericError(redditResponse: Any) {
        Toast.makeText(getApplication(), redditResponse.toString(), Toast.LENGTH_SHORT).show()

    }

    private fun showNetworkError() {
        Toast.makeText(getApplication(), "network error", Toast.LENGTH_SHORT).show()
    }
}

