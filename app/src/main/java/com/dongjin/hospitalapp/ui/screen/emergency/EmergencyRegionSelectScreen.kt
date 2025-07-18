package com.dongjin.hospitalapp.ui.screen.emergency

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
fun EmergencyRegionSelectScreen(
    navController: NavController
) {
    val regionList = listOf(
        "서울시", "인천광역시", "광주광역시",
        "울산광역시", "경기도",
         "전라남도", "경상북도", "경상남도"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("지역 선택") },
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
            items(regionList) { region ->
                Button(
                    onClick = {
                        navController.navigate("emergencyHospitals/${region}")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(region)
                }
            }
        }
    }
}
