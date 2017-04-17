<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page pageEncoding="utf-8" session="true" contentType="text/html; utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../res_include/res_head.jsp"></jsp:include>
</head>
<script>
	function fnWriteNotice(notice_no){
		location.href="/notice_write?notice_no=" + notice_no;
	}
</script>
<body>
	
	<jsp:include page="../res_include/res_top.jsp"></jsp:include>
	
    <!-- Page Content -->
    <br/>
    <div class="container" >
        <div >
            <div align="center">
                <strong style="font-size:50px ">공 지 사 항</strong><br/>
            </div>            
        </div>
    </div><br/><br/>
    
    <!-- 검색 zone -->
    <div align="right" style="display:flex;">
    	<div style="flex:1;"></div>
    	<div style="flex:11;">
    		<form method="post" action="/notice_search">
    			<input type="hidden" value="${sessionScope.loggedid}" name="sawon_id">
	    		<input style="margin-right:20px; font-size:18px; font-style:bold;" type="date" id="notice_start_date" name="notice_start_date">
	    		<input style="margin-right:20px; font-size:18px; font-style:bold;" type="date" id="notice_end_date" name="notice_end_date">
	    		<input style="margin-right:20px; font-size:18px; font-style:bold;" type="text" id="notice_search_text" name="notice_search_text">
	    		<button type="submit" value="검 색"><strong style="font-style:bold; font-size:20px;">검 색</strong></button>
    		</form>
    	</div>
    	<div style="flex:1;"></div>
    </div><br/><br/>
    
    <!-- 게시판 항목 -->
    <div style="display:flex;height:40px;text-align:center;margin-bottom: 5px;">
    	<div style="flex:1;"></div>
    	<div align="center" style="flex:1;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">등 록 번 호</div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">등 록 일 자</div>
    	<div style="flex:1;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">등 록 자 명</div>
    	<div style="flex:7;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">제 목</div>
    	<div style="flex:1;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">조 회 수</div>
    	<div style="flex:1;"></div>
    </div>
    
    <!-- 게시판 리스트 -->
    <c:forEach var="row" items="${mainNotice}">
	    <div style="display:flex;height:30px;margin-bottom: 5px;">
	    	<div style="flex:1;"></div>
	    	<div align="center" style="flex:1;font-size:25px;margin-right:5px;background:#D2DEEF;">${row.board_notice_no}</div>
	    	<div align="center" style="flex:2;font-size:25px;margin-right:5px;background:#D2DEEF;">${fn:substring(row.board_notice_input_time, 0, 11)}</div>
	    	<div align="center" style="flex:1;font-size:25px;margin-right:5px;background:#D2DEEF;">${row.sawon_id}</div>
	    	<div style="flex:7;font-size:25px;margin-right:5px;background:#D2DEEF;"><a href="/read_notice?notice_no=${row.board_notice_no}">${row.board_notice_title}</a></div>
	    	<div align="center" style="flex:1;font-size:25px;margin-right:5px;background:#D2DEEF;">${row.board_notice_counter}</div>
	    	<div style="flex:1;"></div>
	    </div>
    </c:forEach>
    
    <!-- 글쓰기로 이동 -->
    <div class="col-lg-12" align="right" style="display:flex;">
    	<div style="flex:1;"></div>
    	<div style="flex:11;"><button type="button" onclick="javascript:fnWriteNotice(0)"><strong style="font-style:bold; font-size:20px;">글쓰기</strong></button></div>
    	<div style="flex:1;"></div>
    </div>
    
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>
    
</body>
</html>
