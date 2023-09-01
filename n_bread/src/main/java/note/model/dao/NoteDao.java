package note.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import note.model.vo.Note;
import static common.JDBCTemplate.*;
public class NoteDao {

	public Note selectMessage(Connection conn, int messageid) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Note> selectMessageAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertMessage(Connection conn, Note message) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into note values (?,?,?,sysdate,default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, message.getNoNum());
			pstmt.setInt(2, message.getMeNum());
			pstmt.setString(3, message.getNoCon());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}

	public int updateMessage(Connection conn, Note message) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteMessage(Connection conn, Note message) {
		// TODO Auto-generated method stub
		return 0;
	}

}
