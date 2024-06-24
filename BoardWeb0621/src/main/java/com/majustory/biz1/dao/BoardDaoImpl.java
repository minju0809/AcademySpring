package com.majustory.biz1.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.majustory.biz1.BoardVo;
import com.majustory.biz1.JDBCUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDaoImpl() {
		System.out.println("BoardDaoImpl 생성자");
	}
	
	@Override
	public void insert(BoardVo vo) {
		 conn = JDBCUtil.getConnection();
		 String sql = "insert into board (seq, title, writer, content)"
		 		+ " values ((select nvl(max(seq) ,0) + 1 from board),?,?,?)";
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardVo> getSelect() {
		List<BoardVo> li = new ArrayList<>();
		conn = JDBCUtil.getConnection();
		String sql = "select * from board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVo m = new BoardVo();
				m.setSeq(rs.getInt("seq"));
				m.setTitle(rs.getString("title"));
				m.setWriter(rs.getString("writer"));
				m.setContent(rs.getString("content"));
				m.setRegdate(rs.getString("regdate"));
				m.setCnt(rs.getString("cnt"));
				System.out.println("vo: " + m);
				li.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

}
