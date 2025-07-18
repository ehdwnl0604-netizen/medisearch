package com.dongjin.hospitalapp.data

import com.dongjin.hospitalapp.R

// 감염성질환
val infectiousDiseases = listOf(
    Disease(
        id = "sepsis",
        name = "패혈증",
        englishName = "Sepsis",
        category = "감염성질환",
        symptoms = listOf("빈맥", "빈호흡", "심부전", "오한", "열", "의식 저하", "소변량 감소", "저혈압"),
        relatedDiseases = listOf(
            "폐렴",
            "바이러스성 뇌수막염",
            "박테리아성 뇌수막염",
            "급성 신우신염",
            "파종혈관내응고",
            "급성 담낭염",
            "저혈압",
            "좌측혈성 대장균 감염증",
            "반코마이신 내성 장알균(VRE) 감염증",
            "반코마이신 내성 황색포도알균(VRSA) 감염증"
        ),
        department = "호흡기내과, 응급의학과, 중환자실, 소아중환자과",
        synonyms = listOf("패혈증후군"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32319"
    ),

    Disease(
        id = "septic_arthritis",
        name = "패혈성 관절염",
        englishName = "Septic arthritis",
        category = "감염성질환",
        symptoms = listOf("관절통", "열감", "오한", "열", "환부 부종", "관절 운동성 감소", "관절염"),
        relatedDiseases = listOf("전신 홍반성 낭창", "류마티스 관절염", "골관절염", "통풍", "관절염"),
        department = "감염내과, 정형외과, 소아정형외과",
        synonyms = listOf("세균성 관절염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31735"
    ),


    Disease(
        id = "pulmonary_tuberculosis",
        name = "폐결핵",
        englishName = "Pulmonary tuberculosis",
        category = "감염성질환",
        symptoms = listOf("열", "가래", "기침", "체중감소", "객혈"),
        relatedDiseases = listOf(
            "만성 기침",
            "결핵성 골수염",
            "위장관 결핵",
            "결핵성 복막염",
            "결핵성 임파선염",
            "속립성 결핵",
            "결핵성 수막염",
            "결핵"
        ),
        department = "호흡기내과",
        synonyms = listOf("TB"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31847"
    ),
    Disease(
        id = "thromboangiitis_obliterans",
        name = "폐색성 혈전 혈관염",
        englishName = "Thromboangiitis obliterans",
        category = "감염성질환",
        symptoms = listOf("말초 통증", "저림", "말초의 허혈"),
        relatedDiseases = listOf("혈관염"),
        department = "혈관외과",
        synonyms = listOf(
            "Buerger Disease",
            "Buergers Disease",
            "버거씨병",
            "뷰르거병",
            "폐색혈전혈관염",
            "폐쇄혈전혈관염"
        ),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32133"
    ),
    Disease(
        id = "ehec_infection",
        name = "장출혈성 대장균 감염증",
        englishName = "Enterohemorrhagic Escherichia coli",
        category = "감염성질환",
        symptoms = listOf("요독증", "복부 통증", "설사", "혈소판감소", "혈변", "복부경련", "빈혈"),
        relatedDiseases = listOf("대장균 감염", "용혈성 요독 증후군"),
        department = "감염내과, 소화기내과",
        synonyms = listOf("대장균 O157 감염증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32127"
    ),
    Disease(
        id = "sars",
        name = "중증 급성 호흡기 증후군",
        englishName = "Severe Acute Respiratory Syndrome",
        category = "감염성질환",
        symptoms = listOf("오한", "열", "기침", "호흡곤란", "근육통", "권태감", "두통"),
        relatedDiseases = listOf("파라인플루엔자 감염증", "인플루엔자", "신종 플루", "가습기 살균제 연관 폐질환"),
        department = "호흡기내과",
        synonyms = listOf("사스", "SARS"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32128"
    ),
    Disease(
        id = "community_acquired_pneumonia",
        name = "지역사회성 폐렴",
        englishName = "Community acquired pneumonia",
        category = "감염성질환",
        symptoms = listOf("가래", "기침", "호흡곤란", "감기 증상", "흉통"),
        relatedDiseases = listOf(
            "공기가슴증(기흉)",
            "폐렴",
            "병원 감염성 폐렴",
            "상기도 감염",
            "폐 농양",
            "흡인성 폐렴",
            "폐렴간균에 의한 폐렴"
        ),
        department = "호흡기내과",
        synonyms = listOf("비정형성 폐렴", "지역사회 획득 폐렴"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31742"
    ),
    Disease(
        id = "covid19",
        name = "코로나-19",
        englishName = "COVID-19",
        category = "감염성질환",
        symptoms = listOf("열", "가래", "기침", "호흡곤란", "피로감", "근육통", "목의 통증", "두통"),
        relatedDiseases = listOf("폐렴", "상기도 감염", "인플루엔자", "중증 급성 호흡기 증후군", "중동 호흡기 증후군(MERS)"),
        department = "감염내과, 호흡기내과",
        synonyms = listOf(
            "신종 코로나바이러스 폐렴",
            "우한 폐렴",
            "2019-nCoV",
            "2019-Novel Coronavirus",
            "신종 코로나 바이러스 감염증"
        ),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33922"
    ),
    Disease(
        id = "hfrs",
        name = "신증후성 출혈열",
        englishName = "Hemorrhagic fever with renal syndrome",
        category = "감염성질환",
        symptoms = listOf("요독증", "열", "복부 통증", "단백뇨", "식욕부진", "두통", "다뇨", "저혈압"),
        relatedDiseases = listOf("신부전"),
        department = "감염내과, 신장내과",
        synonyms = listOf("신증후군 출혈열", "신증후출혈열", "유행성 출혈열"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32190"
    ),
    Disease(
        id = "endocarditis",
        name = "심내막염",
        englishName = "Endocarditis",
        category = "감염성질환",
        symptoms = listOf("오한", "열", "호흡곤란", "식욕부진", "두통", "반점", "저혈압"),
        relatedDiseases = listOf(
            "심장 판막 질환",
            "울혈성 심부전",
            "선천성 심장 질환",
            "류마티스 관절염",
            "복부 대동맥류",
            "흉부 대동맥류",
            "심낭 삼출"
        ),
        department = "심장내과, 심장병원",
        synonyms = listOf(
            "infectiveendocarditis",
            "감염성심내막염",
            "급성감염성심내막염",
            "급성심내막염",
            "심내막염증",
            "심장내막염",
            "심장내막염증",
            "아급성감염성심내막염",
            "아급성심내막염"
        ),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32143"
    ),

    Disease(
        id = "vre_infection",
        name = "반코마이신 내성 장알균(VRE) 감염증",
        englishName = "Vancomycin-Resistant Enterococci",
        category = "감염성질환",
        symptoms = listOf("오한", "열", "저혈압"),
        relatedDiseases = listOf(
            "요로 감염", "폐렴", "바이러스성 뇌수막염", "박테리아성 뇌수막염",
            "지역사회성 폐렴", "병원 감염성 폐렴", "심내막염", "패혈증", "흡인성 폐렴", "폐렴간균에 의한 폐렴"
        ),
        department = "감염내과",
        synonyms = listOf("반코마이신 내성 장구균 감염증", "반코마이신 저항 장알균 감염증", "VRE 균혈증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33900"
    ),
    Disease(
        id = "vrsa_infection",
        name = "반코마이신 내성 황색포도알균(VRSA) 감염증",
        englishName = "Vancomycin-Resistant Staphylococcus aureus",
        category = "감염성질환",
        symptoms = listOf("오한", "열", "저혈압"),
        relatedDiseases = listOf("포도상구균 감염"),
        department = "감염내과",
        synonyms = listOf(
            "반코마이신 내성 황색포도상구균균(VRSA)감염증",
            "반코마이신 저항 황색포도알균(VRSA) 감염증"
        ),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33890"
    ),
    Disease(
        id = "tuberculosis",
        name = "결핵",
        englishName = "Tuberculosis",
        category = "감염성질환",
        symptoms = listOf("열", "가래", "기침", "체중감소", "객혈"),
        relatedDiseases = listOf("결핵성 골수염", "위장관 결핵", "결핵성 복막염", "결핵성 임파선염", "속립성 결핵", "폐결핵", "결핵성 수막염"),
        department = "감염내과, 호흡기내과",
        synonyms = listOf(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32191"
    ),
    Disease(
        id = "tuberculous_osteomyelitis",
        name = "결핵성 골수염",
        englishName = "Tuberculous osteomyelitis",
        category = "감염성질환",
        symptoms = listOf("관절통", "열", "체중감소", "식욕부진", "뼈의 변형", "근육경련"),
        relatedDiseases = listOf(
            "척추 골수염", "위장관 결핵", "결핵성 복막염", "결핵성 임파선염",
            "속립성 결핵", "폐결핵", "결핵성 수막염", "골수염", "결핵"
        ),
        department = "감염내과",
        synonyms = listOf(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31719"
    ),
    Disease(
        id = "tuberculous_peritonitis",
        name = "결핵성 복막염",
        englishName = "Tuberculous peritonitis",
        category = "감염성질환",
        symptoms = listOf("빈맥", "빈호흡", "열", "복부 통증", "오심", "체중감소", "권태감", "식욕부진", "압통", "복수", "복부팽만감", "발한"),
        relatedDiseases = listOf(
            "결핵성 골수염", "위장관 결핵", "결핵성 임파선염", "속립성 결핵",
            "폐결핵", "결핵성 수막염", "복막염", "결핵"
        ),
        department = "감염내과",
        synonyms = listOf(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31727"
    ),
    Disease(
        id = "tuberculous_meningitis",
        name = "결핵성 수막염",
        englishName = "Tuberculous meningitis",
        category = "감염성질환",
        symptoms = listOf("눈운동신경마비", "열", "혼수", "졸림", "시야장애", "두통"),
        relatedDiseases = listOf("후천성 면역결핍증"),
        department = "감염내과, 신경과",
        synonyms = listOf("결핵성 뇌수막염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31672"
    ),
    Disease(
        id = "tuberculous_lymphadenitis",
        name = "결핵성 임파선염",
        englishName = "Tuberculous lymphadenitis",
        category = "감염성질환",
        symptoms = listOf("고름", "열", "체중감소", "피로감", "목 주변 부종", "식욕부진", "목의 통증", "피부궤양", "발한"),
        relatedDiseases = listOf(
            "결핵성 골수염", "위장관 결핵", "결핵성 복막염", "속립성 결핵",
            "폐결핵", "결핵성 수막염", "결핵"
        ),
        department = "감염내과",
        synonyms = listOf("결핵성 임파선"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31741"
    )
)