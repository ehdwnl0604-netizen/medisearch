package com.dongjin.hospitalapp.ui.screen.product

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavBackStackEntry

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun NaverShoppingWebViewScreen(navBackStackEntry: NavBackStackEntry) {
    val url = navBackStackEntry.arguments?.getString("url") ?: return

    AndroidView(factory = {
        WebView(it).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })
}
