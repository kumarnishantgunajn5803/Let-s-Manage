package UsecasesBDDO;

import java.util.ArrayList;
import java.util.List;

import Dao.BdoDao;
import Dao.BdoDaoImpl;
import Decoration.ConsoleColors;
import Exception.ProjectException;
import Model.Employee;
import Model.Project;

public class ViewListOfProject {

	public static void getListOfProject( ) {
		BdoDao dao = new BdoDaoImpl();
		try { 
			
			List<Project> list = dao.viewListOfProjects();
			
			
System.out.println("---------------------" + ConsoleColors.BLACK_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Project Present" + ConsoleColors.RESET+ "---------------------------");
			
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.printf("%27s   %15s %15s %30s  ",ConsoleColors.BLACK_BOLD + "PID",    "NAME", "BUDGET",   "NO OF EMPLOYEE WORKING" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------------------");
			
			System.out.println();
			 for(Project p:list) {

					System.out.format("%19s  %19s %15s %10s  ", p.getpId(), p.getName(),p.getBudget(),p.getNoOfEmpWorking() );
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
			 }
			System.out.println("---------------------------------------------------------------------------------");
			
			
			
			
			
			
			
			
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

}
