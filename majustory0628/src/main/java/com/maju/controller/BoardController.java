package com.maju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maju.biz.board.BoardService;
import com.maju.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService  service;
	
	@GetMapping(value="boardForm.do")
	  String boardForm() {
	 return "board/insert";		
	}
	

	@GetMapping(value="boardInsert.do")
	  String boardInsert( BoardVO vo ) {
		
		service.insert(vo);   	
		
	 return "redirect:selectAll.do";		
	}
			
	@GetMapping(value="boardUpdate.do")
	 String boardUpdate( BoardVO vo ) {		
		service.update(vo);   			
	 return "redirect:selectAll.do";		
	}
	
	@GetMapping(value="boardDelete.do")
	  String boardDelete( BoardVO vo ) {		
		service.delete(vo);   			
	 return "redirect:selectAll.do";		
	}
	
	
	@RequestMapping(value="selectAll.do")
	  String selectAll(@RequestParam(value="searchCondition", defaultValue="title", required=false) String Condition
	                  , @RequestParam(value="searchKeyword", defaultValue="", required=false)  String Keyword 
	                   ,Model model ) { 
			  
	  model.addAttribute("li", service.getSelectAll(Condition, Keyword));		
		
	 return "board/list";		
	}
	

	@GetMapping(value="boardEdit.do")
	  String boardEdit( Model model, BoardVO vo ) { 			  
	  model.addAttribute("m", service.getSelectOne(vo));		
		
	 return "board/edit";		
	}
	
}
