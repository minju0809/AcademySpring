package com.maju.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.maju.biz.login.LoginVO;

@Controller
@SessionAttributes("board")
public class LoginController {
	
	@GetMapping(value="login.do")
	  String login( LoginVO vo , Model model ) { 
		
	  vo.setId("ppk");	
	  vo.setPassword("1234567");	
	  
	  model.addAttribute("board", vo);		
		
	 return "login/login";		
	}
	
	@PostMapping(value="login.do")
	  String loginOK(@ModelAttribute("board") LoginVO vo ) {	
		
		System.out.println("===> POST login.do");	
		System.out.println("ID :" + vo.getId());
		System.out.println("PWD :" +vo.getPassword());
		
		
	 return "redirect:/index.jsp";		
	}
	
	
}
