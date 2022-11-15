package bankingapplicationPojos;

import java.sql.Timestamp;

public class Statements {

	private int transactionId;
	private long senderAccount;
	private long receiverAccount;
	private long transferAmount;
	private Timestamp time;
	private String transactionType;
	private int customerId;
	private String modeOfTransaction;
	
	public void setTransactionId(int transactionId) {
		this.transactionId=transactionId;
	}
	public int getTransactionId() {
		return transactionId;
	}
	
	public void setSenderAccount(long senderAccount) {
		this.senderAccount=senderAccount;
	}
	public long getSenderAccount() {
		return senderAccount;
	}
	
	public void setReceiverAccount(long receiverAccount) {
		this.receiverAccount=receiverAccount;
	}
	public long getReceiverAccount() {
		return receiverAccount;
	}
	
	public void setTransferAmount(long transferAmount) {
		this.transferAmount=transferAmount;
	}
	public long getTransferAmount() {
		return transferAmount;
	}
	
	public void setTime(long time) {
		this.time=new Timestamp(time) ;
	}
	public Timestamp getTime() {
		return time;
	}
	
	public void setTransactionType(String transactionType) {
		this.transactionType=transactionType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId=customerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	
	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction=modeOfTransaction;
	}
	public String getModeOfTransaction() {
		return modeOfTransaction;
	}
}
