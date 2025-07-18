package com.dongjin.hospitalapp.data
// 호흡기질환
val RespiratoryDiseases = listOf(
    Disease(
        id = "hemoptysis",
        name = "객혈",
        englishName = "Hemoptysis",
        category = "호흡기질환",
        symptoms = listOf("가래", "거품이 섞인 가래", "객혈"),
        relatedDiseases = listOf("폐 혈전색전증", "식도암", "폐암", "비소세포성 폐암", "소세포성 폐암", "폐렴", "속립성 결핵", "기관지확장증", "폐결핵", "폐 전이", "승모판 협착", "아스페르길루스증", "만성 기관지염", "폐부종", "결핵"),
        department = "호흡기내과",
        synonyms = listOf("각혈", "혈담"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31850"
    ),
    Disease(
        id = "tuberculosis",
        name = "결핵",
        englishName = "Tuberculosis",
        category = "호흡기질환",
        symptoms = listOf("열", "가래", "기침", "체중감소", "객혈"),
        relatedDiseases = listOf("결핵성 골수염", "위장관 결핵", "결핵성 복막염", "결핵성 임파선염", "속립성 결핵", "폐결핵", "결핵성 수막염"),
        department = "감염내과, 호흡기내과",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32191"
    ),
    Disease(
        id = "pyothorax",
        name = "농흉",
        englishName = "Pyothorax, Empyema",
        category = "호흡기질환",
        symptoms = listOf("빈맥", "빈호흡", "화농성 객담", "흉부압박감", "마찰음", "가슴 답답", "기침", "호흡곤란", "흉통"),
        relatedDiseases = listOf("공기가슴증(기흉)", "폐렴", "폐결핵"),
        department = "호흡기내과",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32195"
    ),
    Disease(
        id = "pleurisy",
        name = "늑막염",
        englishName = "Pleurisy",
        category = "호흡기질환",
        symptoms = listOf("오한", "열", "가래", "가슴 답답", "기침", "호흡곤란", "권태감", "흉통"),
        relatedDiseases = listOf("폐 혈전색전증", "전신 홍반성 낭창", "류마티스 관절염", "폐렴", "폐결핵", "인플루엔자", "결핵", "자가면역 질환"),
        department = "호흡기내과",
        synonyms = listOf("흉막염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32183"
    ),
    Disease(
        id = "copd",
        name = "만성 폐쇄성 폐질환",
        englishName = "Chronic obstructive pulmonary disease",
        category = "호흡기질환",
        symptoms = listOf("흉곽 팽윤", "운동 시 호흡곤란", "천명음", "곤봉지", "가래", "기침", "호흡곤란", "피로감"),
        relatedDiseases = listOf("만성 기침", "만성 폐질환", "미만성 간질성 폐질환", "가습기 살균제 연관 폐질환"),
        department = "호흡기내과, 알레르기내과",
        synonyms = listOf("COPD"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31528"
    ),
    Disease(
        id = "chronic_lung_disease",
        name = "만성 폐질환",
        englishName = "Chronic lung disease",
        category = "호흡기질환",
        symptoms = listOf("가래", "기침", "객혈"),
        relatedDiseases = listOf("폐암", "비소세포성 폐암", "소세포성 폐암", "만성 폐쇄성 폐질환", "미만성 간질성 폐질환", "특발성 폐섬유화증", "규폐증"),
        department = "호흡기내과, 알레르기내과",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31813"
    ),
    Disease(
        id = "malignant_pleural_effusion",
        name = "악성 흉막 삼출",
        englishName = "Malignant pleural effusion",
        category = "호흡기질환",
        symptoms = listOf("기침", "호흡곤란", "불안", "흉통"),
        relatedDiseases = listOf("폐암", "비소세포성 폐암", "소세포성 폐암", "유방암", "림프종", "폐 전이"),
        department = "종양내과, 호흡기내과",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32014"
    ),

    Disease(
        id = "benign_mediastinal_tumor",
        name = "양성 종격동 종양",
        englishName = "Benign mediastinal tumor",
        category = "호흡기질환",
        symptoms = listOf("천명음", "무증상", "기침", "호흡곤란", "목소리 변화", "삼키기 곤란", "흉통"),
        relatedDiseases = listOf("악성 종격동 종양", "림프종"),
        department = "심장혈관흉부외과",
        synonyms = listOf("종격동 양성종양", "종격동 종양"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30456"
    ),
    Disease(
        id = "asthma",
        name = "천식",
        englishName = "Asthma",
        category = "호흡기질환",
        symptoms = listOf("천명음", "가래", "가슴 답답", "기침", "호흡곤란"),
        relatedDiseases = listOf("알레르기 비염", "아토피성 피부염", "만성 폐쇄성 폐질환", "만성 폐질환"),
        department = "호흡기내과, 알레르기내과",
        synonyms = listOf("소아천식", "운동유발성천식", "직업성천식"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31811"
    ),
    Disease(
        id = "mers",
        name = "중동 호흡기 증후군(MERS)",
        englishName = "Middle East Respiratory Syndrome",
        category = "호흡기질환",
        symptoms = listOf("열", "기침", "호흡곤란", "급성 신부전"),
        relatedDiseases = listOf("폐렴", "신부전", "급성 신부전", "폐렴간균에 의한 폐렴", "중증 급성 호흡기 증후군"),
        department = "호흡기내과",
        synonyms = listOf("신종 코로나 바이러스 감염증", "메르스바이러스 감염증", "메르스 코로나 바이러스 감염증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33862"
    ),
    Disease(
        id = "sars",
        name = "중증 급성 호흡기 증후군",
        englishName = "Severe Acute Respiratory Syndrome",
        category = "호흡기질환",
        symptoms = listOf("오한", "열", "기침", "호흡곤란", "근육통", "권태감", "두통"),
        relatedDiseases = listOf("파라인플루엔자 감염증", "인플루엔자", "신종 플루", "가습기 살균제 연관 폐질환"),
        department = "호흡기내과",
        synonyms = listOf("사스", "SARS"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32128"
    ),
    Disease(
        id = "covid19",
        name = "코로나-19",
        englishName = "COVID-19",
        category = "호흡기질환",
        symptoms = listOf("열", "가래", "기침", "호흡곤란", "피로감", "근육통", "목의 통증", "두통"),
        relatedDiseases = listOf("폐렴", "상기도 감염", "인플루엔자", "중증 급성 호흡기 증후군", "중동 호흡기 증후군(MERS)"),
        department = "감염내과, 호흡기내과",
        synonyms = listOf("신종 코로나바이러스 폐렴", "우한 폐렴", "2019-nCoV", "2019-Novel Coronavirus", "신종 코로나 바이러스 감염증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33922"
    ),
    Disease(
        id = "lung_abscess",
        name = "폐 농양",
        englishName = "Abscess of lung",
        category = "호흡기질환",
        symptoms = listOf("화농성 객담", "열", "기침", "호흡곤란", "체중감소"),
        relatedDiseases = listOf("폐렴"),
        department = "호흡기내과",
        synonyms = listOf("폐농양"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32493"
    ),
    Disease(
        id = "pulmonary_tuberculosis",
        name = "폐결핵",
        englishName = "Pulmonary tuberculosis",
        category = "호흡기질환",
        symptoms = listOf("열", "가래", "기침", "체중감소", "객혈"),
        relatedDiseases = listOf("만성 기침", "결핵성 골수염", "위장관 결핵", "결핵성 복막염", "결핵성 임파선염", "속립성 결핵", "결핵성 수막염", "결핵"),
        department = "호흡기내과",
        synonyms = listOf("TB"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31847"
    ),

    Disease(
        id = "emphysema",
        name = "폐기종",
        englishName = "Emphysema",
        category = "호흡기질환",
        symptoms = listOf("가래", "가슴 답답", "기침", "호흡곤란", "하지부종", "청색증"),
        relatedDiseases = listOf("만성 폐쇄성 폐질환", "폐렴", "급성 기관지염", "만성 폐질환", "미만성 간질성 폐질환", "만성 기관지염", "특발성 폐섬유화증"),
        department = "호흡기내과",
        synonyms = listOf("emphysema of the lung", "pulmonary emphysema"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31849"
    ),
    Disease(
        id = "pneumonia",
        name = "폐렴",
        englishName = "Pneumonia",
        category = "호흡기질환",
        symptoms = listOf("흉수", "오한", "열", "가래", "기침", "호흡곤란", "피로감", "두통", "흉통"),
        relatedDiseases = listOf("지역사회성 폐렴", "병원 감염성 폐렴", "흡인성 폐렴", "폐렴간균에 의한 폐렴"),
        department = "노년내과, 호흡기내과",
        synonyms = listOf("바이러스성 폐렴", "폐염증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31631"
    ),
    Disease(
        id = "lung_cancer",
        name = "폐암",
        englishName = "Lung cancer",
        category = "호흡기질환",
        symptoms = listOf("무증상", "기침", "호흡곤란", "체중감소", "목소리 변화", "흉통", "객혈"),
        relatedDiseases = listOf("비소세포성 폐암", "소세포성 폐암", "만성 기침", "폐 전이"),
        department = "종양내과, 호흡기내과, 방사선종양학과, 심장혈관흉부외과, 암병원",
        synonyms = listOf("기관지암", "폐 악성신생물", "폐악성종양", "폐암종"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30468"
    ),
    Disease(
        id = "aspiration_pneumonia",
        name = "흡인성 폐렴",
        englishName = "Aspiration pneumonia",
        category = "호흡기질환",
        symptoms = emptyList(), // 증상 정보 없음
        relatedDiseases = listOf("만성 기침", "만성 폐쇄성 폐질환", "폐렴", "폐렴간균에 의한 폐렴"),
        department = "노년내과, 호흡기내과",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32494"
    )



)