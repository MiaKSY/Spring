package ex1_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		//----------------------------------
		// 0. POJO (자바클래스. 자바코드)		
//		MessageBean bean1 = new MessageBeanKoImpl();
//		bean1.sayHello("홍길동");
//		
//		MessageBean bean2 = new MessageBeanEnImpl();
//		bean2.sayHello("John");
		//----------------------------------
		
		//**********************************
		// 1. DI
		// 개발자가 객체를 생성하지 않는다.
		// 객체생성, 메모리 관리를 스프링이 한다.
		// (applicationContext.xml 파일을 만들고 와서)
		// xml을 읽어 불러들이는 순간, 생성자가 만들어진다. 객체 딱 하나만 만들어진다.
		// scope의 디폴트는 싱글톤이다.  scope='singleton'  scope='prototype'
		//**********************************
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml1/applicationContext.xml");
		
		System.out.println("-------start b1------");
		MessageBean b1 = (MessageBean)context.getBean("ko");
		b1.sayHello("홍길자");
		
		System.out.println("-------start b12------");
		MessageBean b12 = context.getBean("ko", MessageBean.class);
		b12.sayHello("홍길자2");		
		
		System.out.println("-------start b2------");
		MessageBean b2 = context.getBean("en", MessageBean.class);
		b2.sayHello("John");
		
		System.out.println("-------start b3------");
		MessageBean b3 = context.getBean("en", MessageBean.class);
		b3.sayHello("Ann");
	}

}
