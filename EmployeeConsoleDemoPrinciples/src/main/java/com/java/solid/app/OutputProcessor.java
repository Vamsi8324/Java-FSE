package com.java.solid.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.java.solid.entity.Employee;

public class OutputProcessor {
	List<Employee> employeeList = new ArrayList<>();
	
	//Process output post query execution mainly for select queries
	public void process(ResultSet myRs, int selection) {
		try {
			if (selection == 2) {
				while(myRs.next()) {
					Employee emp = new Employee();
					emp.setId(myRs.getInt(1));
					emp.setLastName(myRs.getString(2));
					emp.setFirstName(myRs.getString(3));
					emp.setEmail(myRs.getString(4));
					emp.setDepartment(myRs.getString(5));
					emp.setSalary(myRs.getDouble(6));
					employeeList.add(emp);					
				}
				System.out.println("Employees Data:");
				System.out.println("----------------");
				System.out.println("ID\tFirstName\tLastName\tEmail\tDepartment\tSalary");
				System.out.println("----------------");
					
				ListIterator<Employee> itr = employeeList.listIterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			}
			if (selection == 3) {
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
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
