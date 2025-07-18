package com.dongjin.hospitalapp.ui.screen.emergency

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dongjin.hospitalapp.ui.theme.AppColors
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.opencsv.CSVReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.InputStreamReader

data class EmergencyHospital(
    val name: String,
    val address: String,
    val tel: String,
    val emergencyTel: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmergencyHospitalListScreen(
    navController: NavController,
    region: String
) {
    var hospitals by remember { mutableStateOf<List<EmergencyHospital>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    var showDialog by remember { mutableStateOf(false) }
    var selectedHospital by remember { mutableStateOf<EmergencyHospital?>(null) }

    val context = LocalContext.current

    LaunchedEffect(region) {
        try {
            val fileName = "$region 응급실 위치 정보.csv"
            val storageRef = Firebase.storage.reference.child(fileName)

            val stream = withContext(Dispatchers.IO) {
                storageRef.getStream().await().stream
            }

            val parsed = withContext(Dispatchers.IO) {
                val reader = CSVReader(InputStreamReader(stream, charset("EUC-KR")))
                val allLines = reader.readAll()
                if (allLines.isEmpty()) return@withContext emptyList()

                val header = allLines.first()
                val dataLines = allLines.drop(1)

                val nameIndex = header.indexOf("기관명")
                val addressIndex = header.indexOf("주소")
                val telIndex = header.indexOf("대표전화")
                val emergencyTelIndex = header.indexOf("응급실전화")

                if (listOf(nameIndex, addressIndex, telIndex, emergencyTelIndex).any { it == -1 }) {
                    Log.e("EmergencyHospitalList", "⚠️ 헤더 항목 누락. 필수 열이 없습니다.")
                    return@withContext emptyList()
                }

                dataLines.mapNotNull { tokens ->
                    try {
                        EmergencyHospital(
                            name = tokens.getOrNull(nameIndex)?.trim() ?: "",
                            address = tokens.getOrNull(addressIndex)?.trim() ?: "",
                            tel = tokens.getOrNull(telIndex)?.trim() ?: "",
                            emergencyTel = tokens.getOrNull(emergencyTelIndex)?.trim() ?: ""
                        )
                    } catch (e: Exception) {
                        Log.w("EmergencyHospitalList", "잘못된 라인 건너뜀: ${tokens.joinToString()}")
                        null
                    }
                }
            }

            hospitals = parsed
        } catch (e: Exception) {
            Log.e("EmergencyHospitalList", "CSV 불러오기 실패", e)
            errorMessage = "데이터를 불러오는 중 오류가 발생했습니다."
        } finally {
            isLoading = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("${region} 응급실 목록") },
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

            errorMessage != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(errorMessage ?: "", color = MaterialTheme.colorScheme.error)
                }
            }

            hospitals.isEmpty() -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    Text("등록된 응급실 정보가 없습니다.")
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
                    items(hospitals) { hosp ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedHospital = hosp
                                    showDialog = true
                                },
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(hosp.name, style = MaterialTheme.typography.titleMedium)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(hosp.address, style = MaterialTheme.typography.bodyMedium)
                                Text("대표전화: ${hosp.tel}", style = MaterialTheme.typography.bodySmall)
                                Text("응급실: ${hosp.emergencyTel}", style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }
        }

        if (showDialog && selectedHospital != null) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                icon = {
                    Icon(Icons.Default.Call, contentDescription = "전화 아이콘")
                },
                title = {
                    Text("응급실 전화 연결")
                },
                text = {
                    Text("“${selectedHospital!!.name}” 응급실로 전화를 거시겠습니까?\n\n${selectedHospital!!.emergencyTel}")
                },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog = false
                        val tel = selectedHospital!!.emergencyTel.replace("-", "").trim()
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$tel"))
                        context.startActivity(intent)
                    }) {
                        Text("예")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("아니오")
                    }
                }
            )
        }
    }
}
