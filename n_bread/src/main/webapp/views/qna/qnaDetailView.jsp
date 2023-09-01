<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="qna.model.vo.Qna, member.model.vo.Member"%>
<%

	Member member = (Member)request.getAttribute("member");
	Qna qna = (Qna)request.getAttribute("qna");
	//int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	
	int nowpage = 1;
	if(request.getAttribute("currentPage") != null){
		nowpage = ((Integer)request.getAttribute("currentPage")).intValue();
	}
	
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nbread</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/jquery-ui.min.css"/>
	<link rel="stylesheet" href="/comi/resources/css/main.css"/>
	<link rel="stylesheet" href="/comi/resources/css/review.css"/>
	<link rel="stylesheet" href="/comi/resources/css/question.css"/>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/common.js"></script>
	<script type="text/javascript" src="/comi/resources/js/question.js"></script>

<script type="text/javascript">
function requestReply(){
	//댓글달기 요청 함수
}
function requestDelete(){
	//게시글(원글, 댓글, 대댓글) 삭제 요청 함수
}
function moveUpdatePage(){
	//게시글 (원글, 댓글, 대댓글) 수정 페이지로 이동 처리 함수
}

function showWriteForm(){
	location.href = "/comi/views/qna/qnaWriteForm.jsp";
}

</script>
</head>
<body>
<!-- Header Section Begin -->
    <header id="header_view">
    	<%@ include file="../common/header.jsp" %> 
    </header>
    <!-- Header Section End -->

	<!-- main -->
	<main class="main_wrapper">
		<div class="container">
			
			<!--상단-->
			<div class="search-container">
				<div class="qa-title">
					Q&A
				</div>
				<div class="search-box question">
					<button class="search-btn">
						<img src="/comi/resources/images/search_btn.png" class="search-image">
					</button>
					<input type="text" placeholder="제목을 입력해보세요." class="search-box-text" value="">
				</div>
			</div>
			<!--상단end-->

			<!--게시판-->
			<div class="qa_detail">
				<h3 align="center"><%= qna.getQaNum()%>번 글 상세보기</h3> <!-- 0으로 나옴 -->
			<br>

				<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
					
					<tr>
						<th width="120">제 목</th>
						<td><a href ="/comi/qdetail?qnum=<%= qna.getQaNum()%>&page=<%= nowpage %>"><%= qna.getQaTitle()%></a></td>
					</tr>
					<tr>
						<th width="120">작성자</th>
						<td><%= qna.getMeNum() %></td> <!-- 작성자 닉네임으로 바꿔야지, 현재는 "member" is null -->
					</tr>
					<tr>
						<th width="120">등록날짜</th>
						<td><%= qna.getQaEnroll() %></td>
					</tr>
					<tr>
					<th width="120">내 용</th>
					<td><%= qna.getQaCon() %></td>
					</tr>
					<tr>
					<th width="120">신고 내용</th>
					<td> <%= qna.getQaReportCon() %></td>
					</tr>
					
				</table>
			</div>
			<!--게시판end-->

			<!--버튼박스-->
			<div class="qa-container">
				<div class="qa-btnbox">
					<button class="qa-write-btn" id="my_write_btn">내가쓴글</button>
					<button class="qa-write-btn" id="write_btn" onclick="showWriteForm();">글쓰기</button>
				</div>
				
					<button class="qa_list" id="qa_list" onclick="javascript:location.href='/comi/qlist?page=1';"> 목록
						
					</button>
					
				</div>
			</div>
			<!--버튼박스end-->
			
		</div>
	</main>
	

	<!-- Footer Section Begin -->
	<footer id="footer_view">
		<%@ include file="../common/footer.jsp" %> 
	</footer>
	<!-- Footer Section End -->
</body>
</html>