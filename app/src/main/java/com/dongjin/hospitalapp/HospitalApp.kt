package com.dongjin.hospitalapp

import android.app.Application
import android.content.pm.PackageManager
import android.util.Log
import com.naver.maps.map.NaverMapSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HospitalApp : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // 네이버 지도 SDK 초기화
        try {
            Log.d("HospitalApp", "🚀 네이버 지도 SDK 초기화 시작...")
            Log.d("HospitalApp", "📱 애플리케이션 패키지: ${packageName}")
            
            // 1. 매니페스트에서 NCP Key ID 읽기 확인
            val appInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
            val ncpKeyId = appInfo.metaData?.getString("com.naver.maps.map.NCP_KEY_ID")
            Log.d("HospitalApp", "📄 매니페스트 NCP Key ID: $ncpKeyId")
            
            // 2. 매니페스트 방식 우선 사용 (가장 안정적)
            // 매니페스트에 NCP_KEY_ID가 설정되어 있으면 자동으로 인식됨
            Log.d("HospitalApp", "📄 매니페스트 방식으로 SDK 초기화")
            
            // NaverMapSdk 인스턴스만 생성 (매니페스트에서 자동 설정)
            NaverMapSdk.getInstance(this)
            Log.d("HospitalApp", "🔑 매니페스트에서 NCP Key ID 자동 로드")
            
            Log.d("HospitalApp", "🗺️ NaverMapSdk 인스턴스 생성 완료")
            
            Log.d("HospitalApp", "✅ 네이버 지도 SDK 초기화 완료")
        } catch (e: Exception) {
            Log.e("HospitalApp", "❌ 네이버 지도 SDK 초기화 실패: ${e.message}", e)
            e.printStackTrace()
        }
    }
}
