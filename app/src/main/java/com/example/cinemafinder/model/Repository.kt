package com.example.cinemafinder.model

import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.MovieResponse
import com.example.cinemafinder.data.RetrofitService
import com.example.cinemafinder.data.Utils
import retrofit2.Response

class Repository(): RepoImple {
    override suspend fun getMovieWithRate(sort_by: String, page: Int): Response<MovieResponse> {
        return RetrofitService.get().getMovie(Utils.API_KEY, "ru-Ru", sort_by, page)
    }

    override suspend fun getMovieWithoutRate(sort_by: String, page:Int): Response<MovieResponse> {
        return RetrofitService.get().getMovie(Utils.API_KEY, "ru-Ru", sort_by, page)
    }
}