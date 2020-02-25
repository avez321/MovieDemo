package com.rtr.moviesdemo.ui.home

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.rtr.moviesdemo.model.MoviesResponse
import com.rtr.moviesdemo.network.ResultWrapper
import com.rtr.moviesdemo.repository.RepositoryImp
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeViewModel(application: Application) : AndroidViewModel(application), KoinComponent {
    private val repositoryImp: RepositoryImp by inject()

    fun getMoviesData() {
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

    private fun showSuccess(value: MoviesResponse) {
        Toast.makeText(getApplication(), value.toString(), Toast.LENGTH_SHORT).show()
    }


    private fun showGenericError(redditResponse: Any) {
        Toast.makeText(getApplication(), redditResponse.toString(), Toast.LENGTH_SHORT).show()

    }

    private fun showNetworkError() {
        Toast.makeText(getApplication(), "network error", Toast.LENGTH_SHORT).show()
    }
}

