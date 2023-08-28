package partyCo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import partyCo.model.vo.PartyCo;

public class PartyCoDao {

	public PartyCo selectPartyCo(Connection conn, int panum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getListCount(Connection conn) {
		
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from comments";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) listCount = rset.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listCount;
	}
	
	public ArrayList<PartyCo> selectPartyCoAll(Connection conn, int panum) {
		ArrayList<PartyCo> list = new ArrayList<PartyCo>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query = "select * "
					+ "from (select rownum rnum, board_num, board_writer, board_title, board_content, "
					+ "           board_original_filename, board_rename_filename, board_ref, "
					+ "           board_reply_ref, board_lev, board_reply_seq, board_readcount, board_date "
					+ "     from (select * from board "
					+ "           order by board_ref desc, board_reply_ref desc, board_lev asc, board_reply_seq asc)) "
					+ "where rnum >= ? and rnum <= ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board board = new Board();
				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setBoardOriginalFileName(rset.getString("board_original_fileName"));
				board.setBoardRenameFileName(rset.getString("board_rename_fileName"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardLev(rset.getInt("board_lev"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				
				//System.out.println("board : " + board);
				list.add(board);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertPartyCo(Connection conn, PartyCo partyCo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updatePartyCo(Connection conn, PartyCo partyCo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deletePartyCo(Connection conn, PartyCo partyCo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int loadPartyCo(Connection conn, PartyCo partyCo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PartyCo> searchPartyCo(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PartyCo> searchPartyCoInterest(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PartyCo> sortPartyCoCategory(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PartyCo> sortPartyCoCurrent(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
