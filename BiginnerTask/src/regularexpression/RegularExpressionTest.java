package regularexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import customexceptionpackage.CustomException;


public class RegularExpressionTest {
	static Logger logger=Logger.getLogger(RegularExpressionTest.class.getName());

public static void main(String args[]) {
	RegularExpressionTask taskObject=new RegularExpressionTask();
	try(Scanner sc=new Scanner(System.in)){
		boolean state=true;
		while(state) {
			logger.log(Level.INFO, "Enter a case No: ");
			int caseNo=sc.nextInt();
			if(caseNo!=20) {
				switch(caseNo) {
				case 1:{
					logger.log(Level.INFO, "Enter the Mobile Number :");
					String number=sc.next();
					if(taskObject.chechIfMatchWithPattern(taskObject.getMobileNumberValidator(), number)) {
						logger.log(Level.INFO, "Given mobile number is valid");
					}
					else {
						logger.log(Level.INFO, "Given mobile number is Invalid");
					}
					break;
				}//end of case1
				case 2:{
					logger.log(Level.INFO, "Enter the AlphaNumeric Character :");
					String input=sc.next();
					if(taskObject.chechIfMatchWithPattern(taskObject.getAlphaNumericPattern(), input)) {
						logger.log(Level.INFO, "Given input accepted");
					}
					else {
						logger.log(Level.INFO, "Given input is not accepted");
					}
					break;
				}//end of case2
				case 3:{
					logger.log(Level.INFO, "Enter the string for expression :");
					String expression=sc.next();
					logger.log(Level.INFO, "Enter the string to check :");
					sc.nextLine();
					String input=sc.nextLine();
					if(taskObject.chechIfMatchWithPattern(taskObject.isStartsWith(expression), input)) {
						logger.log(Level.INFO, "Given String is start with "+expression);
					}
					else {
						logger.log(Level.INFO, "Given String is not start with "+expression);
					}
					break;
				}//end of case3
				case 4:{
					logger.log(Level.INFO, "Enter the string to check if match or not:");
					String expression=sc.next();
					logger.log(Level.INFO, "Enter the string input" );
					sc.nextLine();
					String input=sc.nextLine();
					if(taskObject.chechIfMatchWithPattern(taskObject.isContains(expression), input)) {
						logger.log(Level.INFO, "Given String contain "+expression);
					}
					else {
						logger.log(Level.INFO, "Given String is not contain  "+expression);
					}
					break;
				}//end of case4
				case 5:{
					logger.log(Level.INFO, "Enter the string for expression :");
					String expression=sc.next();
					logger.log(Level.INFO, "Enter the string to check :");
					sc.nextLine();
					String input=sc.nextLine();
					if(taskObject.chechIfMatchWithPattern(taskObject.isEndsWith(expression), input)) {
						logger.log(Level.INFO, "Given String Ends with "+expression);
					}
					else {
						logger.log(Level.INFO, "Given String is not ends with  "+expression);
					}
					break;
				}//end case5
				case 6:{
					logger.log(Level.INFO, "Enter the string for expression :");
					String expression=sc.next();
					logger.log(Level.INFO, "Enter the string to check :");
					sc.nextLine();
					String input=sc.nextLine();
					if(taskObject.chechIfMatchWithPattern(taskObject.isExactlyMatch(expression), input)) {
						logger.log(Level.INFO, "Exact match ");
					}
					else {
						logger.log(Level.INFO, "Given string is not match");
					}
					break;
				}
				case 7:{
					logger.log(Level.INFO, "Enter the string for expression :");
					String expression=sc.next();
					logger.log(Level.INFO, "Enter the string to check :");
					sc.nextLine();
					String input=sc.nextLine();
					if(taskObject.chechIfMatchWithPattern(taskObject.isMatchWithCaseInsensitive(expression), input)) {
						logger.log(Level.INFO, " match ");
					}
					else {
						logger.log(Level.INFO, "Given string is  not match");
					}
					break;
				}//end of case7
				case 8:{
					logger.log(Level.INFO, "Enter the email :");
					String email=sc.next();
					if(taskObject.chechIfMatchWithPattern(taskObject.emailValidation(), email)) {
						logger.log(Level.INFO, " valid ");
					}
					else {
						logger.log(Level.INFO, "Not Valid");
					}
					break;
				}//end of case8
				case 9:{
					logger.log(Level.INFO, "Enter the number of String you want to add :");
					int size=sc.nextInt();
					List<String> stringList=new ArrayList<String>();
					for(int i=0;i<size;i++ ){
						logger.log(Level.INFO, "Enter the string:");
						stringList.add(sc.next());
					}
					boolean range=false;
					try {
						range = taskObject.isInRange(stringList);
					} catch (CustomException e) {
						e.printStackTrace();
					}
					if(range) {
						logger.log(Level.INFO, "Given values within the range");
					}
					else {
						logger.log(Level.INFO, "Given values should not be in the range");
					}
					break;
				}//end of case9
				case 10:{
					logger.log(Level.INFO, "Enter the number of String you want to add :");
					int size=sc.nextInt();
					List<String> stringList1=new ArrayList<String>();
					for(int i=0;i<size;i++ ){
						logger.log(Level.INFO, "Enter the string:");
						stringList1.add(sc.next());
					}
					logger.log(Level.INFO, "Enter the number of String you want to add :");
					int size1=sc.nextInt();
					List<String> stringList2=new ArrayList<String>();
					for(int i=0;i<size1;i++ ){
						logger.log(Level.INFO, "Enter the string:");
						stringList2.add(sc.next());
					}
					try {
						logger.log(Level.INFO, "Keys and values in the Map :"+taskObject.hashMap(stringList1, stringList2));
					} catch (CustomException e) {
						e.printStackTrace();
					}
					break;
				}//end of case10
				case 11:{
					logger.log(Level.INFO, "Enter the htmlInput :");//<p>The <code>President</code> of India is the first citizen of our country.</p>
					sc.nextLine();
					String htmlCode=sc.nextLine();
					List<String>htmlList=taskObject.htmlTags(htmlCode);
					for(int i=0;i<htmlList.size();i++) {
						logger.log(Level.INFO, ""+htmlList.get(i));
					}
					break;
				}
				default:{
					logger.log(Level.INFO, "Enter the valid caseNo");
					break;
				}
				}//end of switch
			}
			else {
				state=false;
			}//end of else
		}//end of while
	}//end of try
	
}
}
