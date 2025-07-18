package com.dongjin.hospitalapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.rememberNavController
import com.dongjin.hospitalapp.ui.nav.AppNavHost
import com.dongjin.hospitalapp.ui.theme.AppColors
import com.dongjin.hospitalapp.ui.theme.HospitalappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		// 상태바 배경색을 AppColors.Background로 설정
		window.statusBarColor = AppColors.Background.toArgb()

		// 상태바 아이콘을 '어두운 색(검정)'으로 설정
		WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true

		// Splash 이후 테마를 명시적으로 전환
		//setTheme(R.style.Theme_Hospitalapp_NoActionBar)
		setContent {
			HospitalappTheme {
				val navController = rememberNavController()
				AppNavHost(navController = navController)
			}


		}



	}
}