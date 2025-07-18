package com.dongjin.hospitalapp.data
// 종양혈액질환(암)

    val CancerHematologicDiseases = listOf(
        Disease(
            id = "hepatocellular_carcinoma",
            name = "간세포암",
            englishName = "Hepatocellular carcinoma",
            category = "종양질환",
            symptoms = listOf("황달", "무증상", "복부 통증", "체중감소", "덩어리가 만져짐"),
            relatedDiseases = listOf("간 전이", "만성 B형 간염", "간염", "간농양"),
            department = "소화기내과, 종양내과, 방사선종양학과, 간담도췌외과, 간이식ㆍ간담도외과",
            synonyms = listOf("liver cancer", "간세포암종", "간암", "간세포성 암종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30463"
        ),
        Disease(
            id = "benign_neoplasm_of_the_liver",
            name = "간의 양성 신생물",
            englishName = "Benign neoplasm of the liver",
            category = "종양질환",
            symptoms = listOf("무증상", "복부 통증", "오심", "복부 압박 증상", "구토", "복부팽만감"),
            relatedDiseases = listOf("간농양", "간 혈관종"),
            department = "소화기내과, 간담도췌외과, 간이식ㆍ간담도외과",
            synonyms = listOf("간의 양성 종양", "간종양"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31041"
        ),
        Disease(
            id = "thyroid_cancer",
            name = "갑상선암",
            englishName = "Thyroid cancer",
            category = "종양질환",
            symptoms = listOf("호흡곤란", "성대마비", "덩어리가 만져짐", "갑상선이 단단해짐", "삼키기 곤란", "결절"),
            relatedDiseases = listOf("갑상선기능저하증", "갑상선중독증", "갑상선 결절", "부갑상선기능저하증", "갑상선염", "갑상선 여포암", "갑상선 수질암", "갑상선 미분화암"),
            department = "내분비내과, 이비인후과",
            synonyms = listOf("갑상샘암", "갑상선암종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31594"
        ),
        Disease(
            id = "oral_cancer",
            name = "구강암",
            englishName = "Oral Cancer",
            category = "종양질환",
            symptoms = listOf("종양부위 부종", "치아 흔들림", "덩어리가 만져짐", "목의 통증", "목소리 변화", "삼키기 곤란", "턱의 통증", "감각 이상", "구강궤양"),
            relatedDiseases = listOf("타액선암"),
            department = "종양내과, 방사선종양학과, 이비인후과, 치과, 구강악안면외과",
            synonyms = listOf("oral cavity cancer", "구강저암", "설암", "치은암", "협부암"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32564"
        ),
        Disease(
            id = "acute_myeloid_leukemia",
            name = "급성골수성백혈병",
            englishName = "Acute myeloid leukemia",
            category = "혈액질환",
            symptoms = listOf("멍", "열", "창백", "피부 긴장도 저하", "호흡곤란", "체중감소", "비출혈", "출혈 경향성", "빈혈"),
            relatedDiseases = listOf("백혈병", "백혈구 이상", "호중구감소증", "급성림프모구백혈병", "만성림프구백혈병", "만성골수백혈병"),
            department = "혈액내과, 소아청소년종양혈액과",
            synonyms = listOf("AML", "급성백혈병"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31779"
        ),
        Disease(
            id = "ovarian_cancer",
            name = "난소암",
            englishName = "Ovarian cancer",
            category = "종양질환",
            symptoms = listOf("무증상", "복부 통증", "생식기 출혈", "골반 통증", "덩어리가 만져짐", "복수", "비정상적 질출혈", "요통"),
            relatedDiseases = listOf("자궁경부암", "자궁내막암", "자궁 상피 내 암종", "난소의 양성 종양", "난소 낭종", "다낭성 난소 증후군", "난소, 난관 이상"),
            department = "종양내과, 산부인과",
            synonyms = listOf("Malignant neoplasm of ovary", "난소 악성 종양"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31820"
        ),
        Disease(
            id = "brain_tumor",
            name = "뇌종양",
            englishName = "Brain tumor",
            category = "종양질환",
            symptoms = listOf("운동장애", "오심", "뇌전증 발작", "구토", "두통", "감각 이상"),
            relatedDiseases = listOf("양성 뇌종양", "뇌하수체 양성 및 악성 신생물", "뇌하수체의 악성 신생물", "신경종"),
            department = "종양내과, 방사선종양학과, 소아청소년종양혈액과, 신경과, 신경외과, 소아내분비대사과, 소아신경과, 암병원",
            synonyms = listOf("뇌암", "뇌종양"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30490"
        ),
        Disease(
            id = "multiple_myeloma",
            name = "다발골수종",
            englishName = "Multiple myeloma",
            category = "혈액질환",
            symptoms = listOf("창백", "피로감", "배뇨장애", "골다공증", "출혈 경향성", "잦은 감염", "뼈의 통증", "빈혈"),
            relatedDiseases = listOf("한랭글로불린혈증", "단세포군감마글로불린병증", "고립성 골수종", "아밀로이드증", "골수증식종양"),
            department = "종양내과, 혈액내과, 방사선종양학과",
            synonyms = listOf("malignant plasma cell neoplasm", "다발성 골수종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30474"
        ),
        Disease(
            id = "gb_cancer",
            name = "담낭암",
            englishName = "GB cancer",
            category = "종양질환",
            symptoms = listOf("황달", "복부 통증", "오심", "체중감소", "식욕부진", "구토"),
            relatedDiseases = listOf("담석", "총담관 담석", "궤양성 대장염", "석회화 담낭"),
            department = "소화기내과, 종양내과, 방사선종양학과, 간담도췌외과, 간이식ㆍ간담도외과",
            synonyms = listOf("담낭 선암종", "담낭악성종양", "쓸개악성종양", "쓸개암"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30462"
        ),
        Disease(
            id = "colon_cancer",
            name = "대장암",
            englishName = "Colon cancer",
            category = "종양질환",
            symptoms = listOf("복부 통증", "잔변감", "혈변", "흑색변", "소화불량", "점액변", "배변습관의 변화"),
            relatedDiseases = listOf("대장 용종", "대장의 양성 종양", "변비"),
            department = "소화기내과, 종양내과, 방사선종양학과, 대장항문외과",
            synonyms = listOf("결장암", "대장악성종양", "대장암종", "대장의 악성신생물"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30461"
        ),
        Disease(
            id = "lymphoma",
            name = "림프종",
            englishName = "Lymphoma",
            category = "종양질환",
            symptoms = listOf("암 부위별로 다름", "덩어리가 만져짐"),
            relatedDiseases = listOf("비호지킨 림프종", "호지킨 림프종", "원발성 중추신경계 림프종"),
            department = "종양내과, 혈액내과, 방사선종양학과, 소아청소년종양혈액과",
            synonyms = listOf("림프암", "악성림프종", "임파선암"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30904"
        ),
        Disease(
            id = "bladder_cancer",
            name = "방광암",
            englishName = "Bladder cancer",
            category = "종양질환",
            symptoms = listOf("긴박뇨", "하지부종", "골반 통증", "배뇨 시 통증", "덩어리가 만져짐", "혈뇨", "옆구리 통증"),
            relatedDiseases = listOf("혈뇨", "배뇨통", "방광요관 역류"),
            department = "종양내과, 방사선종양학과, 비뇨의학과",
            synonyms = listOf("Malignant neoplasm of bladder", "방광 내 신생물", "방광선암"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30649"
        ),
        Disease(
            id = "adrenal_cancer",
            name = "부신암",
            englishName = "Adrenal gland cancer",
            category = "종양질환",
            symptoms = listOf("복부비만", "생리불순", "여드름", "고혈압", "체중감소", "당뇨", "식욕부진", "성기능 장애", "복부 불편감", "복부팽만감", "달모양의 둥근 얼굴", "전신 부종", "빈혈", "근위축"),
            relatedDiseases = listOf("신세포암종", "부신 기능부전", "부신 종양"),
            department = "내분비내과, 종양내과",
            synonyms = listOf("부신악성종양"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31619"
        ),
        Disease(
            id = "spleen_cancer",
            name = "비장암",
            englishName = "Spleen cancer",
            category = "종양질환",
            symptoms = listOf("열", "비정상적 질출혈"),
            relatedDiseases = listOf("진행성 위암"),
            department = "종양내과, 간담도췌외과, 신ㆍ췌장이식외과",
            synonyms = emptyList(),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33469"
        ),
        Disease(
            id = "lung_cancer",
            name = "폐암",
            englishName = "Lung cancer",
            category = "종양질환",
            symptoms = listOf("무증상", "기침", "호흡곤란", "체중감소", "목소리 변화", "흉통", "객혈"),
            relatedDiseases = listOf("비소세포성 폐암", "소세포성 폐암", "만성 기침", "폐 전이"),
            department = "종양내과, 호흡기내과, 방사선종양학과, 심장혈관흉부외과, 암병원",
            synonyms = listOf("기관지암", "폐 악성신생물", "폐악성종양", "폐암종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30468"
        ),
        Disease(
            id = "esophageal_cancer",
            name = "식도암",
            englishName = "Esophageal cancer",
            category = "종양질환",
            symptoms = listOf("기침", "체중감소", "구토", "목소리 변화", "삼키기 곤란", "토혈"),
            relatedDiseases = listOf("바렛 식도"),
            department = "소화기내과, 종양내과, 영상의학과, 방사선종양학과, 신경외과, 이비인후과, 심장혈관흉부외과, 위장관외과",
            synonyms = listOf("식도암종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32044"
        ),

        Disease(
            id = "renal_cell_carcinoma",
            name = "신세포암종",
            englishName = "Renal cell carcinoma",
            category = "종양질환",
            symptoms = listOf("혈뇨", "옆구리 통증"),
            relatedDiseases = listOf("방광암", "신우요관암", "신장의 신생물", "낭성 신장 질환", "전이성 신장암", "신우요관암의 전이", "신우요관 폐색"),
            department = "종양내과, 방사선종양학과, 비뇨의학과",
            synonyms = listOf("renal cancer", "신세포암", "신장암"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30628"
        ),
        Disease(
            id = "stomach_cancer",
            name = "위암",
            englishName = "Stomach cancer",
            category = "종양질환",
            symptoms = listOf("복부 통증", "체중감소", "혈변", "흑색변", "식욕부진", "복부 불편감", "구토", "소화불량", "복부팽만감", "토혈", "빈혈"),
            relatedDiseases = listOf("위염", "만성 위염", "위궤양", "진행성 위암", "조기 위암", "헬리코박터균 감염", "덤핑 증후군"),
            department = "소화기내과, 종양내과, 방사선종양학과, 위장관외과, 암병원",
            synonyms = listOf("Gastric cancer", "Malignant neoplasm of stomach", "cancer of the stomach", "위 악성종양", "위선암", "위선암종", "위암종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30467"
        ),
        Disease(
            id = "breast_cancer",
            name = "유방암",
            englishName = "Breast cancer",
            category = "종양질환",
            symptoms = listOf("유방의 멍울", "환부의 분비물", "겨드랑이 멍울", "유방 통증"),
            relatedDiseases = listOf("유방통", "유방의 엽상 종양", "유방 종양", "유방의 섬유선종", "유방의 유선관 내 유두종", "유방의 미세석회화"),
            department = "종양내과, 방사선종양학과, 성형외과, 재활의학과, 유방외과",
            synonyms = listOf("Breast Cancer", "Breast tumor", "유방 악성신생물", "유방종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30472"
        ),
        Disease(
            id = "cervical_cancer",
            name = "자궁경부암",
            englishName = "Cervical cancer",
            category = "종양질환",
            symptoms = listOf("배변장애", "다리 통증", "생식기 출혈", "골반 통증", "비정상적 질 분비물", "배뇨장애", "악취", "비정상적 질출혈", "변비", "요통"),
            relatedDiseases = listOf("자궁내막암", "난소암", "자궁 상피 내 암종", "자궁의 평활근종", "난소의 양성 종양", "자궁내막 이상증식증", "자궁내막증", "자궁선근증", "자궁내막 용종"),
            department = "산부인과, 암병원",
            synonyms = listOf("Malignant neoplasm of cervix"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31818"
        ),
        Disease(
            id = "endometrial_cancer",
            name = "자궁내막암",
            englishName = "Endometrial cancer",
            category = "종양질환",
            symptoms = listOf("복부 통증", "무월경", "생식기 출혈", "골반 통증", "월경과다", "비정상적 질출혈"),
            relatedDiseases = listOf("자궁경부암", "난소암", "자궁 상피 내 암종", "자궁의 평활근종", "자궁내막 이상증식증", "자궁내막증", "자궁선근증", "자궁내막 용종"),
            department = "산부인과, 암병원",
            synonyms = listOf("Malignant neoplasm of endometrium", "자궁체부암"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31819"
        ),
        Disease(
            id = "prostate_cancer",
            name = "전립선암",
            englishName = "Prostate cancer",
            category = "종양질환",
            symptoms = listOf("소변을 볼 수 없음", "뼈 전이", "요관 폐쇄", "소변이 샘", "혈뇨"),
            relatedDiseases = listOf("양성 전립선 비대증", "만성 전립선염"),
            department = "건강의학과, 종양내과, 방사선종양학과, 비뇨의학과, 암병원",
            synonyms = listOf("Malignant neoplasm of prostate", "전립선 암종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30618"
        ),
        Disease(
            id = "metastatic_cancer",
            name = "전이 암",
            englishName = "Metastatic cancer",
            category = "종양질환",
            symptoms = listOf("종양부위 부종", "환부 통증", "덩어리가 만져짐"),
            relatedDiseases = listOf("간세포암", "췌장암", "간 전이", "폐 전이", "췌장 전이암", "전이성 신장암", "신우요관암의 전이", "연부조직 전이"),
            department = "종양내과, 방사선종양학과",
            synonyms = listOf("암 전이", "전이성 암"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32010"
        ),
        Disease(
            id = "rectal_cancer",
            name = "직장암",
            englishName = "Rectal cancer",
            category = "종양질환",
            symptoms = listOf("설사", "혈변", "변비", "배변습관의 변화"),
            relatedDiseases = listOf("대장암", "직장의 양성 종양", "대장의 양성 종양", "항문 및 직장의 궤양"),
            department = "종양내과, 방사선종양학과, 대장항문외과, 암병원",
            synonyms = listOf("직장악성종양", "직장암종"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30466"
        ),
        Disease(
            id = "pancreatic_cancer",
            name = "췌장암",
            englishName = "Pancreatic cancer",
            category = "종양질환",
            symptoms = listOf("황달", "열", "복부 통증", "오심", "체중감소", "구토", "회색변", "지방변"),
            relatedDiseases = listOf("만성 췌장염", "췌장염"),
            department = "소화기내과, 종양내과, 방사선종양학과, 간담도췌외과, 간이식ㆍ간담도외과, 암병원",
            synonyms = listOf("이자암", "췌장 신경내분비암", "췌장 신경내분비종", "췌장 신경내분비종양", "췌장선암", "췌장악성종양", "췌장암종", "췌장의악성신생물"),
            webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32077"
        )



        )
