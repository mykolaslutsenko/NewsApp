package com.slutsenko.newsapp.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayoutMediator
import com.slutsenko.newsapp.R
import com.slutsenko.newsapp.presentation.adapter.NewsPageAdapter
import com.slutsenko.newsapp.presentation.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        configureNewsPageAdapter()
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
}