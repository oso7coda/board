<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	
<%@ include file="/include/jquery.jsp"%>
	
</script>
</head>
<body>

	<!--상단바  -->
	<%@ include file="/layout/header.jsp"%>

	<!--본문-->
	<div class="container-fluid">
	<!--네비  -->
	<%@ include file="/layout/left.jsp"%>
			<!-- 본문 -->
			<div class="container">
				<h2>게시판 생성</h2>

				<form action="pboard.do" method="post">
					<div class="form-group">
						<label for="usr">게시판 이름:</label> <input type="text"
							class="form-control" id="usr">
					</div>
					<button type="button" class="btn">완료</button>
					<button type="button" class="btn">취소</button>

				</form>
			</div>


			<!--본문끝  -->
	</div>


</body>
</html>