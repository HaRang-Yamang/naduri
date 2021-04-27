<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/naduri/assets/images/naduri.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="../../assets/css/common/reset.css" />
<link rel="stylesheet" href="../../assets/css/common/header.css" />
<link rel="stylesheet" href="../../assets/css/notice.css" />
<link rel="stylesheet" href="../../assets/css/common/footer.css" />

<script src="/naduri/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://kit.fontawesome.com/2004329f9f.js" crossorigin="anonymous"></script>
<script defer src="/naduri/assets/js/header.js"></script>
<title>[관리자 권한]공지사항 작성하기</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<section>
        <div class="noticeWriteArea">
        <form action="/naduri/insert/noticeWrite.no" method="post">
            <div class="head_area">
                <h2 class="notice_head">공지사항 작성하기</h2>
            </div>
            <div class="table_area">
            
                <table class="notice_table">
                    <tr>
                        <th id="notice_no">제목</th>
                        <th id='notice_title input'>
                            <input type="text" id="input_title" placeholder="공지 제목">
                        </th>
                        <th id='notice_writer'>관리자</th>
                        <th id='notice_date'></th>
                    </tr>
                    <tr>
                        <td>첨부파일</td>
                        <td colspan="3">
                            <input class="inputFile" type="file" name="file" id="input_file">

                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <div id="textArea">
                                <textarea name="notice_input" id="notice_input" rows="30"></textarea>
                            </div>
                        </td>
                    </tr>
                </table>
         
                <button class="submit_btn" type="submit">작성하기</button>

            </div>
        </form>
        </div>
	</section>		
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>