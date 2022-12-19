package UsecasesBDDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.BdoDao;
import Dao.BdoDaoImpl;
import Decoration.ConsoleColors;
import Exception.ProjectException;
import Model.Employee;

public class ListOfEmployeeWorkingOnProject {

	public static void getListOfEmployeeWorkingOnProject( ) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The ProjectId:");
		int pId = s.nextInt();
		
		BdoDao dao = new BdoDaoImpl();
		try {
			List<Employee> list =dao.listOfEmployeeWorkingOnProject(pId);
//			System.out.println(dao.listOfEmployeeWorkingOnProject(pId));
			
			
			
			
System.out.println("---------------------" + ConsoleColors.BLACK_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee Present" + ConsoleColors.RESET+ "---------------------------");
			
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.printf("%27s %7.5s %8.5s %10s %15s  ",ConsoleColors.BLACK_BOLD + "EID",  "EPID", "NAME", "ADDRESS",   "WAGE/DAY" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------------------");
			
			System.out.println();
			 
				for(Employee employee :list) {
					System.out.format("%19s %6s %10.5s %11s %8s  ",employee.getEmpid(),employee.getProjectId(),employee.getName(),employee.getAddress(),employee.getWages());
					 
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					
				}
			System.out.println("---------------------------------------------------------------------------------");
			 
			
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

}
