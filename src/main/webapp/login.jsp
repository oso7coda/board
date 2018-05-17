<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<link href="signin.css" rel="stylesheet">
	<!-- boot -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(function() {
		$("#mem_id").val("brown");
		$("#mem_pass").val("123");
		
		
	})
</script>
</head>
<body>
	
    <div class="container col-xs-6" >

      <form class="form-signin" action="main.do" method="post">
        <h2 class="form-signin-heading">hellow~!!</h2>
        <label for="inputEmail" class="sr-only">ID</label>
        <input name="mem_id" type="text" id="mem_id" class="form-control" placeholder="아이디를 입력하세요~"  autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="mem_pass" type="password" id="mem_pass" class="form-control" placeholder="비밀번호를 입력하세요!" >
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 아이디 기억하기
          </label>
        </div>	
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인하기</button>
      </form>

    </div> <!-- /container -->




    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>