package com.slutsenko.newsapp.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.slutsenko.newsapp.presentation.viewmodel.NewsViewModel
import com.slutsenko.newsapp.R
import com.slutsenko.newsapp.presentation.adapter.PagingNewsAdapter
import com.slutsenko.newsapp.presentation.adapter.TopNewsAdapter
import com.slutsenko.newsapp.presentation.const.NewsType
import kotlinx.android.synthetic.main.fragment_video.*
import kotlinx.android.synthetic.main.widget_top_news.*

class VideoFragment : Fragment() {

    lateinit var viewModel: NewsViewModel
    private lateinit var topNewsAdapter: TopNewsAdapter

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

        rv_video.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        //rv_video.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))

        viewModel.pagedListLiveData.observe(requireActivity(), Observer {
            val adapter = PagingNewsAdapter(NewsType.VIDEO.key)
            adapter.submitList(viewModel.pagedListLiveData.value)
            rv_video.adapter = adapter
        })

        viewModel.topNewsLiveData.observe(requireActivity(), Observer {
            topNewsAdapter = TopNewsAdapter(
                requireContext(),
                viewModel.topNewsLiveData.value ?: emptyList()
            )
            //vp_top_news.adapter = topNewsAdapter
        })

    }


}