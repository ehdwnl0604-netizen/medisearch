package com.dongjin.hospitalapp.ui.screen.hospital

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dongjin.hospitalapp.data.Hospital
import com.dongjin.hospitalapp.ui.theme.AppColors
import com.dongjin.hospitalapp.viewmodel.HospitalViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalDetailScreen(
	navController: NavController,
	hospital: Hospital,
	viewModel: HospitalViewModel = hiltViewModel()
) {
	val context = LocalContext.current

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("병원 정보") },
				navigationIcon = {
					IconButton(onClick = { navController.popBackStack() }) {
						Icon(Icons.Default.ArrowBack, contentDescription = "뒤로가기")
					}
				},
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = AppColors.Background,
					titleContentColor = AppColors.Title,
					navigationIconContentColor = AppColors.Title
				)
			)
		}
	) { padding ->
		Column(
			modifier = Modifier
				.padding(padding)
				.padding(24.dp)
				.fillMaxSize(),
			verticalArrangement = Arrangement.spacedBy(16.dp),
			horizontalAlignment = Alignment.Start
		) {
			Text(
				text = hospital.name ?: "병원명 없음",
				style = MaterialTheme.typography.titleLarge,
				color = AppColors.Title
			)

			Text(
				text = "주소: ${hospital.address ?: "정보 없음"}",
				style = MaterialTheme.typography.bodyMedium
			)
			Text(
				text = "전화번호: ${hospital.tel ?: "정보 없음"}",
				style = MaterialTheme.typography.bodyMedium
			)
			Text(
				text = "병원 종류: ${hospital.type ?: "정보 없음"}",
				style = MaterialTheme.typography.bodyMedium
			)
			Text(
				text = "진료 과목: ${hospital.subject ?: "정보 없음"}",
				style = MaterialTheme.typography.bodyMedium
			)
			Text(
				text = "지역: ${hospital.sido ?: "정보 없음"}",
				style = MaterialTheme.typography.bodyMedium
			)
			Spacer(modifier = Modifier.height(24.dp))

			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(12.dp)
			) {
				Button(
					onClick = {
						hospital.tel?.let {
							val telUri = Uri.parse("tel:$it")
							val intent = Intent(Intent.ACTION_DIAL, telUri)
							context.startActivity(intent)
						}
					},
					modifier = Modifier.weight(1f),
					shape = RoundedCornerShape(8.dp)
				) {
					Text("전화 연결")
				}

				Button(
					onClick = {
						hospital.address?.let {
							val mapUri = Uri.parse("geo:0,0?q=${Uri.encode(it)}")
							val intent = Intent(Intent.ACTION_VIEW, mapUri)
							context.startActivity(intent)
						}
					},
					modifier = Modifier.weight(1f),
					shape = RoundedCornerShape(8.dp)
				) {
					Text("지도 보기")
				}

				// 홈페이지 연결
				if (!hospital.url.isNullOrBlank()) {
					Button(
						onClick = {
							val url =
								if (hospital.url.startsWith("http")) hospital.url else "http://${hospital.url}"
							val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
							context.startActivity(intent)
						},
						modifier = Modifier.weight(1f),
						shape = RoundedCornerShape(8.dp)
					) {
						Text("홈페이지")
					}
				}
			}
		}
	}
}

