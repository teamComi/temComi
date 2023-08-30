package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao() {}
	
	//로그인한 회원 조회
	public Member selectLogin(Connection conn, int userid, String userpwd) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where me_num = ? and me_pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, userid);
			pstmt.setString(2, userpwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}
	
	//회원 조회
	public Member selectMember(Connection conn, int userid) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where me_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userid);			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member(
						rset.getInt("ME_NUM")
						,rset.getString("ME_NAME")
						,rset.getString("ME_ID")
						,rset.getString("ME_PWD")
						,rset.getInt("ME_C_PWD")
						,rset.getString("ME_CER")
						,rset.getString("ME_LOGIN_TYPE")
						,rset.getString("ME_EMAIL")
						,rset.getString("ME_PHONE")
						,rset.getString("ME_ADD")
						,rset.getString("ME_GENDER")
						,rset.getDate("ME_B_DAY")
						,rset.getDate("ME_ENROLL")
						,rset.getString("ME_AKA")
						,rset.getInt("ME_LIKE")
						,rset.getString("ME_PHOTO_ADD")
						,rset.getString("ME_ADMIN")
						,rset.getString("ME_BAN")
						,rset.getInt("ME_POINT")
						,rset.getDate("ME_MOD_DATE")
						,rset.getInt("CAT_NUM")
					);
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}
	
	//회원 전체 조회
	public ArrayList<Member> selectList(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//회원 삽입
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into member "
				+ "values ((select count(*)+1 from member), ?, ?, ?, default, "
				+ "            default, default, ?, ?, default, "
				+ "            ?, ?, default, default, default, "
				+ "            default, default, default, default, default, null)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMeName());
			pstmt.setString(2, member.getMeId());
			pstmt.setString(3, member.getMePwd());
			pstmt.setString(4, member.getMeEmail());
			pstmt.setString(5, member.getMePhone());
			pstmt.setString(6, member.getMeGender());
			pstmt.setDate(7, member.getMeBDay());
			//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//회원 수정
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update member set ne_age = ?, ne_phone = ?, ne_email = ?, "
				+ "lastmodified = default where ne_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);			
			
			//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//회원 삭제
	public int deleteMember(Connection conn, int userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from member where me_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userid);
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//검색 - 아이디
	public ArrayList<Member> selectSearchUserid(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//검색할 userid 에 대해 키워드 값이 유사한 형태의 값들을 선택
		String query = "select * from member where me_admin = 'N' and me_num like ?";  //'%'||?||'%' : 에러
		
		try {
			pstmt = conn.prepareStatement(query);	
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//검색 - 성별
	public ArrayList<Member> selectSearchGender(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String query = "select * from member where me_admin = 'N' and me_gender = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//검색 - 연령대
	public ArrayList<Member> selectSearchAge(Connection conn, int keyword) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String query = "select * from member where me_admin = 'N' and ";
		
		if(keyword == 60) {
			query += " age >= ?";
		}else {
			query += " age between ? and ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);	
			
			if(keyword == 60) {
				pstmt.setInt(1, keyword);
			}else {
				pstmt.setInt(1, keyword);
				pstmt.setInt(2, keyword + 9);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//검색 - 가입 날짜
	public ArrayList<Member> selectSearchEnrollDate(Connection conn, Date begin, Date end) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String query = "select * from member where me_admin = 'N' and me_enroll between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, begin);
			pstmt.setDate(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//로그인
	public Member selectLogin(Connection conn, String meId, String mePwd) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where me_id = ? and me_pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, meId);
			pstmt.setString(2, mePwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				
				member.setMeId(meId);
				member.setMePwd(mePwd);
				member.setMeNum(rset.getInt("me_num"));
				member.setMeName(rset.getString("me_name"));
				member.setMeCPwd(rset.getInt("me_c_pwd"));
				member.setMeCer(rset.getString("me_cer"));
				member.setMeLoginType(rset.getString("me_login_type"));
				member.setMeEmail(rset.getString("me_email"));
				member.setMePhone(rset.getString("me_phone"));
				member.setMeAdd(rset.getString("me_add"));
				member.setMeGender(rset.getString("me_gender"));
				member.setMeBDay(rset.getDate("me_b_day"));
				member.setMeEnroll(rset.getDate("me_enroll"));
				member.setMeAka(rset.getString("me_aka"));
				member.setMeLike(rset.getInt("me_like"));
				member.setMePhotoAdd(rset.getString("me_photo_add"));
				member.setMeAdmin(rset.getString("me_admin"));
				member.setMeBan(rset.getString("me_ban"));
				member.setMePoint(rset.getInt("me_point"));
				member.setMeModDate(rset.getDate("me_mod_date"));
				member.setCatNum(rset.getInt("cat_num"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}
	
}
