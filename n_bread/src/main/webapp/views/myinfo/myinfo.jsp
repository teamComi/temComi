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
	 window.location.href = '/comi/views/note/note.html';
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



	
		<div class="infonav">
			<ul>
				<br>
				<br>
				<br>

				<span></span><a href="/comi/views/note/note.html">

						<button style="border:none; "class="btn-open-popup" onclick="moveToNote()">쪽지함</button>


				</a></span>
				<br>
				<span></span><a href="#"> <i class="pointbox"></i> <span
						class="nav-item">포인트 원 </span>
				</a></span>
				<br>
				<span class="nav-item"><a href="#" class="logout"> <b><i
						>Log out</i></b> 
				</a></span>
			</ul>
		</div>
		
		<div class="container">
		<section class="main">
			<div class="main-top">
				<h1><%=member.getMeAka() %>님의 프로필
				</h1>
				<i class="userprofile"></i>
			</div>
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

				<div class="card">

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
				<div class="card">

					<h3>인기도</h3>
					<p>
						<%=member.getMeLike() %>점
					</p>
					<!-- <button>Get Started</button> -->
				</div>
				<div class="card">

					<h3>팔로잉</h3>
					<br>
					<h2>?</h2>
				</div>
			</div>

			<!-- 하단-->
			<br>
			<br>
			<br>
			<section class="main-course">

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

						</div>
					</div>
				</div>
			</section>
		</section>

		<div class="modal_popup"></div>

	</div>


	<footer>
		<%@ include file="../common/footer.jsp"%>
	</footer>
</body>
</html>