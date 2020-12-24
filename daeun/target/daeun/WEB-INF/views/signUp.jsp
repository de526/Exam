<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<style type="text/css">
	.container{
		width: 50%;
	}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$('#id').keyup(function(){
		var id = $('#id').val();
		
		if(id.length < 5 || id.length > 20){
			$('#msg').css("color","red");
			$('#msg').html('아이디를 다시 입력해주세요');
			$('#idChk').val('0');
		}else{
			$.ajax({
			type : 'post',
			url : './idDuplicateCheck.do',
			data : 'id='+id,
			async : true,
			success : function(result){
// 				console.log(result);
				if(result == 'false'){
					$('#idChk').val('0');
					$('#msg').html('사용 불가능한 아이디입니다');
					$('#msg').css('color','red');
				}else{
					$('#idChk').val('1');
					$('#msg').html('사용가능한 아이디입니다');
					$('#msg').css('color','green');
				}
			},
			error : function(){
				console.log('잘못된 요청 값입니다.');
			}
			});//ajax
		}
	});		
});

function idChkVal(){
	var count = document.getElementById('idChk').value;
	if(count == 0){
		alert('아이디 중복체크 해주세요');
		return false;
	}else{
		return true;
	}
}

</script>
<body>
<div class="container">
  <h2>회원가입</h2>
  <form action="./signUp.do" onsubmit="return idChkVal();">
     <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" id="id" name="id">
      <input type="hidden" id="idChk">
	  <span id="msg"></span> 
    </div>
   <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" name="pw">
    </div>
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name">
    </div>
    <div>
    <input type="submit" class="btn btn-primary" value="회원가입">
    <input type="button" class="btn btn-success" value="돌아가기" onclick="location.href='./loginForm.do'">
    </div>
  </form>
</div>

</body>
</html>