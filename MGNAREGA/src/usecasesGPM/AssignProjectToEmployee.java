package usecasesGPM;

import java.util.Scanner;

import Dao.GPMDao;
import Dao.GPMDaoImpl;
import Exception.EmployeeException;
import Exception.ProjectException;

public class AssignProjectToEmployee {

	public static void assignProjectTOEmployee( ) {
		 Scanner s =  new Scanner(System.in);
		 System.out.println("Please Enter Employee Id :");
		 int empId = s.nextInt();
		 System.out.println("Please Enter Project Id :");
		 int pId = s.nextInt();
		 
		 GPMDao dao = new GPMDaoImpl();
		 
		try {
			String ans = dao.assignPorjectToEmployee(pId, empId);
			System.out.println(ans);
		} catch (EmployeeException | ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

}
