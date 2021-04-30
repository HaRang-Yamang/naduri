<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="com.harang.naduri.jdbc.notice.model.vo.*, java.util.*"
 %>
    <!-- 서블릿이 넘긴 n의 정보를 받아오기 -->
<%
	Notice n = (Notice)request.getAttribute("notice");	// 서블릿이 보낸 "notice"받아오기
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
<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
        <div class="noticeDetailArea">
            <div class="head_area">
                <h2 class="notice_head">공지사항</h2>
            </div>
            <div class="table_area">
                <table class="notice_table">
                    <tr>
                        <th id="notice_no"><%= n.getN_no() %></th>
                        <th id='notice_title' name="n_title"><%= n.getN_title() %></th>
                        <th id='notice_writer'>관리자</th>
                        <th id='notice_date'><%= n.getN_date() %></th>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="3">
                        	<%-- 파일이 있을때만 보여주도록 함 --%>
                        	<% if( n.getN_file() != null && n.getN_file().length() > 0 ) { %>
                            <img class="att_icon" src="../../assets/images/icon/attachment.png">
                            <span class="notice_att">첨부파일 : <%= n.getN_file() %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <div id="textArea">
                                <p class="textArea">
                                    <%= n.getN_content() %>

                                </p>
                            </div>
                        </td>
                    </tr>
                </table>

                <button class="gotoList_btn" onclick="goSelectLsit();">목록으로 돌아가기</button>
                
			<script>
				function goSelectLsit(){
					location.href = '/naduri/selectList.no';
				}

			</script>


            </div>
        </div>
	</section>		
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>