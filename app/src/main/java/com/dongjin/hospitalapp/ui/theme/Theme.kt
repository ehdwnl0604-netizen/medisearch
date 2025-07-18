package com.dongjin.hospitalapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
	background = Color(0xFFF8F9FA),
	surface = Color(0xFFFFFFFF),
	primary = Color(0xFF1976D2),
	onPrimary = Color(0xFFFFFFFF),
	onSurface = Color(0xFF212121),
	secondary = Color(0xFFE8F0FE)
)
private val DarkColorScheme = darkColorScheme(
	background = Color(0xFF121212),
	surface = Color(0xFF1E1E1E),
	primary = Color(0xFF90CAF9),
	onPrimary = Color(0xFF000000),
	onSurface = Color(0xFFFFFFFF),
	secondary = Color(0xFF2C3A4F)
)


@Composable
fun HospitalappTheme(content: @Composable () -> Unit) {
	val colorScheme = LightColorScheme //시스템 설정 무시하고 무조건 라이트

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		shapes = Shapes(),
		content = content
	)
}


object AppColors {
	val Background = Color(0xFFF8F9FA)        // 전체 배경
	val Card = Color.White                   // 카드/서피스 배경
	val Title = Color(0xFF212121)            // 제목 텍스트
	val SubText = Color(0xFF666666)          // 설명 텍스트
	val ChipBackground = Color(0xFFE8F0FE)   // 칩 배경
	val ChipText = Color(0xFF1967D2)         // 칩 텍스트
}

