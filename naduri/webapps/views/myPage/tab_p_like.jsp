<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.review.model.vo.*, java.util.*, com.harang.naduri.jdbc.member.model.vo.*,com.harang.naduri.jdbc.attach.model.vo.*" %>
<%
	ArrayList<Review> rlist = (ArrayList<Review>)request.getAttribute("list");
	ArrayList<Attach> list2 = (ArrayList<Attach>)request.getAttribute("list2");
	Member m = (Member)session.getAttribute("member");
%>  
	  <div id="tab_p_like" class="tab-content">
	            <div class="current_tab">
	            <% for(int i=0 ; i < rlist.size(); i++) { %>
	                <div class="like_content" onclick="test(<%=rlist.get(i).getRno() %>);">
	                    <div class="like_nameArea">
	                        <img src="/naduri/assets/images/header/profile.png"><span id="p_like_userName"><%= rlist.get(i).getM_name() %><span id="p_like_coment">님의 리뷰</span></span>
	                    </div>
	                    <div class="like_titleArea">
	                        <h4 class = "myReview_title"><%= rlist.get(i).getR_title() %></h4><span><%= rlist.get(i).getR_rank() %></span>
	                    </div>
	                    <p class="like_date"><%= rlist.get(i).getR_period() %> 방문</p>
	                    <p class="myReview_content"><%= rlist.get(i).getR_content() %></p>
	                    
	                    <script>
	                    $(document).ready(function(){ 
	                    	$('.myReview_title').each(function(){ 
	                    		if ($(this).text().length > 30) $(this).html($(this).text().substr(0,12)+"..."); }); });

	                 
	                    $(document).ready(function(){ 
	                    	$('.myReview_content').each(function(){ 
	                    		if ($(this).text().length > 30) $(this).html($(this).text().substr(0,65)+"..."); }); });

	                 
	                    </script>
	                    
	                    <div class="like_photo" style="margin: 10px 0;">
	                    <% for(Attach a : list2) { %>
	                    	<% if( a.getR_no() == rlist.get(i).getRno()) { %>
	                        <div class="like_photo_sample">
	                        		<img src="/naduri/assets/images/review/<%= a.getA_name() %>" alt="" />
	                        </div>
	                        <% } %>
	                   <% } %>
	                    </div>
	                    
	                    <div class="like_btnArea">
	                        <div class="like_likeBtn"><i class="fas fa-heart"></i><span style="color: var(--black-color);" class = "like_count" id="like-<%=rlist.get(i).getRno() %>">
	                                5</span></div>
	                        <div class="like_comentBtn"><i class="far fa-comment-dots"></i><span
	                                style="color: var(--black-color)"> 5</span></div>
	                    </div>
	                </div>
	                <script>
					
					function recCount() {
						$.ajax({
							url: "/naduri/likeCount.do",
			                type: "get",
			                data: { r_no : '<%=rlist.get(i).getRno() %>', m_no : '<%= m.getM_no() %>'},
			                success: function(count) {
			                	$("#like-<%=rlist.get(i).getRno() %>").html(count);
			                	
			                	console.log(count);
			                }
						});
				    };
				    
				    recCount();
					</script>
	                <% } %>
	                	            
	        </div>
	        
	        <script src="/naduri/assets/js/modal.js"></script>
	            <div class="modal" >
	                <div class="modal_content" title="리뷰 상세보기">
	
	                    <div class="like_nameArea">
	                        <img src="/naduri/assets/images/header/profile.png"><span id="p_like_userName_modal"></span><span class="modal_content_close">X</span>
	                    </div>
	                    <div class="modal_like_titleArea">
	                    <br>
	                        <h4 id="review_title_modal"></h4><br><span id="review_rank_modal"></span>
	                    </div>
	                    
	                    <p class="madal_review">리뷰내용리뷰내용리뷰내용리뷰내용내용리뷰내내용리뷰내리뷰내용리뷰내용리뷰내용리뷰내용내용리뷰내내용리뷰내<br>
	                        리뷰내용리뷰내용리뷰내용리뷰내용내용리뷰내내용리뷰내리뷰내용리뷰내용리뷰내용리뷰내용내용리뷰내내용리뷰내<br>
	                        리뷰내용리뷰내용리뷰내용리뷰내용내용리뷰내내용리뷰내리뷰내용리뷰내용리뷰내용리뷰내용내용리뷰내내용리뷰내리뷰내용리뷰내용리뷰내용리뷰내용내용리뷰내내용리뷰내리뷰내
	                        용리뷰내용리뷰내용리뷰내용내용리뷰내내용리뷰내</p>
	                      
	<span class="like_date_modal"></span><span id="like_date_coment"> 방문</span>
	 <br><br>
	                   
	                    <br>
	                    <article class="slider-images">
	                        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel"
	                            style="width: 920px;">
	                            <div class="carousel-indicators" style="margin-left: 10px;">
	                                <button type="button" name="btn1" data-bs-target="#carouselExampleIndicators"
	                                    data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	                                <button type="button" name="btn1" data-bs-target="#carouselExampleIndicators"
	                                    data-bs-slide-to="1" aria-label="Slide 2"></button>
	                                <button type="button" name="btn1" data-bs-target="#carouselExampleIndicators"
	                                    data-bs-slide-to="2" aria-label="Slide 3"></button>
	                                <button type="button" name="btn1" data-bs-target="#carouselExampleIndicators"
	                                    data-bs-slide-to="3" aria-label="Slide 4"></button>
	                            </div>
	                            
	                            
	                            <div class="carousel-inner" id="review_img">
	                                <div class="carousel-item active">
	                                    <img src="/naduri/assets/images/main/featured_img_1.jpg" width="920px" height="536px"
	                                        class="d-block w-100" alt="...">
	                                </div>
	                                <div class="carousel-item">
	                                    <img src="/naduri/assets/images/main/featured_img_1.jpg" width="920px" height="536px"
	                                        class="d-block w-100" alt="...">
	                                </div>
	                                <div class="carousel-item">
	                                    <img src="/naduri/assets/images/main/featured_img_1.jpg" width="920px" height="536px"
	                                        class="d-block w-100" alt="...">
	                                </div>
	                                <div class="carousel-item">
	                                    <img src="/naduri/assets/images/main/featured_img_1.jpg" width="920px" height="536px"
	                                        class="d-block w-100" alt="...">
	                                </div>
	                            </div>
	                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
	                                data-bs-slide="prev">
	                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	                                <span class="visually-hidden">Previous</span>
	                            </button>
	                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
	                                data-bs-slide="next">
	                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
	                                <span class="visually-hidden">Next</span>
	                            </button>
	                        </div>
	                    </article>
	                    
	                    
	                    
	                </div>
	            </div>
	        </div>
	        <script>
	        function test( r_no) {
            	$.ajax({
            		url : "/naduri/likeReviewSelectOne.do",
            		data : { r_no : r_no, m_no : '<%= m.getM_no()  %>' },
            		success : function(data){  
            			console.log(data);
            			$('#p_like_userName_modal').html(data.m_name+'<span id="p_like_coment">님의 리뷰</span>');
            			$('#review_title_modal').html(data.r_title); 
            			$('#review_rank_modal').html(data.r_rank); 
            			$('.like_date_modal').html(data.r_period); 
            			$('.madal_review').html(data.r_content); 
            			
						$('#review_img>.carousel-item').remove();
            			
            			for( var i in data.attList){
            				if(i == 0){
            					var divImg = '<div class="carousel-item active">' +
                                             '<img src="/naduri/assets/images/review/' + data.attList[i].a_name + '" width="920px" height="536px"' +
                                             'class="d-block w-100" alt="..."></div>'; 
            					$('#review_img').prepend(divImg);
            				} else {
            					var divImg = '<div class="carousel-item">' +
                                    '<img src="/naduri/assets/images/review/' + data.attList[i].a_name + '" width="920px" height="536px"' +
                                    'class="d-block w-100" alt="..."></div>'; 
   								$('#review_img>.carousel-item').after(divImg);
            				}
            			}
            		/* 	$(".carousel-item").children().attr("src",data.a_name"); */
            			
            		},
            		error : function( error ) { alert("전송 실패!"); }
            	});
            }
	        </script>
	       