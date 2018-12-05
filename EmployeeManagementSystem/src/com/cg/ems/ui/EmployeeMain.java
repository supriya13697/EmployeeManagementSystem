package com.cg.ems.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class EmployeeMain {
	public static void main(String args[]) throws EmployeeException{
		EmployeeService service = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		String name, mobileNo, project;
		double salary;
		int id;
		
		while(ch != 5){
			
			System.out.println("1.Add Employee\n2.Display Employee\n3.Display Employee based on project\n4.Update Employee\n5.Exit");
			
			ch = sc.nextInt();
			
			switch(ch){
				
			case 1 :
				
					Employee employee = new Employee();
					do{
						System.out.println("Enter name of employee : ");
						name = sc.next();
						
						System.out.println("Enter mobile number of employee : ");
						mobileNo = sc.next();
						
						System.out.println("Enter the project of the employee : ");
						project = sc.next();
						
						System.out.println("Enter the salary of the employee : ");
						salary = sc.nextDouble();							
						
						employee.setName(name);
						employee.setMobileNo(mobileNo);
						employee.setProject(project);
						employee.setSalary(salary);
						
						if(service.validateEmployee(employee) == null)
							System.out.println("invalid details");
						else
							break;
					}while(true);
					
					service.createEmployee(employee);
					
				break;
			
			case 2 :
				
					System.out.println("Enter the emoplyee ID to view details : ");
					id = sc.nextInt();
					Employee emp = new Employee();
					
					emp = service.displayEmployee(id);
											
					System.out.println("Name : "+emp.getName()+"\nMobile Number : "+emp.getMobileNo()+"\nProject : "+emp.getProject()+"\nSalary : "+emp.getSalary());
				
				break;
				
			case 3 :
				
					System.out.println("Enter the project : ");
					project = sc.next();
					
					ArrayList<Employee> displayEmp = service.displayProjectEmployee(project); 
					
					System.out.println("Employee ID        Name      Mobile No.                 Project               Salary");
					
					for(Employee e : displayEmp){
						System.out.print(e.getEmployeeId()+"          ");
						System.out.print(e.getName()+"         ");
						System.out.print(e.getMobileNo()+"         ");
						System.out.print(e.getProject()+"        ");
						System.out.println(e.getSalary());;
					}
					
				
				break;
				
			case 4 :
				
					Employee empUpdate = new Employee();
					do{
						System.out.println("Enter the employee ID : ");
						id = sc.nextInt();
						
						System.out.println("Enter mobile number : ");
						mobileNo = sc.next();
						
						System.out.println("Enter project : ");
						project = sc.next();
																		
						empUpdate.setMobileNo(mobileNo);
						empUpdate.setProject(project);
						
						if(service.validateMobileNo(empUpdate.getMobileNo()))
							break;
					
					}while(true);		
					service.updateEmployeeDetails(id, empUpdate);
				
				break;
				
			case 5 :
					System.out.println("Ok Bye!");
				break;
			default : System.out.println("Invalid Input!");
			
			}
		}
	}
}
