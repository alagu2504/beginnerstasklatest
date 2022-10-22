package jdbctask;

public class JdbcPojo {
	String employeeName;
	String mobileNumber;
	String emailId;
	String department;
	int range;
	
	
	public void setEmployeeName(String name) {
		this.employeeName=name;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber=mobileNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setEmailId(String emailId) {
		this.emailId=emailId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setDepartment(String department) {
		this.department=department;
	}
	public String getDepartment() {
		return department;
	}
	public void setRange(int range) {
		this.range=range;
	}
	public int getRange() {
		return range;
	}
}
