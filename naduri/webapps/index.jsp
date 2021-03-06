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

	ArrayList<lo_key> list = (ArrayList<lo_key>)request.getAttribute("list"); //키워드
   
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
                    <li><i class="far fa-edit"></i><button type="button" class="not_btn" onclick="join();">회원가입</button></li>
                    <li><i class="fas fa-sign-out-alt"></i><button type="button" class="not_btn" onclick="login();">로그인</button></li>
                </ul>
            </div>

      <% } else if ( m.getM_auth() == 1  ) { %>
         <div class="user_menu">

                <h3><%= m.getM_name() %>님<br><span>일반회원</span></h3>
                <ul>
                    <li><i class="far fa-user-circle"></i><button type="button" class="not_btn" onclick="myPage();">내 기행록</button></li>
                    <li><i class="far fa-edit"></i><button type="button" class="not_btn" onclick="memberUpdate();">회원정보 수정</button></li>
                    <li><i class="fas fa-sign-out-alt"></i><button type="button" class="not_btn" onclick="logout();">로그아웃</button></li>
                </ul>
            </div>

            <% } else if ( m.getM_auth() == 0 ) { %>


            <div class="user_menu">


                <h3><%= m.getM_name() %>님<br><span>관리자</span></h3>
                <ul>
                    <li><i class="far fa-edit"></i><button type="button" class="not_btn" onclick="adminPage();">관리자페이지</button></li>
                    <li><i class="fas fa-sign-out-alt"></i><button type="button" class="not_btn" onclick="logout();">로그아웃</button></li>
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

            <input type="text" placeholder="가고 싶은 곳을 검색하세요(경복궁, 독립문, 흥인지문)" id="sLoc">
            <i class="fas fa-search" aria-hidden="true"></i>

            <input class="search_val"type="text" placeholder="가고 싶은 곳을 검색하세요(예. 경복궁, 독립문, 흥인지문)">
            <div id='searchResult'></div>
            <i class="fas fa-search" aria-hidden="true"></i>

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
                    <li class="list" data-filter="3">#여행</li>
                </ul>
            </div>
        </div>

       
 <!-- featured images -->
        <div class="featured">
            <div class="small-container">
            
<% for(int i=0 ; i < list.size(); i++) { %>
                <div class="hotSpot <%= list.get(i).getLs_code() %>" id="<%= list.get(i).getLocal_name() %>" name="spotName">
                   <img src="/naduri/resources/thumb/<%= list.get(i).getA_name() %>"/>

                    <div class="spotInfo">
                    <h4><%= list.get(i).getLocal_name() %></h4>

					 <% for(String k : list.get(i).getKeyword()) { %>
					 <p>#<%= k %> </p>
	                 <% } %>

                    </div>
                    
                </div>

  <% } %> <!-- for문 end -->            
</div>



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
	              
	               if (event.keyCode == 13) {
	                  var spotName = $(this).val();
	                  /* alert($(".search_val").val()); */
	                   location.href = "/naduri/goresult.sr?spotName=" + spotName;
	                  
	               }
	           });
	        });
	    
	    
	    // selectOne
	    $('.hotSpot').on('click', function(){
	    	var spotName = $(this).attr('id');
			
			location.href = "/naduri/CallApiDetail.do?spotName=" + spotName;
		});


	function join(){
		location.href="/naduri/views/member/joinMember.jsp"
	}
	function login(){
		location.href = '/naduri/views/login.jsp';
	}
	function myPage(){
		location.href='/naduri/myPage.do';
	}
	function memberUpdate(){
		location.href = '/naduri/views/member/modifyMember.jsp';
	}
	function logout() {
		location.href = '/naduri/logout.do';
	}
	function adminPage() {
		location.href = '/naduri/memberList.ad';

	}

    </script>
   
   
   <%@ include file="views/common/footer.jsp" %>
</body>
</html>