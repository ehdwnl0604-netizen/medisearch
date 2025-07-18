package com.dongjin.hospitalapp.data
// 소화기질환
val GastrointestinalDiseases = listOf(

    Disease(
        id = "liver_cirrhosis",
        name = "간경화",
        englishName = "Liver cirrhosis",
        category = "소화기질환",
        symptoms = listOf("황달", "오심", "피부 긴장도 저하", "체중감소", "피로감", "식욕부진", "복부 불편감", "복수"),
        relatedDiseases = listOf("간세포암", "자가면역성 간염", "만성 B형 간염", "만성 C형 간염", "간염", "간성 뇌증", "원발성 담즙성 경화증"),
        department = "소화기내과, 간이식ㆍ간담도외과",
        synonyms = listOf("간경변", "간경변병", "간경변증", "간경화병", "간경화증", "간섬유병", "간섬유증", "간섬유화병", "간섬유화증", "간의경변"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30480"
    ),
    Disease(
        id = "ulcerative_colitis",
        name = "궤양성 대장염",
        englishName = "Ulcerative colitis",
        category = "소화기질환",
        symptoms = listOf("열", "복부 통증", "설사", "체중감소", "탈수", "혈변", "점액변", "변비", "빈혈"),
        relatedDiseases = listOf("강직성 척추염", "크론병", "대장 용종", "대장균 감염", "관절염", "자극성 장 증후군", "대장염", "위막성 대장염", "장출혈성 대장균 감염증"),
        department = "소화기내과",
        synonyms = listOf("궤양대장염", "염증성 장 질환", "큰 창자염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31691"
    ),


    Disease(
        id = "acute_cholecystitis",
        name = "급성 담낭염",
        englishName = "Acute cholecystitis",
        category = "소화기질환",
        symptoms = listOf("열", "복부 통증", "오심", "구토"),
        relatedDiseases = listOf("담낭암", "담석", "만성 담낭염"),
        department = "소화기내과, 간담도췌외과, 간이식ㆍ간담도외과",
        synonyms = listOf("급성 쓸개염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32091"
    ),
    Disease(
        id = "acute_gastroenteritis",
        name = "급성 위장염",
        englishName = "Acute gastroenteritis",
        category = "소화기질환",
        symptoms = listOf("열", "복부 통증", "설사", "탈수", "구토", "복부팽만감", "두통"),
        relatedDiseases = listOf("대장균 감염", "세균성 이질", "바이러스성 장염", "위막성 대장염", "식중독", "장출혈성 대장균 감염증", "아메바성 이질"),
        department = "가정의학과, 소화기내과, 노년내과, 소아외과, 소아내분비대사과, 소아신장과, 소아소화기영양과",
        synonyms = listOf("위장염", "급성 위염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31725"
    ),
    Disease(
        id = "acute_appendicitis",
        name = "급성 충수염",
        englishName = "Acute appendicitis",
        category = "소화기질환",
        symptoms = listOf("열", "복부 통증", "오심", "설사", "식욕부진", "구토"),
        relatedDiseases = listOf("복막염"),
        department = "소아외과, 대장항문외과",
        synonyms = listOf("급성 충수 돌기염", "급성맹장염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32035"
    ),
    Disease(
        id = "acute_pancreatitis",
        name = "급성 췌장염",
        englishName = "Acute pancreatitis",
        category = "소화기질환",
        symptoms = listOf("황달", "열", "복부 통증", "오심", "구토", "복부팽만감", "회색변"),
        relatedDiseases = listOf("췌장암", "만성 췌장염", "췌장염", "췌장 전이암"),
        department = "소화기내과, 간담도췌외과",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31427"
    ),
    Disease(
        id = "norovirus_gastroenteritis",
        name = "노로바이러스 장염",
        englishName = "Norovirus Gastroenteritis",
        category = "소화기질환",
        symptoms = listOf("오한", "열", "복부 통증", "오심", "설사", "근육통", "권태감", "복부 불편감", "구토", "두통"),
        relatedDiseases = listOf("급성 위장염", "바이러스성 장염", "식중독"),
        department = "소화기내과, 소아소화기영양과",
        synonyms = listOf("Norovirus", "노로바이러스", "노로바이러스식중독"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33451"
    ),
    Disease(
        id = "colon_cancer",
        name = "대장암",
        englishName = "Colon cancer",
        category = "소화기질환",
        symptoms = listOf("복부 통증", "잔변감", "혈변", "흑색변", "소화불량", "점액변", "배변습관의 변화"),
        relatedDiseases = listOf("대장 용종", "대장의 양성 종양", "변비"),
        department = "소화기내과, 종양내과, 방사선종양학과, 대장항문외과",
        synonyms = listOf("결장암", "대장악성종양", "대장암종", "대장의 악성신생물"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30461"
    ),
    Disease(
        id = "chronic_gastritis",
        name = "만성 위염",
        englishName = "Chronic gastritis",
        category = "소화기질환",
        symptoms = listOf("복부 통증", "오심", "가슴 답답", "설사", "권태감", "복부 압박 증상", "소화불량", "복부팽만감", "토혈"),
        relatedDiseases = listOf("위암", "위염", "위궤양", "진행성 위암", "조기 위암", "위장관 출혈", "헬리코박터균 감염"),
        department = "소화기내과",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31402"
    ),
    Disease(
        id = "chronic_pancreatitis",
        name = "만성 췌장염",
        englishName = "Chronic pancreatitis",
        category = "소화기질환",
        symptoms = listOf("복부 통증", "체중감소", "당뇨", "방사통", "지방변"),
        relatedDiseases = listOf("췌장암", "급성 췌장염", "췌장염", "췌장 전이암"),
        department = "소화기내과, 간담도췌외과",
        synonyms = listOf("재발성 췌장염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31515"
    ),
    Disease(
        id = "appendicitis",
        name = "맹장염",
        englishName = "Appendicitis",
        category = "소화기질환",
        symptoms = listOf("복부 통증", "설사", "압통", "옆구리 통증", "변비"),
        relatedDiseases = listOf("게실 질환", "메켈 게실", "복막염", "패혈증"),
        department = "대장항문외과",
        synonyms = listOf("꼬리염", "충수돌기염", "충수염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31588"
    )

)