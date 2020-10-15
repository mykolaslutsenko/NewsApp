package com.slutsenko.newsapp.network.service

import com.slutsenko.newsapp.network.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

@JvmSuppressWildcards
interface NewsApiService {

    @GET(".")
    fun getNews(@Query("page") page: String?): Call<List<NewsModel>>

//    companion object {
//        fun getService() : NewsApiService {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("http://188.40.167.45:3001/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            return retrofit.create(NewsApiService::class.java)
//        }
//    }
}