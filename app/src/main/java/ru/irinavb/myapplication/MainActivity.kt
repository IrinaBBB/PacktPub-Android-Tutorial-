package ru.irinavb.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)

        // webView.settings.javaScriptEnabled = true
        true.also { webView.settings.javaScriptEnabled = it }
        setContentView(webView)
        webView.loadUrl("https://www.google.com")
    }
}