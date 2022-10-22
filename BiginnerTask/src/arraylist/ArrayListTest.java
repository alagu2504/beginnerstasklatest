package arraylist;
import java.util.List;
import java.util.Scanner;
//import java.util.Iterator;
import customexceptionpackage.CustomException;

public class ArrayListTest {
	static Scanner sc=new Scanner(System.in);
   static ArrayListLogic listObject=new ArrayListLogic();
	//creatStringList
	public static List<String> creatStringList()throws CustomException{
		List<String> arrayList=listObject.creatStringList();
		String[] array=stringArray();
		listObject.addStringElement(arrayList, array);
		return arrayList;
		
	}
    //StringArray
	public static String[] stringArray() {
		System.out.println("Enter the no String You want :");
		int number=sc.nextInt();
		String[]array=new String[number];
		for(int i=0;i<number;i++) {
			System.out.println("Enter your String :");
			String input=sc.next();
			array[i]=input;
		}//end of for
		return array;
	}
	//integer array
	public static Integer[] intArray() {
		System.out.println("Enter the no of Integer you want:");
		int number=sc.nextInt();
		Integer[]array=new Integer[number];
		for(int i=0;i<number;i++) {
			System.out.println("Enter integer:");
			int input=sc.nextInt();
			array[i]=input;
		}
		return array;
	}//enf of int array
	//float array
	public static Double[] doubleArray() {
		System.out.println("Enter the no of decimal value you want:");
		int number=sc.nextInt();
		Double[]array=new Double[number];
		for(int i=0;i<number;i++) {
			System.out.println("Enter Decimal:");
			double input=sc.nextDouble();
			array[i]=input;
		}
		return array;
	}
	//long array
	public static Long[] longArray() {
		System.out.println("Enter the no of long value you want:");
		int number=sc.nextInt();
		Long[]array=new Long[number];
		for(int i=0;i<number;i++) {
			System.out.println("Enter Long value:");
			Long input=sc.nextLong();
			array[i]=input;
		}
		return array;
	}
	//object array
	public static Object[]objectArray(){
		System.out.println("Enter the number of object you want to create :");
		int length=sc.nextInt();
		Object[] array=new Object[length];
		for(int i=0;i<length;i++) {
			array[i]=new Object();
		}
		return array;
	}
	public static void main(String args[]) {
		
		boolean ready=true;
		while(ready){
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter the valid case :");
			int caseNo=sc.nextInt();
			if(caseNo!=21) {
				try {
					switch(caseNo) {
					
					case 1:{
						List<Object> arrayList=listObject.creatArrayList();
						System.out.println("Size of the given arraylist :"+listObject.sizeOfArrayList(arrayList));
						break;
					}//end of case1
					case 2:{
						List<String> arrayList1=creatStringList();
					    System.out.println("ArrayList after add Element :"+arrayList1);
						System.out.println(" arralist length after add operation :"+listObject.sizeOfArrayList(arrayList1));
						break;
					}//end of case2
					case 3:{
						List<Integer> arrayList=listObject.creatIntegerList();
						Integer[]array=intArray();
						arrayList=listObject.addIntegerElement(arrayList,array);
						System.out.println("ArrayList after add Element :"+arrayList);
						System.out.println("arraylist length after add operation :"+listObject.sizeOfArrayList(arrayList));
						break;
					}//end of case3
					case 4:{
						Object[]array=objectArray();
                        List<Object> arrayList=listObject.creatArrayList();
                        arrayList=listObject.addElement(arrayList,array);
                        System.out.println("ArrayList after add object :"+arrayList);
						System.out.println(" arraylist length after add operation :"+listObject.sizeOfArrayList(arrayList));
						break;
						
					}//end of case4
					case 5:{
						Object []strArray=stringArray();
						Object[]intArray=intArray();
						Object[]objArray=objectArray();
						List<Object> arrayList=listObject.creatArrayList();
						listObject.addElement(arrayList, objArray);
						listObject.addElement(arrayList, strArray);
						listObject.addElement(arrayList, intArray);
						System.out.println("ArrayList after add element:"+arrayList);
						System.out.println("ArrayList length after add operation :"+listObject.sizeOfArrayList(arrayList));
						break;
					}//end of case5
					case 6:{
						List<String> arrayList1=creatStringList();
						System.out.println("Enter the input to find position:");
						String input=sc.next();
						System.out.println("Index position of given input :"+listObject.getFirstIndex(arrayList1, input));
						System.out.println("ArrayList after add Element :"+arrayList1);
						System.out.println("length of ArrayList :"+listObject.sizeOfArrayList(arrayList1));
						break;
					}//end of case6
					case 7:{
						List<String> arrayList1=creatStringList();
						System.out.println("Values :");
						listObject.iteratorMethod(arrayList1);
						break;
					}//end of case7
					case 8:{
						List<String> arrayList1=creatStringList();
						System.out.println("Enter the index position :");
						int index=sc.nextInt();
						System.out.println("value at a given index :"+listObject.getValue(arrayList1, index));
						System.out.println("length of ArrayList :"+listObject.sizeOfArrayList(arrayList1));
						break;
					}//end of case8
					case 9:{
						List<String> arrayList1=creatStringList();
						System.out.println("Enter the input to find position:");
						String input=sc.next();
						System.out.println("First Index position of given input :"+listObject.getFirstIndex(arrayList1, input));
						System.out.println("Last Index position of given input :"+listObject.getLastIndex(arrayList1, input));
						break;
					}//end of case9
					case 10:{
						List<String> arrayList1=creatStringList();
						System.out.println("Enter the String you want to add :");
                        String input=sc.next();
                        System.out.println("Enter the position :");
                        int position=sc.nextInt();
                      listObject.insertMethod(arrayList1, input, position);
                        System.out.println("ArrayList after add operation :"+arrayList1);
                        System.out.println("Size of ArrayList :"+listObject.sizeOfArrayList(arrayList1)); 
						break;
					}
					case 11:{
							List<String> arrayList1=creatStringList();
						System.out.println("Enter the Starting position :");
						int startingPosition=sc.nextInt();
						System.out.println("Enter the Ending position :");
						int endingPosition=sc.nextInt();
						List<String> subArrayList=listObject.subArrayList(arrayList1, startingPosition, endingPosition);
						System.out.println("Substirng of ArrayList :"+subArrayList);
						break;
					}//end of case11
					case 12:{
						List<String> arrayList1=creatStringList();
						List<String> arrayList2=creatStringList();
						List<String> arrayList3=listObject.addAllElement(arrayList1,arrayList2);
						System.out.println("ArrayList after add all :"+arrayList3);
						System.out.println("size of arrayList after add all list :"+listObject.sizeOfArrayList(arrayList3));
						break;
					}//end of case12
					case 13:{
						List<String> arrayList1=creatStringList();
						List<String> arrayList2=creatStringList();
						System.out.println("Enter the position you want to add :");
						int position=sc.nextInt();
						List<String> arrayList3=listObject.addListWithPosition(arrayList1, arrayList2, position);
						System.out.println("ArrayList after add at specific position:"+arrayList3);
						System.out.println("Size of arrayList :"+listObject.sizeOfArrayList(arrayList3));
						break;
					}//end of case13
					case 14:{
						List<Double> arrayList=listObject.creatDoubleList();
						Double[] array=doubleArray();
						arrayList=listObject.addDoubleElement(arrayList, array);
						System.out.println("Enter the Decimal value you want to remove:");
						Double decimalValue=sc.nextDouble();
						listObject.removeElement(arrayList, decimalValue);
						System.out.println("ArrayList after remove the given value:"+arrayList);
						System.out.println("Size of arrayList:"+listObject.sizeOfArrayList(arrayList));
						break;
					}
					case 15:{
						List<Double> arrayList=listObject.creatDoubleList();
						Double[] array=doubleArray();
						arrayList=listObject.addDoubleElement(arrayList, array);
						System.out.println("Enter the position you want to remove: ");
						int position=sc.nextInt();
					    listObject.removeElementAtGivenPosition(arrayList, position);
						System.out.println("ArrayList after remove a element at given position :"+arrayList);
						System.out.println("Size of ArrayList :"+listObject.sizeOfArrayList(arrayList));
						break;
					}//end of case15
					
					case 17:{
						List<String> arrayList=creatStringList();
						System.out.println("Enter the Starting position :");
						int startingPosition=sc.nextInt();
						System.out.println("Enter the Ending position :");
						int endingPosition=sc.nextInt();
						System.out.println("ArrayList :"+arrayList);
						List<String> subArrayList=listObject.subArrayList(arrayList, startingPosition, endingPosition);
						System.out.println("Sub ArrayList :"+subArrayList);
						listObject.removeSubArrayList(arrayList, subArrayList);
						System.out.println("ArrayList after remove subarraylist :"+arrayList);
						System.out.println("Size of final ArrayList :"+listObject.sizeOfArrayList(arrayList));
						break;
					}
					case 18:{
						List<String> arrayList=creatStringList();
						System.out.println("Enter the Starting position :");
						int startingPosition=sc.nextInt();
						System.out.println("Enter the Ending position :");
						int endingPosition=sc.nextInt();
						System.out.println("ArrayList before :"+arrayList);
						List<String> subArrayList=listObject.subArrayList(arrayList, startingPosition, endingPosition);
						System.out.println("Sub ArrayList :"+subArrayList);
						listObject.retainMethod(arrayList, subArrayList);
						System.out.println("Final List :"+arrayList);
						System.out.println("Size of final List : "+listObject.sizeOfArrayList(arrayList));
						break;
					}
					case 19:{
						List<Long> arrayList=listObject.creatLongList();
						Long[] array=longArray();
						arrayList=listObject.addLongElement(arrayList, array);
						listObject.removeAllElement(arrayList);
						System.out.println("ArrayList after remove All :"+arrayList);
						System.out.println("Size of arrayList :"+listObject.sizeOfArrayList(arrayList));
						break;
					}
					case 20:{
						List<String> arrayList=creatStringList();
					System.out.println("Enter value to check is available :");
					String searchValue=sc.next();
					System.out.println("Given value is available :"+listObject.iscontain(arrayList, searchValue));
					System.out.println("ArrayList after remove All :"+arrayList);
					System.out.println("Size of arrayList :"+listObject.sizeOfArrayList(arrayList));
					break;
					}
					
					default:{
						System.out.println("Enter valid case");
					}
					}//end of switch
				}//end of try
				catch(CustomException e) {
					System.out.println("");
					System.out.println(e.getMessage());
				}//end of catch
				
			}//end of if
			else {
				ready=false;
			}//end of else
		}//end of while
		sc.close();
	}
}
