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
<link rel="stylesheet" href="/naduri/assets/css/login.css" />
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

	<div class="loginArea">
	
		<div class="container">
		
		<h2 id="login_title">로그인</h2>
		
		<form action="/naduri/login.do" method="post">
		
			<input type="text" name="m_id" id="m_id" maxlength="20" placeholder="아이디"/>
			<input type="password" name="m_pwd" id="m_pwd" placeholder="비밀번호"/>
			
			<div class="keep_and_find">
			
				<div class="login_check">
					<input type="checkbox" name="saveId" id="checkbox" class="keepLogin" value="saveId"/>
					<label for="keepLogin">로그인 상태 유지</label>
				</div>
				<div class="findIdPwd_Area">
					<button type="button" class="findIdPwd" onclick="location.href='/naduri/views/find/findIdPwd.jsp'">아이디 / 비밀번호 찾기</button>
				</div>
				
			</div>
			
			<button type="submit" class="login_btn">로그인</button>
			<button type="button" class="join" onclick="location.href='/naduri/views/member/joinMember.jsp'">회원가입</button>
		
		</form>
		
				
		</div>
	

	
	</div>




</section>

	<%@ include file="common/footer.jsp"%>
</body>
</html>