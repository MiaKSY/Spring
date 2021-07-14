package aop2_xml_order;

import org.aspectj.lang.JoinPoint;

public class SecuritySample {

	public void before(JoinPoint p) {
		System.out.println("[before] 메소드 호출 전 : " + p);
	}
	public void after(JoinPoint p) {
		System.out.println("[after] 메소드 호출 후 : " + p);
	}

}
