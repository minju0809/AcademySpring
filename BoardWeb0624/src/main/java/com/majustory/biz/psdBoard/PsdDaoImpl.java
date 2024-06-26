package com.majustory.biz.psdBoard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PsdDaoImpl implements PsdDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String INSERTSQL = "insert  into psdboard (seq, age, title, writer, content, uploadFilestr) "
			+ " values(idx.nextval, ?, ?, ?, ?, ?) "; 
	
	private final String SELECTSQL = "select *  from  psdboard order  by  seq desc  "; 
	
	private final String EDITSQL = "select *  from  psdboard where seq = ? ";
	
	private final String DELETESQL = "delete from  psdboard where seq = ? ";
	
	@Override
	public void insert(PsdBoardVO vo) {
		Object []  args = {vo.getAge(), vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getUploadFileStr()} ; 
		jdbcTemplate.update(INSERTSQL, args);
	}

	@Override
	public List<PsdBoardVO> select(PsdBoardVO vo) {
		return jdbcTemplate.query(SELECTSQL, new PsdBoardRowMapper());
	}

	@Override
	public PsdBoardVO edit(PsdBoardVO vo) {
		Object[] args = { vo.getSeq()} ;
		return jdbcTemplate.queryForObject(EDITSQL, new PsdBoardRowMapper(), args );
	}

	@Override
	public void delete(PsdBoardVO vo) {
		jdbcTemplate.update(DELETESQL, vo.getSeq());
	}

}

class PsdBoardRowMapper implements RowMapper<PsdBoardVO>{

	@Override
	public PsdBoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PsdBoardVO	board = new PsdBoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegdate(rs.getString("regdate"));
		board.setAge(rs.getInt("age"));
		board.setUploadFileStr(rs.getString("uploadFileStr"));
		
		board.setCnt(rs.getInt("cnt"));
		return board;
	}
	
}
