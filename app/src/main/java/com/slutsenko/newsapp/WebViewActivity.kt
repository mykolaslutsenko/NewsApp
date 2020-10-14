package com.slutsenko.newsapp

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebSettings.LOAD_CACHE_ELSE_NETWORK
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.slutsenko.newsapp.NewsRecyclerAdapter.Companion.EXTRA_URL
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val url = intent.getStringExtra(EXTRA_URL)
        with(web_view) {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            settings.cacheMode = LOAD_CACHE_ELSE_NETWORK
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)
            loadUrl(url ?: "https://www.google.com")
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }


    override fun onBackPressed() {
        if (web_view.canGoBack()) {
            web_view.goBack()
        } else {
            super.onBackPressed()
        }
    }
}