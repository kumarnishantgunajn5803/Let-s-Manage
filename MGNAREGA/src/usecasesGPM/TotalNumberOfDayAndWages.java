package usecasesGPM;

import java.util.Scanner;

import Dao.GPMDao;
import Dao.GPMDaoImpl;
import Exception.EmployeeException;
import Model.DaysAndWagesOfEMployee;

public class TotalNumberOfDayAndWages {

	public static void totalNumberOfDayAndWages( ) {
		 Scanner s =  new Scanner(System.in);
		 System.out.println("Please Enter Employee Id :");
		 int empId = s.nextInt();
		 
		 GPMDao dao = new GPMDaoImpl();
		 
		 
		try {
			DaysAndWagesOfEMployee dw=  dao.viewTotalDaysAndWagesOfEMployee(empId);
			
			System.out.println("Total No. of Days Worked :"+dw.getDays());
			System.out.println("TOtal wages earned :"+dw.getWages());
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

}
