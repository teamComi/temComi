<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 프로필 -->
	<section id="article-profile">
		<div class="article-profile-box">
			<a class="article-profile-link" href="#">
				<div class="space-between">
					<div class="display-align-items-center">
						<div id="article-profile-image-box">
							<img src="" />
						</div>
						<div id="article-profile-left">
							<div id="article-nickname"><%=  %></div>
							<div id="article-region-name"></div>
						</div>
					</div>
					<div class="article-profile-right">
						<div class="temperature-wrap">
							<span>신뢰도</span>
							<span class="text-color text-color-03" id="text-color-id"></span>
						</div>
						<div class="meters">
							<div class="bar bar-color-03" id="bar-color-id"></div>
						</div>
						<div class="temperature-face">
							<img id="temperature-face-id" src="/comi/resources/images/launcher.png" />
						</div>
					</div>
				</div>
			</a>
		</div>
	</section>
	<!-- 프로필 end-->
	
	<!-- 게시글 -->
	<section id="article-description">
		<h1 id="article-title"></h1>
		<p id="article-category">
		  모임 ∙
		  <span id="article-befordate">
			
		  </span>
		</p>
		<p id="article-location">

		</p>
		<div id="article-price-box">
			
			<div id="article-deposit"></div>
			<div id="article-bar-box">
				<span id="article-price-bar"></span>
				<span id="article-deposit-bar"></span>
			</div>
			<div id="article-price"></div>

			<div class="article-people-box">
				<div id="article-people"></div>
				<div id="article-people-price"></div>
			</div>
		</div>
		<div id="article-detail">
			<p>
				
			</p>
		</div>
		<p id="article-counts">
			
		</p>
	</section>
	<!-- 게시글 end-->

	
</body>
</html>