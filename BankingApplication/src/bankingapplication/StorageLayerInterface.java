package bankingapplication;

import java.util.List;
import java.util.Map;

import bankingapplicationPojos.Account;
import bankingapplicationPojos.Customer;
import bankingapplicationPojos.Statement;
import bankingapplicationPojos.TransactionRequest;
import bankingapplicationPojos.User;
import customexceptionpackage.CustomException;

public interface StorageLayerInterface {
	
	Map<Integer,User> getUserDetails();

	 void insertUsersDetails(User userPojoObject);
	
	 Map<Integer,Customer> getCustomerDetails();

	 void insertCustomerDetails(Customer customerPojoObject);

	 void changeCustomerStatus(int customerId,String status) ;
	 
	 
	 int getCustomerId(long accountNumber);

	 
	 Map<Integer,Map<Long,Account>> getAllAccountDetailsOfCustomer();

	
	 void insertAccountDetails(Account accountPojoObject) ;

	 void changeAccountStatus(int customerId,String status) ;
	 
     void changeInfo(Customer customer)  throws CustomException;
		
	 void updateBalance(long accountNumber,long finalAmount);

	 void transactionRequest(TransactionRequest requestPojoObject) ;
	
	 List<Statement> getStatements(int customerId,long accountNumber);

	 Map<Long,Map<Integer,Statement>> getAllTransactionStatements();

	 void updateTransactionStatement(Statement StatementObject) ;
	
	 void updateTransactionRequest(TransactionRequest requestPojoObject,String requestStatus);

	 Map<Integer,TransactionRequest> getAllTransactionRequest();

   
	
	
	
	
	
	


	
	
	





}
