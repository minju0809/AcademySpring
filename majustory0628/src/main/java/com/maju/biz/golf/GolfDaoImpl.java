package com.maju.biz.golf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.maju.biz.golf.rowmapper.MemberRowMapper;
import com.maju.biz.golf.rowmapper.TeacherMoneyRowMapper;
import com.maju.biz.golf.rowmapper.TeacherRowMapper;
import com.maju.biz.golf.vo.ClassVO;
import com.maju.biz.golf.vo.MemberVO;
import com.maju.biz.golf.vo.MoneyVO;
import com.maju.biz.golf.vo.TeacherVO;

@Repository
public class GolfDaoImpl implements GolfDao  {
	public GolfDaoImpl(){
		System.out.println("===> GolfDaoImpl 생성자 확인 ");
	}
	
	@Autowired
	private JdbcTemplate  jdbcTemplate;  
	
	final String TeacherList = "select  *  from  TBL_TEACHER_202201  order by  TEACHER_CODE " ;
	
	final String MemberList ="select  REGIST_MONTH, M.C_NO as C_NO, C_NAME,"
			+ "          CLASS_NAME, CLASS_AREA, TUITION ,GRADE "
			+ " from TBL_MEMBER_202201 M join TBL_CLASS_202201 C "
			+ " on M.C_NO = C.C_NO join TBL_TEACHER_202201 T "
			+ " on T.TEACHER_CODE = C.TEACHER_CODE order  by REGIST_MONTH desc ";
	
	final String TeacherMoney = " select  T.TEACHER_CODE as T1 ,CLASS_NAME as T2 ,"
			+ "   TEACHER_NAME as T3, sum(TUITION) as T4 "
			+ " from TBL_MEMBER_202201 M join TBL_CLASS_202201 C "
			+ " on M.C_NO = C.C_NO join TBL_TEACHER_202201 T "
			+ " on T.TEACHER_CODE = C.TEACHER_CODE "
			+ " group  by T.TEACHER_CODE,CLASS_NAME,TEACHER_NAME "
			+ " order  by  T.TEACHER_CODE ";
	
	final String EnrolMent ="INSERT INTO TBL_CLASS_202201 "
			+ " (REGIST_MONTH, C_NO,CLASS_AREA,TUITION,TEACHER_CODE) "
			+ " VALUES(?,?, ?, ?, ?)" ;
	
	@Override
	public List<TeacherVO> TeacherList() {		
		return jdbcTemplate.query(TeacherList, new TeacherRowMapper());
	}

	@Override
	public List<MemberVO> memberList() {		
		return jdbcTemplate.query(MemberList, new MemberRowMapper());
	}

	@Override
	public List<MoneyVO> teacherMoney() {		
		return jdbcTemplate.query(TeacherMoney, new TeacherMoneyRowMapper());
	}

	@Override
	public void enrolMent(ClassVO vo) {
		
		Object [] args = {vo.getREGIST_MONTH(), vo.getC_NO(),vo.getCLASS_AREA(),vo.getTUITION(),vo.getTEACHER_CODE()};
		jdbcTemplate.update(EnrolMent, args);
		
	}

}
