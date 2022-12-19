package Model;

public class DaysAndWagesOfEMployee {
     private  int days;
     private int wages;
    
    public DaysAndWagesOfEMployee() {
		// TODO Auto-generated constructor stub
	}

	public DaysAndWagesOfEMployee(int days, int wages) {
		super();
		this.days = days;
		this.wages = wages;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getWages() {
		return wages;
	}

	public void setWages(int wages) {
		this.wages = wages;
	}

	@Override
	public String toString() {
		return "DaysAndWagesOfEMployee [days=" + days + ", wages=" + wages + "]";
	}
    
    
   
}
