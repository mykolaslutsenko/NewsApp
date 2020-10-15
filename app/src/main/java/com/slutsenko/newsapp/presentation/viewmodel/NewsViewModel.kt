package com.slutsenko.newsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.slutsenko.newsapp.network.NewsDataSourceFactory
import com.slutsenko.newsapp.network.model.NewsModel

class NewsViewModel : ViewModel() {

    var newsLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var storiesLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var videoLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var favouriteLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var topNewsLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()




    //private val networkService = RetrofitInstance.newsRetrofit
    var pagedListLiveData: LiveData<PagedList<NewsModel>>
    //private val compositeDisposable = CompositeDisposable()
    private val pageSize = 5
    private val newsDataSourceFactory: NewsDataSourceFactory

    init {
        newsDataSourceFactory = NewsDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        pagedListLiveData = LivePagedListBuilder<String, NewsModel>(newsDataSourceFactory, config).build()
    }


//    fun getState(): LiveData<State> = Transformations.switchMap<NewsDataSource,
//            State>(newsDataSourceFactory.newsDataSourceLiveData, NewsDataSource::state)

//    fun retry() {
//        newsDataSourceFactory.newsDataSourceLiveData.value?.retry()
//    }

//    fun listIsEmpty(): Boolean {
//        return newsList.value?.isEmpty() ?: true
//    }
}