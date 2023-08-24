package common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
	
	public String urlEncoderNullCheck(String str) throws UnsupportedEncodingException {
		
		String rstr = (str == null) ? "" : URLEncoder.encode(str, "UTF-8");
		return rstr;
	}
}
