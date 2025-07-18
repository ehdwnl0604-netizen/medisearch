package com.dongjin.hospitalapp.data
// 순환기질환

val CardiovascularDiseases = listOf(
    Disease(
        id = "pure_hypercholesterolemia",
        name = "고콜레스테롤혈증",
        englishName = "Pure hypercholesterolemia",
        category = "순환기질환",
        symptoms = listOf(),
        relatedDiseases = listOf("뇌졸중", "급성 심근경색증", "협심증"),
        department = "가정의학과, 내분비내과, 심장내과, 노년내과",
        synonyms = listOf("고콜레스테롤혈", "과콜레스테롤", "과콜레스테롤혈증", "콜레스테롤과다증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32081"
    ),
    Disease(
        id = "essential_hypertension",
        name = "고혈압",
        englishName = "Essential (primary) hypertension",
        category = "순환기질환",
        symptoms = listOf("피부 긴장도 저하", "가슴 두근거림", "두통", "어지러움"),
        relatedDiseases = listOf("양성 종격동 종양", "악성 종격동 종양", "자발성 두개강 내 출혈", "뇌졸중", "망막 박리", "부신 종양", "신부전", "혈뇨", "임신성 고혈압", "급성 신부전", "만성 신부전", "뇌경색", "전이성 신장암", "자간증", "자간전증", "폐성 고혈압", "면역글로불린 A 신병증", "신우요관 폐색", "갈색세포종", "뇌하수체 기능 항진"),
        department = "가정의학과, 심장내과",
        synonyms = listOf("High blood pressure", "Hypertension", "본태성 고혈압", "속발성 고혈압"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31322"
    ),
    Disease(
        id = "acute_coronary_syndrome",
        name = "급성 관동맥 증후군",
        englishName = "Acute Coronary Syndrome",
        category = "순환기질환",
        symptoms = listOf("오심", "호흡곤란", "어지러움", "흉통", "방사통"),
        relatedDiseases = listOf("고혈압", "당뇨병", "죽상경화증", "고콜레스테롤혈증", "급성 심근경색증", "불안정형 협심증", "협심증"),
        department = "심장내과, 심장혈관흉부외과",
        synonyms = listOf("ACS", "급성 협심증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33602"
    ),
    Disease(
        id = "acute_myocardial_infarction",
        name = "급성 심근경색증",
        englishName = "Acute myocardial infarction",
        category = "순환기질환",
        symptoms = listOf("오심", "창백", "호흡곤란", "구토", "불안", "발한", "흉통"),
        relatedDiseases = listOf("허혈성 심질환", "오래된 심근경색증", "협심증"),
        department = "심장내과, 심장병원",
        synonyms = listOf("급성 심근경색", "동맥증후군", "심근경색", "심근경색증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32111"
    ),
    Disease(
        id = "arterial_embolism_thrombosis",
        name = "동맥색전증 및 혈전증",
        englishName = "Arterial embolism and thrombosis",
        category = "순환기질환",
        symptoms = listOf("말초 통증", "괴사", "저림", "말초의 허혈"),
        relatedDiseases = listOf("심방 세동", "뇌졸중", "급성 심근경색증"),
        department = "심장내과, 혈관외과",
        synonyms = listOf("Thrombosis", "embolism", "뇌 동맥 혈전증", "뇌동맥 색전증", "동맥 혈전색전증", "동맥색전", "동맥색전증", "동맥혈전", "동맥혈전증", "색전증", "혈전색전증", "혈전증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31751"
    ),
    Disease(
        id = "raynaud_phenomenon",
        name = "레이노병",
        englishName = "Raynaud'S Phenomenon",
        category = "순환기질환",
        symptoms = listOf("말초 통증", "궤양", "청색증", "저림", "사지의 창백한 현상", "손의 통증"),
        relatedDiseases = listOf("전신 홍반성 낭창", "류마티스 관절염", "전신 경화증", "수족냉증"),
        department = "류마티스내과",
        synonyms = listOf("레이노 증후군", "레이노드증후군", "레이노씨병", "레이노이드 증상", "레이노이드 증후군", "레이노이드 질환"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32156"
    ),
    Disease(
        id = "lymphedema",
        name = "림프부종",
        englishName = "Lymphedema",
        category = "순환기질환",
        symptoms = listOf("사지 부종", "피부 긴장도 저하", "피부균열"),
        relatedDiseases = listOf("유방암", "전립선암", "자궁경부암", "자궁내막암", "난소암", "질암", "자궁 육종", "외음부암"),
        department = "산부인과, 성형외과, 혈관외과, 재활의학과",
        synonyms = listOf("림프수종", "임파종대"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32145"
    ),
    Disease(
        id = "cardiac_arrhythmias",
        name = "부정맥",
        englishName = "Cardiac arrhythmias",
        category = "순환기질환",
        symptoms = listOf("가슴 두근거림", "실신", "어지러움"),
        relatedDiseases = listOf(
            "심방 세동", "심장 종양", "방실 중격 결손", "전폐정맥연결 이상", "과호흡 증후군", "설인신경통",
            "급성 심근경색증", "오래된 심근경색증", "심실 세동", "심실 빈맥", "심장신경성 실신", "발작성 상심실성 빈맥",
            "WPW 증후군", "갑상선기능항진증", "고칼륨혈증", "고마그네슘혈증", "저칼륨혈증", "대사성 알칼리증",
            "호흡성 알칼리증", "익수", "악성 고열증"
        ),
        department = "심장내과, 심장혈관흉부외과",
        synonyms = listOf("심장 부정맥"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30298"
    ),
    Disease(
        id = "unstable_angina",
        name = "불안정형 협심증",
        englishName = "Unstable angina",
        category = "순환기질환",
        symptoms = listOf("호흡곤란", "흉통"),
        relatedDiseases = listOf("죽상경화증", "급성 심근경색증", "협심증"),
        department = "심장내과, 심장병원",
        synonyms = listOf("불안정협심증", "비안정성협심증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32135"
    ),
    Disease(
        id = "hypertrophic_cardiomyopathy",
        name = "비후성 심근병증",
        englishName = "Hypertrophic cardiomyopathy",
        category = "순환기질환",
        symptoms = listOf("운동 시 호흡곤란", "호흡곤란", "피로감"),
        relatedDiseases = listOf("박출률 감소 심부전", "중증 심부전", "박출률 보존 심부전"),
        department = "심장내과, 소아심장외과, 심장병원",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33940"
    ),
    Disease(
        id = "bradycardia",
        name = "서맥",
        englishName = "Bradycardia",
        category = "순환기질환",
        symptoms = listOf("어지러움", "자율신경장애"),
        relatedDiseases = listOf("고혈압", "심근염"),
        department = "심장내과, 심장병원",
        synonyms = listOf("느린 맥박", "느린맥"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32142"
    ),
    Disease(
        id = "myocarditis",
        name = "심근염",
        englishName = "Myocarditis",
        category = "순환기질환",
        symptoms = listOf("가슴 두근거림", "호흡곤란", "실신", "흉통"),
        relatedDiseases = listOf("부정맥"),
        department = "심장내과, 심장병원, 심장외과",
        synonyms = listOf("심근염증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31651"
    ),
    Disease(
        id = "pericarditis",
        name = "심낭염",
        englishName = "Pericarditis",
        category = "순환기질환",
        symptoms = listOf("열", "호흡곤란", "피로감", "두통", "흉통", "쇼크", "저혈압"),
        relatedDiseases = listOf("심장 종양", "전신 홍반성 낭창", "류마티스 관절염", "신부전", "심낭 압전", "오래된 심근경색증"),
        department = "심장내과, 심장병원",
        synonyms = listOf("심낭염증", "심막염", "심막염증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32168"
    ),
    Disease(
        id = "endocarditis",
        name = "심내막염",
        englishName = "Endocarditis",
        category = "순환기질환",
        symptoms = listOf("오한", "열", "호흡곤란", "식욕부진", "두통", "반점", "저혈압"),
        relatedDiseases = listOf("심장 판막 질환", "울혈성 심부전", "선천성 심장 질환", "류마티스 관절염", "복부 대동맥류", "흉부 대동맥류", "심낭 삼출"),
        department = "심장내과, 심장병원",
        synonyms = listOf(
            "infectiveendocarditis", "감염성심내막염", "급성감염성심내막염", "급성심내막염",
            "심내막염증", "심장내막염", "심장내막염증", "아급성감염성심내막염", "아급성심내막염"
        ),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32143"
    ),

    Disease(
        id = "atrial_fibrillation",
        name = "심방 세동",
        englishName = "Atrial fibrillation",
        category = "순환기질환",
        symptoms = listOf("빈맥", "가슴 답답", "가슴 두근거림", "호흡곤란", "피로감", "실신", "어지러움"),
        relatedDiseases = listOf("부정맥", "심장 판막 질환", "심근병증", "갑상선기능항진증"),
        department = "심장내과, 심장병원",
        synonyms = listOf("심방 잔떨림"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30452"
    ),
    Disease(
        id = "deep_vein_thrombosis",
        name = "심부정맥 색전증",
        englishName = "Deep vein thrombosis",
        category = "순환기질환",
        symptoms = listOf("환부 부종", "환부 통증", "청색증", "피부궤양", "말초의 허혈"),
        relatedDiseases = listOf("폐 혈전색전증", "하지 정맥류", "동맥색전증 및 혈전증"),
        department = "혈관외과",
        synonyms = listOf("Deep vein thrombosis", "심부정맥 혈전증", "이코노미 클래스 증후군"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31750"
    ),
    Disease(
        id = "ventricular_fibrillation",
        name = "심실 세동",
        englishName = "Ventricular fibrillation",
        category = "순환기질환",
        symptoms = listOf("빈맥", "가슴 두근거림", "호흡곤란", "실신"),
        relatedDiseases = listOf("부정맥", "울혈성 심부전", "갑상선중독증", "심낭염", "저체온증"),
        department = "심장내과, 심장병원",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32137"
    ),
    Disease(
        id = "dyslipidemia",
        name = "이상지질혈증",
        englishName = "Dyslipidemia",
        category = "순환기질환",
        symptoms = listOf("무증상"),
        relatedDiseases = listOf("흉통", "고혈압", "비만", "고콜레스테롤혈증", "급성 심근경색증", "오래된 심근경색증", "고지혈증", "스핑고 지질증"),
        department = "가정의학과, 내분비내과, 노년내과",
        synonyms = listOf("이상지질단백혈증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31326"
    ),
    Disease(
        id = "hypotension",
        name = "저혈압",
        englishName = "Hypotension",
        category = "순환기질환",
        symptoms = listOf("무증상", "두통", "어지러움", "자율신경장애"),
        relatedDiseases = listOf(
            "아나필락시스", "당뇨병", "뇌하수체 기능부전", "이차성 파킨슨증", "양수색전증",
            "위장관 출혈", "장폐색", "복막염", "급성 심근경색증", "심낭 압전", "심내막염", "심낭염",
            "신증후성 출혈열", "점액수종 혼수", "고마그네슘혈증", "저칼륨혈증", "패혈증", "화상", "열사병"
        ),
        department = "심장내과, 심장병원",
        synonyms = listOf("기립성 저혈압", "본태성 저혈압"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32144"
    ),
    Disease(
        id = "ischemic_heart_disease",
        name = "허혈성 심질환",
        englishName = "Ischemic heart disease",
        category = "순환기질환",
        symptoms = listOf("호흡곤란", "흉통", "방사통"),
        relatedDiseases = listOf("흉통", "전도 장애", "부정맥", "심근병증", "급성 심근경색증", "오래된 심근경색증", "불안정형 협심증", "협심증"),
        department = "심장내과, 심장병원",
        synonyms = listOf("허혈성심장병", "허혈성심장질환"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30275"
    )

)