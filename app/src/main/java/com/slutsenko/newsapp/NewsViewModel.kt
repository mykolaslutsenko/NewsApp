package com.slutsenko.newsapp

import androidx.lifecycle.MutableLiveData

class NewsViewModel : BaseViewModel() {

    var newsLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var storiesLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var videoLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var favouriteLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    var topNewsLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()


}