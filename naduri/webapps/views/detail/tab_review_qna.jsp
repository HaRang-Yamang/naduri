<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
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
	
    <!-- 리뷰 영역 -->
    <div id="tab_review" class="tab-content current">
        <!-- 리뷰 필터 영역 -->
        <div class="filter">
            <div class="write_btn">
                <a href="/naduri/views/reviewWrite.jsp"><input type="button" value = "리뷰 쓰기"></a>
            </div>
            <div class="review_table">
                <table>
                    <tr>
                        <th>평가</th>
                        <th>방문유형</th>
                        <th>방문시기</th>

                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" id="excellent"   name="excellent">
                            <label for="excellent">아주 좋음</label>
                        </td>
                        <td>
                            <input type="checkbox" id="family"   name="family">
                            <label for="family">가족</label>
                        </td>
                        <td>
                            <input type="checkbox" id="spring"   name="spring">
                            <label for="spring">봄</label>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" id="good" name="good">
                            <label for="good">좋음</label>
                        </td>
                        <td>
                            <input type="checkbox" id="couple"   name="couple">
                            <label for="couple">커플</label>
                        </td>
                        <td>
                            <input type="checkbox" id="summer"   name="summer">
                            <label for="summer">여름</label>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" id="normal"   name="normal">
                            <label for="normal">보통</label>
                        </td>
                        <td>
                            <input type="checkbox" id="alone"   name="alone">
                            <label for="alone">혼자</label>
                        </td>
                        <td>
                            <input type="checkbox" id="autumn"   name="autumn">
                            <label for="autumn">가을</label>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" id="soso"   name="soso">
                            <label for="soso">별로</label>
                        </td>
                        <td>
                            <input type="checkbox" id="friend"   name="friend">
                            <label for="friend">친구</label>
                        </td>
                        <td>
                            <input type="checkbox" id="winter"   name="winter">
                            <label for="winter">겨울</label>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" id="worst"   name="worst">
                            <label for="worst">최악</label>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
	
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
                    <div class="user_text">
                        <p>user_id</p>
                        <p>작성날짜</p>
                    </div>
                </div>
                <!-- 리뷰 내용 -->
                <div class="review_content">
                    <h4>리뷰 제목입니다.</h4>
                    <span class="score">4.0</span>
                    <div>
                        <p>
                            리뷰 내용입니다. 리뷰 내용은 사람에 따라 길이가 짧을 수도, 길 수도 있으니 노출 단어 수를 정해두고 일정 단어 수 이상은 ‘더보기+’를 클릭한 후에 볼 수 있도록 하면 좋겠습니다. 제가 생각하는 글자 수는 160자 정도 되는데요. 160자가 3줄에 딱  예쁘게 들어가기 때문입니다.
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
                                <td>2021년 4월</td>
                            </tr>
                            <tr>
                                <td>방문유형</td>
                                <td>혼자</td>
                            </tr>
                     </table>
                    </div>
    
                    <!-- 이미지 -->
                    <div class="review_img_area">
                        <div class="review_img">
                            <img src="/naduri/assets/images/detail/review_img.jpg" alt="첫 번째 리뷰 이미지">
                        </div>
                        <div class="review_img">
                            <img src="/naduri/assets/images/detail/review_img.jpg" alt="두 번째 리뷰 이미지">
                        </div>
                        <div class="review_img">
                            <img src="/naduri/assets/images/detail/review_img.jpg" alt="세 번째 리뷰 이미지">
                        </div>
                        <div class="review_img">
                            <img class="last" src="/naduri/assets/images/detail/review_img.jpg" alt="네 번째 리뷰 이미지">
                        </div>
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
	
        <!-- 전체 리뷰 구분 선 -->
        <hr class="green_bar thick">
	
        <!-- 전체 리뷰2 -->
        <div class="content mouse">
                            <div class = "review">
                            <!-- 리뷰 작성자 -->
                            <div class="review_user">
                                <div class="user_img">
                                    <a href="#">
                                        <img src="/naduri/assets/images/profile/profile_m.png" alt="member_profile_img">
                                    </a>
                                </div>
                                <div class="user_text">
                                    <p>user_id</p>
                                    <p>작성날짜</p>
                                </div>
                            </div>
                            <!-- 리뷰 내용 -->
                            <div class="review_content">
                                <h4>리뷰 제목입니다.</h4>
                                <span class="score">4.0</span>
                                <div>
                                    <p>
                                        리뷰 내용입니다. 리뷰 내용은 사람에 따라 길이가 짧을 수도, 길 수도 있으니 노출 단어 수를 정해두고 일정 단어 수 이상은 ‘더보기+’를 클릭한 후에 볼 수 있도록 하면 좋겠습니다. 제가 생각하는 글자 수는 160자 정도 되는데요. 160자가 3줄에 딱  예쁘게 들어가기 때문입니다.
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
                                            <td>2021년 4월</td>
                                        </tr>
                                        <tr>
                                            <td>방문유형</td>
                                            <td>혼자</td>
                                        </tr>
                                        <tr>
                                            <td>키워드</td>
                                            <td>#한식 #국밥</td>
                                        </tr>
                                    </table>
                                </div>
                
                                <!-- 이미지 -->
                                <div class="review_img_area">
                                    <div class="review_img">
                                        <img src="/naduri/assets/images/detail/review_img.jpg" alt="첫 번째 리뷰 이미지">
                                    </div>
                                    <div class="review_img">
                                        <img src="/naduri/assets/images/detail/review_img.jpg" alt="두 번째 리뷰 이미지">
                                    </div>
                                    <div class="review_img">
                                        <img src="/naduri/assets/images/detail/review_img.jpg" alt="세 번째 리뷰 이미지">
                                    </div>
                                    <div class="review_img">
                                        <img class="last" src="/naduri/assets/images/detail/review_img.jpg" alt="네 번째 리뷰 이미지">
                                    </div>
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
        <div class="numArea">
            <ul>
                <li><span class="arrLeft"></span></li>
                <li>1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
                <li>5</li>
                <li>6</li>
                <li>7</li>
                <li>8</li>
                <li>9</li>
                <li>10</li>
                <li><span class="arrRight"></span></li>
                <li><span class="arrDouble"></span></li>
            </ul>
        </div>
	
    </div>
	
    <!-- QnA 영역 -->
    <div id = "tab_qna" class="tab-content">
        <!-- QnA 질문하기 버튼 -->
        <div class = "filter">
        <form id="insertForm" action="/naduri/insert.qn" method="post">
           
            <div class=qnatitle >
            <span>질문 제목: </span>
            <input type="text" name="q_title" />
            </div>
            <div class=qnacontent>
            <span>질문 내용: </span>
             <textarea id="qna_textArea"  name="q_content" cols="150" rows="10" style="resize:none;"></textarea>
             </div>
             <div class="write_btn">
                   <button type="submit"  form='insertForm' id="submit_btn" >질문하기</button>
            </div>
	</form>
	  </div>
        <!-- 전체 QnA -->
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
                    <p>user_id</p>
                    <p>작성날짜</p>
                </div>
            </div>
            <!-- 질문 내용 -->
            <div class="qna_content">
                <h4>질문 제목입니다.</h4>
                <div>
                    <p>
                        질문 내용입니다. 질문 내용은 사람에 따라 길이가 짧을 수도, 길 수도 있으니 노출 단어 수를 정해두고 일정 단어 수 이상은 ‘더보기+’를 클릭한 후에 볼 수 있도록 하면 좋겠습니다. 제가 생각하는 글자 수는 160자 정도 되는데요. 160자가 3줄에 딱  예쁘게 들어가기 때문입니다.
                    </p>
                    <details class="qna_content_more">
                        <!-- 160자 초과 내용 -->
                            <summary>더보기+</summary>
                        <div>
                            <p>
                                비둘기, 가난한 애기 밤을 까닭입니다. 언덕 무덤  소녀들의 잠, 이웃 비둘기, 같이 나는 버리었습니다.  책상을 속의 마리아 지나가는 이름과, 그러나 노새, 차 피어나듯이 까닭입니다. 이웃 가난한 우는 풀이 나는 언덕 까닭입니다. 마디씩 나는 새겨지는 별 별 이름자 딴은 이런 있습니다. 않은 내 우는 있습니다. 피어나듯이 어머니, 지나고 새겨지는 북간도에 봄이 멀리 까닭입니다.
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
	
        <!-- 전체 QnA 구분선 -->
        <hr class="green_bar thick">
        
        <!-- 전체 QnA2 -->
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
                                    <p>user_id</p>
                                    <p>작성날짜</p>
                                </div>
                            </div>
                            <!-- 질문 내용 -->
                            <div class="qna_content">
                                <h4>질문 제목입니다.</h4>
                                <div>
                                    <p>
                                        질문 내용입니다. 질문 내용은 사람에 따라 길이가 짧을 수도, 길 수도 있으니 노출 단어 수를 정해두고 일정 단어 수 이상은 ‘더보기+’를 클릭한 후에 볼 수 있도록 하면 좋겠습니다. 제가 생각하는 글자 수는 160자 정도 되는데요. 160자가 3줄에 딱  예쁘게 들어가기 때문입니다.
                                    </p>
                                    <details class="qna_content_more">
                                        <!-- 160자 초과 내용 -->
                                            <summary>더보기+</summary>
                                        <div>
                                            <p>
                                                비둘기, 가난한 애기 밤을 까닭입니다. 언덕 무덤  소녀들의 잠, 이웃 비둘기, 같이 나는 버리었습니다.  책상을 속의 마리아 지나가는 이름과, 그러나 노새, 차 피어나듯이 까닭입니다. 이웃 가난한 우는 풀이 나는 언덕 까닭입니다. 마디씩 나는 새겨지는 별 별 이름자 딴은 이런 있습니다. 않은 내 우는 있습니다. 피어나듯이 어머니, 지나고 새겨지는 북간도에 봄이 멀리 까닭입니다.
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
	
        <!-- 넘버링 -->
        <div class="numArea">
            <ul>
                <li><span class="arrLeft"></span></li>
                <li>1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
                <li>5</li>
                <li>6</li>
                <li>7</li>
                <li>8</li>
                <li>9</li>
                <li>10</li>
                <li><span class="arrRight"></span></li>
                <li><span class="arrDouble"></span></li>
            </ul>
        </div>
	
    </div>
	
	
</div>    