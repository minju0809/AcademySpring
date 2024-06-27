package com.majustory.view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value="/psdformBoard.do")
	public  String psdformBoard() {
		System.out.println("==> psdformBoard.do ");
		return "psdBoard/form";	
	}
		
	@RequestMapping(value="/pdsEdit.do")
	public  String pdsEdit( Model  model , PsdBoardVO vo  ) {
		model.addAttribute("m",service.edit(vo));
		return "psdBoard/edit";	
	}
		
		
		
	@RequestMapping(value="/psdlistBoard.do")
	public  String psdlistBoard(Model model ) {
		model.addAttribute("li",service.select(null));
		return "psdBoard/list";	
	}
	

	@RequestMapping(value="/pdsDelete.do")
	public  String pdsDelete(Model model , PsdBoardVO vo) {
		// 삭제 1) 삭제할 파일 찾기  2) 파일 삭제   3) 레코드 삭제 
		
		// (1) 삭제 할 파일 찾기 
		PsdBoardVO  m = service.edit(vo);
		String  delFile = m.getUploadFileStr();
		String path = request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		
		// (2) 파일 삭제 
		File f = new File(path + delFile );
		if (delFile != null) {
			if (!delFile.equals("space.png")) {
			  f.delete();
			}
		}
		
		// (3) 레코드 삭제 
		service.delete(vo);
		
		return "redirect:/psdlistBoard.do";	
	}		
	
	@RequestMapping(value="/psdBoardInsert.do")
	public  String psdBoardInsert(PsdBoardVO vo, CreateName cn) throws IOException {
		
		// 자료실 처리 순서  ( 테이블 처리 / 파일처리 ) 
		// 1. Insert  --> 2. Select --> 3. Delete  --> 4. Edit  --> 5. Update
		
		String path = request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		
		System.out.println("==> path : " + path );
		MultipartFile uploadFile =vo.getUploadFile();
		String  fileName = uploadFile.getOriginalFilename();
			
		File f = new File(path+fileName);
		String img = "";
		if (!uploadFile.isEmpty()) {
			if (f.exists()) {
				int lastIndex = fileName.lastIndexOf('.');
				String extension = fileName.substring(lastIndex);
			    img = "img" + cn.k + cn.ran + extension;
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
	
	
	@RequestMapping(value="/psdUpdate.do")
	public  String psdUpdate(PsdBoardVO vo ) throws IOException {
		
		String path = request.getSession().getServletContext().getRealPath("/psdBoard/files/");
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		String k = sdf.format(now);
	
		int ran=(int)(Math.random()*100)+101 ;
		
		System.out.println("==> path : " + path );
		MultipartFile uploadFile =vo.getUploadFile();
		String  fileName = uploadFile.getOriginalFilename();

		/*
		 1. 파일 첨부가 있냐 없냐 ???
		 1-1. 파일 첨부가 있으면 
		    1-1-1. 기존 파일을 삭제. 
		    ( space.png 가 아니라면 삭제.)
		    1-1-2. 파일을 첨부한다.
		    1-1-3. SQL의 값을 수정한다. 
		 1-2. 파일 첨부가 없으면
		    1-2-1. SQL의 값만 수정하면된다.		 
		*/ 
		
		//  1. 파일 첨부가 있냐 없냐 ???
	
		if (!fileName.equals("")) {
			System.out.println("==> 파일첨부 있음 " );	
			// 1-1-1. 기존 파일을 삭제. ( space.png 가 아니라면 삭제.)
			
			// (1) 삭제 할 파일 찾기 
			PsdBoardVO  m = service.edit(vo);
			String  delFile = m.getUploadFileStr();
						
			// (2) 파일 삭제 
			File f = new File(path + delFile );
			if (!delFile.equals("space.png")) {
			  f.delete();
			}			
			
		    // 1-1-2. 파일을 첨부한다.			
			File ff = new File(path+fileName);
			String img = "";
			    // 중복 파일 체크 
				if (ff.exists()) {
					int lastIndex = fileName.lastIndexOf('.');
					String extension = fileName.substring(lastIndex);
				    img = "img" + k + ran + extension;
				} else {
				   img = fileName;
				}				
				uploadFile.transferTo(new File(path + img));
					    
			// 1-1-3. SQL의 값을 수정한다.
			vo.setUploadFileStr(img);	
			service.UPDATEFILEINSQL(vo);
		}else {
			System.out.println("==> 파일첨부 없음 " );	
			service.UPDATEFILENOTSQL(vo)	;
		}
		
		return "redirect:/psdlistBoard.do";	
	}	
}
