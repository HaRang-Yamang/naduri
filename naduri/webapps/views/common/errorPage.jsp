<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>나드리 - 에러페이지</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<section>
	
		<% String msg = (String)request.getAttribute("error-msg"); %>
	
		<div>
			<%= msg %> <br>
			관리자에게 문의하세요! (문의전화: 1500 - 0000)
		</div>
	
	</section>
	
	<%@ include file="footer.jsp" %>
</body>
</html>