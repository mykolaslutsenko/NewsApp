package com.slutsenko.newsapp.network.model

import com.google.gson.annotations.SerializedName

 data class NewsModel (

    @SerializedName("title")
    val title: String?="",

    @SerializedName("type")
    val type: String?="",

    @SerializedName("img")
    val img: String?="",

    @SerializedName("click_url")
    val click_url: String?="",

    @SerializedName("time")
    val time: String?="",

    @SerializedName("top")
    val top: String?=""
)