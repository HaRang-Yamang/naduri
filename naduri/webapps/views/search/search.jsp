<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.harang.naduri.jdbc.spot.model.vo.*, java.util.*, com.harang.naduri.jdbc.heritage.model.vo.*" %>

<%
		ArrayList<Spot> slist = (ArrayList<Spot>)request.getAttribute("slist");
		ArrayList<Heritage> hlist = (ArrayList<Heritage>)request.getAttribute("hlist");
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
<!-- <script defer src="/naduri/assets/js/map.js"></script> -->
<!-- -------------------------------------------------------- -->

<title>나드리</title>
<style>
#s_result{
	width : auto;
	height: auto;

	
}
</style>


</head>
<body>
	<%@ include file="../common/header.jsp" %>    
	
    <div class="search_area">
        <div class="search">
            <input type="text" placeholder="가고 싶은 곳을 검색하세요">
            <i class="fas fa-search" aria-hidden="true"></i>
        </div>
    </div>
    
    <section class="map_box">
        <!-- 지도를 표시할 div 입니다 -->
        
        
        <!-- 검색 결과에서 받아올 값에 따라 결과창에 결과 표시 or 검색 결과 없음 표시하기위한 if 조건문 시작 -->
        <% if(true) { %>
        <div id="map"> </div>
        
        </section>
			
        <!-- hot keword -->
        <section class="main_body">
        
            <div class="hot_keword">
            	<h2>검색 결과</h2>
               <div id="s_result"> <!--  검색 결과 불러오는 div -->
       	          	<div class="row">    
		            	<div class="hotSpot date"> <!-- 클래스명 수정 필 -->
		          		  	 <img src="/naduri/assets/images/main/featured_img_1.jpg">  <!-- 검색한 장소 이미지 불러와야  -->
		            		 <div class="spotInfo">
			            		 <h4>검색결과</h4>  <!--  검색 장소 이름  -->
			            		 <p>#데이트</p> <p>#데이트</p> <p>#데이트</p>  <!-- 검색 장소 연관 키워드 3개 -->
		            		 </div>
		           		</div>
		            </div>       
                </div>
                <h2>주변명소 골라보기</h2>
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
            <div class="small-container" id="thumbloop">
            
          	<!-- 장소 개수만큼 장소 정보 썸네일(div) 생성하는 반복문  -->
			<!-- 
			<% for(Spot p : slist) { %>
			        <div class="row">    
		            	<div class="hotSpot date">
		          		  	 <img src="/naduri/assets/images/main/featured_img_1.jpg">
		            		 <div class="spotInfo">
			            		 <h4><%= p.getS_name() %></h4>
			            		 <p>#데이트</p> <p>#데이트</p> <p>#데이트</p>
		            		 </div>
		           		</div>
		            </div>         			
          	<% } %>
		 	-->
            
            </div>
        </div>
        
        <!-- 만약 검색 결과가 없을 때 나오는 else 구문 -->
        <% } else { %>
        	
        	<div class='not_found'>
        	<p class='not_found_message'> 
        		   나드리 데이터베이스에서 검색 결과를 찾을 수 없습니다.<br>
        		   문화재, 음식점, 여행지 이름으로 다시 검색해 주세요.</p>
        	</div>
        	
        <% } %>
       </section>
       
       		
		<script>
			$(function(){
				// 자바 배열을 이용하여 positions 배열을 만드는 반복문
				var positions = [
						<%
						for(Spot s : slist){
							out.println("{ content : '"+"<div class="+'"'+"lmark"+'"' +" id="+ '"'+s.getL_no()+'"'+
									"style="+'"'+"text-align:center; width:150px;"+'"' +
									
									">" + s.getS_name() + "</div>', "
						   + " latlng: new kakao.maps.LatLng(" + s.getS_lat() + ", " + s.getS_lng() + ") }, ");
						}
						%>
					];
			
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
			    mapOption = { 
			        center: new kakao.maps.LatLng(<%= slist.get(0).getS_lat() +", " + slist.get(0).getS_lng()%>), // 지도의 중심좌표(제주향교])
			        level: 4 // 지도의 확대 레벨
			        
			    };
				
				var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다					
						
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
				var myFunc = function(){
			
					var center = map.getCenter(); 
				    var bounds = map.getBounds();
				    var swLatLng = bounds.getSouthWest();
				    var neLatLng = bounds.getNorthEast();
				    var boundsStr = bounds.toString();
				    			    
				    var message = '지도 중심좌표는 위도 ' + center.getLat() + ', <br>';
				    message += '경도 ' + center.getLng() + ' 이고 <br>';
				    message += '남서쪽 좌표 ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + '///';
				    message += '북동쪽 좌표 ' + neLatLng.getLat() + ', ' + neLatLng.getLng();
				    
				    console.log(message);
				    
				    $.ajax({
				    	url : "/naduri/currlatlng.lo",
						type : "get",
						data : { 
								swlat : swLatLng.getLat(),
								swlng : swLatLng.getLng(),
								nelat : neLatLng.getLat(),
								nelng : neLatLng.getLng(),
						},
						success : function(data){						
						console.log(data);
						
						swlat = data.swlat;
						swlng = data.swlng;
						nelat = data.nelat;
						nelng = data.nelng;
						
						
						console.log(swlat +',' +swlng+',' +nelat+',' +nelng);
						
						
							<!-- 장소 개수만큼 장소 정보 썸네일(div) 생성하는 반복문  -->
							var sidArr =  [];
							var slatArr = [];
							var slngArr = [];
							var snameArr = [];
							
							
							<% for(Spot s : slist) { %>
								
							slatArr.push(<%= s.getS_lat() %>);
							slngArr.push(<%= s.getS_lng() %>);
							snameArr.push('<%= s.getS_name() %>');
							<% } %>	
							
							
							$('#thumbloop').html('');
							for(var i in snameArr, slatArr, slngArr){
								
								if( slatArr[i] > swlat &&	
									slatArr[i] < nelat &&
									slngArr[i] > swlng &&
									slngArr[i] < nelng)	
									{	
									console.log(snameArr[i]);
									 
									$('#thumbloop').html($('#thumbloop').html() +
											
											'<div class="row">'+ 
											   '<div class="hotSpot date">'+
											   	'<img src="/naduri/assets/images/main/featured_img_1.jpg">'+
								            		 '<div class="spotInfo">'+
									            		 '<h4>'+snameArr[i]+'</h4>'+
									            		 '<p>#데이트</p> <p>#데이트</p> <p>#데이트</p>'+
								            		 '</div>'+
								           		'</div>'+
								            '</div>'
										);
									}
								};
			    	},
					    error : function(error){alert("전송 실패");}
				    });
				};
				$('#map').on('mouseup mousewheel mouseleave', myFunc);
				myFunc();
				
				// myFunc()은 페이지 바로 시작과 on 이벤트를 모두 실행하고자 하여 변수로 선언한 것
			}); 
			
			    
		
		</script>
		
	<aside><div id="topBtn" href="#">TOP</div></aside>			

	<script>
    $(function() {
       
        
        $("#topBtn").click(function() {
            $('html, body').animate({
                scrollTop : 0
            }, 400);
            return false;
        });
    });
	</script>

		
			
		<%@ include file="../common/footer.jsp" %>
</body>
</html>