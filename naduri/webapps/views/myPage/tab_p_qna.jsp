<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.harang.naduri.jdbc.member.model.vo.*, java.util.*, com.harang.naduri.jdbc.qna.model.vo.*" %>
<%
	Member m = (Member)session.getAttribute("member");
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
%>

    <div id="tab_p_qna" class="tab-content">
	            <div class="current_tab">
	                <!-- 전체 QnA -->
        <%for(Qna q : list){ %>
        <div class="content mouse">
            <!-- 질문 확인 -->
            <div class = "qna">
            <!-- 질문 작성자 -->
            <div class="qna_user">
                <div class="user_img">
                    <a href="#">
                        <img src="/naduri/assets/images/profile/profile_m.png" alt="member_profile_img">
                    </a>
                </div>
                <div class="user_text">
                    <p><%=q.getM_id()%></p>
                    <p><%=q.getQ_date() %></p>
                </div>
            </div>
            <!-- 질문 내용 -->
            <div class="qna_content">
                <h4><%=q.getQ_title()%></h4>
                <div>
                    <p>
                        <%=q.getQ_content()%>
                    </p>
                </div>
            </div>
            </div>
	 <% } %>
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
        
            <!-- 댓글 -->
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
                    <textarea name="comment_area" id="comment_area" cols="88" row="5"></textarea>
                    <div class="comment_btn">
                        <input type="submit" value="전송하기">
                        <input type="reset" value="취소하기">
                    </div>
                </form>
            </div>
            </div>
        </div>
	
	            </div>
	        </div>