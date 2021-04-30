<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div id="tab_p_qna" class="tab-content">
	            <div class="current_tab">
	                <section class="content mouse">
	                    <!-- 질문 확인 -->
	                    <div class="qna">
	                        <!-- 질문 작성자 -->
	                        <div class="qna_user">
	                            <div class="user_img">
	                                <a href="#">
	                                    <img src="/naduri/assets/images/profile_m.png" alt="member_profile_img">
	                                </a>
	                            </div>
	                            <div class="user_text">
	                                <p>user_id</p>
	                                <p>작성날짜</p>
	                            </div>
	                        </div>
	                        <!-- 질문 내용 -->
	                        <div class="qna_content">
	                            <h4>질문 제목입니다.</h4>
	                            <div>
	                                <p>
	                                    질문 내용입니다. 질문 내용은 사람에 따라 길이가 짧을 수도, 길 수도 있으니 노출 단어 수를 정해두고 일정 단어 수 이상은 ‘더보기+’를 클릭한 후에 볼 수
	                                    있도록 하면 좋겠습니다. 제가 생각하는 글자 수는 160자 정도 되는데요. 160자가 3줄에 딱 예쁘게 들어가기 때문입니다.
	                                </p>
	                                <details class="qna_content_more">
	                                    <!-- 160자 초과 내용 -->
	                                    <summary>더보기+</summary>
	                                    <div>
	                                        <p>
	                                            비둘기, 가난한 애기 밤을 까닭입니다. 언덕 무덤 소녀들의 잠, 이웃 비둘기, 같이 나는 버리었습니다. 책상을 속의 마리아 지나가는 이름과,
	                                            그러나 노새, 차 피어나듯이 까닭입니다. 이웃 가난한 우는 풀이 나는 언덕 까닭입니다. 마디씩 나는 새겨지는 별 별 이름자 딴은 이런 있습니다.
	                                            않은 내 우는 있습니다. 피어나듯이 어머니, 지나고 새겨지는 북간도에 봄이 멀리 까닭입니다.
	                                        </p>
	                                    </div>
	                                </details>
	                            </div>
	                        </div>
	                    </div>
	
	                    <!-- 작성된 댓글 -->
	                    <div class="comment">
	                        <div class="comment_user">
	                            <div class="comment_user_img">
	                                <a href="">
	                                    <img src="/naduri/assets/images/header/profile.png" lat="댓글 작성자">
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
	                                    <img src="/naduri/assets/images/header/profile.png" alt="댓글 작성자">
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
	                                    <img src="/naduri/assets/images/header/profile.png" alt="댓글 사용이미지">
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
	                </section>
	
	            </div>
	        </div>