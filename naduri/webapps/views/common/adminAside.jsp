<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <aside>
        <div class="admin_menu_area">
            <ul>
                <li><img src="/naduri/assets/images/icon/admin_img.png" alt=""></li>
                <li id="menu_title"><h2>관리자<br>페이지</h2></li>

                <li>
                    <hr id="menu_hr">
                    <ul id="menu_detail">
                        <li><button class="adminMember_btn" onclick="adminMemberLsit();">회원관리</button><li>
                        <li><h3>데이터 등록</h3></li>
                        <li><button class="adminHeritage_btn" onclick="adminHeritageLsit();">문화재</button><li>
                        <li><button class="adminHeritage_btn" onclick="adminFoodLsit();">맛집</button><li>
                        <li><button class="adminHeritage_btn" onclick="adminSpotLsit();">여행지</button><li>
                    </ul>
                </li>
            </ul>
        </div>
        
        <script>
				function adminMemberLsit(){
					location.href = '/naduri/memberList.ad';
				}
				function adminHeritageLsit(){
					location.href = '/naduri/heritageList.ad';
				}
				function adminFoodLsit(){
					location.href = '/naduri/foodList.ad';
				}
				function adminSpotLsit(){
					location.href = '/naduri/spotList.ad';
				}
				
			</script>
    </aside>