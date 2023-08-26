<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String login = "login";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="/comi/resources/css/view_reply.css"/>
    <script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
    <script type="text/javascript" src="/comi/resources/js/view_reply.js"></script>
</head>
<body>
	<!-- 게시글 리뷰-->
    <section id="review">

        <!--댓글 헤드-->
        <div class="review-head">
            <span class="review-head-title" id="review_number">개의 댓글</span>
            <button type="button" class="review-head-refresh" alt="새로고침">
                <img src="/comi/resources/images/refresh.png">
            </button>
        </div>
        <!--댓글 헤드 end-->

        <!--댓글 쓰기-->
        <div class="review-write">
            <form action="" action="/comi/partycoins" method="post">
                <fieldset>
                <% if(login.equals("login")) { %>
                    <legend class="u_vc">댓글 쓰기</legend>
                    <div class="review-write-inner">
                        
                        <div class="review-write-profilearea">
                            <div class="review-write-profile">
                                <img src="/comi/resources/images/deafault.png" class="img-profile">
                                <span class="write-name" id></span>
                            </div>
                        </div>

                        <div class="review-write-area">
                            <div class="review-write-area-inbox">
                                <textarea name="reply" title="댓글" class="review-write-textarea" id="review_textarea_1" rows="3" cols="30"></textarea>
                                <label for="review_write_textarea_1" id="review_textlabel_1" class="u_cbox_guide">
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
                            <input type="submit" class="review-write-upload" id="upload_btn_1" value="등록">
                        </div>
                    
                    </div>
                <% }else{ %>    
                    <div class="review-write-inner" id="review-write-login">
                    	<div class="review-write-oucontainer">
                    		<textarea title="댓글" id="review-write-outtext" class="review-write-outbox" rows="3" cols="30"></textarea>
                    		<label for="review-write-outtext" class="review-write-guide" >댓글을 작성하려면 로그인 해주세요</label>
                    	</div>
                    </div>
                <% } %>
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

        <div class="review-bottom">
            <button id="review_bottom_prev"></button>

            <button id="review_bottom_next"></button>
        </div>


        <!--<button id="replyMoreBtn"><b>댓글 더보기</b></button>-->
    </section>
    <!-- 게시글 리뷰 end-->
</body>
</html>