package com.slutsenko.newsapp.presentation.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slutsenko.newsapp.R
import com.slutsenko.newsapp.network.model.NewsModel
import com.slutsenko.newsapp.presentation.ui.web.WebViewActivity

class PagingNewsAdapter(var typeKey: String) :
    PagedListAdapter<NewsModel, RecyclerView.ViewHolder>(newsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.widget_regular_news, parent, false)
        return PagingNewsViewHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val news = getItem(position)

        if (news?.type == typeKey) {
            holder.itemView.visibility = View.VISIBLE
            holder.itemView.layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            with(holder as PagingNewsViewHolder) {
                title.text = news.title
                site.text = news.click_url
                time.text = " - " + news.time

                Glide.with(holder.itemView.context)
                    .load(news.img)
                    .centerCrop()
                    .into(this.image)
            }
        } else {
            holder.itemView.visibility = View.GONE
            holder.itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
        }
    }


    inner class PagingNewsViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        var image: ImageView = itemView.findViewById(R.id.iv_image)
        var title: TextView = itemView.findViewById(R.id.txt_title)
        var site: TextView = itemView.findViewById(R.id.txt_site)
        var time: TextView = itemView.findViewById(R.id.txt_time)

        init {
            item.setOnClickListener {
                val intent = Intent(itemView.context, WebViewActivity::class.java)
                intent.putExtra(EXTRA_URL, getItem(position)?.click_url)
                itemView.context.startActivity(intent)
            }
        }

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

        const val EXTRA_URL = "EXTRA_URL"
    }

}