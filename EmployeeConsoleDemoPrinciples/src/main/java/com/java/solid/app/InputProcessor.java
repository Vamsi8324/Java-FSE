package com.java.solid.app;

import java.util.Scanner;

import com.java.solid.entity.*;

public class InputProcessor {
	int selection = 0;
	int searchSelection = 0;
	Employee employee = new Employee();
	
	//Process inputs from console
	public String process() {
		Scanner scanner = new Scanner(System.in);
		this.selection = scanner.nextInt();
		String query = null;
		
		if (this.selection == 1) {
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
			query = "INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`,"
    				+ "`department`, `salary`) VALUES (?,?,?,?,?,?);";
			return query;
		}
		if (this.selection == 2) {
			query = "select * from Employees";
			return query;
		}
		if (this.selection == 3 ) {
			System.out.println("Search Employee Form:");
			System.out.println("[");
			System.out.println("\t1.Search By ID");
			System.out.println("\t2.Search By FirstName");
			System.out.println("\t3.Search By LastName");
			System.out.println("\t4.Search By Dept");
			System.out.println("\t5.Search By Salary");
				
			searchSelection = scanner.nextInt();
			
			if (searchSelection == 1) {
				System.out.println("Search Employee By ID:");
				System.out.println("enter the id:");
				employee.setId(scanner.nextInt());
				query = "SELECT * FROM Employees WHERE id=?;" ;
			}
			if (searchSelection == 2) {
				System.out.println("Search Employee By Firstname:");
				System.out.println("enter the Firstname:");
				employee.setFirstName(scanner.next());
				query = "SELECT * FROM Employees WHERE first_name=?;";
			}
			if (searchSelection == 3) {
				System.out.println("Search Employee By Lastname:");
				System.out.println("enter the Lastname:");
				employee.setLastName(scanner.next());
				query = "SELECT * FROM Employees WHERE last_name=?;";
			}
			if (searchSelection == 4) {
				System.out.println("Search Employee By Department:");
				System.out.println("enter the department:");
				employee.setDepartment(scanner.next());
				query = "SELECT * FROM Employees WHERE department=?;";
			}
			if (searchSelection == 5) {
				System.out.println("Search Employee By Salary:");
				System.out.println("enter the salary:");
				employee.setSalary(scanner.nextDouble());
				query = "SELECT * FROM Employees WHERE salary=?;";
			}
			return query;
		}
		if (this.selection == 4) {
			System.out.println("Enter id of employee to be deleted");
			employee.setId( scanner.nextInt());
			query = "delete from Employees where id=?";
			return query;
		}
		if (this.selection == 5) {
			System.out.println("Enter id of employee to be updated");
			employee.setId(scanner.nextInt());
			System.out.println("Enter new name");
			employee.setFirstName(scanner.next());
			query = "UPDATE Employees SET first_name=? WHERE id=?;";
			return query;
		}
		return null;		
	}
}
