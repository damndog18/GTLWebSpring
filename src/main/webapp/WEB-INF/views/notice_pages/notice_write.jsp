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
                <strong style="font-size:50px ">공지사항 입력</strong><br/>
            </div>            
        </div>
    </div><br/>
    	
    <div class="row" align="center">
    	<div class="col-lg-12" align="center">
    		<form method="post" action="/input_notice">
    			<input type="hidden" name="sawon_id" value="${sessionScope.loggedid}">
	    		<strong style="font-style:bold; font-size:20px;">제 목 : </strong><input style="width:50%; border:solid navy;" id="input_notice_title" name="input_notice_title" type="text"><br/><br/>
	    		<strong style="vertical-align:top; font-style:bold; font-size:20px;">본 문 : </strong><textarea id="input_notice_note" name="input_notice_note" style="border:solid navy;" rows="30%" cols="133%" maxlength="500" placeholder="본문 입력"></textarea><br/><br/>
	    		<button type="submit"><strong style="font-style:bold; font-size:20px;">작성 완료</strong></button>
    		</form>   		
    	</div>    	
    </div>    
    
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>
    
</body>
</html>
