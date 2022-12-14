package com.java.solid.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ListIterator;

import com.java.solid.entity.Employee;


public class DatabaseController implements DatabaseConnection {
	// created DatabaseDetails interface to accept user and db details
	DatabaseDetails details;
	Connection myConn = null;
	PreparedStatement pstmt = null;
	int rowsInserted;
	ResultSet myRs = null;
	OutputProcessor outputProcess = new OutputProcessor();
	
	public DatabaseController(String url, String userName, String password) {
		this.details = new DatabaseDetails(url, userName, password);
	}

	//Perform db connection
	public boolean connect() {
		try { 
			myConn = DriverManager.getConnection(details.url, details.userName , details.password);
			return true;
		}
		catch (SQLException exc) {
			return false;
		}	
	}
	
	//Execute sql queries
	public void executeQuery(String query, Employee employee, int selection, int searchSelection) {
		try {
			pstmt = myConn.prepareStatement(query);	
			
			if (selection == 1) {
				pstmt.setInt(1,employee.getId());
		    	pstmt.setString(2,employee.getLastName());
		    	pstmt.setString(3,employee.getFirstName());
		    	pstmt.setString(4,employee.getEmail());
		    	pstmt.setString(5, employee.getDepartment());
		    	pstmt.setDouble(6, employee.getSalary());
		    	
		    	rowsInserted = pstmt.executeUpdate();
		    	
		    	if(rowsInserted>0) {
		    		System.out.println("Employee details inserted successfully");
		    	}
			} 
			if (selection == 2 || selection == 3) {
				if(selection == 3) {
					switch(searchSelection) {
						case 1:
							pstmt.setInt(1,employee.getId());
							break;
						case 2: 
							pstmt.setString(1, employee.getFirstName());
							break;
						case 3: 
							pstmt.setString(1, employee.getLastName());
							break;
						case 4: 
							pstmt.setString(1, employee.getDepartment());
							break;
						case 5: 
							pstmt.setDouble(1, employee.getSalary());
							break;
						default:
							break;
					}
				}
				
				myRs = pstmt.executeQuery();
				outputProcess.process(myRs, selection);
			}
			if (selection == 4) {
				pstmt.setInt(1,employee.getId());
				int rowDeleted = pstmt.executeUpdate();
				if(rowDeleted > 0) {
					System.out.println("Employee deleted");
				}
			}
			if (selection == 5) {
				pstmt.setString(1,employee.getFirstName());
				pstmt.setInt(2,employee.getId());
				int rowsUpdated = pstmt.executeUpdate();
				if(rowsUpdated > 0) {
					System.out.println("Employee updated");
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
	}

	public void disconnect() {
		System.out.println("Disconnected");
	}
	
}
