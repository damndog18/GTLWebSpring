<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" session="false" contentType="text/html; utf-8" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../res_include/res_head.jsp"></jsp:include>
</head>
<script>
	var d = new Date();
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
    	
    <div style="display:flex; margin-right: 100px">
    	<div style="font-size:20px;flex:10" ></div>
    	<div style="font-size:20px;flex:1;margin-right: 30px" >	
           	<input type="date" ></input>
        </div>
		<div style="font-size:20px;flex:1;" >
	    	<select>
	    		<option>전   체</option>
	    		<option>김과장</option>
	    		<option>박차장</option>
	    		<option>양계장</option>
	    	</select>
	    </div>
	    <div style="font-size:20px;flex:1;" ><button>검색</button></div>
    </div><br/>
    <!-- 출력화면 제목 -->
    <div style="display:flex;height:40px;text-align:center;margin-bottom: 5px;">
    	<div style="flex:1"></div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">등 록 일 자</div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">등 록 자 명</div>
    	<div style="flex:5;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">
    		제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#5b9bd5;color:white">조 회 수</div>
    	<div style="flex:1"></div>
    </div>
    <div style="display:flex;height:40px;margin-bottom: 5px;">
    	<div style="flex:1"></div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#D2DEEF"></div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#D2DEEF;"></div>
    	<div style="flex:5;font-size:25px;margin-right:5px;background:#D2DEEF;"></div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#D2DEEF;"></div>
    	<div style="flex:1"></div>
    </div>
    <div style="display:flex;height:40px;margin-bottom: 5px;">
    	<div style="flex:1"></div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#EAEFF7"></div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#EAEFF7;"></div>
    	<div style="flex:5;font-size:25px;margin-right:5px;background:#EAEFF7;"></div>
    	<div style="flex:2;font-size:25px;margin-right:5px;background:#EAEFF7;"></div>
    	<div style="flex:1"></div>
    </div><br>
    
    
    
    
    
    
    
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>
    
</body>
</html>
