package com.majustory.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TotalCount implements RowMapper<Integer>{
	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer totalcount = 0;
		totalcount = rs.getInt("totalcount");
		return totalcount;
	}
}
