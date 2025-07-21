plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.compose)
//	alias(libs.plugins.google.gms.google.services)
	id("com.google.gms.google-services")
	id("com.google.dagger.hilt.android")
	kotlin("kapt")
	id ("kotlin-parcelize")
}

android {
	namespace = "com.dongjin.hospitalapp"
	compileSdk = 35

	defaultConfig {
		applicationId = "com.dongjin.hospitalapp"
		minSdk = 24
		targetSdk = 35
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
	buildFeatures {
		compose = true
	}
}

dependencies {

	// 네이버지도 SDK (최신 버전)
	implementation("com.naver.maps:map-sdk:3.18.0") {
		exclude(group = "com.android.support")
	}
	implementation("com.google.android.gms:play-services-location:21.0.1") {
		exclude(group = "com.android.support")
	}
	
	// RecyclerView (네이버지도 layoutManager 오류 해결)
	implementation("androidx.recyclerview:recyclerview:1.3.2")

	implementation ("com.opencsv:opencsv:5.7.1")
	implementation ("com.google.firebase:firebase-storage-ktx:21.0.2")
	implementation ("com.squareup.retrofit2:converter-simplexml:2.9.0")
	implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


	// Retrofit
	implementation("com.squareup.retrofit2:retrofit:2.9.0")

// JSON 파싱 (Gson 사용 시)
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// OkHttp (선택이지만 추천 – 로그 확인용)
	implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

	
	implementation(libs.hilt.android)
	implementation(libs.firebase.firestore.ktx)
	kapt(libs.hilt.compiler)
	implementation(libs.coil.compose)

	// ViewModel / Compose 연동
	implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

	//splashscreen api
	implementation ("androidx.core:core-splashscreen:1.0.0-rc01")

	implementation(platform("com.google.firebase:firebase-bom:33.13.0"))
	implementation("com.google.firebase:firebase-analytics")
	implementation("com.google.android.gms:play-services-auth:21.3.0")
	implementation("com.google.firebase:firebase-auth-ktx")

	implementation(platform(libs.androidx.compose.bom.v20240500))

	// Material3
	implementation("androidx.compose.material3:material3")

	// Navigation
	implementation("androidx.navigation:navigation-compose")

	// Icons
	implementation("androidx.compose.material:material-icons-extended")

	// 기본 Compose UI
	implementation("androidx.compose.ui:ui")
	implementation("androidx.compose.ui:ui-tooling-preview")
	implementation(libs.androidx.credentials)
	implementation(libs.androidx.credentials.play.services.auth)
	implementation(libs.googleid)
	implementation(libs.firebase.auth)
	debugImplementation("androidx.compose.ui:ui-tooling")

	implementation("androidx.navigation:navigation-compose:2.7.7")
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
}