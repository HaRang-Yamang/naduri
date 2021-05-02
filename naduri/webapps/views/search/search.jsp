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

<!--<div id="map2"><img src="/naduri/assets/images/map.gif"></div> -->  
    <section class="map_box">
        <!-- 지도를 표시할 div 입니다 -->
        <div id="map"> </div>
        
        </section>
			
        <!-- hot keword -->
        <section class="main_body">
            <div class="hot_keword">
            	<h2>검색 결과</h2>
               <div id="s_result">
       	          	<div class="row">    
		            	<div class="hotSpot date">
		          		  	 <img src="/naduri/assets/images/main/featured_img_1.jpg">
		            		 <div class="spotInfo">
			            		 <h4>검색결과</h4>
			            		 <p>#데이트</p> <p>#데이트</p> <p>#데이트</p>
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
            
          	<!-- 장소 개수만큼 장소 정보 썸네일(div) 생성하는 반복문  
			//<% for(Spot p : list) { %>
			        <div class="row">    
		            	<div class="hotSpot date">
		          		  	 <img src="/naduri/assets/images/main/featured_img_1.jpg">
		            		 <div class="spotInfo">
			  //          		 <h4><%= p.getSpot_name() %></h4>
			            		 <p>#데이트</p> <p>#데이트</p> <p>#데이트</p>
		            		 </div>
		           		</div>
		            </div>         			
          	//<% } %>
		-->
            
            </div>
        </div>
       </section>		
		<script>
		
			// 자바 배열을 이용하여 positions 배열을 만드는 반복문
			var positions = [
					<%
					for(Spot s : list){
						out.println("{ content : '"+"<div class="+'"'+"lmark"+'"' +" id="+ '"'+s.getL_no()+'"'+
								"style="+'"'+"text-align:center; width:150px;"+'"' +
								
								">" + s.getSpot_name() + "</div>', "
					   + " latlng: new kakao.maps.LatLng(" + s.getSpot_lat() + ", " + s.getSpot_long() + ") }, ");
					}
					%>
				];
		
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		    mapOption = { 
		        center: new kakao.maps.LatLng(33.51157164405874, 126.51559891138311), // 지도의 중심좌표(제주향교])
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
			
			$('#map').on('mouseup mousewheel', function(){
		
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
					console.log(<%= list.get(0).getSpot_lat() %>);
					
					
						<!-- 장소 개수만큼 장소 정보 썸네일(div) 생성하는 반복문  -->
						
						<% for(Spot s : list) { %>
							
							var sid = <%= s.getSpot_id() %>;
							var slat = <%= s.getSpot_lat() %>;
							var slng = <%= s.getSpot_long() %>;
							var sname = '<%= s.getSpot_name() %>';
							
							
					// console.log(typeof(sname));
						
							if( slat > swlat &&
								slat < nelat &&
								slng > swlng &&
								slng < nelng)
							{
								console.log(sname);
								console.log(slat, slng);
								
								$('#thumbloop').html(
									
									'<div class="row">'+ 
									   '<div class="hotSpot date">'+
									   	'<img src="/naduri/assets/images/main/featured_img_1.jpg">'+
						            		 '<div class="spotInfo">'+
							            		 '<h4>'+sname+'</h4>'+
							            		 '<p>#데이트</p> <p>#데이트</p> <p>#데이트</p>'+
						            		 '</div>'+
						           		'</div>'+
						            '</div>'
								);
									
							}
							
						<% } %>			
					   
			// .ready와 on('mouseup') 을 동시에 적용할 수는 없나?
			// 왜 반복문인데 마지막 혹은 첫번째 html만 나오는지???
			    	},
				    error : function(error){alert("전송 실패");}
			    });
			});
			       
			    
		
		</script>

		
			
		<%@ include file="../common/footer.jsp" %>
</body>
</html>