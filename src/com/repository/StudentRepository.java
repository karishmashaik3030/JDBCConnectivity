package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.mysql.cj.protocol.Resultset;

public class StudentRepository {
private String username="root";
private String password="karru";
private String url="jdbc:mysql://localhost:3306/studentdb";
private String driver="com.mysql.cj.jdbc.Driver";
Connection con;
//establishing connection
public void dbConnect() {
	
	//load the driver
	try {
		Class.forName(driver);
		System.out.println("connect");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//establish the connection
	try {
		con=DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//closing connection
public void dbClose() {
	try {
		con.close();
		System.out.println("close");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//inserting student
public void insert(int id, String name, String city, String subject) {
	// TODO Auto-generated method stub
	dbConnect();
	String sql="insert into student values(?,?,?,?)";
	try {
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3, city);
		stmt.setString(4, subject);
		int rs=stmt.executeUpdate();
		if(rs>0) {
			System.out.println("Data inserted successfully");
		}
		else {
			System.out.println("Issue in inserting data");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
dbClose();	
}
//getting students
public List<Student> getAll() {
	// TODO Auto-generated method stub
	dbConnect();
	String sql="select * from student";
	List<Student> students=new ArrayList<Student>();
	try {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String city=rs.getString("city");
			String subject=rs.getString("subject");
			
			Student st=new Student();
			st.setId(id);
			st.setName(name);
			st.setCity(city);
			st.setSubject(subject);
			students.add(st);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dbClose();
	return students;
	
}
//checking id
public int checkId(int id) {
	dbConnect();
	String sql="select * from student where id=?";
	int status=0;
	try {
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs= stmt.executeQuery();
		if(rs.next()) {
			System.out.println("Record found");
			status=1;
		}
		else {
			System.out.println("no record found");
			status=0;
			dbClose();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return status;
}
//deleting student
public void deleteById(int id) {
	// TODO Auto-generated method stub
	dbConnect();
	String sql="select * from student where id=?";
	String sql1="delete from student where id=?";
	try {
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet result=stmt.executeQuery();
		if(result.next()) {
			System.out.println("Student Record found");
			stmt=con.prepareStatement(sql1);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Deleted successfully");
		}
		else {
		System.out.println("Id not found cannot delete");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dbClose();
}
//updating student
public void update(int id, String name, String city, String subject) {
	// TODO Auto-generated method stub
	String query="select * from student where id=?";
	String sql="update student set name=?,city=?,subject=? where id=?";
	String currname="";
	String currcity="";
	String currsubject="";
	try {
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, id);
		ResultSet rs= st.executeQuery();
		while(rs.next()) {
			currname=rs.getString("name");
			currcity=rs.getString("city");
			currsubject=rs.getString("subject");
		}
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, (name != "") ? name : currname);
		stmt.setString(2, (city != "") ? city : currcity);
		stmt.setString(3, (subject != "") ? subject : currsubject);
		stmt.setInt(4, id);
		stmt.executeUpdate();
		System.out.println("Updated successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dbClose();
}

}
