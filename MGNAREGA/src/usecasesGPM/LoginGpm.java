package usecasesGPM;

import java.util.Scanner;

 
import Dao.GPMDao;
import Dao.GPMDaoImpl;
 
import Exception.GpmException;

public class LoginGpm {

	public static boolean LoginGPM( ) {
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter usename of GPM");
		 String username = s.next();
		 System.out.println("Enter password:");
		 String password = s.next();
		 
		 GPMDao dao = new GPMDaoImpl();
		 try {
			String res = dao.loginGpm(username, password);
			System.out.println(res);
			
			return true;
		} catch (GpmException e) {
			System.out.println(e.getMessage());
			
			return false;
		}
	}

}
