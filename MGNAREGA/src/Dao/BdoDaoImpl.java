package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtility;
import Exception.BdoException;
import Exception.EmployeeException;
import Exception.GpmException;
import Exception.ProjectException;
import Model.BDO;
import Model.Employee;
import Model.GPM;
import Model.Project;

public class BdoDaoImpl implements BdoDao {

	@Override
	public String loginBdo(String username,String password) throws BdoException {
		String message = "Wrong Credentials";
		
		try(Connection conn = DBUtility.getConnection()) {
   PreparedStatement ps = conn.prepareStatement("select * from bdo where username=? and password=?");	
   
   ps.setString(1, username);
   ps.setString(2, password);
      
   
            ResultSet rs =  ps.executeQuery();
            if(rs.next()) {
            	message = "Login successfully..";
            } 
		   
	 	
		} catch (SQLException e) {
		  e.printStackTrace();
		  message = e.getMessage();
		}
		 
		return message;
	}

	@Override
	public String createProject(Project p) throws ProjectException {
		 String message = "Wrong details..";
		 
		 try(Connection conn = DBUtility.getConnection()) {
			 
			 PreparedStatement  ps = conn.prepareStatement("insert into project(Name,budget, NoOfEmpWorking ) values(?,?,0)");
			 ps.setString(1, p.getName());
			 ps.setDouble(2, p.getBudget());
			  
			 
			 int x = ps.executeUpdate();
			 if(x>0) {
				 message ="Project Created Successfully.";
			 }
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}
		 
		 
		 
		 
		 
		 return message;
	}

	@Override
	public String createGpmMember(GPM gpm) throws GpmException {
 String message = "Wrong details..";
		 
		 try(Connection conn = DBUtility.getConnection()) {
			 
			 PreparedStatement  ps = conn.prepareStatement("insert into gpm(Name,username,password) values( ?,?,? )");
			 ps.setString(1, gpm.getName());
			 ps.setString(2,gpm.getUsername());
			 ps.setString(3, gpm.getPassword());
			 
			  
			  
			 
			 int x = ps.executeUpdate();
			 if(x>0) {
				 message ="Project Created Successfully.";
			 } 
			
		} catch (SQLException e) {
			 
			 
			throw new GpmException("Username Already Exist");
		}
		 
		 
		 
		 
		 
		 return message;
	}

	@Override
	public List<GPM> viewAllGpm() throws GpmException {
		List<GPM> gpms= new ArrayList<>();
		
		 
		 try(Connection conn = DBUtility.getConnection()) {
			 
			 PreparedStatement  ps = conn.prepareStatement("select * from gpm");
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 GPM  gpm = new GPM();
				 gpm.setGPMId(rs.getInt("GPMId"));
				 gpm.setName(rs.getString("Name"));
				 gpm.setUsername(rs.getString("username"));
				 gpm.setPassword(rs.getString("password"));
				 gpm.setAssignedProjectId(rs.getInt("assignedProjectId"));
				 gpms.add(gpm);
				 
			 }
			  
			  
			 
			 
			
		} catch (SQLException e) {
			 
			 
			throw new GpmException(e.getMessage());
		}
		 
		 if(gpms.size()==0) {
			 throw new GpmException("No Gpm Available");
		 }
		 
		
		
		
		
		return gpms;
	}

	@Override
	public String allocateProjectToGpm(int pId, int GpmId) throws GpmException, ProjectException {
		 String message ="";
		 try(Connection conn = DBUtility.getConnection()){
			 PreparedStatement ps1 = conn.prepareStatement("select * from GPM where GPMId=?");
			 ps1.setInt(1, GpmId);
		  ResultSet rs1 =	ps1.executeQuery(); 
			 if(rs1.next()) {
				 PreparedStatement ps2 = conn.prepareStatement("select * from Project where pId=?");
				 ps2.setInt(1, pId);
				 ResultSet rs2 =	ps2.executeQuery();
				 if(rs2.next()) {
				PreparedStatement ps3 = conn.prepareStatement(" update gpm set assignedProjectId=? where GPMId=?"); 
				ps3.setInt(1, pId);
				ps3.setInt(2, GpmId);
				
				int x = ps3.executeUpdate();
				if(x>0) {
					message="Project Assigned Successfully.";
				}
					 
					 
				 }else {
					 throw new ProjectException("Project Doesn't Exist.");
				 }
				 
			 }else {
				 throw new GpmException("GPM Doesn't Exist.");
			 }
			
		} catch (SQLException e) {
			throw new GpmException(e.getMessage());
		}
		 
		 
		 
		 return message;
	}

	@Override
	public List<Employee> listOfEmployeeWorkingOnProject(int pId) throws ProjectException {
		List<Employee> employees= new ArrayList<>();
		
		 
		 try(Connection conn = DBUtility.getConnection()) {
			 
			 PreparedStatement ps2 = conn.prepareStatement("select * from Project where pId=?");
			 ps2.setInt(1, pId);
			 ResultSet rs2 =	ps2.executeQuery();
			 if(rs2.next()) {
			     
				 PreparedStatement  ps = conn.prepareStatement("select * from Employee where projectId =?");
				 ps.setInt(1, pId);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()) {
					 Employee employee = new Employee();
					 employee.setEmpid(rs.getInt("empId"));
					 employee.setName(rs.getString("Name"));
					 employee.setUsername(rs.getString("username"));
					 employee.setPassword(rs.getString("password"));
					 employee.setAddress(rs.getString("address"));
					 employee.setPhone(rs.getString("phone"));
					 employee.setTotalNoOfDaysWorked(rs.getInt("totalNoOfDayWorked"));
					 employee.setProjectId(rs.getInt("projectId"));
					 employee.setWages(rs.getInt("wages"));
					 employees.add(employee);
					 
					 
				 }
				 
			 }else {
				 throw new ProjectException("Project Doesn't Exist.");
			 }
			 
			
			  
			  
			 
			 
			
		} catch (SQLException e) {
			 
			 
			throw new ProjectException(e.getMessage());
		}
		 
		 if(employees.size()==0) {
			 throw new ProjectException("No Employee Is Working On The Project.");
		 }
		 
		
		
		
		
		return employees;
	}

	@Override
	public List<Project> viewListOfProjects() throws ProjectException {
		List<Project> projects= new ArrayList<>();
		
		 
		 try(Connection conn = DBUtility.getConnection()) {
			 
			 PreparedStatement  ps = conn.prepareStatement("select * from Project");
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 Project project = new Project();
				 project.setpId(rs.getInt("pId"));
				 project.setName(rs.getString("Name"));
				 project.setBudget(rs.getDouble("budget"));
				 project.setNoOfEmpWorking(rs.getInt("NoOfEmpWorking"));
				 projects.add(project);
				 
			 }
			  
			  
			 
			 
			
		} catch (SQLException e) {
			 
			 
			throw new ProjectException(e.getMessage());
		}
		 
		 if(projects.size()==0) {
			 throw new ProjectException("No Project Available");
		 }
		 
		
		
		
		
		return projects;
	}

}
