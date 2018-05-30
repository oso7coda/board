<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<!--상단바  -->
				<%@ include file="/layout/header.jsp"%>

	<!--본문-->
		<div class="container-fluid">
			<!--네비  -->
				<%@ include file="/layout/left.jsp"%>
	
			<!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
				<!-- 본문 -->
				<a href="pboard.jsp">
					<h1 class="page-header">게시판목록</h1>
				</a>
				
				
				<!--본문끝  -->
			<!-- </div> -->
		</div>
	<!--바깥 본문-->
</body>
</html>