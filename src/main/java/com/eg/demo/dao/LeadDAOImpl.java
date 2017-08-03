package com.eg.demo.dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.eg.demo.model.Lead;
import org.springframework.stereotype.Repository;

@Repository
public class LeadDAOImpl implements LeadDAO {
	//returning list of dummy data, instead data can be retrieved from database or else where
	public void add_lead(Lead lead) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/leads";

		//  Database credentials
		final String USER = "root";
		final String PASS = "CDKcdk11";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection to database server
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			String sql;
			stmt = conn.prepareStatement("insert into leads(firstName,lastName,email,phoneno) values(?,?,?,?)");
			stmt.setString(1, lead.getFirstName());
			stmt.setString(2, lead.getLastName());
			stmt.setString(3, lead.getEmail());
			stmt.setInt(4,lead.getPhoneno());

			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("Successfully inserted...");
			} else {
				System.out.println("Error inserting...");
			}

			//STEP 6: Clean-up environment
			stmt.close();

		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();

		} finally {
			//finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
		}//end try
		System.out.println("Done...");
	}
}
