package com.majustory.biz1.client;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.majustory.biz1.BoardVo;
import com.majustory.biz1.service.BoardService;

public class InsertClient {
	public static void main(String[] args) {
		GenericXmlApplicationContext contationer =
				new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) contationer.getBean("service");
		
		BoardVo vo = new BoardVo();
		vo.setTitle("연습12");
		vo.setWriter("영심이");
		vo.setContent("스프링연습");
		boardService.insert(vo);
		
		List<BoardVo> li = boardService.getSelect();
//		for(int i = 0; i < li.size(); i++) {
//			System.out.println(li.get(i));
//		}
	}
}
