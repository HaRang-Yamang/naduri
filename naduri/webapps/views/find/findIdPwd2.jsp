<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/findIdPwd2.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
	
	    <div class="findArea">
	        <form action="">
	            <div class="container">
	            
	                <div class="find_tab">
	                
	                    <input id="find_id" type="radio" name="find" checked>
	                    <label class="tab_item" for="find_id">아이디 찾기</label>
	
	                    <input id="find_pw" type="radio" name="find">
	                    <label class="tab_item" for="find_pw">비밀번호 찾기</label>
	
	                    <div class="tab_content" id="id_tab">
		                    <form id="searchIdForm" action="/naduri/searchId.do" method="post">
		                        <span class="input_box">
		                            <input class="input_box inp_text" type="text" name="m_name" id="m_name" maxlength="20" placeholder="이름">
		                        </span>
		                        <span class="input_box">
		                            <input class="input_box inp_text" type="text" name="m_email" id="m_email" placeholder="이메일">
		                        </span>
		                        <button id="find_btn" type="submit">아이디 찾기</button>
		                    </form>
	                    </div>
	                    
	
	                    <div class="tab_content" id="pw_tab">
		                    <form id="searchPwdForm" action="/naduri/changePwd.do" method="post">
		                        <span class="input_box">
		                            <input class="inp_text" type="text" name="id" id="id" maxlength="20" placeholder="아이디">
		                        </span>
		                        <span class="input_box">
		                            <input class="inp_text" type="email" name="email" id="email" placeholder="이메일">
		                        </span>
		                        <button id="find_btn" type="submit">비밀번호 찾기</button>
		                    </form>
	                    </div>
	
	                </div>
	
	            </div>
	        </form>
    	</div>
	
	</section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>