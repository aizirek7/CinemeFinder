package com.example.cinemafinder.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemafinder.model.Movie
import com.example.cinemafinder.model.Repository
import com.example.cinemafinder.ui.main.adapter.Adapter

class MainViewModel: ViewModel() {
    private val liveDataMovieWithRate = MutableLiveData<List<Movie>>()
    private val liveDataMovieWithoutRate = MutableLiveData<List<Movie>>()

    private val repository = Repository()


    fun getMovieRate(){
        val movieList = repository.getMovieWithRate()
        liveDataMovieWithRate.value = movieList
    }

    fun getMovie(){
        val movies = repository.getMovieWithoutRate()
        liveDataMovieWithoutRate.value = movies
    }

    fun liveDataWithRate() : MutableLiveData<List<Movie>> {
        return liveDataMovieWithRate
    }

    fun liveDataWithoutRate(): MutableLiveData<List<Movie>>{
        return liveDataMovieWithoutRate
    }












}