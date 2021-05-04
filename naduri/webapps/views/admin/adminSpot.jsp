<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.spot.model.vo.* ,com.harang.naduri.jdbc.notice.model.vo.*, java.util.*" %>
<%
	ArrayList<Spot> list = (ArrayList<Spot>)request.getAttribute("list");
	PageNation pn = (PageNation)request.getAttribute("pn");
	
	int st = pn.getStartPage();
	int ed = pn.getEndPage();
	int mx = pn.getMaxPage();
	int limit = pn.getLimit();
	int listCount = pn.getListCount();
	int cur = pn.getCurrentPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/admin.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<style>
	#p_btn {
		background-color : #A5B874;
		border-radius: 5px;
    	border: none;
		cursor : pointer;
		width : 25px;

	}
	.pagingArea {
		text-align : center;
		margin-top : 70px;
	}

</style>
<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<%@ include file="../common/adminAside.jsp" %>
	
	<section>
	
	        <div class="adminArea">
            <div class="head_area">
                <h2 class="notice_head">여행지 관리</h2>
            </div>
            <div class="table_area">
                <table class="m_table">
                    <tr>
                        <th>번호</th>
                        <th>장소명</th>
                        <th></th>
                        <th></th>
                    </tr>
                     <% for(Spot ss : list) { %>
                    <tr>
                        <td id="her_no"><%= ss.getS_id() %></td>
                        <td id="her_id"><%= ss.getS_name() %></td>
                        <td id="her_table_btn">
                            <div class="her_btn_area">
                                <button id="her_update">데이터 수정</button>
                            </div>
                        </td>
                        <td id="her_table_btn">
                            <div class="her_btn_area">
                                <button id="her_delete">데이터 삭제</button>
                            </div>
                        </td>
                    </tr>
                   	<% } %>
                </table>
 				<div class="her_btn_area">
				<button id="her_insert_btn" onclick="location.href='/naduri/views/admin/adminInsertSpot.jsp'">여행지 등록</button>
				</div>
				
            </div>
            <%-- 페이지네이션 버튼 --%>
                <div class="pagingArea">
		        	<button id="p_btn" onclick="location.href='/naduri/spotList.ad?currentPage=1'">
		        		&lt;&lt;
		        	</button>
		        	
		        	<% if (cur <= 1) { %>
						<button id="p_btn" disabled> &lt; </button>
					<% } else { %>
						<button id="p_btn" onclick="location.href='/naduri/spotList.ad?currentPage=<%= cur - 1 %>'"> &lt;</button>
					<% } %>
		        	
		        	<% for(int p = st ; p <= ed ; p ++) { %>
		        	
			        	<% if( p == cur) { %>
			        		<button id="p_btn" disabled> <%= p %> </button>
			        	<% } else { %>
			        		<button id="p_btn" onclick="location.href='/naduri/spotList.ad?currentPage=<%= p %>'"> <%= p %> </button>
			        	<% } %>
		        	
		        	<% } %>
		        	
		        	<% if (cur >= mx) { %>
						<button id="p_btn" disabled> &gt; </button>
					<% } else { %>
						<button id="p_btn" onclick="location.href='/naduri/spotList.ad?currentPage=<%= cur + 1 %>'"> &gt;</button>
					<% } %>
					
		        	<button id="p_btn" onclick="location.href='/naduri/spotList.ad?currentPage=<%= mx %>'">
		        		&gt;&gt;
		        	</button>
		        	
		        </div>
      				
      		<%-- ------------------- --%>
        </div>
	
	</section>

	<%@ include file="../common/footer.jsp" %>
</body>
</html>