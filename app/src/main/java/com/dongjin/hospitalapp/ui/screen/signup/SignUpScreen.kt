package com.dongjin.hospitalapp.ui.screen.signup

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dongjin.hospitalapp.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
	var email by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	var confirmPassword by remember { mutableStateOf("") }

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("회원가입") },
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
				.padding(24.dp),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			OutlinedTextField(
				value = email,
				onValueChange = { email = it },
				label = { Text("이메일") },
				singleLine = true,
				modifier = Modifier.fillMaxWidth(),
				shape = RoundedCornerShape(12.dp)
			)

			Spacer(modifier = Modifier.height(16.dp))

			OutlinedTextField(
				value = password,
				onValueChange = { password = it },
				label = { Text("비밀번호") },
				visualTransformation = PasswordVisualTransformation(),
				singleLine = true,
				modifier = Modifier.fillMaxWidth(),
				shape = RoundedCornerShape(12.dp)
			)

			Spacer(modifier = Modifier.height(16.dp))

			OutlinedTextField(
				value = confirmPassword,
				onValueChange = { confirmPassword = it },
				label = { Text("비밀번호 확인") },
				visualTransformation = PasswordVisualTransformation(),
				singleLine = true,
				modifier = Modifier.fillMaxWidth(),
				shape = RoundedCornerShape(12.dp)
			)

			Spacer(modifier = Modifier.height(24.dp))

			Button(
				onClick = {
					// TODO: Firebase 회원가입 처리
					navController.popBackStack() // 일단 가입 후 이전으로
				},
				modifier = Modifier.fillMaxWidth()
			) {
				Text("가입하기")
			}
		}
	}
}
