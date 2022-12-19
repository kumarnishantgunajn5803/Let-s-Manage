package UsecasesBDDO;

import java.util.List;

import Dao.BdoDao;
import Dao.BdoDaoImpl;
import Decoration.ConsoleColors;
import Exception.GpmException;
import Model.GPM;
import Model.Project;

public class GetListOfAllGpm {

	public static void getListOfAllGPm( ) {
		 
		
		BdoDao dao = new BdoDaoImpl();
		try {
		List<GPM> list =	dao.viewAllGpm();
		 
		
		
		
System.out.println("---------------------" + ConsoleColors.BLACK_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the GPM Present" + ConsoleColors.RESET+ "---------------------------");
		
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.printf("%27s   %15s %15s %30s  ",ConsoleColors.BLACK_BOLD + "GPMID",    "NAME", "USERNAME",   "ALLOCATED PROJECT ID" + ConsoleColors.RESET);
		System.out.println();
		System.out.print("---------------------------------------------------------------------------------");
		
		System.out.println();
		 for(GPM g:list) {

				System.out.format("%19s  %19s %15s %10s  ", g.getGPMId(), g.getName() , g.getUsername() , g.getAssignedProjectId() );
				System.out.println();
				System.out.println("---------------------------------------------------------------------------------");
		 }
		System.out.println("---------------------------------------------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		} catch (GpmException e) {
			System.out.println(e.getMessage());
		}

	}

}
