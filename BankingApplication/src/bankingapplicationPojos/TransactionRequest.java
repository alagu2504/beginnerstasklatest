package bankingapplicationPojos;

public class TransactionRequest {

	private int requestId;
	private long senderAccountNumber;
	private long receiverAccountNumber;
	private long transferAmount;
	private String requestStatus;
	
	public void setRequestId(int requestId) {
		this.requestId=requestId;
	}
	public int getRequestId() {
		return requestId;
	}
	
	public void setSenderAccountNumber(long senderAccountNumber) {
		this.senderAccountNumber=senderAccountNumber;
	}
	public long getSenderAccountNumber() {
		return senderAccountNumber;
	}
	
	public void setReceiverAccountNumber(long receiverAccountNumber) {
		this.receiverAccountNumber=receiverAccountNumber;
	}
	public long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}
	
	public void setTransferAmount(long transferAmount) {
		this.transferAmount=transferAmount;
	}
	public long getTransferAmount() {
		return transferAmount;
	}
	
	public void setRequestStatus(String requestStatus) {
		this.requestStatus=requestStatus;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
}
