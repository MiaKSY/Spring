package ex2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 어노테이션
@Component("dao")
public class MemberDAO {

	// 자동으로 객체 주입시키는 어노테이션
	@Autowired
	private MemberBean member;
		
	public void insert() {
		member.output();
	}

	
	// 1) setter
//	public void setMember(MemberBean member) {
//		this.member = member;
//	}
	
	// 2) constructor
//	public MemberDAO() { }
//	
//	public MemberDAO(MemberBean member) {
//		super();
//		this.member = member;
//	}
	
	
}
