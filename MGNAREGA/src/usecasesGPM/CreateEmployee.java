package usecasesGPM;

import java.util.Scanner;

import Dao.GPMDao;
import Dao.GPMDaoImpl;
import Exception.EmployeeException;
import Model.Employee;

public class CreateEmployee {

	public static void createEmployee( ) {
		 Scanner s = new Scanner(System.in);
 		 System.out.println("Enter Name of Employee :");
 		 String name = s.nextLine();
 		 System.out.println("Enter username of Employee :");
 		 String username = s.nextLine();
 		 System.out.println("Enter Password of Employee :");
 		 String password = s.nextLine();
 		 System.out.println("Enter address of Employee :");
 		 String address = s.nextLine();
 		 System.out.println("Enter phone of Employee :");
 		 String phone = s.nextLine();
 		 System.out.println("Enter wages of Employee :");
 		 int wages = s.nextInt();
 		 
 		 Employee employee = new Employee();
 		 employee.setName(name);
 		 employee.setUsername(username);
 		 employee.setPassword(password);
 		 employee.setAddress(address);
 		 employee.setPhone(phone);
 		 employee.setWages(wages);
 		 
 		 GPMDao dao = new GPMDaoImpl();
 		 
 		try {
			String str = dao.createEmployee(employee);
			System.out.println(str);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
 		 
 		 
	}

}
