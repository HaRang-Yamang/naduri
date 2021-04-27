<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/reviewWriteForm.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>나드리</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	
	<section>
	<form id="insertForm"action="/naduri/insert.vi" method="post"
						enctype="multipart/form-data">
		        <div class="reviewWriteArea">
            <h2>리뷰 작성</h2>

            <div class="img_main">
                <img src="../assets/images/review/review_main.png" width="50%">
            </div>

            <div class="img_text">아이스크림 가게</div>

            <hr class="gray_bar">
            <div id="container">
                <table class="review_table">
                    <tr>
                        <div class="range_part">
                            <td class="review_title" name="r_rank">평점 &nbsp;</td>
                            <td colspan="3">
                                <input type="range" class="slider" id="range" max="5" min="0" step="1" oninput="document.getElementById('value1').innerHTML=this.value;">
                            </td>
                            <td colspan="2" id="range" style="text-align: center;"><span id="value1"></span>점</td>
                        </div>
                    </tr>
                    <tr>
                        <td class="review_title" name="r_period">방문 일자 &nbsp;</td>
                        <td><input type="text" id="yy" class="int" size="10" maxlength="4" placeholder="2021" style="border:solid 2px #b7b7b7"></td>
                        <td><input type="text" id="mm" class="int" size="9" maxlength="2" placeholder="월" style="border:solid 2px #b7b7b7"></td>
                        <td><input type="text" id="dd" class="int" size="9" maxlength="2" placeholder="일" style="border:solid 2px #b7b7b7"></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="review_title" name="r_with">여행 유형 &nbsp;</td>
                        <td><input type="radio" name="t_type" id="t_type1"><label for="t_type1"><span id="int">혼자</span></label></td>
                        <td><input type="radio" name="t_type" id="t_type2"><label for="t_type2"><span id="int">친구</span></label></td>
                        <td><input type="radio" name="t_type" id="t_type3"><label for="t_type3"><span id="int">썸</span></label></td>
                        <td><input type="radio" name="t_type" id="t_type4"><label for="t_type4"><span id="int">커플</span></label></td>
                        <td><input type="radio" name="t_type" id="t_type5"><label for="t_type5"><span id="int">가족</span></label></td>
                    </tr>
                     <tr>
                        <td class="review_title" name="r_title">제목 &nbsp;</td>
                        <td colspan="5"><input type="text" id="review_title" placeholder="30자 이내 작성" size="69%"></td>
                    </tr>
                    <tr>
                        <td class="review_title"name="r_content">내용 &nbsp;</td>
                        <td colspan="5">
                            <textarea id="review_textArea" cols="70" rows="15" style="resize:none;"></textarea>
                        </td>
                    </tr>
                    <tr class="photo_table">
                        <td class="review_title" >사진 업로드 &nbsp;</td>
                        <td><img src="../assets/images/review/no-img.png" width="90px"></td>
                        <td><img src="../assets/images/review/no-img.png" width="90px"></td>
                        <td><img src="../assets/images/review/no-img.png" width="90px"></td>
                        <td><img src="../assets/images/review/no-img.png" width="90px"></td>
                    </tr>
                    </table>
            </div>
            
            <!-- 리뷰 업로드 버튼 -->
            
            <div class="submit_btn">
            
            <button type="submit"  form='insertForm' id="submit_btn" >리뷰 업로드</button>
            
            </div>
        </div>
	</form>
	</section>
	
	<%@ include file="common/footer.jsp" %>
	<script>
	function goReview(){
		location.href='/'
	}
	
	</script>
</body>
</html>