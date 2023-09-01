package totalparty.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;

import totalparty.model.dao.TotalPartyDao;
import totalparty.model.vo.TotalParty;

public class TotalPartyService {
	private TotalPartyDao dao = new TotalPartyDao();
	
    public TotalPartyService() {
		super();
	}
    
    public int createTotalPartyNum(int partyNum, int meNum) {
        Connection conn = getConnection();
		int result = dao.createTotalPartyNum(conn,partyNum,meNum);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
    }

    public TotalParty selcetTotalPart(int partyNum) {
        Connection conn = getConnection();
		TotalParty result = dao.selcetTotalPart(conn,partyNum);
		return result;
    }
}
