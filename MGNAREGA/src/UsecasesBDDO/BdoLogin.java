package UsecasesBDDO;

import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminImpl;
import Dao.BdoDao;
import Dao.BdoDaoImpl;
import Exception.BdoException;

public class BdoLogin {

	public static boolean BDOLogin( ) {
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter usename of BDO");
		 String username = s.next();
		 System.out.println("Enter password:");
		 String password = s.next();
		  
		 BdoDao dao = new BdoDaoImpl();
		 try {
			String res = dao.loginBdo(username, password);
			System.out.println(res);
			
			return true;
			
		} catch (BdoException e) {
			System.out.println(e.getMessage());
			return false;
		}
		 
        
	}

}
