<%@page import="member.model.vo.Member"%>
<%@page import="party.model.vo.Party"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Party party = (Party) request.getAttribute("party");
	Member member = (Member) request.getAttribute("member");
%>
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
							<img src="/comi/resources/images/launcher.png" />
						</div>
						<div id="article-profile-left">
							<div id="article-nickname"><%= member.getMeAka() %></div>
							<div id="article-region-name"><%= party.getPaLocation() %></div>
						</div>
					</div>
					<div class="article-profile-right">
						<div class="temperature-wrap">
							<span>신뢰도</span>
							<span class="text-color text-color-03" id="text-color-id"><%= member.getMeLike() %>>%</span>
						</div>
						<div class="meters">
							<div class="bar bar-color-03" 
							id="bar-color-id" style="width:<%= member.getMeLike() %>%;"></div>
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
		  	<%= party.getCatNum() %><br>
		  <span id="article-befordate">
			<%= party.getPaEnroll() %>
		  </span>
		</p>
		<p id="article-location">
			<%= party.getPaLocation() %>
		</p>
		<div id="article-price-box">
			
			<div id="article-deposit">예치금 : <%= party.getPaDeposit() %>원</div>
			<div id="article-bar-box">
				<span id="article-price-bar"></span>
				<span id="article-deposit-bar" style="width:<%= (party.getPaDeposit() == 0) ? 0 : party.getPaDeposit()/party.getPaTotalAmount() * 100 %>%"></span>
			</div>
			<div id="article-price">가격 : <%= party.getPaTotalAmount() %>원</div>

			<div class="article-people-box">
				<div id="article-people">모집인원 <%= party.getPaTotalNum() %>명</div>
				<div id="article-people-price">인당 <%= party.getPaPerAmount() %>원</div>
			</div>
		</div>
		<div id="article-detail">
			<p>
				<%= party.getPaCon() %>
			</p>
		</div>
		<p id="article-counts">
			찜 <%= party.getPaLike() %> ∙ 조회 <%= party.getPaViews() %>
		</p>
	</section>
	<!-- 게시글 end-->

	
</body>
</html>