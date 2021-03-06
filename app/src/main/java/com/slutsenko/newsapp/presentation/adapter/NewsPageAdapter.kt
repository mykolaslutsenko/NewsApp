package com.slutsenko.newsapp.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.slutsenko.newsapp.presentation.ui.main.FavouritesFragment
import com.slutsenko.newsapp.presentation.ui.main.StoriesFragment
import com.slutsenko.newsapp.presentation.ui.main.VideoFragment

class NewsPageAdapter(fr: FragmentActivity) : FragmentStateAdapter(fr) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StoriesFragment()
            1 -> VideoFragment()
            else -> FavouritesFragment()
        }
    }

}