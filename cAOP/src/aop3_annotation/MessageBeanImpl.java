package aop3_annotation;

import org.springframework.stereotype.Component;



//이 클래스가 메모리에 너가 알아서 올라가줄래?
//이 클래스를 빈으로 생성하고 싶어
// 그런데 우리는 MainApp.java에서
// MessageBean target = context.getBean("targetBean", MessageBean.class);
// 이렇게 쓰고 싶어서
// targetBean으로 별칭 좀 넣어줄래?

@Component("targetBean")
public class MessageBeanImpl implements MessageBean {

	@Override
	public void sayHello() {
		System.out.println("sayHello() 호출");
	}

	@Override
	public void engSayHello() {
		System.out.println("engSayHello() 호출");	
	}

	@Override
	public void test() {
		System.out.println("test() 호출");	
	}

}
