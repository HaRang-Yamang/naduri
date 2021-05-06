<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/admin.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<%@ include file="../common/adminAside.jsp" %>
	
	<section>
	
        <div class="adminArea">
            <div class="head_area">
                <h2 class="notice_head">맛집 데이터 등록</h2>
                <hr class="green_bar">
            </div>
            <div class="dtable_area">
            	<form action="/naduri/AdminFoodInsert.do" method = "post" enctype="multipart/form-data" id="dababy">
                 <table class="d_table">
                    <!-- PASSWORD -->
                    <tr>
                        <td class="data_title">장소명</td>
                        <td colspan="3">
                            <span class="box">
                                <input type="text" id="food_title" size="70" name="s_name">
                            </span>
                        </td>

                    </tr>
                    <!-- PASSWORD -->
                    <tr>
                        <td class="data_title">전화번호</td>
                        <td colspan="3"><span class="box"><input type="text" id="food_tell" size="70" name="s_tel"></span></td>
                    </tr>
                    <!-- NAME -->
                    <tr>
                        <td class="data_title">운영시간</td>
                        <td colspan="3"><span class="box"><input type="text" id="food_time" size="70" name="s_date"></span></td>
                    </tr>
                    <tr>
                        <td class="data_title">위치</td>
                        <td colspan="3">
                            <span class="box">
                                <input type="text" id="food_site" size="70" name="s_address">
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="data_title">위도</td>
                        <td colspan="3">
                            <span class="box">
                                 <input type="text" id="food_location" size="70" name="s_lat">
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="data_title">경도</td>
                        <td colspan="3">
                             <input type="text" id="food_content" size="70" name="s_lng">
                        </td>
                    </tr>
                    <tr class="photo_table">
                        <td class="review_title">관련 사진 &nbsp;</td>
                        <td><img src="../../assets/images/no-img.png" width="90px" style="cursor: pointer"></td>
                        <td><img src="../../assets/images/no-img.png" width="90px" style="cursor: pointer"></td>
                        <td><img src="../../assets/images/no-img.png" width="90px" style="cursor: pointer"></td>
                    </tr>
                    <tr class="photo_table">
                        <td></td>
                        <td><img src="../../assets/images/no-img.png" width="90px" style="cursor: pointer"></td>
                        <td><img src="../../assets/images/no-img.png" width="90px" style="cursor: pointer"></td>
                        <td><img src="../../assets/images/no-img.png" width="90px" style="cursor: pointer"></td>
                    </tr>
                </table>

            </div>
            <hr id="section_hr" style="margin-left: 16%;">
            <!-- 리뷰 업로드 버튼 -->

            <div class="submit_btn">

                <button type="submit" form="dababy" id="submit_btn">데이터 등록</button>

            </div>
            </form>
        </div>	
	
	</section>

	<%@ include file="../common/footer.jsp" %>
</body>
</html>