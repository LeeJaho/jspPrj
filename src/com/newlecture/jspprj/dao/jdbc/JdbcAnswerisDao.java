package com.newlecture.jspprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.entity.Answeris;
import com.newlecture.jspprj.entity.AnswerisView;

public class JdbcAnswerisDao implements AnswerisDao {

	@Override
	public int insert(Answeris answeris) {
		/*data table 가서 드래그 -> insert 작성*/
		String sql = "INSERT INTO answeris (" + 
				"    id," + 
				"    title," + 
				"    language," + 
				"    platform," + 
				"    runtime," + 
				"    error_code," + 
				"    error_message," + 
				"    situation," + 
				"    tried_to_fix," + 
				"    reason," + 
				"    how_to_fix," + 
				"    writer_id" + 
				") VALUES ((SELECT NVL(MAX(TO_NUMBER(ID)),0)+1 ID FROM ANSWERIS)"
				+",?,?,?,?,?,?,?,?,?,?,?)";
		//String sql2 = "SELECT PWD = '122' FROM MEMBER";
		
		//드라이버 로드
		int result = 0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			/*st.setString(1, answeris.getId());*/
			st.setString(1, answeris.getTitle());
			st.setString(2, answeris.getLanguage());
			st.setString(3, answeris.getPlatform());
			st.setString(4, answeris.getRuntime());
			st.setString(5, answeris.getErrorCode());
			st.setString(6, answeris.getErrorMessage());
			st.setString(7, answeris.getSituation());
			st.setString(8, answeris.getTriedToFix());
			st.setString(9, answeris.getReason());
			st.setString(10, answeris.getHowToFix());
			st.setString(11, answeris.getWriterId());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(Answeris answeris) {
		String sql = "UPDATE ANSWERIS SET" + 
					"    title=?," + 
					"    language=?," + 
					"    platform=?," + 
					"    runtime=?," + 
					"    error_code=?," + 
					"    error_message=?," + 
					"    situation=?," + 
					"    tried_to_fix=?," + 
					"    reason=?," + 
					"    how_to_fix=?," + 
					"    hit=?," + 
					"	WHERE ID=?";
		//String sql2 = "SELECT PWD = '122' FROM MEMBER";
		
		//드라이버 로드
		int result = 0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, answeris.getTitle());
			st.setString(2, answeris.getLanguage());
			st.setString(3, answeris.getPlatform());
			st.setString(4, answeris.getRuntime());
			st.setString(5, answeris.getErrorCode());
			st.setString(6, answeris.getErrorMessage());
			st.setString(7, answeris.getSituation());
			st.setString(8, answeris.getTriedToFix());
			st.setString(9, answeris.getReason());
			st.setString(10, answeris.getHowToFix());
			st.setInt(11, answeris.getHit());
			st.setString(12, answeris.getId());
			
			
			result = st.executeUpdate();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(String id) {
		String sql = "DELETE ANSWERIS WHERE ID=?";
		//String sql2 = "SELECT PWD = '122' FROM MEMBER";
		
		//드라이버 로드
		int result = 0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, id);
						
			result = st.executeUpdate();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<AnswerisView> getList() {
		String sql = "SELECT * FROM ANSWERIS_VIEW ORDER BY REG_DATE DESC";
		//String sql2 = "SELECT PWD = '122' FROM MEMBER";
		List<AnswerisView> list = new ArrayList<>();
		
		//드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			
			AnswerisView answeris = null;
			while(rs.next()) {
				/*반복할때마다 새로 만들어주는거임 / 중복 X */
				/*AnswerisView */answeris = new AnswerisView(
							rs.getString("ID"),
							rs.getString("LANGUAGE"),
							rs.getString("PLATFORM"),
							rs.getString("RUNTIME"),
							rs.getString("TITLE"),
							rs.getString("ERROR_CODE"),
							rs.getString("ERROR_MESSAGE"),
							rs.getString("SITUATION"),
							rs.getString("TRIED_TO_FIX"),
							rs.getString("REASON"),
							rs.getString("WRITER_ID"),
							rs.getString("HOW_TO_FIX"),
							rs.getDate("REG_DATE"),
							rs.getInt("HIT"),
							rs.getInt("COMMENT_COUNT")
						);
				
				list.add(answeris);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public AnswerisView get(String id) {
		String sql = "SELECT * FROM ANSWERIS_VIEW WHERE ID=?";
		//String sql2 = "SELECT PWD = '122' FROM MEMBER";
		AnswerisView answeris = null;
		//드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			PreparedStatement st = con.prepareStatement(sql);
			
			/*1은 물음표 개수?*/
			st.setString(1, id);
			
			ResultSet rs = st.executeQuery();
						
			if(rs.next()){
				answeris = new AnswerisView(
							rs.getString("ID"),
							rs.getString("LANGUAGE"),
							rs.getString("PLATFORM"),
							rs.getString("RUNTIME"),
							rs.getString("TITLE"),
							rs.getString("ERROR_CODE"),
							rs.getString("ERROR_MESSAGE"),
							rs.getString("SITUATION"),
							rs.getString("TRIED_TO_FIX"),
							rs.getString("REASON"),
							rs.getString("WRITER_ID"),
							rs.getString("HOW_TO_FIX"),
							rs.getDate("REG_DATE"),
							rs.getInt("HIT"),
							rs.getInt("COMMENT_COUNT")
						);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answeris;
	}

}
