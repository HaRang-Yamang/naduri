<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<footer>
<div class="footerArea">

    <span class="footerInfo">Copyright &copy; 하랑 2021 | KH정보교육원 교육용 사이트입니다</span>
    <!--
    	<a href="/naduri/views/notice/noticeList.jsp" style="float: right;">공지사항</a>
    -->
    <div class="footerInfo" style="float: right; cursor: pointer; margin-top:7px;" onclick="goNotice();">공지사항</div>

</div>

<script>
	function goNotice(){
		location.href="/naduri/selectList.no";
	}

</script>

</footer>