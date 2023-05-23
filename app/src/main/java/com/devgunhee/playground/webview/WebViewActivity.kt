package com.devgunhee.playground.webview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.devgunhee.playground.R
import com.devgunhee.playground.databinding.ActivityWebviewBinding

/**************************************************************************************************
 * Title :
 * Description : WebView 연동 샘플
 *
 * @author   devgunhee@gmail.com
 * @since    2023-05-23
 **************************************************************************************************/

class WebViewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_webview)

        binding.webView.apply {
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    Log.d(TAG, "onPageStarted >> view = $view, url = $url, favicon = $favicon")
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    Log.d(TAG, "onPageFinished >> view = $view, url = $url")
                }

                override fun onLoadResource(view: WebView?, url: String?) {
                    super.onLoadResource(view, url)
                    Log.d(TAG, "onLoadResource >> view = $view, url = $url")
                }
            }

            webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView?,
                    url: String?,
                    message: String?,
                    result: JsResult?
                ): Boolean {
                    Log.d(TAG, "onJsAlert >> view = $view, url = $url, message = $message, result = $result")
                    return super.onJsAlert(view, url, message, result)
                }
            }

            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.useWideViewPort = true
            settings.loadWithOverviewMode = false
            loadUrl(URL)
        }
    }

    companion object {
        private const val TAG = "WebViewActivity"
        private const val URL = "https://www.google.com"
    }
}