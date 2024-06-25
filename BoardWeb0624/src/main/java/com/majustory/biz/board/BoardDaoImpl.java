package com.majustory.biz.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.majustory.biz.comm.JDBCUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String INSERTSQL = "insert  into board (seq, title, writer, content) "
			+ " values(1004, ?, ?, ?) "; 
	private final String SELECTSQL = "select *  from  board order by seq desc "; 
	private final String EDITSQL = "select *  from  board where  seq = ? "; 
	private final String DELETESQL = "delete from board where seq = ? ";
	private final String TOTALCOUNTSQL = "select count(*) as totalcount from board";
	
	@Override
	public void insert(BoardVO vo) {
		jdbcTemplate.update(INSERTSQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	@Override
	public List<BoardVO> select(BoardVO vo) {
		return jdbcTemplate.query(SELECTSQL, new BoardRowMapper());
	}

	@Override
	public void delete(BoardVO vo) {
		jdbcTemplate.update(DELETESQL, vo.getSeq());
		
	}

	@Override
	public BoardVO edit(BoardVO vo) {
		Object[] args = { vo.getSeq()} ;
		return jdbcTemplate.queryForObject(EDITSQL, new BoardRowMapper(), args );
	}

	@Override
	public int totalCount() {
		return jdbcTemplate.queryForObject(TOTALCOUNTSQL, new TotalCount());
	}
}




