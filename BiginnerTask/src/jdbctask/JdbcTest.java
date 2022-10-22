package jdbctask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcTest {
	
	public static void main(String args[]) {
		Logger logger=Logger.getLogger(JdbcTest.class.getName());
	try(Scanner sc=new Scanner(System.in)){	
	JdbcTask jdbcObject=new JdbcTask();
	 boolean state =true;
	
	while(state) {
		logger.log(Level.INFO, "Enter the valid case :");
		int caseNo=sc.nextInt();
		if(caseNo!=14) {
			switch(caseNo) {
			case 1:{
					try {
						jdbcObject.creatTable(jdbcObject.parentQuery());
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				
				break;
			}//end of case 1
			case 2:{
				logger.log(Level.INFO, "Enter the number of Employee details you want to add :");
				int number=sc.nextInt();
				for(int i=0;i<number;i++) {
					logger.log(Level.INFO, "Enter the Employee name :");
					String name=sc.next();
					logger.log(Level.INFO, "Enter the Mobile number :");
					String mobileNumber=sc.next();
					logger.log(Level.INFO, "Enter the Email :");
					String emailId=sc.next();
					logger.log(Level.INFO, "Enter the Department :");
					String department=sc.next();
					try {
						jdbcObject.insertMethodOfParent(name, mobileNumber, emailId, department);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}//end of for loop
				break;
			}//end of case2
			case 3:{
				logger.log(Level.INFO, "Enter the Table Name :");
				String tableName=sc.next();
				logger.log(Level.INFO, "Enter the column Name of the table :");
				String column=sc.next();//EMPLOYEE_NAME
				logger.log(Level.INFO, "Enter the search value :");
				String searchvalue=sc.next();//value
				List< Map<String,Object>> listObject=new ArrayList<>();
				try {
					listObject=jdbcObject.getInfo(tableName, column, searchvalue);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				for(Map<String,Object> value:listObject) {
	               	   logger.info("\n"+value);
	                  }			
				break;
			}//end  of case3
			case 4:{
				logger.log(Level.INFO, "Enter the Table Name :");
				String tableName=sc.next();
				logger.log(Level.INFO, "Enter the Employee Id  :");
				int employeeId=sc.nextInt();
				logger.log(Level.INFO, "Enter the column Name of the table :");
				String column=sc.next();
				logger.log(Level.INFO, "Enter the value for Update :");
				String updatevalue=sc.next();
				try {
					jdbcObject.updateTable(tableName,employeeId,column,updatevalue);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
		
			}//end of case 4
			case 5:{
				logger.log(Level.INFO, "Enter the Table Name :");
				String tableName=sc.next();
				logger.log(Level.INFO, "Enter the number employee details you want:");
				int range=sc.nextInt();
				List< Map<String,Object>> listObject=new ArrayList<>();
                try {
                	listObject=jdbcObject.getTableInfoWithLimit(tableName, range);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
                for(Map<String,Object> value:listObject) {
	               	   logger.info("\n"+value);
                  }
				break;
			}//end of case 5
			case 6:{
				logger.log(Level.INFO, "Enter the Table Name :");
				String tableName=sc.next();
				logger.log(Level.INFO, "Enter the number employee details you want:");
				int range=sc.nextInt();
				logger.log(Level.INFO, "Enter the column Name  to sort:");
				String columnName=sc.next();//EMPLOYEE_NAME
				List< Map<String,Object>> listObject=new ArrayList<>();
                try {
                	listObject=jdbcObject.sortTable(tableName, range, columnName);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
                for(Map<String,Object> value:listObject) {
	               	   logger.info("\n"+value);
                   }				
                break;
			}//end of case 6
			case 7:{
				logger.log(Level.INFO, "Enter the employee Id :");
				int employeeId=sc.nextInt();
				  try {
					  jdbcObject.deleteRow(employeeId);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				   logger.log(Level.INFO, "Enter the Table Name :");
					String tableName=sc.next();
					logger.log(Level.INFO, "Enter the number employee details you want:");
					int range=sc.nextInt();
					List< Map<String,Object>> listObject=new ArrayList<>();
	                try {
	                	listObject=jdbcObject.getTableInfoWithLimit(tableName, range);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
	                for(Map<String,Object> value:listObject) {
		               	   logger.info("\n"+value);
	                  }
				  break;
			}//end of case 7
			case 80:{
				logger.log(Level.INFO, "Enter the number of Employee details you want to add :");
				int number=sc.nextInt();
				for(int i=0;i<number;i++) {
					JdbcPojo pojoObject=new JdbcPojo();	
					logger.log(Level.INFO, "Enter the Employee Name :");
					String employeeName=sc.next();
					pojoObject.setEmployeeName(employeeName);
					logger.log(Level.INFO, "Enter the Mobile number :");
					String mobileNumber=sc.next();
					pojoObject.setMobileNumber(mobileNumber);
					logger.log(Level.INFO, "Enter the Email :");
					String emailId=sc.next();
					pojoObject.setEmailId(emailId);
					logger.log(Level.INFO, "Enter the Department :");
					String department=sc.next();
					pojoObject.setDepartment(department);
					try {
						jdbcObject.insertMethodOfParent(pojoObject.getEmployeeName(), pojoObject.getMobileNumber(), pojoObject.getEmailId(), pojoObject.getDepartment());
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			}//end of case80
			case 81:{
				JdbcPojo pojoObject=new JdbcPojo();	
				logger.log(Level.INFO, "Enter the Table Name :");
				String tableName=sc.next();
				logger.log(Level.INFO, "Enter the column Name of the table :");
				String column=sc.next();//EMPLOYEE_NAME
				logger.log(Level.INFO, "Enter the search value :");
				String searchvalue=sc.next();//value
				pojoObject.setEmployeeName(searchvalue);
				List< Map<String,Object>> listObject=new ArrayList<>();
				try {
					listObject=jdbcObject.getInfo(tableName, column,pojoObject.getEmployeeName());
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				for(Map<String,Object> value:listObject) {
	               	   logger.info("\n"+value);
	                  }
				break;
			}//end 81
			case 82:{
				JdbcPojo pojoObject=new JdbcPojo();	
				logger.log(Level.INFO, "Enter the Table Name :");
				String tableName=sc.next();
				logger.log(Level.INFO, "Enter the number employee details you want:");
				int range=sc.nextInt();
				pojoObject.setRange(range);
				List< Map<String,Object>> listObject=new ArrayList<>();
                try {
                	listObject=jdbcObject.getTableInfoWithLimit(tableName, pojoObject.getRange());
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
                for(Map<String,Object> value:listObject) {
	               	   logger.info("\n"+value);
                   }
                break;
			}
			case 83:{
				JdbcPojo pojoObject=new JdbcPojo();	
				logger.log(Level.INFO, "Enter the Table Name :");
				String tableName=sc.next();
				logger.log(Level.INFO, "Enter the number employee details you want:");
				int range=sc.nextInt();
				pojoObject.setRange(range);
				logger.log(Level.INFO, "Enter the column Name :");
				String columnName=sc.next();//EMPLOYEE_NAME
				List< Map<String,Object>> listObject=new ArrayList<>();
                try {
                	listObject=jdbcObject.sortTable(tableName, pojoObject.getRange(), columnName);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
                for(Map<String,Object> value:listObject) {
	               	   logger.info("\n"+value);
                   }
                break;
			}
			case 9:{
				try {
					jdbcObject.creatTable(jdbcObject.dependentQuery());
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			case 10:{
				logger.log(Level.INFO, "Enter the number of details you want to add to dependent table :");
				int number=sc.nextInt();
				for(int i=0;i<number;i++) {
					logger.log(Level.INFO, "Enter the EmployeeId :");
					int EmployeeId=sc.nextInt();
					logger.log(Level.INFO, "Enter the  name of the person :");
					String name=sc.next();
					logger.log(Level.INFO, "Enter the age :");
					int age=sc.nextInt();
					logger.log(Level.INFO, "Enter the relationship :");
					String relationship=sc.next();
					try {
						jdbcObject.insertMethodForDependent(name, age, relationship, EmployeeId);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			}
			case 11:{
				logger.log(Level.INFO, "Enter the number of details you want  :");
				int number=sc.nextInt();
				List< Map<String,Object>> listObject=new ArrayList<>();
				for(int i=0;i<number;i++) {
					logger.log(Level.INFO, "Enter the EmployeeId :");
					int EmployeeId=sc.nextInt();
					try {
						listObject=jdbcObject.getCommonInfo(EmployeeId);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}//end of for
				for(Map<String,Object> value:listObject) {
	               	   logger.info("\n"+value);
	                  }
				break;
			}
			case 12:{
				logger.log(Level.INFO, "Enter the Table Name :");
				String tableName=sc.next();
				logger.log(Level.INFO, "Enter the number employee details you want:");
				int range=sc.nextInt();
				List< Map<String,Object>> listObject=new ArrayList<>();
                try {
                	listObject=jdbcObject.getTableInfoWithLimit(tableName, range);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}     
				try {
					listObject=jdbcObject.getCommonDetailsWithLimit(jdbcObject.getEmployeeIds(listObject));
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				for(Map<String,Object> value:listObject) {
	               	   logger.info("\n"+value);
	                  }
                 break;
			}
			default:{
				logger.info("Enter the valid caseNo");
				break;
			}
			}
		}
		else {
			state=false;
		}
	}}

	}
}
