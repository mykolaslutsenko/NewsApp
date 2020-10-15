package com.slutsenko.newsapp.network.service

import com.slutsenko.newsapp.network.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

@JvmSuppressWildcards
interface NewsApiService {

    @GET(".")
    fun getNews(@Query("page") page: Int?): Call<List<NewsModel>>

}