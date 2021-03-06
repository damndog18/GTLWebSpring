<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" session="true" contentType="text/html; utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../res_include/res_head.jsp"></jsp:include>
</head>
<script>
	
</script>
<body>
	
	<jsp:include page="../res_include/res_top.jsp"></jsp:include>
	
    <!-- Page Content -->
    <br/>
    <div class="container" >
        <div >
            <div align="center">
                <strong style="font-size:50px ">${writeTitle}</strong><br/>
            </div>            
        </div>
    </div><br/>
    	
    <div class="row" align="center">
    	<div class="col-lg-12" align="center">
    		<form method="post" action="/input_notice">
    			<input type="hidden" name="sawon_id" value="${sessionScope.loggedid}">
    			<c:choose>
	    			<c:when test="${param.notice_no != 0}">
	    				<input type="hidden" name="notice_no" value="${writeUpdate.board_notice_no}">
	    				<strong style="font-style:bold; font-size:20px;">제 목 : </strong><input style="width:50%; border:solid navy;" id="board_notice_title" name="board_notice_title" type="text" value="${writeUpdate.board_notice_title}"><br/><br/>
	    				<strong style="vertical-align:top; font-style:bold; font-size:20px;">본 문 : </strong><textarea id="board_notice_note" name="board_notice_note" style="border:solid navy;" rows="30%" cols="133%" maxlength="10000" placeholder="본문 입력 (10000자 까지)">${writeUpdate.board_notice_note}</textarea><br/><br/>
	    			</c:when>
	    			<c:otherwise>
	    				<input type="hidden" name="notice_no" value="${param.notice_no}">
	    				<strong style="font-style:bold; font-size:20px;">제 목 : </strong><input style="width:50%; border:solid navy;" id="board_notice_title" name="board_notice_title" type="text"><br/><br/>
	    				<strong style="vertical-align:top; font-style:bold; font-size:20px;">본 문 : </strong><textarea id="board_notice_note" name="board_notice_note" style="border:solid navy;" rows="30%" cols="133%" maxlength="10000" placeholder="본문 입력 (10000자 까지)"></textarea><br/><br/>
	    			</c:otherwise>
    			</c:choose>
	    		<button type="submit"><strong style="font-style:bold; font-size:20px;">작성 완료</strong></button>
    		</form>   		
    	</div>    	
    </div>
    
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>
    
</body>
</html>
