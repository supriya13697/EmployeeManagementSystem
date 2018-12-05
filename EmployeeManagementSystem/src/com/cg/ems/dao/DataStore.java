package com.cg.ems.dao;

import java.util.HashMap;

import com.cg.ems.dto.Employee;

public class DataStore {
	
	private static HashMap<Integer, Employee> employee;
	
	public static HashMap<Integer, Employee> createCollection(){
		
		if(employee == null)
			employee = new HashMap<>();
		
		return employee;		
	}
}
