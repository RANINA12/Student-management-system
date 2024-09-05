package student.mgmt.entities;

import java.sql.Date;

public class Faculty {
	private long computerCode;
	private String name;
	private Date date_Of_birth;
	private String email;
	private long mobile_no;
	private String Address;
	private String gender;
	private String branch;
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faculty(long computerCode, String name, Date date_Of_birth, String email, long mobile_no, String address,
			String gender, String branch) {
		super();
		this.computerCode = computerCode;
		this.name = name;
		this.date_Of_birth = date_Of_birth;
		this.email = email;
		this.mobile_no = mobile_no;
		Address = address;
		this.gender = gender;
		this.branch = branch;
	}
	public Faculty(String name, Date date_Of_birth, String email, long mobile_no, String address, String gender,
			String branch) {
		super();
		this.name = name;
		this.date_Of_birth = date_Of_birth;
		this.email = email;
		this.mobile_no = mobile_no;
		Address = address;
		this.gender = gender;
		this.branch = branch;
	}
	public long getComputerCode() {
		return computerCode;
	}
	public void setComputerCode(long computerCode) {
		this.computerCode = computerCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate_Of_birth() {
		return date_Of_birth;
	}
	public void setDate_Of_birth(Date date_Of_birth) {
		this.date_Of_birth = date_Of_birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Faculty [computerCode=" + computerCode + ", name=" + name + ", date_Of_birth=" + date_Of_birth
				+ ", email=" + email + ", mobile_no=" + mobile_no + ", Address=" + Address + ", gender=" + gender
				+ ", branch=" + branch + "]";
	}
	
	
}
