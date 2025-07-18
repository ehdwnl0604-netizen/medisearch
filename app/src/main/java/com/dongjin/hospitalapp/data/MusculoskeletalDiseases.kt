package com.dongjin.hospitalapp.data
// 근골격질환

val MusculoskeletalDiseases = listOf(
    Disease(
        id = "ankylosing_spondylitis",
        name = "강직성 척추염",
        englishName = "Ankylosing spondylitis",
        category = "근골격계 질환",
        symptoms = listOf("어깨의 통증", "관절통", "말초 통증", "골반 통증", "엉덩이 통증", "관절의 경직", "요통"),
        relatedDiseases = listOf("퇴행성 척추 장애", "포도막염", "요추관 협착증", "척추병증"),
        department = "재활의학과, 류마티스내과",
        synonyms = listOf("경직성 척추염", "강직척추염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30824"
    ),
    Disease(
        id = "osteoarthritis",
        name = "골관절염",
        englishName = "Osteoarthritis",
        category = "근골격계 질환",
        symptoms = listOf("관절통", "무릎 부위 부종", "관절 운동성 감소", "무릎 부위 통증", "관절의 경직"),
        relatedDiseases = listOf("류마티스 관절염", "패혈성 관절염", "소아 류마티스 관절염", "관절염"),
        department = "정형외과, 류마티스내과",
        synonyms = listOf("DJD", "degenerative arthritis", "degenerative joint disease", "퇴행성관절염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30828"
    ),
    Disease(
        id = "osteonecrosis",
        name = "골괴사",
        englishName = "Osteonecrosis",
        category = "근골격계 질환",
        symptoms = listOf("환부 부종", "환부 통증", "관절 운동성 감소", "병적골절"),
        relatedDiseases = listOf("대퇴골두 무혈관성 괴사"),
        department = "정형외과",
        synonyms = listOf("골괴사증", "뼈조직 괴사"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31720"
    ),
    Disease(
        id = "osteomyelitis",
        name = "골수염",
        englishName = "Osteomyelitis",
        category = "근골격계 질환",
        symptoms = listOf("열감", "열", "피부 긴장도 저하", "환부 부종", "권태감", "식욕부진", "두통"),
        relatedDiseases = listOf("척추 골수염", "결핵성 골수염"),
        department = "감염내과",
        synonyms = listOf("골수염증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31718"
    ),
    Disease(
        id = "labral_tear",
        name = "관절와순 파열",
        englishName = "Labral tear",
        category = "근골격계 질환",
        symptoms = listOf("어깨의 통증", "어깨 움직임의 제한", "어깨 잡음"),
        relatedDiseases = listOf("회전근개 증후군", "동결견", "재발성 견관절 전방 탈구"),
        department = "정형외과",
        synonyms = listOf("슬랩", "슬랩 병변", "SLAP", "상부관절와순 파열", "관절와순 손상"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33889"
    ),
    Disease(
        id = "avn_femoral_head",
        name = "대퇴골두 무혈관성 괴사",
        englishName = "AVN of hip (femoral head)",
        category = "근골격계 질환",
        symptoms = listOf("골반 통증", "양반다리로 앉기힘듬"),
        relatedDiseases = listOf("대퇴 골절"),
        department = "정형외과",
        synonyms = listOf("고관절무혈성괴사", "대퇴골두무혈성괴사", "대퇴골두무혈성괴사증", "대퇴골무혈성괴사"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31699"
    ),
    Disease(
        id = "rheumatoid_arthritis",
        name = "류마티스 관절염",
        englishName = "Rheumatoid arthritis",
        category = "근골격계 질환",
        symptoms = listOf("다발성 관절염", "관절통", "열감", "손마디가 뻣뻣해짐", "관절의 경직"),
        relatedDiseases = listOf("골관절염", "패혈성 관절염", "소아 류마티스 관절염", "관절염"),
        department = "류마티스내과",
        synonyms = listOf("류마토이드관절염", "류마토이드성관절염", "류머토이드관절염", "류머토이드성관절염", "류머티스 관절염", "류머티스관절", "류머티스성 관절염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30822"
    ),
    Disease(
        id = "meniscus_tear",
        name = "반월판 연골손상",
        englishName = "Tear of meniscus",
        category = "근골격계 질환",
        symptoms = listOf("관절통", "무릎 부위 부종", "관절잡음", "무릎 부위 통증", "관절 불안정증", "관절의 경직"),
        relatedDiseases = listOf("슬관절 장애", "슬개건염"),
        department = "정형외과",
        synonyms = listOf("무릎결림", "무릎관절염", "무릎손상", "반월상연골손상", "반월판연골통증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31568"
    ),
    Disease(
        id = "calcific_tendinitis",
        name = "석회성 건염",
        englishName = "Calcific Tendinitis",
        category = "근골격계 질환",
        symptoms = listOf("어깨의 통증", "팔의 통증", "압통", "어깨 움직임의 제한"),
        relatedDiseases = listOf("회전근개 증후군", "동결견"),
        department = "정형외과",
        synonyms = listOf("석회화 건염"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32561"
    ),
    Disease(
        id = "carpal_tunnel_syndrome",
        name = "손목 수근관 증후군",
        englishName = "Carpal tunnel syndrome",
        category = "근골격계 질환",
        symptoms = listOf("손가락 힘이 약해짐", "저림", "감각 이상", "손의 통증"),
        relatedDiseases = listOf("수족냉증"),
        department = "신경과, 정형외과",
        synonyms = listOf("손목굴 증후군", "손목터널증후군", "손저림증", "수근관증", "수근관증후군", "터널증후군", "팔목터널증후군"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31570"
    ),
    Disease(
        id = "cruciate_ligament_injuries",
        name = "십자 인대 손상",
        englishName = "Cruciate Ligament Injuries",
        category = "근골격계 질환",
        symptoms = listOf("무릎 부위 부종", "파열음", "관절잡음", "환부 부종", "무릎 부위 통증", "관절 불안정증"),
        relatedDiseases = listOf("슬관절 장애", "반월판 연골손상", "원판형 반월상연골", "반달연골 이상", "슬개건염"),
        department = "정형외과",
        synonyms = listOf("십자인대부상", "십자인대파열", "전방십자인대손상", "후방십자인대손상"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33574"
    ),
    Disease(
        id = "achilles_rupture",
        name = "아킬레스 건 파열",
        englishName = "Acute achilles tendon rupture",
        category = "근골격계 질환",
        symptoms = listOf("파열음", "발의 통증", "발끝으로 설 수 없음", "파열부위 오목해짐"),
        relatedDiseases = listOf("건 손상", "아킬레스 건염", "소건막류", "슬개건염", "건초염"),
        department = "정형외과",
        synonyms = listOf("아켈리스 건 파열"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31698"
    ),
    Disease(
        id = "traumatic_spine_injury",
        name = "외상에 의한 척추 손상",
        englishName = "Traumatic spine injury",
        category = "근골격계 질환",
        symptoms = listOf("서맥", "활력징후 이상", "저혈압"),
        relatedDiseases = listOf("외상에 의한 뇌 손상", "외상에 의한 척수 손상"),
        department = "신경외과, 응급의학과, 정형외과",
        synonyms = listOf("경추부염좌", "척추손상"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=30569"
    ),
    Disease(
        id = "lumbar_spondylolisthesis",
        name = "요추 전방전위증",
        englishName = "Lumbar spondylolisthesis",
        category = "근골격계 질환",
        symptoms = listOf("자세이상", "파행", "보행이상", "저림", "요통"),
        relatedDiseases = listOf("퇴행성 척추 장애", "외상에 의한 척추 손상", "강직성 척추염", "요추관 협착증", "요통", "척추병증", "노인성 척추후만증"),
        department = "신경외과, 정형외과",
        synonyms = listOf("요추전위증", "척추전방전위증", "척추전위증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31572"
    ),
    Disease(
        id = "lumbar_disc_herniation",
        name = "요추 추간판 탈출증",
        englishName = "Herniation of intervertebral disk",
        category = "근골격계 질환",
        symptoms = listOf("다리 통증", "하지 마비", "저림", "감각 이상", "요통"),
        relatedDiseases = listOf("퇴행성 척추 장애", "요추관 협착증", "요추 전방전위증", "척추병증", "노인성 척추후만증", "후종인대 골화증"),
        department = "마취통증의학과, 신경외과, 정형외과",
        synonyms = listOf("디스크", "척추관 협착증", "퇴행성 척추관 협착증", "허리 디스크"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32556"
    ),
    Disease(
        id = "lumbar_spinal_stenosis",
        name = "요추관 협착증",
        englishName = "Lumbar spinal stenosis",
        category = "근골격계 질환",
        symptoms = listOf("하지의 근력약화", "파행", "저림", "방사통", "요통"),
        relatedDiseases = listOf("요추 추간판 탈출증"),
        department = "마취통증의학과, 신경외과, 정형외과",
        synonyms = listOf("척추관 협착증", "퇴행성 척추관 협착증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31571"
    ),
    Disease(
        id = "sciatica",
        name = "좌골신경통",
        englishName = "Sciatica",
        category = "근골격계 질환",
        symptoms = listOf("다리 통증", "골반 통증", "저림", "요통"),
        relatedDiseases = listOf("요추관 협착증"),
        department = "마취통증의학과, 신경외과, 정형외과",
        synonyms = listOf("궁둥뼈신경통"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31919"
    ),
    Disease(
        id = "spondylolysis",
        name = "척추분리증",
        englishName = "Spondylolysis",
        category = "근골격계 질환",
        symptoms = emptyList(),
        relatedDiseases = listOf("퇴행성 척추 장애", "외상에 의한 척추 손상", "요추 전방전위증", "척추병증", "경추 추간판 탈출증", "요추 추간판 탈출증"),
        department = "정형외과",
        synonyms = emptyList(),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=33877"
    ),
    Disease(
        id = "opll",
        name = "후종인대 골화증",
        englishName = "Ossification of posterior longitudinal ligament",
        category = "근골격계 질환",
        symptoms = listOf("배변장애", "근력 약화", "목의 통증", "하지 마비", "보행이상", "배뇨장애", "저림", "감각 이상", "상지 마비"),
        relatedDiseases = listOf("퇴행성 척추 장애", "강직성 척추염", "요추관 협착증", "요추 전방전위증", "척추병증", "경추 추간판 탈출증", "요추 추간판 탈출증"),
        department = "신경외과, 정형외과",
        synonyms = listOf("후방인대 골화증", "후총인대 골화증"),
        webUrl = "https://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=32559"
    )

)
