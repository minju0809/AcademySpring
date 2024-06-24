package com.majustory.biz1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.majustory.biz1.BoardVo;
import com.majustory.biz1.service.BoardService;
import com.majustory.biz1.service.BoardServiceImpl;

/**
 * Servlet implementation class MajustoryController
 */
@Controller
public class MajustoryController extends HttpServlet {
	
	@Autowired
	BoardService service;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajustoryController() {
    	super();
    	System.out.println("1");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url = request.getRequestURL().toString();
		System.out.println("url: " + url);
			
			BoardVo vo = new BoardVo();
			vo.setTitle(request.getParameter("title"));
			vo.setWriter(request.getParameter("writer"));
			vo.setContent(request.getParameter("content"));
			System.out.println("2");
			BoardService service = new BoardServiceImpl();
			service.insert(vo);
			System.out.println("3");
			System.out.println("vo: " + vo);
			service.getSelect();
	}
}