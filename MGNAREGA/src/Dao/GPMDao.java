package Dao;

import Exception.EmployeeException;
import Exception.GpmException;
import Exception.ProjectException;
import Model.DaysAndWagesOfEMployee;
import Model.Employee;

public interface GPMDao {
 // Login to Gpm Account
	
	public String  loginGpm(String username, String password) throws GpmException;
	
	//create EMployee
	
	public String createEmployee(Employee employee)throws EmployeeException;
	
	
	//view details of employee
	
   public Employee viewEmpDetail(int empId)throws EmployeeException;
   
   //Assign Employee a project
   
   public String assignPorjectToEmployee(int pId, int empId)throws EmployeeException, ProjectException;
   
   //. View total number of days Employee worked in a project and also their wages.
   
   public DaysAndWagesOfEMployee viewTotalDaysAndWagesOfEMployee(int empId)throws EmployeeException;
	
	
	
}
