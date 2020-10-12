package Bean;

import java.util.Date;

public class Client {
	
	private int id;             // 在数据库中的ID
    private int cno;      // 
    private String name;        // 姓名
    private String con;		//联系人
    private String address;
    private String tel;
    private String sex; 
    private String pwd;
    private String img;
   // private String sort;
    private String remark;
    private String power;
    public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String add) {
		this.address = add;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	

}
