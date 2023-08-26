package party.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import common.JsonReturn;
import member.model.service.MemberService;
import member.model.vo.Member;
import party.model.service.PartyService;
import party.model.vo.Party;

/**
 * Servlet implementation class PartySelectAllServlet
 */
@WebServlet("/partysel")
public class PartySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartySelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파티 클릭시 
		String panum = request.getParameter("panum");
		String act = request.getParameter("act");//활성화 비활성화 여부
		
		//System.out.println("select panum : " + panum);
		Party party = new PartyService().selectParty(Integer.parseInt(panum));
		//System.out.println("party : " + party);
		Member member = new MemberService().selectMember(party.getMeNum());
		RequestDispatcher view = null;
		//System.out.println("member : " + member);
		
		//JSONObject jparty = new JsonReturn().returnParty(party);
		//JSONObject jmember = new JsonReturn().returnMember(member);
		
		ArrayList<Party> list = new PartyService().selectPartyList("open", 1, 6, panum);
		System.out.println("==list : " + list);
		
		
		if(act != null) {
			String url = "views/party/party_click.jsp";
			//if(act.equals("N")) url = "views/party/party_click.jsp";
			
			view = request.getRequestDispatcher(url);
			request.setAttribute("act", act);
			request.setAttribute("party", party);
			request.setAttribute("partyList", list);
			request.setAttribute("member", member);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "파티 리스트 불러오기 실패");
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
