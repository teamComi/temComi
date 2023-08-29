<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comi : error</title>
</head>
<body>
<h1>오류 발생 : </h1>
<%-- jsp 내장객체중 exception 객체 사용:
	page 지시자 태그에 isErrorPage='true' 라고 지정 했을때만
	exception 내장객체를 사용할 수 있음
	jsp 페이지에서 발생한 에러(예외)를 자동으로 전달받게 됨
--%>
<%
	if(exception != null){	//jsp 페이지에서 발생한 에러이면 
%>
	<h3>jsp 페이지 오류 : <%= exception.getMessage() %></h3>
<%		
	}else{	//jsp 페이지 에러가 아니라면(서블릿에서 넘긴 exception라면)
%>	
	<h3>jsp 페이지 오류 : <%= request.getAttribute("message") %></h3>
<%	
	}
%>
<a href="/comi/main.html">메인페이지로 이동</a>

</body>
</html>