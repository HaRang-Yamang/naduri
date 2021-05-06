<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.harang.naduri.jdbc.spot.model.vo.*, java.util.*, com.harang.naduri.jdbc.heritage.model.vo.*" %>

<%
		ArrayList<Spot> slist = (ArrayList<Spot>)request.getAttribute("slist");
		ArrayList<Heritage> hlist = (ArrayList<Heritage>)request.getAttribute("hlist");
		Heritage heri = new Heritage();
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
		            	<div class="hotSpot heritage food spot"> <!-- 클래스명 수정 필 -->
		          		  	 <img src="/naduri/assets/images/main/featured_img_1.jpg">  <!-- 검색한 장소 이미지 불러와야  -->
		            		 <div class="spotInfo">
			            		 <h4><%= heri.getH_name() %></h4>  <!--  검색 장소 이름  -->
			            	 </div>
		           		</div>
		            </div>       
                </div>
                <h2>주변명소 골라보기</h2>
                <ul class="tag">
                    <li class="list active" data-filter="All">전체보기</li>
                    <li class="list" data-filter="heritage">#문화재</li>
                    <li class="list" data-filter="food">#맛집</li>
                    <li class="list" data-filter="spot">#여행지</li>
                </ul>
                      
            </div>

    </section>

    <section>
        <!-- featured images -->
        <div class="featured">
            <div class="small-container" id="thumbloop">
            
          	<!-- 장소 개수만큼 장소 정보 썸네일(div) 생성하는 반복문  -->
		<!-- 	<% for(Spot p : slist) { %>
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
						for(Heritage h : hlist){
							out.println("{ content : '"+"<div class="+'"'+"lmark"+'"' +" id="+ '"'+h.getL_no()+'"'+
									"style="+'"'+"text-align:center; width:150px;"+'"' +
									
									">" + h.getH_name() + "</div>', "
						   + " latlng: new kakao.maps.LatLng(" + h.getH_lat() + ", " + h.getH_lng() + ") }, ");
						}

						
						for(Spot s : slist){
							out.println("{ content : '"+"<div class="+'"'+"lmark"+'"' +" id="+ '"'+s.getL_no()+'"'+
									"style="+'"'+"text-align:center; width:150px;"+'"' +
									
									">" + s.getS_name() + "</div>', "
						   + " latlng: new kakao.maps.LatLng(" + s.getS_lat() + ", " + s.getS_lng() + ") }, ");
						}
						%>
					];
				
				console.log(positions); // 배열에 전부 담기 성공.
				
			
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
			    mapOption = { 
			        center: new kakao.maps.LatLng(<%= heri.getLatitude()+", "+ heri.getLongitude() %> ), // 지도의 중심좌표
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
							
							
							
							var idArr = [];
							var latArr = [];
							var lngArr = [];
							var nameArr = [];
							
							<% for(Heritage h : hlist) { %>
							
							idArr.push(<%= h.getL_no() %>);
							latArr.push(<%= h.getH_lat() %>);
							lngArr.push(<%= h.getH_lng() %>);
							nameArr.push('<%= h.getH_name() %>');
							<% } %>	
							
							<% for(Spot s : slist) { %>
							
							idArr.push(<%= s.getL_no() %>);
							latArr.push(<%= s.getS_lat() %>);
							lngArr.push(<%= s.getS_lng() %>);
							nameArr.push('<%= s.getS_name() %>');
							<% } %>	
							
							
							
							
							$('#thumbloop').html('');
							for(var i in nameArr, latArr, lngArr, idArr){
								
								if( latArr[i] > swlat &&	
									latArr[i] < nelat &&
									lngArr[i] > swlng &&
									lngArr[i] < nelng)	
									{	
									console.log(idArr[i]);
							//		var imgSelector = '';
									
						//		   	if(idArr[i] < 500){
							//	   		imgSelector = '<img src="/naduri/resources/thumb/1.jpg">';
								//   	} else if(idArr[i] <1000){
								   		imgSelector = '<img src="/naduri/resources/thumb/5.jpg">';
							//	   	} else {
							//	   		imgSelector = '<img src="/naduri/resources/thumb/3.jpg">';
							//	   	}
								
									if(idArr[i] < 500){
										$('#thumbloop').html( $('#thumbloop').html() +
										<!--	'<div style="height:300; width:300;">'+ -->
												'<div class="row">'+ 
												   '<div class="hotSpot heritage" id="'+idArr[i]+'">'+
												    imgSelector +
												   	'<div class="spotInfo">'+
										            		 '<h4>'+nameArr[i]+'</h4>'+
										            		 '<p>#문화재</p> <p>#데이트</p> <p>#데이트</p>'+
									            		 '</div>'+
									           		'</div>'+
									            '</div>'
									       <!--    '</div>' -->
									            );
									} else if(idArr[i] < 1000)
								            
								               
								     <!-- onclick="location.href=\'/naduri/CallApiDetailSelectOneCollection.do?l_no=' + idArr[i] + '\'--> 
										
								    	
								    else if(idArr[i] < 1000){
						   		$('#thumbloop').html( $('#thumbloop').html() +
										'<div class="row">'+ 
										   '<div class="hotSpot food" id="'+idArr[i]+'">'+
										   	'<img src="/naduri/resources/thumb/5.jpg">'+
							            		 '<div class="spotInfo">'+
								            		 '<h4>'+nameArr[i]+'</h4>'+
								            		 '<p>#맛집</p> <p>#데이트</p> <p>#데이트</p>'+
							            		 '</div>'+
							           		'</div>'+
							            '</div>'
							            );
						     		
						   	} else { 
						   		$('#thumbloop').html( $('#thumbloop').html() +
										'<div class="row">'+ 
										   '<div class="hotSpot spot" id="'+idArr[i]+'">'+
										   	'<img src="/naduri/resources/thumb/3.jpg">'+
							            		 '<div class="spotInfo">'+
								            		 '<h4>'+nameArr[i]+'</h4>'+
								            		 '<p>#여행지</p> <p>#데이트</p> <p>#데이트</p>'+
							            		 '</div>'+
							           		'</div>'+
							            '</div>'
							            );
						     	} -->
								
									} // if close
							$('.hotSpot').each(function(){
								var daniel_no = $(this).attr('id');
								location.href='/naduri/CallApiDetail.do?spotName='+daniel_no;
								});  // function close
							
							} // for close
				   	}, // success close(Ajax)
				    function(error){alert("전송 실패");}
					    } //error close
				    }); // Ajax close
				};
				
				
				
				$('#map').on('mouseup mousewheel mouseleave', myFunc);
				myFunc();
								// myFunc()은 페이지 바로 시작과 on 이벤트를 모두 실행하고자 하여 변수로 선언한 것
			
								
			}); //function close
			
			    
		
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