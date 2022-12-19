package AppController;

import Decoration.ConsoleColors;
import UsecasesBDDO.AllocateProjectToGPm;
import UsecasesBDDO.BdoLogin;
import UsecasesBDDO.CreateNewGpm;
import UsecasesBDDO.CreateNewProject;
import UsecasesBDDO.GetListOfAllGpm;
import UsecasesBDDO.ListOfEmployeeWorkingOnProject;
import UsecasesBDDO.ViewListOfProject;

public class BdoMain {
	public static Boolean bdoLogin() {
		 
		Boolean result = BdoLogin.BDOLogin();
		return result;	
	}
	
	public static void bdoHomeWndow() {
		String color =  ConsoleColors.BLUE_BOLD;
		System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to BDO Home Window : "+ ConsoleColors.RESET);
		System.out.println("Press 1 to"+color+" Create a Project." + ConsoleColors.RESET);
		System.out.println("Press 2 to"+color+" View List of all Projects." + ConsoleColors.RESET);
		System.out.println("Press 3 to"+color +" Create a Gram Panchayat Member." + ConsoleColors.RESET);
		System.out.println("Press 4 to"+color+" View List of all Gram Panchayat Members ." + ConsoleColors.RESET);
		System.out.println("Press 5 to"+color +" Allocate Project to Gram Panchayat Member." + ConsoleColors.RESET);
		System.out.println("Press 6 to"+color +" See the List of Employee working on a project" + ConsoleColors.RESET);
		System.out.println("Press 7 to"+ConsoleColors.RED_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);	
	}
	
	public static void createProject() {
  
		CreateNewProject.createNewProject();
	}
	
	public static void viewListOfProject() {
 	
		ViewListOfProject.getListOfProject();
	}
	
	public static void createGPM() {
		
             CreateNewGpm.createNewGPM();
	}
	
	public static void viewListOfGPM() {
	 
		GetListOfAllGpm.getListOfAllGPm();
	}
	
	public static void allocateProjectToGPM() {
		
	   AllocateProjectToGPm.allocateProjectToGpm();
		
	}
	
	public static void listOfEmployee() {
		
	  ListOfEmployeeWorkingOnProject.getListOfEmployeeWorkingOnProject();
		
	}
}
