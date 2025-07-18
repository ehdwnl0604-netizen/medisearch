package com.dongjin.hospitalapp.ui.screen.caregiver

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.dongjin.hospitalapp.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun CareServiceWebViewScreen(
    navController: NavController
) {
    val url = "https://www.bizno.net/%EC%83%81%ED%98%B8%EB%AA%85%EC%9C%BC%EB%A1%9C%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EB%B2%88%ED%98%B8%EC%A1%B0%ED%9A%8C/?query=%EA%B0%84%EB%B3%91"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("간병서비스 검색") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "뒤로가기")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppColors.Background,
                    titleContentColor = AppColors.Title
                )
            )
        },
        containerColor = AppColors.Background
    ) { padding ->
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                    loadUrl(url)
                }
            }
        )
    }
}
