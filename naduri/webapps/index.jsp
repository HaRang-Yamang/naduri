<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.heritage.model.vo.*
,com.harang.naduri.jdbc.member.model.vo.*
,com.harang.naduri.jdbc.Thumbnail.model.vo.*
,com.harang.naduri.jdbc.attach.model.vo.*
,com.harang.naduri.jdbc.location.model.vo.*
, java.util.*" %>
<%
	Member m = (Member)session.getAttribute("member");
	
	// spot 정보
	ArrayList<Thumbnail> list = (ArrayList<Thumbnail>)request.getAttribute("list");
	// Heritage 정보
	ArrayList<Heritage> listHeri = (ArrayList<Heritage>)request.getAttribute("listHeri");
	// 첨부파일 정보
	ArrayList<Attach> list2 = (ArrayList<Attach>)request.getAttribute("list2");
	// Location & Keyword 정보
	ArrayList<Location> lo_key = (ArrayList<Location>)request.getAttribute("lo_key");
	
	ArrayList<lo_key> lokey = (ArrayList<lo_key>)request.getAttribute("lokey");
	
	
	Heritage heri = new Heritage();

	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/main.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<!-- <script defer src="/naduri/assets/js/icon.js"></script> -->
       
<title>나드리</title>
</head>
<body>

	<header>
        <h2 class="hidden">나드리</h2>

        <nav class="navbar">
            <div></div> <!-- 지우지 마세요. -->
            <div class="logo">
                <h1><a href="/naduri/index.jsp"><img src="/naduri/assets/images/logo_big.png" alt="로고 이미지"></a></h1>
            </div>

            <div class="profile">
                <img src="/naduri/assets/images/header/profile.png" alt="로그인" >

            <!-- profile menu-->
        <% if ( m == null) { %>
            <div class="user_menu">

                <h3><span>로그인이<br> 필요합니다</span></h3>
                <ul>
                    <li><i class="far fa-edit"></i><a href="/naduri/views/member/joinMember.jsp">회원가입</a></li>
                    <li><i class="fas fa-sign-out-alt"></i><a href="/naduri/views/login.jsp">로그인</a></li>
                </ul>
            </div>
		<% } else if ( m.getM_id() == "0"  ) { %>
			<div class="user_menu">

                <h3><%= m.getM_name() %>님<br><span>일반회원</span></h3>
                <ul>
                    <li><i class="far fa-user-circle"></i><a href="/naduri/views/myPage/myPage.jsp">내 기행록</a></li>
                    <li><i class="far fa-edit"></i><a href="/naduri/views/member/modifyMember.jsp">회원정보 수정</a></li>
                    <li><i class="fas fa-sign-out-alt"></i><button type="button" onclick="logout();">로그아웃</button></li>
                </ul>
            </div>
            <% } else if ( m.getM_id() == "1" ) { %>
                  			<div class="user_menu">

                <h3><%= m.getM_name() %>님<br><span>관리자</span></h3>
                <ul>
                    <li><i class="far fa-user-circle"></i><a href="/naduri/views/myPage/myPage.jsp">내 기행록</a></li>
                    <li><i class="far fa-edit"></i><a href="/naduri/views/member/modifyMember.jsp">회원정보 수정</a></li>
                    <li><i class="fas fa-sign-out-alt"></i><button type="button" onclick="logout();">로그아웃</button></li>
                </ul>
            </div>
                <% }  %>          
           <script>
           	function logout(){
           		location.href='/naduri/logout.do';
           	}
           </script>
            </div>    
        </nav>

        <div class="main_typo">
            <p>지금은 떠나야 할 때!</p> <br><br>
            <p>역사와 함께하는 핫 플레이스</p>
        </div>

        <div class="search">

            <input type="text" placeholder="가고 싶은 곳을 검색하세요" id="sLoc">
            <i class="fas fa-search" aria-hidden="true"></i>

            <input class="search_val"type="text" placeholder="가고 싶은 곳을 검색하세요">
            <div id='searchResult'></div>
            <i class="fas fa-search" aria-hidden="true" onclick="goSearch();"></i>

        </div>

        
    </header>

    <section>

       
 <!-- featured images -->
        <div class="featured">
            <div class="small-container">
			<% for(lo_key l : lokey) { %>
            <div class="row">
                <div class="hotSpot date">
                   <img src="/naduri/resources/thumb/ <%=l.getA_name() %>"/>

                    <div class="spotInfo">
                    <h4><%=l.getLocal_name() %></h4>
                    
                    <% for( int z = 0 ; z < l.getKeyword().length() ; z++ ) { %>
                    <p>#<%=l.getKeyword() %></p>
                     <% } %>
                     
                    </div>
                    <div class="markIcon"><i class="fas fa-heart"></i></div>
                </div>
               
</div>
 <% } %>
</div>
<!--  featured images end -->


        
    </section>
    <script>
    
    $(document).ready(function() {
        $(".search_val").keydown(function(key) {
            if (key.keyCode == 13) {
            	$(".search_val").val().href = ""
            }
        });
    });

    </script>
	
	
	<%@ include file="views/common/footer.jsp" %>
</body>
</html>