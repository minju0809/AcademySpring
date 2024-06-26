package com.majustory.biz.psdBoard;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PsdBoardVO {
	  private  int seq;  
	  private  int age;  
	  private  String title;  
	  private  String writer;  
	  private  String content;  
	  private  String regdate;  
	  private  MultipartFile uploadFile;  
	  private  String  uploadFileStr;  
	  private  int cnt;  
}
