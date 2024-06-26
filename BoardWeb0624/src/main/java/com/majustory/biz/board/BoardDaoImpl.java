package com.majustory.biz.board;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private final String INSERTSQL = "insert  into board (seq, title, writer, content) "
			+ " values(1114, ?, ?, ?) "; 
	
	private final String SELECTSQL = "select *  from  board order  by  seq desc  "; 
	private final String EDITSQL = "select *  from  board where  seq = ? "; 
	private final String DELETESQL = "delete from board where seq = ? ";
	
	private final String TOTALCOUNTSQL = "select count(*) totalcount  from  board  "; 
		
	@Override
	public void insert(BoardVO vo) {
		
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
		  System.out.println("===>  insert 확인 ");	
		  Object[] args = { vo.getTitle(), vo.getWriter(),vo.getContent()} ;
		  jdbcTemplate.update(INSERTSQL, args);
		} catch ( Exception e) {
		  transactionManager.rollback(status);  // 예외 발생 시 롤백
		  System.out.println("에러발생");
		}
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
	public Map<String, Integer> totalCount() {			
		return jdbcTemplate.queryForObject(TOTALCOUNTSQL, new MapRowMapper());		
	}

	@Override
	public TotalCountVo totalCount2() {			
		return jdbcTemplate.queryForObject(TOTALCOUNTSQL, new TotalCount());
	}
}


class MapRowMapper implements RowMapper<Map<String, Integer>>{

	@Override
	public Map<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {		
		Map<String, Integer> map = new  HashMap<String, Integer>();	
		map.put("totalcount", rs.getInt("totalcount"));		
		return map;
	}	
}

