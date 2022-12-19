package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.PrinterLocation;

import DBUtil.DBUtility;
import Exception.EmployeeException;
import Exception.GpmException;
import Exception.ProjectException;
import Model.DaysAndWagesOfEMployee;
import Model.Employee;

public class GPMDaoImpl implements GPMDao{

	@Override
	public String loginGpm(String username, String password) throws GpmException {
		String message = "Wrong Credentials.";
		
		try (Connection conn = DBUtility.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from GPM where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				message="Login Successfully.";
				
			} 
			
		} catch (SQLException e) {
			
			throw new GpmException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String createEmployee(Employee employee) throws EmployeeException {
String message = "Something went wrong.";
		
		try (Connection conn = DBUtility.getConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into employee(Name,username,password,address,phone,wages) values(?,?,?,?,?,?)");
		ps.setString(1, employee.getName());
		ps.setString(2, employee.getUsername());
		ps.setString(3, employee.getPassword());
		ps.setString(4, employee.getAddress());
		ps.setString(5, employee.getPhone());
		ps.setInt(6,employee.getWages());
		
		int x = ps.executeUpdate();
		if(x>0) {
			message="Employee Added Successfully.";
		}
			
			
			
		} catch (SQLException e) {
			
		throw new EmployeeException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public Employee viewEmpDetail(int empId) throws EmployeeException {
		 Employee employee = new Employee();
		 try (Connection conn = DBUtility.getConnection()){
			 PreparedStatement ps = conn.prepareStatement("select * from Employee where empId=?");
			 ps.setInt(1, empId);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 employee.setEmpid(rs.getInt("empId"));
				 employee.setName(rs.getString("Name"));
				 employee.setUsername(rs.getString("username"));
				 employee.setPassword(rs.getString("password"));
				 employee.setAddress(rs.getString("address"));
				 employee.setPhone(rs.getString("phone"));
				 employee.setTotalNoOfDaysWorked(rs.getInt("totalNoOfDayWorked"));
				 employee.setProjectId(rs.getInt("projectId"));
				 employee.setWages(rs.getInt("wages"));
				 
				 
				 
			 }else {
				 throw new EmployeeException("Employee Doesn't Exist with empId "+empId);
			 }
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		 
		 
		 return employee;
	}

	@Override
	public String assignPorjectToEmployee(int pId, int empId) throws EmployeeException, ProjectException {
		String message ="";
		 int n=0;
		 
		 try(Connection conn = DBUtility.getConnection()){
			 PreparedStatement ps1 = conn.prepareStatement("select * from Employee where empId=?");
			 ps1.setInt(1, empId);
		  ResultSet rs1 =	ps1.executeQuery(); 
			 if(rs1.next()) {
				 PreparedStatement ps2 = conn.prepareStatement("select * from Project where pId=?");
				 ps2.setInt(1, pId);
				 ResultSet rs2 =	ps2.executeQuery();
				 if(rs2.next()) {
					n=rs2.getInt("NoOfEmpWorking"); 
				PreparedStatement ps3 = conn.prepareStatement(" update Employee set  projectId=? where empId=?"); 
				
				ps3.setInt(1, pId);
				ps3.setInt(2, empId);
				
				 
				
				int x = ps3.executeUpdate();
				if(x>0  ) {
					
					 PreparedStatement ps4 = conn.prepareStatement("update Project set NoOfEmpWorking = ? where pId = ?");
 					 
 						ps4.setInt(1, n+1);
 			         		ps4.setInt(2, pId);
 						  ps4.executeUpdate();
					 message="Project Assigned Successfully.";
					
					 
				}
					 
					 
				 }else {
					 throw new ProjectException("Project Doesn't Exist with ProjectID "+pId);
				 }
				 
			 }else {
				 throw new EmployeeException("Employee Doesn't Exist with Employee ID "+empId);
			 }
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		 
 
		 
		 return message;
	}

	@Override
	public DaysAndWagesOfEMployee viewTotalDaysAndWagesOfEMployee(int empId) throws EmployeeException {
		DaysAndWagesOfEMployee dw = new DaysAndWagesOfEMployee();
		try (Connection conn = DBUtility.getConnection()){
			 PreparedStatement ps = conn.prepareStatement("select * from Employee where empId=?");
			 ps.setInt(1, empId);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
			    int days=rs.getInt("totalNoOfDayWorked");
				 dw.setDays(days);
				  
				 dw.setWages(days*rs.getInt("wages"));
				 
				 
				 
			 }else {
				 throw new EmployeeException("Employee Doesn't Exist with empId "+empId);
			 }
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		 
			
			
		 
		return dw;
	}

}
