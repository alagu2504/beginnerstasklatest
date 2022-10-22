package bankingapplicationPojos;

public class User {
	
private int userId;
private String userName;
private String dateOfBirth;
private long mobileNumber;
private String address;
private String emailId;
private String password;
private String role;

public void setUserId(int userId) {
	this.userId=userId;
}
public int getUserId() {
	return userId;
}

public void setUserName(String userName) {
	this.userName=userName;
}
public String getUserName() {
	return userName;
}
public void setDataOfBirth(String dateOfBirth) {
	this.dateOfBirth=dateOfBirth;
}
public String getDataOfBirth() {
	return dateOfBirth;
}

public void setMobileNumber(long mobileNumber) {
	this.mobileNumber=mobileNumber;
}
public long getMobileNumber() {
	return mobileNumber;
}

public void setAddress(String address) {
	this.address=address;
}
public String getAddress() {
	return address;
}

public void setEmailId(String emailId) {
	this.emailId=emailId;
}
public String getEmailId() {
	return emailId;
}

public void setPassword(String password) {
	this.password=password;
}
public String getPassword() {
	return password;
}

public void setRole(String role) {
	this.role=role;
}
public String getRole() {
	return role;
}

}
