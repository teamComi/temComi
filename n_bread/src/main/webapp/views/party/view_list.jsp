<%@page import="java.util.ArrayList"%>
<%@page import="party.model.vo.Party"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
ArrayList<Party> partyList = (ArrayList<Party>) request.getAttribute("partyList"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for(Party p : partyList){ %>
     <a class="port_box flexBox" href="/comi/partysel?panum=<%= p.getPaNum() %>&act=<%= p.getPaAct() %>">
            <div class="image featured">
                <img src="/comi/resources/images/empty.png" alt="" />
            </div>
            <div class="text_box">
                <div class="port_box_title"><%= p.getPaTitle() %></div>
                <div class="port_box_textbox">
                    <div class="port_box_price">가격 : <span class="price_all"><%= p.getPaTotalAmount() %></span></div>
                    <div class="port_box_deposit port_box_text_right">
                    	예치금 : <span class="price_deposit"><%= p.getPaDeposit() %></span>
                    </div>
                </div>
                <div class="port_box_textbox">
                    <div class="port_box_address"><%= p.getPaLocation() %></div>
                    <div class="port_box_date port_box_text_right"><%= p.getPaEnroll() %></div>
                </div>
                <div class="port_box_textbox">
                    <div class="port_box_text">인원 모집 <%= p.getPaTotalNum() %>명</div>
                    <div class="port_box_text port_box_text_right">인당 <%= p.getPaPerAmount() %>원</div>
                </div>
                <%if(p.getPaAct().equals("N")) {%>
                    <div class="party_closed_bottom">종료된 모임이에요.</div>
                <%}%>
            </div>
        </a>
    <% } %>
</body>
</html>