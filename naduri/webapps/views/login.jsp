<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/login.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>나드리</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	
	<section>
	
		<div class="loginArea">
            <form action="/naduri/login.do" method="post">
                <div class="container">
                    <h2 id="login_title">로그인</h2>
                    <span class="input_box">
                        <input class="inp_text" checked type="text" name="m_id" id="id" maxlength="20" placeholder="아이디">
                    </span>
                    <span class="input_box">
                        <input class="inp_text" type="password" name="m_pwd" id="pw" placeholder="비밀번호">
                    </span>
                    <div class="keep_and_find">
                        <div class="login_check">
                            <input type="checkbox" name="saveId" id="checkbox" class="keepLogin">
                            <label for="keep_login">로그인 상태 유지</label>
                        </div>
                        <div class="find_acc">
                            <a href="find/findIdPwd.jsp">아이디 / 비밀번호 찾기</a>
                        </div>
                    </div>
                    <button id="login_btn" type="submit">로그인</button>
                    <a id="join" href="member/joinMember.jsp">회원 가입</a>
                </div>
            </form>
        </div>
	
	</section>
	
	<%@ include file="common/footer.jsp" %>
</body>
</html>