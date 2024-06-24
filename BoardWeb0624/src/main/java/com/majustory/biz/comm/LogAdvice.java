package com.majustory.biz.comm;

public class LogAdvice {
	LogAdvice() {
		System.out.println("LogAdvice 생성자 확인");
	}
	
	public void beforeLog() {
		System.out.println("beforeLog");
	}
	
	public void afterLog() {
		System.out.println("afterLog");
	}
}
