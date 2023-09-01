package party.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import common.JsonReturn;
import common.Paging;
import member.model.service.MemberService;
import member.model.vo.Member;
import party.model.service.PartyService;
import party.model.vo.Party;
import partyCo.model.service.PartyCoService;
import partyCo.model.vo.PartyCo;
import photo.model.vo.Photo;

import static common.PhotoTemplate.*;

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
		int panum = Integer.parseInt(request.getParameter("panum"));
		String act = request.getParameter("act");//활성화 비활성화 여부
		
		//System.out.println("select panum : " + panum);
		Party party = new PartyService().selectParty(panum);
		//System.out.println("party : " + party);
		Member member = new MemberService().selectMember(party.getMeNum());
		RequestDispatcher view = null;
		System.out.println("panum : "+ panum + " party : " + party.getPaNum());
		Photo photo = searchPhoto(party,"party");
		PartyService pservice = new PartyService();
		//System.out.println(photo.getPhotonum());
		//System.out.println("member : " + member);
		
		//JSONObject jparty = new JsonReturn().returnParty(party);
		//JSONObject jmember = new JsonReturn().returnMember(member);
		
		//맨처음 보여질 리스트들 6개만 보이니까 1~6
		ArrayList<Party> list = pservice.selectPartyList("open", 1, 6, Integer.toString(panum));
		//System.out.println("==list : " + list);
		
		String type = (act.equals("Y")) ? "findParty" : "findReview";
		ArrayList<PartyCo> partyCoList = null;
		ArrayList<ArrayList<PartyCo>> coList = null;
		
		Paging paging = null;
		int listCountReply = 0;
		
		if(type == "findReview") {//후기 
			int currentPage = 1;//댓글의 카운트
			int limit = 10;//한페이지당 목록 갯수
			
			//System.out.println("panum : " + panum);
			PartyCoService coservice = new PartyCoService();
			
			listCountReply = coservice.getListCount(panum);
			//System.out.println("==listCount : " + listCount);
			paging = new Paging(listCountReply, currentPage, limit);
			paging.calculator();
			//댓글 부분
			partyCoList = coservice.selectPartyCoList(panum, 1, limit);
			//System.out.println("==partyCoList : " + partyCoList);
			//System.out.println("==partyCoList size : " + partyCoList.size());
			//이중배열 만들어 보내기
			int count = 0;
			if(partyCoList.size() > 0) {
				
				coList = new ArrayList<ArrayList<PartyCo>>();
				ArrayList<PartyCo> cList = new ArrayList<PartyCo>();
				
				for(int i=0; i<partyCoList.size(); i++) {
					//System.out.println("i : " + i);
					int nextDepth = (i < partyCoList.size()-1) ? partyCoList.get(i+1).getComDepth() : -1;//다음번 뎁스
					
					cList.add(partyCoList.get(i));
					
					if(nextDepth == 1 || i == partyCoList.size()-1) {//마지막이거나 다음 뎁스가 1일때
						
						ArrayList<PartyCo> ctemp = (ArrayList<PartyCo>) cList.clone();
						coList.add(ctemp);
						cList.clear();
						count ++;
					}
				}
			}
			//System.out.println("coList : " + coList);
			
		}
		
		if(act != null) {
			String url = "views/party/party_click.jsp";
			//if(act.equals("N")) url = "views/party/party_click.jsp";
			
			view = request.getRequestDispatcher(url);
			//System.out.println("act : " + act);
			request.setAttribute("type", (act.equals("Y")) ? "findParty" : "findReview");
			request.setAttribute("party", party);
			request.setAttribute("partyList", list);
			request.setAttribute("member", member);
			request.setAttribute("photo",photo);
			
			if(type == "findReview") {
				System.out.println("partyColistCount" + listCountReply);
				System.out.println("partyCoPaging" + paging);
				System.out.println("partyCoList" + coList);
				
				request.setAttribute("partyColistCount", listCountReply);
				request.setAttribute("partyCoPaging", paging);
				request.setAttribute("partyCoList", coList);
				//System.out.println(">>partyCoList : " + coList.size());
				//System.out.println(">>partyCoList : " + coList.get(0).get(0).getMeId());
				//System.out.println(">>partyColistCount : " + listCountReply);
			}
			
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
