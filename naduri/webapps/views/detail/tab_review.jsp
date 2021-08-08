<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.harang.naduri.jdbc.review.model.vo.*, com.harang.naduri.jdbc.attach.model.vo.*,
     com.harang.naduri.jdbc.member.model.vo.*,com.harang.naduri.jdbc.Thumbnail.model.vo.*"%>
   <%
 ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
 ArrayList<lo_key> list = (ArrayList<lo_key>)request.getAttribute("lo_key");
     int repeatCnt = 0;
 %>
  <!-- 리뷰 영역 -->
    <div id="tab_review" class="tab-content current">
    
        <!-- 전체 리뷰 -->
        <div class="content mouse">
	
            <div class = "review">
                <!-- 리뷰 작성자 -->
                <div class="review_user">
                    <div class="user_img">
                        <a href="#">
                            <img src="/naduri/assets/images/profile/profile_m.png" alt="member_profile_img">
                        </a>
                    </div>
                    <%for(Review r : reviewList){ %>
                    <% if(repeatCnt == r.getRno()) {
                    	        continue;
                          } else { 
                          repeatCnt = r.getRno();
                          %>
                    <div class="user_text">
                        <p><%=r.getM_id() %></p>
                        <p><%=r.getR_date() %></p>
                    </div>
                </div>
                <!-- 리뷰 내용 -->
                
                <div class="review_content">
                    <h4><%=r.getR_title() %></h4>
                    <span class="score"><%=r.getR_rank() %></span>
                    <div>
                        <p>
                            <%=r.getR_content() %>
                        </p>
                        <details class="review_content_more">
                            <!-- 160자 초과 내용 -->
                                <summary>더보기+</summary>
                            <div>
                                <p>
                                    비둘기, 가난한 애기 밤을 까닭입니다. 언덕 무덤  소녀들의 잠, 이웃 비둘기, 같이 나는 버리었습니다.  책상을 속의 마리아 지나가는 이름과, 그러나 노새, 차 피어나듯이 까닭입니다. 이웃 가난한 우는 풀이 나는 언덕 까닭입니다. 마디씩 나는 새겨지는 별 별 이름자 딴은 이런 있습니다. 않은 내 우는 있습니다. 피어나듯이 어머니, 지나고 새겨지는 북간도에 봄이 멀리 까닭입니다.
                                </p>
                            </div>
                        </details> 
                    </div>
                    <div class="filter_content">
                        <table>
                            <tr>
                                <td>방문날짜</td>
                                <td><%=r.getR_period() %></td>
                            </tr>
                            <tr>
                                <td>방문유형</td>
                                   <td>
                                <%if(r.getR_with()==1){ %> 혼자 
	                            <% } else if(r.getR_with()==2){ %>친구
	                            <%}else if(r.getR_with()==3){ %>썸
	                      	     <%}else if(r.getR_with()==4){ %>커플
	                      	     <%}else{ %>가족<%} %>    
	                             </td>
                            </tr>
                     </table>
                    </div>
    
                    <!-- 이미지 -->
                    
                    <div class="review_img_area">
                    <%for(Attach a : r.getAttList()) {%>
                        <div class="review_img">
                        <img src="/naduri/resources/review/<%= a.getA_name()%>" style="width : 120px; height : 120px;">
                        <a href="/naduri/resources/review/"<%=a.getA_name()%>></a>
                        </div>
                    <% } %>
                    </div>
                </div>
            </div>
            <!-- 전체 리뷰 구분 선 -->
        <hr class="green_bar thick">
	<% } } %>
            <!-- 작성된 댓글 -->
            <div class="comment">
                <div class="comment_user">
                    <div class="comment_user_img">
                        <a href="">
                            <img src="/naduri/assets/images/profile/profile.png" lat="댓글 작성자">
                        </a>
                    </div>
                    <div class="user_text">
                        <p>user_id</p>
                        <p>작성 날짜</p>
                    </div>
                </div>
                <!-- 작성된 댓글 -->
                <div class="written_comment_area">
                    <p>작성된 댓글입니다.</p>
                </div>
            </div>
	
            
	
            <!-- 작성된 댓글2 -->
            <div class="comment">
                <div class="comment_user">
                    <div class="comment_user_img">
                        <a href="">
                            <img src="/naduri/assets/images/profile/profile.png" lat="댓글 작성자">
                        </a>
                    </div>
                    <div class="user_text">
                        <p>user_id</p>
                        <p>작성 날짜</p>
                    </div>
                </div>
                <!-- 작성된 댓글 -->
                <div class="written_comment_area">
                    <p>작성된 댓글입니다.</p>
                </div>
            </div>
	
            <!-- 댓글 작성하기 -->
            <div class="comment">
                <!-- 댓글 작성자 프로필 -->
                <div class="comment_user">
                    <div class="comment_user_img">
                        <a href="#">
                            <img src="/naduri/assets/images/profile/profile.png" alt="댓글 사용이미지">
                        </a>
                        <div class="user_text">
                            <p>user_id</p>
                            <p>작성 날짜</p>
                        </div>
                    </div>
                </div>
                <!-- 댓글 작성 내용 -->
                <div class="write_comment_area">
                    <form action="" class="write_comment" method="post">
                        <textarea name="comment_area" id="comment_area" cols="88" row="8"></textarea>
                        <div class="comment_btn">
                            <input type="submit" value="전송하기">
                            <input type="reset" value="취소하기">
                        </div>
                    </form>
                </div>
            </div>
        </div>
                            <!-- 작성된 댓글 -->
                            <div class="comment">
                            <div class="comment_user">
                                <div class="comment_user_img">
                                    <a href="">
                                        <img src="/naduri/assets/images/profile/profile.png" lat="댓글 작성자">
                                    </a>
                                </div>
                                <div class="user_text">
                                    <p>user_id</p>
                                    <p>작성 날짜</p>
                                </div>
                            </div>
                            <!-- 작성된 댓글 -->
                            <div class="written_comment_area">
                                <p>작성된 댓글입니다.</p>
                            </div>
                            </div>
        
                            <hr class="green_bar short">
        
                            <!-- 작성된 댓글2 -->
                            <div class="comment">
                            <div class="comment_user">
                                <div class="comment_user_img">
                                    <a href="">
                                        <img src="/naduri/assets/images/profile/profile.png" lat="댓글 작성자">
                                    </a>
                                </div>
                                <div class="user_text">
                                    <p>user_id</p>
                                    <p>작성 날짜</p>
                                </div>
                            </div>
                            <!-- 작성된 댓글 -->
                            <div class="written_comment_area">
                                <p>작성된 댓글입니다.</p>
                            </div>
                            </div>
        
                            <!-- 댓글 작성하기 -->
                            <div class="comment">
                            <!-- 댓글 작성자 프로필 -->
                            <div class="comment_user">
                                <div class="comment_user_img">
                                    <a href="#">
                                        <img src="/naduri/assets/images/profile/profile.png" alt="댓글 사용이미지">
                                    </a>
                                    <div class="user_text">
                                        <p>user_id</p>
                                        <p>작성 날짜</p>
                                    </div>
                                </div>
                            </div>
                            <!-- 댓글 작성 내용 -->
                            <div class="write_comment_area">
                                <form action="" class="write_comment" method="post">
                                    <textarea name="comment_area" id="comment_area" cols="88" row="8"></textarea>
                                    <div class="comment_btn">
                                        <input type="submit" value="전송하기">
                                        <input type="reset" value="취소하기">
                                    </div>
                                </form>
                            </div>
                            </div>
        </div>
        
        <!-- 넘버링 -->
     
	
    </div>
    
