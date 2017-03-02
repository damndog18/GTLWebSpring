<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" session="false" contentType="text/html; utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<jsp:include page="../res_include/res_head.jsp"></jsp:include>
<script>
	function popupOpen(message){
		var popUrl = message;
		if(popUrl != "writeEndBrief"){
			var popOption = "left=400,top=50,width=600, height=700";
		}
		else{
			var popOption = "left=400,top=10,width=1200, height=900";
		}
		window.open(popUrl,"",popOption );
	}
</script>
<body>
	
	<jsp:include page="../res_include/res_top.jsp"></jsp:include>
	
    <!-- Page Content -->
    <br/>
    <div class="container">
        <div class="row" style="">
            <div class="col-lg-12" align="center">
                <strong style="font-size:50px ">업무일지 등록</strong><br/>
            </div>
        </div>
    </div><br/><br/>
    <div class="container" align="center">
	    <div >
	    	<button style="background:black;width:500px;height:120px;border-radius:20px; " > 
	    		<div style="color:white; font-size:30px"><a href="javascript:popupOpen('writeStartBrief')">계획된 주요 업무</a></div>
		    	<div style="color:white; font-size:15px">(오전 8시 50분까지 작성)</div>
	    	</button>
	    </div><br/>
	    <div >
	    	<button style="background:black;width:500px;height:120px;border-radius:20px; " > 
	    		<div style="color:white; font-size:30px"><a href="javascript:popupOpen('writeUpdateBrief')">추가된 업무, 협조 및</a> </div>
		    	<div style="color:white; font-size:30px"><a href="javascript:popupOpen('writeUpdateBrief')">개선 필요 사항</a></div>
		    	<div style="color:white; font-size:15px">(오후 17시 50분까지 작성)</div>
	    	</button>
	    </div><br/><div >
	    	<button style="background:black;width:500px;height:120px;border-radius:20px; " > 
	    		<div style="color:white; font-size:30px"><a href="javascript:popupOpen('writeEndBrief')">완료 여부 및</a></div>
		    	<div style="color:white; font-size:30px"><a href="javascript:popupOpen('writeEndBrief')">진행 상황</a></div>
		    	<div style="color:white; font-size:15px">(오후 17시 50분까지 작성)</div>
	    	</button>
	    </div><br/>
    </div>
    
    <jsp:include page="../res_include/res_bottom.jsp"></jsp:include>
    
</body>
</html>
