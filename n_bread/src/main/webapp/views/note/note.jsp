<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member, note.model.vo.Note"%>
<%
	Member member = (Member)request.getAttribute("member");
	Note note = (Note)request.getAttribute("note");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nbread note</title>

<link rel="stylesheet" type="text/css" href="/comi/views/note/note.css"/>



</head>
<body>



 <div class="modal">
      <div class="modal_body">Modal</div>
    </div>
    <button class="btn-open-popup">Modal 띄우기</button>
    
      
         <form action="/comi/noinsert" method="post">     
       <table id="outer" align="center" width="600" cellspacing="5" cellpadding="0">
        <tr> <th colspan="2"> 쪽지 쓰기 </th></tr>
        <tr><th width="120">받는 사람 </th>
    	 <td><input type="text" name="" value="" >
		</td></tr>
		  <tr><th width="120">제목 </th>
    	 <td><input type="text" name="" value="" >
    	<tr><th>내용</th>
       <td><textarea></textarea></td></tr>
  	  <tr><th width="120">받는 사람 </th>
    	 <td><input type="text" name="" value="" >
      
      </table>
           </form>
  
</body>
</html>