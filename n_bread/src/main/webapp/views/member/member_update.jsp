<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>
<%-- <%
	//로그인 확인을 위해서 내장된 session 객체를 이용
	Member loginMember = (Member)session.getAttribute("loginMember");
%> --%>
<%
	Member member = (Member)request.getAttribute("member");
	Member loginMember = (Member)session.getAttribute("loginMember");
%>    

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>member_update</title>
<link rel="stylesheet" href="/comi/resources/css/member_update.css" />
<style type="text/css">
table th { background-color: orange }
table#outer { border: 2px solid navy; }
</style>
</head>
<body>
<h1 align="center">회원 정보 수정 페이지</h1>
<br>
<form action="/comi/mupdate" method="post">
<table id="outer" align="center" width="500" cellspacing="5" cellpadding="0">
<tr>
	<th colspan="2">정보 변경 후 수정하기 버튼을 누르세요.
	</th>
</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" value="<%= loginMember.getMeName() %>" readonly>
				</td>
			</tr>
			<tr>
				<th width="120">아이디</th>
				<td>
					<input type="text" name="id" value="<%= loginMember.getMeId() %>" readonly>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="M" checked>남자 &nbsp; 
					<input type="radio" name="gender" value="F"> 여자
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="tel" name="phone" value="<%= loginMember.getMePhone() %>">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td> 
					<input type="email" name="email" value="<%= loginMember.getMeEmail() %>">
				</td>
			</tr>
			
</table>
			<div class="meber-bottom-box">
					<input type="submit" value="수정하기" > &nbsp;
					<a href ="javascript:history.go(-1);">이전 페이지로 이동</a> &nbsp; 
					<a href="/comi/main.jsp">시작페이지로 이동</a> &nbsp;
					<a href="#">탈퇴하기</a>
			</div>
</form>
   <script src="/comi/resources/js/member_update.js"></script>
</body>
</head>
</html>