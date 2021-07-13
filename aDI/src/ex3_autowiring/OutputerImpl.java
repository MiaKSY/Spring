package ex3_autowiring;

import java.io.FileWriter;
import java.io.IOException;

public class OutputerImpl implements Outputer {

	String path;
	
	public void setPath(String path) {
		this.path = path;
	}
	
	
	// ▼ 자바가 읽는 어노테이션. (우리는 스프링이 읽는 어노테이션 배우는 중!)
	@Override
	public void writeMessage(String msg) throws IOException {
		FileWriter f = new FileWriter(path);
		f.write(msg);
		f.close();
	}

}
