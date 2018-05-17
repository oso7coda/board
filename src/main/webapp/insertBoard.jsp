<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="favicon.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/SE2/js/HuskyEZCreator.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	$('#formbtn').on('click', function(){
			board_title = $("#board_title").val().trim();

			if(board_title==""){
				alert("제목을 입력하세요");
				return;
			}else{
				$("#form").submit();
			}
			
		})
	
});//end



</script>

<style>
</style>
</head>
<body>
	<!--상단바  -->
	<%@ include file="/layout/header.jsp"%>
	<!--네비  -->
	<%@ include file="/layout/left.jsp"%>



	<!--본문-->
	<div class="container-fluid">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<!-- 본문 -->

				<!-- text line -->
				<div class="form-group col-xs-7">
				<h1>게시글 작성하기</h1>
			<form id="form" action="insertBoard.do" method="post"  enctype="multipart/form-data">
				<input type="hidden" name="pboard_seq" value="${pboard_seq}">
				<label for="usr">제목:</label> <input type="text" class="form-control" name="board_title" id="board_title" placeholder="제목을 입력하세요"> <br>

				<textarea name="board_content" name="board_content" id="smarteditor" rows="10" cols="100" style="width:776px; height:412px;"></textarea>
				<!--파일첨부 5개  -->
				<tr><td><input type="file" name="file_log"></td><td></td></tr>
				<tr><td><input type="file" name="file_log"></td><td></td></tr>
				<tr><td><input type="file" name="file_log"></td><td></td></tr>
				<tr><td><input type="file" name="file_log"></td><td></td></tr>
				<tr><td><input type="file" name="file_log"></td><td></td></tr>
				<button id="formbtn" type="button" class="btn btn-default">작성</button>
			</form>
			
			<form action="board.jsp" method="post">
					<button type="submit" class="btn btn-default">취소</button>
			</form>
				</div>

			<!--본문끝  -->
		</div>
	</div>
	<!--바깥 본문-->
</body>
</html>