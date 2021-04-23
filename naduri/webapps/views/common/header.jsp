<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<header>
    <!-- 페이지 설명 -->
    <h1 class="hidden">나드리</h1>

    <nav class="navbar">
        <div class="headerArea">
            <a href="/naduri/index.jsp"><img src="/naduri/assets/images/header/logo.png" alt="나드리 로고"></a>
        </div>
        <div class="profile">
            <img src="/naduri/assets/images/header/profile.png" alt="로그인" >
            <!-- profile menu-->
            <div class="user_menu">
                <h3>Someone<br><span>일반회원</span></h3>
                <ul>
                    <li><i class="far fa-user-circle"></i><a href="/naduri/views/myPage.jsp">내 기행록</a></li>
                    <li><i class="far fa-edit"></i><a href="/naduri/views/member/modifyMember.jsp">회원정보 수정</a></li>
                    <li><i class="fas fa-sign-out-alt"></i><a href="">로그아웃</a></li>
                </ul>
            </div>
        </div>
    </nav>

</header>