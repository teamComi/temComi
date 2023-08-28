package common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.json.simple.JSONObject;

import member.model.vo.Member;
import party.model.vo.Party;
import partyCh.model.vo.PartyCh;
import partyCo.model.vo.PartyCo;

public class JsonReturn {
	public JsonReturn() {
		
	}
	
	public JSONObject returnObject(String type, Object obj) throws UnsupportedEncodingException {
		
		JSONObject json = null;
		
		switch(type) {
			case "party":
				json = returnParty((Party) obj);
				break;
			case "partyCh":
				json = returnPartyCh((PartyCh) obj);
				break;
			case "partyCo":
				json = returnPartyCo((PartyCo) obj);
				break;
			case "member":
				json = returnMember((Member) obj);
				break;
			default : 
		}
		
		return json;
	}
	
	public JSONObject returnParty(Party party) throws UnsupportedEncodingException {
		JSONObject json = new JSONObject();
		json.put("paid", party.getPaNum());
		json.put("meid", party.getMeNum());
		json.put("time", String.valueOf(party.getPaTime()));
		json.put("price", party.getPaTotalAmount());
		json.put("deposit", party.getPaDeposit());
		json.put("peoplePrice", party.getPaPerAmount());
		
		json.put("title", urlEncoderNullCheck(party.getPaTitle()));
		json.put("contents", urlEncoderNullCheck(party.getPaCon()));
		json.put("enroll", String.valueOf(party.getPaEnroll()));
		json.put("modDate", String.valueOf(party.getPaModDate()));
		json.put("delDate", String.valueOf(party.getPaDelDate()));
		json.put("act", party.getPaAct());
		json.put("views", party.getPaViews());
		json.put("likes", party.getPaLike());
		json.put("count", party.getPaComCount());
		
		json.put("genderSet", party.getPaGenderSet());
		json.put("location", urlEncoderNullCheck(party.getPaLocation()));
		json.put("totalNum", party.getPaTotalNum());
		json.put("genderLimit", party.getPaGenderLimit());
		//json.put("phNum", party.getPhNum());
		json.put("category", party.getCatNum());
		
		return json;
	}
	
	public JSONObject returnPartyCh(PartyCh partyCh) {
		JSONObject json = new JSONObject();
		
		return json;
	}
	
	public JSONObject returnPartyCo(PartyCo partyCo) {
		JSONObject json = new JSONObject();
		json.put("comNum", partyCo.getComNum());
		json.put("paNum", partyCo.getPaNum());
		json.put("comParent", partyCo.getComParent());
		json.put("comDepth", partyCo.getComDepth());
		json.put("comCon", partyCo.getComCon());
		json.put("comViews", partyCo.getComViews());
		json.put("comCount", partyCo.getComCount());
		json.put("comEnroll", partyCo.getComEnroll());
		json.put("comModDate", partyCo.getComModDate());
		json.put("comDelDate", partyCo.getComDelDate());
		json.put("comPhotoNum", partyCo.getComPhotoNum());
		
		return json;
	}
	
	public JSONObject returnMember(Member member) throws UnsupportedEncodingException {
		JSONObject json = new JSONObject();
		json.put("menum", member.getMeNum());
		json.put("name", urlEncoderNullCheck(member.getMeName()));
		json.put("id", member.getMeId());
		json.put("email", member.getMeEmail());
		json.put("phone", member.getMePhone());
		json.put("address", urlEncoderNullCheck(member.getMeAdd()));
		json.put("gender", member.getMeGender());
		json.put("birthday", String.valueOf(member.getMeBDay()));
		json.put("enroll", String.valueOf(member.getMeEnroll()));
		json.put("nickname", urlEncoderNullCheck(member.getMeAka()));
		json.put("like", member.getMeLike());
		json.put("photo", member.getMePhotoAdd());
		json.put("admin", member.getMeAdmin());
		json.put("ban", member.getMeBan());
		json.put("point", member.getMePoint());
		
		return json;
	}
	
	public JSONObject returnPaging(Paging paging) {
		JSONObject json = new JSONObject();
		json.put("startRow", paging.getStartRow());// 페이지에 출력할 시작행
		json.put("endRow", paging.getEndRow());// 페이지에 출력할 마지막행
		json.put("listCount", paging.getListCount());// 총 목록 갯수
		json.put("limit", paging.getLimit());// 한 페이지에 출력할 목록 갯수
		json.put("currentPage", paging.getCurrentPage());// 출력할 현제 페이지
		json.put("maxPage", paging.getMaxPage());// 총 페이지 수
		json.put("startPage", paging.getStartPage());// 페이지 그룹의 시작값
		json.put("endPage", paging.getEndPage());// 페이지 그룹의 끝값
		return json;
	}
	
	public String urlEncoderNullCheck(String str) throws UnsupportedEncodingException {
		
		String rstr = (str == null) ? "" : URLEncoder.encode(str, "UTF-8");
		return rstr;
	}
}
