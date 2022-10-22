package bankingapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bankingapplicationPojos.Account;
import bankingapplicationPojos.Customer;
import bankingapplicationPojos.Statement;
import bankingapplicationPojos.TransactionRequest;
import bankingapplicationPojos.User;
import customexceptionpackage.CustomException;

public class BankingApplicationStorage implements StorageLayerInterface {
    Logger logger=Logger.getLogger(BankingApplicationStorage.class.getName());

	public  Connection getConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/banking_system";
		String driver="com.mysql.cj.jdbc.Driver";
        String userName="alagu";
        String password="mysql2504.";
       
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url, userName, password);
	        return connection;
			}//end of getConnection
	
	public void insertAccountDetails(Account accountPojoObject) {
		String query="INSERT INTO account_info(ACCOUNT_NUMBER,ACCOUNT_TYPE,IFSC_CODE,"
				+ "BRANCH_NAME,BALANCE,STATUS,CUSTOMER_ID) VALUES(?,?,?,?,?,?,?)";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setLong(1, accountPojoObject.getAccountNumber());
			statement.setString(2, accountPojoObject.getAccountType());
			statement.setString(3, accountPojoObject.getIfscCode());
			statement.setString(4, accountPojoObject.getBranchName());
			statement.setLong(5, accountPojoObject.getBalance());
			statement.setString(6, accountPojoObject.getStatus());
			statement.setInt(7, accountPojoObject.getCustomerId());
			statement.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
    	logger.info("Successfully Inserted");
	}
	
	public Map<Integer,Account> getAccountDetails() {
		Map<Integer,Account> mapOfAccountDetails=new HashMap<>();
		String query=" SELECT * FROM account_info INNER JOIN customer_info ON account_info.CUSTOMER_ID=customer_info.CUSTOMER_ID";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			try(ResultSet resultSet=statement.executeQuery()){
				while(resultSet.next()) {
					Account accountPojoObject=new Account();
					accountPojoObject.setAccountNumber(resultSet.getLong("ACCOUNT_NUMBER"));
					accountPojoObject.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
					accountPojoObject.setIfscCode(resultSet.getString("IFSC_CODE"));
					accountPojoObject.setBranchName(resultSet.getString("BRANCH_NAME"));
					accountPojoObject.setBalance(resultSet.getLong("BALANCE"));
					accountPojoObject.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
					accountPojoObject.setStatus(resultSet.getString("STATUS"));
					mapOfAccountDetails.put(resultSet.getInt("CUSTOMER_ID"), accountPojoObject);
				}
			}
		}
		 catch (ClassNotFoundException | SQLException e) {
	 			e.printStackTrace();
	 		}
		return mapOfAccountDetails;
	}//END OF AccountPojo
	
	
	public Map<Long,Account> getAccountDetailsOfCustomer(int customerId){
		Map<Long,Account> mapOfAccount=new HashMap<>();
		String query="SELECT * FROM account_info WHERE CUSTOMER_ID = ?";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setInt(1, customerId);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Account accountPojoObject=new Account();
				accountPojoObject.setAccountNumber(resultSet.getLong("ACCOUNT_NUMBER"));
				accountPojoObject.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
				accountPojoObject.setIfscCode(resultSet.getString("IFSC_CODE"));
				accountPojoObject.setBranchName(resultSet.getString("BRANCH_NAME"));
				accountPojoObject.setBalance(resultSet.getLong("BALANCE"));
				accountPojoObject.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
				accountPojoObject.setStatus(resultSet.getString("STATUS"));
				mapOfAccount.put(resultSet.getLong("ACCOUNT_NUMBER"), accountPojoObject);
			}
			}
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
		return mapOfAccount;
	}
	
	public Map<Integer,Map<Long,Account>> getAllAccountDetailsOfCustomer(){
		Map<Integer,Map<Long,Account>> mapOfAllAccount=new HashMap<>();
		String query="SELECT ACCOUNT_NUMBER,CUSTOMER_ID FROM account_info";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				mapOfAllAccount.put(resultSet.getInt("CUSTOMER_ID"),getAccountDetailsOfCustomer(resultSet.getInt("CUSTOMER_ID")) );
			}
			
		}
		 catch (ClassNotFoundException | SQLException e) {
	 			e.printStackTrace();
	 		}
return mapOfAllAccount;
	}

	
	public Map<Integer,User> getUserDetails() {
		Map<Integer,User> mapOfAllUser=new HashMap<>();
		String query="SELECT * FROM user_info ";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			try(ResultSet resultSet=statement.executeQuery()){
				while(resultSet.next()) {
					User userPojoObject=new User();
					userPojoObject.setUserId(resultSet.getInt("USER_ID"));
					userPojoObject.setUserName(resultSet.getString("USER_NAME"));
					userPojoObject.setDataOfBirth(resultSet.getString("DATE_OF_BIRTH"));
					userPojoObject.setMobileNumber(resultSet.getLong("MOBILE"));
					userPojoObject.setAddress(resultSet.getString("ADDRESS"));
					userPojoObject.setEmailId(resultSet.getString("EMAIL_ID"));
					userPojoObject.setPassword(resultSet.getString("PASSWORD"));
					userPojoObject.setRole(resultSet.getString("ROLE"));
					mapOfAllUser.put(resultSet.getInt("USER_ID"), userPojoObject);
				}
			}
		}
		 catch (ClassNotFoundException | SQLException e) {
	 			e.printStackTrace();
	 		}
		return mapOfAllUser;
	}
	
	public void insertUsersDetails(User userPojoObject) {
		String query="INSERT INTO user_info(USER_NAME,DATE_OF_BIRTH,MOBILE,ADDRESS,EMAIL_ID,PASSWORD,ROLE) VALUES(?,?,?,?,?,?,?)";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setString(1,userPojoObject.getUserName());
			statement.setString(2, userPojoObject.getDataOfBirth());
			statement.setLong(3, userPojoObject.getMobileNumber());
			statement.setString(4, userPojoObject.getAddress());
			statement.setString(5, userPojoObject.getEmailId());
			statement.setString(6, userPojoObject.getPassword());
			statement.setString(7, userPojoObject.getRole());
			statement.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    	logger.info("Successfully Inserted");
	}
	
	public void insertCustomerDetails(Customer customerPojoObject) {
		String query="INSERT INTO customer_info(CUSTOMER_ID,AADHAAR_NUMBER,PAN_NUMBER,STATUS) VALUES (?,?,?,?)";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setInt(1, customerPojoObject.getCustomerId());
			statement.setLong(2, customerPojoObject.getAadhaarNumber());
			statement.setString(3, customerPojoObject.getPanNumber());
			statement.setString(4, customerPojoObject.getStatus());
			statement.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    	logger.info("Successfully Inserted");
	}
	
	public Map<Integer,Customer> getCustomerDetails(){
		Map<Integer,Customer> mapOfCustomer=new HashMap<>();
		String query="SELECT user_info.USER_ID,user_info.USER_NAME,user_info.DATE_OF_BIRTH,"
				+ "user_info.MOBILE,user_info.ADDRESS,user_info.EMAIL_ID,user_info.PASSWORD,"
				+ "user_info.ROLE,customer_info.CUSTOMER_ID,customer_info.AADHAAR_NUMBER,"
				+ "customer_info.PAN_NUMBER,customer_info.STATUS FROM user_info INNER JOIN "
				+ "customer_info ON user_info.USER_ID=customer_info.CUSTOMER_ID";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			try(ResultSet resultSet=statement.executeQuery()){
				while(resultSet.next()) {
					Customer customerObject=new Customer();
					customerObject.setUserId(resultSet.getInt("USER_ID"));
					customerObject.setUserName(resultSet.getString("USER_NAME"));
					customerObject.setDataOfBirth(resultSet.getString("DATE_OF_BIRTH"));
					customerObject.setMobileNumber(resultSet.getLong("MOBILE"));
					customerObject.setAddress(resultSet.getString("ADDRESS"));
					customerObject.setEmailId(resultSet.getString("EMAIL_ID"));
					customerObject.setPassword(resultSet.getString("PASSWORD"));
					customerObject.setRole(resultSet.getString("ROLE"));
					customerObject.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
					customerObject.setAadhaarNumber(resultSet.getLong("AADHAAR_NUMBER"));
					customerObject.setPanNumber(resultSet.getString("PAN_NUMBER"));
					customerObject.setUserId(resultSet.getInt("USER_ID"));
					customerObject.setStatus(resultSet.getString("STATUS"));
					mapOfCustomer.put(resultSet.getInt("USER_ID"), customerObject);
				}
			}
		}
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
		return mapOfCustomer;
	}//end of getCustomerDetails
	 
	private void statementsOperation(String query,List<Statement> statements) {
		
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
           try(ResultSet resultSet=statement.executeQuery()){
        	   while(resultSet.next()) {
               	Statement statementObject=new Statement();
               	statementObject.setTransactionId(resultSet.getInt("TRANSACTION_ID"));
               	statementObject.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
               	statementObject.setSenderAccount(resultSet.getLong("SENDER_ACCOUNT_NUMBER"));
               	statementObject.setReceiverAccount(resultSet.getLong("RECEIVER_ACCOUNT_NUMBER"));
               	statementObject.setTransferAmount(resultSet.getLong("TRANSFER_AMOUNT"));
               	statementObject.setTransactionType(resultSet.getString("TRANSACTION_TYPE"));
               	statementObject.setTime(resultSet.getLong("TRANSACTION_TIME"));
               	statements.add(statementObject);
               }
           }
			
		}
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
	}
	
	
	public Map<Long,Map<Integer,Statement>> getAllTransactionStatements(){
		
		Map<Long,Map<Integer,Statement>> allTransactionStatements=new HashMap<>();
		String query="SELECT ACCOUNT_NUMBER,CUSTOMER_ID FROM account_info";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				allTransactionStatements.put(resultSet.getLong("ACCOUNT_NUMBER"),getAllStatements(resultSet.getInt("CUSTOMER_ID"),resultSet.getLong("ACCOUNT_NUMBER")));
			}
		}
		
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
		return allTransactionStatements;
	}//end of getAllTransactionStatements

	public void statementOperation(String query,Map<Integer,Statement> mapOfStatements){
		
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
	           try(ResultSet resultSet=statement.executeQuery()){
	        	   while(resultSet.next()) {
	               	Statement statementObject=new Statement();
	               	statementObject.setTransactionId(resultSet.getInt("TRANSACTION_ID"));
	               	statementObject.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
	               	statementObject.setSenderAccount(resultSet.getLong("SENDER_ACCOUNT_NUMBER"));
	               	statementObject.setReceiverAccount(resultSet.getLong("RECEIVER_ACCOUNT_NUMBER"));
	               	statementObject.setTransferAmount(resultSet.getLong("TRANSFER_AMOUNT"));
	               	statementObject.setTransactionType(resultSet.getString("TRANSACTION_TYPE"));
	               	statementObject.setTime(resultSet.getLong("TRANSACTION_TIME"));
	               	mapOfStatements.put(resultSet.getInt("TRANSACTION_ID"), statementObject);
	               }
	           }
	}
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
	}//end of statementOperation
		

	public Map<Integer,Statement> getAllStatements(int customerId,long accountNumber){
		Map<Integer,Statement> mapOfStatements=new HashMap<>();
		 String query="SELECT * FROM transaction_statements WHERE CUSTOMER_ID = "
		+customerId+"  AND SENDER_ACCOUNT_NUMBER = "+accountNumber ;
			statementOperation(query,mapOfStatements);

			String query2="SELECT * FROM transaction_statements WHERE CUSTOMER_ID = "
			+customerId+" AND RECEIVER_ACCOUNT_NUMBER = "+accountNumber;
			statementOperation(query2,mapOfStatements);
            return mapOfStatements;
	}//end of getStatements
	
	public List<Statement> getStatements(int customerId,long accountNumber){
		List<Statement>TransactionStatements=new ArrayList<>();
		 String query="SELECT * FROM transaction_statements WHERE CUSTOMER_ID = "
		+customerId+"  AND SENDER_ACCOUNT_NUMBER = "+accountNumber ;
			statementsOperation(query,TransactionStatements);

			String query2="SELECT * FROM transaction_statements WHERE CUSTOMER_ID = "
			+customerId+" AND RECEIVER_ACCOUNT_NUMBER = "+accountNumber;
			statementsOperation(query2,TransactionStatements);
			
            return TransactionStatements;
	}//end of getStatements
	
	
	public void updateBalance(long accountNumber,long finalAmount) {
		String query="UPDATE account_info SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setLong(1, finalAmount);
			statement.setLong(2, accountNumber);
			statement.executeUpdate();
		}
		 catch (ClassNotFoundException | SQLException e) {
	 			e.printStackTrace();
	 		}
	}//END OF UPDATE BALANCE
	
	public void transactionRequest(TransactionRequest requestPojoObject) {
		String query="INSERT INTO transaction_request(SENDER_ACCOUNT_NUMBER,TRANSFER_AMOUNT,REQUEST_STATUS) VALUES(?,?,?)";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setLong(1,requestPojoObject.getSenderAccountNumber() );
			statement.setLong(2, requestPojoObject.getTransferAmount());
			statement.setString(3, requestPojoObject.getRequestStatus());
			statement.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
	}
	
	public void updateTransactionRequest(TransactionRequest requestPojoObject,String requestStatus) {
		String query="UPDATE transaction_request SET REQUEST_STATUS= ?";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setString(1, requestStatus);
			statement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
	}
	
	
	public void transactionMethod(long senderAccountNumber,long receiverAccountNumber,long senderBalance,long receiverBalance) {
		updateBalance(senderAccountNumber,senderBalance);
		updateBalance(receiverAccountNumber,receiverBalance);
	}//end of transactionMethod
	
	
	public void updateTransactionStatement(Statement StatementObject) {
		String query="INSERT INTO transaction_statements(CUSTOMER_ID,SENDER_ACCOUNT_NUMBER,"
				+ "RECEIVER_ACCOUNT_NUMBER,TRANSFER_AMOUNT,TRANSACTION_TIME,TRANSACTION_TYPE) VALUES(?,?,?,?,?,?)";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setInt(1, StatementObject.getCustomerId());
			statement.setLong(2, StatementObject.getSenderAccount());
			statement.setLong(3, StatementObject.getReceiverAccount());
			statement.setLong(4, StatementObject.getTransferAmount());
			statement.setLong(5, StatementObject.getTime().getTime());
			statement.setString(6, StatementObject.getTransactionType());
			statement.executeUpdate();
		}
		 catch (ClassNotFoundException | SQLException e) {
	 			e.printStackTrace();
	 		}
	}//end of updateTransactionStatement
	
	public void changeAccountStatus(int customerId,String status) {    ///
		String query="UPDATE account_info SET STATUS= '"+status+"' WHERE CUSTOMER_ID = "+customerId;
		changeStatus(query);
	}//end of delete user
	
	public void changeCustomerStatus(int customerId,String status) {    ///
		String query="UPDATE customer_info SET STATUS= '"+status+"' WHERE CUSTOMER_ID = "+customerId;
		changeStatus(query);
	}//end of changeCustomerStatus
	
	
	public int getCustomerId(long accountNumber) {
		int customerId=0;
		String query="SELECT CUSTOMER_ID FROM account_info WHERE ACCOUNT_NUMBER = ?";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setLong(1, accountNumber);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				customerId=resultSet.getInt("CUSTOMER_ID");
			}
		}
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
		return customerId;
	}
	
	public Map<Integer,TransactionRequest> getAllTransactionRequest(){
		Map<Integer,TransactionRequest> requestStatementsMap=new HashMap<>();
		String query="SELECT * FROM transaction_request";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
	           try(ResultSet resultSet=statement.executeQuery()){
	        	   while(resultSet.next()) {
	        		   TransactionRequest requestPojoObject=new TransactionRequest();
	        		   requestPojoObject.setRequestId(resultSet.getInt("REQUEST_ID"));
	        		   requestPojoObject.setSenderAccountNumber(resultSet.getLong("SENDER_ACCOUNT_NUMBER"));
	        		   requestPojoObject.setTransferAmount(resultSet.getLong("TRANSFER_AMOUNT"));
	        		   requestPojoObject.setRequestStatus(resultSet.getString("REQUEST_STATUS"));
	        		   requestStatementsMap.put(resultSet.getInt("REQUEST_ID"), requestPojoObject);
	        	   }
	           }
		}
		catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
 		}
		return requestStatementsMap;
		}//end of getAllTransactionRequest
	
	public void changeStatus(String query) {
		
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.executeUpdate();
		}
		 catch (ClassNotFoundException | SQLException e) {
	 			e.printStackTrace();
	 		}
	}
	
	public void changeInfo(Customer customer) throws CustomException {
		if(customer.getUserName()!=null) {
			String query="UPDATE user_info SET USER_NAME = "+customer.getUserName()+" WHERE USER_ID = "+customer.getCustomerId();
			changeStatus(query);
		}
		else if(customer.getDataOfBirth()!=null) {
			String query="UPDATE user_info SET DATE_OF_BIRTH = "+customer.getDataOfBirth()+" WHERE USER_ID = "+customer.getCustomerId();
			changeStatus(query);
		}
		else if(customer.getMobileNumber()!=0L) {
			String query="UPDATE user_info SET MOBILE = "+customer.getMobileNumber()+" WHERE USER_ID = "+customer.getCustomerId();
			changeStatus(query);
		}
		else if(customer.getAddress()!=null) {
			String query="UPDATE user_info SET ADDRESS = "+customer.getAddress()+" WHERE USER_ID = "+customer.getCustomerId();
			changeStatus(query);

		}
		else if(customer.getEmailId()!=null) {
			String query="UPDATE user_info SET EMAIL_ID = "+customer.getEmailId()+" WHERE USER_ID = "+customer.getCustomerId();
			changeStatus(query);
		}
		else if(customer.getPassword()!=null) {
			Pattern passwordPattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%&]).{8,32}$");
			   Matcher matcherObject = passwordPattern.matcher(customer.getPassword());
			   if(!matcherObject.matches()) {
				   throw new CustomException("Enter the New Password contains with one lowercase and one uppercase and one special char[*.!@$%&] ");
			   }
			   String query="UPDATE user_info SET PASSWORD = '"+customer.getPassword()+"' WHERE USER_ID = "+customer.getCustomerId();
				changeStatus(query);
		}
	    else if(customer.getAadhaarNumber()!=0L) {
			String query="UPDATE customer_info SET AADHAAR_NUMBER = "+customer.getAadhaarNumber()+" WHERE CUSTOMER_ID = "+customer.getCustomerId();
			changeStatus(query);
		}
		else if(customer.getPanNumber()!=null) {
			String query="UPDATE customer_info SET PAN_NUMBER = "+customer.getPanNumber()+" WHERE CUSTOMER_ID = "+customer.getCustomerId();
			changeStatus(query);
		}
	}//end of changeCustomer
	
}
