package com.slutsenko.newsapp.network

import androidx.paging.PageKeyedDataSource
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

        val newsApiService = RetrofitInstance.newsRetrofit.create(NewsApiService::class.java)
        val data = newsApiService.getNews("1")
        data.enqueue(object : Callback<List<NewsModel>> {
            override fun onResponse(
                call: Call<List<NewsModel>>,
                response: Response<List<NewsModel>>
            ) {
                //viewModel.newsLiveData.value = response.body()
                val newsList: MutableList<NewsModel> = response.body() as MutableList<NewsModel>
                callback.onResult(newsList, null, "2")
            }

            override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {
                //Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
            }
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
                //viewModel.newsLiveData.value = response.body()
                val newsList: MutableList<NewsModel> = response.body() as MutableList<NewsModel>
                callback.onResult(newsList, (params.key.toLong() + 1).toString())
            }

            override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {
                //Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, NewsModel>) {

    }
}