package com.slutsenko.newsapp.network

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.DataSource.Factory
import com.slutsenko.newsapp.network.model.NewsModel
import com.slutsenko.newsapp.network.service.NewsApiService


class NewsDataSourceFactory(): Factory<String, NewsModel>() {

    val newsDataSourceLiveData = MutableLiveData<NewsDataSource>()


    override fun create(): DataSource<String, NewsModel> {
        val newsDataSource = NewsDataSource()
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}