package party.model.vo;

import java.io.Serializable;

//(vo, dto, do, entity, bean) 반드시 직렬화
//모든 필드 private
//to String 오버라이딩
public class Party implements Serializable{

	private static final long serialVersionUID = -6359098139311809216L;
	private int partyId;//파티 아이디
	private int partyHostId;//파티장 아이디
	private String partyTitle;//게시글 제목
	private int partyTime;//모임 시간
	private int priceAll;//총금액
	private int deposit;//거치금
	private int pricePeople;//1인당금액
	private int partyMemberId;//파티 멤버 아이디
	
	private String partyContent;//게시글 내용
	private int certifyId;//인증 테이블 번호
	
	public Party() {
		
	}
	
	
	
	
	
	
	
}
