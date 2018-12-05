package com.cg.ems.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class TestClass {

	EmployeeService service = new EmployeeServiceImpl();
	String name;
	boolean result;
	
	@Test(expected=EmployeeException.class)
	public void test_ValidateName_Null()throws EmployeeException{
		service.validateName(null);
	}
	
	@Test
	public void test_validateName_v1()throws EmployeeException{
		name = "akhil";
		result = service.validateName(name);
		Assert.assertEquals(false,result);
	}
	
	@Test
	public void test_validateName_v2()throws EmployeeException{
		name = "Akhil";
		result = service.validateName(name);
		Assert.assertEquals(true,result);
	}
	
	@Test
	public void test_validateName_v3()throws EmployeeException{
		name = "Akhil121";
		result = service.validateName(name);
		Assert.assertEquals(false,result);
	}
	
	
	@Test(expected=EmployeeException.class)
	public void test_validateMobileNo_Null()throws EmployeeException{
		result = service.validateMobileNo(null);
		
	}
	
	@Test
	public void test_ValidateMobileNo_v1()throws EmployeeException{
		result = service.validateMobileNo("0123456789");
		Assert.assertEquals(false, result);
		
	}
	
	
	@Test
	public void test_ValidateMobileNo_v2()throws EmployeeException{
		result = service.validateMobileNo("8912434354dsf");
		Assert.assertEquals(false, result);
		
	}
	
	@Test
	public void test_ValidateMobileNo_v3()throws EmployeeException{
		result = service.validateMobileNo("7021540643");
		Assert.assertEquals(true, result);
		
	}
	
	@Test(expected=EmployeeException.class)
	public void test_ValidateSalary_Null()throws EmployeeException{
		result = service.validateSalary(null);
		Assert.assertEquals(false, result);
	}
	
	
	@Test
	public void test_ValidateSalary_v1()throws EmployeeException{
		result = service.validateSalary(25000.0);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void test_ValidateSalary_v2()throws EmployeeException{
		result = service.validateSalary(250000000000.0);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void test_ValidateSalary_v3()throws EmployeeException{
		result = service.validateSalary(250.0);
		Assert.assertEquals(false, result);
	}

	@Test
	public void test_ValidateSalary_v4()throws EmployeeException{
		result = service.validateSalary(250.436750);
		Assert.assertEquals(false, result);
	}
	
	
}
