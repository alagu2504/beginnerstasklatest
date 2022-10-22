
package beginnersbasictask;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import customexceptionpackage.CustomException;


public class BeginnersBasicTest {
	static Logger logger=Logger.getLogger(BeginnersBasicTest.class.getName());

	//Q1
	public static void caseOne(Scanner sc,BeginnersBasicTask taskObject,String file) throws IOException, CustomException {
		logger.log(Level.INFO, "Enter the number of String you want to write :");
		int number =sc.nextInt();
		sc.nextLine();
		for(int i=0;i<number;i++) {
			logger.log(Level.INFO, "Enter String to write :");
			String input=sc.nextLine();
			taskObject.writeFile(file,input);
		}
	}
	//Q2
	public static void caseTwo(Scanner sc,BeginnersBasicTask taskObject,String file) throws IOException, CustomException {
		logger.log(Level.INFO, "Enter the key to properties :");
		String key=sc.next();
		logger.log(Level.INFO, "Enter the value to key properties :");
		String value=sc.next();
		Properties propertiesObject=taskObject.createProperties(key, value);
		taskObject.storePropertiesValues(propertiesObject, file);
	}//end of caseTWo
	
	//Q3
	public static void loadPropMethod(Scanner sc,BeginnersBasicTask taskObject,String fileName) throws IOException, CustomException {
		logger.log(Level.INFO, "Contents in the FileInputStream :");
		logger.log(Level.INFO, ""+	taskObject.readFile(fileName));
		Properties propertiesObject=taskObject.creatProp();
		taskObject.loadMethod(propertiesObject, fileName);
		logger.log(Level.INFO, "Properties keys and value :"+propertiesObject);
	}
	public static void main(String args[]) {
	
		BeginnersBasicTask taskObject=new BeginnersBasicTask();
		TimeTask timeObject=new TimeTask();
	try(Scanner sc=new Scanner(System.in)){
		boolean ready=true;
		while(ready) {
			logger.log(Level.INFO, "Enter a case No: ");
			int caseNo=sc.nextInt();
			if(caseNo!=30) {
					switch(caseNo) {
						case 1:{
							try {
								sc.nextLine();
								logger.log(Level.INFO, "Enter the file name with .txt :");
								String fileName=sc.nextLine();
									caseOne(sc,taskObject,fileName);
							}
							catch(IOException e) {
								logger.log(Level.WARNING,e.toString());
							}
							catch(CustomException e) {
								logger.log(Level.WARNING,e.getMessage());
							}
							
						break;
					}//endofcase1
						
						case 2:{
							try {
								sc.nextLine();
								logger.log(Level.INFO, "Enter the file name with .txt :");
								String fileName=sc.nextLine();
								caseTwo(sc,taskObject,fileName);
								break;
							}
							catch(IOException e) {
								logger.log(Level.WARNING,e.getMessage());
							}//end of catch	
							catch(CustomException e) {
								logger.log(Level.WARNING,e.getMessage());
							}
							break;
							}//end of case 2
						case 3:{
							try {
								sc.nextLine();
								logger.log(Level.INFO, "Enter the file name with .txt :");
								String fileName=sc.nextLine();
								loadPropMethod(sc,taskObject,fileName);
							}
							catch(IOException e) {
								logger.log(Level.WARNING,e.getMessage());
							}//end of catch	
							catch(CustomException e) {
								logger.log(Level.WARNING,e.getMessage());
							}
							break;
							}//end of case3
						case 4:{
			                  try {
								  logger.log(Level.INFO, "Enter the dir to create: ");
								  //       //home/inc10/myDir/
			                	  String dir=sc.next();
			                	  File fileBath=new File(dir);
			                	  fileBath.mkdir();
								  logger.log(Level.INFO, "Enter txt file with  : ");
								  String file=dir+sc.next();
								  caseOne(sc,taskObject,file);
								  logger.log(Level.INFO, "Enter the file name with .txt :");
								  String fileName=dir+sc.nextLine();
								  caseTwo(sc,taskObject,fileName);	
								  sc.nextLine();
								  logger.log(Level.INFO, "Enter the file name with .txt :");
								  String fileName1=sc.nextLine();
								  loadPropMethod(sc,taskObject,dir+fileName1);
			                  }
			                  catch(IOException e) {
									logger.log(Level.WARNING,e.getMessage());
								}//end of catch
			                  catch(CustomException e) {
									logger.log(Level.WARNING,e.getMessage());
								}
								break;

						}//end of case4
						case 5:{
							logger.log(Level.INFO, "Enter the String : ");
							String input=sc.next();
							Beginner beginnerObject=new Beginner(input);
							logger.log(Level.INFO, ""+beginnerObject);
							break;
						}//end of case5
						case 6:{
							logger.log(Level.INFO, "Enter the String : ");
							String input=sc.next();
							logger.log(Level.INFO, "Enter the Integer: ");
							int intValue=sc.nextInt();
							PojoClass pojoObject=new PojoClass(input,intValue);
							logger.log(Level.INFO, ""+pojoObject);
							break;
						}
						case 7:{
							PojoClass pojoObject=new PojoClass();
							logger.log(Level.INFO, "Enter the String value: ");
							String inputString=sc.next();
							pojoObject.setString(inputString);
							logger.log(Level.INFO, "Enter the int value: ");
							int intValue=sc.nextInt();
							pojoObject.setInt(intValue);
							logger.log(Level.INFO, "Given String : "+pojoObject.getString());
							logger.log(Level.INFO, "Given integer : "+pojoObject.getInt());	
                            break;
						}
						case 9:{
							for (Rainbow s : Rainbow.values())  
								System.out.println(s+" "+s.getValue());  							
							break;
						}
						case 10:{
							SingletonClass singletonObj1=SingletonClass.getInstance();
							SingletonClass singletonObj2=SingletonClass.getInstance();
							SingletonClass singletonObj3=SingletonClass.getInstance();
							logger.log(Level.INFO, "HashCode of given object :"+ singletonObj1.hashCode());
							logger.log(Level.INFO, "HashCode of given object :"+ singletonObj2.hashCode());
							logger.log(Level.INFO, "HashCode of given object :"+ singletonObj3.hashCode());
                            break;
						}
						case 11:{
							logger.log(Level.INFO,"Current date and Time :"+timeObject.localDateTime() );
							logger.log(Level.INFO,"Current Time in MilliSeconds using System class :"+timeObject.timeInMillis() );
							logger.log(Level.INFO,"Current Time in MilliSeconds using Instant :"+timeObject.milliSeconds());
							break;
						}
						case 12:{
							// ZoneId zone = ZoneId.of("America/New_York");		
							     logger.log(Level.INFO,"Enter the ZoneId :");
								 String zone=sc.next();
						         logger.log(Level.INFO,"Current date and Time in "+zone+ " :"+timeObject.localDateTimeWithZone(zone));
							// ZoneId zone = ZoneId.of("Europe/London");		
								 logger.log(Level.INFO,"Enter the ZoneId :");
							     String zone1=sc.next();
						         logger.log(Level.INFO,"Current date and Time in "+zone1+" :"+timeObject.localDateTimeWithZone(zone1));
								 break;
						}
						case 13:{
							logger.log(Level.INFO,"Enter the time with milli seconds:");
                             long time=sc.nextLong();							
									logger.log(Level.INFO, "Day of Week :"+timeObject.getDayOfWeek(time));
							break;
						}
						case 14:{
							logger.log(Level.INFO,"Enter the time with milli seconds:");
                            long time=sc.nextLong();	
							logger.log(Level.INFO, "Month :"+timeObject.getMonthOfGivenTime(time));
							break;
						}
						case 15:{
							logger.log(Level.INFO,"Enter the time with milli seconds:");
                            long time=sc.nextLong();
							logger.log(Level.INFO,"Year :"+timeObject.getYearOfGivenTime(time));
							break;
						}
					
					default:{
					logger.log(Level.WARNING,"Enter the valid caseNo");
					break;
					}//end of default method
					}//end of switch
			}//end of if
			else {
				ready=false;
			}
		}
	}//end of try
	}
}
