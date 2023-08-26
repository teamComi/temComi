<%@page import="java.util.ArrayList"%>
<%@page import="party.model.vo.Party"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String pageType = (String) request.getAttribute("type"); 
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>party_view</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/jquery-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/comi/resources/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="/comi/resources/css/party_view.css"/>
    <link rel="stylesheet" type="text/css" href="/comi/resources/css/party_view_click.css"/>
    <script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
    <script type="text/javascript" src="/comi/resources/js/lib/lozad.min.js"></script>
    <script type="text/javascript" src="/comi/resources/js/util.js"></script>
    <script type="text/javascript">
        var pageType = <%= "\"" + pageType + "\"" %>;
    </script>
    <script type="text/javascript" src="/comi/resources/js/makeParty.js"></script>
    <script type="text/javascript" src="/comi/resources/js/party_view.js"></script>
</head>
<body>
    <!-- Header Section Begin -->
    <header id="header_view">
    	<%@ include file="../common/header.jsp" %>
    </header>
    <!-- Header Section End -->

    <!-- main -->
    <main class="main_wrapper">
        <div class="container">
            <div class="search-container">
                <div class="search-box">
                    <button class="search-btn">
                        <img src="/comi/resources/images/search_btn.png" class="search-image">
                    </button>
                    <% if(pageType.equals("findParty")){ %>
                    	<input type="text" placeholder="찾고 싶은 공유 모임을 검색해보세요." class="search-box-text" value="">
                    <% }else{ %>
                    	<input type="text" placeholder="예전 공유 모임을 검색해보세요." class="search-box-text" value="">
                    <% } %>
                </div>
                <div class="search-classify">
                    <span class="search-classify-title">분류</span>
                    <select class="search-classify-select" onchange="changeCategory(this.value);">
                        <option value="all" selected>전체</option>
                        <option value="meeting">모임</option>
                        <option value="group">공구</option>
                        <option value="rental"> 렌탈</option>
                        <option value="game">게임</option>
                        <option value="etc"> 기타</option>
                    </select>

                    <select class="search-classify-select" onchange="changeSort(this.value);">
                        <option value="accuracy" selected>정확도순</option>
                        <option value="interest">관심순</option>
                        <option value="recent">최신순</option>
                    </select>

                </div>
            </div>
            
            <div class="main_portfolio" id="portf_box">
                <%@ include file="./view_list.jsp" %>
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