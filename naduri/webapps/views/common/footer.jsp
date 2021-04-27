<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<footer>
<div class="footerArea">
    <span class="footerInfo">Copyright © 하랑 2021 | KH정보교육원 교육용 사이트입니다</span>
    <!--
    	<a href="/naduri/views/notice/noticeList.jsp" style="float: right;">공지사항</a>
    -->
    <div class="footerInfo" style="float: right;" onclick="goNotice();">공지사항</div>
</div>

<script>
	function goNotice(){
		location.href="/myWeb/selectList.no";
	}

</script>

</footer>