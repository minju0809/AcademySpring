package com.maju.biz.golf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maju.biz.golf.vo.ClassVO;
import com.maju.biz.golf.vo.MemberVO;
import com.maju.biz.golf.vo.MoneyVO;
import com.maju.biz.golf.vo.TeacherVO;

@Service
public class GolfServiceImpl implements GolfService {
	
	@Autowired
	private  GolfDao  dao;
	
	public GolfServiceImpl(){
		System.out.println("==> GolfServiceImpl 생성자 ");
	}

	@Override
	public List<TeacherVO> TeacherList() {
		return dao.TeacherList();
	}

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public List<MoneyVO> teacherMoney() {
		return dao.teacherMoney();
	}

	@Override
	public void enrolMent(ClassVO vo) {
		dao.enrolMent(vo);		
	}

}
