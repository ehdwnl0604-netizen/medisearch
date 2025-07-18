package com.dongjin.hospitalapp.ui.screen.main

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dongjin.hospitalapp.R
import com.dongjin.hospitalapp.ui.theme.AppColors
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
	val snackbarHostState = remember { SnackbarHostState() }
	val coroutineScope = rememberCoroutineScope()
	var showLogoutDialog by remember { mutableStateOf(false) }
	var showExitDialog by remember { mutableStateOf(false) }
	val context = LocalContext.current
	val activity = context as? Activity

	BackHandler {
		showExitDialog = true
	}

	Scaffold(
		snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
		topBar = {
			TopAppBar(
				title = {
					// 로고 이미지로 대체
					Image(
						painter = painterResource(id = R.drawable.logo2),
						contentDescription = "앱 로고",
						modifier = Modifier
							.height(148.dp) // <-- 요거 키워줘야 잘 보여
							.padding(start = 8.dp)
					)
				},
				actions = {
					IconButton(onClick = { showLogoutDialog = true }) {
						Icon(Icons.Default.Logout, contentDescription = "로그아웃")
					}
				},
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = AppColors.Background,
					titleContentColor = AppColors.Title,
					navigationIconContentColor = AppColors.Title
				)
			)

		},
	) { padding ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(padding)
				.padding(horizontal = 16.dp),
			verticalArrangement = Arrangement.Center, // ⬅️ 중앙 정렬
			horizontalAlignment = Alignment.CenterHorizontally // ⬅️ 가로 정렬도 중앙
		) {
			Column(
				verticalArrangement = Arrangement.spacedBy(16.dp),
				horizontalAlignment = Alignment.CenterHorizontally, // ⬅️ 메뉴도 가운데 정렬
				modifier = Modifier.fillMaxWidth()
			) {
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.spacedBy(16.dp)
				) {
					MenuItem(
						title = "질환정보",
						icon = R.drawable.ic_disease,
						modifier = Modifier.weight(1f)
					) {
						navController.navigate("diseaseCategory")
					}
					MenuItem(
						title = "병원검색",
						icon = R.drawable.ic_search_hospital, // 병원검색용 아이콘 리소스 필요
						modifier = Modifier.weight(1f)
					) {
						navController.navigate("hospitalSearch")
					}
				}

				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.spacedBy(16.dp)
				) {
					MenuItem(
						title = "응급실",
						icon = R.drawable.ic_policy,
						modifier = Modifier.weight(1f)
					) {
						navController.navigate("emergencyRegionSelect")
					}
					MenuItem(
						title = "물품구매",
						icon = R.drawable.ic_shopping,
						modifier = Modifier.weight(1f)
					) {
						navController.navigate("productPurchase")
					}
				}
			}
		}

		// 기존 AlertDialog는 그대로 유지
		if (showLogoutDialog) {
			AlertDialog(
				onDismissRequest = { showLogoutDialog = false },
				title = { Text("로그아웃") },
				text = { Text("로그아웃하시겠습니까?") },
				confirmButton = {
					TextButton(onClick = {
						showLogoutDialog = false
						val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
							.requestIdToken(context.getString(R.string.default_web_client_id))
							.requestEmail()
							.build()
						GoogleSignIn.getClient(context, gso).signOut()
						FirebaseAuth.getInstance().signOut()
						coroutineScope.launch {
							snackbarHostState.showSnackbar("로그아웃되었습니다.")
						}
						navController.navigate("loginSelection") {
							popUpTo("main") { inclusive = true }
						}
					}) {
						Text("확인")
					}
				},
				dismissButton = {
					TextButton(onClick = { showLogoutDialog = false }) {
						Text("취소")
					}
				}
			)
		}

		if (showExitDialog) {
			AlertDialog(
				onDismissRequest = { showExitDialog = false },
				title = { Text("앱 종료") },
				text = { Text("앱을 종료하시겠습니까?") },
				confirmButton = {
					TextButton(onClick = {
						activity?.finish()
					}) {
						Text("확인")
					}
				},
				dismissButton = {
					TextButton(onClick = { showExitDialog = false }) {
						Text("취소")
					}
				}
			)
		}
	}
}


@Composable
fun MenuItem(
	title: String,
	icon: Int,
	modifier: Modifier = Modifier,
	onClick: () -> Unit
) {
	Box(
		modifier = modifier
			.aspectRatio(1f)
			.background(Color(0xFFFDF6F0), RoundedCornerShape(16.dp))
			.clickable(onClick = onClick)
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(16.dp),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Icon(
				painter = painterResource(id = icon),
				contentDescription = title,
				tint = Color.Unspecified,
				modifier = Modifier.size(40.dp)
			)
			Spacer(modifier = Modifier.height(12.dp))
			Text(
				title,
				fontSize = 16.sp,
				color = Color.Black
			)
		}
	}
}
