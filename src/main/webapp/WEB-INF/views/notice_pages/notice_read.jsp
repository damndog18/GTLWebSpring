<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page pageEncoding="utf-8" session="true" contentType="text/html; utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../res_include/res_head.jsp"></jsp:include>
</head>
<script>
	function fnUpdateNotice(notice_no){
		location.href="/notice_write?notice_no=" + notice_no;
	}
	function fnDeleteNotice(notice_no){
		
		confirmToDelete = confirm("정말 삭제 하시겠습니까?");
		
		if(confirmToDelete == true){
			location.href="/delete_notice?notice_no=" + notice_no;
		}
		else{
			alert("취소하셨습니다.")
		}
	}
</script>
<body>
	
	<jsp:include page="../res_include/res_top.jsp"></jsp:include>
	
    <!-- Page Content -->
    <br/>
    <div class="container" >
        <div >
            <div align="center">
                <strong style="font-size:50px;">공지 사항</strong><br/>
            </div>            
        </div>
    </div><br/><br/>
    	
    <!-- 출력화면 제목 -->
    <div style="display:flex;height:40px;text-align:center;margin-bottom: 5px;">
    	<div style="flex:1"></div>
    	<div style="flex:11;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">${readNotice.board_notice_title}</div>
    	<div style="flex:1"></div>
    </div>
    <div style="display:flex;height:40px;text-align:center;margin-bottom: 5px;">
    	<div style="flex:8"></div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#D2DEEF;">${fn:substring(readNotice.board_notice_input_time, 0, 11)}</div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#D2DEEF;">${readNotice.sawon_id}</div>
    	<div style="flex:1"></div>
    </div>
    <div style="display:flex;margin-bottom: 5px;">
    	<div style="flex:1"></div>
    	<div style="flex:11;font-size:25px;margin-right:5px;"><pre style="font-size:15px;">${readNotice.board_notice_note}</pre></div>
    	<div style="flex:1"></div>
    </div><br>
    <div style="display:flex;height:40px;text-align:center;">
    	<div style="flex:10"></div>
    	<div style="flex:2;"><button type="button" style="width:150px; height:40px; border-color:black; background-color:gray;" onclick="javascript:fnUpdateNotice(${readNotice.board_notice_no})"><strong style="font-style:bold; font-size:20px;">수 정</strong></button></div>
    	<div style="flex:2;"><button type="button" style="width:150px; height:40px; border-color:black; background-color:gray;" onclick="javascript:fnDeleteNotice(${readNotice.board_notice_no})"><strong style="font-style:bold; font-size:20px;">삭 제</strong></button></div>
    	<div style="flex:1"></div>
    </div>  
    
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>
    
</body>
</html>
