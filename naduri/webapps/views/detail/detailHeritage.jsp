<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import="com.harang.naduri.jdbc.heritage.model.vo.*, java.util.*,
com.harang.naduri.jdbc.Thumbnail.model.vo.*,
com.harang.naduri.jdbc.attach.model.vo.*" %>
<%
		ArrayList<Heritage> listHeri = (ArrayList<Heritage>)request.getAttribute("listHeri"); // 문화재 정보 저장 객체
		ArrayList<lo_key> keyword = (ArrayList<lo_key>)request.getAttribute("keyword"); // 키워드가 여러개일 경우를 위한 객체
		ArrayList<lo_key> spotlo = (ArrayList<lo_key>)request.getAttribute("spotlo"); // location and keyword 썸네일 필요한 부분만을 위한 통합 vo
		
		ArrayList<Thumbnail> list = (ArrayList<Thumbnail>)request.getAttribute("list"); // 맛집과 여행지 정보 저장 객체
		ArrayList<Attach> list2 = (ArrayList<Attach>)request.getAttribute("list2"); // 첨부파일 저장 객체
		ArrayList<lo_key> lokey = (ArrayList<lo_key>)request.getAttribute("lokey"); // 장소와 키워드 정보 저장 객체
		
		
		HashMap<String, Object> map = (HashMap<String, Object>)request.getAttribute("map");
		Heritage heri = listHeri.get(0);
		
		int sendL_no = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/detail.css" />
<link rel="stylesheet" href="/naduri/assets/css/slide.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"  
        integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" 
            integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
            
<script type="text/javascript" src="/naduri/assets/js/tab.js"></script>
<style>
	/* 헤더 살리기 프로젝트 ver 2.0 */
	header .navbar {
    	display: flex;
    	justify-content: space-between;
    	align-items: inherit;
    	padding-top: 0px;
	}
	header .navbar .user_menu{
		width : 150px;
		height : 240px;
	}
	header .navbar .user_menu li{
		position : relative;
		left : -38px;
		width : 110px;
		text-align : center;
	}
	header .profile {
	 	margin : 0;
	}
	header .headerArea {
		margin : 0;
	}
	
	img, svg {
    	vertical-align: baseline;
	}

</style>


<title>나드리</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
	
		<div class="detailArea_heritage">
	
	        <h2 class="hidden">상세페이지</h2>
	        
<% if( spotlo != null ) { %>	  
 <% sendL_no = spotlo.get(0).getL_no(); %>       
 <% for(lo_key l : spotlo) { %>
	                    	
	 <div class="slider-images">
	            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" style="width: 1000px;">
	                <div class="carousel-indicators" style="margin-left: 10px;" >
	                    <button type="button" name="btn1" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	                    <button type="button" name="btn1" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
	                    <button type="button" name="btn1"data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	                    <button type="button" name="btn1"data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
	                </div>
	                <div class="carousel-inner">
	                    <div class="carousel-item active">
	                        <img src="<%=l.getA_name() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	                    </div>
	                    <div class="carousel-item">
	                        <img src="<%=l.getA_name() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	                    </div>
	                    <div class="carousel-item">
	                        <img src="<%=l.getA_name() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	                    </div>
	                    <div class="carousel-item">
	                        <img src="<%=l.getA_name() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	                    </div>
	                </div>
	                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
	                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	                    <span class="visually-hidden">Previous</span>
	                </button>
	                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
	                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	                    <span class="visually-hidden">Next</span>
	                </button>
	            </div>
	        </div >


		
<div class="infoArea">
	            <!-- 장소 명, 평점, 홈페이지 아이콘, 찜 버튼 -->
	            <div class="infoTitle">
	                <h2><%=l.getLocal_name() %></h2>
	                <h2 style="color:var(--main-color);">4.3</h2>
	                <button style="border:none; background : transparent;">
	                    <img src="/naduri/assets/images/icon/homebutton.PNG" id="home">
	                </button>
	                <div class="markIcon">
	                    <i class="far fa-star"></i>
	                </div>
	            </div>
	<script>
	$(function(){
		// 추천버튼 클릭시(추천 추가 또는 추천 제거)
		$(".markIcon").click(function(){
			$.ajax({
				url: "/naduri/bookmarkInsert.do",
                type: "get",
                data: { l_no : <%= sendL_no%>, m_no : '<%= m.getM_no() %>'
                },
                success: function () {
                	$(".fa-star").removeClass("far");

                 
                    $(".fa-star").addClass("fas");
                },
			})
		})
		
	recCount();
	
	</script>
	            <!-- 키워드 -->
	            <div class="keyword">
	                <ul>
	                    <li>#벚꽃</li>
	                    <li>#궁궐</li>
	                    <li>#문화유산</li>
	                </ul>
	            </div>
	
	<img src="<%=l.getA_name() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	            <div class="infoDetailArea">
	                <!-- 테이블-->
	                <div class="infoTable">
	                    <table>
	                        <tr>
	                            <td >소재지</td>
	                            <td><%= l.getS_address() %> %></td>
	                        </tr>   
	                        <tr>
	                            <td>전화번호</td>
	                            <td><%= l.getS_tel() %></td>
	                        </tr>
	                        <tr>
	                            <td>운영시간</td>
	                            <td>9 a.m - 5.pm</td>
	                        </tr>

	                        </tr>
	                    </table>
	                </div>
	                <!-- 상세 정보 (텍스트) -->
	                <div class="infoDetail">
	                    <div class="a">
	                        <p>
	                           <td>000-0000</td>
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
 <% } %>	        
 <% } else if( listHeri != null ) { %>	
 <% sendL_no = heri.getL_no(); %>        
<div class="slider-images">
	            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" style="width: 1000px;">
	                <div class="carousel-indicators" style="margin-left: 10px;" >
	                    <button type="button" name="btn1" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	                    <button type="button" name="btn1" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
	                    <button type="button" name="btn1"data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	                    <button type="button" name="btn1"data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
	                </div>
	                <div class="carousel-inner">
	                    <div class="carousel-item active">
	                        <img src="<%=heri.getImageUrl() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	                    </div>
	                    <div class="carousel-item">
	                        <img src="<%=heri.getImageUrl() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	                    </div>
	                    <div class="carousel-item">
	                        <img src="<%=heri.getImageUrl() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	                    </div>
	                    <div class="carousel-item">
	                        <img src="<%=heri.getImageUrl() %>" width="1000px" height="536px" class="d-block w-100" alt="...">
	                    </div>
	                </div>
	                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
	                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	                    <span class="visually-hidden">Previous</span>
	                </button>
	                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
	                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	                    <span class="visually-hidden">Next</span>
	                </button>
	            </div>
	        </div >


		
<div class="infoArea">
	            <!-- 장소 명, 평점, 홈페이지 아이콘, 찜 버튼 -->
	            <div class="infoTitle">
	                <h2><%=heri.getH_name() %></h2>
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


	            <div class="infoDetailArea">
	                <!-- 테이블-->
	                <div class="infoTable">
	                    <table>
	                        <tr>
	                            <td >소재지</td>
	                            <td><%=heri.getCcbaLcad() %></td>
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
	                            <td><%=heri.getH_serial() %></td>
	                        </tr>
	                        <tr>
	                            <td>지정일</td>
	                            <td><%=heri.getCcbaAsdt() %></td>
	                        </tr>
	                        <tr>
	                            <td>분류</td>
	                            <td><%=heri.getGcodeName() %></td>
	                        </tr>
	                        <tr>
	                            <td>시대</td>
	                            <td><%=heri.getCcceName() %></td>
	                        </tr>
	                        <tr>
	                            <td>면적</td>
	                            <td>93,843.1㎡</td>
	                        </tr>
	                        <tr>
	                            <td>소유자</td>
	                            <td><%=heri.getCcbaPoss() %></td>
	                        </tr>
	                        <tr>
	                            <td>관리자</td>
	                            <td><%=heri.getCcbaAdmin() %></td>
	                        </tr>
	                    </table>
	                </div>
	                <!-- 상세 정보 (텍스트) -->
	                <div class="infoDetail">
	                    <div class="a">
	                        <p>
	                            <%=heri.getContent() %>
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
	
	        <!-- 근처 장소 영역 -->
	        <%@ include file="nearArea.jsp" %>
	        
	        
	        <script>
	        $(function(){
	        var lat = <%= listHeri.get(0).getLatitude()%>; 
	       	var lng = <%= listHeri.get(0).getLongitude() %>;
	       	var hh = <%= listHeri.get(0).getH_name() %>;
	        
	        var positions = [
	        	out.println("{ content : '" + "<div class=" + '"' + "lmark" + '"' + " id=" + '"hi"' + "style="
						+ '"' + "text-align:center; width:150px;" + '"' +
			
						">" + h.getH_name() + "</div>', " + " latlng: new kakao.maps.LatLng(" + h.getH_lat() + ", " + h.getH_lng()
						+ ") }, ");
					}
	        	];       
	        
			console.log(positions); // 배열에 전부 담기 성공.
			});
	        </script>
	        
	        <!-- 탭 -->
	        <div class="write_btn">
                <a href="/naduri/views/reviewWrite.jsp?l_no=<%= sendL_no %>&"><input type="button" value = "리뷰 쓰기" id="insertreview"></a>
            </div>
               <div class="write_btn">
                <a href="/naduri/views/qnaWrite.jsp?l_no=<%= sendL_no %>"><input type="button" value = "QNA 쓰기" id="insertqna"></a>
            </div>
<div id = "container">
	
    <!-- 상단 tab 영역 -->
    <ul class = "tabs">
        <li class="tab-link current" data-tab="tab_review">
            <div class="chk"></div>
           <h3>리뷰</h3></li>
        <li class="tab-link" data-tab="tab_qna">
            <div class="chk"></div>
            <h3>QnA</h3></li>
    </ul>
    <div id="tab-content"></div>
	
 <script>
 $(function() {
     // tab operation
     $('.tab-link').click(function() {
        var tab_id = $(this).attr("data-tab");

         $(".tabs li").removeClass("current");
         $(".tab-content").removeClass("current");

         $(this).addClass("current");
         $("#"+tab_id).addClass("current");
   var urlPath = "";
   
   if ( tab_id == 'tab_review' ) {
      urlPath = '/naduri/selectList.re';
   } else if( tab_id == 'tab_qna') {
      urlPath = '/naduri/selectList.qn';
   }
 
   	reviewLoad(urlPath);
     });
     
     reviewLoad('/naduri/selectList.re');
 });
 
 function reviewLoad(urlPath){
	 $.ajax({
         type : 'GET',                 //get방식으로 통신
         url : urlPath,    //탭의 data-tab속성의 값으로 된 html파일로 통신
         dataType : "html",//html형식으로 값 읽기 
         data: { l_no : '<%= sendL_no %>' } ,
         error : function() {          //통신 실패시
          alert('통신실패!');
         },
         success : function(data) {    //통신 성공시 탭 내용담는 div를 읽어들인 값으로 채운다.
            
            $("#tab-content").html(data);
            console.log( "통신성공");
         }
    });
 }
 </script>
	
</div> 
 			

	
	        <!-- 비슷한 장소 추천 -->
	        <%@ include file="recommendPlace.jsp" %>
	        
	    </div>
	
	</section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>