package member.model.vo;

public class Member implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8714310883390003772L;
	//    ME_NUM	NUMBER
    private int meNum;
    //    ME_NAME	VARCHAR2(20 BYTE)
    private String meName;
    //    ME_ID	VARCHAR2(15 BYTE)
    private String meId;
    //    ME_PWD	VARCHAR2(20 BYTE)
    private String mePwd;
    //    ME_C_PWD	NUMBER
    private int meCPwd;
    //    ME_CER	CHAR(1 BYTE)
    private String meCer;
    //    ME_LOGIN_TYPE	CHAR(1 BYTE)
    private String meLoginType;
    //    ME_EMAIL	VARCHAR2(40 BYTE)
    private String meEmail;
    //    ME_PHONE	CHAR(13 BYTE)
    private String mePhone;
    //    ME_ADD	VARCHAR2(80 BYTE)
    private String meAdd;
    //    ME_GENDER	CHAR(1 BYTE)
    private String meGender;
    //    ME_B_DAY	DATE
    private java.sql.Date meBDay;
    //    ME_ENROLL	DATE
    private java.sql.Date meEnroll;
    //    ME_AKA	VARCHAR2(15 BYTE)
    private String meAka;
    //    ME_LIKE	NUMBER
    private int meLike;
    //    ME_PHOTO_ADD	VARCHAR2(100 BYTE)
    private String mePhotoAdd;
    //    ME_ADMIN	CHAR(1 BYTE)
    private String meAdmin;
    //    ME_BAN	CHAR(1 BYTE)
    private String meBan;
    //    ME_POINT	NUMBER
    private int mePoint;
    //    ME_FIR_CATEGORY	VARCHAR2(20 BYTE)
    private String meFirCategory;
    //    ME_SEC_CATEGORY	VARCHAR2(20 BYTE)
    private String meSecCategory;

    public Member() {
    }

    public Member(int meNum, String meName, String meId, String mePwd, int meCPwd, String meCer, String meLoginType, String meEmail, String mePhone, String meAdd, String meGender, java.sql.Date meBDay, java.sql.Date meEnroll, String meAka, int meLike, String mePhotoAdd, String meAdmin, String meBan, int mePoint, String meFirCategory, String meSecCategory) {
        this.meNum = meNum;
        this.meName = meName;
        this.meId = meId;
        this.mePwd = mePwd;
        this.meCPwd = meCPwd;
        this.meCer = meCer;
        this.meLoginType = meLoginType;
        this.meEmail = meEmail;
        this.mePhone = mePhone;
        this.meAdd = meAdd;
        this.meGender = meGender;
        this.meBDay = meBDay;
        this.meEnroll = meEnroll;
        this.meAka = meAka;
        this.meLike = meLike;
        this.mePhotoAdd = mePhotoAdd;
        this.meAdmin = meAdmin;
        this.meBan = meBan;
        this.mePoint = mePoint;
        this.meFirCategory = meFirCategory;
        this.meSecCategory = meSecCategory;
    }

    public int getMeNum() {
        return meNum;
    }

    public void setMeNum(int meNum) {
        this.meNum = meNum;
    }

    public String getMeName() {
        return meName;
    }

    public void setMeName(String meName) {
        this.meName = meName;
    }

    public String getMeId() {
        return meId;
    }

    public void setMeId(String meId) {
        this.meId = meId;
    }

    public String getMePwd() {
        return mePwd;
    }

    public void setMePwd(String mePwd) {
        this.mePwd = mePwd;
    }

    public int getMeCPwd() {
        return meCPwd;
    }

    public void setMeCPwd(int meCPwd) {
        this.meCPwd = meCPwd;
    }

    public String getMeCer() {
        return meCer;
    }

    public void setMeCer(String meCer) {
        this.meCer = meCer;
    }

    public String getMeLoginType() {
        return meLoginType;
    }

    public void setMeLoginType(String meLoginType) {
        this.meLoginType = meLoginType;
    }

    public String getMeEmail() {
        return meEmail;
    }

    public void setMeEmail(String meEmail) {
        this.meEmail = meEmail;
    }

    public String getMePhone() {
        return mePhone;
    }

    public void setMePhone(String mePhone) {
        this.mePhone = mePhone;
    }

    public String getMeAdd() {
        return meAdd;
    }

    public void setMeAdd(String meAdd) {
        this.meAdd = meAdd;
    }

    public String getMeGender() {
        return meGender;
    }

    public void setMeGender(String meGender) {
        this.meGender = meGender;
    }

    public java.sql.Date getMeBDay() {
        return meBDay;
    }

    public void setMeBDay(java.sql.Date meBDay) {
        this.meBDay = meBDay;
    }

    public java.sql.Date getMeEnroll() {
        return meEnroll;
    }

    public void setMeEnroll(java.sql.Date meEnroll) {
        this.meEnroll = meEnroll;
    }

    public String getMeAka() {
        return meAka;
    }

    public void setMeAka(String meAka) {
        this.meAka = meAka;
    }

    public int getMeLike() {
        return meLike;
    }

    public void setMeLike(int meLike) {
        this.meLike = meLike;
    }

    public String getMePhotoAdd() {
        return mePhotoAdd;
    }

    public void setMePhotoAdd(String mePhotoAdd) {
        this.mePhotoAdd = mePhotoAdd;
    }

    public String getMeAdmin() {
        return meAdmin;
    }

    public void setMeAdmin(String meAdmin) {
        this.meAdmin = meAdmin;
    }

    public String getMeBan() {
        return meBan;
    }

    public void setMeBan(String meBan) {
        this.meBan = meBan;
    }

    public int getMePoint() {
        return mePoint;
    }

    public void setMePoint(int mePoint) {
        this.mePoint = mePoint;
    }

    public String getMeFirCategory() {
        return meFirCategory;
    }

    public void setMeFirCategory(String meFirCategory) {
        this.meFirCategory = meFirCategory;
    }

    public String getMeSecCategory() {
        return meSecCategory;
    }

    public void setMeSecCategory(String meSecCategory) {
        this.meSecCategory = meSecCategory;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Member{" +
                "meNum=" + meNum +
                ", meName='" + meName + '\'' +
                ", meId='" + meId + '\'' +
                ", mePwd='" + mePwd + '\'' +
                ", meCPwd=" + meCPwd +
                ", meCer='" + meCer + '\'' +
                ", meLoginType='" + meLoginType + '\'' +
                ", meEmail='" + meEmail + '\'' +
                ", mePhone='" + mePhone + '\'' +
                ", meAdd='" + meAdd + '\'' +
                ", meGender='" + meGender + '\'' +
                ", meBDay=" + meBDay +
                ", meEnroll=" + meEnroll +
                ", meAka='" + meAka + '\'' +
                ", meLike=" + meLike +
                ", mePhotoAdd='" + mePhotoAdd + '\'' +
                ", meAdmin='" + meAdmin + '\'' +
                ", meBan='" + meBan + '\'' +
                ", mePoint=" + mePoint +
                ", meFirCategory='" + meFirCategory + '\'' +
                ", meSecCategory='" + meSecCategory + '\'' +
                '}';
    }
}
