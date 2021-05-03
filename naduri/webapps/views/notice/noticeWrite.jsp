<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@
	page import="com.harang.naduri.jdbc.notice.model.vo.*, java.util.*"
 %>
    
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy. MM. dd");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/notice.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>

<title>[관리자 권한]공지사항 작성하기</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
        <div class="noticeWriteArea">
        <form action="/naduri/noticeWrite.no" method="post"
        	  enctype="multipart/form-data">
        	  
            <div class="head_area">
                <h2 class="notice_head">공지사항 작성하기</h2>
            </div>
            <div class="table_area">
            
                <table class="notice_table">
                    <tr>
                        <th id="n_title">제목</th>
                        <th id='notice_title input'>
                            <input type="text" name="n_title" id="input_title" placeholder="공지 제목">
                        </th>
                        <th id='notice_writer'>관리자</th>
                        <th id='notice_date' name="n_date"><%= sf.format(nowTime) %></th>
                    </tr>
                    <tr>
                        <td>첨부파일</td>
                        <td colspan="3">
                            <input class="inputFile" type="file" name="n_file" id="input_file">

                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <div id="textArea">
                                <textarea name="n_content" id="notice_input" rows="30" style="resize:none"></textarea>
                            </div>
                        </td>
                    </tr>
                </table>
	                <button class="submit_btn" type="submit" style="cursor: pointer;">작성하기</button>
	              
            </div>
        </form>
        	<%-- form태그 밖에 목록으로 돌아가는 버튼 생성 --%>
        	<button class="gotoList_btn" onclick="goSelectLsit();">작성취소</button>
        	<script>
					function goSelectLsit(){
						location.href = '/naduri/selectList.no';
					}
		
			</script>
        </div>
	</section>		
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>