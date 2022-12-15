package Model;

public class GPM {
	    private int GPMId;
	     private String name;
	     private String username;
	     private String password;
	     private String email;
	     private int assignedProjectId;
	     private int BdoId;
	     
	 public GPM() {
		// TODO Auto-generated constructor stub
	}

	public GPM(int gPMId, String name, String username, String password, String email, int assignedProjectId,
			int bdoId) {
		super();
		GPMId = gPMId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.assignedProjectId = assignedProjectId;
		BdoId = bdoId;
	}

	public int getGPMId() {
		return GPMId;
	}

	public void setGPMId(int gPMId) {
		GPMId = gPMId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAssignedProjectId() {
		return assignedProjectId;
	}

	public void setAssignedProjectId(int assignedProjectId) {
		this.assignedProjectId = assignedProjectId;
	}

	public int getBdoId() {
		return BdoId;
	}

	public void setBdoId(int bdoId) {
		BdoId = bdoId;
	}

	@Override
	public String toString() {
		return "GPM [GPMId=" + GPMId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", assignedProjectId=" + assignedProjectId + ", BdoId=" + BdoId + "]";
	}
	 
	   
	     
}
