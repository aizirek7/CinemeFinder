package com.example.cinemafinder.network

import com.example.cinemafinder.data.Result
import com.example.cinemafinder.data.Utils
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkUtils {

    @GET("movie")
    fun getMovie(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("sort_by") sort_by: String,
        @Query("page") page: Int,
        @Query("with_watch_monetization_types") with_watch_monetization_types: String
    ): Call<Result>

    companion object{
        private var retrofitService: NetworkUtils? = null
        fun getInstance(): NetworkUtils{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(NetworkUtils::class.java)
             }
            return retrofitService!!
        }
    }

}