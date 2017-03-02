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
                <strong style="font-size:50px ">업무일지 조회</strong><br/>
            </div>
            
        </div>
    </div><br/>
    <div>
	    <div align="center" style="font-size:25px;text-decoration: underline;flex:8 ">
			    		<script>document.write(
			    			d.getFullYear()+"년 " +(d.getMonth()+1)+"월 "+d.getDate()+"일 입니다.")</script>
		</div>
	</div>	
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
    <div style="display:flex;height:30px;text-align:center;margin-bottom: 5px;">
    	<div style="flex:1"></div>
    	<div style="flex:2;font-size:20px;margin-right:5px;background:#5b9bd5;color:white">직원명</div>
    	<div style="flex:3;font-size:20px;margin-right:5px;background:#5b9bd5;color:white">계획된 주요 업무</div>
    	<div style="flex:3;font-size:20px;margin-right:5px;background:#5b9bd5;color:white">추가된 업무, 협조 및 개선사항</div>
    	<div style="flex:3;font-size:20px;margin-right:5px;background:#5b9bd5;color:white">완료 여부 및 진행 상황</div>
    	<div style="flex:1"></div>
    </div>
    <div style="display:flex;height:20px;margin-bottom: 5px;">
    	<div style="flex:1"></div>
    	<div style="flex:2;font-size:15px;margin-right:5px;background:#D2DEEF"></div>
    	<div style="flex:3;font-size:15px;margin-right:5px;background:#D2DEEF;"></div>
    	<div style="flex:3;font-size:15px;margin-right:5px;background:#D2DEEF;"></div>
    	<div style="flex:3;font-size:15px;margin-right:5px;background:#D2DEEF;"></div>
    	<div style="flex:1"></div>
    </div>
    <div style="display:flex;height:20px;margin-bottom: 5px;">
    	<div style="flex:1"></div>
    	<div style="flex:2;font-size:15px;margin-right:5px;background:#EAEFF7"></div>
    	<div style="flex:3;font-size:15px;margin-right:5px;background:#EAEFF7;"></div>
    	<div style="flex:3;font-size:15px;margin-right:5px;background:#EAEFF7;"></div>
    	<div style="flex:3;font-size:15px;margin-right:5px;background:#EAEFF7;"></div>
    	<div style="flex:1"></div>
    </div></br>
    
    
    
    
    
    
    
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>
    
</body>
</html>
