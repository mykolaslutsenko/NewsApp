package com.slutsenko.newsapp.presentation.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.tabs.TabLayoutMediator
import com.slutsenko.newsapp.presentation.viewmodel.NewsViewModel
import com.slutsenko.newsapp.R
import com.slutsenko.newsapp.presentation.adapter.PagingNewsAdapter
import com.slutsenko.newsapp.presentation.adapter.TopNewsAdapter
import com.slutsenko.newsapp.presentation.const.NewsType
import kotlinx.android.synthetic.main.fragment_stories.*
import kotlinx.android.synthetic.main.widget_top_news.*

class StoriesFragment : Fragment() {


    private lateinit var topNewsAdapter: TopNewsAdapter
    lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(NewsViewModel::class.java)

        rv_stories.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)


        viewModel.pagedListLiveData.observe(requireActivity(), Observer {
            val adapter = PagingNewsAdapter(NewsType.STORIES.key)
            adapter.submitList(viewModel.pagedListLiveData.value)
            rv_stories.adapter = adapter
        })

        viewModel.topNewsLiveData.observe(requireActivity(), Observer {
            topNewsAdapter = TopNewsAdapter(
                requireContext(),
                viewModel.topNewsLiveData.value ?: emptyList()
            )
            vp_top_news.adapter = topNewsAdapter
        })


    }
    }