package com.dongjin.hospitalapp.ui.screen.caregiver

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dongjin.hospitalapp.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaregiverServiceScreen(navController: NavController) {
	val regions = listOf("서울", "경기북부", "경기서부", "경기동부", "경기남부", "강원", "대전충남", "충북", "대구경북", "부산경남", "전북", "전남", "제주")

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("간병서비스 지역 선택") },
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
			items(regions) { region ->
				Card(
					modifier = Modifier
						.fillMaxWidth()
						.clickable {
							navController.navigate("caregiverList/$region")
						},
					colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
				) {
					Text(
						text = region,
						modifier = Modifier.padding(16.dp),
						style = MaterialTheme.typography.titleMedium
					)
				}
			}
		}
	}
}