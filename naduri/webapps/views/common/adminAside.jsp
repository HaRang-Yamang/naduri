<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <aside>
        <div class="admin_menu_area">
            <ul>
                <li><img src="/naduri/assets/images/icon/admin_img.png" alt=""></li>
                <li id="menu_title">관리자<br>페이지</li>

                <li>
                    <hr id="menu_hr">
                    <ul id="menu_detail">
                        <li><button class="adminMember_btn" onclick="adminmemberLsit();">회원관리</button><li>
                        <li><a>데이터 등록</a></li>
                        <li><a href="/naduri/views/admin/adminHeritage.jsp">문화재</a></li>
                        <li><a href="/naduri/views/admin/adminFood.jsp">맛집</a></li>
                        <li><a href="/naduri/views/admin/adminSpot.jsp">여행지</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        
        <script>
				function adminmemberLsit(){
					location.href = '/naduri/memberList.ad';
				}
	
			
			</script>
    </aside>