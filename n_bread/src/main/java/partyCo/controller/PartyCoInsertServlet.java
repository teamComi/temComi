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
		int panum = Integer.parseInt(request.getParameter("panum"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		int parent = Integer.parseInt(request.getParameter("parent"));
		int currentPage = 1;//현재페이지
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		String content = request.getParameter("content");
		
		PartyCoService coservice = new PartyCoService();
		PartyCo partyCo = new PartyCo(panum, parent, depth, content);
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
			
			//리스트 불러오기 
			JSONArray jarr = new JSONArray();
			
			for(PartyCo pc : partyCoList) {
				JSONObject json = new JsonReturn().returnPartyCo(pc);
				jarr.add(json);
			}
			
			JSONObject sendJson = new JSONObject();
			sendJson.put("list", jarr);
			
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
