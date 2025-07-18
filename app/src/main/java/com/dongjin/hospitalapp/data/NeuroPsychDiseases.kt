package com.dongjin.hospitalapp.data
import com.dongjin.hospitalapp.R
// 뇌신경정신질환

val neuroPsychDiseases = listOf(

    Disease(
        id = "경계성_인격장애",
        name = "경계성 인격장애",
        englishName = "Borderline personality disorder",
        category = "뇌신경정신질환",
        symptoms = listOf("자살의 위험", "조절할 수 없는 충동감", "대인관계 어려움", "약물남용", "의심", "망상", "우울"),
        relatedDiseases = listOf("양극성 장애", "우울증", "불안 장애", "행동 및 충동 장애", "병적 방화", "병적 도벽", "반사회성 인격장애", "망상 장애", "해리 장애", "편집성 인격장애", "분노 조절 장애"),
        department = "정신건강의학과",
        synonyms = listOf("경계선 인격장애", "경계역 인격장애"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32723"
    ),
    Disease(
        id = "경미한_인지장애",
        name = "경미한 인지장애",
        englishName = "Mild cognitive impairment",
        category = "뇌신경정신질환",
        symptoms = listOf("무관심", "우울", "언어장애", "기억장애", "판단력장애"),
        relatedDiseases = listOf("치매", "우울증", "혈관성 치매", "간성 뇌증"),
        department = "신경과",
        synonyms = listOf("MCI", "경도 인지장애", "경도인지기능장애", "경미 인지장애", "경미한인지기능장애"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32003"
    ),

    Disease(
        id = "공황_장애",
        name = "공황 장애",
        englishName = "Panic disorder",
        category = "뇌신경정신질환",
        symptoms = listOf("숨막히는 느낌", "오한", "온몸이 떨림", "오심", "손떨림", "가슴 답답", "가슴 두근거림", "얼굴이 화끈거림", "죽음에 대한 공포", "어지러움", "발한", "감각 이상", "흉통"),
        relatedDiseases = listOf("부정맥", "불안 장애", "심계항진", "갑상선기능항진증"),
        department = "정신건강의학과",
        synonyms = listOf("공황발작", "우발적 발작성불안", "임소공포"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31583"
    ),

    Disease(
        id = "금단_현상",
        name = "금단 현상",
        englishName = "Withdrawal Phenomenon",
        category = "뇌신경정신질환",
        symptoms = listOf("기운없음", "복시", "손떨림", "고혈압", "서맥", "우울", "환청", "환각", "두통", "불면증", "불안", "청색증", "저혈압"),
        relatedDiseases = listOf("알코올 의존성", "우울증", "불안 장애", "불면증", "행동 및 충동 장애", "인터넷 중독", "소화불량"),
        department = "정신건강의학과",
        synonyms = listOf("withdrawal symptoms", "금단증상"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32654"
    ),

    Disease(
        id = "기억상실증",
        name = "기억상실증",
        englishName = "amnesia",
        category = "뇌신경정신질환",
        symptoms = listOf("초조함", "감정 변화", "기억장애", "건망증", "불안", "흥분"),
        relatedDiseases = listOf("치매", "저혈당증", "알츠하이머병", "혈관성 치매", "경미한 인지장애", "해리 장애", "외상성 치매"),
        department = "신경과",
        synonyms = listOf("기억상실", "단기기억상실", "단기기억상실증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32749"
    ),

    Disease(
        id = "길랑_바레_증후군",
        name = "길랑-바레 증후군",
        englishName = "Guillain-Barre Syndrome",
        category = "뇌신경정신질환",
        symptoms = listOf("안면마비", "복시", "다리 통증", "가슴 두근거림", "호흡곤란", "삼키기 곤란", "배뇨장애", "감각 이상"),
        relatedDiseases = listOf("위염", "대상포진", "폐렴", "상기도 감염", "식중독"),
        department = "신경과",
        synonyms = listOf("polyneuritis", "polyradiculo-neuropathy", "갈리안바레 증후군", "급성 염증성 탈수초성 다발성 신경병증", "급성 특발성 다발성 근신경염", "길랭-바레증후군", "길렝-바레 증후군", "다발성 척수신경증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31904"
    ),

    Disease(
        id = "뇌경색",
        name = "뇌경색",
        englishName = "Cerebral infarction",
        category = "뇌신경정신질환",
        symptoms = listOf("의식 변화", "언어장애", "시야장애", "반신마비", "어지러움"),
        relatedDiseases = listOf("뇌졸중", "일과성 뇌허혈증"),
        department = "신경과, 신경외과, 재활의학과, 정신건강의학과, 소아신경과",
        synonyms = listOf("ischemic stroke", "경색성 뇌졸중", "뇌경색증", "뇌색전증", "뇌혈전증", "허혈성 뇌졸증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31996"
    ),

    Disease(
        id = "뇌농양",
        name = "뇌농양",
        englishName = "Brain abscess",
        category = "뇌신경정신질환",
        symptoms = listOf("열", "오심", "성격의변화", "구토", "두통", "경련"),
        relatedDiseases = listOf("뇌종양", "양성 뇌종양", "부비동염", "바이러스성 뇌수막염", "박테리아성 뇌수막염", "만성 중이염", "심내막염", "급성 중이염"),
        department = "감염내과, 신경외과",
        synonyms = listOf(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33710"
    ),

    Disease(
        id = "뇌동맥류",
        name = "뇌동맥류",
        englishName = "Cerebral aneurysm",
        category = "뇌신경정신질환",
        symptoms = listOf("오심", "뇌전증 발작", "구토", "의식 변화", "안구내 출혈", "두통"),
        relatedDiseases = listOf("자발성 두개강 내 출혈", "뇌동맥 폐쇄", "동맥류"),
        department = "영상의학과, 신경외과, 신경중재클리닉",
        synonyms = listOf("뇌동맥꽈리", "뇌지주막하 출혈", "두개강 내 동맥류"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30503"
    ),

    Disease(
        id = "뇌전증",
        name = "뇌전증",
        englishName = "Epilepsy",
        category = "뇌신경정신질환",
        symptoms = listOf("온몸이 떨림", "손떨림", "뇌전증 발작", "의식 저하", "눈꺼풀의 떨림", "경련"),
        relatedDiseases = listOf("뇌종양", "양성 뇌종양", "뇌 동정맥 기형", "뇌졸중", "저혈당증", "발작", "뇌경색", "외상성 경막하 출혈", "선천성 기형", "저칼슘혈증"),
        department = "신경과, 신경외과",
        synonyms = listOf("epilepticseizure", "epilepticsyndrome"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30519"
    ),

    Disease(
        id = "뇌졸중",
        name = "뇌졸중",
        englishName = "Cerebrovascular disease",
        category = "뇌신경정신질환",
        symptoms = listOf("운동장애", "복시", "시력 감소", "삼키기 곤란", "언어장애", "시야장애", "두통", "반신마비", "발음 이상", "어지러움"),
        relatedDiseases = listOf("고혈압", "뇌경색", "급성 심근경색증", "협심증", "뇌출혈"),
        department = "신경과, 신경외과, 소아신경과, 소아신경외과",
        synonyms = listOf("stroke", "급성기 허혈성 뇌중풍", "뇌졸증", "뇌중풍", "중풍", "허혈성 뇌중풍", "허혈성 뇌혈관 질환"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30518"
    ),

    Disease(
        id = "뇌출혈",
        name = "뇌출혈",
        englishName = "Cerebral hemorrhage",
        category = "뇌신경정신질환",
        symptoms = listOf("의식 저하", "구토", "의식 변화", "두통", "어지러움", "마비"),
        relatedDiseases = listOf("자발성 두개강 내 출혈", "뇌졸중", "지주막하 출혈"),
        department = "신경과, 신경외과, 재활의학과",
        synonyms = listOf("뇌 내 출혈", "뇌실질내출혈", "뇌일혈", "출혈성 뇌졸중", "출혈성 뇌중풍"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32611"
    ),

    Disease(
        id = "뇌종양",
        name = "뇌종양",
        englishName = "Brain tumor",
        category = "뇌신경정신질환",
        symptoms = listOf("운동장애", "오심", "뇌전증 발작", "구토", "두통", "감각 이상"),
        relatedDiseases = listOf("양성 뇌종양", "뇌하수체 양성 및 악성 신생물", "뇌하수체의 악성 신생물", "신경종"),
        department = "종양내과, 방사선종양학과, 소아청소년종양혈액과, 신경과, 신경외과, 소아내분비대사과, 소아신경과, 암병원",
        synonyms = listOf("뇌암", "뇌종양"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30490"
    ),

    Disease(
        id = "발작",
        name = "발작",
        englishName = "Seizure",
        category = "뇌신경정신질환",
        symptoms = listOf("실신", "격동적 움직임"),
        relatedDiseases = listOf("뇌전증", "수두증", "신생아 다혈구증", "생식선 및 생식 세포의 신생물", "팔로 사 징후", "바이러스성 뇌수막염", "박테리아성 뇌수막염", "신부전", "요붕증", "급성 신부전", "광견병", "스파르가눔증", "뇌성 마비", "자간증", "양수색전증", "신생아 경련", "라이 증후군", "핵황달", "고나트륨혈증", "대사성 알칼리증", "익수", "화상", "원발성 중추신경계 림프종"),
        department = "신경과",
        synonyms = listOf("대발작", "소발작"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31851"
    ),

    Disease(
        id = "비정형_파킨슨_증후군",
        name = "비정형 파킨슨 증후군",
        englishName = "Atypical Parkinsonism",
        category = "뇌신경정신질환",
        symptoms = listOf("자세 불안정", "자세이상", "보행이상", "근육강직", "떨림(진전)", "서동"),
        relatedDiseases = listOf("파킨슨병", "이차성 파킨슨증", "알츠하이머병"),
        department = "신경과",
        synonyms = listOf("진행핵상마비", "다계통 위축", "피질 기저핵 변성", "루이소체치매"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31985"
    ),

    Disease(
        id = "섬망",
        name = "섬망",
        englishName = "Delirium",
        category = "뇌신경정신질환",
        symptoms = listOf("초조함", "손떨림", "감정 변화", "혼돈", "언어장애", "환시", "환각", "불면증", "수면장애", "섬망", "산만함", "감각 이상"),
        relatedDiseases = listOf("뇌종양", "양성 뇌종양", "뇌졸중", "외상에 의한 뇌 손상", "치매", "알코올 의존성", "혈관성 치매", "간성 뇌증", "대사성 알칼리증"),
        department = "정신건강의학과",
        synonyms = listOf("급성 기질성 뇌 증후군"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31576"
    ),

    Disease(
        id = "치매",
        name = "치매",
        englishName = "Dementia",
        category = "뇌신경정신질환",
        symptoms = listOf("지남력 장애", "성격의변화", "감정 변화", "혼돈", "언어장애", "기억장애", "건망증"),
        relatedDiseases = listOf("비정형 파킨슨 증후군", "알츠하이머병", "혈관성 치매"),
        department = "노년내과, 신경과, 정신건강의학과",
        synonyms = listOf("노인성 치매"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31575"
    ),

    Disease(
        id = "파킨슨병",
        name = "파킨슨병",
        englishName = "Parkinson's disease",
        category = "뇌신경정신질환",
        symptoms = listOf("자세 불안정", "손떨림", "자세이상", "경직", "보행이상", "수면장애", "떨림(진전)", "서동"),
        relatedDiseases = listOf("비정형 파킨슨 증후군", "이차성 파킨슨증", "알츠하이머병"),
        department = "신경과",
        synonyms = listOf("파킨슨질환", "퍼킨슨병", "특발파킨슨병"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31983"
    )


)