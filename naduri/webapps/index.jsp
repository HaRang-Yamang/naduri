<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.heritage.model.vo.*
,com.harang.naduri.jdbc.member.model.vo.*
,com.harang.naduri.jdbc.Thumbnail.model.vo.*
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
<script defer src="/naduri/assets/js/icon.js"></script>
       
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
            <input class="search_val"type="text" placeholder="가고 싶은 곳을 검색하세요">
            <div id='searchResult'></div>
            <i class="fas fa-search" aria-hidden="true" onclick="goSearch();"></i>
        </div>

        
    </header>

    <section>

        <div class="main_body">
            <div class="hot_keword">
                <h2>인기명소 골라보기</h2>
                <ul class="tag">
                    <li class="list active" data-filter="All">전체보기</li>
                    <li class="list" data-filter="1">#문화재</li>
                    <li class="list" data-filter="2">#맛집</li>
                    <li class="list" data-filter="2">#여행</li>
                </ul>
            </div>
        </div>

        <div class = "areaList">
            <!-- featured images -->
            <div class="featured">
                <div class="small-container">
					
					
					
                    <div class="row">
                    <% for(int i=0 ; i < lo_key.size(); i++) { %>
                        <div class="hotSpot <%= lo_key.get(i).getLs_code() %>">
                         <% } %>
                         <% for(int i=0 ; i < list2.size(); i++) { %>
                         <% if( list2.get(i).getAttach_name() != null ) { %>
                            <img src="/naduri/resources/thumb/<%= list2.get(i).getAttach_name() %>" id=<%= list2.get(i).getL_no() %>/>
                             
                            <div class="spotInfo">
                                <h4><%= list2.get(i).getAttach_name() %></h4>
                                 <% } %>
                                  <% } %>
                                  
                                  
                                  <!--  썸네일에 따른 태그 값 가져오는 부분 location list 반복 돌리기 -->
                                <% for(int i=0 ; i < lo_key.size(); i++) { %>
                                 <% if( list2.get(i).getAttach_name() != null ) { %>
                                <p>#<%= lo_key.get(i).getKeyword() %></p>
                                <% } %>
                                <% } %>
                            </div>
                            <div class="markIcon">
                                <i class="fas fa-heart"></i>
                            </div>
                        </div>
                    </div>
                   
                    
                </div>
            </div>
            <!-- featured images end -->
        </div>
       



        
    </section>
	
	
	<%@ include file="views/common/footer.jsp" %>
</body>
</html>