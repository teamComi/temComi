/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-24 09:05:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.party;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.simple.JSONObject;
import member.model.vo.Member;
import party.model.vo.Party;

public final class party_005fclosed_005fclick_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.json.simple.JSONObject");
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("party.model.vo.Party");
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
 
	JSONObject jparty = (JSONObject) request.getAttribute("party");
	JSONObject jmember = (JSONObject) request.getAttribute("member");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>party_closed</title>\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/lib/slick.min.css\">\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/lib/slick-theme.min.css\">\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/lib/jquery-ui.min.css\"/>\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/main.css\"/>\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/review.css\"/>\r\n");
      out.write("	<link rel=\"stylesheet\" type=\"text/css\" href=\"/comi/resources/css/party_closed_click.css\"/>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/lib/jquery.min.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/lib/slick.min.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/common.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		var partyStr = JSON.stringify(");
      out.print( jparty );
      out.write(");\r\n");
      out.write("		var partyData = JSON.parse(partyStr);\r\n");
      out.write("		\r\n");
      out.write("		var memberStr = JSON.stringify(");
      out.print( jmember );
      out.write(");\r\n");
      out.write("		var memberData = JSON.parse(memberStr);\r\n");
      out.write("	    console.log('partyStr : ' + partyStr);\r\n");
      out.write("	    console.log('memberStr : ' + memberStr);\r\n");
      out.write("    </script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/clickView.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/makeParty.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/party_closed_click.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\" src=\"/comi/resources/js/slick_set.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- Header Section Begin -->\r\n");
      out.write("    <header id=\"header_view\">    \r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- Header Section End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- main -->\r\n");
      out.write("	<main class=\"main_wrapper\">\r\n");
      out.write("		<div class=\"container side_margin_zero\">\r\n");
      out.write("			<div class=\"party_closed_up\">종료된 모임이에요.</div>\r\n");
      out.write("\r\n");
      out.write("			<!-- 슬라이더 -->\r\n");
      out.write("			<div class=\"main_slider margin-bottom10px\">\r\n");
      out.write("				<div id=\"slider_main\">\r\n");
      out.write("					\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<!-- 프로필 -->\r\n");
      out.write("			<section id=\"article-profile\">\r\n");
      out.write("				<div class=\"article-profile-box\">\r\n");
      out.write("					<a class=\"article-profile-link\" href=\"#\">\r\n");
      out.write("						<div class=\"space-between\">\r\n");
      out.write("							<div class=\"display-align-items-center\">\r\n");
      out.write("								<div id=\"article-profile-image-box\">\r\n");
      out.write("									<img src=\"\" />\r\n");
      out.write("								</div>\r\n");
      out.write("								<div id=\"article-profile-left\">\r\n");
      out.write("									<div id=\"article-nickname\"></div>\r\n");
      out.write("									<div id=\"article-region-name\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"article-profile-right\">\r\n");
      out.write("								<div class=\"temperature-wrap\">\r\n");
      out.write("									<span>신뢰도</span>\r\n");
      out.write("									<span class=\"text-color text-color-03\" id=\"text-color-id\"></span>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"meters\">\r\n");
      out.write("									<div class=\"bar bar-color-03\" id=\"bar-color-id\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"temperature-face\">\r\n");
      out.write("									<img id=\"temperature-face-id\" src=\"/comi/resources/images/launcher.png\" />\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</a>\r\n");
      out.write("				</div>\r\n");
      out.write("			</section>\r\n");
      out.write("			<!-- 프로필 end-->\r\n");
      out.write("			\r\n");
      out.write("			<!-- 게시글 -->\r\n");
      out.write("			<section id=\"article-description\">\r\n");
      out.write("				<h1 id=\"article-title\"></h1>\r\n");
      out.write("				<p id=\"article-category\">\r\n");
      out.write("				  모임 ∙\r\n");
      out.write("				  <span id=\"article-befordate\">\r\n");
      out.write("					\r\n");
      out.write("				  </span>\r\n");
      out.write("				</p>\r\n");
      out.write("				<p id=\"article-location\">\r\n");
      out.write("\r\n");
      out.write("				</p>\r\n");
      out.write("				<div id=\"article-price-box\">\r\n");
      out.write("					\r\n");
      out.write("					<div id=\"article-deposit\"></div>\r\n");
      out.write("					<div id=\"article-bar-box\">\r\n");
      out.write("						<span id=\"article-price-bar\"></span>\r\n");
      out.write("						<span id=\"article-deposit-bar\"></span>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div id=\"article-price\"></div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"article-people-box\">\r\n");
      out.write("						<div id=\"article-people\"></div>\r\n");
      out.write("						<div id=\"article-people-price\"></div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div id=\"article-detail\">\r\n");
      out.write("					<p>\r\n");
      out.write("						\r\n");
      out.write("					</p>\r\n");
      out.write("				</div>\r\n");
      out.write("				<p id=\"article-counts\">\r\n");
      out.write("					\r\n");
      out.write("				</p>\r\n");
      out.write("			</section>\r\n");
      out.write("			<!-- 게시글 end-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<!-- 게시글 리뷰-->\r\n");
      out.write("			<section id=\"review\">\r\n");
      out.write("\r\n");
      out.write("				<!--댓글 헤드-->\r\n");
      out.write("				<div class=\"review-head\">\r\n");
      out.write("					<span class=\"review-head-title\">54개의 댓글</span>\r\n");
      out.write("					<button type=\"button\" class=\"review-head-refresh\" alt=\"새로고침\">\r\n");
      out.write("						<img src=\"/comi/resources/images/refresh.png\">\r\n");
      out.write("					</button>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!--댓글 헤드 end-->\r\n");
      out.write("\r\n");
      out.write("				<!--댓글 쓰기-->\r\n");
      out.write("				<div class=\"review-write\">\r\n");
      out.write("					<form>\r\n");
      out.write("						<fieldset>\r\n");
      out.write("							<legend class=\"u_vc\">댓글 쓰기</legend>\r\n");
      out.write("							<div class=\"review-write-inner\">\r\n");
      out.write("								\r\n");
      out.write("								<div class=\"review-write-profilearea\">\r\n");
      out.write("									<div class=\"review-write-profile\">\r\n");
      out.write("										<img src=\"/comi/resources/images/deafault.png\" class=\"img-profile\">\r\n");
      out.write("										<span class=\"write-name\">donkihotex</span>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("\r\n");
      out.write("								<div class=\"review-write-area\">\r\n");
      out.write("									<div class=\"review-write-area-inbox\">\r\n");
      out.write("										<textarea title=\"댓글\" class=\"review-write-textarea\" id=\"review_write_textarea_1\" rows=\"3\" cols=\"30\"></textarea>\r\n");
      out.write("										<label for=\"review_write_textarea_1\" class=\"u_cbox_guide\">\r\n");
      out.write("											다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  \r\n");
      out.write("											모든 작성자는 <em class=\"guide_emphasis\">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.\r\n");
      out.write("										</label>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("								\r\n");
      out.write("								<div class=\"review-write-count-box\">\r\n");
      out.write("									<div class=\"review-write-count\">\r\n");
      out.write("										<strong class=\"review-write-count-num\">0</strong>/\r\n");
      out.write("										<span class=\"review-write-count-total\">300</span>\r\n");
      out.write("									</div>\r\n");
      out.write("									<button type=\"button\" class=\"review-write-upload\">\r\n");
      out.write("										<span class=\"review-write-upload-text\">등록</span>\r\n");
      out.write("									</button>\r\n");
      out.write("								</div>\r\n");
      out.write("							\r\n");
      out.write("							</div>\r\n");
      out.write("						</fieldset>\r\n");
      out.write("					</form>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!--댓글 쓰기 end-->\r\n");
      out.write("\r\n");
      out.write("				<!--댓글 정렬 버튼-->\r\n");
      out.write("				<div class=\"review-sort\">\r\n");
      out.write("					<button class=\"review-sort-btn sort-type-1 active\">공감순</button>\r\n");
      out.write("					<button class=\"review-sort-btn sort-type-2\">최신순</button>\r\n");
      out.write("					<button class=\"review-sort-btn sort-type-3\">답글순</button>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!--댓글 정렬 버튼 end-->\r\n");
      out.write("\r\n");
      out.write("				<!--댓글 보기-->\r\n");
      out.write("				<div class=\"review-body\">\r\n");
      out.write("					\r\n");
      out.write("					<!--댓글 첫번째-->\r\n");
      out.write("					<div class=\"review-body-container reviewbody-first\">\r\n");
      out.write("\r\n");
      out.write("						<div class=\"review-body-box\">\r\n");
      out.write("\r\n");
      out.write("							<div class=\"review-body-list\">\r\n");
      out.write("								<div class=\"review-body-list-profile\">\r\n");
      out.write("									<img class=\"review-body-list-profile-img\" src=\"/comi/resources/images/profile.png\">\r\n");
      out.write("									<div class=\"review-body-list-profile-box\">\r\n");
      out.write("										<div class=\"review-body-list-name\">마이프레셔스</div>\r\n");
      out.write("										<div class=\"review-body-list-date\">2023.08.05 14:57</div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"review-body-list-right\">\r\n");
      out.write("									<button class=\"review-body-list-right-btn\">\r\n");
      out.write("										<img class=\"review-body-list-right-btn-img\" src=\"/comi/resources/images/profile.png\">\r\n");
      out.write("									</button>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("\r\n");
      out.write("							<div class=\"review-body-read\">\r\n");
      out.write("								<div class=\"review-body-read-text\">\r\n");
      out.write("									이 편지는 1956년 영국에서 시작되었습니다. \r\n");
      out.write("									이 편지를 받은 사람은 저주에 빠지게 됨니다.\r\n");
      out.write("									그래서 돈을 보내야 함니다.\r\n");
      out.write("									이 편지는 1956년 영국에서 시작되었습니다. \r\n");
      out.write("									이 편지를 받은 사람은 저주에 빠지게 됨니다.\r\n");
      out.write("									그래서 돈을 보내야 함니다.내야 함니다. 내야 함니다.\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("\r\n");
      out.write("							<div class=\"review-body-bottom\">\r\n");
      out.write("								<button class=\"review-body-bottom-retext\">\r\n");
      out.write("									답글 <b>1</b>\r\n");
      out.write("								</button>\r\n");
      out.write("								<div class=\"review-body-bottom-heartbox\">\r\n");
      out.write("									<button class=\"review-body-bottom-heart\">\r\n");
      out.write("										<img class=\"review-body-bottom-heart-img\" src=\"/comi/resources/images/heart.png\">\r\n");
      out.write("									</button>\r\n");
      out.write("									<span>0</span>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("					<!--댓글 첫번째 end-->\r\n");
      out.write("\r\n");
      out.write("					<!--댓글 두번째-->\r\n");
      out.write("					<div class=\"review-body-container reviewbody-second\">\r\n");
      out.write("\r\n");
      out.write("						<div class=\"review-body-box\">\r\n");
      out.write("\r\n");
      out.write("							<div class=\"review-body-list\">\r\n");
      out.write("								<div class=\"review-body-list-profile\">\r\n");
      out.write("									<img class=\"review-body-list-profile-img\" src=\"/comi/resources/images/profile.png\">\r\n");
      out.write("									<div class=\"review-body-list-profile-box\">\r\n");
      out.write("										<div class=\"review-body-list-name\">마이프레셔스</div>\r\n");
      out.write("										<div class=\"review-body-list-date\">2023.08.05 14:57</div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"review-body-list-right\">\r\n");
      out.write("									<button class=\"review-body-list-right-btn\">\r\n");
      out.write("										<img class=\"review-body-list-right-btn-img\" src=\"/comi/resources/images/profile.png\">\r\n");
      out.write("									</button>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("\r\n");
      out.write("							<div class=\"review-body-read\">\r\n");
      out.write("								<div class=\"review-body-read-text\">\r\n");
      out.write("									이 편지는 1956년 영국에서 시작되었습니다. \r\n");
      out.write("									이 편지를 받은 사람은 저주에 빠지게 됨니다.\r\n");
      out.write("									그래서 돈을 보내야 함니다.\r\n");
      out.write("									이 편지는 1956년 영국에서 시작되었습니다. \r\n");
      out.write("									이 편지를 받은 사람은 저주에 빠지게 됨니다.\r\n");
      out.write("									그래서 돈을 보내야 함니다.내야 함니다. 내야 함니다.\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("\r\n");
      out.write("							<div class=\"review-body-bottom\">\r\n");
      out.write("								<button class=\"review-body-bottom-retext\">\r\n");
      out.write("									답글 <b>1</b>\r\n");
      out.write("								</button>\r\n");
      out.write("								<div class=\"review-body-bottom-heartbox\">\r\n");
      out.write("									<button class=\"review-body-bottom-heart\">\r\n");
      out.write("										<img class=\"review-body-bottom-heart-img\" src=\"/comi/resources/images/heart.png\">\r\n");
      out.write("									</button>\r\n");
      out.write("									<span>0</span>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("					<!--댓글 두번째 end-->\r\n");
      out.write("\r\n");
      out.write("					<!--댓글 쓰기-->\r\n");
      out.write("					<div class=\"review-write review-rewriting\">\r\n");
      out.write("						<form>\r\n");
      out.write("							<fieldset>\r\n");
      out.write("								<legend class=\"u_vc\">댓글 쓰기</legend>\r\n");
      out.write("								<div class=\"review-write-inner\">\r\n");
      out.write("									\r\n");
      out.write("									<div class=\"review-write-profilearea\">\r\n");
      out.write("										<div class=\"review-write-profile\">\r\n");
      out.write("											<img src=\"/comi/resources/images/deafault.png\" class=\"img-profile\">\r\n");
      out.write("											<span class=\"write-name\">donkihotex</span>\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("\r\n");
      out.write("									<div class=\"review-write-area\">\r\n");
      out.write("										<div class=\"review-write-area-inbox\">\r\n");
      out.write("											<textarea title=\"댓글\" class=\"review-write-textarea\" id=\"review_write_textarea_2\" rows=\"3\" cols=\"30\"></textarea>\r\n");
      out.write("											<label for=\"review_write_textarea_2\" class=\"u_cbox_guide\">\r\n");
      out.write("												다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  \r\n");
      out.write("												모든 작성자는 <em class=\"guide_emphasis\">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.\r\n");
      out.write("											</label>\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("									\r\n");
      out.write("									<div class=\"review-write-count-box\">\r\n");
      out.write("										<div class=\"review-write-count\">\r\n");
      out.write("											<strong class=\"review-write-count-num\">0</strong>/\r\n");
      out.write("											<span class=\"review-write-count-total\">300</span>\r\n");
      out.write("										</div>\r\n");
      out.write("										<button type=\"button\" class=\"review-write-upload\">\r\n");
      out.write("											<span class=\"review-write-upload-text\">등록</span>\r\n");
      out.write("										</button>\r\n");
      out.write("									</div>\r\n");
      out.write("								\r\n");
      out.write("								</div>\r\n");
      out.write("							</fieldset>\r\n");
      out.write("						</form>\r\n");
      out.write("					</div>\r\n");
      out.write("					<!--댓글 쓰기 end-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("				<!--댓글 보기 end-->\r\n");
      out.write("\r\n");
      out.write("			</section>\r\n");
      out.write("			<!-- 게시글 리뷰 end-->\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			<!-- 공유 모임 더 보기 -->\r\n");
      out.write("			<section class=\"article-party-share\">\r\n");
      out.write("				<div class=\"article-party-share-box\">\r\n");
      out.write("					<div class=\"article-party-share-title\">인기공유모임</div>\r\n");
      out.write("					<a id=\"article-party-share-re\" href=\"/comi/partysall?type=findParty\">더보기</a>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("				<div class=\"main_portfolio\" id=\"portf_box\">\r\n");
      out.write("					\r\n");
      out.write("				</div>\r\n");
      out.write("			</section>\r\n");
      out.write("			<!-- 공유 모임 더 보기 end-->\r\n");
      out.write("			\r\n");
      out.write("		</div>\r\n");
      out.write("	</main>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	<!-- Footer Section Begin -->\r\n");
      out.write("	<footer id=\"footer_view\">	\r\n");
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
