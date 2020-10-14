package com.slutsenko.newsapp

import com.google.gson.annotations.SerializedName

 class NewsModel (

//     @SerializedName("name")
//     val name: String? ,
//
//
//     @SerializedName("id")
//     val id: String

    @SerializedName("title")
    val title: String?,

    @SerializedName("type")
    val type: String?,

    @SerializedName("img")
    val img: String?,

    @SerializedName("click_url")
    val click_url: String?,

    @SerializedName("time")
    val time: String?,

    @SerializedName("top")
    val top: String?
)