package qna.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import qna.model.vo.Qna;

public class QnaDao {
	public QnaDao() {}
	
	public Qna selectQna(Connection conn, int partyid) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Qna> selectQnaAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertPartyCo(Connection conn, Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertQna(Connection conn, Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateQna(Connection conn, Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteQna(Connection conn, int qnaNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from qa ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNum);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int loadQna(Connection conn, Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Qna> searchQna(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		//sql 가서 QNA 테이블에서 전체 복사해오기
		String query = "";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Qna> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Qna> list = new ArrayList<Qna>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "";
			//쿼리문 미작성
		try {
			//try문 미작성
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	public int insertOriginQa(Connection conn, Qna qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int addReadCount(Connection conn, int qnaNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "";
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Qna> selectTop3(Connection conn) {
		ArrayList<Qna> list = new ArrayList<Qna>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	
}
