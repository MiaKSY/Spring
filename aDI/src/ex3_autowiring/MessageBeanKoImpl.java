package ex3_autowiring;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageBeanKoImpl implements MessageBean {

	private String name;
	private String message;
	
	
	
	// @Autowired
	// @Qualifier("outputer2")
	// ▲위 2개와 아래 1개는 같다▼
	@Resource(name="outputer2")
	private Outputer out;
	// setter, constructor 없음
	
	
	
	
	
	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public void sayHello() {
	
		System.out.println(name + "님께 " + message);
		
		try {
			out.writeMessage(name + "님께 " + message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
