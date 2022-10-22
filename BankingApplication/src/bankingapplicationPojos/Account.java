package bankingapplicationPojos;

public class Account {

	private long  accountNumber;
	private String accountType;
	private String ifscCode;
	private String branchName;
	private long balance;
	private int customerId;
	private String status;
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber=accountNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountType(String accountType) {
		this.accountType=accountType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode=ifscCode;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
	public String getStatus() {
		return status;
	}
	
	public void setBranchName(String branchName) {
		this.branchName=branchName;
	}
	public String getBranchName() {
		return branchName;
	}
	
	public void setBalance(long balance) {
		this.balance=balance;
	}
	public long getBalance() {
		return balance;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId=customerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	
}
