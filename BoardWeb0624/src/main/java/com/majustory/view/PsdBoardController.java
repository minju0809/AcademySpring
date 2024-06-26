package com.majustory.view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.majustory.biz.psdBoard.PsdBoardVO;
import com.majustory.biz.psdBoard.PsdService;


@Controller
public class PsdBoardController {
	
	@Autowired
	HttpServletRequest  request ;
	
	@Autowired
	PsdService  service;
	
	PsdBoardController(){
		System.out.println("===>PsdBoardController 생성자  ");
	}
	
	@RequestMapping(value="/psdformBoard.do")
	public  String psdformBoard() {
		System.out.println("==> psdformBoard.do ");
		return "psdBoard/form";	
	}
		
	@RequestMapping(value="/psdBoardInsert.do")
	public  String psdBoardInsert(PsdBoardVO vo) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		String k = sdf.format(now);
	
		int ran=(int)(Math.random()*100)+101 ;
		
		System.out.println("==> path : " + path );
		MultipartFile uploadFile =vo.getUploadFile();
		String  fileName = uploadFile.getOriginalFilename();
			
		File f = new File(path+fileName);
		String img = "";
		if (!uploadFile.isEmpty()) {
			if (f.exists()) {
				int lastIndex = fileName.lastIndexOf('.');
				String extension = fileName.substring(lastIndex);
			    img = "img" + k + ran + extension;
			} else {
			   img = fileName;
			}
			
			uploadFile.transferTo(new File(path + img));
			
		} else {
			 img = "space.png";
		}
		        
		vo.setUploadFileStr(img);
		service.insert(vo);
		
		return "redirect:/psdlistBoard.do";	
	}
	
	@RequestMapping(value="/psdlistBoard.do")
	public  String psdlistBoard(Model model ) {
		model.addAttribute("li",service.select(null));
		return "psdBoard/list";	
	}
	
	
	@RequestMapping(value="/psdEdit.do")
	public  String psdEdit(PsdBoardVO vo, Model model) {
		model.addAttribute("m", service.edit(vo));
		System.out.println("==> psdEdit.do " + service.edit(vo));
		return "psdBoard/edit";	
	}
	
	@RequestMapping(value="/psdDelete.do")
	public  String psdDelete(PsdBoardVO vo, Model model) {
		PsdBoardVO m = service.edit(vo);
		String delFile = m.getUploadFileStr();
		String path = request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		File f = new File(path + delFile);
		if(!delFile.equals("sqace.png")) {
			f.delete();
		}
		
		service.delete(vo);
		
		return "redirect:/psdlistBoard.do";	
	}
}
