package com.newlecture.jspweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.newlecture.jspweb.entity.MemberRole;


public class MemberRoleDao {
	public List<MemberRole> getList() throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM MEMBER_ROLE";
		//String sql2 = "SELECT PWD = '122' FROM MEMBER";
		
		//드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		String memberId;
		String roleId;
		
		
		List<MemberRole> list = new ArrayList<>();
		while(rs.next()) {
			//id=rs.getString("MID");
			memberId=rs.getString("MEMBER_ID");
			roleId=rs.getString("ROLE_ID");
					
			MemberRole memberRole = new MemberRole(memberId, roleId);
			list.add(memberRole);
		}
		
		rs.close();
		st.close();
		con.close(); 
		
		return list;
		
	}
}
