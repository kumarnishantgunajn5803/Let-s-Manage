package AppController;

import Decoration.ConsoleColors;
import usecasesGPM.AssignProjectToEmployee;
import usecasesGPM.CreateEmployee;
import usecasesGPM.LoginGpm;
import usecasesGPM.TotalNumberOfDayAndWages;
import usecasesGPM.ViewDetailsOfEmployee;

public class GpmMain {

	public static boolean GpmLogin() {
		 boolean result = LoginGpm.LoginGPM();
		return result;	
	}
	
	public static void gpmWindow() {
		String color =  ConsoleColors.BLUE_BOLD;
		
		System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Gram Panchayat Member Home Window : "+ ConsoleColors.RESET);
		System.out.println("Press 1 to"+color+" Create a Employee." + ConsoleColors.RESET);
		System.out.println("Press 2 to"+color+" View Details of Employee." + ConsoleColors.RESET);
		System.out.println("Press 3 to"+color+" Assingn Project To An Employee." + ConsoleColors.RESET);
		System.out.println("Press 4 to"+color+"  View total number of days Employee worked in a project and also their wages." + ConsoleColors.RESET);
		System.out.println("Press 5 to"+ConsoleColors.RED_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);
	}
	
	
	
	public static void createEmployee() {
		 
		CreateEmployee.createEmployee();
	}
	
	public static void displayEmployee() {
		 ViewDetailsOfEmployee.viewDetailsOfEmployee();
	}
	
	public static void assignProjectToEmployee() {
		 
		AssignProjectToEmployee.assignProjectTOEmployee();
	}
	
	public static void dayWageTotal() {
		
		TotalNumberOfDayAndWages.totalNumberOfDayAndWages();
		
	}
		
		
	
	
	
	
	
	
	
	
}
