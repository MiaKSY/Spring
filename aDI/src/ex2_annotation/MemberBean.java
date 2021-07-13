package ex2_annotation;

import org.springframework.stereotype.Component;

@Component
public class MemberBean {
	private String name;
	private int age;
	private String message;
	
	/*
	 * 멤버변수의 값을 지정하는 방법 두가지
	 * 1) setter 이용
	 * 2) 생성자 이용
	 * */
	
	//--------------------------------
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	// setter
	//--------------------------------
	
	
	
	//--------------------------------
	// 생성자 : 객체가 생성될 때 불려와서, 멤버면수 초기화
	public MemberBean() { 
		this.name = "아무개";
		this.age = 25;
		this.message = "화이팅";
	}
	
	public MemberBean(String name, int age, String message) {
		super();
		this.name = name;
		this.age = age;
		this.message = message;
	}
	// 생성자
	//--------------------------------
	

	public void output() {
		System.out.println(name + "[" + age + "]" + message);
	}



}
