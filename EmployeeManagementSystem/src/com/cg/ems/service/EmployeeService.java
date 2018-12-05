package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeService {

	public void createEmployee(Employee employee) throws EmployeeException;
	
	public Employee displayEmployee(int employeeId)throws EmployeeException;
	
	public void updateEmployeeDetails(int employeeId, Employee employee)throws EmployeeException;
	
	public ArrayList<Employee> displayProjectEmployee(String project)throws EmployeeException;
	
	
	
	public Employee validateEmployee(Employee employee)throws EmployeeException;
	
	public boolean validateName(String name) throws EmployeeException;
	
	public boolean validateSalary(Double salary) throws EmployeeException;
	
	public boolean validateMobileNo(String mobileNo)throws EmployeeException;
	
}
