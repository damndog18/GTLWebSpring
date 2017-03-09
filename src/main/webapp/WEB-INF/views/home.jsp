<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" session="true" contentType="text/html; utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<jsp:include page="res_include/res_head.jsp"></jsp:include>
<script>
	function fnInputSawon(){
		location.href="/sub_pages/input_sawon";
	}
	
	function fnUpdateSawon(){
		location.href="/sub_pages/update_sawon";
	}
</script>
<body>

	<jsp:include page="res_include/res_top.jsp"></jsp:include><br/><br/>
		
    <!-- Page Content -->
    <c:choose>
    <c:when test="${!empty sessionScope.loggedid}">
    <div class="container">
        <div class="row">
            <div class="col-lg-12" align="center">
                <img src="../resources/images/gtlLogo.bmp" width="40%" height="40%">
                <h2 style="font-style:bold; font-size:48px;">측량으로 세상을 밝히는 우주 최강 GTL TECH.CO</h2><br/><br/><br/>
            </div>
            <div class="col-lg-12" align="center">
            	<form method="post" action="/logout">
	            	<button type="submit" style="width:180px; height:50px; border-color:black; background-color:gray;"><strong style="font-style:bold; font-size:20px;">로그 아웃</strong></button>
            	</form><br/>
            	<button type="button" style="width:180px; height:50px; border-color:black; background-color:gray;" onclick="javascript:fnUpdateSawon()"><strong style="font-style:bold; font-size:20px;">정보 변경</strong></button>       	
            </div>
        </div>
    </div>
    </c:when>
    
    <c:otherwise>
    <div class="container">
        <div class="row">
            <div class="col-lg-12" align="center">
                <img src="../resources/images/gtlLogo.bmp" width="40%" height="40%">
                <h2 style="font-style:bold;">지금은 ${serverTime} 입니다.</h2><br/>
            </div>
            <div class="col-lg-12" align="center">
            	<form method="post" action="/login">
	            	<strong style="font-style:bold; font-size:25px;">ID : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="text" id="sawon_Id" name="sawon_Id"><br/><br/>
	            	<strong style="font-style:bold; font-size:25px;">PASS : </strong><input type="password" id="sawon_Pass" name="sawon_Pass"><br/><br/><br/>
	            	<button type="submit" style="width:180px; height:50px; border-color:black; background-color:gray;"><strong style="font-style:bold; font-size:20px;">로그인</strong></button>
            	</form><br/>
            	<button type="button" style="width:180px; height:50px; border-color:black; background-color:gray;" onclick="javascript:fnInputSawon()"><strong style="font-style:bold; font-size:20px;">직원 정보 입력</strong></button>            	
            </div>
        </div>
    </div>
    </c:otherwise>
    </c:choose>
    
    <jsp:include page="res_include/res_bottom.jsp"></jsp:include>

</body>
</html>