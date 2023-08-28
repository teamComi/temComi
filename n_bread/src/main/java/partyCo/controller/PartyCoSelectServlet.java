package partyCo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
@WebServlet("/partycosel")
public class PartyCoSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartyCoSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int panum = Integer.parseInt(request.getParameter("panum"));
		int currentPage = 1;
		//전송온 페이지 값이 있다면 추출함
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//한페이지당 목록 갯수
		int limit = 10;
		
		System.out.println("panum : " + panum);
		PartyCoService coservice = new PartyCoService();
		
		int listCount = coservice.getListCount();
		System.out.println("listCount : " + listCount);
		Paging paging = new Paging(listCount, currentPage, limit);
		paging.calculator();
		
		
		ArrayList<PartyCo> list = coservice.selectPartyCoAll(panum);
		
		System.out.println("list : " + list);
		
		JsonReturn jsonR = new JsonReturn();
		JSONArray jarr = new JSONArray();
		JSONArray pagingArr = new JSONArray();
		
		for(PartyCo partyCo : list) {
			JSONObject json = jsonR.returnPartyCo(partyCo);
			jarr.add(json);
		}
		for(PartyCo partyCo : list) {
			JSONObject json2 = jsonR.returnPaging(paging);
			pagingArr.add(json2);
		}
		
		JSONObject sendJson = new JSONObject();
		sendJson.put("list", jarr);
		sendJson.put("paging", pagingArr);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(sendJson);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
