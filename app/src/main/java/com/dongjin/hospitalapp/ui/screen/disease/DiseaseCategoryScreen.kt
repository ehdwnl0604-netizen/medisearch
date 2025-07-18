package com.dongjin.hospitalapp.ui.screen.disease

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dongjin.hospitalapp.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiseaseCategoryScreen(navController: NavController) {
	val categories = listOf("감염성질환", "뇌신경정신질환", "신장비뇨기질환", "종양혈액질환(암)","근골격질환","소화기질환","호흡기질환","순환기질환")

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("질환 카테고리") },
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
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.padding(padding)
				.padding(16.dp),
			verticalArrangement = Arrangement.spacedBy(12.dp)
		) {
			items(categories) { category ->
				Card(
					modifier = Modifier
						.fillMaxWidth()
						.clickable { navController.navigate("diseaseList/$category") },
					colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
				) {
					Text(
						text = category,
						modifier = Modifier.padding(16.dp),
						style = MaterialTheme.typography.titleMedium
					)
				}
			}
		}
	}
}