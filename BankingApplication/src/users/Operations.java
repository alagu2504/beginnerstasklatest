package users;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bankingapplication.BankingApplicationStorage;
import bankingapplication.StorageLayerInterface;
import bankingapplicationPojos.Account;
import bankingapplicationPojos.Customer;
import bankingapplicationPojos.Statement;
import bankingapplicationPojos.TransactionRequest;
import bankingapplicationPojos.User;
import customcheck.CustomCheck;
import customexceptionpackage.CustomException;

public class Operations {

	StorageLayerInterface storageLayerObject=new BankingApplicationStorage();
	Logger logger=Logger.getLogger(Operations.class.getName());
	
	public boolean loginMethod(long accountNumber,String password) throws ClassNotFoundException, SQLException, CustomException {
		CustomCheck.isNull(password);

		Map<Integer,User>allUsersDetails = storageLayerObject.getUserDetails();
		User userPojoObject=allUsersDetails.get(storageLayerObject.getCustomerId(accountNumber));
		if(userPojoObject==null) {
			throw new CustomException("Given Account Number is doesn't Match!");
		}
		if(!password.equals(userPojoObject.getPassword())) {
			logger.info("Given  password is incorrect!");
			return false;
		}
		return true;
	}//end of login method
	
	
	public void depositMethod(long depositeAmount,long accountNumber) {
		Account accountPojoObject=getAccountDetails(accountNumber);
        long currentBalance=accountPojoObject.getBalance();
        long finalAmount=currentBalance+depositeAmount;
        storageLayerObject.updateBalance(accountNumber, finalAmount);
        
        Statement statementObject=new Statement();
        statementObject.setReceiverAccount(accountNumber);
        statementObject.setTransferAmount(depositeAmount);
        statementObject.setTime(System.currentTimeMillis());
        statementObject.setCustomerId(accountPojoObject.getCustomerId());
        statementObject.setTransactionType("Debit");
		storageLayerObject.updateTransactionStatement(statementObject);
	}
	
	
	public void withdrawMethod(long withdrawAmount,long accountNumber) {
		Account accountPojoObject=getAccountDetails(accountNumber);
        long currentBalance=accountPojoObject.getBalance();
        if(currentBalance<withdrawAmount) {
        logger.info("Overdraft");
        }
        TransactionRequest requestPojoObject=new TransactionRequest();
        requestPojoObject.setSenderAccountNumber(accountNumber);
        requestPojoObject.setTransferAmount(withdrawAmount);
        requestPojoObject.setRequestStatus("Waiting");
        storageLayerObject.transactionRequest(requestPojoObject);
	}//end of withdraw Method
	
	
public void executeTransaction(TransactionRequest requestPojoObject) {
	
	Account accountPojo=getAccountDetails(requestPojoObject.getSenderAccountNumber());
		long Balance=accountPojo.getBalance();
		Balance=Balance-requestPojoObject.getTransferAmount();
		storageLayerObject.updateBalance(requestPojoObject.getSenderAccountNumber(), Balance);
		
		Statement statementObject=new Statement();
		statementObject.setCustomerId(accountPojo.getCustomerId());
		statementObject.setSenderAccount(requestPojoObject.getSenderAccountNumber());
		statementObject.setReceiverAccount(requestPojoObject.getReceiverAccountNumber());
		statementObject.setTransferAmount(requestPojoObject.getTransferAmount());
		statementObject.setTime(System.currentTimeMillis());
		statementObject.setCustomerId(accountPojo.getCustomerId());
		statementObject.setTransactionType("Credit");
		
		
		storageLayerObject.updateTransactionStatement(statementObject);
	}
	
	
	public String transactionMethod(long senderAccountNumber,long receiverAccountNumber,long transferAmount,String password) throws CustomException {
		CustomCheck.isNull(password);
		Account senderAccount=getAccountDetails(senderAccountNumber);
		Account receiverAccount=getAccountDetails(receiverAccountNumber);
		Map<Integer,User>allUsersDetails = storageLayerObject.getUserDetails();
		User sendersUserDetails=allUsersDetails.get(senderAccount.getCustomerId());	
		long senderBalance=senderAccount.getBalance();
		
		if(receiverAccount.getAccountNumber()!=receiverAccountNumber) {
			return "Given Account Number is incorrect !";
		}
		else if(!password.equals(sendersUserDetails.getPassword())) {
			return "Enter the Correct Password !";
		}
		else if(senderBalance<transferAmount) {
			return "Overdraft";
		}
		senderBalance=senderBalance-transferAmount;
		long receiverBalance=receiverAccount.getBalance()+transferAmount;
		storageLayerObject.updateBalance(senderAccountNumber, senderBalance);
		storageLayerObject.updateBalance(receiverAccountNumber, receiverBalance);
		Map<Integer,Customer> allCustomerDetails=storageLayerObject.getCustomerDetails();
		Customer senderCustomerObject=allCustomerDetails.get(senderAccount.getCustomerId());
		Customer receiverCustomerObject=allCustomerDetails.get(receiverAccount.getCustomerId());
		
		Statement senderStatementObject=new Statement();
		senderStatementObject.setCustomerId(senderCustomerObject.getCustomerId());
		senderStatementObject.setSenderAccount(senderAccountNumber);
		senderStatementObject.setReceiverAccount(receiverAccountNumber);
		senderStatementObject.setTransferAmount(transferAmount);
		long time=System.currentTimeMillis();
		senderStatementObject.setTime(time);
		senderStatementObject.setTransactionType("Debit");
		
		Statement receiverStatementObject=new Statement();
		receiverStatementObject.setCustomerId(receiverCustomerObject.getCustomerId());
		receiverStatementObject.setSenderAccount(senderAccountNumber);
		receiverStatementObject.setReceiverAccount(receiverAccountNumber);
		receiverStatementObject.setTransferAmount(transferAmount);
		receiverStatementObject.setTime(time);
		receiverStatementObject.setTransactionType("Credit");
		
		
		storageLayerObject.updateTransactionStatement(senderStatementObject);
		storageLayerObject.updateTransactionStatement(receiverStatementObject);
		return "Transaction Completed";
	}//end of transactionMethod
	
	
	
	public long checkBalance(long accountNumber) {
		Account accountPojoObject=getAccountDetails(accountNumber);
		return accountPojoObject.getBalance();
	}
	
	
	public String changePassword(long currentAccount,long accountNumber,String newPassword) throws CustomException {

		Pattern passwordPattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%&]).{8,32}$");
		   Matcher matcherObject = passwordPattern.matcher(newPassword);
		   if(!matcherObject.matches()) {
			   return "Enter the New Password contains with one lowercase and one uppercase and one special char[*.!@$%&] ";
		   }
		   else if(currentAccount!=accountNumber) {
			   return "Given Account Number is Mismatch!";
		   }
		   Customer customer=new Customer();
		   customer.setCustomerId(storageLayerObject.getCustomerId(currentAccount));
		   customer.setPassword(newPassword);
		   changeInfo(customer);
		   return "Password changed Successfully";
	}//end of changePassword
	
	
	public boolean switchAccount(long currentAccountNumber,long switchAccountNumber,String password) {
		
		Map<Integer,User>allUsersDetails = storageLayerObject.getUserDetails();
		User userDetails=allUsersDetails.get(storageLayerObject.getCustomerId(switchAccountNumber));
		
		if(storageLayerObject.getCustomerId(currentAccountNumber)!=storageLayerObject.getCustomerId(switchAccountNumber)) {
			logger.info("Given switch account is Mismatch !");
			return false;
		}
		else if(!password.equals(userDetails.getPassword())) {
			logger.info("Given Password is incorrect !");
			return false;
		}
		return true;
	}//end of switchAccount
	
	
	public Account getAccountDetails(long accountNumber) {
		Map<Integer,Map<Long,Account>>allAccountDetails=storageLayerObject.getAllAccountDetailsOfCustomer();
		Map<Long,Account> mapOfAccount=allAccountDetails.get(storageLayerObject.getCustomerId(accountNumber));
		Account currentAccountLoginPojo=new Account();
		for(Account account:mapOfAccount.values()) {
			if(accountNumber==account.getAccountNumber()) {
				currentAccountLoginPojo=account;
			}
		}
		return currentAccountLoginPojo;
	}//end of getAccountDetails
	
	
	public User getUserDetails(long accountNumber) {

		Map<Integer,User>allUsersDetails = storageLayerObject.getUserDetails();
		User UserDetails=allUsersDetails.get(storageLayerObject.getCustomerId(accountNumber));
		return UserDetails;
	}
	
	
	public Customer getCustomerDetails(long accountNumber) {

		Map<Integer,Customer> allCustomerDetails=storageLayerObject.getCustomerDetails();
		Customer CustomerPojoObject=allCustomerDetails.get(storageLayerObject.getCustomerId(accountNumber));
		return CustomerPojoObject;
	}
	
	
	public List<Statement> getTransactionStatements(long accountNumber){

		List<Statement> statements=storageLayerObject.getStatements(storageLayerObject.getCustomerId(accountNumber), accountNumber);
		return statements;
	}
	
	
	public boolean getAccountStatus(long accountNumber) {

		Account accountPojoObject=getAccountDetails(accountNumber);
		String status=accountPojoObject.getStatus();
		String state="Active";
		if(!state.equalsIgnoreCase(status)) {
			return false;
		}
		return true;
	}//end of getStatus
	
	
	public boolean getCustomerStatus(long accountNumber) {

		Map<Integer,Customer> allCustomerDetails=storageLayerObject.getCustomerDetails();
		Customer customerPojoObject=allCustomerDetails.get(storageLayerObject.getCustomerId(accountNumber));
		String status="Active";
		String state=customerPojoObject.getStatus();
		if(!status.equalsIgnoreCase(state)) {
			return false;
		}
		return true;
		
	}
	
	
	public String getRole(long accountNumber) {

		Map<Integer,User>allUsersDetails = storageLayerObject.getUserDetails();
		User currentUserDetails=allUsersDetails.get(storageLayerObject.getCustomerId(accountNumber));
		return currentUserDetails.getRole();
		
	}
	
	public void changeInfo(Customer customer) throws CustomException {
		storageLayerObject.changeInfo(customer);
	}
	
}
