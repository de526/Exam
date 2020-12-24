<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
		width: 70%;
}
</style>
</head>
<body>
<script type="text/javascript">
function writeBoard(){
	document.writeForm.action="./insert.do";
	document.writeForm.submit();
}
function writeReply(){
	document.writeForm.action="./writeReply.do";
	document.writeForm.submit();
}
</script>

<div class="container">
  <h2>글 입력</h2>
  <form name="writeForm">
    <div class="form-group">
      <label for="id">아이디</label>
      <input type="text" class="form-control" id="id" name="id" value="${sessionScope.mdto.id}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" name="title">
    </div>
    <div class="form-group">
 		<label for="content">내용</label>
 	 	<textarea class="form-control" rows="5" id="content" name="content" ></textarea>
	</div>
	<div>
	<c:choose>
		<c:when test="${empty seq}">
			<input type="button" class="btn btn-primary" value ="글  입력" onclick="writeBoard()">
		</c:when>
		<c:otherwise>
			<input type="hidden" value="${seq}" name="seq">				
			<input type="button" class="btn btn-primary" value ="답글 입력" onclick="writeReply()">
		</c:otherwise>
	</c:choose>
	<input type="button" class="btn btn-success"  value ="돌아가기" onclick="location.href='./boardList.do'">
	</div>
  </form>
</div>
</body>
</html>