package partyCo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import common.JsonReturn;
import common.Paging;
import party.model.service.PartyService;
import partyCo.model.service.PartyCoService;
import partyCo.model.vo.PartyCo;

/**
 * Servlet implementation class PartyReSelectAllServlet
 */
@WebServlet("/partycoins")
public class PartyCoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartyCoInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int menum = Integer.parseInt(request.getParameter("menum"));
		int panum = Integer.parseInt(request.getParameter("panum"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		int parent = Integer.parseInt(request.getParameter("parent"));
		int currentPage = 1;//현재페이지
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		String content = request.getParameter("content");
		
		System.out.println("??parent : " + parent);
		
		PartyCoService coservice = new PartyCoService();
		PartyCo partyCo = new PartyCo(panum, parent, depth, content, menum);
		int result = coservice.insertPartyCo(partyCo);
		
		if(result > 0) {
			
			int limit = 10;//한페이지당 목록 갯수
			
			int listCount = coservice.getListCount(panum);
			System.out.println("??listCount : " + listCount);
			Paging paging = new Paging(listCount, currentPage, limit);
			paging.calcuator();
			
			//댓글 부분
			ArrayList<PartyCo> partyCoList = coservice.selectPartyCoList(panum, paging.getStartRow(), paging.getEndRow());
			System.out.println("??partyCoList : " + partyCoList);
			
			
			//이중배열 만들어 보내기
			JSONArray coList = null;
			//ArrayList<ArrayList<PartyCo>> coList = null;
			int count = 0;
			if(partyCoList.size() > 0) {
				
				//coList = new ArrayList<ArrayList<PartyCo>>();
				coList = new JSONArray();
				//ArrayList<PartyCo> cList = new ArrayList<PartyCo>();
				JSONArray cList = new JSONArray();
				
				for(int i=0; i<partyCoList.size(); i++) {
					System.out.println("i : " + i);
					int nextDepth = (i < partyCoList.size()-1) ? partyCoList.get(i+1).getComDepth() : -1;//다음번 뎁스
					
					cList.add(new JsonReturn().returnPartyCo(partyCoList.get(i)));
					
					if(nextDepth == 1 || i == partyCoList.size()-1) {//마지막이거나 다음 뎁스가 1일때
						
						JSONArray ctemp = (JSONArray) cList.clone();
						coList.add(ctemp);
						cList.clear();
						count ++;
					}
				}
			}
			JSONObject pagingJason = new JsonReturn().returnPaging(paging);
			
			
			JSONObject sendJson = new JSONObject();
			sendJson.put("paging", pagingJason);
			sendJson.put("list", coList);
			sendJson.put("listCount", listCount);
			System.out.println("sendJson : " + sendJson);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(sendJson);
			out.flush();
			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");//상대경로만 사용가능
			request.setAttribute("message", "댓글 등록 실패");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
