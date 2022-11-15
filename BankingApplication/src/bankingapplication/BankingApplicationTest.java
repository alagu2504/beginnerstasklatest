package bankingapplication;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

import bankingapplicationPojos.Account;
import bankingapplicationPojos.AccountStatusRequest;
import bankingapplicationPojos.Customer;
import bankingapplicationPojos.CustomerStatusRequest;
import bankingapplicationPojos.Statements;
import bankingapplicationPojos.TransactionRequest;
import bankingapplicationPojos.User;
import customexceptionpackage.CustomException;
import users.Admin;
import users.Operations;


public class BankingApplicationTest {
	
	public int getInt(Logger logger,Scanner sc) {
		boolean state=true;
		int output=0;
		while(state){
		    if(sc.hasNextInt()){
		    	output=sc.nextInt();
		        state=false;
		    }
		    else{
		        sc.next();
		    }
		}
		return output;
	}//end of getInt
	
	public long getLong(Logger logger,Scanner sc) {
		boolean state=true;
		long output=0;
		while(state){
		    if(sc.hasNextLong()){
		    	output=sc.nextLong();
		        state=false;
		    }
		    else{
		        sc.next();
		    }
		}
		return output;
	}

	public static void main(String args[]) {
		BankingApplicationTest testClassObject=new BankingApplicationTest();
		Logger logger=Logger.getLogger(BankingApplicationTest.class.getName());
		 Operations userObject=new Operations();
		Admin adminObject=new Admin();
	    boolean login=false;
		boolean state=true;
        long currentUsersAccountNumber=0L;
        String accountStatus="Inactive";
        String customerStatus="Inactive";
        int loginUserId=0;
        
        try(Scanner sc=new Scanner(System.in)){

    		do {
    			logger.info("Enter the User Id :");
    			loginUserId=testClassObject.getInt(logger, sc);
    			logger.info("Enter the PassWord :");
    			 String password=sc.next();
    		   try {
    			login = userObject.loginMethod(loginUserId,password);
    			if(login==false) {
        			logger.info("Login Failed !");
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
    		}while(login==false);
    		
			Map<Integer,Map<Long,Account>> accountDetails=adminObject.getAllAccountDetailsOfCustomer();
   			Map<Long,Account> accounts=accountDetails.get(loginUserId);
           if(accounts!=null&&!accounts.isEmpty()) {
        		 Set<Long> accountNumber=accounts.keySet();
        		 Object[] accountNumberArray=accountNumber.toArray();
    			 logger.info("Account Numbers for given User ID :");
        		 for(int i=0;i<accountNumberArray.length;i++) {
        			 logger.info("\n"+i+"   :"+accountNumberArray[i]);
        		 }
        		 logger.info("Choose the Account to use :");
        		 int index=testClassObject.getInt(logger, sc);
        		 currentUsersAccountNumber=(long)accountNumberArray[index];
           }   		
         if(currentUsersAccountNumber!=0L) {
        	 accountStatus=userObject.getAccountStatus(currentUsersAccountNumber);
        	 customerStatus=userObject.getCustomerStatus(loginUserId);
         }
    		String role=userObject.getRole(loginUserId);
    		while(state) {
    			if(role.equalsIgnoreCase("Customer")&&customerStatus.equalsIgnoreCase("Blocked")) {
    				logger.info("Your Customer ID is Blocked !");
    				state=false;
    				break;
    			}
    			
    			else if(role.equalsIgnoreCase("Customer")&&customerStatus.equalsIgnoreCase("Inactive")) {
    				logger.info("Your Customer Id is Inactive!\n     "
    						+ "Enter 22 for request to Active the Customer");
    			}
    			else if(role.equalsIgnoreCase("Customer")&&accountStatus.equalsIgnoreCase("Inactive")) {
    				logger.info("Your Current Account is Inactive\n"
    						+ "     1.If you have another Active Account Enter 6 to Switch the Current Acount\n"
    						+ "     2.Enter 23 for request to Active your Current Account ");
    			}
    			else if(role.equalsIgnoreCase("Customer")&&customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    				logger.info("\n----------------------------------------------------------------"
        					+ "\n     1.Deposit\n     2.Withdraw\n     3.Transaction\n   "
        					+ "  4.CheckBalance\n     5.Change Password\n     6.Switch Alternate Account\n"
        					+ "     7.Transaction Statements\n     8.Account Details\n     9.user Details\n"
        					+ "     10.Customer Details\n     21.Change Customer Info\n     22.Request to change the customer Status\n"
        					+ "     23.Request to change the Account Status\n   Enter 100 for Terminate"
        					+ "\n---------------------------------------------------------------------");
    			}
    			else if(role.equalsIgnoreCase("Admin")&&customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    				logger.info("\n----------------------------------------------------------------"
        					+ "\n     1.Deposit\n     2.Withdraw\n     3.Transaction\n   "
        					+ "  4.CheckBalance\n     5.Change Password\n     6.Switch Alternate Account\n  "
        					+ "   7.Transaction Statements\n     8.Account Details\n     9.user Details\n    "
        					+ " 10.Customer Details\n     11.Transaction Statements of All Customer\n "
        					+ "    12.Account Details of All users\n     13. All Users Details\n    "
        					+ " 14.All Customer Details\n     15.Insert New users\n     16.Insert Customer Details\n"
        					+ "     17.Insert Account Details\n     18.Verified and Change Account Status\n"
        					+ "     19.Verified and Change Customer Status\n     20.Check and Verified Transaction Request\n"
        					+ "     21.Change Customer Info\n     22.Request to change the customer Status\n"
        					+ "     23.Request to change the Account Status\n      Enter 100 for Terminate"
        					+ "\n---------------------------------------------------------------------");
    			}
    			else if(role.equalsIgnoreCase("Admin")) {
    				logger.info("\n------------------------------------------------------------------"
    						+ "\n     9.user Details     13.All User's Details\n     14.All Customer Details\n "
    						+ "    12.All Account Details\n     11.Transaction Statements of All Customer\n     15.Insert New Users\n     "
    						+ "16.Insert Customer Details\n     17.Insert Account Details\n     "
    						+ "18.Verified and Change Account Status\n     19.Verified and Change Customer Status\n"
    						+ "     20.Check and Verified Transaction Request\n     Enter 100 for Terminate"
    						+ "\n-----------------------------------------------------------------------");
    			}
    			logger.info("Enter the case Number :");
    			int caseNo=testClassObject.getInt(logger, sc);
    			switch(caseNo) {
    			
    			case 1:{
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    					logger.info("Enter the Amount you want to Deposit :");
        				long depositAmount=testClassObject.getLong(logger, sc);
        				userObject.depositMethod(depositAmount, currentUsersAccountNumber);
    				}
    				break;
    			}//end of case 1
    			
    			case 2:{
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    					logger.info("Enter the Amount you want to Withdraw :");
        				long withdrawAmount=testClassObject.getInt(logger, sc);
        				userObject.withdrawMethod(withdrawAmount, currentUsersAccountNumber);
    				}
    				break;
    			}//end of case 2
    			
    			case 3:{
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    					logger.info("Enter the Account Number of the Receiver :");
        				long receiverAccount=testClassObject.getInt(logger, sc);
        				logger.info("Enter the Amount to transfer :");
        				long transferAmount=testClassObject.getInt(logger, sc);
        				logger.info("Enter the Password :");
        				String passWord=sc.next();
        		     	try {
    						logger.info("\n"+userObject.transactionMethod(currentUsersAccountNumber, receiverAccount, transferAmount, passWord));
    					} catch (CustomException e) {
    						logger.warning(e.getMessage());
    					}
    				}
    				
    				break;
    			}//end of case 3
    			
    			case 4:{
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
        				logger.info("Balance :"+userObject.checkBalance(currentUsersAccountNumber));

    				}
    				break;
    			}//end of case 4
    			
    			case 5:{
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    					logger.info("Enter the Account Number :");
        				long accountNumber=testClassObject.getInt(logger, sc);
        				logger.info("Enter the New Password :");
        				String newPassword=sc.next();
                        try {
    						logger.info("\n"+userObject.changePassword(currentUsersAccountNumber,accountNumber, newPassword));
    					} catch (CustomException e) {
    						logger.warning(e.getMessage());
    					}
    				}
    				    				
    				break;
    			}//end of case 5
    			
    			case 6:{
    				if(customerStatus.equalsIgnoreCase("Active")) {
    					logger.info("Enter the Switch Account Number :");
        				long switchAccountNumber=testClassObject.getInt(logger, sc);
        				logger.info("Enter the Given Switch Account Password :");
        				String password=sc.next();
        				try {
							if(userObject.switchAccount(currentUsersAccountNumber, switchAccountNumber, password)) {
								currentUsersAccountNumber=switchAccountNumber;
								logger.info("Account Switched Successfully");
							}
							else {
								logger.info("Failed !");
							}
						} catch (CustomException e) {
							logger.warning(e.getMessage());
							e.printStackTrace();
						}
    				}
    				
    				break;
    			}//end of case 6
    			case 7:{
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    					List<Statements>statementsList=userObject.getTransactionStatements(currentUsersAccountNumber);
        				for(Statements statements:statementsList) {
    						logger.info("\n------------------------------------------------------------------"
    		    				    + "\n     Transaction Id :"+statements.getTransactionId()
    		    				    +"\n     Customer Id :"+statements.getCustomerId()
    		    					+"\n     Sender Account Number :"+statements.getSenderAccount()
    		    					+"\n     Receiver Account Number :"+statements.getReceiverAccount()
    		    					+"\n     Transfer Amount :"+statements.getTransferAmount()
    		    					+"\n     Transaction Type :"+statements.getTransactionType()
    		    					+"\n     Transaction Time :"+statements.getTime()
    		    					+"\n     Mode of Transaction :"+statements.getModeOfTransaction()
    		    					+"\n--------------------------------------------------------------------------------");
    					}
    				}
    				
    				break;
    			}//end of case 7
    			case 8:{
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
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
    				}
    			
    				break;
    			}//end of case 8
    			case 9:{
    					User UserDetails=userObject.getUserDetails(loginUserId);
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
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    					Customer customerPojoObject=userObject.getCustomerDetails(currentUsersAccountNumber);
        				logger.info("\n--------------------------------------------------------------------"
        				+ "\n     User Id :"+customerPojoObject.getUserId()
        	    		+"\n     User Name :"+customerPojoObject.getUserName()
        	    		+"\n     Date Of Birth :"+customerPojoObject.getDataOfBirth()
        	    		+"\n     Mobile Number :"+customerPojoObject.getMobileNumber()
        	    		+"\n     Address :"+customerPojoObject.getAddress()
        	    		+"\n     Email Id :"+customerPojoObject.getEmailId()
        	    		+"\n     Password :"+customerPojoObject.getPassword()
        	    		+"\n     Role :"+customerPojoObject.getRole()
        				+"\n     Aadhaar Number :"+customerPojoObject.getAadhaarNumber()
        				+"\n     Pan Card Number :"+customerPojoObject.getPanNumber()
        				+"\n     Status :"+customerPojoObject.getStatus()
        				+"\n----------------------------------------------------------------------------");
    				}
    				
    				break;
    			}//end of case 10
    			
    			case 11:{
    				if(role.equalsIgnoreCase("Admin")) {
    					Map<Long,Map<Integer,Statements>> allStatements=adminObject.getAllStatements();    					
    					Iterator <Long> iteratorObject=allStatements.keySet().iterator();
    					while(iteratorObject.hasNext()) {
    						Map<Integer,Statements> mapOfStatement=allStatements.get(iteratorObject.next());
    						for(Statements statement:mapOfStatement.values()) {
    							logger.info("\n------------------------------------------------------------------"
        		    				    + "\n     Transaction Id :"+statement.getTransactionId()
        		    				    +"\n     Customer Id :"+statement.getCustomerId()
        		    					+"\n     Sender Account Number :"+statement.getSenderAccount()
        		    					+"\n     Receiver Account Number :"+statement.getReceiverAccount()
        		    					+"\n     Transfer Amount :"+statement.getTransferAmount()
        		    					+"\n     Transaction Type :"+statement.getTransactionType()
        		    					+"\n     Mode Of Transaction :"+statement.getModeOfTransaction()
        		    					+"\n     Transaction Time :"+statement.getTime()
        		    					+"\n--------------------------------------------------------------------------------");
    						}
    					}
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
    					int size=testClassObject.getInt(logger, sc);
    					for(int i=0;i<size;i++) {
    						User userPojoObject=new User();
        			    	logger.info("Enter the user name :");
        			    	String userName=sc.next();
        			    	logger.info("Enter the Date of Birth(dd-mm-yyyy) :");
        			    	String dateOfBirth=sc.next();
        			    	logger.info("Enter the Mobile Number :");
        			    	long MobileNumber=testClassObject.getLong(logger, sc);
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
	    					int userId=testClassObject.getInt(logger, sc);
	    					logger.info("Enter the Aadhaar Number :");
				    		long aadhaarNumber=testClassObject.getLong(logger, sc);
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
						long accountNumber=testClassObject.getLong(logger, sc);
						logger.info("Enter the Account Type :");
						String accountType=sc.next();
						logger.info("Enter the Ifsc Code :");
						String ifscCode=sc.next();
						logger.info("Enter the Branch Name :");
						String branchName=sc.next();
						logger.info("Enter the Account Balance :");
						long balance=testClassObject.getLong(logger, sc);
						logger.info("Enter the Status of the Customer :");
						String currentStatus=sc.next();
						logger.info("Enter the Customer Id :");
						int customerId=testClassObject.getInt(logger, sc);
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

    					List<AccountStatusRequest> accountStatusRequest=adminObject.getAllAccountStatusRequest();
    					for(AccountStatusRequest request:accountStatusRequest) {
    						logger.info("--------------------------------------------------------------------"
    								+ "\n     Account Number  :"+request.getAccountNumber()
    								+"\n     Description  :"+request.getdescription()
    								+"\n     Status :"+request.getStatus());
    	    				Account currentAccountPojo=userObject.getAccountDetails(request.getAccountNumber());
    	    				logger.info("Enter true for Accepted or false for Rejected  :");
                            boolean requestStatus=sc.nextBoolean();
                            String customerState=currentAccountPojo.getStatus();
                            if(requestStatus) {
                            	logger.info("Enter the Customer State to Change(Active/Inactive/Blocked):");
                            	customerState=sc.next();
                            }
                            adminObject.updateAccountStatus(currentAccountPojo, requestStatus, customerState);

    					}
    				}
    				break;
    			}//end of case18
    			
    			case 19:{
    				if(role.equalsIgnoreCase("Admin")) {
    					Map<Integer,Customer> allCustomerDetails=adminObject.getAllCustomerDetails();
    					 Map<Integer,CustomerStatusRequest> customerStatusRequest=adminObject.getAllCustomerStatusRequest();
    					 for(CustomerStatusRequest request:customerStatusRequest.values()) {
    						 logger.info("----------------------------------------------------------------"
    						 		+ "\n     Customer Id :"+request.getCustomerId()
    						 		+"\n     Description :"+request.getDescription()
    						 		+"\n     Starus     :"+request.getStatus());
 							logger.info("Enter true for Accepted or false for Rejected  :");
                            boolean requestStatus=sc.nextBoolean();
                            
                            Customer customer=allCustomerDetails.get(request.getCustomerId());
                            String customerState=customer.getStatus();
                            if(requestStatus) {
                            	logger.info("Enter the Customer State to Change(Active/Inactive/Blocked):");
                            	customerState=sc.next();
                            }
                            adminObject.updateCustomerStatus(request.getCustomerId(),requestStatus,customerState);
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
    							try {
									adminObject.updateTransactionRequest(requestPojo, sc.nextBoolean());
								} catch (CustomException e) {
									logger.warning(e.getMessage());
									e.printStackTrace();
								}
    						}
    					}
    				}
    				break;
    			}//end of case 20
    			case 21:{
    				if(customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    					Customer customer=userObject.getCustomerDetails(currentUsersAccountNumber);
        				logger.info("Enter the Details to change  \nEnter the Name :");
        				customer.setUserName(sc.next());
        				logger.info("Enter the New Date of Birth(dd-mm-yyyy) :");
        				customer.setDataOfBirth(sc.next());
        				logger.info("Enter the New Mobile Number :");
        				customer.setMobileNumber(testClassObject.getLong(logger, sc));
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
    				}
    				
    				break;
    			}//end of case 21
    			case 22:{
    			if(currentUsersAccountNumber!=0L&&customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    				sc.nextLine();
    				logger.info("Enter your request reasons for change the customer status :");
    				String description=sc.nextLine();
    				try {
						userObject.customerStatusRequest(currentUsersAccountNumber, description);
					} catch (CustomException e) {
						logger.info(e.getMessage());
					}
    				state=false;
    			}
    			
    				break;
    			}//end of case 22
    			case 23:{
    			if(currentUsersAccountNumber!=0L&&customerStatus.equalsIgnoreCase("Active")&&accountStatus.equalsIgnoreCase("Active")) {
    				sc.nextLine();
    				logger.info("Enter the resons for change your Account status :");
    				String description=sc.nextLine();
    				try {
						userObject.accountStatusRequest(currentUsersAccountNumber, description);
					} catch (CustomException e) {
						logger.info(e.getMessage());
					}
    			}
    				break;
    			}//end of case 23
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
