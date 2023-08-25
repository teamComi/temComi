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
	<title>party_view</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/slick.min.css">
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/slick-theme.min.css">
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/jquery-ui.min.css"/>
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/party_view_click.css"/>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/lib/slick.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/common.js"></script>
	<script type="text/javascript" src="/comi/resources/js/clickView.js"></script>
	<script type="text/javascript" src="/comi/resources/js/makeParty.js"></script>
	<script type="text/javascript" src="/comi/resources/js/setParty.js"></script>
	<script type="text/javascript" src="/comi/resources/js/party_view_click.js"></script>
	
</head>
<body>
    <!-- Header Section Begin -->
    <header id="header_view">    
    </header>
    <!-- Header Section End -->

	<!-- main -->
	<main class="main_wrapper">
		<div class="container side_margin_zero">

			<!-- 슬라이더 -->
			<div class="main_slider">
				<div id="slider_main">
					
				</div>
			</div>
		</div>

		<div class="container">
			<!-- 채팅 리뷰-->
			<section id="chating">
				<!--채팅 헤드-->
				<div class="chating-head">
					<span class="chating-head-title">엔브레드톡</span>
				</div>
				<!--채팅 헤드 end-->
				
				<!--채팅 바디-->
				<div class="chating-body">
					<div class="chating-body-box" id="chating_box">
		
						
		
					</div>
				</div>
		
				<!--채팅 바디end-->
		
				<!--채팅 입력-->
				<div class="chating-input" id="chating-input-talk">
					<div class="chating-input-area">
						<textarea placeholder="엔브레드톡에 참여해보세요" class="chating-input-area-write"></textarea> 
						<button type="button" class="chating-post-stickerbtn">
							<img class="chating-post-sendbtn-image" src="/comi/resources/images/stickerbtn.png">
						</button>
					</div>
					<div class="chating-post-area">
						<button type="button" class="chating-post-sendbtn">
							<img class="chating-post-sendbtn-image" src="/comi/resources/images/sendbtn.png">
						</button>
					</div>
				</div>
				<!--채팅 입력 end-->
			</section>
		
		
			<!--참여 버튼 버튼을 클릭해야 채팅을 할 수 있음 - 참여하지 않으면 채팅기록만 볼수 있음-->
			<section class="chating-allow">
				<button class="chating-allow-btn">참여</button>
			</section>
			<!--참여 버튼 end-->
		
		
			<!-- 공유 모임 더 보기 -->
			<section class="article-party-share">
				<div class="article-party-share-box">
					<div class="article-party-share-title">인기공유모임</div>
					<a id="article-party-share-re" href="/comi/partysall?type=findParty">더보기</a>
				</div>
		
				<div class="main_portfolio" id="portf_box">
					
				</div>
			</section>
			<!-- 공유 모임 더 보기 end-->

		</div>
	</main>
	

	<!-- Footer Section Begin -->
	<footer id="footer_view">	
	</footer>
	<!-- Footer Section End -->
</body>
</html>