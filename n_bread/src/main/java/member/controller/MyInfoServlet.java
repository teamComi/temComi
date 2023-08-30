package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet("/myinfo")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내 정보(프로필) 페이지 요청 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		int menum = 14;
		
		Member member = new MemberService().infoMember(menum);
		System.out.println(member.getMePoint());
		//받은 결과로 성공/실패 페이지 내보내기
		RequestDispatcher view = null;
		
		if(member != null) {
			view = request.getRequestDispatcher("views/myinfo/myinfo.jsp");
			request.setAttribute("member", member);
		} else {
			view = request.getRequestDispatcher("views/common/header.jsp");
			//request.setAttribute("message", menum + " 실패");
		}
	
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
