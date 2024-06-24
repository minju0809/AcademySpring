package com.majustory.biz.comm;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	LogAdvice() {
		System.out.println("LogAdvice 생성자 확인");
	}
	
	@Pointcut("execution(* com.majustory.biz.board..*ServiceImpl.*(..))")
	public void allPointcut() {
		
	}
	
	@Before("allPointcut()")
	public void beforeLog() {
		System.out.println("beforeLog");
	}
	
	@After("allPointcut()")
	public void afterLog() {
		System.out.println("afterLog");
	}
}
