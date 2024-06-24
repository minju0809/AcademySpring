package com.majustory.biz.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.majustory.biz.comm.JDBCUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;	
	private ResultSet rs =null;
	@Override
	public void insert(BoardVO vo) {
		System.out.println("==>  BoardDaoImpl insert(BoardVO vo) ");
		conn  = JDBCUtil.getConnection();
		String SQL = "insert  into board (seq, title, writer, content) "
				+ " values(idx.nextval, ?, ?, ?) "; 
		try {
		   pstmt =	conn.prepareStatement(SQL);
		   pstmt.setString(1, vo.getTitle());
		   pstmt.setString(2, vo.getWriter());
		   pstmt.setString(3, vo.getContent());
		   pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
