package com.cg.ems.dao;

import java.util.ArrayList;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeDAO {

	
	public void createEmployee(Employee employee) throws EmployeeException;
	
	public Employee displayEmployee(int employeeId)throws EmployeeException;
	
	public void updateEmployeeDetails(int employeeId, Employee employee)throws EmployeeException;
	
	public ArrayList<Employee> displayProjectEmployee(String project)throws EmployeeException;	
}
