<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/naduri/assets/css/common/reset.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/header.css" />
<link rel="stylesheet" href="/naduri/assets/css/myPage.css" />
<link rel="stylesheet" href="/naduri/assets/css/myPage2.css" />
<link rel="stylesheet" href="/naduri/assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
    integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
    integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous">
</script>

<style>
	/* 헤더 살리기 프로젝트 ver 2.0 */
	header .navbar {
    	display: flex;
    	justify-content: space-between;
    	align-items: inherit;
    	padding-top: 0px;
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
	    <div class="profileArea">
	        <h2 class="hidden">프로필 페이지</h2>
	        
	        <!-- 프로필 영역 -->

	        <form class="top_area" action = "/naduri/profileImgInsert.do" method="post" enctype="multipart/form-data">
	        
	            <div class="profile_img">
	            	<img src="/naduri/assets/images/no-img.png" id="profileImg" width="350px" height="295px" alt="프로필사진" />
	            </div>
	            <input type="file" class="hidden" accept="image/*" name="profileImg" id="profileImg1" onchange="readURL(input)" />
	          
	        <script>
	        	$('.profile_img').on('click', function(){
	        		$('#profileImg1').click();
	        	})
	        	
	         // 사진 미리보기 구현
	        	 function readURL(input) {
      				  if (input.files && input.files[0]) {
         				  var reader = new FileReader();
          				  reader.onload = function(e) {
        	     		   $('#profileImg').attr('src', e.target.result);
          			  }
         		   reader.readAsDataURL(input.files[0]);
      			  }
   					 }

    				$("#profileImg1").change(function() {
       				 readURL(this);
   				 });

	        </script>
	            <div class="profile_area">
	                <div>
	                    <span class="green_title"></span>
	                    <h3>회원정보</h3>
	                </div>
	                <table class="profile_content">
	                    <tbody>
	                        <tr>
	                            <td class="profile_first">이름</td>
	                            <td>ddd</td>
	                        </tr>
	                        <tr>
	                            <td>생년월일</td>
	                            <td>ddd</td>
	                        </tr>
	                        <tr>
	                            <td>좋아하는 여행 테마</td>
	                            <td>
	                                <ol class="keword">
	                                    <li>문화재</li>
	                                    <li>문화재</li>
	                                    <li>문화재</li>
	                                </ol>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td>선호하는 계절</td>
	                            <td>
	                                <ol class="keword">
	                                    <li>봄</li>
	                                </ol>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td>선호 키워드</td>
	                            <td>
	                                <ol class="keword">
	                                    <li>궁월</li>
	                                    <li>궁월</li>
	                                    <li>궁월</li>
	                                    <li>궁월</li>
	                                    <li>궁월</li>
	                                    <li>궁월</li>
	                                    <li>궁월</li>
	                                    <li>궁월</li>
	                                </ol>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	                <div class="modify_Area">
	                <div class="profileImg_modify"><button type="submit">프로필 사진 등록</button></div>
	                <div class="profileImg_delete"><button type="reset">프로필 사진 삭제</button></div>
	                <div class="profile_modify"><a href="../member/joinMember.jsp">프로필 수정하기</a></div>
	                </div>
	            </div>

 </form> 
			<!-- 탭 영역 -->	
	        <div class="tabs_area">
	            <ul class="tabs">
	                <li class="tab-link current" data-tab="tab_togolist">
	                    <div class="chk"></div>
	                    <h3>To Go List</h3>
	                </li>
	                <li class="tab-link" data-tab="tab_p_reviews">
	                    <div class="chk"></div>
	                    <h3>기행록</h3>
	                </li>
	                <li class="tab-link" data-tab="tab_p_like">
	                    <div class="chk"></div>
	                    <h3>좋아요 누른 리뷰</h3>
	                </li>
	                <li class="tab-link" data-tab="tab_p_qna">
	                    <div class="chk"></div>
	                    <h3>내가 작성한 문의</h3>
	                </li>
	            </ul>
	        </div>
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
				
				if ( tab_id == 'tab_p_like' ) {
					urlPath = '/naduri/tab_p_like.do';
				} else if( tab_id == 'tab_p_qna') {
					urlPath = '/naduri/tab_p_qna.do';
				} else if( tab_id == 'tab_p_reviews') {
					urlPath = '/naduri/tab_p_reviews.do';
				} else if( tab_id == 'tab_togolist') {
					urlPath = '/naduri/tab_togolist.do';
				}
			 
	            $.ajax({
	                 type : 'GET',                 //get방식으로 통신
	                 url : urlPath,    //탭의 data-tab속성의 값으로 된 html파일로 통신
	                 dataType : "html",//html형식으로 값 읽기 
	                 data: { m_no : '<%= m.getM_no() %>' } ,
	                 error : function() {          //통신 실패시
	                  alert('통신실패!');
	                 },
	                 success : function(data) {    //통신 성공시 탭 내용담는 div를 읽어들인 값으로 채운다.
	                 	
	                	 $("#tab-content").html(data);
	                 	console.log( "통신성공");
	                 }
	            });
				/* 
               $.ajax({
                 type : 'GET',                 //get방식으로 통신
                 url : tab_id + ".jsp",    //탭의 data-tab속성의 값으로 된 html파일로 통신
                 dataType : "html",//html형식으로 값 읽기 
                 data: ,
                 error : function() {          //통신 실패시
                  alert('통신실패!');
                 },
                 success : function(data) {    //통신 성공시 탭 내용담는 div를 읽어들인 값으로 채운다.
                  $("#tab-content").html(data);
                 console.log( "통신성공");
                 }
               }); */
              });
              
              $('.tab-link.current').click();
            });
         </script>
	
	       <div id="tab-content"></div>
	    </div>
	</section>		
	<div id="topBtn" href="#">TOP</div>

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