<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" session="true" contentType="text/html; utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<jsp:include page="../res_include/res_head.jsp"></jsp:include>
<script>
	function fnInputComplete(){
		location.href="/";
	}
</script>
<body>

	<jsp:include page="../res_include/res_top.jsp"></jsp:include>
	
    <div align="center">
    	<br/><br/><strong style="font-size:45px; font-style:bold;">사원 정보 입력 완료</strong><br/><br/><br/><br/>
    	<h1>${inputSawon}</h1><br/><br/>
    	<button type="button" style="width:180px; height:50px; border-color:black; background-color:gray;" onclick="javascript:fnInputComplete()"><strong style="font-style:bold; font-size:20px;">입력 완료</strong></button>
    </div>
        
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>

</body>
</html>