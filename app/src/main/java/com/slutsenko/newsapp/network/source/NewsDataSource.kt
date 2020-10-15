package com.slutsenko.newsapp.network.source

import androidx.paging.PageKeyedDataSource
import com.slutsenko.newsapp.network.RetrofitInstance
import com.slutsenko.newsapp.network.model.NewsModel
import com.slutsenko.newsapp.network.service.NewsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsDataSource() : PageKeyedDataSource<String, NewsModel>() {


    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, NewsModel>
    ) {
        val key: Int = 1
        val newsApiService = RetrofitInstance.newsRetrofit.create(NewsApiService::class.java)
        val data = newsApiService.getNews(key.toString())
        data.enqueue(object : Callback<List<NewsModel>> {
            override fun onResponse(
                call: Call<List<NewsModel>>,
                response: Response<List<NewsModel>>
            ) {
                val newsList: MutableList<NewsModel> = response.body() as MutableList<NewsModel>
                callback.onResult(newsList, key.toString(), (key + 1).toString())
            }

            override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {}
        })
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, NewsModel>) {
        val newsApiService = RetrofitInstance.newsRetrofit.create(NewsApiService::class.java)
        val data = newsApiService.getNews(params.key)
        data.enqueue(object : Callback<List<NewsModel>> {
            override fun onResponse(
                call: Call<List<NewsModel>>,
                response: Response<List<NewsModel>>
            ) {
                val newsList: MutableList<NewsModel> = response.body() as MutableList<NewsModel>
                callback.onResult(newsList, (params.key.toLong() + 1).toString())
            }

            override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {}
        })
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, NewsModel>) {

    }
}