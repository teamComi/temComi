<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="qna.model.vo.Qna" %>
<%    
    Qna qna = (Qna)request.getAttribute("qna");
    int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comi</title>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

<h1 align="center"><%= qna.getQaNum() %>번 게시글 수정페이지</h1>
<br>

<%-- [ 보 류 ] 원글 수정 폼 : 첨부파일 수정 기능 포함 --%>
<%-- [ 보 류 ] 댓글, 대댓글 수정 폼 --%>

</body>
</html>