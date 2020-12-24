<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
	.container{
		width: 50%;
	}
</style>
</head>
<body>
<div class="container">
<br><br>
<h2>로그인</h2>  <br>
  <form action="./login.do" method="post" >
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input id="id" type="text" class="form-control" name="id" placeholder="id">
    </div>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="pw" type="password" class="form-control" name="pw" placeholder="Password">
    </div>
    <br>
    <div>
    <input type="submit" class="btn btn-primary" value="로그인">
    <input type="button" class="btn btn-success" value="회원가입" onclick="location.href='./signUpForm.do'">
    </div>
  </form>
  
</div>
</body>
</html>