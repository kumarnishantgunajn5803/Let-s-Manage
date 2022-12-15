package Model;

public class Employee {
     private int empid;
     private String name;
     private String username;
     private String password;
     private String address;
     private String phone;
     private int totalNoOfDaysWorked;
     private int projectId;
     private int GpmId;
     private int wages;
     
     public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empid, String name, String username, String password, String address, String phone,
			int totalNoOfDaysWorked, int projectId, int gpmId, int wages) {
		super();
		this.empid = empid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.totalNoOfDaysWorked = totalNoOfDaysWorked;
		this.projectId = projectId;
		GpmId = gpmId;
		this.wages = wages;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTotalNoOfDaysWorked() {
		return totalNoOfDaysWorked;
	}

	public void setTotalNoOfDaysWorked(int totalNoOfDaysWorked) {
		this.totalNoOfDaysWorked = totalNoOfDaysWorked;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getGpmId() {
		return GpmId;
	}

	public void setGpmId(int gpmId) {
		GpmId = gpmId;
	}

	public int getWages() {
		return wages;
	}

	public void setWages(int wages) {
		this.wages = wages;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", phone=" + phone + ", totalNoOfDaysWorked=" + totalNoOfDaysWorked
				+ ", projectId=" + projectId + ", GpmId=" + GpmId + ", wages=" + wages + "]";
	}
     
     
     
     
     
     
 }
