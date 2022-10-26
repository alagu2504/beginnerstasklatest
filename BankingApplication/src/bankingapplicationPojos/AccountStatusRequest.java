package bankingapplicationPojos;

public class AccountStatusRequest {

	private long accountNumber;
	private String description;
	private String status;

	public void setAccountNumber(long accountNumber) {
		this.accountNumber=accountNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setDescription(String description) {
		this.description=description;
	}
	public String getdescription() {
		return description;
	}

	public void setStatus(String status) {
		this.status=status;
	}
	public String getStatus() {
		return status;
	}
}
