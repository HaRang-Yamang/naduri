<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@
	page import="com.harang.naduri.jdbc.notice.model.vo.*, java.util.*"
 %>
    
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	Notice n = (Notice)request.getAttribute("notice");
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

<title>[관리자 권한]공지사항 수정하기</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
        <div class="noticeWriteArea">
        <form action="/naduri/updateList.no" method="post" enctype="multipart/form-data">
        <input type="hidden" name="n_no" value="<%= n.getN_no() %>"/>
        	  
            <div class="head_area">
                <h2 class="notice_head">공지사항 수정하기</h2>
            </div>
            <div class="table_area">
            
                <table class="notice_table">
                    <tr>
                        <th id="n_title">제목</th>
                        <th id='notice_title input'>
                            <input type="text" name="n_title" id="input_title" value="<%= n.getN_title() %>">
                        </th>
                        <th id='notice_writer'>관리자</th>
                        <th id='notice_date' name="n_date"><%= n.getN_date() %></th>
                    </tr>
                    <% if( n.getN_file() != null ) { %>
                    <tr>
                        <td>기존 첨부파일</td>
                        <td colspan="3">
                           	<a href="/naduri/resources/noticeFiles/<%= n.getN_file() %>"><%= n.getN_file() %></a>

                        </td>
                    </tr>
                    <% } %>
                    <tr>
                        <td>새 첨부파일</td>
                        <td colspan="3">
                           	<input class="inputFile" type="file" name="n_file" id="input_file">

                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <div id="textArea">
                                <textarea name="n_content" id="notice_input" rows="30" style="resize:none">
                                	<%= n.getN_content() %>
                                </textarea>
                            </div>
                        </td>
                    </tr>
                </table>
	                <button class="submit_btn" type="submit" style="cursor: pointer;">작성완료</button>
	                <button class="submit_btn" type="button" style="cursor: pointer;" onclick="deleteNotice()">게시글 삭제</button>
            </div>
        </form>
        </div>
	</section>
	<script>
		function deleteNotice(){
			var n_no = '<%= n.getN_no() %>';
			
			location.href = '/naduri/delete.no?n_no=' + n_no;
		}
	</script>		
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>