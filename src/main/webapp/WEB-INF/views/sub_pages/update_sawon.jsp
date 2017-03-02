<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" session="true" contentType="text/html; utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<jsp:include page="../res_include/res_head.jsp"></jsp:include>
<script>
	
</script>
<body>

	<jsp:include page="../res_include/res_top.jsp"></jsp:include>
	
    <div align="center">
    	<br/><br/><strong style="font-size:45px; font-style:bold;">사원 정보 수정</strong><br/><br/><br/><br/>
    	<form method="post" action="/update_sawon">
    		<strong style="font-size:20px; font-style:bold;">아이디 : </strong><input type="text" id="sawon_id" name="sawon_id" value="${sessionScope.loggedid}"><br/><br/>
    		<strong style="font-size:20px; font-style:bold;">패 스 1 : </strong><input type="password" id="sawon_pass" name="sawon_pass"><br/><br/>
    		<strong style="font-size:20px; font-style:bold;">패 스 2 : </strong><input type="password" id="sawon_pass_2" name="sawon_pass_2"><br/><br/>
    		<strong style="font-size:20px; font-style:bold;">이   름 : </strong><input type="text" id="sawon_name" name="sawon_name"><br/><br/>
    		<strong style="font-size:20px; font-style:bold;">직   급 : </strong><input type="text" id="sawon_position" name="sawon_position"><br/><br/><br/><br/>
    		<button type="submit" style="border-color:black; background-color:gray;"><strong style="font-style:bold; font-size:20px;">입력 완료</strong></button>
    	</form>
    </div>
        
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>

</body>
</html>