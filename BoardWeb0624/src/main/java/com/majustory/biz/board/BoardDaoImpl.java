package com.majustory.biz.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.majustory.biz.comm.JDBCUtil;

@Repository
public class BoardDaoImpl extends JdbcDaoSupport implements BoardDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;	
	private ResultSet rs =null;
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	String INSERTSQL = "insert  into board (seq, title, writer, content) "
			+ " values(idx.nextval, ?, ?, ?) "; 
	
	@Override
	public void insert(BoardVO vo) {
		System.out.println("==>  BoardDaoImpl insert(BoardVO vo) ");
		
		getJdbcTemplate().update(INSERTSQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	@Override
	public List<BoardVO> select(BoardVO vo) {
		List<BoardVO> li = new ArrayList<>();
		System.out.println("===> select(BoardVo vo)");
		conn = JDBCUtil.getConnection();
		String SQL ="select *  from  board "
				+ " order  by seq  desc " ;
		try {
			pstmt = conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO m =new BoardVO();
				m.setSeq(rs.getInt("seq"));
				m.setTitle(rs.getString("title"));
				m.setWriter(rs.getString("writer"));
				li.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}
}
