package com.dongjin.hospitalapp.ui.screen.disease

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dongjin.hospitalapp.viewmodel.DiseaseViewModel
import com.dongjin.hospitalapp.ui.theme.AppColors
import androidx.core.net.toUri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiseaseListScreen(navController: NavController, category: String, viewModel: DiseaseViewModel = hiltViewModel()) {
	val context = LocalContext.current
	val diseases by viewModel.diseaseList.collectAsState()

	LaunchedEffect(category) {
		viewModel.loadDiseases(category)
	}

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("$category 질환 목록") },
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
			items(diseases) { disease ->
				Card(
					modifier = Modifier
						.fillMaxWidth()
						.clickable {
							val intent = Intent(Intent.ACTION_VIEW, disease.webUrl.toUri())
							context.startActivity(intent)
						},
					colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
				) {
					Row(modifier = Modifier.padding(16.dp)) {
						Spacer(modifier = Modifier.width(12.dp))
						Column {
							Text(text = "${disease.name} (${disease.englishName})", style = MaterialTheme.typography.titleMedium)
							Text(text = "증상: ${disease.symptoms.joinToString(", ")}", style = MaterialTheme.typography.bodySmall)
							Text(text = "관련질환: ${disease.relatedDiseases.joinToString(", ")}", style = MaterialTheme.typography.bodySmall)
							Text(text = "진료과: ${disease.department}", style = MaterialTheme.typography.bodySmall)
							Text(text = "동의어: ${disease.synonyms.joinToString(", ")}", style = MaterialTheme.typography.bodySmall)
						}
					}
				}
			}
		}
	}
}
