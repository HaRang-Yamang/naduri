<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="com.harang.naduri.jdbc.notice.model.vo.*, java.util.*"
 %>
    
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
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
<link rel="stylesheet" href="/naduri/assets/css/notice.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>공지사항 목록</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>

        <div class="noticeListArea">
            <div class="head_area">
                <h2 class="notice_head">공지사항</h2>
            </div>
            <div class="table_area">
                <table class="notice_table" id="listArea">
                    <tr>
                        <th id="notice_no">글번호</th>
                        <th id='notice_title'>제목</th>
                        <th id='notice_writer'>작성자</th>
                        <th id='notice_date'>날짜</th>
                    </tr>
                    <% for(Notice n : list) { %>             
                    <tr>
                        <td>
                            <span id="<%= n.getN_no() %>"><%= n.getN_no() %></span>
                        </td>
                        <td>
                            <span class="notice_title">
                                <%= n.getN_title() %>
                            </span>
                        </td>
                        <td>
                            <span class="notice_writer">관리자</span>
                        </td>
                        <td>
                            <span class="write_date"><%= n.getN_date() %></span>
                        </td>
                    </tr>
                    <% } %>
               
                </table>
                
                <div class="submit_btn_area">
                <% if( m != null && m.getM_auth() == 0 ) { %>
                <button class="submit_btn" type="submit" style="cursor: pointer;" onclick="location.href='views/notice/noticeWrite.jsp'">작성하기</button>
               
                <% } %>
                
	                <%-- 페이지네이션 버튼 --%>
	                <div class="pagingArea">
			        	<button id="p_btn" onclick="location.href='/naduri/selectList.no?currentPage=1'">
			        		&lt;&lt;
			        	</button>
			        	
			        	<% if (cur <= 1) { %>
							<button id="p_btn" disabled> &lt; </button>
						<% } else { %>
							<button id="p_btn" onclick="location.href='/naduri/selectList.no?currentPage=<%= cur - 1 %>'"> &lt;</button>
						<% } %>
			        	
			        	<% for(int p = st ; p <= ed ; p ++) { %>
			        	
				        	<% if( p == cur) { %>
				        		<button id="p_btn" disabled> <%= p %> </button>
				        	<% } else { %>
				        		<button id="p_btn" onclick="location.href='/naduri/selectList.no?currentPage=<%= p %>'"> <%= p %> </button>
				        	<% } %>
			        	
			        	<% } %>
			        	
			        	<% if (cur >= mx) { %>
							<button id="p_btn" disabled> &gt; </button>
						<% } else { %>
							<button id="p_btn" onclick="location.href='/naduri/selectList.no?currentPage=<%= cur + 1 %>'"> &gt;</button>
						<% } %>
						
			        	<button id="p_btn" onclick="location.href='/naduri/selectList.no?currentPage=<%= mx %>'">
			        		&gt;&gt;
			        	</button>
			        	
			        </div>
		        </div>
      				
      			<%-- ------------------- --%>	
      				
      			<script>
               		$('#listArea td').on('mouseenter', function(){
               			$(this).parent().css({'background' : 'rgba(178, 191, 80, 0.1)', 'cursor' : 'pointer'});
               		}).on('mouseout', function(){
               			$(this).parent().css({'background' : 'white'});
               		}).on('click', function() {
               			var n_no = $(this).parent().children().first().children().attr('id');
               			
               			//console.log(n_no);
               			location.href = "/naduri/selectOne.no?n_no=" + n_no;
               		});
               	</script>
      
            </div>
        </div>
        
     

	</section>		
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>