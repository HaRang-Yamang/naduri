<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.heritage.model.vo.*, java.util.*,
com.harang.naduri.jdbc.Thumbnail.model.vo.*" %>
<%
		ArrayList<Heritage> listHeri = (ArrayList<Heritage>)request.getAttribute("listHeri");
		ArrayList<lo_key> lokey = (ArrayList<lo_key>)request.getAttribute("lokey");
		Heritage heri = new Heritage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


		<!-- div.tableArea -->
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<!-- th*6 -->
					<th width="300px;">종목코드</th>
					<th width="300px;">지정번호</th>
					<th width="300px;">시도코드</th>
					<th width="300px;">문화재명</th>
					<th width="300px;">문화재종목</th>
					<th width="300px;">문화재분류</th>
					<th width="300px;">지정(등록일)</th>
					<th width="300px;">소재지 상세</th>
					<th width="300px;">내용</th>
				</tr>
				<% for(Heritage h : listHeri) { %>
				<tr>
					<td><%=h.getH_events() %></td> 
					<td><%=h.getH_serial() %></td>
					<td><%=h.getH_zipcode() %></td>
					<td><%=h.getH_name() %></td>
					<td><%=h.getCcmaName() %></td>
					<td><%=h.getGcodeName() %></td>
					<td><%=h.getCcbaAsdt() %></td>
					<td><%=h.getCcbaLcad() %></td>
					<td><%=h.getLongitude() %></td>


					<td><%=h.getContent() %></td>
<td><%=h.getImageUrl() %></td>
<img src="<%=h.getImageUrl() %>" >
					<% } %>
				</tr>
							</table>

		</div>
				

<% for( Heritage h : listHeri ) { %>		
<div class="infoArea">
	            <!-- 장소 명, 평점, 홈페이지 아이콘, 찜 버튼 -->
	            <div class="infoTitle">
	                <h2>덕수궁</h2>
	                <h2 style="color:var(--main-color);">4.3</h2>
	                <button style="border:none; background : transparent;">
	                    <img src="/naduri/assets/images/icon/homebutton.PNG" id="home">
	                </button>
	                <div class="markIcon" onclick="change();">
	                    <i class="fas fa-star"></i>
	                </div>
	            </div>
	
	            <!-- 키워드 -->
	            <div class="keyword">
	                <ul>
	                    <li>#벚꽃</li>
	                    <li>#궁궐</li>
	                    <li>#문화유산</li>
	                </ul>
	            </div>
	
	<img src="<%=h.getImageUrl() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	            <div class="infoDetailArea">
	                <!-- 테이블-->
	                <div class="infoTable">
	                    <table>
	                        <tr>
	                            <td >소재지</td>
	                            <td><%=h.getCcbaLcad() %></td>
	                        </tr>   
	                        <tr>
	                            <td>전화번호</td>
	                            <td>000-0000</td>
	                        </tr>
	                        <tr>
	                            <td>운영시간</td>
	                            <td>9 a.m - 5.pm</td>
	                        </tr>
	                        <tr>
	                            <td>지정번호</td>
	                            <td><%=h.getH_serial() %></td>
	                        </tr>
	                        <tr>
	                            <td>지정일</td>
	                            <td><%=h.getCcbaAsdt() %></td>
	                        </tr>
	                        <tr>
	                            <td>분류</td>
	                            <td><%=h.getGcodeName() %></td>
	                        </tr>
	                        <tr>
	                            <td>시대</td>
	                            <td><%=h.getCcceName() %></td>
	                        </tr>
	                        <tr>
	                            <td>면적</td>
	                            <td>93,843.1㎡</td>
	                        </tr>
	                        <tr>
	                            <td>소유자</td>
	                            <td><%=h.getCcbaPoss() %></td>
	                        </tr>
	                        <tr>
	                            <td>관리자</td>
	                            <td><%=h.getCcbaAdmin() %></td>
	                        </tr>
	                    </table>
	                </div>
	                <!-- 상세 정보 (텍스트) -->
	                <div class="infoDetail">
	                    <div class="a">
	                        <p>
	                            <%=h.getContent() %>
	                        </p>
	                        <details>
	                            <summary>내용 더보기+</summary>
	                            <div>
	                                <p>
	                                    1904년의 큰 불로 대부분의 건물들이 불에 타 없어지자 서양식 건물인석조전들이 지어지면서, 원래 궁궐 공간의 조화를 잃어버리게 되었다. 그중 가장 큰 변화는 정문이 바뀐 것이다. 덕수궁의 정문은 남쪽에 있던인화문이었는데, 다시 지으면서 동쪽에 있던 대안문을 수리하고 이름도대한문으로 고쳐 정문으로 삼았다.
	                                    비록 조선 후기에 궁궐로 갖추어진 곳이지만, 구한말의 역사적현장이었으며 전통목조건축과 서양식의 건축이 함께 남아있는 곳으로조선왕조의 궁궐 가운데 특이한 위치를 차지하고 있다.
	                                </p>
	                            </div>
	                             
	                        </details>      
	                    </div>
	                </div>
	                
	            </div>
	        </div>
	       <% } %>
		

</body>
</html>