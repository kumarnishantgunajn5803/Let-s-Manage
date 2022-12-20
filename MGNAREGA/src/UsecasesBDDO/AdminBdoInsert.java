package UsecasesBDDO;

import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminImpl;
import Exception.BdoException;
import Model.BDO;

public class AdminBdoInsert {

	public static void AddBDO( ) {
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter Name of BDO");
		 String name = s.nextLine();
		 System.out.println("Enter usename of BDO");
		 String username = s.next();
		 System.out.println("Enter password:");
		 String password = s.next();
		 
		 
		 BDO bdo = new BDO();
		 bdo.setName(name);
		 bdo.setUsername(username);
		 bdo.setPassword(password);
		 
		 AdminDao  dao = new AdminImpl();
		 
		 try {
		 
			System.out.println(dao.addBdo(bdo));
		} catch (BdoException e) {
			 System.out.println(e.getMessage());
		}
		 

	}

}
