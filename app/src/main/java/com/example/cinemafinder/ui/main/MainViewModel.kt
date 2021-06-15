package com.example.cinemafinder.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.Result
import com.example.cinemafinder.data.Utils
import com.example.cinemafinder.model.Repository
import com.example.cinemafinder.network.NetworkUtils
import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates

class MainViewModel : ViewModel() {
    var liveDataMovieWithRate = MutableLiveData<List<Movie>>()
    var livedataMovieWithoutRate = MutableLiveData<List<Movie>>()

    private val repository = Repository(NetworkUtils.getInstance())

    fun getMovie(language: String, sort_by: String, page: Int) {
        repository.getMovieWithRate(Utils.API_KEY, language, sort_by, page, "flatrate")
            .enqueue(object : retrofit2.Callback<Result> {
                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    if (response.isSuccessful) {
                        val movie = response.body()
                        Log.i("MyTag", movie.toString())
                        if (sort_by.equals("popularity.desc")) {
                            livedataMovieWithoutRate.value = movie!!.results
                        } else {
                            liveDataMovieWithRate.value = movie!!.results
                        }
                    }
                }

                override fun onFailure(call: Call<Result>, t: Throwable) {
                    Log.i("MyTag", t.message.toString())
                }
            })
    }
}