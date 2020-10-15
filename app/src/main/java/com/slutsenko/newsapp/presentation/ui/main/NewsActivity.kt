package com.slutsenko.newsapp.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayoutMediator
import com.slutsenko.newsapp.network.service.NewsApiService
import com.slutsenko.newsapp.network.model.NewsModel
import com.slutsenko.newsapp.presentation.viewmodel.NewsViewModel
import com.slutsenko.newsapp.R
import com.slutsenko.newsapp.presentation.adapter.NewsPageAdapter
import kotlinx.android.synthetic.main.activity_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

//    lateinit var newsApiService: NewsApiService


//    init {
//        provideRetrofit()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        configureNewsPageAdapter()
        getNews()

        viewModel.newsLiveData.observe(this, Observer {
            setNewsTypeLiveData(it)
        })
    }

    private fun configureNewsPageAdapter() {

        vp2_news.isUserInputEnabled = false
        vp2_news.adapter = NewsPageAdapter(this)
        TabLayoutMediator(tl_news, vp2_news) { tl_news, position ->
            when (position) {
                0 -> tl_news.text = getString(R.string.stories)
                1 -> tl_news.text = getString(R.string.video)
                else -> tl_news.text = getString(R.string.favourites)
            }
        }.attach()
    }

//    private fun provideRetrofit() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://188.40.167.45:3001/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        newsApiService = retrofit.create(NewsApiService::class.java)
//    }

    private fun getNews() {
//        val call = newsApiService.getNews("?page=2")
//        call.enqueue(object : Callback<List<NewsModel>> {
//            override fun onResponse(
//                call: Call<List<NewsModel>>,
//                response: Response<List<NewsModel>>
//            ) {
//                viewModel.newsLiveData.value = response.body()
//            }
//
//            override fun onFailure(call: Call<List<NewsModel>>, t: Throwable) {
//                //Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
//            }
//        })
    }

    private fun setNewsTypeLiveData(news: List<NewsModel>?) {
        viewModel.storiesLiveData.value = news?.filter { it.type == NewsType.STORIES.key }
        viewModel.videoLiveData.value = news?.filter { it.type == NewsType.VIDEO.key }
        viewModel.favouriteLiveData.value = news?.filter { it.type == NewsType.FAVOURITES.key }
        viewModel.topNewsLiveData.value = news?.filter { it.top == NewsType.TOP.key }
    }


    enum class NewsType(var key: String) {
        STORIES("strories"),
        VIDEO("video"),
        FAVOURITES("favourites"),
        TOP("1")
    }

}