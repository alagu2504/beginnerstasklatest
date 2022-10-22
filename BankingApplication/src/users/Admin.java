package users;

import java.util.Map;
import java.util.Scanner;

import bankingapplicationPojos.Account;
import bankingapplicationPojos.Customer;
import bankingapplicationPojos.Statement;
import bankingapplicationPojos.TransactionRequest;
import bankingapplicationPojos.User;

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
    
    public void changeAccountStatus(int userId,String status) {
    	storageLayerObject.changeAccountStatus(userId,status);
    }
    
    public void changeCustomerStatus(int customerId,String status) {
    	storageLayerObject.changeCustomerStatus(customerId,status);
    }
    
    public Map<Integer,TransactionRequest> getAllRequestStatements(){
    	return storageLayerObject.getAllTransactionRequest();
    }
    
    public void updateTransactionRequest(TransactionRequest requestPojoObject,boolean accept) {
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
    
	

}
