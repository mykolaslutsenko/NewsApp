package com.slutsenko.newsapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slutsenko.newsapp.R
import com.slutsenko.newsapp.network.model.NewsModel

class PagingNewsAdapter: PagedListAdapter<NewsModel, PagingNewsAdapter.PagingNewsViewHolder>(newsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingNewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.widget_news, parent, false)
        return PagingNewsViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PagingNewsViewHolder, position: Int) {
        val news = getItem(position)
        with(holder) {
            title.text = news?.title
            site.text = news?.click_url
            time.text = " - " + news?.time

            Glide.with(holder.itemView.context)
                .load(news?.img)
                .centerCrop()
                .into(this.image)
        }
    }

    inner class PagingNewsViewHolder(item: View): RecyclerView.ViewHolder(item) {

        var image: ImageView = itemView.findViewById(R.id.iv_image)
        var title: TextView = itemView.findViewById(R.id.txt_title)
        var site: TextView = itemView.findViewById(R.id.txt_site)
        var time: TextView = itemView.findViewById(R.id.txt_time)

    }

    companion object {
        val newsDiffCallback = object : DiffUtil.ItemCallback<NewsModel>() {
            override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}