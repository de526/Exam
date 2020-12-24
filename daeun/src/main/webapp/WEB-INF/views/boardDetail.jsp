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
window.onload = function(){
	$("#update").css("display", "none");
	}

	function updateBoard(){
		$("#content").removeAttr("readonly");
		$("#update").css("display", "block");
		$("#normal").css("display", "none");
	}
	function replyBoard(){
		location.href="./replyBoard.do?seq=${dto[0].seq}";
	}

</script>

<div class="container">
  <h2>상세글 보기 </h2>
  <form action="./updateBoard.do">
    <div class="form-group">
    <input type="hidden" name="seq" value="${dto[0].seq }">
      <label for="id">아이디</label>
      <input type="text" class="form-control" id="id" readonly="readonly" value="${dto[0].id}">
    </div>
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" readonly="readonly" value="${dto[0].title }">
    </div>
    <div class="form-group">
 		<label for="content">내용</label>
 	 	<textarea class="form-control" rows="5" id="content" name="content" readonly="readonly" >${dto[0].content }</textarea>
	</div>
	<div id="normal">
	<c:if test="${sessionScope.mdto != null }">
		<input type="button" class="btn btn-primary" value ="글 수정" onclick="updateBoard()">
		<input type="button" class="btn btn-info" value="답글 입력" onclick="replyBoard()">
	</c:if>
	<input type="button" class="btn btn-success"  value ="글 목록" onclick="location.href='./boardList.do'">
	</div>
	<!-- 	글 수정할때만 보여지는 버튼 -->
	<div id="update">
	<input type="submit" class="btn btn-primary" value ="수정완료">
	<input type="button" class="btn btn-success" value ="수정취소" onclick="history.back()">
	</div>

 </form>
</div>
</body>
</html>