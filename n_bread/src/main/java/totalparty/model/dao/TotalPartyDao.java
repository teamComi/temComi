package totalparty.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import totalparty.model.vo.TotalParty;

import static common.JDBCTemplate.*;
public class TotalPartyDao {

	public TotalPartyDao() {
		super();
	}
    public int createTotalPartyNum(Connection conn, int partyNum, int meNum) {
        int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into totalparty values (?,?,null,null,null,null,null,null,null,null,null)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,partyNum);
			pstmt.setInt(2,meNum);
		
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("error : createTotalPartyNum");
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
    }
    public TotalParty selcetTotalPart(Connection conn, int partyNum) {
		TotalParty result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from totalparty where pa_num = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, partyNum);
			rset = pstmt.executeQuery();
			if(rset.next()){
				result = new TotalParty();
				result.setPaNum(partyNum);
				result.setPaMem1(rset.getInt(2));
				result.setPaMem2(rset.getInt(3));
				result.setPaMem3(rset.getInt(4));
				result.setPaMem4(rset.getInt(5));
				result.setPaMem5(rset.getInt(6));
				result.setPaMem6(rset.getInt(7));
				result.setPaMem7(rset.getInt(8));
				result.setPaMem8(rset.getInt(9));
				result.setPaMem9(rset.getInt(10));
				result.setPaMem10(rset.getInt(11));
			}
		} catch (Exception e) {
			System.out.println("error : selcetTotalPart");
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
    }
}
