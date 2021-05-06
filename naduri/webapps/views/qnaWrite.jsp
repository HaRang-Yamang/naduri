<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.harang.naduri.jdbc.heritage.model.vo.*, java.util.*,
com.harang.naduri.jdbc.Thumbnail.model.vo.*" %>
<%
		ArrayList<lo_key> lokey = (ArrayList<lo_key>)request.getAttribute("lokey");
%>
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
<form id="insertForm" action="/naduri/insert.qn" method="post">
          <input type="hidden" name="m_no" value="<%=m.getM_no() %>"/> 
            <div class=qnatitle >
            <span>질문 제목: </span>
            <input type="text" name="q_title" />
            </div>
            <div class=qnacontent>
            <span>질문 내용: </span>
             <textarea id="qna_textArea"  name="q_content" cols="150" rows="10" style="resize:none;"></textarea>
             </div>
             <div class="write_btn">
                   <button type="submit"  form='insertForm' id="submit_btn" >질문하기</button>
            </div>
	</form>
	</section>
	
	<%@ include file="common/footer.jsp" %>
	

</body>
</html>