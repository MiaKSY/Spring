package aop3_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class MainApp {

	public static void main(String[] args) {

		// applicationContext에서 설정한 후 여기서 클래스 빈으로 가져옴
		ApplicationContext context = new ClassPathXmlApplicationContext("aop3_annotation/applicationContext.xml");

		// @Component("targetBean")으로 별칭 지정한 클래스 빈으로 가져옴
		MessageBean target = context.getBean("targetBean", MessageBean.class);

		System.out.println("-------------------------");
		target.sayHello();

		System.out.println("-------------------------");
		target.engSayHello();
		
		System.out.println("-------------------------");
		target.test();
		
		System.out.println("-------------------------");
	}

}
