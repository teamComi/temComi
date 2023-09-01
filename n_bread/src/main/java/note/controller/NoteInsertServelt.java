package note.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import note.model.service.NoteService;
import note.model.vo.Note;

/**
 * Servlet implementation class MessageInsertServelt
 */
@WebServlet("/noinsert")
public class NoteInsertServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteInsertServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쪽지 쓰기 요청용 컨트롤러
		//1. 전송온 값에 한글이 있다면 인코딩처리함
		request.setCharacterEncoding("UTF-8");
		
		Note message = new Note();
		
		message.setMeNum(Integer.parseInt(request.getParameter("meNum"))); //상대방
		
		message.setNoCon(request.getParameter("content"));
		//String noCon = request.getParameter("content"); //내용
				
		message.setNoNum(Integer.parseInt(request.getParameter("noNum"))); //나
		
		//모델 서비스 메소드로 전달하고 결과받기
		int result = new NoteService().insertMessage(message);
		
		//받은 결과로 성공/실패 페이지 내보내기
		if(result > 0) {
			response.sendRedirect("comi/main.jsp");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "쪽지 발송 실패.");
			
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
