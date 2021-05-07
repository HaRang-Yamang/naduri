
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page

	import="com.harang.naduri.jdbc.heritage.model.vo.*, java.util.*,

com.harang.naduri.jdbc.Thumbnail.model.vo.*"%>
<%
ArrayList<lo_key> lokey = (ArrayList<lo_key>) request.getAttribute("lokey");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon"
	type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/WriteFrm.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js"
	crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>나드리</title>
</head>
<body>
	<%@ include file="common/header.jsp"%>

	<section>

		<div class="writeFrm">
			<form id="insertForm" action="/naduri/insert.re" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="l_no" value="<%= request.getParameter("l_no")%>">
				<h2>리뷰 작성</h2>
				<div class="container">
					<table>
						<tr>
							<td colspan="2"><input type="hidden" name="m_no"
								value="<%=m.getM_no()%>" /></td>
						</tr>
						<tr>
							<div class="range_part">
								<td class="review_title">평점</td>
								<td><input type="range" class="slider" id="range" max="5"
									min="0" step="1" name="r_rank"
									oninput="document.getElementById('value1').innerHTML=this.value;">
									<span class="slider_txt"><span id="value1"></span>점</span></td>
							</div>
						</tr>
						<tr>
							<td class="review_title">방문 일자</td>
							<td><input type="text" id="yy" name="r_period" size="10"
								maxlength="4" placeholder="2021"> <input
								type="text" id="mm" name="r_period" size="9" maxlength="2"
								placeholder="월"> <input type="text" id="dd"
								name="r_period" size="9" maxlength="2" placeholder="일"></td>
						<tr>
							<td class="review_title">여행 유형</td>
							<td><input type="radio" name="r_with" id="t_type1" value="1"><label
								for="t_type1">혼자</label> <input type="radio" name="r_with"
								id="t_type2" value="2"><label for="t_type2">친구</label> <input
								type="radio" name="r_with" id="t_type3" value="3"><label
								for="t_type3">썸</label> <input type="radio" name="r_with"
								id="t_type4" value="4"><label for="t_type4">커플</label> <input
								type="radio" name="r_with" id="t_type5" value="5"><label
								for="t_type5">가족</label></td>
						</tr>
						<tr>
							<td class="review_title">제목</td>
							<td><input type="text" id="review_title" name="r_title"
								placeholder="30자 이내 작성" style="width:445px;"></td>
						</tr>
						<tr>
							<td class="review_title place">내용</td>
							<td><textarea id="review_textArea" name="r_content"
									cols="70" rows="15"></textarea></td>
						</tr>
						<tr class="photo_table">
							<td class="review_title place">사진 업로드</td>

							<td>
								<div id="titleImgArea">
									<img id="titleImg" src="../assets/images/review/no-img.png"
										width="90px">
								</div>
								<div id="contentImgArea1">
									<img id="contentImg1" src="../assets/images/review/no-img.png"
										width="90px">
								</div>
								<div id="contentImgArea2">
									<img id="contentImg2" src="../assets/images/review/no-img.png"
										width="90px">
								</div>
								<div id="contentImgArea3">
									<img id="contentImg3" src="../assets/images/review/no-img.png"
										width="90px">
								</div>
							</td>
						</tr>
					</table>
				</div>
				<div class="fileArea" id="fileArea">
					<input type="file" accept="image/*" name="thumbImg1" id="thumbImg1"
						onchange="loadImg(this,1)" /> <input type="file" name="thumbImg2"
						id="thumbImg2" onchange="loadImg(this,2)" /> <input type="file"
						name="thumbImg3" id="thumbImg3" onchange="loadImg(this,3)" /> <input
						type="file" name="thumbImg4" id="thumbImg4"
						onchange="loadImg(this,4)" />
				</div>

				<!-- 리뷰 업로드 버튼 -->

				<div class="submit_btn">

					<button type="submit" form='insertForm' id="submit_btn">리뷰
						업로드</button>

				</div>
			</form>
		</div>
	</section>

	<%@ include file="common/footer.jsp"%>
	<script>
		$('#titleImgArea').on('click', function() {
			$('#thumbImg1').click();
		});
		$('#contentImgArea1').on('click', function() {
			$('#thumbImg2').click();
		})
		$('#contentImgArea2').on('click', function() {
			$('#thumbImg3').click();
		})
		$('#contentImgArea3').on('click', function() {
			$('#thumbImg4').click();
		})
		$('#fileArea').hide();
		//사진 미리 보기 구현
		function loadImg(img, num) {
			if (img.files && img.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {

					switch (num) {
					case 1:
						$('#titleImg').attr('src', e.target.result);
						break;
					case 2:
						$('#contentImg1').attr('src', e.target.result);
						break;
					case 3:
						$('#contentImg2').attr('src', e.target.result);
						break;
					case 4:
						$('#contentImg3').attr('src', e.target.result);
						break;
					}
				}
				reader.readAsDataURL(img.files[0]);
			}
		}
	</script>
</body>
</html>