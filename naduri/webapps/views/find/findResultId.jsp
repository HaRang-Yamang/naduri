<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/findResult.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
	
        <div class="contentArea">
            <div class="container">
                <p class="id_notice"><%= m.getM_name() %>님의 아이디는 아래와 같습니다.</p>
                <p class="id_result"><%= m.getM_id() %></p>
                <button class="find_pw_btn"><a href="findResultPwd.jsp">비밀번호 찾기</a></button>
                <button class="login_btn"><a href="../login.jsp">로그인 하기</a></button>
            </div>
        </div>	
	
	</section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>