package polymorphism.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("t")
public class TestSample {
	
	@Autowired
	Test test;
	
	public void print() {
		System.out.println("Test Sample print");
		// test.print();
	}
}
