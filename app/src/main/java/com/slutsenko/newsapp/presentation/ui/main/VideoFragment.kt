package com.slutsenko.newsapp.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.slutsenko.newsapp.presentation.viewmodel.NewsViewModel
import com.slutsenko.newsapp.R
import com.slutsenko.newsapp.presentation.adapter.NewsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_video.*

class VideoFragment: Fragment() {

    private lateinit var newsAdapter: NewsRecyclerAdapter
    lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(NewsViewModel::class.java)

        newsAdapter =
            NewsRecyclerAdapter(
                requireContext(),
                viewModel.videoLiveData.value ?: emptyList()
            )
        rv_video.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        rv_video.adapter = newsAdapter

        viewModel.newsLiveData.observe(requireActivity(), Observer {
            newsAdapter =
                NewsRecyclerAdapter(
                    requireContext(),
                    viewModel.videoLiveData.value ?: emptyList()
                )
            rv_video.adapter = newsAdapter
        })
    }
}