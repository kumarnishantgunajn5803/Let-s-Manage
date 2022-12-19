package Dao;

import java.util.List;

import Exception.BdoException;
import Exception.GpmException;
import Exception.ProjectException;
import Model.BDO;
import Model.Employee;
import Model.GPM;
import Model.Project;

public interface BdoDao {
	// Login into their account.
    public String loginBdo(String username,String password) throws BdoException;
    
    //create a project
    public String createProject(Project p) throws ProjectException;
    
    //view list of project
    
    public List<Project > viewListOfProjects() throws ProjectException;
    
    //create new GPM
    public String createGpmMember(GPM gpm) throws GpmException;
    
    //view all GPM
    
    public List<GPM> viewAllGpm()throws GpmException;
    
    //Allocate Project to Gpm
    
    public String allocateProjectToGpm(int pId, int GpmId)throws GpmException , ProjectException;
    
    //see the list of EMployee Working on the project
    
    public List<Employee> listOfEmployeeWorkingOnProject(int pid) throws ProjectException;
    
    
    
    
    
}
