package com.majustory.view;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.majustory.biz.board.BoardService;
import com.majustory.biz.board.BoardVO;
import com.majustory.biz.psdBoard.PsdBoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService  service;
	
	BoardController(){
		System.out.println("==> BoardController ");
	}
	
		
	@RequestMapping(value="/editBoard.do")
	public String  editBoard(BoardVO vo, Model model   ) {
		System.out.println("==> editBoard(BoardVO vo) ");
		model.addAttribute("m", service.edit(vo));
		return "board/edit";
	}	
		
	@RequestMapping(value="/listBoard.do")
	public String  listBoard(BoardVO vo, Model model   ) {
		System.out.println("==> listBoard(BoardVO vo) ");
		model.addAttribute("li", service.select(vo));
		model.addAttribute("map", service.totalCount());
		model.addAttribute("tc", service.totalCount2());
				
		return "board/list";
	}
	
	
	@RequestMapping(value="/formBoard.do")
	public  String formBoard() {
		System.out.println("==> formBoard.do ");
		return "board/form";	
	}
	
		
	@RequestMapping(value="/insertBoardOk.do")
	public  String insertBoardOk(BoardVO  vo) {
		System.out.println("==> insertBoardOk.d0o " + vo);
		service.insert(vo);
		return "redirect:/listBoard.do";	
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public  String deleteBoard(BoardVO  vo) {
		System.out.println("==> deleteBoard " + vo);
		service.delete(vo);
		return "redirect:/listBoard.do";	
	}
		
	
}
