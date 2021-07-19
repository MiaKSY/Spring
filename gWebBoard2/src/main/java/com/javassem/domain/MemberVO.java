package com.javassem.domain;

public class MemberVO {
	
	
	/*
	Lombok ( VO에서 getter, setter 안 쓰려고 쓰는 어노테이션@ )
	*/
	
	private String userId;
	private String userPass;
	private String userName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName =userName;
	}
	
	
}
