/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-25 10:00:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.party;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import party.model.vo.Party;
import java.util.ArrayList;
import member.model.vo.Member;
import party.model.vo.Party;
import java.util.ArrayList;
import party.model.vo.Party;

public final class party_005fclick_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/views/party/../common/footer.jsp", Long.valueOf(1692951862105L));
    _jspx_dependants.put("/views/party/./partyClickView.jsp", Long.valueOf(1692957392893L));
    _jspx_dependants.put("/views/party/./partyView.jsp", Long.valueOf(1692957598668L));
    _jspx_dependants.put("/views/party/../common/header.jsp", Long.valueOf(1692955089793L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("party.model.vo.Party");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>party_view</title>\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/lib/slick.min.css\">\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/lib/slick-theme.min.css\">\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/lib/jquery-ui.min.css\"/>\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/main.css\"/>\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/party_view_click.css\"/>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/lib/jquery.min.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/lib/slick.min.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/common.js\"></script>\r\n");
      out.write("	\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- Header Section Begin -->\r\n");
      out.write("    <header id=\"header_view\">\r\n");
      out.write("    	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>header</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/header.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- Header Section Begin -->\r\n");
      out.write("    \r\n");
      out.write("    <header class=\"header\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <!--메뉴-->\r\n");
      out.write("            <nav class=\"header_menu\">\r\n");
      out.write("                <!--로고-->\r\n");
      out.write("                <div class=\"header_logo left\">\r\n");
      out.write("                    <a href=\"/comi/main.jsp\"><img src=\"/comi/resources/images/logo.png\" alt=\"\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!--메뉴-->\r\n");
      out.write("                <div class=\"header_text center\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"/comi/views/party/party_make.html\">공유 해요</a>\r\n");
      out.write("                            <!--<ul class=\"dropdown\">\r\n");
      out.write("                                <li><a href=\"#\">Product 1</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Product 2</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Product 3</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Product 3</a></li>\r\n");
      out.write("                            </ul>-->\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"/comi/partysall?type=findParty\">공유 찾기</a></li>\r\n");
      out.write("                        <li><a href=\"/comi/partysall?type=findReview\">공유 후기</a></li>\r\n");
      out.write("                        <li><a href=\"/comi/views/qna/qna.html\">Q&A</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!--장바구니, 찜-->\r\n");
      out.write("                <div class=\"header_right right\">\r\n");
      out.write("                    <ul class=\"header_right_widget\">\r\n");
      out.write("                        <li><a href=\"/comi/views/party/login.html\">로그인</a></li>\r\n");
      out.write("                        <li><a href=\"#\"><img src=\"/comi/resources/images/search.png\" class=\"icon_mypage\" />\r\n");
      out.write("                            <div class=\"tip\">2</div>\r\n");
      out.write("                        </a></li>\r\n");
      out.write("                        <li><a href=\"#\"><img src=\"/comi/resources/images/search.png\"  class=\"icon_mycart\" />\r\n");
      out.write("                            <div class=\"tip\">2</div>\r\n");
      out.write("                        </a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- Header Section End -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- mobile_header 사용안함-->\r\n");
      out.write("    <header class=\"mobile_header\">\r\n");
      out.write("        \r\n");
      out.write("        <nav class=\"mobile_nav\">\r\n");
      out.write("            <div class=\"mobile_nav_top\">\r\n");
      out.write("                <a class=\"home_btn\" href=\"/comi/main.html\">\r\n");
      out.write("                    <img src=\"/comi/resources/images/headerTopIcon_1.png\" />\r\n");
      out.write("                </a>\r\n");
      out.write("            \r\n");
      out.write("                <button class=\"nav_btn\" type=\"button\">\r\n");
      out.write("                    <img src=\"/comi/resources/images/headerTopIcon_2.png\" />\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"navbar_box\">\r\n");
      out.write("                <div class=\"nav_item\">\r\n");
      out.write("                    <a class=\"nav_link\" href=\"/comi/views/party/party_make.html\" target=\"_blank\">\r\n");
      out.write("                        <img src=\"/comi/resources/images/headerSubIcon_1.png\" />\r\n");
      out.write("                            <span class=\"nav_link_tex\">공유 해요</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"nav_item\">\r\n");
      out.write("                    <a class=\"nav_link\" href=\"/comi/views/party/party_view.html\" target=\"_blank\">\r\n");
      out.write("                        <img src=\"/comi/resources/images/headerSubIcon_2.png\" />\r\n");
      out.write("                            <span class=\"nav_link_tex\">공유 찾기</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"nav_item\">\r\n");
      out.write("                    <a class=\"nav_link\" href=\"/comi/views/party/party_closed.html\" target=\"_blank\">\r\n");
      out.write("                        <img src=\"/comi/resources/images/headerSubIcon_3.png\" />\r\n");
      out.write("                            <span class=\"nav_link_tex\">공유 후기</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"nav_item\">\r\n");
      out.write("                    <a class=\"nav_link\" href=\"/comi/views/qna/qna.html\" target=\"_blank\">\r\n");
      out.write("                        <img src=\"/comi/resources/images/headerSubIcon_5.png\" />\r\n");
      out.write("                            <span class=\"nav_link_tex\">Q&A</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- mobile_header End -->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- Header Section End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- main -->\r\n");
      out.write("	<main class=\"main_wrapper\">\r\n");
      out.write("		<div class=\"container side_margin_zero\">\r\n");
      out.write("\r\n");
      out.write("			<!-- 슬라이더 -->\r\n");
      out.write("			<div class=\"main_slider\">\r\n");
      out.write("				<div id=\"slider_main\">\r\n");
      out.write("					\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	Party party = (Party) request.getAttribute("party");
	Member member = (Member) request.getAttribute("member");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- 프로필 -->\r\n");
      out.write("	<section id=\"article-profile\">\r\n");
      out.write("		<div class=\"article-profile-box\">\r\n");
      out.write("			<a class=\"article-profile-link\" href=\"#\">\r\n");
      out.write("				<div class=\"space-between\">\r\n");
      out.write("					<div class=\"display-align-items-center\">\r\n");
      out.write("						<div id=\"article-profile-image-box\">\r\n");
      out.write("							<img src=\"/comi/resources/images/launcher.png\" />\r\n");
      out.write("						</div>\r\n");
      out.write("						<div id=\"article-profile-left\">\r\n");
      out.write("							<div id=\"article-nickname\">");
      out.print( member.getMeAka() );
      out.write("</div>\r\n");
      out.write("							<div id=\"article-region-name\">");
      out.print( party.getPaLocation() );
      out.write("</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"article-profile-right\">\r\n");
      out.write("						<div class=\"temperature-wrap\">\r\n");
      out.write("							<span>신뢰도</span>\r\n");
      out.write("							<span class=\"text-color text-color-03\" id=\"text-color-id\">");
      out.print( member.getMeLike() );
      out.write(">%</span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"meters\">\r\n");
      out.write("							<div class=\"bar bar-color-03\" \r\n");
      out.write("							id=\"bar-color-id\" style=\"width:");
      out.print( member.getMeLike() );
      out.write("%;\"></div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"temperature-face\">\r\n");
      out.write("							<img id=\"temperature-face-id\" src=\"/comi/resources/images/launcher.png\" />\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</a>\r\n");
      out.write("		</div>\r\n");
      out.write("	</section>\r\n");
      out.write("	<!-- 프로필 end-->\r\n");
      out.write("	\r\n");
      out.write("	<!-- 게시글 -->\r\n");
      out.write("	<section id=\"article-description\">\r\n");
      out.write("		<h1 id=\"article-title\"></h1>\r\n");
      out.write("		<p id=\"article-category\">\r\n");
      out.write("		  모임 ∙\r\n");
      out.write("		  <span id=\"article-befordate\">\r\n");
      out.write("			\r\n");
      out.write("		  </span>\r\n");
      out.write("		</p>\r\n");
      out.write("		<p id=\"article-location\">\r\n");
      out.write("\r\n");
      out.write("		</p>\r\n");
      out.write("		<div id=\"article-price-box\">\r\n");
      out.write("			\r\n");
      out.write("			<div id=\"article-deposit\"></div>\r\n");
      out.write("			<div id=\"article-bar-box\">\r\n");
      out.write("				<span id=\"article-price-bar\"></span>\r\n");
      out.write("				<span id=\"article-deposit-bar\"></span>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div id=\"article-price\"></div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"article-people-box\">\r\n");
      out.write("				<div id=\"article-people\"></div>\r\n");
      out.write("				<div id=\"article-people-price\"></div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div id=\"article-detail\">\r\n");
      out.write("			<p>\r\n");
      out.write("				\r\n");
      out.write("			</p>\r\n");
      out.write("		</div>\r\n");
      out.write("		<p id=\"article-counts\">\r\n");
      out.write("			\r\n");
      out.write("		</p>\r\n");
      out.write("	</section>\r\n");
      out.write("	<!-- 게시글 end-->\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("			<!-- 채팅 리뷰-->\r\n");
      out.write("			<section id=\"chating\">\r\n");
      out.write("				<!--채팅 헤드-->\r\n");
      out.write("				<div class=\"chating-head\">\r\n");
      out.write("					<span class=\"chating-head-title\">엔브레드톡</span>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!--채팅 헤드 end-->\r\n");
      out.write("				\r\n");
      out.write("				<!--채팅 바디-->\r\n");
      out.write("				<div class=\"chating-body\">\r\n");
      out.write("					<div class=\"chating-body-box\" id=\"chating_box\">\r\n");
      out.write("		\r\n");
      out.write("						\r\n");
      out.write("		\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("		\r\n");
      out.write("				<!--채팅 바디end-->\r\n");
      out.write("		\r\n");
      out.write("				<!--채팅 입력-->\r\n");
      out.write("				<div class=\"chating-input\" id=\"chating-input-talk\">\r\n");
      out.write("					<div class=\"chating-input-area\">\r\n");
      out.write("						<textarea placeholder=\"엔브레드톡에 참여해보세요\" class=\"chating-input-area-write\"></textarea> \r\n");
      out.write("						<button type=\"button\" class=\"chating-post-stickerbtn\">\r\n");
      out.write("							<img class=\"chating-post-sendbtn-image\" src=\"/comi/resources/images/stickerbtn.png\">\r\n");
      out.write("						</button>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"chating-post-area\">\r\n");
      out.write("						<button type=\"button\" class=\"chating-post-sendbtn\">\r\n");
      out.write("							<img class=\"chating-post-sendbtn-image\" src=\"/comi/resources/images/sendbtn.png\">\r\n");
      out.write("						</button>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!--채팅 입력 end-->\r\n");
      out.write("			</section>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("			<!--참여 버튼 버튼을 클릭해야 채팅을 할 수 있음 - 참여하지 않으면 채팅기록만 볼수 있음-->\r\n");
      out.write("			<section class=\"chating-allow\">\r\n");
      out.write("				<button class=\"chating-allow-btn\">참여</button>\r\n");
      out.write("			</section>\r\n");
      out.write("			<!--참여 버튼 end-->\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("			<!-- 공유 모임 더 보기 -->\r\n");
      out.write("			<section class=\"article-party-share\">\r\n");
      out.write("				<div class=\"article-party-share-box\">\r\n");
      out.write("					<div class=\"article-party-share-title\">인기공유모임</div>\r\n");
      out.write("					<a id=\"article-party-share-re\" href=\"/comi/partysall?type=findParty\">더보기</a>\r\n");
      out.write("				</div>\r\n");
      out.write("		\r\n");
      out.write("				<div class=\"main_portfolio\" id=\"portf_box\">\r\n");
      out.write("					");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
ArrayList<Party> partyList = (ArrayList<Party>) request.getAttribute("partyList"); 

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
 for(Party p : partyList){ 
      out.write("\r\n");
      out.write("     <a class=\"port_box flexBox\" href=\"/comi/partysel?panum=");
      out.print( p.getPaNum() );
      out.write("&act='");
      out.print( p.getPaAct() );
      out.write("\">\r\n");
      out.write("            <div class=\"image featured\">\r\n");
      out.write("                <img src=\"/comi/resources/images/empty.png\" alt=\"\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"text_box\">\r\n");
      out.write("                <div class=\"port_box_title\">");
      out.print( p.getPaTitle() );
      out.write("</div>\r\n");
      out.write("                <div class=\"port_box_textbox\">\r\n");
      out.write("                    <div class=\"port_box_price\">가격 : <span class=\"price_all\">");
      out.print( p.getPaTotalAmount() );
      out.write("</span></div>\r\n");
      out.write("                    <div class=\"port_box_deposit port_box_text_right\">\r\n");
      out.write("                    	예치금 : <span class=\"price_deposit\">");
      out.print( p.getPaDeposit() );
      out.write("</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"port_box_textbox\">\r\n");
      out.write("                    <div class=\"port_box_address\">");
      out.print( p.getPaLocation() );
      out.write("</div>\r\n");
      out.write("                    <div class=\"port_box_date port_box_text_right\">");
      out.print( p.getPaEnroll() );
      out.write("</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"port_box_textbox\">\r\n");
      out.write("                    <div class=\"port_box_text\">인원 모집 ");
      out.print( p.getPaTotalNum() );
      out.write("명</div>\r\n");
      out.write("                    <div class=\"port_box_text port_box_text_right\">인당 ");
      out.print( p.getPaPerAmount() );
      out.write("원</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
if(p.getPaAct() == "N") {
      out.write("\r\n");
      out.write("                <div class=\"party_closed_bottom\">종료된 모임이에요.</div>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("			</section>\r\n");
      out.write("			<!-- 공유 모임 더 보기 end-->\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</main>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	<!-- Footer Section Begin -->\r\n");
      out.write("	<footer id=\"footer_view\">\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>footer</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/footer.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- Footer Section Begin -->\r\n");
      out.write("    <footer class=\"footer\">\r\n");
      out.write("        <div class=\"container side_margin_zero\">\r\n");
      out.write("            <div class=\"footer_section_box\">\r\n");
      out.write("                <div class=\"footer_section\">\r\n");
      out.write("                    <div class=\"footer_div\">\r\n");
      out.write("                        <img src=\"/comi/resources/images/logo.png\" class=\"footer_logo\">\r\n");
      out.write("                        <div class=\"footer_right\">\r\n");
      out.write("                            <div class=\"footer_right_sub\">\r\n");
      out.write("                                <label class=\"footer_right_sub_label\">서비스</label>\r\n");
      out.write("                                <div class=\"footer_right_subsub\">\r\n");
      out.write("                                    <span class=\"footer_right_sub_text\">앱 다운로드</span>\r\n");
      out.write("                                    <span class=\"footer_right_sub_text\">공지사항</span>\r\n");
      out.write("                                    <span class=\"footer_right_sub_text\">고객센터</span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"footer_right_sub\">\r\n");
      out.write("                                <label class=\"footer_right_sub_label\">문의</label>\r\n");
      out.write("                                <div class=\"footer_right_subsub\">\r\n");
      out.write("                                    <span class=\"footer_right_sub_text\"><a href=\"#\">사업 제휴</a></span>\r\n");
      out.write("                                    <span class=\"footer_right_sub_text\"><a href=\"#\">광고 문의</a></span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"footer_bottom_1\">\r\n");
      out.write("                        <label class=\"footer_text_2\"><b>(주)십시일반</b></label>\r\n");
      out.write("                        <div class=\"\">\r\n");
      out.write("                            <p class=\"footer_text_2\">\r\n");
      out.write("                                <span>사업자 등록번호 : 없음</span> |<span> 팀장 : 김정선 </span>| 팀원 : 전성훤, 이재민, 나정운, 김건, 서진우 | <br>서울특별시 서초구 서초대로77길 41, 4층 (서초동, 대동Ⅱ)\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"footer_bottom_2\">\r\n");
      out.write("                        <span class=\"footer_text_1\">서비스 이용약관</span>\r\n");
      out.write("                        <span class=\"footer_text_1\">개인정보 처리방침</span>\r\n");
      out.write("                        <span class=\"footer_text_1 footer_copyright_text\">Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"#\" target=\"_blank\" class=\"team_text\">Komi</a></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("    <!-- Footer Section End -->\r\n");
      out.write("\r\n");
      out.write("    <!-- 상담 -->\r\n");
      out.write("    <div>\r\n");
      out.write("        <div class=\"launcher_character\">\r\n");
      out.write("            <button id=\"launcher_btn\" type=\"button\" class=\"\">\r\n");
      out.write("                <span class=\"text_hidden\">상담 버튼</span>\r\n");
      out.write("                <img alt=\"\" src=\"/comi/resources/images/launcher.png\" width=\"64\" height=\"64\" class=\"character_img\">\r\n");
      out.write("                <div class=\"hidden_message\">\r\n");
      out.write("                    <span class=\"\">0개의 안읽은 메시지</span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- 상담 End -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("	\r\n");
      out.write("	</footer>\r\n");
      out.write("	<!-- Footer Section End -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
