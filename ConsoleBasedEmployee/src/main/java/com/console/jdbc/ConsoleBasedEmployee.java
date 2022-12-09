package com.console.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.console.jdbc1.Employee;

public class ConsoleBasedEmployee {

	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		ResultSet myRs = null;
		int rowsInserted = 0;
		int selection = 0;
		PreparedStatement pstmt = null;
		Scanner scanner = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root" , "DataGuard432$");
			System.out.println("Database connection successful!\n");
			while (selection != 6) {
				System.out.println("welcome admin:");
				System.out.println("[");
				System.out.println("\t1. add a new Employee,");
				System.out.println("\t2. see all employee,");
				System.out.println("\t3. search an employee,");
				System.out.println("\t4. delete an employee,");
				System.out.println("\t5. update an employee");
				System.out.println("\t6. Exit");
				System.out.println("]");
				System.out.println("select a number between 1 - 5:");

				scanner = new Scanner(System.in);
				selection = Integer.parseInt(scanner.next());

				if (selection == 1) {
					Employee employee = new Employee();
					System.out.println("Add employee Form");
					System.out.println("------------------");
					System.out.println("Enter Id:");
					employee.setId(scanner.nextInt());
					System.out.println("Enter last name:");
					employee.setLastName(scanner.next());
					System.out.println("Enter firstname:");
					employee.setFirstName(scanner.next());
					System.out.println("Enter email:");
					employee.setEmail(scanner.next());
					System.out.println("Enter department:");
					employee.setDepartment(scanner.next());
					System.out.println("Enter salary:");
					employee.setSalary(scanner.nextDouble());

		    		String insertSqlQuery="INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`,"
		    				+ "`department`, `salary`) VALUES (?,?,?,?,?,?);";

			    	pstmt = myConn.prepareStatement(insertSqlQuery);
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

				if(selection == 2 ) {
					List<Employee> empList = new ArrayList<Employee>();
					pstmt = myConn.prepareStatement("select * from Employees");
					myRs = pstmt.executeQuery();
					while(myRs.next()) {
						Employee emp = new Employee();
						emp.setId(myRs.getInt(1));
						emp.setLastName(myRs.getString(2));
						emp.setFirstName(myRs.getString(3));
						emp.setEmail(myRs.getString(4));
						emp.setDepartment(myRs.getString(5));
						emp.setSalary(myRs.getDouble(6));
						empList.add(emp);					
					}
					System.out.println("Employees Data:");
					System.out.println("----------------");
					System.out.println("ID\tFirstName\tLastName\tEmail\tDepartment\tSalary");
					System.out.println("----------------");

					ListIterator<Employee> itr = empList.listIterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				}

				if(selection == 3) {
					System.out.println("Search Employee Form:");
					System.out.println("[");
					System.out.println("\t1.Search By ID");
					System.out.println("\t2.Search By FirstName");
					System.out.println("\t3.Search By LastName");
					System.out.println("\t4.Search By Dept");
					System.out.println("\t5.Search By Salary");

					int searchSelection = scanner.nextInt();

					if (searchSelection == 1) {
						System.out.println("Search Employee By ID:");
						System.out.println("enter the id:");
						int id = scanner.nextInt();
						pstmt = myConn.prepareStatement("SELECT * FROM Employees WHERE id=" + id + ";");
					}
					if (searchSelection == 2) {
						System.out.println("Search Employee By Firstname:");
						System.out.println("enter the Firstname:");
						String fName = scanner.next();
						pstmt = myConn.prepareStatement("SELECT * FROM Employees WHERE first_name='" + fName + "';");
					}
					if (searchSelection == 3) {
						System.out.println("Search Employee By Lastname:");
						System.out.println("enter the Lastname:");
						String lName = scanner.next();
						pstmt = myConn.prepareStatement("SELECT * FROM Employees WHERE last_name='" + lName + "';");
					}
					if (searchSelection == 4) {
						System.out.println("Search Employee By Department:");
						System.out.println("enter the id:");
						String dept = scanner.next();
						pstmt = myConn.prepareStatement("SELECT * FROM Employees WHERE department='" + dept + "';");
					}
						myRs = pstmt.executeQuery();
						while(myRs.next()) {
						Employee emp = new Employee();
						emp.setId(myRs.getInt(1));
						emp.setLastName(myRs.getString(2));
						emp.setFirstName(myRs.getString(3));
						emp.setEmail(myRs.getString(4));
						emp.setDepartment(myRs.getString(5));
						emp.setSalary(myRs.getDouble(6));
						System.out.println(emp);
						}
				}
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}

}