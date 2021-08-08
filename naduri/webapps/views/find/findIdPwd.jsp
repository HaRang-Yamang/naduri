<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon"
	type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/findIdPwd.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js"
	crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<script defer src="/naduri/assets/js/tab.js"></script>
<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<section>

		<div class="findArea">

			<!-- 상단 탭 영역 -->
			<div class="container">
				<!-- 상단 탭 영역 -->
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1"><span class="inline">아이디 찾기</span></li>
					<li class="tab-link" data-tab="tab-2"><span class="inline">비밀번호 바꾸기</span></li>
				</ul>
				<!-- 상단 탭 영역 끝 -->

				<!-- 아이디 찾기 -->
				<div id="tab-1" class="tab-content current">

					<div class="mid">
						<form action="/naduri/searchId.do" method="post" id="searchIdForm">

							<input type="text" name="m_name" id="m_name" placeholder="이름" />
							<input type="text" name="m_email" id="m_email" placeholder="이메일" />
							<input type="submit" value="아이디 찾기" />

						</form>
					</div>

				</div>
				<!-- 아이디 찾기 끝 -->

				<!-- 비밀번호 바꾸기 -->
				<div id="tab-2" class="tab-content">
					<div class="mid">
						<form action="/naduri/changePwd.do" method="post"
							id="changePwdForm">
							<input type="text" name="m_id" id="m_id" placeholder="회원 아이디" />
							<input type="text" name="m_email" id="m_email"
								placeholder="회원 이메일" /> <input type="password" name="m_pwd"
								id="m_pwd1" placeholder="비밀번호" /> <input type="password"
								name="m_pwd2" id="m_pwd2" placeholder="비밀번호 확인" /> <input
								type="submit" value="비밀번호 바꾸기" />

						</form>
					</div>
				</div>
				<!-- 비밀번호 바꾸기 끝 -->
			</div>


		</div>

	</section>

	<%@ include file="../common/footer.jsp"%>
</body>
</html>