<%@page import="org.json.simple.JSONObject"%>
<%@page import="member.model.vo.Member"%>
<%@page import="party.model.vo.Party"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	JSONObject jparty = (JSONObject) request.getAttribute("party");
	JSONObject jmember = (JSONObject) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>party_closed</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/slick.min.css">
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/slick-theme.min.css">
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/jquery-ui.min.css"/>
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/review.css"/>
	<link rel="stylesheet" type="text/css" href="/comi/resources/css/party_closed_click.css"/>
	<script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/lib/slick.min.js"></script>
	<script type="text/javascript" src="/comi/resources/js/common.js"></script>
	<script type="text/javascript">
		var partyStr = JSON.stringify(<%= jparty %>);
		var partyData = JSON.parse(partyStr);
		
		var memberStr = JSON.stringify(<%= jmember %>);
		var memberData = JSON.parse(memberStr);
	    console.log('partyStr : ' + partyStr);
	    console.log('memberStr : ' + memberStr);
    </script>
	<script type="text/javascript" src="/comi/resources/js/clickView.js"></script>
	<script type="text/javascript" src="/comi/resources/js/makeParty.js"></script>
	<script type="text/javascript" src="/comi/resources/js/party_closed_click.js"></script>
	<script type="text/javascript" src="/comi/resources/js/slick_set.js"></script>
</head>
<body>
	<!-- Header Section Begin -->
    <header id="header_view">    
    </header>
    <!-- Header Section End -->

	<!-- main -->
	<main class="main_wrapper">
		<div class="container side_margin_zero">
			<div class="party_closed_up">종료된 모임이에요.</div>

			<!-- 슬라이더 -->
			<div class="main_slider margin-bottom20px">
				<div id="slider_main">
					
				</div>
			</div>
		</div>

		<div class="container">
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
									<div id="article-nickname"></div>
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


			<!-- 게시글 리뷰-->
			<section id="review">

				<!--댓글 헤드-->
				<div class="review-head">
					<span class="review-head-title">54개의 댓글</span>
					<button type="button" class="review-head-refresh" alt="새로고침">
						<img src="/comi/resources/images/refresh.png">
					</button>
				</div>
				<!--댓글 헤드 end-->

				<!--댓글 쓰기-->
				<div class="review-write">
					<form>
						<fieldset>
							<legend class="u_vc">댓글 쓰기</legend>
							<div class="review-write-inner">
								
								<div class="review-write-profilearea">
									<div class="review-write-profile">
										<img src="/comi/resources/images/deafault.png" class="img-profile">
										<span class="write-name">donkihotex</span>
									</div>
								</div>

								<div class="review-write-area">
									<div class="review-write-area-inbox">
										<textarea title="댓글" class="review-write-textarea" id="review_write_textarea_1" rows="3" cols="30"></textarea>
										<label for="review_write_textarea_1" class="u_cbox_guide">
											다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  
											모든 작성자는 <em class="guide_emphasis">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.
										</label>
									</div>
								</div>
								
								<div class="review-write-count-box">
									<div class="review-write-count">
										<strong class="review-write-count-num">0</strong>/
										<span class="review-write-count-total">300</span>
									</div>
									<button type="button" class="review-write-upload">
										<span class="review-write-upload-text">등록</span>
									</button>
								</div>
							
							</div>
						</fieldset>
					</form>
				</div>
				<!--댓글 쓰기 end-->

				<!--댓글 정렬 버튼-->
				<div class="review-sort">
					<button class="review-sort-btn sort-type-1 active">공감순</button>
					<button class="review-sort-btn sort-type-2">최신순</button>
					<button class="review-sort-btn sort-type-3">답글순</button>
				</div>
				<!--댓글 정렬 버튼 end-->

				<!--댓글 보기-->
				<div class="review-body">
					
					<!--댓글 첫번째-->
					<div class="review-body-container reviewbody-first">

						<div class="review-body-box">

							<div class="review-body-list">
								<div class="review-body-list-profile">
									<img class="review-body-list-profile-img" src="/comi/resources/images/profile.png">
									<div class="review-body-list-profile-box">
										<div class="review-body-list-name">마이프레셔스</div>
										<div class="review-body-list-date">2023.08.05 14:57</div>
									</div>
								</div>
								<div class="review-body-list-right">
									<button class="review-body-list-right-btn">
										<img class="review-body-list-right-btn-img" src="/comi/resources/images/profile.png">
									</button>
								</div>
							</div>

							<div class="review-body-read">
								<div class="review-body-read-text">
									이 편지는 1956년 영국에서 시작되었습니다. 
									이 편지를 받은 사람은 저주에 빠지게 됨니다.
									그래서 돈을 보내야 함니다.
									이 편지는 1956년 영국에서 시작되었습니다. 
									이 편지를 받은 사람은 저주에 빠지게 됨니다.
									그래서 돈을 보내야 함니다.내야 함니다. 내야 함니다.
								</div>
							</div>

							<div class="review-body-bottom">
								<button class="review-body-bottom-retext">
									답글 <b>1</b>
								</button>
								<div class="review-body-bottom-heartbox">
									<button class="review-body-bottom-heart">
										<img class="review-body-bottom-heart-img" src="/comi/resources/images/heart.png">
									</button>
									<span>0</span>
								</div>
							</div>

						</div>

					</div>
					<!--댓글 첫번째 end-->

					<!--댓글 두번째-->
					<div class="review-body-container reviewbody-second">

						<div class="review-body-box">

							<div class="review-body-list">
								<div class="review-body-list-profile">
									<img class="review-body-list-profile-img" src="/comi/resources/images/profile.png">
									<div class="review-body-list-profile-box">
										<div class="review-body-list-name">마이프레셔스</div>
										<div class="review-body-list-date">2023.08.05 14:57</div>
									</div>
								</div>
								<div class="review-body-list-right">
									<button class="review-body-list-right-btn">
										<img class="review-body-list-right-btn-img" src="/comi/resources/images/profile.png">
									</button>
								</div>
							</div>

							<div class="review-body-read">
								<div class="review-body-read-text">
									이 편지는 1956년 영국에서 시작되었습니다. 
									이 편지를 받은 사람은 저주에 빠지게 됨니다.
									그래서 돈을 보내야 함니다.
									이 편지는 1956년 영국에서 시작되었습니다. 
									이 편지를 받은 사람은 저주에 빠지게 됨니다.
									그래서 돈을 보내야 함니다.내야 함니다. 내야 함니다.
								</div>
							</div>

							<div class="review-body-bottom">
								<button class="review-body-bottom-retext">
									답글 <b>1</b>
								</button>
								<div class="review-body-bottom-heartbox">
									<button class="review-body-bottom-heart">
										<img class="review-body-bottom-heart-img" src="/comi/resources/images/heart.png">
									</button>
									<span>0</span>
								</div>
							</div>

						</div>

					</div>
					<!--댓글 두번째 end-->

					<!--댓글 쓰기-->
					<div class="review-write review-rewriting">
						<form>
							<fieldset>
								<legend class="u_vc">댓글 쓰기</legend>
								<div class="review-write-inner">
									
									<div class="review-write-profilearea">
										<div class="review-write-profile">
											<img src="/comi/resources/images/deafault.png" class="img-profile">
											<span class="write-name">donkihotex</span>
										</div>
									</div>

									<div class="review-write-area">
										<div class="review-write-area-inbox">
											<textarea title="댓글" class="review-write-textarea" id="review_write_textarea_2" rows="3" cols="30"></textarea>
											<label for="review_write_textarea_2" class="u_cbox_guide">
												다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  
												모든 작성자는 <em class="guide_emphasis">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.
											</label>
										</div>
									</div>
									
									<div class="review-write-count-box">
										<div class="review-write-count">
											<strong class="review-write-count-num">0</strong>/
											<span class="review-write-count-total">300</span>
										</div>
										<button type="button" class="review-write-upload">
											<span class="review-write-upload-text">등록</span>
										</button>
									</div>
								
								</div>
							</fieldset>
						</form>
					</div>
					<!--댓글 쓰기 end-->


				</div>
				<!--댓글 보기 end-->

			</section>
			<!-- 게시글 리뷰 end-->
			
			
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