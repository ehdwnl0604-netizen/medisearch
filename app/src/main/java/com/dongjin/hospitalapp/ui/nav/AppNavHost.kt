package com.dongjin.hospitalapp.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dongjin.hospitalapp.data.Hospital
import com.dongjin.hospitalapp.ui.screen.caregiver.CareServiceWebViewScreen
import com.dongjin.hospitalapp.ui.screen.caregiver.CaregiverListScreen
import com.dongjin.hospitalapp.ui.screen.caregiver.CaregiverServiceScreen
import com.dongjin.hospitalapp.ui.screen.disease.DiseaseCategoryScreen
import com.dongjin.hospitalapp.ui.screen.disease.DiseaseListScreen
import com.dongjin.hospitalapp.ui.screen.emergency.EmergencyHospitalListScreen
import com.dongjin.hospitalapp.ui.screen.emergency.EmergencyRegionSelectScreen
import com.dongjin.hospitalapp.ui.screen.login.PersonalLoginScreen
import com.dongjin.hospitalapp.ui.screen.main.MainScreen
import com.dongjin.hospitalapp.ui.screen.signup.SignUpScreen
import com.dongjin.hospitalapp.ui.screen.hospital.HospitalDetailScreen
import com.dongjin.hospitalapp.ui.screen.hospital.HospitalListScreen
import com.dongjin.hospitalapp.ui.screen.hospital.HospitalSearchFilterScreen
import com.dongjin.hospitalapp.ui.screen.login.LoginSelectionScreen
import com.dongjin.hospitalapp.ui.screen.product.ProductPurchaseScreen
import com.dongjin.hospitalapp.ui.screen.product.NaverShoppingWebViewScreen
import com.google.firebase.auth.FirebaseAuth
@Composable
fun AppNavHost(navController: NavHostController) {
	val isLoggedIn = FirebaseAuth.getInstance().currentUser != null

	// 로그인 여부에 따라 시작 화면 설정
	val startDestination = if (isLoggedIn) "main" else "loginSelection"

	NavHost(navController = navController, startDestination = startDestination) {

		composable("loginSelection") {
			LoginSelectionScreen(onPersonalLoginClick = { navController.navigate("personalLogin") })
		}

		composable("personalLogin") { PersonalLoginScreen(navController) }
		composable("main") { MainScreen(navController) }
		composable("signUp") { SignUpScreen(navController = navController) }

		// ✅ 병원 검색 → 리스트 → 상세 구조
		composable("hospitalSearch") {
			HospitalSearchFilterScreen(navController = navController)
		}

		composable(
			route = "hospitalList?name={name}&disease={disease}&type={type}&region={region}",
			arguments = listOf(
				navArgument("name") { defaultValue = "" },
				navArgument("disease") { defaultValue = "" },
				navArgument("type") { defaultValue = "" },
				navArgument("region") { defaultValue = "" }
			)
		) {
			HospitalListScreen(navController = navController)
		}

		composable("hospitalDetail") {
			val hospital = navController.previousBackStackEntry?.savedStateHandle?.get<Hospital>("hospital")
			hospital?.let {
				HospitalDetailScreen(navController = navController, hospital = it)
			}
		}

		// 질환정보
		composable("diseaseCategory") { DiseaseCategoryScreen(navController = navController) }
		composable("diseaseList/{category}") { backStackEntry ->
			val category = backStackEntry.arguments?.getString("category") ?: ""
			DiseaseListScreen(navController = navController, category = category)
		}

		// 간병서비스
		composable("caregiverService") { CaregiverServiceScreen(navController = navController) }
		composable("caregiverList/{region}") { backStackEntry ->
			val region = backStackEntry.arguments?.getString("region") ?: ""
			CaregiverListScreen(region = region, navController = navController)
		}

		composable("careServiceWebView") {
			CareServiceWebViewScreen(navController = navController)
		}

		// 응급실
		composable(
			route = "emergencyHospitals/{region}",
			arguments = listOf(navArgument("region") { type = NavType.StringType })
		) { backStackEntry ->
			val region = backStackEntry.arguments?.getString("region") ?: ""
			EmergencyHospitalListScreen(navController, region)
		}

		composable("emergencyRegionSelect") {
			EmergencyRegionSelectScreen(navController = navController)
		}

		// 물품구매
		composable("productPurchase") { ProductPurchaseScreen(navController = navController) }

		// 외부 쇼핑 웹뷰
		composable(
			"naverShoppingWebView?url={url}",
			arguments = listOf(navArgument("url") { defaultValue = "" })
		) { backStackEntry ->
			NaverShoppingWebViewScreen(navBackStackEntry = backStackEntry)
		}
	}
}
