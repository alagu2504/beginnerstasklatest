package hashmap;
import customexceptionpackage.CustomException;
import java.util.Map;
import java.util.Scanner;
public class HashMapTest {
	
	static Scanner sc=new Scanner(System.in);
	static HashMapTask hashMapObject=new HashMapTask();
	
	public static Map<String,String> appendString(Map<String,String> hashMap) throws CustomException{
		 System.out.println("Enter number of pairs you want to add :");
         int number=sc.nextInt();
		 for(int i=0;i<number;i++) {
         	System.out.println("Enter the string key :");
         	String key=sc.next();
         	System.out.println("Enter the String value:");
         	String value=sc.next();
         	hashMapObject.addStringMethod(hashMap, key, value);
         }
		 return hashMap;
	}
	
	public static Map<String,Integer> appendStringInteger(Map<String,Integer> hashMap) throws CustomException{
		 System.out.println("Enter number of pairs you want to add :");
        int number=sc.nextInt();
		 for(int i=0;i<number;i++) {
        	System.out.println("Enter the string key :");
        	String key=sc.next();
        	System.out.println("Enter the int value:");
        	Integer value=sc.nextInt();
        	hashMapObject.addStringIntegerElement(hashMap, key, value);
        }
		 return hashMap;
	}
	
public static void main(String args[]) {
	boolean ready=true;
	while(ready) {
	System.out.println("---------------------------------");
	System.out.println("Enter the valid case:");
	int caseNo=sc.nextInt();

	
	if(caseNo!=21) {
		try {
			switch(caseNo) {
			 case 1:{
		            Map<Object,Object> hashMap=hashMapObject.createMap();
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }//end of case1
		        case 2:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }//end of case2
		        case 3:{
		            Map<Integer,Integer> hashMap=hashMapObject.createIntegerMap();
		            System.out.println("Enter number of pairs you want to add :");
		            int number=sc.nextInt();
		            for(int i=0;i<number;i++) {
		            	System.out.println("Enter the int key :");
		            	Integer key=sc.nextInt();
		            	System.out.println("Enter the int value:");
		            	Integer value=sc.nextInt();
		            	hashMapObject.addIntegerElement(hashMap, key, value);
		            }
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 4:{
		            Map<String,Integer> hashMap=hashMapObject.createStringIntegerMap();
		            hashMap=appendStringInteger(hashMap);
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 5:{
		            Map<String,Object> hashMap=hashMapObject.createStirngObjectMap();
		            HashMapTest object1=new HashMapTest();
		            HashMapTest object2=new HashMapTest();
		            HashMapTest object3=new HashMapTest();
		            hashMapObject.addStringObjectElement(hashMap,"First",object1);
		            hashMapObject.addStringObjectElement(hashMap,"Second",object2);
		            hashMapObject.addStringObjectElement(hashMap,"Third",object3);
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 6:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMapObject.addStringMethod(hashMap,"First","Alagu");
		            hashMapObject.addStringMethod(hashMap,"Second",null);
		            hashMapObject.addStringMethod(hashMap,"Third","kasi");
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 7:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMapObject.addStringMethod(hashMap,"First","Alagu");
		            hashMapObject.addStringMethod(hashMap,null,"Raj");
		            hashMapObject.addStringMethod(hashMap,"Third","kasi");
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 8:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println("Enter key to check available or not in Map:");
		            String key=sc.next();
		            System.out.println("Given Key is available :"+hashMapObject.keyIsAvailable(hashMap,key));
		            break;
		        }
		        case 9:{
		            Map<String,Integer> hashMap=hashMapObject.createStringIntegerMap();
		            hashMap=appendStringInteger(hashMap);
		            System.out.println("Enter the int value to check available or not:");
		            int value=sc.nextInt();
		            System.out.println("Given value is available :"+hashMapObject.valuesIsAvailable(hashMap,value));
		            break;
		        }
		        case 10:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println("Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            for(int i=0;i<hashMapObject.getSize(hashMap);i++) {
		            	System.out.println("Enter existing key :");
		            	String key=sc.next();
		            	System.out.println("Enter value to replace:");
		            	String value=sc.next();
			            hashMapObject.replaceValues(hashMap,key,value);
		            }
		            System.out.println("Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 11:{
		            Map<String,Integer> hashMap=hashMapObject.createStringIntegerMap();
		            hashMap=appendStringInteger(hashMap);
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Enter  existing key to get value:");
		            String key=sc.next();
		            System.out.println("Values for given key :"+hashMapObject.getValue(hashMap,key));
		            break;
		        }
		        case 12:{
		            Map<String,Integer> hashMap=hashMapObject.createStringIntegerMap();
		            hashMap=appendStringInteger(hashMap);
		            System.out.println("HashMap :"+hashMap);
		            System.out.println("Enter non existing key for search:");
		            String key=sc.next();
		            System.out.println("Values for given key :"+hashMapObject.getValue(hashMap,key));
		            break;
		        }
		        case 13:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println("Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            System.out.println("Enter the non existing key :");
		            String key=sc.next();
		            System.out.println("Value for non existing key :"+hashMapObject.getDefaultValue(hashMap,key,"Zoho"));
		            System.out.println("After HashMap :"+hashMap);
		            System.out.println("After Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 14:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println("Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            System.out.println("Enter key to remove :");
		            String key=sc.next();
		            hashMapObject.removeKey(hashMap,key);
		            System.out.println("After HashMap :"+hashMap);
		            System.out.println("After Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 15:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println("Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            System.out.println("Enter key to remove :");
		            String key=sc.next();
		            System.out.println("Enter String value  :");
		            String value=sc.next();
		            hashMapObject.removeIfMatch(hashMap,key,value);
		            System.out.println("After HashMap :"+hashMap);
		            System.out.println("After Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 16:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println("Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            System.out.println("Enter existing key :");
		            String key=sc.next();
		            System.out.println("Enter String value to replace :");
		            String value=sc.next();
		            hashMapObject.replaceValue(hashMap,key,value);
		            System.out.println("After HashMap :"+hashMap);
		            System.out.println("After Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 17:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println("Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            System.out.println("Enter existing key :");
		            String key=sc.next();
		            System.out.println("Enter existing String value  :");
		            String oldValue=sc.next();
		            System.out.println("Enter new String value to replace :");
		            String newValue=sc.next();
		            hashMapObject.replaceIfMatch(hashMap,key,oldValue,newValue);
		            System.out.println("After HashMap :"+hashMap);
		            System.out.println("After Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
		        case 18:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println(" Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            Map<String,String> hashMap1=hashMapObject.createStringMap();
		            hashMap1=appendString(hashMap1);
		            System.out.println(" Before HashMap1 :"+hashMap1);
		            System.out.println("Before Size of the hashMap1 :"+hashMapObject.getSize(hashMap1));
		            hashMap1=hashMapObject.transferValues(hashMap,hashMap1);
		            System.out.println("After HashMap :"+hashMap);
		            System.out.println("After Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            System.out.println("After HashMap1 :"+hashMap1);
		            System.out.println("After Size of the hashMap1 :"+hashMapObject.getSize(hashMap1));
		            break;
		        }
		        case 19:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            hashMapObject.printMethod(hashMap);
		            break;
		        }
		        case 20:{
		            Map<String,String> hashMap=hashMapObject.createStringMap();
		            hashMap=appendString(hashMap);
		            System.out.println(" Before HashMap :"+hashMap);
		            System.out.println("Before Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            hashMapObject.removeAll(hashMap);
		            System.out.println("After HashMap :"+hashMap);
		            System.out.println("After Size of the hashMap :"+hashMapObject.getSize(hashMap));
		            break;
		        }
			default:{
				    System.out.println("Given caseno is invalid");
			}
			}//end of switch
	       	}//end of try
		    catch(CustomException e) {
			       System.out.println(e.getMessage());
		     }
	         }
	     else {
		    ready=false;
		      }
	       }
       }
}
