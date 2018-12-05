package com.cg.ems.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.cg.ems.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	
	Map<Integer, Employee> employeeMap;
	
	public EmployeeDAOImpl(){
		
		employeeMap = DataStore.createCollection();
		
	}
	
	
	@Override
	public void createEmployee(Employee employee) {
		int randomId = (int) (1000*Math.random());
		employee.setEmployeeId(randomId);
		employeeMap.put(randomId, employee);
		System.out.println("New Employee created.. \nID : "+randomId);
	}

	@Override
	public Employee displayEmployee(int employeeId) {
			
		
		return employeeMap.get(employeeId);
	}

	@Override
	public void updateEmployeeDetails(int employeeId, Employee employee) {
		
		Employee e = employeeMap.get(employeeId);
		if(e == null){
			System.out.println("No employee found of this ID");
		}
		else{
			e.setMobileNo(employee.getMobileNo());
			e.setProject(employee.getProject());
			
			System.out.println("Record updated successfully");
		}
		
		
	}

	@Override
	public ArrayList<Employee> displayProjectEmployee(String project) {
		
		Collection<Employee> empList =  employeeMap.values();
		
		ArrayList<Employee> empArray = new ArrayList();
		
		for(Employee e : empList){
		
			if(e.getProject().equals(project))
				empArray.add(e);
			
		}
		
		return empArray;
	}

}
