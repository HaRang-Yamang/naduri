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
	                <div class="like_content">
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
	                    
	                    <div class="like_photo">
	                    
	                    <% for(Attach a : list2) { %>
	                    	<% if( a.getRno() == rlist.get(i).getRno()) { %>
	                        
	                        <div class="like_photo_sample">
	                        		<img src="/naduri/assets/images/review/<%= a.getAttach_name() %>" alt="" />
	                        </div>
	                        <% } %>
	                   <% } %>
	                    </div>
	                    
	                    <div class="like_btnArea">
	                        <div class="like_likeBtn"><i class="fas fa-heart"></i><span style="color: var(--black-color);">
	                                5</span></div>
	                        <div class="like_comentBtn"><i class="far fa-comment-dots"></i><span
	                                style="color: var(--black-color)"> 5</span></div>
	                    </div>
	                </div>
	                <% } %>
	                	            
	        </div>
	        </div>