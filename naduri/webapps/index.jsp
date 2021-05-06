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
	
	ArrayList<lo_key> keyword = (ArrayList<lo_key>)request.getAttribute("keyword");
	ArrayList<lo_key> spotlo = (ArrayList<lo_key>)request.getAttribute("spotlo");
	
	HashMap<String, Object> map = (HashMap<String, Object>)request.getAttribute("map");
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
                <h1><a href="/naduri"><img src="/naduri/assets/images/logo_big.png" alt="로고 이미지"></a></h1>
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

		<% } else if ( m.getM_auth() == 1  ) { %>
			<div class="user_menu">

                <h3><%= m.getM_name() %>님<br><span>일반회원</span></h3>
                <ul>
                    <li><i class="far fa-user-circle"></i><a href="/naduri/myPage.do">내 기행록</a></li>
                    <li><i class="far fa-edit"></i><a href="/naduri/views/member/modifyMember.jsp">회원정보 수정</a></li>
                    <li><i class="fas fa-sign-out-alt"></i><button type="button" onclick="logout();">로그아웃</button></li>
                </ul>
            </div>

            <% } else if ( m.getM_auth() == 0 ) { %>

                  			<div class="user_menu">

                <h3><%= m.getM_name() %>님<br><span>관리자</span></h3>
                <ul>
                    <li><i class="far fa-edit"></i><button type="button" onclick="adminPage();">관리자페이지</button></li>
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
            
<% if( spotlo != null ) { %>	         
<% for(int i=0 ; i < spotlo.size(); i++) { %>	
            <div class="row">
                <div class="hotSpot date">
                   <img src="/naduri/resources/thumb/ <%=spotlo.get(i).getA_name() %>"/>

                    <div class="spotInfo">
                    <h4><%=spotlo.get(i).getLocal_name() %></h4>
                    
					 <% for( lo_key k : keyword) { %>
					 <% if( k.getL_no() == spotlo.get(i).getL_no()) { %>
                    <p>#<%=k.getKeyword() %></p>
					 <% } %>
                     <% } %>
                    </div>
                    <div class="markIcon"><i class="fas fa-heart"></i></div>
                </div>
           
             
              
</div>

<% } %> <!-- for문 end -->
<% } %>  <!-- if문 end -->
</div>
<!--  featured images end -->


     
    </section>
    <script>
    
	/**
	 * author : dababy
	 * e-mail : pieta2529@gmail.com
	 * last-update : 2021-05-06 p.m. 12:37
	 * comment : 사용자가 검색하는 장소명을 검색 페이지로 넘깁니다. 이 때, submit 이벤트는 Enter 값으로 인식합니다.
	 * 
	 * 
	 * **/
	 
    $(document).ready(function() {
        $(".search_val").keydown(function(key) {
            if (key.keyCode == 13) {
            	alert($(".search_val").val());
            	/* $(".search_val").val().href = "" */
            }
        });
    });
    
    function adminPage(){
        location.href='/naduri/memberList.ad';
     }

    </script>
	
	
	<%@ include file="views/common/footer.jsp" %>
</body>
</html>