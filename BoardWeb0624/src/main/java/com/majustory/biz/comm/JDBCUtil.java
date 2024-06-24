package com.majustory.biz.comm;

import java.sql.*;

public class JDBCUtil {
	public static Connection getConnection() {

		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String id = "system";
		String pwd = "1234";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(PreparedStatement pstmt, Connection conn) {

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
