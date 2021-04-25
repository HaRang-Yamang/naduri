<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/detail.css" />
<link rel="stylesheet" href="/naduri/assets/css/slide.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"  
        integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" 
            integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
            
<script type="text/javascript" src="/naduri/assets/js/tab.js"></script>



<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
	
		<div class="detailArea_heritage">
	
	        <h2 class="hidden">상세페이지</h2>
	
	        <!-- 상단 슬라이드 영역 -->
	        <%@ include file="slider.jsp" %>
	        
	        <!-- 상단 정보 영역 -->
	        <%@ include file="infoArea.jsp" %>
	
	        <!-- 근처 장소 영역 -->
	        <%@ include file="nearArea.jsp" %>
	        
	        <!-- 탭 -->
			<%@ include file="tab_review_qna.jsp" %>
	
	        <!-- 비슷한 장소 추천 -->
	        <%@ include file="recommendPlace.jsp" %>
	        
	    </div>
	
	</section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>