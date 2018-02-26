package com.newlecture.jspweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.jspweb.entity.Member;
import com.newlecture.jspweb.entity.Notice;

public class JdbcMemberDao {
	public List<Member> getList() throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM MEMBER";
		//String sql2 = "SELECT PWD = '122' FROM MEMBER";
		
		//드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		String id;
		String pwd;
		String name;
		String gender;
		int age;
		String birthday;
		String major;
		String address;
		String phone;
		String ssn;
		String ip;
		String boss;
		Date regDate;
		
		List<Member> list = new ArrayList<>();
		while(rs.next()) {
			//id=rs.getString("MID");
			id=rs.getString("ID");
			pwd=rs.getString("PWD");
			name=rs.getString("NAME");
			gender=rs.getString("GENDER");
			age=rs.getInt("AGE");
			birthday=rs.getString("BIRTHDAY");
			major=rs.getString("MAJOR");
			address=rs.getString("ADDRESS");
			phone=rs.getString("PHONE");
			ssn=rs.getString("SSN");
			ip=rs.getString("IP");
			boss=rs.getString("BOSS");
			regDate=rs.getDate("REG_DATE");
			
			Member member = new Member(id,pwd,name,gender,age,
					birthday, major, address, phone, ssn, ip, boss, regDate);
			list.add(member);
		}
		
		rs.close();
		st.close();
		con.close(); 
		
		return list;
		
	}
}
