package DTO;

import java.sql.*;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String sex;
	private String phone;
	private int type;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String id, String pw, String name, String sex, String phone, int type) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public MemberDTO setId(String id) {
		this.id = id;
		return this;
	}
	public String getPw() {
		return pw;
	}
	public MemberDTO setPw(String pw) {
		this.pw = pw;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getSex() {
		return sex;
	}
	public MemberDTO setSex(String sex) {
		this.sex = sex;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public MemberDTO setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public int getType() {
		return type;
	}
	public MemberDTO setType(int type) {
		this.type = type;
		return this;
	}
	
	public String toString() {
		return " ID : " + id + " / 성별 : " + sex + "\n 이름 : " + name +
				" / 전화번호 : " + phone;
	}
}