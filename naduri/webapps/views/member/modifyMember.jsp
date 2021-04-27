<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/memberForm.css">
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />
<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
        <div class="joinArea">

            <!-- 회원가입 타이틀 영역-->
            <h2>회원 수정</h2>
            <!-- 회원가입 폼 -->
            <div class="joinFormArea">
                <form id="joinForm" method="post">

                    <div class="join_baisc">
                        <div class="joinTitleArea">
                            <div class="join_guide"><h3>기본 정보</h3></div>
                            <div class="join_red"><span class="red">*</span>항목은 필수 입력 사항입니다.</div>
                            <hr class="gray_bar">
                        </div>
                        <div class="join_container">
                            <!-- 기본 정보 -->
                            <table class="join_table">
                                <!-- ID -->
                                <tr>
                                    <tr>
                                        <td class="join_title">
                                            <h4><span class="red">*</span>아이디</h4>
                                            </td>
                                        <td>
                                            <span class="box">
                                                test1111
                                            </span>
                                        </td>
                                    </tr>
                                <!-- PASSWORD -->
                                <tr>
                                    <td class="join_title">
                                        <h4><span class="red">*</span>비밀번호</h4>
                                    </td>
                                    <td>
                                        <span class="box">
                                            <input type="password" id="join_pwd1" size="40" placeholder="6자리 이상, 영문 숫자 포함">
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="join_title"><h4><span class="red">*</span>비밀번호 확인</h4></td>
                                    <td><span class="box"><input type="password" id="join_pwd2" size="40"></span></td>
                                </tr>
                                <!-- NAME -->
                                <tr>
                                    <td class="join_title">
                                        <h4><span class="red">*</span>이름</h4>
                                    </td>
                                    <td><span class="box"><input type="text" id="join_name" size="40"></span></td>
                                </tr>
                                <!-- GENDER -->
                                <tr>
                                	<td class="join_title">
                                		<h4><span class="red">*</span>성별</h4>
                                	</td>
                                	<td>
										<span class="box">
											<input type="radio" name="m_gender" id="gender_M" value="M" /> <label for="gender_M">남성</label>
											<input type="radio" name="m_gender" id="gender_F" value="F" /> <label for="gender_F">여성</label>
										</span>
                                	</td>
                                </tr>
                                <!-- BIRTH -->
                                <tr>
                                    <td class="join_title">
                                        <h4><span class="red">*</span>생년월일</h4>
                                    </td>
                                    <td class="join_birth">
                                        <span class="box">
                                        <input type="text" id="yy" class="int" size="10" maxlength="4" placeholder="2021">
                                        </span>
                                        <span class="box">
                                            <input type="text" id="mm" class="int" size="9" maxlength="2" placeholder="월">
                                        </span>
                                        <span class="box">
                                        <input type="text" id="dd" class="int" size="9" maxlength="2" placeholder="일">
                                        </span>
                                    </td>
                                </tr>
                                <!-- PHONE -->
                                <tr>
                                    <td class="join_title">
                                        <h4><span class="red">*</span>연락처</h4>
                                    </td>
                                    <td>
                                        <select id="join_phone" style="width: 50px;">
                                            <option value="010">
                                                010
                                            </option>
                                            <option value="011">
                                                011
                                            </option>
                                            <option value="016">
                                                016
                                            </option>
                                            <option value="019">
                                                019
                                            </option>
                                            <option value="02">
                                                02
                                            </option>	
                                        </select>
                                        <span class="box">
                                            <input type="number" id="phone1" style="width: 50px;" class="int" maxlength="4">
                                        </span>
                                        <span class="box">
                                            <input type="number" id="phone2" style="width: 50px;" class="int" maxlength="4">
                                        </span>
                                        <button type="button" id="phone_btn">번호인증</button>
                                    </td>
                                </tr>
                                <!-- E-MAIL -->
                                <tr>
                                    <td class="join_title">
                                        <h4><span class="red">*</span>이메일</h4>
                                    </td>
                                    <td>
                                        <input type="text" size="15" placeholder="example"> @
                                        <input type="text" size="15" placeholder="example.com">
                                        <select name="email" style="width: 75px;">
                                            <option value="">직접입력</option>
                                            <option value="@gmail.com">구글 메일</option>
                                            <option value="@naver.com">네이버 메일</option>
                                            <option value="@zoom.com">줌 메일</option>
                                            <option value="@daum.net">다음 메일</option>
                                            <option value="@nate.com">네이트 메일</option>
                                            <option value="@hanmail.net">한 메일</option>
                                        </select>
                                    </td>
                                </tr>
                                <!-- ADDRESS -->
                                <tr>
                                    <td class="join_title">
                                        <h4><span class="red">*</span>주소</h4>
                                    </td>
                                    <td>
                                        <span class="box">
                                            <input type="text" id="address1" size="40" class="int" maxlength="4">
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="join_title">
                                        <h4>상세주소</h4>
                                    </td>
                                    <td>
                                        <span class="box">
                                            <input type="text" id="address2" size="40" class="int" maxlength="4">
                                        </span>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>


                    <!-- 관심사 선택 -->
                    <div class="join_keyword_id">
                        <div class="joinTitleArea">
                            <div class="join_guide"><h3>관심사 선택</h3></div>
                            <hr class="gray_bar">
                        </div>
                        <div class="join_container">
                            <table class="check_table">
                                <tr>
                                    <td class="check_title">
                                        <h4>여행 테마</h4>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="check-box" id="check-box1" name="keyword_id" value="문화재"><label for="check-box1"><span id="int">문화재</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box2" name="keyword_id" value="맛집"><label for="check-box2"><span id="int">맛집</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box3" name="keyword_id" value="쇼핑"><label for="check-box3"><span id="int">쇼핑</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box4" name="keyword_id" value="축제"><label for="check-box4"><span id="int">축제</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box5" name="keyword_id" value="트래킹"><label for="check-box5"><span id="int">트래킹</span></label></td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="check-box" id="check-box6" name="keyword_id" value="드라이브"><label for="check-box6"><span id="int">드라이브</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box7" name="keyword_id" value="자전거"><label for="check-box7"><span id="int">자전거</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box8" name="keyword_id" value="사진"><label for="check-box8"><span id="int">사진</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box9" name="keyword_id" value="반려동물"><label for="check-box9"><span id="int">반려동물</span></label></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td class="check_title">
                                        <h4>여행 유형</h4>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="check-box" id="check-box10" name="keyword_id" value="혼자"><label for="check-box10"><span id="int">혼자</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box11" name="keyword_id" value="친구"><label for="check-box11"><span id="int">친구</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box12" name="keyword_id" value="커플"><label for="check-box12"><span id="int">커플</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box13" name="keyword_id" value="가족"><label for="check-box13"><span id="int">가족</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box14" name="keyword_id" value="단체"><label for="check-box14"><span id="int">단체</span></label></td>
                                </tr>
                                <tr>
                                    <td class="check_title">
                                        <h4>계절</h4>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="check-box" id="check-box15" name="keyword_id" value="봄"><label for="check-box15"><span id="int">봄</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box16" name="keyword_id" value="여름"><label for="check-box16"><span id="int">여름</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box17" name="keyword_id" value="가을"><label for="check-box17"><span id="int">가을</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box18" name="keyword_id" value="겨울"><label for="check-box18"><span id="int">겨울</span></label></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td class="check_title">
                                        <h4>키워드</h4>
                                    </td>
                                </tr>
                                <tr>
                            
                                    <td><input type="checkbox" class="check-box" id="check-box19"><label for="check-box19" name="keyword_id" value="궁궐"><span id="int">궁궐</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box20"><label for="check-box20" name="keyword_id" value="유적지"><span id="int">유적지</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box21"><label for="check-box21" name="keyword_id" value="교육기관"><span id="int">교육기관</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box22"><label for="check-box22" name="keyword_id" value="인물"><span id="int">인물</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box23"><label for="check-box23" name="keyword_id" value="한옥"><span id="int">한옥</span></label></td>
                                    
                                <tr>    
                                    
                                    <td><input type="checkbox" class="check-box" id="check-box24"><label for="check-box24" name="keyword_id" value="전통"><span id="int">전통</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box25"><label for="check-box25" name="keyword_id" value="교과서"><span id="int">교과서</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box26"><label for="check-box26" name="keyword_id" value="무덤"><span id="int">무덤</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box27"><label for="check-box27" name="keyword_id" value="건축"><span id="int">건축</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box28"><label for="check-box28" name="keyword_id" value="종교"><span id="int">종교</span></label></td>
                                    
                                </tr>
                                <tr>     
                                    
                                    <td><input type="checkbox" class="check-box" id="check-box29"><label for="check-box29" name="keyword_id" value="술"><span id="int">술</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box30"><label for="check-box30" name="keyword_id" value="먹방"><span id="int">먹방</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box31"><label for="check-box31" name="keyword_id" value="카페"><span id="int">카페</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box32"><label for="check-box32" name="keyword_id" value="데이트"><span id="int">데이트</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box33"><label for="check-box33" name="keyword_id" value="장터"><span id="int">장터</span></label></td>
                                    
                                </tr>
                                <tr>     
                                    
                                    <td><input type="checkbox" class="check-box" id="check-box34"><label for="check-box34"><span id="int" name="keyword_id" value="미슐랭">미슐랭</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box35"><label for="check-box35"><span id="int" name="keyword_id" value="골목식당">골목식당</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box36"><label for="check-box36"><span id="int" name="keyword_id" value="먹킷리스트">먹킷리스트</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box37"><label for="check-box37"><span id="int" name="keyword_id" value="노포">노포</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box38"><label for="check-box38"><span id="int" name="keyword_id" value="나만알고픈">나만알고픈</span></label></td>
                                    
                                </tr>
                                <tr>     
                                    
                                    <td><input type="checkbox" class="check-box" id="check-box39"><label for="check-box39"><span id="int" name="keyword_id" value="당일치기">당일치기</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box40"><label for="check-box40"><span id="int" name="keyword_id" value="즉흥">즉흥</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box41"><label for="check-box41"><span id="int" name="keyword_id" value="레트로">레트로</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box42"><label for="check-box42"><span id="int" name="keyword_id" value="힐링">힐링</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box43"><label for="check-box43"><span id="int" name="keyword_id" value="캠핑">캠핑</span></label></td>
                                    
                                </tr>
                                <tr> 
                                    
                                    <td><input type="checkbox" class="check-box" id="check-box44"><label for="check-box44"><span id="int" name="keyword_id" value="바다">바다</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box45"><label for="check-box45"><span id="int" name="keyword_id" value="자연">자연</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box46"><label for="check-box46"><span id="int" name="keyword_id" value="패키지">패키지</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box47"><label for="check-box47"><span id="int" name="keyword_id" value="기차">기차</span></label></td>
                                    <td><input type="checkbox" class="check-box" id="check-box48"><label for="check-box48"><span id="int" name="keyword_id" value="도심">도심</span></label></td>
                                    
                                </tr>

                            </table>
                        </div>
                    </div>

                    <!-- 회원 정보 수정 버튼 -->
                    <div class="submit_btn">
                        <button type="button" id="submit_btn">회원 정보 수정</button>
                    </div>
                </form>
            </div>

        </div>
	</section>		
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>