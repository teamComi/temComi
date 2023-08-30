package party.controller;

import static common.PhotoTemplate.savePathChange;
import static common.PhotoTemplate.seqPhotoNum;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.model.service.MemberService;
import member.model.vo.Member;
import party.model.service.PartyService;
import party.model.vo.Party;
import photo.model.service.PhotoService;
import photo.model.vo.Photo;

/**
 * Servlet implementation class partyMakeServlet
 */
@WebServlet("/partyi")
public class PartyInsertServlet extends HttpServlet {

	private static final long serialVersionUID = -1011000182097991224L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PartyInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int photoNum = -1;
		String inputFileName = null;
		int photoResult = 0;
		RequestDispatcher view = null;
		// RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 에러 페이지 급구!
			// view = request.getRequestDispatcher("views/common/error.jsp");
			// request.setAttribute("message", "form의 enctype='multipart/form-data' 속성
			// 누락됨.");
			// view.forward(request, response);
			System.out.println("에러! : enctype='multipart/form-data'");
		}

		int maxSize = 1024 * 1024 * 10;
		String savePath = savePathChange(request.getSession().getServletContext().getRealPath("/resources/partyfile"),
				Integer.toString(photoNum));

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		Photo photo = new Photo();
		Party party = new Party();
		party.setPaTitle(mrequest.getParameter("pa_title"));
		party.setPaCon(mrequest.getParameter("pa_con"));
		party.setMeNum(2);
		// 회원가입 완료후 수정부분
		party.setPaLocation(mrequest.getParameter("address"));
		party.setPaTotalAmount(Integer.parseInt(mrequest.getParameter("pa_total_amount")));
		party.setPaDeposit(Integer.parseInt(mrequest.getParameter("pa_deposit")));
		party.setPaTotalNum(Integer.parseInt(mrequest.getParameter("pa_total_num")));
		party.setPaPerAmount((Integer.parseInt(mrequest.getParameter("pa_total_amount"))
				- Integer.parseInt(mrequest.getParameter("pa_deposit")))
				/ Integer.parseInt(mrequest.getParameter("pa_total_num")));
		party.setPaAct("Y");
		
		if ((inputFileName = mrequest.getFilesystemName("pa_img1")) != null) {
			photoNum = seqPhotoNum("photo");
			party.setPhNum(photoNum);
			
			photo.setPhotonum(photoNum);
			photo.setPhoto1(inputFileName);
			inputFileName = mrequest.getFilesystemName("pa_img2");
			photo.setPhoto2(inputFileName);
			inputFileName = mrequest.getFilesystemName("pa_img3");
			photo.setPhoto3(inputFileName);
			inputFileName = mrequest.getFilesystemName("pa_img4");
			photo.setPhoto4(inputFileName);
			inputFileName = mrequest.getFilesystemName("pa_img5");
			photo.setPhoto5(inputFileName);
			photoResult = new PhotoService().insertPhoto(photo, "photo");
		}
		int result = new PartyService().insertParty(party);
		String panum = new PartyService().getNowPartyNum();
		// System.out.println("result : " + result);

		Member member = new MemberService().selectMember(party.getMeNum());
		ArrayList<Party> list = new PartyService().selectPartyList("open", 1, 6, panum);
		System.out.println(party.getPaNum());
		if (result > 0 && photoResult > 0) {
			String url = "views/party/party_click.jsp";
			// 오픈 URL 주소
			// if(act.equals("N")) url = "views/party/party_click.jsp";

			view = request.getRequestDispatcher(url);
			System.out.println("act : " + party.getPaAct());
			// 파티 활성화 여부
			request.setAttribute("type", (party.getPaAct().toUpperCase().equals("Y")) ? "findParty" : "findReview");
			// 파티 활성화 여부에 따라 보여줄 페이지 선택
			request.setAttribute("party", party);
			// 파티 정보
			request.setAttribute("partyList", list);
			request.setAttribute("member", member);
			// 파티 글 쓴 회원 정보

		} else if (result > 0 && photoResult == 0) {
			// 사진 저장오류
			System.out.println("사진저장 실패");
			response.sendRedirect("/comi/partysall");
		} else {
			// 오류!
			System.out.println("저장 실패");
			System.out.println("result : " + result);
			System.out.println("photoResult : " + photoResult);
			response.sendRedirect("/comi/partysall");
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
