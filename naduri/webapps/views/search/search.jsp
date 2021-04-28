<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.harang.naduri.jdbc.spot.model.vo.*, java.util.*" %>
<%
	ArrayList<Spot> list = (ArrayList<Spot>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="/naduri/assets/images/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/main_body.css" />
<link rel="stylesheet" href="/naduri/assets/css/search.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />


<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>

<!-- 지도 api 사용 위한 스크립트 영역 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6005fc94dc9f6c5072c2ef8a64151536"></script>
<script defer src="/naduri/assets/js/map.js"></script>
<!-- -------------------------------------------------------- -->

<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>    
	
    <div class="search_area">
        <div class="search">
            <input type="text" placeholder="가고 싶은 곳을 검색하세요">
            <i class="fas fa-search" aria-hidden="true"></i>
        </div>
    </div>

<!--<div id="map2"><img src="/naduri/assets/images/map.gif"></div> -->  
    <section class="map_box">
        <!-- 지도를 표시할 div 입니다 -->
        <div id="map"> </div>
        

        </section>
                
        <section>
        <!-- 위치 정보 -->
       <!--  <div class="info">
                <div class="title">
	                <ul id="location_title">
	                    <li id="list_title">위치</li>
	                    <li>주소</li>
	                    <li>전화번호</li>
	                    <li>영업시간</li>
	                    <li>웹사이트</li>
	                </ul>
                </div>

                <div class="data">
                    <ul id="location_data">
                        <li id="list_title">none</li>
                        <li>서울 종로구 율곡로 99</li>
                        <li>02-762-8261</li>
                        <li>9 a.m - 5 p.m.</li>
                        <li><i class="fas fa-home"></i></li>
                    </ul>
                </div>
        </div> -->

        <!-- 주변 둘러보기 -->
        <!-- 주변 둘러보기 삭제하기로 하여 주석 처리
       <div class="info">
            <div class="other">
            <div id="location_title">
                <h3 id="list_title">주변 둘러보기</h3>

                <div class="spot_container">

                    spot1
                <div class="other_spot">
                <div class="spot_image"><img src="/naduri/assets/images/spot_img_1.jpg"></div>

                <div class="otehr_info">
                    <h4>토속촌 삼계탕</h4>
                    <p class="rank"> 평점 </p>

                    
                    <ul class="tag">
                        <li class="tag_list">#데이트</li>
                        <li class="tag_list">#궁궐</li>
                        <li class="tag_list">#역사</li>
                    </ul>

                        <p> 걸어서 7분 </p>
                </div>
                </div>

                    spot2
                <div class="other_spot">
                    <div class="spot_image"><img src="/naduri/assets/images/spot_img_2.jpg"></div>

                    <div class="otehr_info">
                        <h4>토속촌 삼계탕</h4>
                        <p class="rank"> 평점 </p>
    
                        
                            <ul class="tag">
                                <li class="tag_list">#데이트</li>
                                <li class="tag_list">#궁궐</li>
                                <li class="tag_list">#역사</li>
                            </ul>
    
                            <p> 걸어서 7분 </p>
                    </div>
                    </div>
	        </div>
            </div>
            </div>
    	</div> -->
   		</section>
	
        <!-- hot keword -->
        <section class="main_body">
            <div class="hot_keword">
                <h2>주변명소 골라보기
                 
                </h2>
                <ul class="tag">
                    <li class="list active" data-filter="All">전체보기</li>
                    <li class="list" data-filter="date">#데이트</li>
                    <li class="list" data-filter="palace">#궁궐</li>
                    <li class="list" data-filter="heritage">#역사</li>
                </ul>
            </div>

    </section>

    <section>
        <!-- featured images -->
        <div class="featured">
            <div class="small-container">
            
          	<!-- 장소 개수만큼 장소 정보 썸네일(div) 생성하는 반복문  -->

 			<% for(Spot p : list) { %>
            <div class="row">    
            	<div class="hotSpot date">
          		  	 <img src="/naduri/assets/images/main/featured_img_1.jpg">
            		 <div class="spotInfo">
	            		 <h4><%= p.getSpot_name() %></h4>
	            		 <p>#데이트</p> <p>#데이트</p> <p>#데이트</p>
            		 </div>
           		</div>
            </div>
			<% } %>
            
            </div>
        </div>
       </section>
       
       <script>
			$(function(){		
				$.ajax({
					url : '/naduri/getloc.sp',
					type : 'get',
					success: function( data ) {
						console.log(data);
					},
					error : function( error ) { }
				});
			});
		</script>
		
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		    mapOption = { 
		        center: new kakao.maps.LatLng(<%= list.get(0).getSpot_lat() %>, <%= list.get(0).getSpot_long() %>), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
		
			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			 
			// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
			var positions = [
			    {
			        content: '<div><%= list.get(0).getSpot_name() %><div>', 
			        latlng: new kakao.maps.LatLng(<%= list.get(0).getSpot_lat() %>, <%= list.get(0).getSpot_long() %>)
			    },
			   
			];
			
		
			<%-- 자바스크립트 반복문 무엇.,.,
				var positions = [
				for(Spot s : list){
				    content: '<div><%= s.getSpot_name() %><div>', 
			        latlng: new kakao.maps.LatLng(<%= s.getSpot_lat() %>, <%= s.getSpot_long()%>)
			    }
			 ]; --%>

			for (var i = 0; i < positions.length; i ++) {
			    // 마커를 생성합니다
			    var marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: positions[i].latlng // 마커의 위치
			    });
		
			    // 마커에 표시할 인포윈도우를 생성합니다 
			    var infowindow = new kakao.maps.InfoWindow({
			        content: positions[i].content // 인포윈도우에 표시할 내용
			    });
		
			    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
			    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
			    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
			    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
			    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
			}
		
			// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
			function makeOverListener(map, marker, infowindow) {
			    return function() {
			        infowindow.open(map, marker);
			    };
			}
		
			// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
			function makeOutListener(infowindow) {
			    return function() {
			        infowindow.close();
			    };
			}
		</script>
       
    
		
			
		<%@ include file="../common/footer.jsp" %>
</body>
</html>