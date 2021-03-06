<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ 
	page
	import="com.harang.naduri.jdbc.member.model.vo.*,
		com.harang.naduri.jdbc.location.model.vo.*,
		com.harang.naduri.jdbc.Thumbnail.model.vo.*,
		java.util.*"%>

<%
Member m = (Member) session.getAttribute("member");
ArrayList<Keyword> listK = (ArrayList<Keyword>) session.getAttribute("listK");
ArrayList<Location> lo_key = (ArrayList<Location>) request.getAttribute("lo_key");
%>
<header>
	<!-- 페이지 설명 -->
	<h2 class="hidden">나드리</h2>
	<nav class="navbar">
		<div class="headerArea">
			<h1 class="logo">
				<a href="/naduri"><img
					src="/naduri/assets/images/header/logo.png" alt="나드리 로고"></a>
			</h1>
		</div>

		<div class="profile">
			<img src="/naduri/assets/images/header/profile.png" alt="로그인">

			<!-- profile menu-->
			<%
			if (m == null) {
			%>
			<div class="user_menu">

				<h3>
					<span>로그인이<br> 필요합니다
					</span>
				</h3>
				<ul>
					<li><i class="far fa-edit"></i><button type="button" class="not_btn" onclick="join();">회원가입</button></li>
					<li><i class="fas fa-sign-out-alt"></i><button type="button" class="not_btn" onclick="login();">로그인</button></li>
				</ul>
			</div>
			<%
			} else if (m.getM_auth() == 1) {
			%>
			<div class="user_menu">

				<h3><%=m.getM_name()%>님<br>
					<span>일반회원</span>
				</h3>
				<ul>
					<li><i class="far fa-user-circle"></i><button type="button" class="not_btn" onclick="myPage();">
						내 기행록</button></li>
					<li><i class="far fa-edit"></i><button type="button" class="not_btn" onclick="memberUpdate();">회원정보
							수정</button></li>
					<li><i class="fas fa-sign-out-alt"></i>
					<button type="button" class="not_btn" onclick="logout();">로그아웃</button></li>
				</ul>
			</div>
			<%
			} else if (m.getM_auth() == 0) {
			%>

			<div class="user_menu">

				<h3><%=m.getM_name()%>님<br>
					<span>관리자</span>
				</h3>
				<ul>
					<li><i class="far fa-edit"></i>
					<button type="button" class="not_btn" onclick="adminPage();">관리자페이지</button></li>
					<li><i class="fas fa-sign-out-alt"></i>
					<button type="button" class="not_btn" onclick="logout();">로그아웃</button></li>
				</ul>
			</div>
			<%
			}
			%>
			<script>
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
		</div>

	</nav>

</header>