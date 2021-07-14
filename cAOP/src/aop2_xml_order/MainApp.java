package aop2_xml_order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aop2_xml_order/applicationContext.xml");

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
