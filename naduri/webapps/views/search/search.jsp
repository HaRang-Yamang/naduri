<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="/naduri/assets/js/map.js"></script>
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
        
        
        
        <!-- 위치 정보 -->
        <div class="info">
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
        </div>
        
        <!-- 주변 둘러보기 -->
        <div class="info">
            <div class="other">
            <div id="location_title">
                <h3 id="list_title">주변 둘러보기</h3>

                <div class="spot_container">

                    <!-- spot1 -->
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

                    <!-- spot2 -->
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
    </div>
    </section>

        <!-- hot keword -->
        <section class="main_body">
            <div class="hot_keword">
                <h2>인기명소 골라보기</h2>
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

            <div class="row">
                <div class="hotSpot date">
                    <img src="/naduri/assets/images/main/featured_img_1.jpg">

                    <div class="spotInfo">
                    <h4>한옥마을</h4>
                    <p>#데이트</p> <p>#데이트</p> <p>#데이트</p>
                    </div>

                </div>
                <div class="hotSpot palace">
                    <img src="/naduri/assets/images/main/featured_img_2.jpg">

                    <div class="spotInfo">
                        <h4>수원화성</h4>
                        <p>#궁궐</p> <p>#궁궐</p> <p>#궁궐</p>
                        </div>
                </div>
                <div class="hotSpot heritage">
                    <img src="/naduri/assets/images/main/featured_img_3.jpg">

                    <div class="spotInfo">
                        <h4>수원화성</h4>
                        <p>#역사</p> <p>#역사</p> <p>#역사</p>
                        </div>
                </div>
            </div>

            <div class="row">
                <div class="hotSpot date">
                    <img src="/naduri/assets/images/main/featured_img_1.jpg">

                    <div class="spotInfo">
                    <h4>한옥마을</h4>
                    <p>#데이트</p> <p>#데이트</p> <p>#데이트</p>
                    </div>

                </div>
                <div class="hotSpot palace">
                    <img src="/naduri/assets/images/main/featured_img_2.jpg">

                    <div class="spotInfo">
                        <h4>수원화성</h4>
                        <p>#궁궐</p> <p>#궁궐</p> <p>#궁궐</p>
                        </div>
                </div>
                <div class="hotSpot heritage">
                    <img src="/naduri/assets/images/main/featured_img_3.jpg">

                    <div class="spotInfo">
                        <h4>수원화성</h4>
                        <p>#역사</p> <p>#역사</p> <p>#역사</p>
                        </div>
                </div>
            </div>

            <div class="row">
                <div class="hotSpot date">
                    <img src="/naduri/assets/images/main/featured_img_1.jpg">

                    <div class="spotInfo">
                    <h4>한옥마을</h4>
                    <p>#데이트</p> <p>#데이트</p> <p>#데이트</p>
                    </div>

                </div>
                <div class="hotSpot palace">
                    <img src="/naduri/assets/images/main/featured_img_2.jpg">

                    <div class="spotInfo">
                        <h4>수원화성</h4>
                        <p>#궁궐</p> <p>#궁궐</p> <p>#궁궐</p>
                        </div>
                </div>
                <div class="hotSpot heritage">
                    <img src="/naduri/assets/images/main/featured_img_3.jpg">

                    <div class="spotInfo">
                        <h4>수원화성</h4>
                        <p>#역사</p> <p>#역사</p> <p>#역사</p>
                        </div>
                </div>
            </div>
            </div>
        </div>
       </section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>