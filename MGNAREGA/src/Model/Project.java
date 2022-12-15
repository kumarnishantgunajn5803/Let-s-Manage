package Model;

public class Project {
   private int pId;
   private String name;
   private double budget;
   private int noOfEmpWorking;
   public Project() {
	// TODO Auto-generated constructor stub
}
public Project(int pId, String name, double budget, int noOfEmpWorking) {
	super();
	this.pId = pId;
	this.name = name;
	this.budget = budget;
	this.noOfEmpWorking = noOfEmpWorking;
}
public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getBudget() {
	return budget;
}
public void setBudget(double budget) {
	this.budget = budget;
}
public int getNoOfEmpWorking() {
	return noOfEmpWorking;
}
public void setNoOfEmpWorking(int noOfEmpWorking) {
	this.noOfEmpWorking = noOfEmpWorking;
}
@Override
public String toString() {
	return "Project [pId=" + pId + ", name=" + name + ", budget=" + budget + ", noOfEmpWorking=" + noOfEmpWorking + "]";
} 
   
}
