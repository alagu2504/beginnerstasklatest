package bankingapplicationPojos;

public class CustomerStatusRequest {
	
private int customerId;
private String description;
private String status;

public void setCustomerId(int customerId) {
	this.customerId=customerId;
}
public int getCustomerId() {
	return customerId;
}

public void setDescription(String description) {
	this.description=description;
}
public String getDescription() {
	return description;
}

public void setStatus(String status) {
	this.status=status;
}
public String getStatus() {
	return status;
}

}
