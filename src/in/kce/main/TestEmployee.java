package in.kce.main;

import java.util.ArrayList;
import java.util.Scanner;

import in.kce.bean.Employee;
import in.kce.service.EmployeeService;
import java.util.Scanner;
public class TestEmployee {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	//switch for menu
	System.out.println("Employee Management\n"
			+ "1. Store Employee\n"
			+ "2. Update Employee\n"
			+ "3. Delete Employee\n"
			+ "4. Fetch one Employee\n"
			+ "5. Fetch All Employee");
	int option=sc.nextInt();
	switch (option) {
	case 1: {
		//Get 3 inputs
		int id=sc.nextInt();
		String name=sc.next();
		String desig=sc.next();
		EmployeeService employeeService=new EmployeeService();
		boolean result=employeeService.saveEmployee(id,name,desig);
		if(result) {
			System.out.println("Inserted");
		}
		break;
	}
	case 2: {
		int id=sc.nextInt();
		String name=sc.next();
		EmployeeService employeeService=new EmployeeService();
		boolean result=employeeService.updateEmployee(id, name);
		if(result) {
			System.out.println("Updated");
		}
		break;
	}
	case 3: {
		int id=sc.nextInt();
		EmployeeService employeeService=new EmployeeService();
		boolean result=employeeService.deleteEmployee(id);
		if(result) {
			System.out.println("Deleted");
		}
		break;
	}
	case 4: {
		int id=sc.nextInt();
		EmployeeService employeeService=new EmployeeService();
		Employee emp=employeeService.getEmployee(id);	
		if(emp!=null) {
			System.out.println("Emp Id:"+emp.getEmpId());
			System.out.println("Emp Name:"+emp.getEmpName());
			System.out.println("Designation:"+emp.getDesignation());
		}else {
			System.out.println("Employee not found");
		}
		break;
	}
	case 5: {
		EmployeeService employeeService=new EmployeeService();
		ArrayList<Employee> l=employeeService.getAllEmployee();
		if(!l.isEmpty()) {
			
		}
		break;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + option);
	}
	
}
}
