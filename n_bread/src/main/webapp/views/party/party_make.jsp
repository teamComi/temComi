<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<% request.setAttribute("type", "make" ); %>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>party_make</title>

	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/jquery-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/main.css" />
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/view_reply.css" />
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/party_make.css" />
	<script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery-ui-zoom.js"></script>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/util.js"></script>
	<script type="text/javascript" src="/comi/resources/js/party_make.js"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=16134ee8ff451b97dae7335bb35de144&libraries=services"></script>
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

			<form action="/comi/partyi" method="post" enctype="multipart/form-data">
				<!-- 카테고리 설정 -->
				<section class="view-section view-category">
					<div class="title-text view-category-title">카테고리를 설정해주세요.</div>
					<div class="view-category-content">
						<label class="view-category-box">
							<input type="radio" name="category_check" value="모임"><span>모임</span>
						</label>
						<label class="view-category-box">
							<input type="radio" name="category_check" value="공구"><span>공구</span>
						</label>
						<label class="view-category-box">
							<input type="radio" name="category_check" value="렌탈"><span>렌탈</span>
						</label>
						<label class="view-category-box">
							<input type="radio" name="category_check" value="게임"><span>게임</span>
						</label>
						<label class="view-category-box">
							<input type="radio" name="category_check" value="OTT"><span>OTT</span>
						</label>
						<label class="view-category-box">
							<input type="radio" name="category_check" value="기타"><span>기타 </span>
						</label>
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
						<fieldset class="view-price-field">
							<div class="view-price-field-div">
								가격 &nbsp;<input type="number" id="setting_price" min="10000" max="10000000"
									step="1000" value="5000" name="pa_total_amount">
							</div>
							<div class="view-price-field-div">
								거치금 &nbsp;<input type="number" id="setting_deposit" min="10000" max="10000000"
									step="1000" value="10000" name="pa_deposit">
							</div>
							<div class="view-price-field-div">
								모집인원 &nbsp;<input type="number" id="setting_people" min="1" max="20" step="1"
									value="1" name="pa_total_num">
							</div>
						</fieldset>
					</div>
					<div class="view-price-peopleprice">1인당 금액 : 5000원</div>
				</section>
				<!-- 가격 및 디파짓 및 인원 설정 end -->

				<!-- 게시글 설정 -->
				<section class="view-section view-notice">
					<div class="view-notice-title title-text">공유 모임글을 작성해주세요.</div>
					<div class="view-notice-area">

				<div class="view-notice-box">
					<div class="view-notice-box-title">공유 날짜</div>
					<div class="review-write-area-inbox">
						<input type="date" title="공유 날짜" value="2023-09-01" class="review-input-date" name="pa_time_1"
							id="notice_write_date_1">
						<input type="time" title="공유 날짜" value="13:10:20" class="review-input-date" name="pa_time_2"
						id="notice_write_date_2">
					</div>
				</div>

				<div class="view-notice-box">
					<div class="view-notice-box-title">제목</div>
					<div class="review-write-area-inbox">
						<input type="text" title="제목" class="review-write-textarea input" name="pa_title"
							id="notice_write_input">

							</div>
						</div>

						<div class="view-notice-box">
							<div class="view-notice-box-title">자세한 설명</div>
							<div class="review-write-area-inbox">
								<textarea title="자세한 설명" class="review-write-textarea" name="pa_con"
									id="notice_write_textarea" rows="3" cols="30"></textarea>

							</div>
						</div>

						<div class="view-notice-box">
							<div class="view-notice-box-title under-line">사진</div>
							<div class="view-notice-picture-box">

								<div class="view-notice-picture-left">
									<div class="view-notice-picture-explain">
										<div class="view-notice-picture-textbig">이미지 추가등록</div>
										<div class="view-notice-picture-textsmall">
											이미지는 최대 5장까지 등록가능합니다.<br> 이미지 권장 사이즈는 700 * 500입니다.
										</div>
									</div>
								</div>

								<div class="view-notice-picture-area">
									<label class="view-notice-picture">
										<input type="file" name="pa_img1" style="display: none;">
										<samp>이미지<br>업로드</samp>
									</label>
									<label class="view-notice-picture">
										<input type="file" name="pa_img2" style="display: none;">
										<samp>이미지<br>업로드</samp>
									</label>
									<label class="view-notice-picture">
										<input type="file" name="pa_img3" style="display: none;">
										<samp>이미지<br>업로드</samp>
									</label>
									<label class="view-notice-picture">
										<input type="file" name="pa_img4" style="display: none;">
										<samp>이미지<br>업로드</samp>
									</label>
									<label class="view-notice-picture">
										<input type="file" name="pa_img5" style="display: none;">
										<samp>이미지<br>업로드</samp>
									</label>

								</div>

							</div>
						</div>

						<div class="view-notice-box">
						</div>



						<div class="view-notice-box-title">공유 희망 장소</div>
						<div class="view-notice-location">
							<div class="view-notice-location-title">
								<div class="notice-text-bold">파티원들과 만나서 물건을 전달하거나 모임을 가질
									장소를 선택해 주세요.</div>
								<div class="notice-text-normal">누구나 찾기 쉬운 공공장소가 좋아요.</div>
							</div>
							<div class="view-notice-location-box">
								<div class="view-notice-location-search location-box-style">
									<div class="view-notice-location-searchtext">
										<input type="hidden" id="address" name="address"
											class="postcodify_address" size="100">
										<input type="text" value="홍대입구역" id="keyword" size="100">
									</div>

									<input type="button" value="검색하기" onclick="searchPlaces(); return false;">
								</div>
								<div class="map_wrap">
									<div id="map" style="width:100%;height:100%;"></div>
									<div id="menu_wrap" class="bg_white" style="display: none;">
										<div class="option">
											<div>
												<form onsubmit="searchPlaces(); return false;">
												</form>
											</div>
										</div>
										<hr>
										<ul id="placesList" style="display: none;"></ul>
										<div id="pagination" style="display: none;"></div>

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
