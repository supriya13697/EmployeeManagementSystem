package com.cg.ems.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmployeeDAO;
import com.cg.ems.dao.EmployeeDAOImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao;
	
	public EmployeeServiceImpl(){
		dao = new EmployeeDAOImpl();
	}
	
	@Override
	public void createEmployee(Employee employee) {
		
		try {
			dao.createEmployee(employee);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee displayEmployee(int employeeId) {

		try {
			return dao.displayEmployee(employeeId);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateEmployeeDetails(int employeeId, Employee employee) {
		
		try {
			dao.updateEmployeeDetails(employeeId, employee);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Employee> displayProjectEmployee(String project) throws EmployeeException {
		// TODO Auto-generated method stub
		return dao.displayProjectEmployee(project);
	}

	@Override
	public Employee validateEmployee(Employee employee)
			throws EmployeeException {
		// TODO Auto-generated method stub
		if(validateName(employee.getName()) && validateSalary(employee.getSalary()) && validateMobileNo(employee.getMobileNo()))
			return employee;
		return null;
	}

	@Override
	public boolean validateName(String name) throws EmployeeException {
		// TODO Auto-generated method stub
				
		if(name == null)
			throw new EmployeeException("Null value found");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{3,10}");
		Matcher m = p.matcher(name); 
		return m.matches();
	}

	@Override
	public boolean validateSalary(Double salary) throws EmployeeException {
		// TODO Auto-generated method stub
		if(salary == null)
			throw new EmployeeException("Null value found");
		String sal = salary.toString();
		return (sal.matches("\\d{4,9}\\.\\d{0,4}"));
	}

	@Override
	public boolean validateMobileNo(String mobileNo) throws EmployeeException {
		// TODO Auto-generated method stub
		if(mobileNo == null)
			throw new EmployeeException("Null value found");
		Pattern p = Pattern.compile("[6789][0-9]{9}");
		Matcher m = p.matcher(mobileNo);
		return m.matches();
	}

	
	
}
