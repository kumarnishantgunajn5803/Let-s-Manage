package AppController;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Decoration.ConsoleColors;

public class Main {
	
	public static void appOpening() throws InputMismatchException  {
		

		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT+"Welcome to LET's MANAGE : "+ ConsoleColors.RESET);
			System.out.println(ConsoleColors.RED_BOLD+"Please Choose Login Option As Per your Designation  : " + ConsoleColors.RESET);
			System.out.println("Press 1 to" +ConsoleColors.BLUE_BOLD + " LogIn as BDO." + ConsoleColors.RESET);
			System.out.println("Press 2 to" +ConsoleColors.BLUE_BOLD + " LogIn as Gram Panchayat Member."+ ConsoleColors.RESET);
			System.out.println("Press 3 to" +ConsoleColors.RED_BOLD_BRIGHT+" EXIT."+ ConsoleColors.RESET);
			String choice = sc.nextLine();
		
			if(choice.equals("1")) {
				
				 
				BdoMain bmain = new BdoMain();
				Boolean resultb = bmain.bdoLogin();
				
				int countBdoLogin =1;
				
				while(!resultb) {
					countBdoLogin++;
					System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + (4-countBdoLogin) +" Attempts remaining"+ ConsoleColors.RESET);
					resultb = bmain.bdoLogin();
					
					if(countBdoLogin ==3 && resultb ==false) {
						System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Maximum Limit Crossed : Try Again Later"+ ConsoleColors.RESET);
						break;
						
					}
				}
				
				if(resultb) {
					
					while(true) {
						
						bmain.bdoHomeWndow();
						
						String choiceBdo = sc.nextLine();
						
						if(choiceBdo.equals("1")) {
							bmain.createProject();
						}else if(choiceBdo.equals("2")) {
							bmain.viewListOfProject();
						}else if (choiceBdo.equals("3")) {
							bmain.createGPM();
						}else if(choiceBdo.equals("4")){
							bmain.viewListOfGPM();
						}else if(choiceBdo.equals("5")){
							bmain.allocateProjectToGPM();
						}else if(choiceBdo.equals("6")){
							bmain.listOfEmployee();
							 
						}else if(choiceBdo.equals("7")){
							System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "LOGOUT SUCCESSFUL !" + ConsoleColors.RESET);				
							break;
						}else {
							System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 7" + ConsoleColors.RESET);
						}
						
					}
					appOpening();
						
				}else {
					appOpening();
				}
				
			}else if(choice.equals("2")) {
				 
				GpmMain gpmMain = new GpmMain();
				Boolean resultg = gpmMain.GpmLogin();
				
				int countGpmLogin=1;
				while(!resultg) {
					countGpmLogin++;
					System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + (4-countGpmLogin) +" Attempts remaining"+ ConsoleColors.RESET);
					resultg = gpmMain.GpmLogin();
					
					if(countGpmLogin ==3 && resultg ==false) {
						System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Maximum Limit Crossed : Try Again Later"+ ConsoleColors.RESET);
						break;
						
					}
				}
				
				if(resultg) {
					
					while(true) {
						
						gpmMain.gpmWindow();
						
						String choiceGpm = sc.nextLine();
						
						if(choiceGpm.equals("1")) {
							gpmMain.createEmployee();
						}else if(choiceGpm.equals("2")) {
							gpmMain.displayEmployee();
						}else if(choiceGpm.equals("3")) {
							gpmMain.assignProjectToEmployee();
						}else if(choiceGpm.equals("4")) {
							gpmMain.dayWageTotal();
						}else if(choiceGpm.equals("5")) {
							System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "LOGOUT SUCCESSFUL !" + ConsoleColors.RESET);
							break;
						}else {
							System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 5" + ConsoleColors.RESET);
						}		
					}
					appOpening();
					
				}else {
					appOpening();
				}
				
				
			}else if(choice.equals("3")) {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "APPLICATION CLOSED : EXITED" + ConsoleColors.RESET);
				System.exit(0);
				
			}else {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 3" + ConsoleColors.RESET);
				appOpening();
				
			}
		
			}catch (InputMismatchException e){
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
			}catch (NoSuchElementException e) {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
			}
		
		
	}
	public static void main(String[] args) {
		appOpening();	
		
	}
		
	

}