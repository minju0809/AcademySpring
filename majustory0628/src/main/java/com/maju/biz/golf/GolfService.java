package com.maju.biz.golf;

import java.util.List;

import com.maju.biz.golf.vo.ClassVO;
import com.maju.biz.golf.vo.MemberVO;
import com.maju.biz.golf.vo.MoneyVO;
import com.maju.biz.golf.vo.TeacherVO;

public interface GolfService {
	List<TeacherVO> TeacherList();
	List<MemberVO>  memberList();
	List<MoneyVO>   teacherMoney();   
	   
	void  enrolMent(ClassVO vo);
}
