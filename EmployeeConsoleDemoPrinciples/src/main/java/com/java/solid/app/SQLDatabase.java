package com.java.solid.app;

import com.java.solid.entity.Employee;

public class SQLDatabase extends DatabaseController{
	//Created a parent class DatabaseController so that we can override connect(), disconnect() methods
	DatabaseController dbController;
	
	public SQLDatabase(DatabaseController dbController) {
		super(dbController.details.url, dbController.details.userName, dbController.details.password);
		this.dbController = dbController;
	}
	
	@Override
	public boolean connect() {
		return this.dbController.connect();
	}
	
	@Override
	public void executeQuery(String query, Employee e,int selection,int searchSelection) {
		this.dbController.executeQuery(query, e, selection, searchSelection);
	}
}
