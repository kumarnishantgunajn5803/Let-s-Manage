package UsecasesBDDO;

import java.util.Scanner;

import Dao.BdoDao;
import Dao.BdoDaoImpl;
import Exception.GpmException;
import Model.GPM;

public class CreateNewGpm {
      public static void createNewGPM( ) {
    	  Scanner s = new Scanner(System.in);
 		 System.out.println("Enter Name of GPM");
 		 String name = s.nextLine();
 		 System.out.println("Enter username of GPM:");
 		 String username = s.nextLine();
 		 System.out.println("Enter Password of GPM");
 		 String password = s.nextLine();
 		  
 		 
 		 GPM gpm = new GPM();
 		 gpm.setName(name);
 		 gpm.setUsername(username);
 		 gpm.setPassword(password);
 		 
 		 BdoDao dao= new BdoDaoImpl();
 		 
 		 try {
		String res =	dao.createGpmMember(gpm);
			System.out.println(res);
		} catch (GpmException e) {
			System.out.println(e.getMessage());
		}
	}
}
