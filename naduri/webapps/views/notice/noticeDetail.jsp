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
                            <span class="notice_att"><a href="/naduri/resources/noticeFiles/<%= n.getN_file() %>">첨부파일 : <%= n.getN_file() %></a></span>
                            <a href="/naduri/resources/noticeFiles/<%= n.getN_file() %>" download>파일 다운로드</a>
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
                
				<div class="btn_area">
	                <button class="gotoList_btn" onclick="goSelectLsit();">목록으로 돌아가기</button>

	                <!-- 관리자만 볼 수 있는 버튼을 만들고 싶어요... -->
	                <% if (m != null && m.getM_auth() == 0) { %>
	                	<button class="goupdate_btn" onclick="goUpdatePage();">수정하기</button>
                	<% }%>
                </div>
                

			<script>
				function goSelectLsit(){
					location.href = '/naduri/selectList.no';
				}
	
				function goUpdatePage(){
					location.href = '/naduri/noticeUpdate.no?n_no=' + <%= n.getN_no() %>;
				}
			</script>


            </div>
        </div>
	</section>		
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>