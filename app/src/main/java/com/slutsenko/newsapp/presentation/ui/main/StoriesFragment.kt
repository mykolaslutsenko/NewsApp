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
import com.slutsenko.newsapp.presentation.adapter.PagingNewsAdapter
import com.slutsenko.newsapp.presentation.adapter.TopNewsAdapter
import kotlinx.android.synthetic.main.fragment_stories.*

class StoriesFragment : Fragment() {

    private lateinit var newsAdapter: NewsRecyclerAdapter
    private lateinit var topNewsAdapter: TopNewsAdapter
    lateinit var viewModel: NewsViewModel
    private var dotscount = 0

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
//        newsAdapter =
//            NewsRecyclerAdapter(
//                requireContext(),
//                viewModel.storiesLiveData.value ?: emptyList()
//            )
        rv_stories.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
//        rv_stories.adapter = newsAdapter


        viewModel.pagedListLiveData.observe(requireActivity(), Observer {
            val adapter = PagingNewsAdapter()
            adapter.submitList(it)
            rv_stories.adapter = adapter
        })

        viewModel.newsLiveData.observe(requireActivity(), Observer {
//            newsAdapter =
//                NewsRecyclerAdapter(
//                    requireContext(),
//                    viewModel.storiesLiveData.value ?: emptyList()
//                )
//            rv_stories.adapter = newsAdapter
        })
    }

//        viewModel.topNewsLiveData.observe(requireActivity(), Observer {
//            topNewsAdapter = TopNewsAdapter(
//                requireContext(),
//                viewModel.topNewsLiveData.value ?: emptyList()
//            )
//            vp_top_news.adapter = topNewsAdapter

//            dotscount = topNewsAdapter.count
//            val dots = arrayOfNulls<ImageView>(dotscount)
//
//
//            for (i in 0 until dotscount) {
//                dots[i] = ImageView(requireContext())
//                dots[i]!!.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_dehaze))
//                val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//                params.setMargins(8, 0, 8, 0)
//                ll_slider_dots!!.addView(dots[i], params)
//            }
//            //dots[0]?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_news))
//
//
//            vp_top_news.setOnPageChangeListener(object: ViewPager.OnPageChangeListener{
//                override fun onPageScrollStateChanged(state: Int) {}
//
//                override fun onPageScrolled(
//                    position: Int,
//                    positionOffset: Float,
//                    positionOffsetPixels: Int){}
//
//                override fun onPageSelected(position: Int) {
//                    for (i in 0 until dotscount) {
//                        dots[i]?.setImageDrawable(
//                            ContextCompat.getDrawable(
//                                requireContext(),R.drawable.ic_dehaze)
//                        )
//                    }
//                    dots[position]?.setImageDrawable(
//                        ContextCompat.getDrawable(
//                            requireActivity(),R.drawable.ic_news)
//                    )
//                }
//            })
//        })
//        configureTopNewsView()
//    }
//
//    private fun configureTopNewsView() {
//        topNewsAdapter = TopNewsAdapter(
//            requireContext(),
//            viewModel.topNewsLiveData.value ?: emptyList()
//        )
//        vp_top_news.adapter = topNewsAdapter
//
//    }


}