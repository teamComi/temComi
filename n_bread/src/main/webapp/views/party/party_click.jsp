<%@page import="party.model.vo.Party"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   //String type = (String) request.getAttribute("type");
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