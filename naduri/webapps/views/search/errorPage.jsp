<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="com.harang.naduri.jdbc.spot.model.vo.*, java.util.*, com.harang.naduri.jdbc.heritage.model.vo.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon"
	type="/naduri/assets/images/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/main_body.css" />
<link rel="stylesheet" href="/naduri/assets/css/search.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />



<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js"
	crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>

<!-- 지도 api 사용 위한 스크립트 영역 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6005fc94dc9f6c5072c2ef8a64151536"></script>
<!-- <script defer src="/naduri/assets/js/map.js"></script> -->
<!-- -------------------------------------------------------- -->

<title>나드리</title>
<style>
#s_result {
	width: auto;
	height: auto;
}
</style>


</head>
<body>

	<%@ include file="../common/header.jsp"%>


	<section>
		<div class="search_area">
			<div class="search">
				<input class="search_val" type="text" placeholder="가고 싶은 곳을 검색하세요(예. 경복궁, 독립문, 흥인지문)">
				<i class="fas fa-search" aria-hidden="true"></i>
			</div>
		</div>

		



			<div class='not_found'>
				<p class='not_found_message'>
					나드리 데이터베이스에서 검색 결과를 찾을 수 없습니다.<br> 문화재 이름으로 다시 검색해주세요.
				</p>
				
				<div class='goToMain'>
					<button class='mainBtn'>메인으로 돌아가기</button>
				</div>
				
			</div>


	</section>


	<script>
	 $(document).ready(function() {
         $(".search_val").keydown(function(key) {
            
             if (event.keyCode == 13) {
                var spotName = $(this).val();
                /* alert($(".search_val").val()); */
                 location.href = "/naduri/goresult.sr?spotName=" + spotName;
                
             }
         });
      });
		
	$(".mainBtn").click(function(){
			location.href="/naduri/"
			
	});
		
	</script>



	<%@ include file="../common/footer.jsp"%>
</body>
</html>