package partyCo.model.service;

import partyCo.model.dao.PartyCoDao;
import partyCo.model.vo.PartyCo;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class PartyCoService {
	private PartyCoDao dao = new PartyCoDao();
	
	public PartyCoService() {}
	
	//조회 
	public PartyCo selectPartyCo(int panum) {
		Connection conn = getConnection();
		PartyCo partyCo = dao.selectPartyCo(conn, panum);
		close(conn);
		return partyCo;
	}
	
	//전체 조회
	public ArrayList<PartyCo> selectPartyCoAll(int panum) {
		Connection conn = getConnection();
		ArrayList<PartyCo> list = dao.selectPartyCoAll(conn, panum);
		close(conn);
		return list;
	}
	
	//리스트 카운트 조회
	public int getListCount(int pa_num) {
		Connection conn = getConnection();
		int listCount = dao.getListCount(conn, pa_num);
		close(conn);
		return listCount;
	}
	
	//리스트 조회
	public ArrayList<PartyCo> selectPartyCoList(int panum, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<PartyCo> list = dao.selectPartyCoList(conn, panum, startRow, endRow);
		close(conn);
		return list;
	}
	
	//삽입
	public int insertPartyCo(PartyCo partyCo) {
		Connection conn = getConnection();
		int result = dao.insertPartyCo(conn, partyCo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
	
	//수정
	public int updatePartyCo(PartyCo partyCo) {
		Connection conn = getConnection();
		int result = dao.updatePartyCo(conn, partyCo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
			
		close(conn);
		return result;
	}
	
	//삭제
	public int deletePartyCo(PartyCo partyCo) {
		Connection conn = getConnection();
		int result = dao.deletePartyCo(conn, partyCo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
			
		close(conn);
		return result;
	}
	
	//첨부파일 업로드
	public int loadPartyCo(PartyCo partyCo) {
		Connection conn = getConnection();
		int result = dao.loadPartyCo(conn, partyCo);
		if(result > 0) commit(conn);
		else rollback(conn);
			
		close(conn);
		return result;
	}
	
	//검색
	public ArrayList<PartyCo> searchPartyCo(String keyword){
		Connection conn = getConnection();
		ArrayList<PartyCo> list = dao.searchPartyCo(conn, keyword);
		close(conn);
		return list;
	}
	
	//정렬 - 공감순
	public ArrayList<PartyCo> sortPartyCoInterest(String keyword){
		Connection conn = getConnection();
		ArrayList<PartyCo> list = dao.searchPartyCoInterest(conn, keyword);
		close(conn);
		return list;
	}
	
	//정렬 - 카테고리
	public ArrayList<PartyCo> sortPartyCoCategory(String keyword){
		Connection conn = getConnection();
		ArrayList<PartyCo> list = dao.sortPartyCoCategory(conn, keyword);
		close(conn);
		return list;
	}
	
	//정렬 - 날짜
	public ArrayList<PartyCo> sortPartyCoCurrent(String keyword){
		Connection conn = getConnection();
		ArrayList<PartyCo> list = dao.sortPartyCoCurrent(conn, keyword);
		close(conn);
		return list;
	}

	

	
}
