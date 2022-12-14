package com.java.solid.app;

public class App {

	public static void main(String[] args) {
		String query;
		InputProcessor input = new InputProcessor();
		SQLDatabase sql = new SQLDatabase(new DatabaseController("jdbc:mysql://localhost:3306/demo", "root" , "DataGuard432$"));
		
		if (sql.connect()) 
			System.out.println("Connected to database successfully");
		else 
			System.out.println("Not able to connect due to some error");
		
		while (input.selection != 6) {
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
			query = input.process();	
			if (query != null )
				sql.executeQuery(query, input.employee, input.selection,input.searchSelection);
			else 
				System.out.println("Thank you!");
		}	
	}
}
