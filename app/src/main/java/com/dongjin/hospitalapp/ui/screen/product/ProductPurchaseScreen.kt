package com.dongjin.hospitalapp.ui.screen.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dongjin.hospitalapp.ui.theme.AppColors
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ProductPurchaseScreen(
	navController: NavController
) {
	var searchText by remember { mutableStateOf("") }

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("물품구매") },
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
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(padding)
				.padding(16.dp),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			OutlinedTextField(
				value = searchText,
				onValueChange = { searchText = it },
				modifier = Modifier.fillMaxWidth(),
				placeholder = { Text("제품명 검색") },
				singleLine = true,
				shape = RoundedCornerShape(12.dp)
			)

			Spacer(modifier = Modifier.height(12.dp))

			Button(
				onClick = {
					if (searchText.isNotBlank()) {
						val encoded = URLEncoder.encode(searchText, "UTF-8")
						val url = "https://search.shopping.naver.com/search/all?query=$encoded"
						navController.navigate("naverShoppingWebView?url=$url")
					}
				}
			) {
				Text("네이버쇼핑에서 검색")
			}
		}
	}
}