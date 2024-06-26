package com.majustory.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TotalCount implements RowMapper<TotalCountVo> {

	@Override
	public TotalCountVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		TotalCountVo m = new TotalCountVo();
		m.setTotalCount(rs.getInt("totalcount"));
		return m;
	}

}
