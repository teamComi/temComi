/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-30 03:32:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.party;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class party_005fmake_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/party/../common/footer.jsp", Long.valueOf(1692966060000L));
    _jspx_dependants.put("/views/party/../common/header.jsp", Long.valueOf(1693354152000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

      out.write('\r');
      out.write('\n');
      out.write('	');
 request.setAttribute("type", "make" ); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>party_make</title>\r\n");
      out.write("\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/lib/jquery-ui.min.css\" />\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/main.css\" />\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/view_reply.css\" />\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/party_make.css\" />\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/lib/jquery.min.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/lib/jquery-ui-zoom.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/lib/jquery.ui.touch-punch.min.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/util.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/party_make.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\"\r\n");
      out.write("		src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=16134ee8ff451b97dae7335bb35de144&libraries=services\"></script>\r\n");
      out.write("	<!--\r\n");
      out.write("<script type=\"text/javascript\" src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 사용하세요&libraries=services\"></script>\r\n");
      out.write("-->\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- Header Section Begin -->\r\n");
      out.write("	<header id=\"header_view\">\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("\r\n");

	String type = (String) request.getAttribute("type");

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
      out.write("                        <li class=\"");
      out.print( (type != null && type.equals("make")) ? "active" : "" );
      out.write("\"><a href=\"/comi/views/party/party_make.jsp\">공유 해요</a></li>\r\n");
      out.write("                        <li class=\"");
      out.print( (type != null && type.equals("findParty")) ? "active" : "" );
      out.write("\"><a href=\"/comi/partysall?type=findParty\">공유 찾기</a></li>\r\n");
      out.write("                        <li class=\"");
      out.print( (type != null && type.equals("findReview")) ? "active" : "" );
      out.write("\"><a href=\"/comi/partysall?type=findReview\">공유 후기</a></li>\r\n");
      out.write("                        <li class=\"");
      out.print( (type != null && type.equals("qna")) ? "active" : "" );
      out.write("\"><a href=\"/comi/views/qna/qna.jsp\">Q&A</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!--장바구니, 찜-->\r\n");
      out.write("                <div class=\"header_right right\">\r\n");
      out.write("                    <ul class=\"header_right_widget\">\r\n");
      out.write("                        <li><a href=\"/comi/views/member/member_login.html\">로그인</a></li>\r\n");
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
      out.write("	</header>\r\n");
      out.write("	<!-- Header Section End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- main -->\r\n");
      out.write("	<main class=\"main_wrapper\">\r\n");
      out.write("		<div class=\"container make-view\">\r\n");
      out.write("\r\n");
      out.write("			<form action=\"/comi/partyi\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("				<!-- 카테고리 설정 -->\r\n");
      out.write("				<section class=\"view-section view-category\">\r\n");
      out.write("					<div class=\"title-text view-category-title\">카테고리를 설정해주세요.</div>\r\n");
      out.write("					<div class=\"view-category-content\">\r\n");
      out.write("						<label class=\"view-category-box\">\r\n");
      out.write("							<input type=\"radio\" name=\"category_check\" value=\"모임\"><span>모임</span>\r\n");
      out.write("						</label>\r\n");
      out.write("						<label class=\"view-category-box\">\r\n");
      out.write("							<input type=\"radio\" name=\"category_check\" value=\"공구\"><span>공구</span>\r\n");
      out.write("						</label>\r\n");
      out.write("						<label class=\"view-category-box\">\r\n");
      out.write("							<input type=\"radio\" name=\"category_check\" value=\"렌탈\"><span>렌탈</span>\r\n");
      out.write("						</label>\r\n");
      out.write("						<label class=\"view-category-box\">\r\n");
      out.write("							<input type=\"radio\" name=\"category_check\" value=\"게임\"><span>게임</span>\r\n");
      out.write("						</label>\r\n");
      out.write("						<label class=\"view-category-box\">\r\n");
      out.write("							<input type=\"radio\" name=\"category_check\" value=\"OTT\"><span>OTT</span>\r\n");
      out.write("						</label>\r\n");
      out.write("						<label class=\"view-category-box\">\r\n");
      out.write("							<input type=\"radio\" name=\"category_check\" value=\"기타\"><span>기타 </span>\r\n");
      out.write("						</label>\r\n");
      out.write("					</div>\r\n");
      out.write("				</section>\r\n");
      out.write("				<!-- 카테고리 설정 end-->\r\n");
      out.write("\r\n");
      out.write("				<!-- 가격 및 디파짓 및 인원 설정 -->\r\n");
      out.write("				<section class=\"view-section view-price\">\r\n");
      out.write("					<div class=\"title-text view-category-title\">가격및 거치금을 설정해주세요.</div>\r\n");
      out.write("					<div class=\"view-price-content\">\r\n");
      out.write("\r\n");
      out.write("						<div class=\"view-price-barbox\">\r\n");
      out.write("							<div class=\"view-price-bar\">\r\n");
      out.write("								<div id=\"view-price-bar-price\"></div>\r\n");
      out.write("								<div id=\"view-price-bar-deposit\"></div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div id=\"view-price-cursor\"></div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<fieldset class=\"view-price-field\">\r\n");
      out.write("							<div class=\"view-price-field-div\">\r\n");
      out.write("								가격 &nbsp;<input type=\"number\" id=\"setting_price\" min=\"10000\" max=\"10000000\"\r\n");
      out.write("									step=\"1000\" value=\"5000\" name=\"pa_total_amount\">\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"view-price-field-div\">\r\n");
      out.write("								거치금 &nbsp;<input type=\"number\" id=\"setting_deposit\" min=\"10000\" max=\"10000000\"\r\n");
      out.write("									step=\"1000\" value=\"10000\" name=\"pa_deposit\">\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"view-price-field-div\">\r\n");
      out.write("								모집인원 &nbsp;<input type=\"number\" id=\"setting_people\" min=\"1\" max=\"20\" step=\"1\"\r\n");
      out.write("									value=\"1\" name=\"pa_total_num\">\r\n");
      out.write("							</div>\r\n");
      out.write("						</fieldset>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"view-price-peopleprice\">1인당 금액 : 5000원</div>\r\n");
      out.write("				</section>\r\n");
      out.write("				<!-- 가격 및 디파짓 및 인원 설정 end -->\r\n");
      out.write("\r\n");
      out.write("				<!-- 게시글 설정 -->\r\n");
      out.write("				<section class=\"view-section view-notice\">\r\n");
      out.write("					<div class=\"view-notice-title title-text\">공유 모임글을 작성해주세요.</div>\r\n");
      out.write("					<div class=\"view-notice-area\">\r\n");
      out.write("\r\n");
      out.write("				<div class=\"view-notice-box\">\r\n");
      out.write("					<div class=\"view-notice-box-title\">공유 날짜</div>\r\n");
      out.write("					<div class=\"review-write-area-inbox\">\r\n");
      out.write("						<input type=\"date\" title=\"공유 날짜\" value=\"2023-09-01\" class=\"review-input-date\" name=\"pa_time_1\"\r\n");
      out.write("							id=\"notice_write_date_1\">\r\n");
      out.write("						<input type=\"time\" title=\"공유 날짜\" value=\"13:10:20\" class=\"review-input-date\" name=\"pa_time_2\"\r\n");
      out.write("						id=\"notice_write_date_2\">\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("				<div class=\"view-notice-box\">\r\n");
      out.write("					<div class=\"view-notice-box-title\">제목</div>\r\n");
      out.write("					<div class=\"review-write-area-inbox\">\r\n");
      out.write("						<input type=\"text\" title=\"제목\" class=\"review-write-textarea input\" name=\"pa_title\"\r\n");
      out.write("							id=\"notice_write_input\">\r\n");
      out.write("\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<div class=\"view-notice-box\">\r\n");
      out.write("							<div class=\"view-notice-box-title\">자세한 설명</div>\r\n");
      out.write("							<div class=\"review-write-area-inbox\">\r\n");
      out.write("								<textarea title=\"자세한 설명\" class=\"review-write-textarea\" name=\"pa_con\"\r\n");
      out.write("									id=\"notice_write_textarea\" rows=\"3\" cols=\"30\"></textarea>\r\n");
      out.write("\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<div class=\"view-notice-box\">\r\n");
      out.write("							<div class=\"view-notice-box-title under-line\">사진</div>\r\n");
      out.write("							<div class=\"view-notice-picture-box\">\r\n");
      out.write("\r\n");
      out.write("								<div class=\"view-notice-picture-left\">\r\n");
      out.write("									<div class=\"view-notice-picture-explain\">\r\n");
      out.write("										<div class=\"view-notice-picture-textbig\">이미지 추가등록</div>\r\n");
      out.write("										<div class=\"view-notice-picture-textsmall\">\r\n");
      out.write("											이미지는 최대 5장까지 등록가능합니다.<br> 이미지 권장 사이즈는 700 * 500입니다.\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("\r\n");
      out.write("								<div class=\"view-notice-picture-area\">\r\n");
      out.write("									<label class=\"view-notice-picture\">\r\n");
      out.write("										<input type=\"file\" name=\"pa_img1\" style=\"display: none;\">\r\n");
      out.write("										<samp>이미지<br>업로드</samp>\r\n");
      out.write("									</label>\r\n");
      out.write("									<label class=\"view-notice-picture\">\r\n");
      out.write("										<input type=\"file\" name=\"pa_img2\" style=\"display: none;\">\r\n");
      out.write("										<samp>이미지<br>업로드</samp>\r\n");
      out.write("									</label>\r\n");
      out.write("									<label class=\"view-notice-picture\">\r\n");
      out.write("										<input type=\"file\" name=\"pa_img3\" style=\"display: none;\">\r\n");
      out.write("										<samp>이미지<br>업로드</samp>\r\n");
      out.write("									</label>\r\n");
      out.write("									<label class=\"view-notice-picture\">\r\n");
      out.write("										<input type=\"file\" name=\"pa_img4\" style=\"display: none;\">\r\n");
      out.write("										<samp>이미지<br>업로드</samp>\r\n");
      out.write("									</label>\r\n");
      out.write("									<label class=\"view-notice-picture\">\r\n");
      out.write("										<input type=\"file\" name=\"pa_img5\" style=\"display: none;\">\r\n");
      out.write("										<samp>이미지<br>업로드</samp>\r\n");
      out.write("									</label>\r\n");
      out.write("\r\n");
      out.write("								</div>\r\n");
      out.write("\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<div class=\"view-notice-box\">\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("						<div class=\"view-notice-box-title\">공유 희망 장소</div>\r\n");
      out.write("						<div class=\"view-notice-location\">\r\n");
      out.write("							<div class=\"view-notice-location-title\">\r\n");
      out.write("								<div class=\"notice-text-bold\">파티원들과 만나서 물건을 전달하거나 모임을 가질\r\n");
      out.write("									장소를 선택해 주세요.</div>\r\n");
      out.write("								<div class=\"notice-text-normal\">누구나 찾기 쉬운 공공장소가 좋아요.</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"view-notice-location-box\">\r\n");
      out.write("								<div class=\"view-notice-location-search location-box-style\">\r\n");
      out.write("									<div class=\"view-notice-location-searchtext\">\r\n");
      out.write("										<input type=\"hidden\" id=\"address\" name=\"address\"\r\n");
      out.write("											class=\"postcodify_address\" size=\"100\">\r\n");
      out.write("										<input type=\"text\" value=\"홍대입구역\" id=\"keyword\" size=\"100\">\r\n");
      out.write("									</div>\r\n");
      out.write("\r\n");
      out.write("									<input type=\"button\" value=\"검색하기\" onclick=\"searchPlaces(); return false;\">\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"map_wrap\">\r\n");
      out.write("									<div id=\"map\" style=\"width:100%;height:100%;\"></div>\r\n");
      out.write("									<div id=\"menu_wrap\" class=\"bg_white\" style=\"display: none;\">\r\n");
      out.write("										<div class=\"option\">\r\n");
      out.write("											<div>\r\n");
      out.write("												<form onsubmit=\"searchPlaces(); return false;\">\r\n");
      out.write("												</form>\r\n");
      out.write("											</div>\r\n");
      out.write("										</div>\r\n");
      out.write("										<hr>\r\n");
      out.write("										<ul id=\"placesList\" style=\"display: none;\"></ul>\r\n");
      out.write("										<div id=\"pagination\" style=\"display: none;\"></div>\r\n");
      out.write("\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<div class=\"view-notice-box\">\r\n");
      out.write("							<input type=\"submit\" value=\"작성완료\" class=\"view-notice-btn\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</section>\r\n");
      out.write("			</form>\r\n");
      out.write("\r\n");
      out.write("			<!-- 결제 설정 -->\r\n");
      out.write("			<!--\r\n");
      out.write("	<section class=\"view-section view-location\">\r\n");
      out.write("		<button class=\"view-payment-btn\">\r\n");
      out.write("			<img class=\"view-payment-btn-img\" src=\"/comi/resources/images/payment_btn.png\">\r\n");
      out.write("		</button>\r\n");
      out.write("	</section>\r\n");
      out.write("	-->\r\n");
      out.write("			<!-- 결제 설정 end-->\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</main>\r\n");
      out.write("	<!-- main end-->\r\n");
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
      out.write("                                    <span class=\"footer_right_sub_text\"><a href=\"/comi/noticesall\">공지사항</a></span>\r\n");
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
      out.write("\r\n");
      out.write("	</footer>\r\n");
      out.write("	<!-- Footer Section End -->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
