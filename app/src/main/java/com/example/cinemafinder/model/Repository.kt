package com.example.cinemafinder.model

import com.example.cinemafinder.R
import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.Result
import com.example.cinemafinder.network.NetworkUtils
import retrofit2.Call

class Repository(private val networkUtils: NetworkUtils): RepoImple {
    override fun getMovieWithRate(api_key: String, language: String, sort_by: String, page: Int, with_watch_monetization_types: String): Call<Result> {
        return networkUtils.getMovie(api_key, language, sort_by, page, with_watch_monetization_types)
    }

    override fun getMovieWithoutRate(api_key: String, language: String, sort_by: String, page: Int, with_watch_monetization_types: String): Call<Result> {
        return networkUtils.getMovie(api_key, language, sort_by, page, with_watch_monetization_types)
    }
}