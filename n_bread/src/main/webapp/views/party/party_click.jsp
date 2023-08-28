<%@page import="party.model.vo.Party"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//String type = (String) request.getAttribute("type");
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
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/party_click.css"/>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/lib/slick.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/util.js"></script>
	<script type="text/javascript" src="/comi/resources/js/makeParty.js"></script>
</head>
<body>
    <!-- Header Section Begin -->
    <header id="header_view">
    	<%@ include file="../common/header.jsp" %>
    </header>
    <!-- Header Section End -->

	<!-- main -->
	<main class="main_wrapper">
		<% if(type.equals("findReview")) { //종료된 모임 %>
		<div class="container side_margin_zero margin-top20px">
			<div class="party_closed_up">종료된 모임이에요.</div>

			<!-- 슬라이더 -->
			<div class="main_slider margin-top20px">
		<% }else { //종료되지 않은 모임 %>
		<div class="container side_margin_zero">
		
			<!-- 슬라이더 -->
			<div class="main_slider">
		<% } %>
				<div id="slider_main">
				<% for(int i=0; i<4; i++){ %>
					<div>
		                <div class="slide_box">
		                    <img class="picture_box" src="<%= "/comi/resources/images/pic01.jpg" %>" />
		                </div>
		            </div>
				<% } %>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">new Util().slide();</script>
		
		<div class="container">
			<%@ include file="./view_click.jsp" %>
			
			<% if(type.equals("findReview")) { //종료된 모임 %>
				<%@ include file="./view_reply.jsp" %>
			<% }else { //종료되지 않은 모임 %>
				<%@ include file="./view_chat.jsp" %>
			<% } %>
		
			<!-- 공유 모임 더 보기 -->
			<section class="article-party-share">
				<div class="article-party-share-box">
					<div class="article-party-share-title">인기공유모임</div>
					<a id="article-party-share-re" href="/comi/partysall?type=findParty">더보기</a>
				</div>
		
				<div class="main_portfolio" id="portf_box">
					<%@ include file="./view_list.jsp" %>
				</div>
			</section>
			<!-- 공유 모임 더 보기 end-->

		</div>
	</main>
	

	<!-- Footer Section Begin -->
	<footer id="footer_view">
		<%@ include file="../common/footer.jsp" %>	
	</footer>
	<!-- Footer Section End -->
</body>
</html>