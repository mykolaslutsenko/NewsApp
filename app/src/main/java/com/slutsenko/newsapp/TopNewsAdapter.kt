package com.slutsenko.newsapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TopNewsAdapter(var context: Context, var topNewsList: List<NewsModel>) : PagerAdapter() {
    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return topNewsList.size
    }

    @SuppressLint("SetTextI18n")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_top_news, container, false)

        val image: ImageView = view.findViewById(R.id.iv_top_image)
        val title: TextView = view.findViewById(R.id.txt_top_title)
        val site: TextView = view.findViewById(R.id.txt_top_site)
        val time: TextView = view.findViewById(R.id.txt_top_time)

        val item = topNewsList[position]

        title.text = item.title
        site.text = item.click_url
        time.text = " - " + item.time

        Glide.with(context)
            .load(item.img)
            .centerCrop()
            .placeholder(R.drawable.ic_news)
            .into(image)
        container.addView(view)
        return view
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as View)
    }
}