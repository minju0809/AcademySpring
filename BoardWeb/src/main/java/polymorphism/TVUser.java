package polymorphism;

import org.springframework.context.support.GenericXmlApplicationContext;

import polymorphism.test.TestSample;

public class TVUser {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
//		TestSample test = new TestSample();
//		test.print();
		
		TestSample t = (TestSample) factory.getBean("t");
		t.print();
		
		factory.close();
	}

}
