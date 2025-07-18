package com.dongjin.hospitalapp.ui.screen.hospital

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dongjin.hospitalapp.data.Hospital
import com.dongjin.hospitalapp.viewmodel.HospitalViewModel
import com.dongjin.hospitalapp.ui.screen.hospital.HospitalListItem
import com.dongjin.hospitalapp.ui.theme.AppColors
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalListScreen(
    navController: NavHostController,
    viewModel: HospitalViewModel = hiltViewModel()
) {
    val hospitalList by viewModel.hospitalList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val navBackStackEntry = navController.currentBackStackEntryAsState().value

    val name = navBackStackEntry?.arguments?.getString("name")?.trim() ?: ""
    val diseaseCodes = navBackStackEntry?.arguments?.getString("disease")?.split(",")?.filter { it.isNotBlank() } ?: emptyList()
    val typeCodes = navBackStackEntry?.arguments?.getString("type")?.split(",")?.filter { it.isNotBlank() } ?: emptyList()
    val regionCodes = navBackStackEntry?.arguments?.getString("region")?.split(",")?.filter { it.isNotBlank() } ?: emptyList()

    LaunchedEffect(name, diseaseCodes, typeCodes, regionCodes) {
        viewModel.fetchHospitals(
            name = name,
            typeCodes = typeCodes,
            regionCodes = regionCodes
        )
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("병원 리스트") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = AppColors.Background,
                titleContentColor = AppColors.Title,
                navigationIconContentColor = AppColors.Title
            )
        )
    }) { padding ->
        Box(Modifier.padding(padding)) {
            LazyColumn {
                items(hospitalList) { hospital ->
                    HospitalListItem(hospital) {
                        navController.currentBackStackEntry?.savedStateHandle?.set("hospital", hospital)
                        navController.navigate("hospitalDetail")
                    }
                }
            }

            // ✅ 로딩 중일 때 다이얼로그 표시
            if (isLoading) {
                AlertDialog(
                    onDismissRequest = {},
                    title = { Text("검색 중입니다") },
                    text = {
                        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                            CircularProgressIndicator(modifier = Modifier.padding(end = 12.dp))
                            Text("병원 목록을 불러오는 중이에요...")
                        }
                    },
                    confirmButton = {}
                )
            }
        }
    }
}


@Composable
fun HospitalListItem(
    hospital: Hospital,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = hospital.name ?: "-", style = MaterialTheme.typography.titleMedium)
            Text(text = hospital.type ?: "-", style = MaterialTheme.typography.bodySmall)
            Text(text = hospital.address ?: "-", style = MaterialTheme.typography.bodySmall)
            Text(text = hospital.tel ?: "-", style = MaterialTheme.typography.bodySmall)
            if (!hospital.url.isNullOrBlank()) {
                Text(text = hospital.url ?: "", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

