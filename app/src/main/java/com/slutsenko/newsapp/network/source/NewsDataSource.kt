package com.slutsenko.newsapp.network.source

import androidx.paging.PageKeyedDataSource
import com.slutsenko.newsapp.network.RetrofitInstance
import com.slutsenko.newsapp.network.model.NewsModel
import com.slutsenko.newsapp.network.service.NewsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsDataSource : PageKeyedDataSource<Int, NewsModel>() {


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, NewsModel>
    ) {
        val key = 1
        val newsApiService = RetrofitInstance.newsRetrofit.create(NewsApiService::class.java)
        val data = newsApiService.getNews(key)
        data.enqueue(object : Callback<List<NewsModel>> {
            override fun onResponse(
                call: Call<List<NewsModel>>,
                response: Response<List<NewsModel>>
            ) {
                val newsList: MutableList<NewsModel> = response.body() as MutableList<NewsModel>
                callback.onResult(newsList, key, (key + 1))
            }

            override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {}
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, NewsModel>) {
        val newsApiService = RetrofitInstance.newsRetrofit.create(NewsApiService::class.java)
        val data = newsApiService.getNews(params.key)
        data.enqueue(object : Callback<List<NewsModel>> {
            override fun onResponse(
                call: Call<List<NewsModel>>,
                response: Response<List<NewsModel>>
            ) {
                val newsList: MutableList<NewsModel> = response.body() as MutableList<NewsModel>
                callback.onResult(newsList, (params.key + 1))
            }

            override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {}
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, NewsModel>) {}
}