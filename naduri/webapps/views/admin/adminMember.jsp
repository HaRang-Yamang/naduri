<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.harang.naduri.jdbc.notice.model.vo.*, java.util.*"%>    
 
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
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
	#m_btn_ban {
		width : 100px;
	}
	.table_area {
    width: 850px;
    height: auto;
	}
	#m_btn_ban{
	cursor : pointer;
	}

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
                <h2 class="notice_head">회원 관리</h2>
            </div>
            <div class="table_area">
                <table class="m_table">
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>이름</th>
                        <th>연락처</th>
                        <th>이메일</th>
                        <th>상태</th>
                        <th></th>
                        <th colspan='3'>관리</th>
                        <th></th>
                        
                    </tr>
					
					<% for(Member mm : list ) { %> 
                    <tr>
                        <td id="m_no"><%= mm.getM_no() %></td>
                        <td id="m_id"><%= mm.getM_id() %></td>
                        <td id="m_name"><%= mm.getM_name() %></td>
                        <td id="m_phone"><%= mm.getM_phone() %></td>
                        <td id="m_email"><%= mm.getM_email() %></td>
                        <td id="m_status"><%= mm.getM_status() %></td>
                   
                        <td colspan='2'>
                            <div class="btn_area">
                            <% if( mm.getM_status().equals("Y")) { %>
                                <button class="m_btn_ban" id="m_btn_ban" onclick="banMember(<%= mm.getM_no() %>,'<%= mm.getM_status() %>')">이용권한 정지</button>
                            <% } else { %>
                                <button class="m_btn_ban" id="m_btn_ban" onclick="banMember(<%= mm.getM_no() %>,'<%= mm.getM_status() %>')">정지 해제</button>
                            <% } %>
                            </div>
                        </td>
                    </tr>
               		<% } %>
               	
                </table>
                <script>
                	function banMember(m_no, m_status) {
                		location.href = '/naduri/memberUpdate.ad?m_no='+ m_no + '&m_status=' + m_status;
                	}
                </script>
				
				<%-- 페이지네이션 버튼 --%>
                <div class="pagingArea">
		        	<button id="p_btn" onclick="location.href='/naduri/memberList.ad?currentPage=1'">
		        		&lt;&lt;
		        	</button>
		        	
		        	<% if (cur <= 1) { %>
						<button id="p_btn" disabled> &lt; </button>
					<% } else { %>
						<button id="p_btn" onclick="location.href='/naduri/memberList.ad?currentPage=<%= cur - 1 %>'"> &lt;</button>
					<% } %>
		        	
		        	<% for(int p = st ; p <= ed ; p ++) { %>
		        	
			        	<% if( p == cur) { %>
			        		<button id="p_btn" disabled> <%= p %> </button>
			        	<% } else { %>
			        		<button id="p_btn" onclick="location.href='/naduri/memberList.ad?currentPage=<%= p %>'"> <%= p %> </button>
			        	<% } %>
		        	
		        	<% } %>
		        	
		        	<% if (cur >= mx) { %>
						<button id="p_btn" disabled> &gt; </button>
					<% } else { %>
						<button id="p_btn" onclick="location.href='/naduri/memberList.ad?currentPage=<%= cur + 1 %>'"> &gt;</button>
					<% } %>
					
		        	<button id="p_btn" onclick="location.href='/naduri/memberList.ad?currentPage=<%= mx %>'">
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