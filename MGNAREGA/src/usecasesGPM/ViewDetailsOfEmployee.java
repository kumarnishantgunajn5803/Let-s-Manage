package usecasesGPM;

import java.util.Scanner;

import Dao.GPMDao;
import Dao.GPMDaoImpl;
import Decoration.ConsoleColors;
import Exception.EmployeeException;
import Model.Employee;

public class ViewDetailsOfEmployee {

	public static void viewDetailsOfEmployee( ) {
		 Scanner s =  new Scanner(System.in);
		 System.out.println("Please Enter Employee Id :");
		 int empId = s.nextInt();
		 
		 GPMDao dao = new GPMDaoImpl();
		try {
			Employee employee = dao.viewEmpDetail(empId);
			
System.out.println("---------------------" + ConsoleColors.BLACK_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee Present" + ConsoleColors.RESET+ "---------------------------");
			
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.printf("%27s %7.5s %8.5s %10s %15s  ",ConsoleColors.BLACK_BOLD + "EID",  "EPID", "NAME", "ADDRESS",   "WAGE/DAY" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------------------");
			
			System.out.println();
			 
				System.out.format("%19s %6s %10.5s %11s %8s  ",employee.getEmpid(),employee.getProjectId(),employee.getName(),employee.getAddress(),employee.getWages());
			 
				System.out.println();
			System.out.println("---------------------------------------------------------------------------------");
			 
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

}
