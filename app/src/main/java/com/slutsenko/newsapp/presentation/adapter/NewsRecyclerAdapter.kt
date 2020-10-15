package com.slutsenko.newsapp.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slutsenko.newsapp.network.model.NewsModel
import com.slutsenko.newsapp.R
import com.slutsenko.newsapp.presentation.ui.web.WebViewActivity

class NewsRecyclerAdapter(private val context: Context, private val newsList: List<NewsModel>) :
    RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.widget_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        with(holder) {
            title.text = news.title
            site.text = news.click_url
            time.text = " - " + news.time

            Glide.with(context)
                .load(news.img)
                .centerCrop()
                .into(this.image)
        }


    }

    inner class NewsViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var image: ImageView = itemView.findViewById(R.id.iv_image)
        var title: TextView = itemView.findViewById(R.id.txt_title)
        var site: TextView = itemView.findViewById(R.id.txt_site)
        var time: TextView = itemView.findViewById(R.id.txt_time)


        init {
            item.setOnClickListener {
                val intent = Intent(context, WebViewActivity::class.java)
                intent.putExtra(EXTRA_URL, newsList[position].click_url)
                context.startActivity(intent)
            }
        }


    }

    companion object {
        val EXTRA_URL = "EXTRA_URL"
    }
}