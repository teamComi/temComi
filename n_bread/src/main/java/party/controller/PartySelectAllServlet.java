package party.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

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
import party.model.vo.Party;

/**
 * Servlet implementation class MenuLinkServlet
 */
@WebServlet("/partysall")
public class PartySelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartySelectAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		String keyword = request.getParameter("keyword");
		String sort = request.getParameter("sort");//정렬
		String classfy = request.getParameter("classfy");//분류
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);;
		int limit = 10;
		
		PartyService pservice = new PartyService();
		
		String act = (type.equals("findParty")) ? "Y" : "N";
		int listCount = pservice.getListCount(act);
		System.out.println("--listCount : " + listCount);
		Paging paging = new Paging(listCount, currentPage, limit);
		paging.calculator();
		
		int start = paging.getStartRow(); 
		int end = paging.getEndRow();
		
		String selType = (type.equals("findParty")) ? "Y" : "N";
		ArrayList<Party> list = null;//활성화
		HashMap<String, String> map = null;
		System.out.println("--type : " + type + ", start : " + start + ", end : " + end);
		
		if(keyword == null) list = pservice.selectPartyAll(selType, start, end);//활성화
		else {
			map = new HashMap<String, String>();
			map.put("selType", selType);
			map.put("sort", sort);
			map.put("classfy", classfy);
			map.put("keyword", keyword);
			map.put("start", String.valueOf(start));
			map.put("end", String.valueOf(end));
			list = pservice.searchParty(map);//활성화
		}
		
		System.out.println("list : " + list);
		
		RequestDispatcher view = null;
		
		
		
		sort = (sort == null) ? "current" : sort;
		classfy = (classfy == null) ? "-1" : classfy;
		System.out.println("sort : " + sort + "  classfy : " + classfy);
		if(list != null && list.size() > 0) {
			view = request.getRequestDispatcher("views/party/party_view.jsp");
			request.setAttribute("sort", sort);
			request.setAttribute("classfy", Integer.parseInt(classfy));
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("type", type);
			request.setAttribute("partyList", list);
		}else {
			view = request.getRequestDispatcher("views/party/party_view.jsp");
			request.setAttribute("sort", sort);
			request.setAttribute("classfy", Integer.parseInt(classfy));
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("type", type);
			request.setAttribute("partyList", list);
			//view = request.getRequestDispatcher("views/common/error.jsp");
			//request.setAttribute("message", "파티 리스트 불러오기 실패");
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
