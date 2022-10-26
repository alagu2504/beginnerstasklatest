package users;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bankingapplicationPojos.Account;
import bankingapplicationPojos.AccountStatusRequest;
import bankingapplicationPojos.Customer;
import bankingapplicationPojos.CustomerStatusRequest;
import bankingapplicationPojos.Statement;
import bankingapplicationPojos.TransactionRequest;
import bankingapplicationPojos.User;
import customexceptionpackage.CustomException;

public class Admin extends Operations {
	
    Scanner scanner=new Scanner(System.in);

	
	
	public  Map<Integer,Customer> getAllCustomerDetails(){
		return storageLayerObject.getCustomerDetails();
	}
	
	
	public Map<Long,Map<Integer,Statement>>getAllStatements(){
		return storageLayerObject.getAllTransactionStatements();
	}
	
	public Map<Integer,Map<Long,Account>> getAllAccountDetailsOfCustomer(){
		return storageLayerObject.getAllAccountDetailsOfCustomer();
	}

	

	public Map<Integer,User> getAllUsersDetails(){
	return storageLayerObject.getUserDetails();	
	}
	
    public void insertNewUsers(User userPojoObject) {
    	storageLayerObject.insertUsersDetails(userPojoObject);
    }
    
    public void insertCustomerDetails(Customer cutomerPojoObject) {
    	storageLayerObject.insertCustomerDetails(cutomerPojoObject);
    }
    
    public void insertAccountInfo(Account accountPojo) {
    	storageLayerObject.insertAccountDetails(accountPojo);
    }
    
    
    public Map<Integer,CustomerStatusRequest> getAllCustomerStatusRequest(){
    	return storageLayerObject.getAllCustomerStatusRequest();
    }
    
    public Map<Integer,TransactionRequest> getAllRequestStatements(){
    	return storageLayerObject.getAllTransactionRequest();
    }
    
    public void updateTransactionRequest(TransactionRequest requestPojoObject,boolean accept) throws CustomException {
    	String requestStatus;
    	if(accept) {
    		requestStatus="Accepted";
    		executeTransaction(requestPojoObject);
    	}
    	else {
    		requestStatus="Rejected";
    	}
    	storageLayerObject.updateTransactionRequest(requestPojoObject, requestStatus);
    }
    
	public void updateCustomerStatus(int customerId,boolean status,String customerStatus) {
		String requestStatus;
    	if(status) {
    		requestStatus="Accepted";
    	}
    	else {
    		requestStatus="Rejected";
    	}
		storageLayerObject.updateCustomerStatus(customerId, requestStatus, customerStatus);
	}
	
	public List<AccountStatusRequest> getAllAccountStatusRequest(){
		return storageLayerObject.getAllAccountStatusRequest();
	}	
	public void updateAccountStatus(Account account,boolean status,String accountStatus) {
		String requestStatus;
    	if(status) {
    		requestStatus="Accepted";
    	}
    	else {
    		requestStatus="Rejected";
    	}
    	storageLayerObject.updateAccountStatus(account, accountStatus, requestStatus);
	}

}
