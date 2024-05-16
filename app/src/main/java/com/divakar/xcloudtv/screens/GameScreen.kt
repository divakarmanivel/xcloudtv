package com.divakar.xcloudtv.screens

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.divakar.xcloudtv.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun GameScreen(locale: String?) {
    val url = "https://www.xbox.com/$locale/play"
    val context = LocalContext.current

    Column(
        Modifier.fillMaxSize().padding(.5.dp),
    ) {
        AndroidView(factory = {
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                this.webViewClient = WebViewClient()
                this.webChromeClient = WebChromeClient()
                this.setLayerType(View.LAYER_TYPE_HARDWARE, null)
                this.settings.javaScriptEnabled = true
                this.settings.userAgentString =
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36 Edg/119.0.0."
                this.settings.domStorageEnabled = true
                this.settings.allowFileAccess = true
                this.settings.useWideViewPort = true
                this.requestFocus(View.FOCUS_DOWN)
                this.loadUrl(url)
            }
        }, update = {
            if (it.progress != 100) {
                it.stopLoading()
            }
            it.loadUrl(url)
        })
    }
}