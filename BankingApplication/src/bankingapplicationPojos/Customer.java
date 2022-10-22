package bankingapplicationPojos;

public class Customer extends User{

	private int customerId;
	private long aadhaarNumber;
	private String panNumber;
	private String status;
	
	public void setCustomerId(int customerId) {
		this.customerId=customerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	
	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber=aadhaarNumber;
	}
	public long getAadhaarNumber() {
		return aadhaarNumber;
	}
	
	public void setPanNumber(String panNumber) {
		this.panNumber=panNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
    public String getStatus() {
    	return status;
    }
	
}
