package com.dongjin.hospitalapp.data
// 신장비뇨기질환

val RenalUroDiseases = listOf(
    Disease(
        id = "acute_tubulointerstitial_nephritis",
        name = "급성 간질성 신염",
        englishName = "Acute tubulo-interstitial nephritis",
        category = "신장질환",
        symptoms = listOf("관절통", "열", "고혈압", "단백뇨", "발진", "혈뇨", "요통"),
        relatedDiseases = listOf("고혈압", "신부전", "사구체신염", "급성 신부전", "만성 신부전"),
        department = "신장내과",
        synonyms = listOf("세뇨관 간질성 신염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31976"
    ),

    Disease(
        id = "acute_cystitis",
        name = "급성 방광염",
        englishName = "Acute cystitis",
        category = "비뇨기질환",
        symptoms = listOf("긴박뇨", "배뇨곤란", "빈뇨", "골반 통증", "배뇨 시 통증", "탁한 소변", "작열감"),
        relatedDiseases = listOf("양성 전립선 비대증", "급성 신우신염", "급성 질염", "만성 전립선염"),
        department = "비뇨의학과",
        synonyms = listOf("방광 감염", "방광 염증", "방광염", "오줌소태", "하부요로감염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31736"
    ),

    Disease(
        id = "acute_renal_failure",
        name = "급성 신부전",
        englishName = "Acute renal failure",
        category = "신장질환",
        symptoms = listOf("무뇨", "산혈증", "오심", "탈수", "소변량 감소", "구토", "경련", "전신 부종", "저혈량 쇼크", "쇼크"),
        relatedDiseases = listOf(
            "선천성 심장 질환", "전격성 간염", "신세포암종", "신우요관암", "고혈압", "처그 스트라우스 증후군",
            "대동맥 협착", "말기 신질환", "신부전", "사구체신염", "만성 신부전", "급성 간질성 신염",
            "신우요관암의 전이", "요로결석"
        ),
        department = "신장내과, 신ㆍ췌장이식외과",
        synonyms = listOf("급성신부전증", "급성신장기능상실증", "급성콩팥기능상실증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31971"
    ),


    Disease(
        id = "acute_pyelonephritis",
        name = "급성 신우신염",
        englishName = "Acute pyelonephritis",
        category = "비뇨기/신장질환",
        symptoms = listOf("오한", "열", "오심", "배뇨곤란", "근육통", "빈뇨", "배뇨 시 통증", "구토", "두통", "잔뇨감", "요통"),
        relatedDiseases = listOf(
            "신우요관암",
            "급성 방광염",
            "대장균 감염",
            "임균성 요도염",
            "비임균성 요도염",
            "신우요관 폐색",
            "방광요관 역류",
            "요관 협착"
        ),
        department = "감염내과, 신장내과, 소아신장과",
        synonyms = listOf("신우신염", "신우염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31737"
    ),

    Disease(
        id = "chronic_renal_failure",
        name = "만성 신부전",
        englishName = "Chronic renal failure",
        category = "비뇨기/신장질환",
        symptoms = listOf(
            "피부 긴장도 저하",
            "고혈압",
            "피로감",
            "식욕부진",
            "혼수",
            "복수",
            "만성 신부전",
            "피부소양감",
            "감각 이상",
            "빈혈",
            "면역기능 이상"
        ),
        relatedDiseases = listOf("고혈압", "당뇨병", "신부전", "사구체신염", "급성 신부전", "낭성 신장 질환", "알포트 증후군"),
        department = "신장내과, 소아청소년심장과, 신ㆍ췌장이식외과",
        synonyms = listOf("만성콩팥기능상실증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31973"
    ),

    Disease(
        id = "chronic_pyelonephritis",
        name = "만성 신우신염",
        englishName = "Chronic pyelonephritis",
        category = "비뇨기/신장질환",
        symptoms = listOf(),
        relatedDiseases = listOf(
            "요로 감염",
            "급성 방광염",
            "급성 신우신염",
            "신우요관 폐색",
            "요로결석",
            "방광요관 역류",
            "요관 협착",
            "간질성 방광염"
        ),
        department = "감염내과, 신장내과, 소아신장과",
        synonyms = listOf("만성 신우염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33876"
    ),

    Disease(
        id = "end_stage_renal_disease",
        name = "말기 신질환",
        englishName = "End stage renal disease",
        category = "비뇨기/신장질환",
        symptoms = listOf("멍", "무뇨", "오심", "피로감", "혈변", "소변량 감소", "혼수", "피부소양감", "전신 부종", "출혈 경향성"),
        relatedDiseases = listOf("신부전", "급성 신부전", "만성 신부전"),
        department = "신장내과, 소아신장과, 신ㆍ췌장이식외과",
        synonyms = listOf("말기 신장(콩팥)병"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31748"
    ),

    Disease(
        id = "bladder_cancer",
        name = "방광암",
        englishName = "Bladder cancer",
        category = "비뇨기/신장질환",
        symptoms = listOf("긴박뇨", "하지부종", "골반 통증", "배뇨 시 통증", "덩어리가 만져짐", "혈뇨", "옆구리 통증"),
        relatedDiseases = listOf("혈뇨", "배뇨통", "방광요관 역류"),
        department = "종양내과, 방사선종양학과, 비뇨의학과",
        synonyms = listOf("Malignant neoplasm of bladder", "방광 내 신생물", "방광선암"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30649"
    ),

    Disease(
        id = "glomerulonephritis",
        name = "사구체신염",
        englishName = "Glomerulonephritis",
        category = "비뇨기/신장질환",
        symptoms = listOf("단백뇨", "전신 부종", "혈뇨"),
        relatedDiseases = listOf("신증후군", "미세변화 신증후군"),
        department = "신장내과, 소아신장과",
        synonyms = listOf("급성사구체신염", "만성사구체신염", "신염", "신장염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31802"
    ),

    Disease(
        id = "renal_failure",
        name = "신부전",
        englishName = "Renal failure",
        category = "비뇨기/신장질환",
        symptoms = listOf("피부 긴장도 저하", "얼굴부종", "전신 부종", "신부전"),
        relatedDiseases = listOf(
            "울혈성 심부전",
            "고혈압",
            "당뇨병",
            "말기 신질환",
            "사구체신염",
            "급성 신부전",
            "만성 신부전",
            "렙토스피라증"
        ),
        department = "신장내과, 신ㆍ췌장이식외과",
        synonyms = listOf("kidney failure", "신부전증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31798"
    ),

    Disease(
        id = "renal_cell_carcinoma",
        name = "신세포암종",
        englishName = "Renal cell carcinoma",
        category = "비뇨기/신장질환",
        symptoms = listOf("혈뇨", "옆구리 통증"),
        relatedDiseases = listOf(
            "방광암",
            "신우요관암",
            "신장의 신생물",
            "낭성 신장 질환",
            "전이성 신장암",
            "신우요관암의 전이",
            "신우요관 폐색"
        ),
        department = "종양내과, 방사선종양학과, 비뇨의학과",
        synonyms = listOf("renal cancer", "신세포암", "신장암"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30628"
    ),

    Disease(
        id = "renal_stone",
        name = "신장 결석",
        englishName = "Renal stone",
        category = "비뇨기/신장질환",
        symptoms = listOf("오심", "구토", "혈뇨", "옆구리 통증"),
        relatedDiseases = listOf("요로 감염", "혈뇨", "요관 결석", "요로결석"),
        department = "비뇨의학과, 소아비뇨의학과",
        synonyms = listOf("신결석증", "신장결석증", "신결석"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30633"
    ),

    Disease(
        id = "benign_prostatic_hyperplasia",
        name = "양성 전립선 비대증",
        englishName = "Benign prostatic hyperplasia",
        category = "비뇨기/신장질환",
        symptoms = listOf("긴박뇨", "야간뇨", "지연뇨", "배뇨곤란", "요로감염", "빈뇨", "잔뇨감", "배뇨장애", "혈뇨"),
        relatedDiseases = listOf("전립선암", "만성 전립선염"),
        department = "가정의학과, 비뇨의학과",
        synonyms = listOf("전립샘의 증식", "전립선비대", "전립선비대증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30607"
    ),
    Disease(
        id = "prostate_cancer",
        name = "전립선암",
        englishName = "Prostate cancer",
        category = "비뇨기/신장질환",
        symptoms = listOf("소변을 볼 수 없음", "뼈 전이", "요관 폐쇄", "소변이 샘", "혈뇨"),
        relatedDiseases = listOf("양성 전립선 비대증", "만성 전립선염"),
        department = "건강의학과, 종양내과, 방사선종양학과, 비뇨의학과, 암병원",
        synonyms = listOf("Malignant neoplasm of prostate", "전립선 암종"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30618"
    ),
    Disease(
        id = "hematuria",
        name = "혈뇨",
        englishName = "Hematuria",
        category = "비뇨기/신장질환",
        symptoms = listOf("열", "하지부종", "진한 소변색", "빈뇨", "배뇨 시 통증", "혈뇨", "옆구리 통증"),
        relatedDiseases = listOf(
            "양성 전립선 비대증", "전립선암", "신장 결석", "방광암", "신우요관암", "전신 홍반성 낭창", "용혈빈혈", "급성 신우신염",
            "약물 유발성 자가면역성 용혈성 빈혈", "미세혈관병용혈빈혈", "신부전", "헤노호 쉰라인 자반증", "급성 신부전", "만성 신부전",
            "급성 간질성 신염", "신우요관암의 전이", "요관 결석", "알포트 증후군", "혈정액증", "면역글로불린 A 신병증",
            "신우요관 폐색", "요로결석", "만성 전립선염", "요관 협착", "방광소장 누공", "면역혈소판감소증", "자가면역 질환"
        ),
        department = "신장내과, 비뇨의학과, 소아신장과",
        synonyms = listOf("소변에 피", "소변에서 피", "소변피", "요혈"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31801"
    )

)
