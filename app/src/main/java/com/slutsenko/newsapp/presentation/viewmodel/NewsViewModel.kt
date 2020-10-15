package com.slutsenko.newsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.slutsenko.newsapp.network.source.NewsDataSourceFactory
import com.slutsenko.newsapp.network.model.NewsModel

class NewsViewModel : ViewModel() {

    var topNewsLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var pagedListLiveData: LiveData<PagedList<NewsModel>>
    private val pageSize = 5
    private val newsDataSourceFactory: NewsDataSourceFactory =
        NewsDataSourceFactory()

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        pagedListLiveData = LivePagedListBuilder<String, NewsModel>(newsDataSourceFactory, config).build()
    }
}