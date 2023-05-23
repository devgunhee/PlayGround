package com.devgunhee.playground

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.devgunhee.playground.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        startActivity(
            Intent(Intent.ACTION_MAIN).apply {
                setClassName(this@MainActivity, WEBVIEW_ACTIVITY)
            })
    }

    companion object {
        private const val WEBVIEW_ACTIVITY = "com.devgunhee.playground.webview.WebViewActivity"
    }
}