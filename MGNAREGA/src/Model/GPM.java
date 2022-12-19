package Model;

public class GPM {
	    private int GPMId;
	     private String name;
	     private String username;
	     private String password;
		private int assignedProjectId;
	      
	     
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
		 
		this.assignedProjectId = assignedProjectId;
		 
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

	 

	public int getAssignedProjectId() {
		return assignedProjectId;
	}

	public void setAssignedProjectId(int assignedProjectId) {
		this.assignedProjectId = assignedProjectId;
	}
 

	@Override
	public String toString() {
		return "GPM [GPMId=" + GPMId + ", name=" + name + ", username=" + username + ", password=" + password
				  + ", assignedProjectId=" + assignedProjectId + "]";
	}
	 
	   
	     
}
