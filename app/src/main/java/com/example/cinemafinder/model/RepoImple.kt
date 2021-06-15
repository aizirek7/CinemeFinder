package com.example.cinemafinder.model

import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.Result
import retrofit2.Call

interface RepoImple {
    fun getMovieWithRate(api_key: String,language: String,sort_by: String,page: Int,with_watch_monetization_types: String): Call<Result>
    fun getMovieWithoutRate(api_key: String,language: String,sort_by: String,page: Int,with_watch_monetization_types: String): Call<Result>
}