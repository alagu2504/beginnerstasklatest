package bankingapplication;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import bankingapplicationPojos.Account;
import bankingapplicationPojos.Customer;
import bankingapplicationPojos.Statement;
import bankingapplicationPojos.TransactionRequest;
import bankingapplicationPojos.User;
import customexceptionpackage.CustomException;
import users.Admin;
import users.Operations;


public class BankingApplicationTest {

	public static void main(String args[]) {
		
		Logger logger=Logger.getLogger(BankingApplicationTest.class.getName());
		 Operations userObject=new Operations();
		Admin adminObject=new Admin();
	    boolean login=false;
		boolean state=true;
        long currentUsersAccountNumber;
        boolean accountStatus=false;
        boolean customerStatus=false;
        
        try(Scanner sc=new Scanner(System.in)){

    		do {
    			logger.info("Enter the account Number :");
    			currentUsersAccountNumber=sc.nextLong();
    			logger.info("Enter the PassWord :");
    			 String password=sc.next();
    		   try {
    			login = userObject.loginMethod(currentUsersAccountNumber,password);
    			accountStatus=userObject.getAccountStatus(currentUsersAccountNumber);
    			customerStatus=userObject.getCustomerStatus(currentUsersAccountNumber);
    			if(login==false) {
        			logger.info("Login Failed !");
        		}
    			else if(!accountStatus) {
    				logger.info("You are Account Currently inactive !");
    			}
    			else if(!customerStatus) {
    				logger.info("you are Currently inactive !");
    			}
        		else {
        			logger.info("Successfully login");
        		}
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
    		   catch(CustomException e) {
    			   logger.info(e.getMessage());
    		   }
    		}while(login==false||accountStatus==false||customerStatus==false);
    		
    		String role=userObject.getRole(currentUsersAccountNumber);
    		while(state) {
    			if(role.equalsIgnoreCase("Admin")) {
    				logger.info("\n----------------------------------------------------------------"
        					+ "\n     1.Deposit\n     2.Withdraw\n     3.Transaction\n   "
        					+ "  4.CheckBalance\n     5.Change Password\n     6.Switch Alternate Account\n  "
        					+ "   7.Transaction Statements\n     8.Account Details\n     9.user Details\n    "
        					+ " 10.Customer Details\n     11.Transaction Statements of All users\n "
        					+ "    12.Account Details of All users\n     13. All Users Details\n    "
        					+ " 14.All Customer Details\n     15.Insert New users\n     16.Insert Customer Details\n"
        					+ "     17.Insert Account Details\n     18.Change Account Status\n     19.Change Customer Status\n"
        					+ "     20.Check and Verified Transaction Request\n     21.Change Customer Info      Enter 100 for Terminate"
        					+ "\n---------------------------------------------------------------------");
    			}
    			else {
    				logger.info("\n----------------------------------------------------------------"
        					+ "\n     1.Deposit\n     2.Withdraw\n     3.Transaction\n   "
        					+ "  4.CheckBalance\n     5.Change Password\n     6.Switch Alternate Account\n     7.Transaction Statements\n  "
        					+ "   8.Account Details\n     9.user Details\n     10.Customer Details\n  \n   21.Change Customer Info   Enter 100 for Terminate"
        					+ "\n---------------------------------------------------------------------");
    			}
    			logger.info("Enter the case Number :");
    			int caseNo=sc.nextInt();
    			switch(caseNo) {
    			
    			case 1:{
    				logger.info("Enter the Amount you want to Deposit :");
    				long depositAmount=sc.nextLong();
    				userObject.depositMethod(depositAmount, currentUsersAccountNumber);
    				logger.info("Successfully Deposited");
    				break;
    			}//end of case 1
    			
    			case 2:{
    				logger.info("Enter the Amount you want to Withdraw :");
    				long withdrawAmount=sc.nextLong();
    				userObject.withdrawMethod(withdrawAmount, currentUsersAccountNumber);
    				break;
    			}//end of case 2
    			
    			case 3:{
    				logger.info("Enter the Account Number of the Receiver :");
    				long receiverAccount=sc.nextLong();
    				logger.info("Enter the Amount to transfer :");
    				long transferAmount=sc.nextLong();
    				logger.info("Enter the Password :");
    				String passWord=sc.next();
    		     	try {
						logger.info("\n"+userObject.transactionMethod(currentUsersAccountNumber, receiverAccount, transferAmount, passWord));
					} catch (CustomException e) {
						logger.warning(e.getMessage());
					}
    				break;
    			}//end of case 3
    			
    			case 4:{
    				logger.info("Balance :"+userObject.checkBalance(currentUsersAccountNumber));
    				break;
    			}//end of case 4
    			
    			case 5:{
    				logger.info("Enter the Account Number :");
    				long accountNumber=sc.nextLong();
    				logger.info("Enter the New Password :");
    				String newPassword=sc.next();
                    try {
						logger.info("\n"+userObject.changePassword(currentUsersAccountNumber,accountNumber, newPassword));
					} catch (CustomException e) {
						logger.warning(e.getMessage());
					}    				
    				break;
    			}//end of case 5
    			
    			case 6:{
    				logger.info("Enter the Switch Account Number :");
    				long switchAccountNumber=sc.nextLong();
    				logger.info("Enter the Given Switch Account Password :");
    				String password=sc.next();
    				if(userObject.switchAccount(currentUsersAccountNumber, switchAccountNumber, password)) {
    					currentUsersAccountNumber=switchAccountNumber;
    					logger.info("Account Switched Successfully");
    				}
    				else {
    					logger.info("Failed !");
    				}
    				break;
    			}//end of case 6
    			case 7:{
    				List<Statement>statementsList=userObject.getTransactionStatements(currentUsersAccountNumber);
    				for(Statement statements:statementsList) {
						logger.info("\n------------------------------------------------------------------"
		    				    + "\n     Transaction Id :"+statements.getTransactionId()
		    				    +"\n     Customer Id :"+statements.getCustomerId()
		    					+"\n     Sender Account Number :"+statements.getSenderAccount()
		    					+"\n     Receiver Account Number :"+statements.getReceiverAccount()
		    					+"\n     Transfer Amount :"+statements.getTransferAmount()
		    					+"\n     Transaction Type :"+statements.getTransactionType()
		    					+"\n     Transaction Time :"+statements.getTime()
		    					+"\n--------------------------------------------------------------------------------");
					}
    				break;
    			}//end of case 7
    			case 8:{
    				Account currentAccountPojo=userObject.getAccountDetails(currentUsersAccountNumber);
    				logger.info("\n----------------------------------------------------------------------"
    				+ "\n     Account Number :"+currentAccountPojo.getAccountNumber()
    				+"\n     Account Type:"+currentAccountPojo.getAccountType()
    				+"\n     Ifsc Code :"+currentAccountPojo.getIfscCode()
    				+"\n     Branch Name :"+currentAccountPojo.getBranchName()
    				+"\n     Balance :"+currentAccountPojo.getBalance()
    				+"\n     User Id :"+currentAccountPojo.getCustomerId()
    				+"\n     Status :"+currentAccountPojo.getStatus()
    				+"\n---------------------------------------------------------------------------------");
    				break;
    			}//end of case 8
    			case 9:{
    				User UserDetails=userObject.getUserDetails(currentUsersAccountNumber);
    				logger.info("\n-----------------------------------------------------------------"
    				+ "\n     User Id :"+UserDetails.getUserId()
    				+"\n     User Name :"+UserDetails.getUserName()
    				+"\n     Date Of Birth :"+UserDetails.getDataOfBirth()
    				+"\n     Mobile Number :"+UserDetails.getMobileNumber()
    				+"\n     Address :"+UserDetails.getAddress()
    				+"\n     Email Id :"+UserDetails.getEmailId()
    				+"\n     Password :"+UserDetails.getPassword()
    				+"\n     Role :"+UserDetails.getRole()
    				+"\n-----------------------------------------------------------------------------");
    				break;
    			}//end of case 9
    			case 10:{
    				Customer CustomerPojoObject=userObject.getCustomerDetails(currentUsersAccountNumber);
    				logger.info("\n--------------------------------------------------------------------"
    				+ "\n     User Id :"+CustomerPojoObject.getUserId()
    	    		+"\n     User Name :"+CustomerPojoObject.getUserName()
    	    		+"\n     Date Of Birth :"+CustomerPojoObject.getDataOfBirth()
    	    		+"\n     Mobile Number :"+CustomerPojoObject.getMobileNumber()
    	    		+"\n     Address :"+CustomerPojoObject.getAddress()
    	    		+"\n     Email Id :"+CustomerPojoObject.getEmailId()
    	    		+"\n     Password :"+CustomerPojoObject.getPassword()
    	    		+"\n     Role :"+CustomerPojoObject.getRole()
    				+"\n     Aadhaar Number :"+CustomerPojoObject.getAadhaarNumber()
    				+"\n     Pan Card Number :"+CustomerPojoObject.getPanNumber()
    				+"\n----------------------------------------------------------------------------");
    				break;
    			}//end of case 10
    			case 11:{
    				if(role.equalsIgnoreCase("Admin")) {
    					Map<Long,Map<Integer,Statement>> allStatements=adminObject.getAllStatements();    					
    					Iterator <Long> iteratorObject=allStatements.keySet().iterator();
    					while(iteratorObject.hasNext()) {
    						Map<Integer,Statement> mapOfStatement=allStatements.get(iteratorObject.next());
    						for(Statement statements:mapOfStatement.values()) {
    							logger.info("\n------------------------------------------------------------------"
        		    				    + "\n     Transaction Id :"+statements.getTransactionId()
        		    				    +"\n     Customer Id :"+statements.getCustomerId()
        		    					+"\n     Sender Account Number :"+statements.getSenderAccount()
        		    					+"\n     Receiver Account Number :"+statements.getReceiverAccount()
        		    					+"\n     Transfer Amount :"+statements.getTransferAmount()
        		    					+"\n     Transaction Type :"+statements.getTransactionType()
        		    					+"\n     Transaction Time :"+statements.getTime()
        		    					+"\n--------------------------------------------------------------------------------");
    						}
    					}
//    					System.out.println(allStatements);
    				}
    				break;
    			}//end of case 11
    			case 12:{
    				if(role.equalsIgnoreCase("Admin")) {
    					Map<Integer,Map<Long,Account>> allAccountDetails=adminObject.getAllAccountDetailsOfCustomer();
    					Iterator<Integer> iteratorObject=allAccountDetails.keySet().iterator();
    					while(iteratorObject.hasNext()) {
    						Map<Long,Account> mapOfAccount=allAccountDetails.get(iteratorObject.next());
    						for(Account account:mapOfAccount.values()) {
    							logger.info("\n----------------------------------------------------------------------"
        			    				+ "\n     Account Number :"+account.getAccountNumber()
        			    				+"\n     Account Type:"+account.getAccountType()
        			    				+"\n     Ifsc Code :"+account.getIfscCode()
        			    				+"\n     Branch Name :"+account.getBranchName()
        			    				+"\n     Balance :"+account.getBalance()
        			    				+"\n     User Id :"+account.getCustomerId()
        			    				+"\n     Status :"+account.getStatus()
        			    				+"\n---------------------------------------------------------------------------------");
    						}
    					}
    				}
    				break;
    			}//en dof case12
    			case 13:{
    				if(role.equalsIgnoreCase("Admin")) {
    					Map<Integer,User> mapOfAllUser=adminObject.getAllUsersDetails();
    					for(User UserDetails:mapOfAllUser.values()) {
    						logger.info("\n-----------------------------------------------------------------"
    			    				+ "\n     User Id :"+UserDetails.getUserId()
    			    				+"\n     User Name :"+UserDetails.getUserName()
    			    				+"\n     Date Of Birth :"+UserDetails.getDataOfBirth()
    			    				+"\n     Mobile Number :"+UserDetails.getMobileNumber()
    			    				+"\n     Address :"+UserDetails.getAddress()
    			    				+"\n     Email Id :"+UserDetails.getEmailId()
    			    				+"\n     Password :"+UserDetails.getPassword()
    			    				+"\n     Role :"+UserDetails.getRole()
    			    				+"\n-----------------------------------------------------------------------------");
    					}
    				}
    				break;
    			}//end of case 13
    			
    			case 14:{
    				if(role.equalsIgnoreCase("Admin")) {
    					Map<Integer,Customer> allCustomerDetails=adminObject.getAllCustomerDetails();
    					for(Customer CustomerPojoObject:allCustomerDetails.values()) {
    						logger.info("\n--------------------------------------------------------------------"
    								+ "\n     User Id :"+CustomerPojoObject.getUserId()
    			    	    		+"\n     User Name :"+CustomerPojoObject.getUserName()
    			    	    		+"\n     Date Of Birth :"+CustomerPojoObject.getDataOfBirth()
    			    	    		+"\n     Mobile Number :"+CustomerPojoObject.getMobileNumber()
    			    	    		+"\n     Address :"+CustomerPojoObject.getAddress()
    			    	    		+"\n     Email Id :"+CustomerPojoObject.getEmailId()
    			    	    		+"\n     Password :"+CustomerPojoObject.getPassword()
    			    	    		+"\n     Role :"+CustomerPojoObject.getRole()
    			    				+"\n     Aadhaar Number :"+CustomerPojoObject.getAadhaarNumber()
    			    				+"\n     Pan Card Number :"+CustomerPojoObject.getPanNumber()
    			    				+"\n----------------------------------------------------------------------------");
    					}
    				}
    				break;
    			}//end of case 14
    			
    			case 15:{
    				if(role.equalsIgnoreCase("Admin")) {
    					logger.info("Enter the Number of Users you want to add:");
    					int size=sc.nextInt();
    					for(int i=0;i<size;i++) {
    						User userPojoObject=new User();
        			    	logger.info("Enter the user name :");
        			    	String userName=sc.next();
        			    	logger.info("Enter the Date of Birth(dd-mm-yyyy) :");
        			    	String dateOfBirth=sc.next();
        			    	logger.info("Enter the Mobile Number :");
        			    	long MobileNumber=sc.nextLong();
        			    	sc.nextLine();
        			    	logger.info("Enter the Address :");
        			    	String address=sc.nextLine();
        			    	logger.info("Enter the Email Id :");
        			    	String emailId=sc.next();
        			    	logger.info("Enter the password :");
        			    	String password=sc.next();
        			    	logger.info("Enter the Role :");
        			    	String roleOfUser=sc.next();
        			    	userPojoObject.setUserName(userName);
        			    	userPojoObject.setDataOfBirth(dateOfBirth);
        			    	userPojoObject.setMobileNumber(MobileNumber);
        			    	userPojoObject.setAddress(address);
        			    	userPojoObject.setEmailId(emailId);
        			    	userPojoObject.setPassword(password);
        			    	userPojoObject.setRole(roleOfUser);
        			    	adminObject.insertNewUsers(userPojoObject);
    					}
    				}
    				break;
    			}//end of case 15
    			
    			case 16 :{
					if(role.equalsIgnoreCase("Admin")) {
    				logger.info("Enter the Number of Customer details you want to add:");
					int size=sc.nextInt();
					for(int i=0;i<size;i++) {
	    					logger.info("Enter the userId");
	    					int userId=sc.nextInt();
	    					logger.info("Enter the Aadhaar Number :");
				    		long aadhaarNumber=sc.nextLong();
				    		logger.info("Enter the Pan Card Number");
				    		String panNumber=sc.next();
				    		logger.info("Enter the Status :");
				    		String currentUserStatus=sc.next();
				    		Customer customerPojoObject=new Customer();
				    		customerPojoObject.setCustomerId(userId);
				    		customerPojoObject.setAadhaarNumber(aadhaarNumber);
				    		customerPojoObject.setPanNumber(panNumber);
				    		customerPojoObject.setStatus(currentUserStatus);
				    		adminObject.insertCustomerDetails(customerPojoObject);
					}
					break;
    			}
    			}
    			case 17:{
					if(role.equalsIgnoreCase("Admin")) {
    				logger.info("Enter the Number of Account details you want to add:");
					int size=sc.nextInt();
					for(int i=0;i<size;i++) {
						logger.info("Enter the Account Number  :");
						long accountNumber=sc.nextLong();
						logger.info("Enter the Account Type :");
						String accountType=sc.next();
						logger.info("Enter the Ifsc Code :");
						String ifscCode=sc.next();
						logger.info("Enter the Branch Name :");
						String branchName=sc.next();
						logger.info("Enter the Account Balance :");
						long balance=sc.nextLong();
						logger.info("Enter the Status of the Customer :");
						String currentStatus=sc.next();
						logger.info("Enter the Customer Id :");
						int customerId=sc.nextInt();
						Account accountPojo=new Account();
						accountPojo.setAccountNumber(accountNumber);
						accountPojo.setAccountType(accountType);
						accountPojo.setIfscCode(ifscCode);
						accountPojo.setBranchName(branchName);
						accountPojo.setBalance(balance);
						accountPojo.setStatus(currentStatus);
						accountPojo.setCustomerId(customerId);
						adminObject.insertAccountInfo(accountPojo);
						}
    				break;
					}
    			}//end of case 17
    			
    			case 18:{
    				if(role.equalsIgnoreCase("Admin")) {
        				logger.info("Enter the number of Accounts status you want to change : ");
        				int size=sc.nextInt();
        				for(int i=0;i<size;i++) {
        					logger.info("Enter the customer id :");
        					int customerId=sc.nextInt();
        					logger.info("Enter the status :");
        					String status=sc.next();
        					adminObject.changeAccountStatus(customerId,status);
        				}
    				}
    				break;
    			}//end of case18
    			
    			case 19:{
    				if(role.equalsIgnoreCase("Admin")) {
    					logger.info("Enter the number of Customers you want to inactive :");
    					int size=sc.nextInt();
    					for(int i=0;i<size;i++) {
    						logger.info("Enter the customer id :");
    						int customerId=sc.nextInt();
    						logger.info("Enter the status of the Customer :");
    						String status=sc.next();
    						adminObject.changeCustomerStatus(customerId,status);
    					}
    				}
    				break;
    			}//end of case 19
    			
    			case 20:{
    				if(role.equalsIgnoreCase("Admin")) {
    					Map<Integer,TransactionRequest> requestStatementsMap=adminObject.getAllRequestStatements();
    					for(TransactionRequest requestPojo:requestStatementsMap.values()) {
    						if(requestPojo.getRequestStatus().equalsIgnoreCase("Waiting")) {
    							logger.info("\n---------------------------------------------------------"
        								+ "\n     Request Id :"+requestPojo.getRequestId()
        								+"\n     Sender Account Number :"+requestPojo.getSenderAccountNumber()
        								+"\n     Transfer Amount :"+requestPojo.getTransferAmount()
        								+"\n     Request Status :"+requestPojo.getRequestStatus());
    							logger.info("Enter true for Accepted or false for Rejected  :");
    							adminObject.updateTransactionRequest(requestPojo, sc.nextBoolean());
    						}
    					}
    				}
    				break;
    			}//end of case 20
    			case 21:{
    				Customer customer=userObject.getCustomerDetails(currentUsersAccountNumber);
    				logger.info("Enter the Details to change  \nEnter the Name :");
    				customer.setUserName(sc.next());
    				logger.info("Enter the New Date of Birth(dd-mm-yyyy) :");
    				customer.setDataOfBirth(sc.next());
    				logger.info("Enter the New Mobile Number :");
    				customer.setMobileNumber(sc.nextLong());
    				sc.nextLine();
    				logger.info("Enter the New Address :");
    				customer.setAddress(sc.nextLine());
    				logger.info("Enter the New Email Id :");
    				customer.setEmailId(sc.next());
    				logger.info("Enter the  New Password :");
    				customer.setPassword(sc.next());
    				try {
						userObject.changeInfo(customer);
					} catch (CustomException e) {
						logger.info(e.getMessage());
					}
    				break;
    			}//end of case 21
    			case 100:{
    				state=false;
    				break;
    			}
    			
    			default:{
    				logger.info("Enter the valid caseNo");
    				break;
    			}
    			}//end of switch
    		}//end of while
    		
    		
    		
    		
    		
    		
        }//end of try with resources
	}//end of main
}
