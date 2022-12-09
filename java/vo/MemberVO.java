package vo;

import java.util.Date;

public class MemberVO {

	private int memberNum;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private Date writeDate;
	
	
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + ", email=" + email + ", writeDate=" + writeDate + "]";
	}
	
	
	
	
}
