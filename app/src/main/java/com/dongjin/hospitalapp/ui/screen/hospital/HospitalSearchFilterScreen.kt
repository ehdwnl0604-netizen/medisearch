package com.dongjin.hospitalapp.ui.screen.hospital

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dongjin.hospitalapp.ui.theme.AppColors
import com.dongjin.hospitalapp.viewmodel.HospitalViewModel
import java.net.URLEncoder
import com.dongjin.hospitalapp.util.HospitalCodeMapper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalSearchFilterScreen(
	navController: NavController,
	viewModel: HospitalViewModel = hiltViewModel()
) {
	val scrollState = rememberScrollState()

	var searchText by remember { mutableStateOf("") }

	//val diseaseTypes = listOf("투석", "감염", "장기요양")
	val hospitalTypes = listOf("상급종합병원", "요양병원", "종합병원")
	val regions = listOf("서울", "경기", "강원", "경남", "경북", "광주", "대구", "부산", "울산", "인천", "전남", "전북","제주","충남","충북",)

	var selectedDiseases by remember { mutableStateOf(listOf<String>()) }
	var selectedHospitalTypes by remember { mutableStateOf(listOf<String>()) }
	var selectedRegions by remember { mutableStateOf(listOf<String>()) }

	var showDiseaseFilters by remember { mutableStateOf(false) }
	var showHospitalTypeFilters by remember { mutableStateOf(false) }
	var showRegionFilters by remember { mutableStateOf(false) }

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("병원 검색") },
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
				.fillMaxSize()
				.padding(padding)
				.padding(16.dp)
				.verticalScroll(scrollState),
			verticalArrangement = Arrangement.spacedBy(24.dp)
		) {
			OutlinedTextField(
				value = searchText,
				onValueChange = { searchText = it },
				modifier = Modifier.fillMaxWidth(),
				placeholder = { Text("병원명으로 검색") },
				singleLine = true,
				shape = RoundedCornerShape(12.dp)
			)

//			ExpandableFilterSection(
//				title = "질환",
//				expanded = showDiseaseFilters,
//				onExpandToggle = { showDiseaseFilters = !showDiseaseFilters },
//				options = diseaseTypes,
//				selectedItems = selectedDiseases,
//				onItemSelected = { selectedDiseases = it }
//			)

			ExpandableFilterSection(
				title = "종별 검색",
				expanded = showHospitalTypeFilters,
				onExpandToggle = { showHospitalTypeFilters = !showHospitalTypeFilters },
				options = hospitalTypes,
				selectedItems = selectedHospitalTypes,
				onItemSelected = { selectedHospitalTypes = it }
			)

			ExpandableFilterSection(
				title = "지역 검색",
				expanded = showRegionFilters,
				onExpandToggle = { showRegionFilters = !showRegionFilters },
				options = regions,
				selectedItems = selectedRegions,
				onItemSelected = { selectedRegions = it }
			)

			Button(
				onClick = {
					val nameParam = URLEncoder.encode(searchText, "utf-8")
					val diseaseParam = HospitalCodeMapper.getDepartmentCodes(selectedDiseases).joinToString(",")
					val typeParam = HospitalCodeMapper.getHospitalTypeCodes(selectedHospitalTypes).joinToString(",")
					val regionParam = HospitalCodeMapper.getRegionCodes(selectedRegions).joinToString(",")

					Log.d("쿼리확인", "search=$nameParam / disease=$diseaseParam / type=$typeParam / region=$regionParam")
					navController.navigate(
						"hospitalList?name=$nameParam&disease=$diseaseParam&type=$typeParam&region=$regionParam"
					)
				},
				modifier = Modifier.fillMaxWidth()
			) {
				Text("검색하기")
			}
		}
	}
}

@Composable
fun ExpandableFilterSection(
	title: String,
	expanded: Boolean,
	onExpandToggle: () -> Unit,
	options: List<String>,
	selectedItems: List<String>,
	onItemSelected: (List<String>) -> Unit
) {
	Surface(
		modifier = Modifier.fillMaxWidth(),
		tonalElevation = 2.dp,
		shape = MaterialTheme.shapes.medium
	) {
		Column(modifier = Modifier.padding(12.dp)) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.clickable { onExpandToggle() },
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(title, modifier = Modifier.weight(1f), style = MaterialTheme.typography.titleMedium)
				Icon(
					imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
					contentDescription = null
				)
			}

			if (expanded) {
				Spacer(modifier = Modifier.height(8.dp))
				options.chunked(3).forEach { rowItems ->
					Row(
						modifier = Modifier.fillMaxWidth(),
						horizontalArrangement = Arrangement.spacedBy(8.dp)
					) {
						rowItems.forEach { item ->
							val selected = item in selectedItems
							FilterChip(
								selected = selected,
								label = { Text(item) },
								onClick = {
									val updated = if (selected) {
										selectedItems - item
									} else {
										selectedItems + item
									}
									onItemSelected(updated)
								}
							)
						}
					}
					Spacer(modifier = Modifier.height(4.dp))
				}
			}
		}
	}
}
