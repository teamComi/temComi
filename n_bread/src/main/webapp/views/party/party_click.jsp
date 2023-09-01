<%@page import="party.model.vo.Party"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   //String type = (String) request.getAttribute("type");
   Party party = (Party) request.getAttribute("party");
   Member member = (Member) request.getAttribute("member");//파티장
   String category_check = (String)request.getAttribute("category_check");
   int per = 0;
   if(party.getPaDeposit() > 0) {
	   per = (int)((double)party.getPaDeposit()/(double)party.getPaTotalAmount() * 100);
   }
   ArrayList<Integer> totalPartyList = (ArrayList<Integer>)request.getAttribute("totalPartyList");
   
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
   <!--<script type="text/javascript"	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>-->
	<script src="https://js.tosspayments.com/v1/payment-widget"></script>
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
    <%
    	String partyMemberType = "none";
    	if(loginMember.getMeNum() == member.getMeNum()) {
    		partyMemberType = "host";
    	}else{
    		if(totalPartyList != null && totalPartyList.size() > 0) {
	    		for(int i=0; i<totalPartyList.size(); i++) {
		            if(loginMember.getMeNum() == totalPartyList.get(i)) {
		               	partyMemberType = "member";
		               	break;
		            }
	         	}
    		}
    	}
    	
    %>
	<script type="text/javascript">
      var partyMemberType = 'none';
      <% if(loginMember.getMeNum() == member.getMeNum()) { %>
         partyMemberType = 'host';
      <% } else {
    	  
            //for(int i=0; i<totalPartyList.size(); i++) {
               //if(loginMember.getMeNum() == totalPartyList.get(i)) {
                  %>
                  partyMemberType = 'member';
                  <% //break;
               //}
            //}
    	  	
       } %>
   </script>
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
                           <span class="text-color text-color-03" id="text-color-id"><%= member.getMeLike() %>%</span>
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
                 <%= category_check %><br>
              <span id="article-befordate">
               <%= party.getPaTime() %>
              </span>
            </p>
            <p id="article-location">
               <a href="javascript:popup()"><%= party.getPaLocation() %></a>
               <script>
                  function popup(){
                     //창 크기 지정
                  var width = 500;
                  var height = 500;
                  
                  //pc화면기준 가운데 정렬
                  var left = (window.screen.width / 2) - (width/2);
                  var top = (window.screen.height / 4);
                  
                     //윈도우 속성 지정
                  var windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes';
                  
                     //연결하고싶은url
                     const url = "/comi/views/common/location.jsp?local=<%=party.getPaLocation()%>";

                  //등록된 url 및 window 속성 기준으로 팝업창을 연다.
                  window.open(url, "hello popup", windowStatus);
                  }
               </script>
            </p>
            <div id="article-price-box">
               
               <div id="article-deposit">예치금 : <%= party.getPaDeposit() %>원</div>
               <div id="article-bar-box">
                  <span id="article-price-bar"></span>
                  <span id="article-deposit-bar" style="width:<%= per %>%"></span>
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

         <!-- 결제 페이지 파티장과 회원이 같을때만 보이기 -->
         <% 
         //out.print("partyMemberType : " + partyMemberType + " party.getPaAct() : " + party.getPaAct());
         if(partyMemberType != "none" && party.getPaAct().equals("Y")) { %>
         <div class="view-payment-box">
            <button id="paymentPop">결제하기</button>
            <!-- <span id="paymentEnd">결제완료</span> -->
         </div>
         <% } %>
         <!-- 결제 페이지 end -->
         <script type="text/javascript">
			var partyMemberTypeJs = <%= "\"" + partyMemberType + "\"" %>;

         function generateRandomString() {
            return window.btoa(Math.random()).slice(0, 20);
         }

         $(function(){

            //결제
            var paymentWidget = PaymentWidget(
               "test_ck_6BYq7GWPVv5nNOzL6dw3NE5vbo1d",
               PaymentWidget.ANONYMOUS
            );

            var depositBool = (partyMemberTypeJs == 'host') ? 'Y' : 'N';
            var price = (partyMemberTypeJs == 'host') 
                              ? Number(<%= "\"" + party.getPaDeposit() + "\"" %>)
                              : Number(<%= "\"" + party.getPaPerAmount() + "\"" %>);//결제금액
            
            price = 100;
            var paymentMethodWidget = paymentWidget.renderPaymentMethods("#payment-method", { value: price });
         
            $('#payment').click(function(){
               
               //결제 금액과 테이블 저장된 금액이 맞을때
               paymentWidget.requestPayment({
                  amount: price,
                  orderId: generateRandomString(),
                  orderName: <%= "\"" + party.getPaTitle() + "\"" %>,
                  //successUrl: sucUrl,
                  //failUrl: url + '&pay=no',
                  customerEmail: <%= "\"" + loginMember.getMeEmail() + "\"" %>,
                  customerName: <%= "\"" + loginMember.getMeName() + "\"" %>
               })
               .then(function (response) {
                  // 성공 처리: 결제 승인 API를 호출하세요
                  
                  console.log('결제가 성공적으로 처리되었습니다.');
                  console.log('response : ' + response);
                  
                  var selectedPaymentMethod = paymentMethodWidget.getSelectedPaymentMethod()
                  console.log('selectedPaymentMethod : ' + selectedPaymentMethod);
                  $.ajax({
                     url : '/comi/payins'
                     ,type : 'post'
                     ,dataType : 'json'
                     ,data : {
                        
                        pa_num : Number(<%= "\"" + party.getPaNum() + "\"" %>)
                        ,me_num : Number(<%= "\"" + loginMember.getMeNum() + "\"" %>)
                        ,pm_amount : price//결제금액
                        ,pm_host : depositBool
                        ,pm_deposit : depositBool
                        ,pm_method : selectedPaymentMethod.method
                        
                     }
                     ,success : function(result){
                        console.log('저장완료');

                        var jstr = JSON.stringify(result);
                        var res = JSON.parse(jstr);
                        //저장
                        $('.view-payment-box').hide();
                        $('#paymentPop').hide();
                        $('#paymentEnd').show();
                     },error : function(error){
                        console.log('저장안됨');
                     }
                  });
               })
               .catch(function (error) {
                  // 에러 처리: 에러 목록을 확인하세요
                  console.log('error.code : ' + error.code);
                  // https://docs.tosspayments.com/reference/error-codes#failurl로-전달되는-에러
                  if (error.code === 'USER_CANCEL') {
                  // 결제 고객이 결제창을 닫았을 때 에러 처리
                  } else if (error.code === 'INVALID_CARD_COMPANY') {
                  // 유효하지 않은 카드 코드에 대한 에러 처리
                  }
                  
               })
            });
            

            $('#paymentPop').on('click', function(){
               $('.view-payment-pop').show();
               //return false;
            })
         
            $('.view-payment-pop').on('click', function(){
               $(this).hide();
               //return false;
            })
            
            
         })
         </script>
         
         <% if(type.equals("findReview")) { //종료된 모임 %>
            <%@ include file="./view_reply.jsp" %>
         <% }else { //종료되지 않은 모임 %>
            <%@ include file="./view_chat.jsp" %>
            <%--
            <% if(loginMember.getMeNum() == party.getMeNum()){%>
               <%@ include file="./view_chat.jsp" %>
            <%}else {%>
               <section class="joinparty-allow">
                  <button class="joinparty-allow-btn" id="sendButton">참여하기</button>
              </section>   
            <% } %>
            --%>
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

      <div class="view-payment-pop">
			<!-- <input type="button" class="view-payment-btn" value="결제하기"> -->
			<div class="view-payment-pop-box">
				<div id="payment-method"></div>
				<button id="payment">결제하기</button>
			</div>
			
		</div>
   </main>
   

   <!-- Footer Section Begin -->
   <footer id="footer_view">
      <%@ include file="../common/footer.jsp" %>   
   </footer>
   <!-- Footer Section End -->
</body>
</html>