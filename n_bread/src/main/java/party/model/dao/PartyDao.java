package party.model.dao;


import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import party.model.vo.Party;

public class PartyDao {
	
	public PartyDao() {}
	
	//조회
	public Party selectParty(Connection conn, int partyid) {
		
		Party party = null;
		PreparedStatement ptst = null;
		ResultSet rset = null;
		
		try {
			
			String query = "select * from party where pa_num=?";
			ptst = conn.prepareStatement(query);
			ptst.setInt(1, partyid);
			
			rset = ptst.executeQuery();
			
			if(rset.next()) {
				party = makeParty(rset);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ptst);
			close(rset);
		}
		
		return party;
	}
	
	//전체 조회
	public ArrayList<Party> selectPartyAll(Connection conn, String type, int start, int end) {
		ArrayList<Party> partyList = new ArrayList<Party>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, PA_NUM, ME_NUM, PA_TIME, PA_TOTAL_AMOUNT, "
				+ "           PA_DEPOSIT, PA_PER_AMOUNT, PA_TITLE, PA_CON, PA_ENROLL, "
				+ "           PA_MOD_DATE, PA_DEL_DATE, PA_ACT, PA_VIEWS, PA_LIKE, "
				+ "           PA_COM_COUNT, PA_GENDER_SET, PA_LOCATION, PA_TOTAL_NUM, "
				+ "           PA_GENDER_LIMIT, PH_NUM, CAT_NUM "
				+ "     from (select * from party where PA_ACT = ?"
				+ "           order by PA_ENROLL desc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, (type == "open") ? "Y" : "N");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Party party = makeParty(rset);
				//System.out.println("party : " + party);
				partyList.add(party);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return partyList;
	}
	
	//리스트 조회(나만 빼고)
	public ArrayList<Party> selectPartyList(Connection conn, String type, int start, int end, String panum) {
		ArrayList<Party> partyList = new ArrayList<Party>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, PA_NUM, ME_NUM, PA_TIME, PA_TOTAL_AMOUNT, "
				+ "           PA_DEPOSIT, PA_PER_AMOUNT, PA_TITLE, PA_CON, PA_ENROLL, "
				+ "           PA_MOD_DATE, PA_DEL_DATE, PA_ACT, PA_VIEWS, PA_LIKE, "
				+ "           PA_COM_COUNT, PA_GENDER_SET, PA_LOCATION, PA_TOTAL_NUM, "
				+ "           PA_GENDER_LIMIT, PH_NUM, CAT_NUM "
				+ "     from (select * from party where PA_ACT = ? and PA_NUM != ? "
				+ "           order by PA_ENROLL desc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setString(2, panum);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Party party = makeParty(rset);
				//System.out.println("party : " + party);
				partyList.add(party);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return partyList;
	}
	
	//삽입
	public int insertParty(Connection conn, Party party) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into party " + 
				"values ((select count(*) from party)+1,2,sysdate,?,?,?,?,?,default,NULL,NULL,default,default, " +
				"        default,default,default,?,?,default,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,party.getPaTotalAmount());
			pstmt.setInt(2, party.getPaDeposit());
			pstmt.setInt(3, party.getPaPerAmount());
			pstmt.setString(4, party.getPaTitle());
			pstmt.setString(5, party.getPaCon());
			pstmt.setString(6,party.getPaLocation());
			pstmt.setInt(7, party.getPaTotalNum());
			pstmt.setInt(8, party.getPhNum());
			if(party.getCatNum() > 0){
				pstmt.setInt(9, party.getCatNum());
			}else{
				pstmt.setString(9, null);
			}
			result = pstmt.executeUpdate();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	//수정
	public int updateParty(Connection conn, Party party) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update party "
				+ "set PA_TIME = ?, PA_TOTAL_AMOUNT = ?, PA_DEPOSIT = ?, PA_TITLE = ?, "
				+ "PA_CON = ?, PA_MOD_DATE = sysdate, PA_GENDER_SET = ?, "
				+ "PA_GENDER_LIMIT = ?, PA_LOCATION = ?, PA_TOTAL_NUM = ?, CAT_NUM = ? "
				+ "where pa_num = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, party.getPaTime());//시간
			pstmt.setInt(2, party.getPaTotalAmount());//총금액
			pstmt.setInt(3, party.getPaDeposit());//예치금
			
			pstmt.setString(4, party.getPaTitle());//제목
			pstmt.setString(5, party.getPaCon());//내용
			
			pstmt.setString(6, party.getPaGenderSet());//성별 세팅
			pstmt.setString(7, party.getPaGenderLimit());//all/m/f
			pstmt.setString(8, party.getPaLocation());//all/m/f
			pstmt.setInt(9, party.getPaTotalNum());//전체 인원
			pstmt.setInt(10, party.getCatNum());//카테고리
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//삭제
	public int deleteParty(Connection conn, Party party) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from party "
				+ "set PA_TIME = ?, PA_TOTAL_AMOUNT = ?, PA_DEPOSIT = ?, PA_TITLE = ?, "
				+ "PA_CON = ?, PA_MOD_DATE = sysdate, PA_GENDER_SET = ?, "
				+ "PA_GENDER_LIMIT = ?, PA_LOCATION = ?, PA_TOTAL_NUM = ?, CAT_NUM = ? "
				+ "where pa_num = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, party.getPaTime());//시간
			pstmt.setInt(2, party.getPaTotalAmount());//총금액
			pstmt.setInt(3, party.getPaDeposit());//예치금
			
			pstmt.setString(4, party.getPaTitle());//제목
			pstmt.setString(5, party.getPaCon());//내용
			
			pstmt.setString(6, party.getPaGenderSet());//성별 세팅
			pstmt.setString(7, party.getPaGenderLimit());//all/m/f
			pstmt.setString(8, party.getPaLocation());//all/m/f
			pstmt.setInt(9, party.getPaTotalNum());//전체 인원
			pstmt.setInt(10, party.getCatNum());//카테고리
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//첨부파일 업로드
	public int loadParty(Connection conn, Party party) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//검색
	public ArrayList<Party> searchParty(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//정렬 - 관심사
	public ArrayList<Party> searchPartyInterest(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//정렬 - 카테고리
	public ArrayList<Party> sortPartyCategory(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//정렬 - 날짜
	public ArrayList<Party> sortPartyCurrent(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Party makeParty(ResultSet rset) throws SQLException {
		Party party = new Party(
				rset.getInt("PA_NUM")
				,rset.getInt("ME_NUM")
				,rset.getDate("PA_TIME")
				,rset.getInt("PA_TOTAL_AMOUNT")
				,rset.getInt("PA_DEPOSIT")
				,rset.getInt("PA_PER_AMOUNT")
				,rset.getString("PA_TITLE")
				,rset.getString("PA_CON")
				,rset.getDate("PA_ENROLL")
				,rset.getDate("PA_MOD_DATE")
				,rset.getDate("PA_DEL_DATE")
				,rset.getString("PA_ACT")
				,rset.getInt("PA_VIEWS")
				,rset.getInt("PA_LIKE")
				,rset.getInt("PA_COM_COUNT")
				,rset.getString("PA_GENDER_SET")
				,rset.getString("PA_LOCATION")
				,rset.getInt("PA_TOTAL_NUM")
				,rset.getString("PA_GENDER_LIMIT")
				,rset.getInt("PH_NUM")
				,rset.getInt("CAT_NUM")
		);
		
		return party;
	}

	public String getNowPartyNum(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String nowPartyNum = null;
		String query = "select count(*) from party";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				nowPartyNum = rset.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(stmt);
		}
		return nowPartyNum;
	}
	
	
}
