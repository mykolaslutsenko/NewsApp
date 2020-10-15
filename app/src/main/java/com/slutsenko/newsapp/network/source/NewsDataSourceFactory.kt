package com.slutsenko.newsapp.network.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.DataSource.Factory
import com.slutsenko.newsapp.network.model.NewsModel


class NewsDataSourceFactory: Factory<Int, NewsModel>() {

    private val newsDataSourceLiveData = MutableLiveData<NewsDataSource>()

    override fun create(): DataSource<Int, NewsModel> {
        val newsDataSource = NewsDataSource()
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}