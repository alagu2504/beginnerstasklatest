package bankingapplication;

import java.util.List;
import java.util.Map;

import bankingapplicationPojos.Account;
import bankingapplicationPojos.AccountStatusRequest;
import bankingapplicationPojos.Customer;
import bankingapplicationPojos.CustomerStatusRequest;
import bankingapplicationPojos.Statements;
import bankingapplicationPojos.TransactionRequest;
import bankingapplicationPojos.User;
import customexceptionpackage.CustomException;

public interface StorageLayerInterface {
	
	Map<Integer,User> getUserDetails();

	 void insertUsersDetails(User user);
	
	 Map<Integer,Customer> getCustomerDetails();

	 void insertCustomerDetails(Customer customer);

     void updateCustomerStatus(int customerId,String requestStatus,String customerStatus);
	 
	 void customerStatusRequest(CustomerStatusRequest request);
	 
	 int getCustomerId(long accountNumber);

	 
	 Map<Integer,Map<Long,Account>> getAllAccountDetailsOfCustomer();

	
	 void insertAccountDetails(Account account) ;
	 
	 void accountStatusRequest(AccountStatusRequest request) ;
	 
	 List<AccountStatusRequest> getAllAccountStatusRequest();
	 
	 Map<Integer,CustomerStatusRequest> getAllCustomerStatusRequest();
	 
	 void updateAccountStatus(Account account,String status,String requestStatus) ;
	 
     void changeInfo(Customer customer)  throws CustomException;
		
	 void updateBalance(long accountNumber,long finalAmount);

	 void transactionRequest(TransactionRequest request) ;
	
	 List<Statements> getStatements(int customerId,long accountNumber);

	 Map<Long,Map<Integer,Statements>> getAllTransactionStatements();

	 void updateTransactionStatement(Statements statementObject) ;
	
	 void updateTransactionRequest(TransactionRequest requestPojoObject,String requestStatus);

	 Map<Integer,TransactionRequest> getAllTransactionRequest();

   
	
	
	
	
	
	


	
	
	





}
