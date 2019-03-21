<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery,min.js"></script>
<script>
$(function(){
	$("#btn-sned").click(function(){
	var num1 = $("#intNum1").val();
	var num2 = $("#intNum2").val();
	
	// Ajax를 사용해서 controller에게 두 값을 보내겠다.
	$.ajax({
		url : "{pageContext.request.contextPath}/add-ajax",
		method : "POST",
		data : {intNum1 : num1, intNum2 : num2},
		// json형태로 intNum1을 num1으로 바꾼다음에 url로 보내라
		success : function(result){
		 // span tag의 id c-add인 곳에 표시
		 $("#c-add").text(result)
		 
		 },
		 error : funtion(xhr,status,err){
		 alert(err)
	})
	
	})
	
	})
</script>
</head>
<body>

	<form action="calc-vo" method="POST">
	<p>숫자 1: <input type="text" id="intNum1" name="intNum1" value="${CALC.intNum1}">
	<p>숫자 2: <input type="text" id="intNum2" name="intNum2" value="${CALC.intNum2}">
	<p><button id="btn-send" type="button">계산</button>
	</form>
	<hr/>
	<p>덧셈 : <span id="c-add">0</span></p>
	<p>뺄셈 : <span id="c-minus">0</span></p>
	<p>곱셈 : <span id="c-multi">0</span></p>
	<p>나눗셈 :<span id="c-devide">0</span></p>
</body>
</html>