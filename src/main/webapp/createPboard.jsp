<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(function() {
		$('#pboard_btn').on('click', function(){
			temp = $("#inputdefault").val().trim();
			if(temp==""){
				alert("게시판 이름을 입력하세요")
			}else{
				$("#frm").submit();
			}
			
			
		})
		
		
	})
</script>
</head>
<body>
	
	<!--상단바  -->
				<%@ include file="/layout/header.jsp"%>
	<!--네비  -->
				<%@ include file="/layout/left.jsp"%>
	
	<!--본문-->
		<div class="container-fluid">
		
				<!-- 본문 -->
				<h1 style="padding: 20px">  게시판 추가</h1>
				<div class="col-xs-4">
				<form id="frm" action="createPboard.do" method="post">
					<label for="inputdefault">게시판 이름</label> <input
						class="form-control" id="inputdefault" name="pboard_name" type="text">
					<button id="pboard_btn" type="button" class="btn btn-primary">생성하기</button>
				</form>
						
			</div>
				
				
				<!--본문끝  -->
		</div>
	<!--바깥 본문-->

</body>
</html>