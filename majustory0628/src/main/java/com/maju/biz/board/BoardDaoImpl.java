package com.maju.biz.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.maju.biz.golf.rowmapper.BoardRowMapper;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private JdbcTemplate  jdbcTemplate;  
	
	final String BoardInsert = "insert into Board (seq, title, writer,content) "
			+ " values (idx.nextval, ?, ?, ? )  " ;
	final String BoardUpdate = "update Board set  title =? , writer = ?,content= ? where seq = ? " ;
	final String BoardDelete = "delete from  Board where seq =? " ;
	
	final String BoardSelectOne = "select  *  from  Board  where seq = ?  " ;
	final String BoardSelectALL = "select  *  from  Board  order by  seq  desc " ;
	final String BoardSelectTITLE = "select  *  from  Board where title like ? order by  seq  desc " ;
	final String BoardSelectWRITER = "select  *  from  Board where writer like ?  order by  seq  desc " ;
	
	
	@Override
	public void insert(BoardVO vo) {
		Object [] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BoardInsert, args);
		
	}

	@Override
	public void update(BoardVO vo) {
		Object [] args = {vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq()};
		jdbcTemplate.update(BoardUpdate, args);
		
	}

	@Override
	public void delete(BoardVO vo) {
		Object [] args = { vo.getSeq() };
		jdbcTemplate.update(BoardDelete, args);		
	}

	@Override
	public HashMap<String, Object> getSelectOne(BoardVO vo) {		
		return jdbcTemplate.queryForObject(BoardSelectOne, new BoardRowMapper() , vo.getSeq());
	}

	@Override
	public List<HashMap<String, Object>> getSelectAll(String ch1, String Ch2) {
		Object [] args = { "%"+Ch2+"%" };
		if (ch1.equals("title")) {			
			return jdbcTemplate.query(BoardSelectTITLE, new BoardRowMapper(), args);
		} else if (ch1.equals("writer")) {
			return jdbcTemplate.query(BoardSelectWRITER, new BoardRowMapper(), args );
		} else {
			return jdbcTemplate.query(BoardSelectALL, new BoardRowMapper());
		}		
	}

}
