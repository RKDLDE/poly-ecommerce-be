-- dummy date insert

-- user (관리자: admin, 일반 사용자: user01, user02, user03, user04, user05)
INSERT INTO tb_user (id_user, nm_user, nm_paswd, no_mobile, nm_email, st_status, cd_user_type) VALUES ('admin', '관리자', 'hash_pwd_admin', '010-1234-5678', 'admin@stationery.com', 'st01', '20');
INSERT INTO tb_user (id_user, nm_user, nm_paswd, no_mobile, nm_email, st_status, cd_user_type) VALUES ('user01', '김정상', 'hash_pwd_01', '010-1111-1111', 'user01@gmail.com', 'st01', '10');
INSERT INTO tb_user (id_user, nm_user, nm_paswd, no_mobile, nm_email, st_status, cd_user_type) VALUES ('user02', '이정상', 'hash_pwd_02', '010-2222-2222', 'user02@gmail.com', 'st01', '10');
INSERT INTO tb_user (id_user, nm_user, nm_paswd, no_mobile, nm_email, st_status, cd_user_type) VALUES ('user03', '박요청', 'hash_pwd_03', '010-3333-3333', 'user03@gmail.com', 'st03', '10');
INSERT INTO tb_user (id_user, nm_user, nm_paswd, no_mobile, nm_email, st_status, cd_user_type) VALUES ('user04', '최탈퇴', 'hash_pwd_04', '010-4444-4444', 'user04@gmail.com', 'st04', '10');
INSERT INTO tb_user (id_user, nm_user, nm_paswd, no_mobile, nm_email, st_status, cd_user_type) VALUES ('user05', '정해지', 'hash_pwd_05', '010-5555-5555', 'user05@gmail.com', 'st02', '10');

-- content는 따로 기입 X

-- category
-- 대분류 (Level 1)
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (100, NULL, '필기류', 1, 1);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (200, NULL, '노트', 1, 2);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (300, NULL, '다이어리', 1, 3);

-- 중분류 (Level 2)
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (101, 100, '펜', 2, 1);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (102, 100, '연필', 2, 2);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (103, 100, '샤프', 2, 3);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (104, 100, '형광펜', 2, 4);

INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (201, 200, '유선/무선 노트', 2, 1);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (202, 200, '가계부', 2, 2);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (203, 200, '일기장', 2, 3);

INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (301, 300, '다이어리', 2, 1);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (302, 300, '스케쥴러', 2, 2);
INSERT INTO tb_category (nb_category, nb_parent_category, nm_category, cn_level, cn_order) VALUES (303, 300, '캘린더', 2, 3);

/* =========================================================
   1. 상품 데이터 (tb_product) - 총 300개
   ========================================================= */

/* [101: 펜] 30개 */
INSERT INTO tb_product VALUES ('P_PEN_01', '제트스트림 스탠다드 0.5 검정', '부드러운 유성펜', NULL, '20260101', '20291231', 1800, 500);
INSERT INTO tb_product VALUES ('P_PEN_02', '제트스트림 스탠다드 0.5 빨강', '부드러운 유성펜', NULL, '20260101', '20291231', 1800, 300);
INSERT INTO tb_product VALUES ('P_PEN_03', '제트스트림 스탠다드 0.5 파랑', '부드러운 유성펜', NULL, '20260101', '20291231', 1800, 300);
INSERT INTO tb_product VALUES ('P_PEN_04', '시그노 DX 0.38 블랙', '세밀한 젤 잉크펜', NULL, '20260101', '20291231', 2000, 400);
INSERT INTO tb_product VALUES ('P_PEN_05', '시그노 DX 0.38 블루블랙', '인기 컬러 젤펜', NULL, '20260101', '20291231', 2000, 400);
INSERT INTO tb_product VALUES ('P_PEN_06', '모나미 153 클래식', '국민 볼펜', NULL, '20260101', '20291231', 300, 1000);
INSERT INTO tb_product VALUES ('P_PEN_07', '모나미 153 네오', '고급형 153', NULL, '20260101', '20291231', 10000, 100);
INSERT INTO tb_product VALUES ('P_PEN_08', '모나미 FX 153', '저점도 유성잉크', NULL, '20260101', '20291231', 1500, 500);
INSERT INTO tb_product VALUES ('P_PEN_09', '펜텔 에너겔 메탈팁 0.5', '진하고 빨리 마르는 잉크', NULL, '20260101', '20291231', 3000, 200);
INSERT INTO tb_product VALUES ('P_PEN_10', '파이롯트 프릭션볼 노크 0.5', '지워지는 볼펜', NULL, '20260101', '20291231', 3500, 150);
INSERT INTO tb_product VALUES ('P_PEN_11', '파이롯트 하이테크-C 0.3', '초미세 펜촉', NULL, '20260101', '20291231', 4000, 200);
INSERT INTO tb_product VALUES ('P_PEN_12', '사라사 클립 0.5 블랙', '부드러운 노크식 젤펜', NULL, '20260101', '20291231', 1800, 400);
INSERT INTO tb_product VALUES ('P_PEN_13', '사라사 클립 0.5 밀크블루', '파스텔톤 젤펜', NULL, '20260101', '20291231', 1800, 200);
INSERT INTO tb_product VALUES ('P_PEN_14', '유니볼 원 0.38', '선명한 발색 젤펜', NULL, '20260101', '20291231', 2200, 300);
INSERT INTO tb_product VALUES ('P_PEN_15', '스테들러 피그먼트 라이너', '도면 및 드로잉용', NULL, '20260101', '20291231', 3500, 100);
INSERT INTO tb_product VALUES ('P_PEN_16', '라미 사파리 만년필 EF', '입문용 만년필', NULL, '20260101', '20291231', 38000, 50);
INSERT INTO tb_product VALUES ('P_PEN_17', '모나미 153 골드', '한정판 골드 바디', NULL, '20200101', '20211231', 50000, 0);
INSERT INTO tb_product VALUES ('P_PEN_18', '쥬스업 0.4 블랙', '시너지 팁 적용 젤펜', NULL, '20260101', '20291231', 3000, 200);
INSERT INTO tb_product VALUES ('P_PEN_19', '동아 애니볼 501', '가성비 유성볼펜', NULL, '20260101', '20291231', 500, 800);
INSERT INTO tb_product VALUES ('P_PEN_20', '빅 라운드 스틱', '미국 국민 볼펜', NULL, '20260101', '20291231', 700, 600);
INSERT INTO tb_product VALUES ('P_PEN_21', '파이롯트 커스텀 74', '정통파 금촉 만년필', NULL, '20260101', '20291231', 150000, 20);
INSERT INTO tb_product VALUES ('P_PEN_22', '플래티넘 프레피 만년필', '가성비 만년필', NULL, '20260101', '20291231', 4500, 200);
INSERT INTO tb_product VALUES ('P_PEN_23', '세일러 프로페셔널 기어', '21K 금촉 만년필', NULL, '20260101', '20291231', 350000, 10);
INSERT INTO tb_product VALUES ('P_PEN_24', '카웨코 스포츠 만년필', '휴대용 미니 만년필', NULL, '20260101', '20291231', 32000, 40);
INSERT INTO tb_product VALUES ('P_PEN_25', '모나미 붓펜', '경조사 및 서예용', NULL, '20260101', '20291231', 2000, 300);
INSERT INTO tb_product VALUES ('P_PEN_26', '펠리칸 M200 블랙', '피스톤 필러 방식', NULL, '20260101', '20291231', 180000, 15);
INSERT INTO tb_product VALUES ('P_PEN_27', '파커 조터 볼펜', '아이코닉한 디자인', NULL, '20260101', '20291231', 15000, 100);
INSERT INTO tb_product VALUES ('P_PEN_28', '워터맨 엑스퍼트 3', '프랑스 명품 필기구', NULL, '20260101', '20291231', 220000, 5);
INSERT INTO tb_product VALUES ('P_PEN_29', '스테들러 트리플러스 화인라이너', '삼각형 바디 사인펜', NULL, '20260101', '20291231', 1200, 400);
INSERT INTO tb_product VALUES ('P_PEN_30', '펜텔 트라디오 만년필형 펜', '플라스틱 촉 펜', NULL, '20260101', '20291231', 6000, 80);

/* [102: 연필] 30개 */
INSERT INTO tb_product VALUES ('P_PENC_01', '스테들러 마스 루모그래프 HB', '전통적인 연필', NULL, '20260101', '20291231', 1300, 1000);
INSERT INTO tb_product VALUES ('P_PENC_02', '스테들러 마스 루모그래프 2B', '드로잉용 연필', NULL, '20260101', '20291231', 1300, 1000);
INSERT INTO tb_product VALUES ('P_PENC_03', '스테들러 마스 루모그래프 4B', '입시 미술용', NULL, '20260101', '20291231', 1300, 500);
INSERT INTO tb_product VALUES ('P_PENC_04', '파버카스텔 카스텔 9000 B', '독일 명품 연필', NULL, '20260101', '20291231', 1500, 800);
INSERT INTO tb_product VALUES ('P_PENC_05', '파버카스텔 카스텔 9000 2B', '부드러운 심', NULL, '20260101', '20291231', 1500, 800);
INSERT INTO tb_product VALUES ('P_PENC_06', '블랙윙 602', '전설적인 연필', NULL, '20260101', '20291231', 4500, 100);
INSERT INTO tb_product VALUES ('P_PENC_07', '블랙윙 매트 블랙', '가장 진한 심', NULL, '20260101', '20291231', 4500, 100);
INSERT INTO tb_product VALUES ('P_PENC_08', '블랙윙 내추럴', '나무 질감 강조', NULL, '20260101', '20291231', 4500, 100);
INSERT INTO tb_product VALUES ('P_PENC_09', '유니 하이유니 HB', '일본 최고급 연필', NULL, '20260101', '20291231', 2500, 200);
INSERT INTO tb_product VALUES ('P_PENC_10', '유니 하이유니 2B', '균일한 밀도', NULL, '20260101', '20291231', 2500, 200);
INSERT INTO tb_product VALUES ('P_PENC_11', '톰보 모노 100 HB', '부드러운 필기감', NULL, '20260101', '20291231', 2200, 300);
INSERT INTO tb_product VALUES ('P_PENC_12', '톰보 모노 100 4B', '진하고 부드러움', NULL, '20260101', '20291231', 2200, 200);
INSERT INTO tb_product VALUES ('P_PENC_13', '동아 파블 연필 HB', '학생용 국산 연필', NULL, '20260101', '20291231', 400, 2000);
INSERT INTO tb_product VALUES ('P_PENC_14', '동아 파블 연필 2B', '학습 및 시험용', NULL, '20260101', '20291231', 400, 1500);
INSERT INTO tb_product VALUES ('P_PENC_15', '문화 연필 더존 HB', '클래식한 국산 연필', NULL, '20260101', '20291231', 300, 2000);
INSERT INTO tb_product VALUES ('P_PENC_16', '문화 연필 더존 2B', '고시용 추천', NULL, '20260101', '20291231', 300, 1500);
INSERT INTO tb_product VALUES ('P_PENC_17', '스테들러 노리스 연필', '노란색 줄무늬 디자인', NULL, '20260101', '20291231', 800, 1000);
INSERT INTO tb_product VALUES ('P_PENC_18', '파버카스텔 골드파버', '가성비 드로잉 연필', NULL, '20260101', '20291231', 1000, 800);
INSERT INTO tb_product VALUES ('P_PENC_19', '코이노어 쥬피터 연필', '체코산 프리미엄', NULL, '20260101', '20291231', 1200, 300);
INSERT INTO tb_product VALUES ('P_PENC_20', '미츠비시 9800 HB', '실무용 표준 연필', NULL, '20260101', '20291231', 1000, 500);
INSERT INTO tb_product VALUES ('P_PENC_21', '더웬트 그래픽 연필 HB', '영국 드로잉 명가', NULL, '20260101', '20291231', 2000, 200);
INSERT INTO tb_product VALUES ('P_PENC_22', '카랑다쉬 에델바이스 연필', '스위스 장인 정신', NULL, '20260101', '20291231', 1800, 150);
INSERT INTO tb_product VALUES ('P_PENC_23', '스테들러 루모그래프 블랙 8B', '카본 함유 극진 연필', NULL, '20260101', '20291231', 2500, 100);
INSERT INTO tb_product VALUES ('P_PENC_24', '파버카스텔 점보 연필', '어린이용 굵은 연필', NULL, '20260101', '20291231', 2200, 300);
INSERT INTO tb_product VALUES ('P_PENC_25', '까렌다쉬 테크노그래프 HB', '최고급 흑연 사용', NULL, '20260101', '20291231', 3500, 100);
INSERT INTO tb_product VALUES ('P_PENC_26', '바이킹 델타 연필', '덴마크 감성 연필', NULL, '20260101', '20291231', 2000, 150);
INSERT INTO tb_product VALUES ('P_PENC_27', '키타보시 9900 HB', '전통 공법 제조', NULL, '20260101', '20291231', 1500, 200);
INSERT INTO tb_product VALUES ('P_PENC_28', '팔로미노 블랙윙 볼륨 시리즈', '한정판 컬렉션', NULL, '20260101', '20291231', 5000, 50);
INSERT INTO tb_product VALUES ('P_PENC_29', '스테들러 마스 카본 홀더심', '홀더 펜 전용 심', NULL, '20260101', '20291231', 12000, 80);
INSERT INTO tb_product VALUES ('P_PENC_30', '제네럴스 세미 헥스 연필', '미국산 클래식', NULL, '20260101', '20291231', 1800, 100);

/* [103: 샤프] 30개 */
INSERT INTO tb_product VALUES ('P_SHA_01', '펜텔 그래프 1000 0.5', '샤프의 표준', NULL, '20260101', '20291231', 12000, 300);
INSERT INTO tb_product VALUES ('P_SHA_02', '펜텔 스매쉬 0.5 블랙', '그립감이 좋은 샤프', NULL, '20260101', '20291231', 15000, 200);
INSERT INTO tb_product VALUES ('P_SHA_03', '유니 쿠루토가 어드밴스 0.5', '심이 돌아가는 샤프', NULL, '20260101', '20291231', 9000, 250);
INSERT INTO tb_product VALUES ('P_SHA_04', '로트링 600 블랙 0.5', '풀 메탈 바디 샤프', NULL, '20260101', '20291231', 35000, 50);
INSERT INTO tb_product VALUES ('P_SHA_05', '펜텔 그래프 기어 1000', '촉 보호 기능 탑재', NULL, '20260101', '20291231', 18000, 150);
INSERT INTO tb_product VALUES ('P_SHA_06', '스테들러 925 35 0.5', '알루미늄 바디 실버', NULL, '20260101', '20291231', 20000, 100);
INSERT INTO tb_product VALUES ('P_SHA_07', '제브라 델가드 LX 0.5', '심이 부러지지 않는 샤프', NULL, '20260101', '20291231', 12000, 120);
INSERT INTO tb_product VALUES ('P_SHA_08', '파이롯트 S20 0.5', '나무 바디의 따뜻함', NULL, '20260101', '20291231', 25000, 60);
INSERT INTO tb_product VALUES ('P_SHA_09', '펜텔 P205 블랙', '전설의 제도용 샤프', NULL, '20260101', '20291231', 6000, 500);
INSERT INTO tb_product VALUES ('P_SHA_10', '로트링 800 0.5', '최고급 트위스트 방식', NULL, '20260101', '20291231', 65000, 30);
INSERT INTO tb_product VALUES ('P_SHA_11', '유니 쿠루토가 다이브', '자동 심 배출 프리미엄', NULL, '20260101', '20291231', 85000, 10);
INSERT INTO tb_product VALUES ('P_SHA_12', '펜텔 오렌즈 네로 0.5', '자동 샤프의 정점', NULL, '20260101', '20291231', 35000, 80);
INSERT INTO tb_product VALUES ('P_SHA_13', '스테들러 925 15', '가성비 우수 모델', NULL, '20260101', '20291231', 7000, 300);
INSERT INTO tb_product VALUES ('P_SHA_14', '펜텔 케리 샤프', '만년필형 고급 샤프', NULL, '20260101', '20291231', 22000, 90);
INSERT INTO tb_product VALUES ('P_SHA_15', '유니 알파겔 스위치', '흔들 샤프 모드 탑재', NULL, '20260101', '20291231', 13000, 110);
INSERT INTO tb_product VALUES ('P_SHA_16', '제브라 에스피나 샤프', '말랑한 고무 그립', NULL, '20260101', '20291231', 4500, 400);
INSERT INTO tb_product VALUES ('P_SHA_17', '파이롯트 닥터그립 CL', '피로 저감 샤프', NULL, '20260101', '20291231', 9000, 200);
INSERT INTO tb_product VALUES ('P_SHA_18', '모나미 153 샤프 0.5', '클래식 볼펜 디자인', NULL, '20260101', '20291231', 1500, 600);
INSERT INTO tb_product VALUES ('P_SHA_19', '라미 사파리 샤프 0.5', '디자인 샤프의 정석', NULL, '20260101', '20291231', 25000, 70);
INSERT INTO tb_product VALUES ('P_SHA_20', '카웨코 스페셜 알루 0.5', '팔각형 알루미늄 바디', NULL, '20260101', '20291231', 55000, 40);
INSERT INTO tb_product VALUES ('P_SHA_21', '펜텔 그래프렛 0.5', '슬림한 전문용', NULL, '20260101', '20291231', 8000, 150);
INSERT INTO tb_product VALUES ('P_SHA_22', '플래티넘 프레스피 샤프', '가성비 학생용', NULL, '20260101', '20291231', 3000, 500);
INSERT INTO tb_product VALUES ('P_SHA_23', '코이노어 5.6mm 홀더', '두꺼운 크로키 전용', NULL, '20260101', '20291231', 15000, 50);
INSERT INTO tb_product VALUES ('P_SHA_24', '펜텔 PG5', '제도용 전문 샤프', NULL, '20260101', '20291231', 12000, 100);
INSERT INTO tb_product VALUES ('P_SHA_25', '파이롯트 레그노 샤프', '적성재 사용 고급형', NULL, '20260101', '20291231', 30000, 30);
INSERT INTO tb_product VALUES ('P_SHA_26', '스테들러 775 0.5', '클래식 마스 마이크로', NULL, '20260101', '20291231', 9000, 200);
INSERT INTO tb_product VALUES ('P_SHA_27', '제브라 테크 2 웨이', '흔들 샤프 기능', NULL, '20260101', '20291231', 8500, 150);
INSERT INTO tb_product VALUES ('P_SHA_28', '로트링 라피드 PRO', '쿠션 포인트 탑재', NULL, '20260101', '20291231', 45000, 40);
INSERT INTO tb_product VALUES ('P_SHA_29', '펜텔 캡렛 샤프', '캡이 있는 독특한 샤프', NULL, '20260101', '20291231', 2500, 300);
INSERT INTO tb_product VALUES ('P_SHA_30', '플래티넘 프로유즈 171', '심 경도 조절 가능', NULL, '20260101', '20291231', 28000, 60);

/* [104: 형광펜] 30개 */
INSERT INTO tb_product VALUES ('P_HL_01', '제브라 마일드라이너 그레이', '은은한 색감', NULL, '20260101', '20291231', 1500, 600);
INSERT INTO tb_product VALUES ('P_HL_02', '제브라 마일드라이너 골드', '다이어리 꾸미기', NULL, '20260101', '20291231', 1500, 400);
INSERT INTO tb_product VALUES ('P_HL_03', '스테들러 텍스트서퍼 클래식 노랑', '번짐 없는 형광펜', NULL, '20260101', '20291231', 1200, 800);
INSERT INTO tb_product VALUES ('P_HL_04', '동아 에센티 소프트 민트', '부드러운 사각촉', NULL, '20260101', '20291231', 700, 1000);
INSERT INTO tb_product VALUES ('P_HL_05', '스타빌로 보스 오리지널 파스텔', '대용량 형광펜', NULL, '20260101', '20291231', 2000, 500);
INSERT INTO tb_product VALUES ('P_HL_06', '파이롯트 프릭션 라이트', '지워지는 형광펜', NULL, '20260101', '20291231', 2000, 300);
INSERT INTO tb_product VALUES ('P_HL_07', '샤피 탱크 형광펜 노랑', '미국 국민 형광펜', NULL, '20260101', '20291231', 1000, 600);
INSERT INTO tb_product VALUES ('P_HL_08', '모나미 에델 형광펜 세트', '6색 파스텔 컬러', NULL, '20260101', '20291231', 3500, 200);
INSERT INTO tb_product VALUES ('P_HL_09', '펜텔 핸디 라인 S', '노크식 형광펜', NULL, '20260101', '20291231', 2200, 400);
INSERT INTO tb_product VALUES ('P_HL_10', '유니 프로퍼스 윈도우', '창이 있어 앞이 보임', NULL, '20260101', '20291231', 1800, 300);
INSERT INTO tb_product VALUES ('P_HL_11', '스타빌로 스윙 쿨', '슬림한 디자인', NULL, '20260101', '20291231', 1500, 500);
INSERT INTO tb_product VALUES ('P_HL_12', '파이롯트 스팟라이터 VW', '리필 가능한 형광펜', NULL, '20260101', '20291231', 2000, 150);
INSERT INTO tb_product VALUES ('P_HL_13', '자바 파워라인 형광펜', '가성비 우수 국산', NULL, '20260101', '20291231', 400, 2000);
INSERT INTO tb_product VALUES ('P_HL_14', '모나미 라이브 컬러', '트윈 타입 마커', NULL, '20260101', '20291231', 800, 1500);
INSERT INTO tb_product VALUES ('P_HL_15', '스테들러 트리플러스 텍스트서퍼', '삼각 바디 형광펜', NULL, '20260101', '20291231', 1500, 400);
INSERT INTO tb_product VALUES ('P_HL_16', '아이코닉 파스텔 마커', '빈티지 색감', NULL, '20260101', '20291231', 1200, 300);
INSERT INTO tb_product VALUES ('P_HL_17', '제브라 체크라이너', '암기용 펜(시트 포함)', NULL, '20260101', '20291231', 2500, 200);
INSERT INTO tb_product VALUES ('P_HL_18', '샤피 포켓 형광펜 핑크', '슬림 휴대용', NULL, '20260101', '20291231', 800, 500);
INSERT INTO tb_product VALUES ('P_HL_19', '스타빌로 보스 미니', '귀여운 소형 형광펜', NULL, '20260101', '20291231', 1800, 250);
INSERT INTO tb_product VALUES ('P_HL_20', '펜텔 일루미나', '눈이 편안한 색상', NULL, '20260101', '20291231', 1500, 300);
INSERT INTO tb_product VALUES ('P_HL_21', '파이롯트 프릭션 소프트', '지워지는 파스텔톤', NULL, '20260101', '20291231', 2000, 200);
INSERT INTO tb_product VALUES ('P_HL_22', '모나미 에센티 브라이트', '쨍한 형광 컬러', NULL, '20260101', '20291231', 700, 1000);
INSERT INTO tb_product VALUES ('P_HL_23', '동아 트윈 라이너', '두 가지 굵기 지원', NULL, '20260101', '20291231', 900, 800);
INSERT INTO tb_product VALUES ('P_HL_24', '제브라 마일드라이너 브러쉬', '붓펜 타입 형광펜', NULL, '20260101', '20291231', 2800, 150);
INSERT INTO tb_product VALUES ('P_HL_25', '스타빌로 루미나코어', '가늘게 써지는 형광펜', NULL, '20260101', '20291231', 1200, 400);
INSERT INTO tb_product VALUES ('P_HL_26', '샤피 노크식 형광펜', '뚜껑 없는 편리함', NULL, '20260101', '20291231', 2500, 200);
INSERT INTO tb_product VALUES ('P_HL_27', '고체 형광펜 노랑', '종이가 울지 않음', NULL, '20260101', '20291231', 1000, 500);
INSERT INTO tb_product VALUES ('P_HL_28', '제브라 저스트핏', '펜촉이 휘는 형광펜', NULL, '20260101', '20291231', 1800, 300);
INSERT INTO tb_product VALUES ('P_HL_29', '유니 프로퍼스 소프라', '매우 부드러운 필기', NULL, '20260101', '20291231', 2000, 200);
INSERT INTO tb_product VALUES ('P_HL_30', '모나미 라이브 마커 세트', '전문가용 구성', NULL, '20260101', '20291231', 15000, 50);

/* [201: 유선/무선 노트] 30개 */
INSERT INTO tb_product VALUES ('P_NOT_01', '옥스포드 리갈패드 A4 옐로우', '줄형 연습장', NULL, '20260101', '20291231', 3000, 500);
INSERT INTO tb_product VALUES ('P_NOT_02', '무인양품 유선 노트 B5', '깔끔한 디자인', NULL, '20260101', '20291231', 1500, 400);
INSERT INTO tb_product VALUES ('P_NOT_03', '로디아 도트패드 No.16', '고품질 도트 노트', NULL, '20260101', '20291231', 7500, 300);
INSERT INTO tb_product VALUES ('P_NOT_04', '양지 룰드 노트 A5', '탄탄한 제본 노트', NULL, '20260101', '20291231', 5000, 200);
INSERT INTO tb_product VALUES ('P_NOT_05', '코넬식 노트 링제본', '학습 효율 극대화', NULL, '20260101', '20291231', 4500, 150);
INSERT INTO tb_product VALUES ('P_NOT_06', '몰스킨 카이에 노트', '얇고 가벼운 메모용', NULL, '20260101', '20291231', 12000, 100);
INSERT INTO tb_product VALUES ('P_NOT_07', '미도리 MD 노트 무지', '만년필 최적화 종이', NULL, '20260101', '20291231', 15000, 80);
INSERT INTO tb_product VALUES ('P_NOT_08', '옥스포드 절취 노트', '깔끔하게 뜯어짐', NULL, '20260101', '20291231', 4000, 300);
INSERT INTO tb_product VALUES ('P_NOT_09', '무인양품 그리드 노트', '방안지 형식', NULL, '20260101', '20291231', 1800, 400);
INSERT INTO tb_product VALUES ('P_NOT_10', '클레르퐁텐 베이직 노트', '프랑스산 매끄러운 종이', NULL, '20260101', '20291231', 6500, 120);
INSERT INTO tb_product VALUES ('P_NOT_11', '양지 속사정 노트', '비침 없는 두꺼운 내지', NULL, '20260101', '20291231', 8000, 100);
INSERT INTO tb_product VALUES ('P_NOT_12', '로디아 웹노트 하드커버', '프리미엄 저널', NULL, '20260101', '20291231', 28000, 40);
INSERT INTO tb_product VALUES ('P_NOT_13', '옥스포드 캠퍼스 노트', '대학생 필수품', NULL, '20260101', '20291231', 2500, 600);
INSERT INTO tb_product VALUES ('P_NOT_14', '모닝글로리 SP 노트', '스프링 제본 노트', NULL, '20260101', '20291231', 3000, 500);
INSERT INTO tb_product VALUES ('P_NOT_15', '리히트랩 트위스트링 노트', '내지 교체 가능', NULL, '20260101', '20291231', 9500, 150);
INSERT INTO tb_product VALUES ('P_NOT_16', '미도리 원고지 노트', '고전적인 원고 양식', NULL, '20260101', '20291231', 6000, 90);
INSERT INTO tb_product VALUES ('P_NOT_17', '옥스포드 포켓 노트', '주머니 쏙 사이즈', NULL, '20260101', '20291231', 1500, 400);
INSERT INTO tb_product VALUES ('P_NOT_18', '모스카 바인더 노트', '정리 끝판왕', NULL, '20260101', '20291231', 13000, 70);
INSERT INTO tb_product VALUES ('P_NOT_19', '라이프 노블 노트 B5', '일본 빈티지 감성', NULL, '20260101', '20291231', 22000, 30);
INSERT INTO tb_product VALUES ('P_NOT_20', '무인양품 도트 그리드', '가이드라인용 도트', NULL, '20260101', '20291231', 2000, 350);
INSERT INTO tb_product VALUES ('P_NOT_21', '양지 메모 패드', '낱장 메모용', NULL, '20260101', '20291231', 3500, 400);
INSERT INTO tb_product VALUES ('P_NOT_22', '옥스포드 수학 오답 노트', '수학 특화 양식', NULL, '20260101', '20291231', 4500, 150);
INSERT INTO tb_product VALUES ('P_NOT_23', '미도리 MD 페이퍼 패드', '뜯어서 쓰는 만년필용', NULL, '20260101', '20291231', 12000, 80);
INSERT INTO tb_product VALUES ('P_NOT_24', '몰스킨 스마트 라이팅 노트', '디지털 전송 전용', NULL, '20260101', '20291231', 45000, 20);
INSERT INTO tb_product VALUES ('P_NOT_25', '로디아 스크립트 노트', '필기 전용 라인', NULL, '20260101', '20291231', 8500, 100);
INSERT INTO tb_product VALUES ('P_NOT_26', '모닝글로리 단어장', '영어 단어 암기용', NULL, '20260101', '20291231', 1000, 1000);
INSERT INTO tb_product VALUES ('P_NOT_27', '라이프 서머셋 노트', '잉크 비침 완벽 차단', NULL, '20260101', '20291231', 18000, 40);
INSERT INTO tb_product VALUES ('P_NOT_28', '양지 마이노트 무선', '그림 및 낙서용', NULL, '20260101', '20291231', 5500, 150);
INSERT INTO tb_product VALUES ('P_NOT_29', '옥스포드 리갈패드 미니', '메모 패드 옐로우', NULL, '20260101', '20291231', 1800, 400);
INSERT INTO tb_product VALUES ('P_NOT_30', '무인양품 재생종이 노트', '친환경 에디션', NULL, '20260101', '20291231', 1200, 500);

/* [202: 가계부] 30개 */
INSERT INTO tb_product VALUES ('P_ACC_01', '부자되는 가계부 (만년형)', '체계적인 지출 관리', NULL, '20260101', '20291231', 9800, 100);
INSERT INTO tb_product VALUES ('P_ACC_02', '하루 5분 용돈기입장', '어린이 경제 교육용', NULL, '20260101', '20291231', 3500, 200);
INSERT INTO tb_product VALUES ('P_ACC_03', '인디고 자산관리 노트', '재테크 특화 가계부', NULL, '20260101', '20291231', 12000, 80);
INSERT INTO tb_product VALUES ('P_ACC_04', '미니멀 가계부 플래너', '심플한 항목 정리', NULL, '20260101', '20291231', 7500, 150);
INSERT INTO tb_product VALUES ('P_ACC_05', '절약 습관 챌린지 노트', '무지출 데이 체크 가능', NULL, '20260101', '20291231', 11000, 90);
INSERT INTO tb_product VALUES ('P_ACC_06', '식비 절약 가계부', '식단표와 가계부 통합', NULL, '20260101', '20291231', 8500, 120);
INSERT INTO tb_product VALUES ('P_ACC_07', '꿈꾸는 집 가계부', '신혼부부 경제 합치기', NULL, '20260101', '20291231', 15000, 70);
INSERT INTO tb_product VALUES ('P_ACC_08', '비즈니스 지출 증빙 노트', '경비 정산용 양식', NULL, '20260101', '20291231', 9000, 100);
INSERT INTO tb_product VALUES ('P_ACC_09', '양지 프리미엄 가계부', '가죽 커버 고급 가계부', NULL, '20260101', '20291231', 22000, 40);
INSERT INTO tb_product VALUES ('P_ACC_10', '사회초년생 경제 독립 노트', '저축 가이드 포함', NULL, '20260101', '20291231', 13500, 110);
INSERT INTO tb_product VALUES ('P_ACC_11', '한달 살기 결산 프로젝트', '여행지 가계부', NULL, '20260101', '20291231', 6000, 150);
INSERT INTO tb_product VALUES ('P_ACC_12', '오피스 회비 관리장', '동호회 및 모임용', NULL, '20260101', '20291231', 4500, 200);
INSERT INTO tb_product VALUES ('P_ACC_13', '만년 다이어리 가계부', '날짜가 자유로운 가계부', NULL, '20260101', '20291231', 10500, 130);
INSERT INTO tb_product VALUES ('P_ACC_14', '인디고 오리지널 가계부', '감성 일러스트 수록', NULL, '20260101', '20291231', 12800, 80);
INSERT INTO tb_product VALUES ('P_ACC_15', '지출 제로 챌린지 바인더', '현금 바인더 포함', NULL, '20260101', '20291231', 19500, 60);
INSERT INTO tb_product VALUES ('P_ACC_16', '투명 머니 로그', '직관적인 지출 확인', NULL, '20260101', '20291231', 8800, 140);
INSERT INTO tb_product VALUES ('P_ACC_17', '부동산 임대 수익 관리장', '임대인 전용 장부', NULL, '20260101', '20291231', 16000, 30);
INSERT INTO tb_product VALUES ('P_ACC_18', '포켓 머니 다이어리', '휴대용 미니 가계부', NULL, '20260101', '20291231', 3000, 300);
INSERT INTO tb_product VALUES ('P_ACC_19', '양지 오피스 가계부 B5', '사무실 자금 관리', NULL, '20260101', '20291231', 11000, 90);
INSERT INTO tb_product VALUES ('P_ACC_20', '재테크 투자 기록장', '주식/코인 전용', NULL, '20260101', '20291231', 14000, 70);
INSERT INTO tb_product VALUES ('P_ACC_21', '모먼트 데일리 가계부', '일기형 지출 기록', NULL, '20260101', '20291231', 12000, 100);
INSERT INTO tb_product VALUES ('P_ACC_22', '인덱스 가계부 하드커버', '오래 보관 가능', NULL, '20260101', '20291231', 18500, 50);
INSERT INTO tb_product VALUES ('P_ACC_23', '세이빙 리포트 365', '1년 저축 통계', NULL, '20260101', '20291231', 15500, 80);
INSERT INTO tb_product VALUES ('P_ACC_24', '체크카드 전용 가계부', '맞춤 양식', NULL, '20260101', '20291231', 9500, 110);
INSERT INTO tb_product VALUES ('P_ACC_25', '현금 생활 다이어리 세트', '바인더 풀세트', NULL, '20260101', '20291231', 25000, 40);
INSERT INTO tb_product VALUES ('P_ACC_26', '비기너 캐시 북', '입문용 쉬운 가계부', NULL, '20260101', '20291231', 6500, 200);
INSERT INTO tb_product VALUES ('P_ACC_27', '비즈니스 회계 입문 장부', '간편 장부 대상자용', NULL, '20260101', '20291231', 13000, 60);
INSERT INTO tb_product VALUES ('P_ACC_28', '인포그래픽 스마트 가계부', '그래프 중심', NULL, '20260101', '20291231', 14500, 80);
INSERT INTO tb_product VALUES ('P_ACC_29', '에코 친환경 가계부', '재생지 제작', NULL, '20260101', '20291231', 8000, 120);
INSERT INTO tb_product VALUES ('P_ACC_30', '메모 가계부 (낱장형)', '벽걸이형 계획표', NULL, '20260101', '20291231', 4000, 250);

/* [203: 일기장] 30개 */
INSERT INTO tb_product VALUES ('P_DRY_01', '3년 다이어리 (일기 전용)', '나의 기록을 한눈에', NULL, '20260101', '20291231', 18000, 50);
INSERT INTO tb_product VALUES ('P_DRY_02', '질문 일기장 (Q&A 365)', '매일 다른 질문', NULL, '20260101', '20291231', 15000, 100);
INSERT INTO tb_product VALUES ('P_DRY_03', '육아 일기 (꿈꾸는 아이)', '성장 기록용', NULL, '20260101', '20291231', 22000, 60);
INSERT INTO tb_product VALUES ('P_DRY_04', '오늘의 감사 일기', '긍정 기록', NULL, '20260101', '20291231', 9800, 150);
INSERT INTO tb_product VALUES ('P_DRY_05', '감성 기록 필사 노트', '명언 필사 전용', NULL, '20260101', '20291231', 12500, 110);
INSERT INTO tb_product VALUES ('P_DRY_06', '불렛 저널 입문 일기장', '나만의 기호 기록', NULL, '20260101', '20291231', 14000, 90);
INSERT INTO tb_product VALUES ('P_DRY_07', '여행의 조각들 (여행 일기)', '티켓 보관 가능', NULL, '20260101', '20291231', 17000, 70);
INSERT INTO tb_product VALUES ('P_DRY_08', '하루 한 장 무드 로그', '기분 색채 기록', NULL, '20260101', '20291231', 11000, 130);
INSERT INTO tb_product VALUES ('P_DRY_09', '성공 습관 한 줄 일기', '매일 밤 단 한 줄', NULL, '20260101', '20291231', 8500, 180);
INSERT INTO tb_product VALUES ('P_DRY_10', '교환 일기', '친구/연인 공유', NULL, '20260101', '20291231', 13000, 100);
INSERT INTO tb_product VALUES ('P_DRY_11', '5년 후 나에게 (만년형)', '미래 지향적 기록', NULL, '20260101', '20291231', 25000, 40);
INSERT INTO tb_product VALUES ('P_DRY_12', '새벽 공기 다이어리', '아침 일기 전용', NULL, '20260101', '20291231', 12000, 110);
INSERT INTO tb_product VALUES ('P_DRY_13', '밤의 기록 (숙면 로그)', '수면 상태 기록', NULL, '20260101', '20291231', 14500, 80);
INSERT INTO tb_product VALUES ('P_DRY_14', '인디고 클래식 일기장', '빈티지 감성', NULL, '20260101', '20291231', 13800, 95);
INSERT INTO tb_product VALUES ('P_DRY_15', '나의 열두 달 (만년형)', '달별 테마 구성', NULL, '20260101', '20291231', 15500, 85);
INSERT INTO tb_product VALUES ('P_DRY_16', '명상과 일기', '마음 챙김 가이드', NULL, '20260101', '20291231', 19000, 60);
INSERT INTO tb_product VALUES ('P_DRY_17', '필름 로그 (영화 감상문)', '리뷰 기록용', NULL, '20260101', '20291231', 10500, 120);
INSERT INTO tb_product VALUES ('P_DRY_18', '리딩 다이어리 (독서 일기)', '독서 기록 전용', NULL, '20260101', '20291231', 12800, 100);
INSERT INTO tb_product VALUES ('P_DRY_19', '다꾸러를 위한 무제 일기', '여백 중심 레이아웃', NULL, '20260101', '20291231', 9900, 150);
INSERT INTO tb_product VALUES ('P_DRY_20', '운동과 식단 (바디 체크)', '건강 일기장', NULL, '20260101', '20291231', 13000, 110);
INSERT INTO tb_product VALUES ('P_DRY_21', '식물 키우기 관찰 일기', '반려 식물 성장기', NULL, '20260101', '20291231', 14000, 75);
INSERT INTO tb_product VALUES ('P_DRY_22', '나의 레시피 노트', '과정 및 맛 평가', NULL, '20260101', '20291231', 16500, 65);
INSERT INTO tb_product VALUES ('P_DRY_23', '반려견 성장 일기', '강아지 동반 일상', NULL, '20260101', '20291231', 15000, 90);
INSERT INTO tb_product VALUES ('P_DRY_24', '우표 일기 (미니)', '짧은 칸 구성', NULL, '20260101', '20291231', 7500, 200);
INSERT INTO tb_product VALUES ('P_DRY_25', '자아 성찰 100일 챌린지', '나를 찾는 질문', NULL, '20260101', '20291231', 13500, 105);
INSERT INTO tb_product VALUES ('P_DRY_26', '비밀 일기 (자물쇠)', '보안 유지 기록', NULL, '20260101', '20291231', 28000, 30);
INSERT INTO tb_product VALUES ('P_DRY_27', '창작자의 낙서 일기', '아이디어 스케치', NULL, '20260101', '20291231', 11500, 130);
INSERT INTO tb_product VALUES ('P_DRY_28', '감성 바인더 일기', '속지 교체 자유', NULL, '20260101', '20291231', 21000, 50);
INSERT INTO tb_product VALUES ('P_DRY_29', '드로잉 일기 A5', '그림 위주 구성', NULL, '20260101', '20291231', 14800, 80);
INSERT INTO tb_product VALUES ('P_DRY_30', '포켓 다이어리 (클립)', '수시 휴대 메모', NULL, '20260101', '20291231', 5500, 180);

/* [301: 다이어리] 30개 */
INSERT INTO tb_product VALUES ('P_DIA_01', '몰스킨 클래식 L 블랙', '프리미엄 다이어리', NULL, '20260101', '20291231', 32000, 100);
INSERT INTO tb_product VALUES ('P_DIA_02', '프랭클린 플래너 컴팩트', '성공 지표 관리', NULL, '20260101', '20291231', 45000, 40);
INSERT INTO tb_product VALUES ('P_DIA_03', '6공 다이어리 투명 커버', '다꾸 최적화', NULL, '20260101', '20291231', 12000, 150);
INSERT INTO tb_product VALUES ('P_DIA_04', '양지 다이어리 유즈어리 25', '국민 표준', NULL, '20260101', '20291231', 12000, 500);
INSERT INTO tb_product VALUES ('P_DIA_05', '루카랩 아카이브 다이어리', '빈티지 레트로', NULL, '20260101', '20291231', 16500, 120);
INSERT INTO tb_product VALUES ('P_DIA_06', '인디고 프리즘 만년', '색채 강조 디자인', NULL, '20260101', '20291231', 14800, 110);
INSERT INTO tb_product VALUES ('P_DIA_07', '몰스킨 위클리 소프트', '유연한 위클리', NULL, '20260101', '20291231', 28000, 80);
INSERT INTO tb_product VALUES ('P_DIA_08', '프랭클린 속지 세트 2026', '리필용 전용', NULL, '20260101', '20261231', 25000, 100);
INSERT INTO tb_product VALUES ('P_DIA_09', '양지 수첩 48k', '전통 수첩', NULL, '20260101', '20291231', 4500, 300);
INSERT INTO tb_product VALUES ('P_DIA_10', '스타벅스 다이어리 2026', '시즌 한정', NULL, '20260101', '20261231', 35000, 50);
INSERT INTO tb_product VALUES ('P_DIA_11', '몰스킨 데일리 하드', '전용 일일 기록', NULL, '20260101', '20291231', 35000, 60);
INSERT INTO tb_product VALUES ('P_DIA_12', '모노태스크 만년형', '깔끔한 사무용', NULL, '20260101', '20291231', 13000, 140);
INSERT INTO tb_product VALUES ('P_DIA_13', '비온뒤 오리지널', '감성 레이아웃', NULL, '20260101', '20291231', 12500, 100);
INSERT INTO tb_product VALUES ('P_DIA_14', '인디고 릴레이 다이어리', '월별 변화 구성', NULL, '20260101', '20291231', 15800, 90);
INSERT INTO tb_product VALUES ('P_DIA_15', '몰스킨 어린왕자 에디션', '한정 소장품', NULL, '20260101', '20261231', 42000, 30);
INSERT INTO tb_product VALUES ('P_DIA_16', '프랭클린 CEO 모델 가죽', '소가죽 커버', NULL, '20260101', '20291231', 120000, 15);
INSERT INTO tb_product VALUES ('P_DIA_17', '루카랩 365 데일리 패드', '뜯는 방식 기록', NULL, '20260101', '20291231', 9800, 200);
INSERT INTO tb_product VALUES ('P_DIA_18', '아이코닉 디자인 다이어리', '실용 포켓 탑재', NULL, '20260101', '20291231', 13500, 110);
INSERT INTO tb_product VALUES ('P_DIA_19', '라이브워크 모먼트', '차분한 톤 위클리', NULL, '20260101', '20291231', 14000, 120);
INSERT INTO tb_product VALUES ('P_DIA_20', '미도리 트래블러스 블랙', '여행 기록 전용', NULL, '20260101', '20291231', 58000, 40);
INSERT INTO tb_product VALUES ('P_DIA_21', '호보니치 테쵸 A5', '최고급 종이 다이어리', NULL, '20260101', '20291231', 48000, 25);
INSERT INTO tb_product VALUES ('P_DIA_22', '무인양품 도트 다이어리', '심플 격자', NULL, '20260101', '20291231', 9500, 180);
INSERT INTO tb_product VALUES ('P_DIA_23', '양지 마이플래너 B6', '사이즈 표준', NULL, '20260101', '20291231', 10500, 150);
INSERT INTO tb_product VALUES ('P_DIA_24', '몰스킨 포켓 레드', '휴대 특화', NULL, '20260101', '20291231', 25000, 70);
INSERT INTO tb_product VALUES ('P_DIA_25', '프랭클린 캐주얼', '합리적 가격 플래너', NULL, '20260101', '20291231', 18000, 100);
INSERT INTO tb_product VALUES ('P_DIA_26', '비온뒤 6공 A7 미니', '초미니 사이즈', NULL, '20260101', '20291231', 8500, 200);
INSERT INTO tb_product VALUES ('P_DIA_27', '모먼트 드로잉', '예술가용 여백', NULL, '20260101', '20291231', 15000, 60);
INSERT INTO tb_product VALUES ('P_DIA_28', '인디고 페이퍼', '에코 종이 사용', NULL, '20260101', '20291231', 13000, 130);
INSERT INTO tb_product VALUES ('P_DIA_29', '양지 전문직용', '시간 관리 특화', NULL, '20260101', '20291231', 14500, 80);
INSERT INTO tb_product VALUES ('P_DIA_30', '몰스킨 벚꽃 에디션', '시즌 한정판', NULL, '20260101', '20260531', 45000, 0);

/* [302: 스케줄러] 30개 */
INSERT INTO tb_product VALUES ('P_SCH_01', '주간 스케줄러 패드', '데스크 매트형', NULL, '20260101', '20291231', 4000, 300);
INSERT INTO tb_product VALUES ('P_SCH_02', '한달 계획표 (월간)', '벽보용 스케줄러', NULL, '20260101', '20291231', 2500, 500);
INSERT INTO tb_product VALUES ('P_SCH_03', '스터디 플래너 (100일)', '공부량 측정', NULL, '20260101', '20291231', 8500, 200);
INSERT INTO tb_product VALUES ('P_SCH_04', '비즈니스 데일리 패드', '업무 리스트', NULL, '20260101', '20291231', 6500, 150);
INSERT INTO tb_product VALUES ('P_SCH_05', '공시생 텐미닛', '시간 밀도 관리', NULL, '20260101', '20291231', 12000, 100);
INSERT INTO tb_product VALUES ('P_SCH_06', '위클리 데스크 A3', '대형 계획 패드', NULL, '20260101', '20291231', 9500, 80);
INSERT INTO tb_product VALUES ('P_SCH_07', '운동 습관 스케줄러', '피트니스 전용', NULL, '20260101', '20291231', 7000, 120);
INSERT INTO tb_product VALUES ('P_SCH_08', '프로젝트 관리 플래너', '일정 로드맵', NULL, '20260101', '20291231', 15000, 50);
INSERT INTO tb_product VALUES ('P_SCH_09', '체크 리스트 수첩', '단순 업무 확인', NULL, '20260101', '20291231', 3500, 400);
INSERT INTO tb_product VALUES ('P_SCH_10', '시험 대비 월간', '단기 집중 구성', NULL, '20260101', '20291231', 4800, 300);
INSERT INTO tb_product VALUES ('P_SCH_11', '포스트잇 플래너', '부착형 스케줄러', NULL, '20260101', '20291231', 5500, 250);
INSERT INTO tb_product VALUES ('P_SCH_12', '슬림 휴대 스케줄러', '포켓형 장축 디자인', NULL, '20260101', '20291231', 4200, 350);
INSERT INTO tb_product VALUES ('P_SCH_13', '굿모닝 루틴 플래너', '아침 기상 관리', NULL, '20260101', '20291231', 8800, 140);
INSERT INTO tb_product VALUES ('P_SCH_14', '미팅 로그 스케줄러', '회의 결과 기록', NULL, '20260101', '20291231', 11000, 110);
INSERT INTO tb_product VALUES ('P_SCH_15', '심플 타임 테이블', '대학 시간표용', NULL, '20260101', '20291231', 2000, 600);
INSERT INTO tb_product VALUES ('P_SCH_16', '자기계발 100일 챌린지', '목표 추적', NULL, '20260101', '20291231', 9900, 100);
INSERT INTO tb_product VALUES ('P_SCH_17', '탁상형 통합 제품', '달력 겸용 스케줄러', NULL, '20260101', '20291231', 12500, 80);
INSERT INTO tb_product VALUES ('P_SCH_18', '패밀리 스케줄러 B4', '공용 일정 관리', NULL, '20260101', '20291231', 10500, 120);
INSERT INTO tb_product VALUES ('P_SCH_19', '수험생 D-Day', '시험 카운트다운', NULL, '20260101', '20291231', 3500, 500);
INSERT INTO tb_product VALUES ('P_SCH_20', '아이코닉 데일리', '색채 위주 계획', NULL, '20260101', '20291231', 13000, 90);
INSERT INTO tb_product VALUES ('P_SCH_21', '비즈니스 여행 플래너', '출장 전용', NULL, '20260101', '20291231', 14500, 60);
INSERT INTO tb_product VALUES ('P_SCH_22', '홈카페 레시피', '개발 과정 기록', NULL, '20260101', '20291231', 11800, 75);
INSERT INTO tb_product VALUES ('P_SCH_23', '미니멀 계획장', '여백 중심 플래너', NULL, '20260101', '20291231', 7500, 130);
INSERT INTO tb_product VALUES ('P_SCH_24', '다이어트 성공 플래너', '식단 추적', NULL, '20260101', '20291231', 8900, 180);
INSERT INTO tb_product VALUES ('P_SCH_25', '취미 생활 기록', '활동 일정 관리', NULL, '20260101', '20291231', 12800, 95);
INSERT INTO tb_product VALUES ('P_SCH_26', '자산 로드맵', '금융 계획 특화', NULL, '20260101', '20291231', 16500, 45);
INSERT INTO tb_product VALUES ('P_SCH_27', '연구 플래너', '대학원생 학술 일정', NULL, '20260101', '20291231', 19000, 35);
INSERT INTO tb_product VALUES ('P_SCH_28', '선생님 학급 관리', '교육 일정 전용', NULL, '20260101', '20291231', 22000, 30);
INSERT INTO tb_product VALUES ('P_SCH_29', '육아 시간표', '신생아 루틴 관리', NULL, '20260101', '20291231', 10000, 110);
INSERT INTO tb_product VALUES ('P_SCH_30', '블로거 포스팅 계획', '발행일 관리', NULL, '20260101', '20291231', 13500, 70);

/* [303: 캘린더] 30개 */
INSERT INTO tb_product VALUES ('P_CAL_01', '2026 탁상용 달력', '표준형 사무용', NULL, '20260101', '20261231', 5000, 500);
INSERT INTO tb_product VALUES ('P_CAL_02', '미니 우드 캘린더', '소품형 디자인', NULL, '20260101', '20261231', 12000, 100);
INSERT INTO tb_product VALUES ('P_CAL_03', '대형 벽걸이 달력', '시인성 강조', NULL, '20260101', '20261231', 9000, 150);
INSERT INTO tb_product VALUES ('P_CAL_04', '연간 포스터 달력', '포스터형 인테리어', NULL, '20260101', '20261231', 3500, 400);
INSERT INTO tb_product VALUES ('P_CAL_05', '일러스트 한정판 달력', '예술 그림 삽입', NULL, '20260101', '20261231', 18000, 80);
INSERT INTO tb_product VALUES ('P_CAL_06', '명화 갤러리 캘린더', '작품 감상형', NULL, '20260101', '20261231', 22000, 50);
INSERT INTO tb_product VALUES ('P_CAL_07', '전통 민화 달력', '한국미 강조', NULL, '20260101', '20261231', 15000, 70);
INSERT INTO tb_product VALUES ('P_CAL_08', '메모 타입 탁상', '하단 메모 기능', NULL, '20260101', '20261231', 6500, 300);
INSERT INTO tb_product VALUES ('P_CAL_09', '무드등 캘린더', '조명 융합 달력', NULL, '20260101', '20261231', 38000, 30);
INSERT INTO tb_product VALUES ('P_CAL_10', '패브릭 포스터 달력', '천 소재 감성', NULL, '20260101', '20261231', 14000, 120);
INSERT INTO tb_product VALUES ('P_CAL_11', '풍경 사진 달력', '글로벌 풍경 샷', NULL, '20260101', '20261231', 20000, 60);
INSERT INTO tb_product VALUES ('P_CAL_12', '동물 캐릭터 달력', '귀여운 일러스트', NULL, '20260101', '20261231', 9800, 200);
INSERT INTO tb_product VALUES ('P_CAL_13', '입체 종이 공예 달력', '매달 입체 변화', NULL, '20260101', '20261231', 28000, 40);
INSERT INTO tb_product VALUES ('P_CAL_14', '식물 세밀화 캘린더', '보태니컬 아트', NULL, '20260101', '20261231', 16500, 90);
INSERT INTO tb_product VALUES ('P_CAL_15', '심플 화이트 탁상', '극강의 심플함', NULL, '20260101', '20261231', 4800, 500);
INSERT INTO tb_product VALUES ('P_CAL_16', '빈티지 블랙 라벨', '인더스트리얼 무드', NULL, '20260101', '20261231', 13000, 100);
INSERT INTO tb_product VALUES ('P_CAL_17', '수채화 플라워', '플로럴 일러스트', NULL, '20260101', '20261231', 15500, 80);
INSERT INTO tb_product VALUES ('P_CAL_18', '미니멀 아크릴 달력', '투명 소재 강조', NULL, '20260101', '20261231', 24000, 50);
INSERT INTO tb_product VALUES ('P_CAL_19', '자성 만년 달력', '자석 이동형', NULL, '20260101', '20301231', 32000, 40);
INSERT INTO tb_product VALUES ('P_CAL_20', '우드 블록 만년', '조립형 나무 달력', NULL, '20260101', '20301231', 19000, 70);
INSERT INTO tb_product VALUES ('P_CAL_21', '빈티지 일력', '전통적인 뜯는 달력', NULL, '20260101', '20261231', 12000, 150);
INSERT INTO tb_product VALUES ('P_CAL_22', '오늘의 명언 캘린더', '명언 수록형', NULL, '20260101', '20261231', 17000, 110);
INSERT INTO tb_product VALUES ('P_CAL_23', '아이들 낙서 달력', 'D.I.Y 컬러링', NULL, '20260101', '20261231', 8500, 250);
INSERT INTO tb_product VALUES ('P_CAL_24', '우주 테마 달력', '홀로그램 이미지', NULL, '20260101', '20261231', 21000, 60);
INSERT INTO tb_product VALUES ('P_CAL_25', '여행지 스탬프 달력', '기록형 캘린더', NULL, '20260101', '20261231', 14800, 100);
INSERT INTO tb_product VALUES ('P_CAL_26', '커플 기념일 달력', '디데이 특화', NULL, '20260101', '20261231', 13500, 90);
INSERT INTO tb_product VALUES ('P_CAL_27', '비즈니스 세로형', '스케줄 기입 최적화', NULL, '20260101', '20261231', 11000, 120);
INSERT INTO tb_product VALUES ('P_CAL_28', '건강 수칙 달력', '데일리 습관 체크', NULL, '20260101', '20261231', 9900, 140);
INSERT INTO tb_product VALUES ('P_CAL_29', '영어 단어 학습형', '어학 학습 겸용', NULL, '20260101', '20261231', 12800, 130);
INSERT INTO tb_product VALUES ('P_CAL_30', '친환경 크라프트', '따뜻한 색감', NULL, '20260101', '20261231', 7500, 300);


/* - 101(펜) 카테고리만 1~25번 상품 매핑 (5개 미매핑)
   - 나머지(102~303) 카테고리는 1~30번 상품 전체 매핑
*/
INSERT INTO tb_category_product_mapping (nb_category, no_product, cn_order)
SELECT
    sub.nb_cat,
    sub.no_prod,
    ROW_NUMBER() OVER (PARTITION BY sub.nb_cat ORDER BY sub.no_prod)
FROM (
         -- 1. 펜(101) 카테고리: 25번까지만 선택
         SELECT 101 as nb_cat, no_product as no_prod FROM tb_product
         WHERE no_product LIKE 'P_PEN_%' AND SUBSTR(no_product, -2) <= '25'

         UNION ALL

         -- 2. 나머지 모든 카테고리: 30번까지 전체 선택
         SELECT 102, no_product FROM tb_product WHERE no_product LIKE 'P_PENC_%'
         UNION ALL
         SELECT 103, no_product FROM tb_product WHERE no_product LIKE 'P_SHA_%'
         UNION ALL
         SELECT 104, no_product FROM tb_product WHERE no_product LIKE 'P_HL_%'
         UNION ALL
         SELECT 201, no_product FROM tb_product WHERE no_product LIKE 'P_NOT_%'
         UNION ALL
         SELECT 202, no_product FROM tb_product WHERE no_product LIKE 'P_ACC_%'
         UNION ALL
         SELECT 203, no_product FROM tb_product WHERE no_product LIKE 'P_DRY_%'
         UNION ALL
         SELECT 301, no_product FROM tb_product WHERE no_product LIKE 'P_DIA_%'
         UNION ALL
         SELECT 302, no_product FROM tb_product WHERE no_product LIKE 'P_SCH_%'
         UNION ALL
         SELECT 303, no_product FROM tb_product WHERE no_product LIKE 'P_CAL_%'
     ) sub;

COMMIT;

/* 김정상(user01) 장바구니 */
INSERT INTO tb_basket (nb_basket, id_user) VALUES (1, 'user01');
INSERT INTO tb_basket_item VALUES (1, 1, 1, 'P_PEN_01', 1800, 10, 18000);
INSERT INTO tb_basket_item VALUES (2, 1, 2, 'P_SHA_01', 12000, 1, 12000);
INSERT INTO tb_basket_item VALUES (3, 1, 3, 'P_DIA_01', 32000, 2, 64000);

/* 이정상(user02) 주문 */
INSERT INTO tb_order VALUES ('ORD_20260515_01', 'user02', 46300, '이정상', '광명시 일직동', SYSDATE, '10');
INSERT INTO tb_order_item VALUES ('OI_01', 'ORD_20260515_01', 1, 'P_PEN_11', 4000, 3);
INSERT INTO tb_order_item VALUES ('OI_02', 'ORD_20260515_01', 2, 'P_SHA_11', 85000, 1);

COMMIT;