package com.example.cinemafinder.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.RetrofitService
import com.example.cinemafinder.data.Utils
import com.example.cinemafinder.model.Repository
import com.example.cinemafinder.network.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {
    var liveDataMovieWithRate = MutableLiveData<List<Movie>>()
    var livedataMovieWithoutRate = MutableLiveData<List<Movie>>()
    private val repository = Repository()

    init {
        getMovie("popularity.desc", 1)
        getMovie("vote_count.desc", 1)
    }

    private fun getMovie(sort_by: String, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getMovieWithRate(sort_by, page)
            if (response.isSuccessful && response.body() != null) {
                withContext(Dispatchers.Main) {
                    if (sort_by == "popularity.desc") {
                        livedataMovieWithoutRate.value = response.body()?.results
                    }
                    else {
                        liveDataMovieWithRate.value = response.body()?.results
                    }
                }
            }
        }
    }
}



