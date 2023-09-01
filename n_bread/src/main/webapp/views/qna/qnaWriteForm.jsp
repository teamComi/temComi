<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="qna.model.vo.Qna, member.model.vo.Member"%>

<%
	
	Member member = (Member)request.getAttribute("member");
	Qna qna = (Qna)request.getAttribute("qna");
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comi</title>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<hr>

<h1 align="center">Qna 등록 페이지</h1>
<br>

<!-- form 에서 입력값들과 파일을 함께 전송하려면 반드시 속성
 enctype="multipart/form-data" 를 추가해야함 -->

<form action="/comi/qinsert" method="post" enctype="multipart/form-data">
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th>제 목</th>
		<td><input type="text" name="title" size="50"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="writer" 
		readonly value="14"></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" name="upfile"></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="5" cols="50" name="content"></textarea></td>
	</tr>
	<tr>
		<th>신 고 내 용</th>
		<td><textarea rows="5" cols="50" name="report"></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="등록하기"> &nbsp; <!-- [/comi/comi/qlist]로 연결 X -->
			<input type="reset" value="작성취소"> &nbsp;
			<input type="button" value="목록" 
			onclick="javascript:location.href='/comi/qlist?page=1'; return false;">
		</th>
	</tr>
</table>
</form>
<br>

<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>