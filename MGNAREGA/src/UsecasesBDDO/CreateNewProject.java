package UsecasesBDDO;

import java.util.Scanner;

import Dao.BdoDao;
import Dao.BdoDaoImpl;
import Exception.ProjectException;
import Model.Project;

public class CreateNewProject {

	public static void createNewProject( ) {
		 Scanner s = new Scanner(System.in);
		 System.out.println("Enter Name of Project:");
		 String name = s.nextLine();
		 System.out.println("Enter budget of Project.");
		 
		 Double budget = s.nextDouble();
		 
		 Project project = new Project();
		 project.setName(name);
		 project.setBudget(budget);
		 
		 BdoDao dao = new BdoDaoImpl();
		 try {
			    String res= dao.createProject(project);
			System.out.println(res);
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}

	}

}
