<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.spot.model.vo.*, com.harang.naduri.jdbc.notice.model.vo.*, java.util.*" %>
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
<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<%@ include file="../common/adminAside.jsp" %>
	
	<section>
	
	        <div class="adminArea">
            <div class="head_area">
                <h2 class="notice_head">맛집 관리</h2>
            </div>
            <div class="table_area">
                <table class="m_table">
                    <tr>
                        <th>번호</th>
                        <th>장소명</th>
                        <th style="width:100px">삭제여부</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <% for(Spot ss : list) { %>
                    <tr>
                        <td id="her_no"><%= ss.getS_id() %></td>
                        <td id="her_id"><%= ss.getS_name() %></td>
                        <td id="her_status"><%= ss.getS_status() %></td>
                        <td>
                            <div class="btn_area">
                            <% if( ss.getS_status().equals("Y")) { %>
                                <button class="m_btn" id="m_btn" onclick="banMember(<%= ss.getS_id() %>,'<%= ss.getS_status() %>')">데이터삭제</button>
                            <% } else { %>
                                <button class="m_btn" id="m_btn" onclick="banMember(<%= ss.getS_id() %>,'<%= ss.getS_status() %>')">삭제취소</button>
                            <% } %>
                            </div>
                        </td>
                    </tr>
   					<% } %>
                </table>
                 <script>
                	function banMember(s_id, s_status) {
                		location.href = '/naduri/updateFood.ad?s_id='+ s_id + '&s_status=' + s_status;
                	}
                </script>
		          <div class="insert_btn_area">
		            <button id="insert_btn" onclick="location.href='/naduri/views/admin/adminInsertFood.jsp'">맛집 등록</button>
		         </div>

				
				
				<%-- 페이지네이션 버튼 --%>
                <div class="pagingArea">
		        	<button id="p_btn" onclick="location.href='/naduri/foodList.ad?currentPage=1'">
		        		&lt;&lt;
		        	</button>
		        	
		        	<% if (cur <= 1) { %>
						<button id="p_btn" disabled> &lt; </button>
					<% } else { %>
						<button id="p_btn" onclick="location.href='/naduri/foodList.ad?currentPage=<%= cur - 1 %>'"> &lt;</button>
					<% } %>
		        	
		        	<% for(int p = st ; p <= ed ; p ++) { %>
		        	
			        	<% if( p == cur) { %>
			        		<button id="p_btn" disabled> <%= p %> </button>
			        	<% } else { %>
			        		<button id="p_btn" onclick="location.href='/naduri/foodList.ad?currentPage=<%= p %>'"> <%= p %> </button>
			        	<% } %>
		        	
		        	<% } %>
		        	
		        	<% if (cur >= mx) { %>
						<button id="p_btn" disabled> &gt; </button>
					<% } else { %>
						<button id="p_btn" onclick="location.href='/naduri/foodList.ad?currentPage=<%= cur + 1 %>'"> &gt;</button>
					<% } %>
					
		        	<button id="p_btn" onclick="location.href='/naduri/foodList.ad?currentPage=<%= mx %>'">
		        		&gt;&gt;
		        	</button>
		        	
		        </div>
      				
      			<%-- ------------------- --%>	
            </div>
        </div>
	
	</section>

	<%@ include file="../common/footer.jsp" %>
</body>
</html>