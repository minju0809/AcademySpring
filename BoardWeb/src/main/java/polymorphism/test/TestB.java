package polymorphism.test;

import org.springframework.stereotype.Component;

// @Component
public class TestB implements Test {
	TestB() {
		System.out.println("TestB");
	}

	@Override
	public void print() {
		System.out.println("TestB print");
	}
}
