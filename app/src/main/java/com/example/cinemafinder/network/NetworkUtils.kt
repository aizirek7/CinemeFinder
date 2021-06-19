package com.example.cinemafinder.network

import com.example.cinemafinder.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkUtils {

    @GET("movie")
    suspend fun getMovie(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("sort_by") sort_by: String,
        @Query("page") page: Int
    ): Response<MovieResponse>

}