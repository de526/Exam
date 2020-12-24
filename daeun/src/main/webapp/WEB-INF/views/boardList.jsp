<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnswerBoardList</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
		width: 60%;
}
</style>
</head>

<body>
<script type="text/javascript">
$(function(){
	//체크박스 전체선택
    $("#checkAll").click(function(){
        var chk = $(this).is(":checked");
        if(chk) {
        	$(".checkOne").prop('checked', true);
        }else{
        	$(".checkOne").prop('checked', false);
        }
    });
});

function chkbox(){
	var chk = document.getElementsByName("seqs");
	for(i=0;i<chk.length;i++){
		if(chk[i].checked){
			return true;
		}
	}
		alert('한개 이상 체크해주세요 ');
		return false;
}


</script>
<div class="container">
  <h2>답변형 게시판</h2>
  <form action="./delete.do" onsubmit="return chkbox()">
  <div>
 	<input type="submit" class="btn btn-danger" value="선택 삭제" >
 	<c:if test="${sessionScope.mdto != null}">
 	<input type="button" class="btn btn-primary" value="글 입력" onclick="location.href='./writeBoard.do'"> 
 	</c:if>
  </div>
  <table class="table">
    <thead>
      <tr>
      	<th><input type="checkbox" id="checkAll"></th>
        <th>연번</th>
        <th>아이디</th>
        <th>제목</th>
        <th>등록일</th>
        <th>삭제여부</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${list }" var="board" varStatus="st">
		<tr>
			<td><input type="checkbox" class="checkOne" name="seqs" value="${board.seq}"></td>
			<td>${st.count }</td>
			<td>${board.id }</td>
			<td>
			<c:if test="${board.delflag eq 'Y' }">
				삭제된 글
			</c:if>
			<c:if test="${board.delflag eq 'N' }">
				<c:if test="${board.depth>0}">
					<c:forEach begin="1" end="${board.depth}">
						&nbsp;&nbsp;&nbsp;
					</c:forEach>
					ㄴ
				</c:if>
				<a href="./selectOne.do?seq=${board.seq}">${board.title }</a>
			</c:if>
			
			</td>
			<td>${board.regdate }</td>
			<td>${board.delflag }</td>		
		</tr>
	</c:forEach>
    </tbody>
  </table>
  </form>
</div>

</body>
</html>