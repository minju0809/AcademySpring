package polymorphism.test;

import org.springframework.stereotype.Component;

@Component
public class TestA implements Test {
	TestA() {
		System.out.println("TestA");
	}

	@Override
	public void print() {
		System.out.println("TestA print");
	}
}