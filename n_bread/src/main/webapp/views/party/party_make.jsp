<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setAttribute("type", "make");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>party_make</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/jquery-ui.min.css"/>
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/view_reply.css"/>
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/party_make.css"/>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery-ui-zoom.js"></script>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/util.js"></script>
	<script type="text/javascript" src="/comi/resources/js/party_make.js"></script>
	<!--
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 사용하세요&libraries=services"></script>
	-->
</head>
<body>
	<!-- Header Section Begin -->
    <header id="header_view">
    	<%@ include file="../common/header.jsp" %> 
    </header>
    <!-- Header Section End -->

	<!-- main -->
	<main class="main_wrapper">
		<div class="container make-view">

			<form action="/comi/partyi" method="post">
				<!-- 카테고리 설정 -->
				<section class="view-section view-category">
					<div class="title-text view-category-title">카테고리를 설정해주세요.</div>
					<div class="view-category-content">
						<button class="view-category-box" id="category_btn_1">
							<div class="view-category-text">모임</div>
						</button>
						<button class="view-category-box">
							<div class="view-category-text">공구</div>
						</button>
						<button class="view-category-box">
							<div class="view-category-text">렌탈</div>
						</button>
						<button class="view-category-box">
							<div class="view-category-text">게임</div>
						</button>
						<button class="view-category-box">
							<div class="view-category-text">OTT</div>
						</button>
						<button class="view-category-box">
							<div class="view-category-text">기타</div>
						</button>
					</div>
				</section>
				<!-- 카테고리 설정 end-->

				<!-- 가격 및 디파짓 및 인원 설정 -->
				<section class="view-section view-price">
					<div class="title-text view-category-title">가격및 거치금을 설정해주세요.</div>
					<div class="view-price-content">
						
						<div class="view-price-barbox">
							<div class="view-price-bar">
								<div id="view-price-bar-price"></div>
								<div id="view-price-bar-deposit"></div>
							</div>
							<div id="view-price-cursor"></div>
						</div>
						
						<form>
							<fieldset class="view-price-field">
								<div class="view-price-field-div">
									가격 &nbsp;<input type="number" id="setting_price" min="10000" max="10000000" step="1000" value="5000" name="pa_total_amount">
								</div>
								<div class="view-price-field-div">
									거치금 &nbsp;<input type="number" id="setting_deposit" min="10000" max="10000000" step="1000" value="10000" name="pa_deposit" >
								</div>
								<div class="view-price-field-div">
									모집인원 &nbsp;<input type="number" id="setting_people" min="1" max="100" step="1" value="1" name="pa_per_amount" >
								</div>
							</fieldset>
						</form>
					</div>
					<div class="view-price-peopleprice">1인당 금액 : 5000원</div>
				</section>
				<!-- 가격 및 디파짓 및 인원 설정 end -->

				<!-- 게시글 설정 -->
				<section class="view-section view-notice">
					<div class="view-notice-title title-text">공유 모임글을 작성해주세요.</div>
					<div class="view-notice-area">

						<div class="view-notice-box">
							<div class="view-notice-box-title">제목</div>
							<div class="review-write-area-inbox">
								<input title="댓글" class="review-write-textarea input" name="pa_title" id="notice_write_input"></textarea>
								<label for="review_write_textarea" class="u_cbox_guide">
									다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  
									모든 작성자는 <em class="guide_emphasis">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.
								</label>
							</div>
						</div>

						<div class="view-notice-box">
							<div class="view-notice-box-title">자세한 설명</div>
							<div class="review-write-area-inbox">
								<textarea title="댓글" class="review-write-textarea" name="pa_con" id="notice_write_textarea" rows="3" cols="30"></textarea>
								<label for="notice_write_textarea" class="u_cbox_guide">
									다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  
									모든 작성자는 <em class="guide_emphasis">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.
								</label>
							</div>
						</div>

						<div class="view-notice-box">
							<div class="view-notice-box-title under-line">사진</div>
							<div class="view-notice-picture-box">

								<div class="view-notice-picture-left">
									<div class="view-notice-picture-explain">
										<div class="view-notice-picture-textbig">
											이미지 추가등록
										</div>
										<div class="view-notice-picture-textsmall">
											이미지는 최대 5장까지 등록가능합니다.<br>
											이미지 권장 사이즈는 700 * 500입니다.
										</div>
									</div>
								</div>

								<div class="view-notice-picture-area">
									<button class="view-notice-picture">
										이미지 <br>업로드
									</button>
									<button class="view-notice-picture">
										이미지 <br>업로드
									</button>
									<button class="view-notice-picture">
										이미지 <br>업로드
									</button>
									<button class="view-notice-picture">
										이미지 <br>업로드
									</button>
									<button class="view-notice-picture choice">
										<span class="view-notice-picture-plus">
											<span class="view-notice-picture-plustext">+</span>
										</span>
									</button>
									
								</div>

							</div>
						</div>

						<div class="view-notice-box">
							<div class="view-notice-box-title">공유 희망 장소</div>
							<div class="view-notice-location">
								<div class="view-notice-location-title">
									<div class="notice-text-bold">
										파티원들과 만나서 물건을 전달하거나 모임을 가질 장소를 선택해 주세요.
									</div>
									<div class="notice-text-normal">
										누구나 찾기 쉬운 공공장소가 좋아요.
									</div>
								</div>
								<div class="view-notice-location-box">
									<div class="view-notice-location-search location-box-style">
										<div class="view-notice-location-searchtext">서울시 동작구 상도로 15길</div>
										<img class="view-notice-location-searchimg" src="/comi/resources/images/searchimg.png">
									</div>
									<div class="view-notice-location-map location-box-style">
										<div class="location-map"></div>
									</div>
								</div>
							</div>
						</div>

						<div class="view-notice-box">
							<input type="submit" value="작성완료" class="view-notice-btn">
						</div>
					</div>
				</section>
			</form>

			<!-- 결제 설정 -->
			<!--
			<section class="view-section view-location">
				<button class="view-payment-btn">
					<img class="view-payment-btn-img" src="/comi/resources/images/payment_btn.png">
				</button>
			</section>
			-->
			<!-- 결제 설정 end-->

		</div>
	</main>
	<!-- main end-->

	<!-- Footer Section Begin -->
	<footer id="footer_view">
		<%@ include file="../common/footer.jsp" %>
	</footer>
	<!-- Footer Section End -->
</body>
</html>