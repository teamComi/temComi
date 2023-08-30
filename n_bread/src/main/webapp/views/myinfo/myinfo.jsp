<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>

<%
	Member member = (Member)request.getAttribute("member");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<title>nbread</title>
<link rel="stylesheet" type="text/css"
	href="/comi/views/myinfo/myinfo.css" />
<style type ="text/css">


</style>
<!-- 노트 modal 창 스크립트 -->

<script type="text/javascript"> 
 
function moveToNote(){
	 window.location.href = '/comi/views/myinfo/myinfo.jsp';
	 const modal = document.querySelector('.modal');
     const btnOpenPopup = document.querySelector('.btn-open-popup');

     btnOpenPopup.addEventListener('click', () => {
       modal.style.display = 'block';
     });
     
     
     document.addEventListener("DOMContentLoaded", function() {
   	    document.body.style.overflow = 'hidden';  // 또는 'auto'
   	});
     
     modal.classList.add('show');
 }
 
      const body = document.querySelector('body');
      const modal = document.querySelector('.modal');
      const btnOpenPopup = document.querySelector('.btn-open-popup');

      btnOpenPopup.addEventListener('click', () => {
        modal.classList.toggle('show');

        if (modal.classList.contains('show')) {
          body.style.overflow = 'hidden';
        }
      });

      modal.addEventListener('click', (event) => {
        if (event.target === modal) {
          modal.classList.toggle('show');

          if (!modal.classList.contains('show')) {
            body.style.overflow = 'auto';
          }
        }
      });
    </script>




</head>
<body>


	<header>
		<%@ include file="../common/header.jsp"%>
	</header>

		<nav class="infonav">
			<ul>
				<br>
				<br>
				<br>

				<span></span><!-- <a href="/comi/views/note/note.html"> -->
						<a href="/comi/views/note/note.jsp">
						<button style="border:none; background-color: transparent; cursor:pointer;" "class="btn-open-popup" onclick="moveToNote()">쪽지함</button>


				</a></span>
				<br>
				<span></span><a href="#"> <i class="pointbox"></i> <span
						class="nav-item">포인트 <%=member.getMePoint() %>원 </span>
				</a></span>
				<br>
				<span class="nav-item"><a href="#" class="logout"> <b><i
						>Log out</i></b> 
				</a></span>
			</ul>
		</nav>
		
		<div class="container">
		<section class="main">
			<div class="main-top">
				<h1><%=member.getMeAka() %>님의 프로필
				</h1>
				<i class="userprofile"></i>
			
			<div class="main-skills">
				<div class="card">
					<i class="fas fa-laptop-code"></i>
					<p>
						<img>
						<%=member.getMePhotoAdd() %>
					</p>
					<br>

					<h4><%=member.getMeAka() %></h4>
					<button
						onclick="javascript:location.href='/comi/moveup?meId=<%= member.getMeId()%>';">프로필
						편집</button>
				</div>

				<div class="category">

					<h3># I 대분류 카테고리</h3>
					<table>
						<tr>
							<td>#넷플릭스</td>
							<td>#소분류</td>
						</tr>
						<tr>
							<td>#디즈니플러스</td>
							<td>#영화</td>
						</tr>

						<tr>
							<td>#맛집</td>
							<td>#<%= member.getCatNum() %></td>
						</tr>

					</table>
					<button
						onclick="javascript:location.href='/comi/movecategory?meId=<%= member.getMeId()%>';">관심사
						편집</button>
				</div>
				<div class="like">

					<h3>인기도</h3>
					<p>
						<%=member.getMeLike() %>점
					</p>
					<!-- <button>Get Started</button> -->
				</div>
				<div class="following">

					<h3>팔로잉</h3>
					<br>
					<h2>?</h2>
				</div>
			</div>
		</div>
			<!-- 하단-->
			<br>
			<br>
			<br>
			<section class="review_recommend">

				<div class="course-box">

					<div class="course">
						<div class="box">
							<h3><%=member.getMeAka() %>님의 모임에 대한 후기
							</h3>
							<table>
								<tr>
									<td>즐거웠습니다.</td>
								</tr>
								<tr>
									<td>즐거웠습니다2.</td>
								</tr>
								<tr>
									<td>즐거웠습니다3.</td>
								</tr>
							</table>
							<button>continue</button>

						</div>

						<div class="box">
							<h3>새로운 공유 활동 추천</h3>
							<table class="recommend" border="1">

								<tr>
									<!-- 첫번째 줄 시작 -->
									<h4>
										<td>첫번째 칸</td>
										<td>두번째 칸</td>
									</h4>
								</tr>
								<!-- 첫번째 줄 끝 -->
								<tr>
									<!-- 두번째 줄 시작 -->
									<h4>
										<td>첫번째 칸</td>
										<td>두번째 칸</td>
									</h4>
								</tr>
								<!-- 두번째 줄 끝 -->

							</table>

							<button>continue</button>
		<table class="profile" >

								<tr>
									
									<h4>
										<td>회원번호 : <%=member.getMeNum() %></td>
										<td>회원아이디 : <%=member.getMeId() %></td>
										<td>회원이름 : <%=member.getMeName() %></td>
									</h4>
								</tr>
								
								<tr>
									
									<h4>
										<td>회원 비밀번호 : <%=member.getMePwd() %> </td>
										<td>회원 로그인 시도 : <%=member.getMeCPwd() %></td>
										<td>회원 인증여부 : <%=member.getMeCer() %></td>
									</h4>
								</tr>
								
								<tr>
									
									<h4>
										<td>회원간편로그인 유무 : <%=member.getMeLoginType() %></td>
										<td>회원이메일 : <%=member.getMeEmail() %></td>
										<td>회원핸드폰 : <%=member.getMePhone() %></td>
									</h4>
								</tr>
								<tr>
								
									<h4>
										<td>회원주소 : <%=member.getMeAdd() %></td>
										<td>회원성별 : <%=member.getMeGender() %></td>
										<td>회원생일 : <%=member.getMeBDay() %></td>
									</h4>
								</tr>
								<tr>
									
									<h4>
										<td>회원가입일 : <%=member.getMeEnroll() %></td>
										<td>회원닉네임 : <%=member.getMeAka() %></td>
										<td>회원인기도 : <%=member.getMeLike() %></td>
									</h4>
								</tr>
								<tr>
									
									<h4>
										<td>회원사진저장위치 : <%=member.getMePhotoAdd() %></td>
										<td>회원관리자여부 : <%=member.getMeAdmin() %></td>
										<td>회원차단여부 : <%=member.getMeBan() %></td>
									</h4>
								</tr>
								<tr>
									
									<h4>
										<td>회원포인트 : <%=member.getMePoint() %></td>
										<td>회원정보수정일 : <%=member.getMeModDate() %></td>
										<td>회원관심사카테고리 : <%=member.getCatNum() %></td>
									</h4>
								</tr>
							</table>

						</div>
					</div>
				</div>
			</section>
		</section>

		<div class="note_modal"> 
		
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
       <tr><th width="120">날짜 </th>
    	 <td> sysdate 출력
       <tr><th width="120">수신확인 여부</th>
    	 
    	 <tr><th colspan="2">
    	 <input type="submit" value="보내기"> &nbsp;
    	 <input type="reset" value="취소">&nbsp;
      </table>
           </form>
		
		
		
		</div>

	</div>


	<footer>
		<%@ include file="../common/footer.jsp"%>
	</footer>
</body>
</html>