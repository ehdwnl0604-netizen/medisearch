package com.dongjin.hospitalapp.ui.screen.caregiver

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.dongjin.hospitalapp.viewmodel.CaregiverViewModel
import com.dongjin.hospitalapp.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaregiverListScreen(
    region: String,
    viewModel: CaregiverViewModel = hiltViewModel(),
    navController: NavHostController
) {
	val caregiverList by viewModel.caregiverList.collectAsState()
	val isLoading by viewModel.isLoading.collectAsState()

	LaunchedEffect(region) {
		viewModel.loadCaregivers(region)
	}

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("$region 간병협회 목록") },navigationIcon = {
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
		when {
			isLoading -> {
				Box(
					modifier = Modifier
						.fillMaxSize()
						.padding(padding),
					contentAlignment = Alignment.Center
				) {
					CircularProgressIndicator()
				}
			}
			caregiverList.isEmpty() -> {
				Box(
					modifier = Modifier
						.fillMaxSize()
						.padding(padding),
					contentAlignment = Alignment.Center
				) {
					Text("등록된 간병 협회 정보가 없습니다.", style = MaterialTheme.typography.bodyLarge)
				}
			}
			else -> {
				LazyColumn(
					modifier = Modifier
						.fillMaxSize()
						.padding(padding)
						.padding(16.dp),
					verticalArrangement = Arrangement.spacedBy(12.dp)
				) {
					items(caregiverList) { caregiver ->
						Card(
							modifier = Modifier.fillMaxWidth(),
							colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
						) {
							Column(modifier = Modifier.padding(16.dp)) {
								Text(caregiver.name, style = MaterialTheme.typography.titleMedium)
								Spacer(modifier = Modifier.height(4.dp))
								Text("주소: ${caregiver.address}", style = MaterialTheme.typography.bodyMedium)
								Text("연락처: ${caregiver.phone}", style = MaterialTheme.typography.bodyMedium)
							}
						}
					}
				}
			}
		}
	}
}
