package com.dongjin.hospitalapp.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dongjin.hospitalapp.ui.theme.AppColors
import kotlinx.coroutines.launch

@Composable
fun LoginSelectionScreen(
	onPersonalLoginClick: () -> Unit,
	// onCompanyLoginClick 파라미터 제거됨
) {
	// Snackbar 상태 생성
	val snackbarHostState = remember { SnackbarHostState() }
	val coroutineScope = rememberCoroutineScope()

	Scaffold(
		snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
		containerColor = AppColors.Background
	) { padding ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(padding)
				.padding(24.dp),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(
				text = "회원 유형 선택",
				style = MaterialTheme.typography.headlineSmall,
				color = Color(0xFF333333)
			)

			Spacer(modifier = Modifier.height(32.dp))

			Button(
				onClick = onPersonalLoginClick,
				modifier = Modifier.fillMaxWidth().height(56.dp),
				colors = ButtonDefaults.buttonColors(
					containerColor = Color(0xFF4DB6AC),
					contentColor = Color.White
				)
			) {
				Text("개인 회원 로그인")
			}

			Spacer(modifier = Modifier.height(16.dp))

			Button(
				onClick = {
					coroutineScope.launch {
						snackbarHostState.showSnackbar("현재 기업회원 로그인은 불가합니다")
					}
				},
				modifier = Modifier.fillMaxWidth().height(56.dp),
				colors = ButtonDefaults.buttonColors(
					containerColor = Color(0xFF1976D2),
					contentColor = Color.White
				)
			) {
				Text("기업 회원 로그인")
			}
		}
	}
}
