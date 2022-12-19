package UsecasesBDDO;

import java.util.Scanner;

import Dao.BdoDao;
import Dao.BdoDaoImpl;
import Exception.GpmException;
import Exception.ProjectException;

public class AllocateProjectToGPm {

	public static void allocateProjectToGpm( ) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter GpmId");
		int GPMId = s.nextInt();
		System.out.println("Please Enter ProjectId");
		int pId = s.nextInt();
		
		BdoDao dao = new BdoDaoImpl();
		 try {
			 String rs = dao.allocateProjectToGpm(pId, GPMId);
			 System.out.println(rs);
		} catch (GpmException | ProjectException e) {
			System.out.println(e.getMessage());
		}
		 s.close();

	}

}
