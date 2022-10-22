package stringbuilder;
import customexceptionpackage.CustomException;
import java.util.Scanner;
public class StringBuilderTest {
	static StringBuilderLogic object=new StringBuilderLogic();
	static Scanner sc=new Scanner(System.in);
	
	public static StringBuilder createBuilder()throws CustomException {
		StringBuilder stringBuilder=object.getStringBuilder();
		sc.nextLine();
		System.out.println("Enter the string for append :");
		String input1=sc.nextLine();
		stringBuilder=object.appendMethod(stringBuilder, input1);
		return stringBuilder;
	}
	
public static void main(String []args) {
	boolean ready=true;
while(ready) {
	System.out.println("--------------------------------------------------------");
	System.out.println("Enter 11 for terminate the loop");
	System.out.println("");
	System.out.println("Enter the valid case no :");
	int caseNo=sc.nextInt();
	if(caseNo!=11) {
		switch(caseNo) {
		case 1:
		{   
			
			try {
				StringBuilder stringBuilder=object.getStringBuilder();
				System.out.println("Length of the given String :" +object.getLength(stringBuilder));
				sc.nextLine();
				System.out.println("Enter the string for append :");
				String input1=sc.nextLine();
				stringBuilder=object.appendMethod(stringBuilder, input1);
				System.out.println("StringBuilder after append the String :"+stringBuilder);
				System.out.println("Length of the given String :" +object.getLength(stringBuilder));
				break;
                }
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}
		}//end of case1
		case 2:{
			try {			
				StringBuilder stringBuilder=createBuilder();
			System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
			System.out.println("Enter the no of string you want :");
			int size=sc.nextInt();
			String []stringArray=new String[size];
			for(int i=0;i<size;i++) {
				System.out.println("Enter the String :");
				stringArray[i]=sc.next();
			}		
			System.out.println("Enter the symbol you want to insert :");
			String insertValue =sc.next();
			System.out.println("StringBuilder after append the string :"+object.appendArray(stringBuilder, stringArray,insertValue));
			System.out.println("Length of the String Builder :"+object.getLength(object.appendArray(stringBuilder, stringArray,insertValue)));
			break;
            }
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}    
		}//end of case2
		
		case 3:{
			try {
				StringBuilder stringBuilder=createBuilder();
				System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
				System.out.println("Enter the string you want to insert :");
				String input2=sc.next();
				System.out.println("Enter the symbol or char you want to replace:");
				String delimiter=sc.next();
				StringBuilder output=object.insertString(stringBuilder,input2,delimiter);
                System.out.println("StringBuilder after insert :"+output);
                System.out.println("Length of the StringBuilder after insert string :"+output);
			    break;
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			} 		}//end of case3
		
		case 4:{
			try {
				StringBuilder stringBuilder=createBuilder();
				System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
				System.out.println("Enter the symbol :");
				char symbol=sc.next().charAt(0);
				String delimiter=String.valueOf(symbol);
				System.out.println("StringBuilder After the delete operation :"+object.deleteSubString(stringBuilder,delimiter));
				System.out.println("Length of the StringBuilder after delete operation :"+object.getLength(object.deleteSubString(stringBuilder,delimiter)));
			    break;
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}
		}//end of case 4
		case 5:{
			try {
				StringBuilder stringBuilder=createBuilder();
				System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
				System.out.println("Search symbol :");
				char searchSymbol=sc.next().charAt(0);
				System.out.println("Replace symbol :");
				char symbol=sc.next().charAt(0);
				String replaceSymbol=String.valueOf(symbol);
				System.out.println("StringBUilder After insert '-' :"+object.replaceChar(stringBuilder,searchSymbol,replaceSymbol));
				System.out.println("Length of the StringBuilder after insert '- ' : "+object.getLength(object.replaceChar(stringBuilder,searchSymbol,replaceSymbol)));
			    break;
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}
		}//end of case6
		case 6:{
			try {
				StringBuilder stringBuilder=createBuilder();
				System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
				System.out.println("StringBuilder After reverse :"+object.reverseStringBuilder(stringBuilder));
				System.out.println("Length of the StringBuilder after reverse :"+object.getLength(object.reverseStringBuilder(stringBuilder)));
			    break;
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}
		}//end of case6
		case 7:{
			try {
				StringBuilder stringBuilder=createBuilder();
				System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
				System.out.println("Starting index :");
				int startingIndex=sc.nextInt();
				System.out.println("Ending Index :");
				int endingIndex=sc.nextInt();
				stringBuilder=object.deleteCharacters(stringBuilder, startingIndex, endingIndex);
				System.out.println("StringBuilder after delete the Characters :"+stringBuilder);
				System.out.println("Length of the StringBuilder after delete the characters :"+object.getLength(stringBuilder));
			    break;
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}
		}//end of case7
		case 8:{
			try {
				StringBuilder stringBuilder=createBuilder();
				System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
				System.out.println("Starting index :");
				int startingIndex=sc.nextInt();
				System.out.println("Ending Index :");
				int endingIndex=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter String to replace :");
				String stringToReplace=sc.nextLine();
				System.out.println("StringBuilder after replace characters :"+object.replaceCharacters(stringBuilder, startingIndex, endingIndex,stringToReplace));
				System.out.println("Length of StringBuilder after repalce characters :"+object.getLength(object.replaceCharacters(stringBuilder, startingIndex, endingIndex,stringToReplace)));
			    break;
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}
		}//end of case8
		case 9:{
			try {
				StringBuilder stringBuilder=createBuilder();
				System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
				System.out.println("enter the char to find first index  :");
				char symbol=sc.next().charAt(0);
				String searchChar=String.valueOf(symbol);
				System.out.println("Index of first occurrence of given char :"+object.firstIndex(stringBuilder, searchChar));
			    break;
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}
		}//end of case9
		//method10
		case 10:{
			try {
				StringBuilder stringBuilder=createBuilder();
				System.out.println("Length of the given String Builder:" +object.getLength(stringBuilder));
				System.out.println("enter the char to find last index  :");
				char symbol=sc.next().charAt(0);
				String searchChar=String.valueOf(symbol);
				System.out.println("Index of last occurrence of given char :"+object.lastIndex(stringBuilder, searchChar));
			    break;
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
				break;
			}
		}//end of case10
		
		default:{
			System.out.println("Enter the valid case no");
		}
		}//end of switch
		
	}
	else {
		ready=false;
	}
}
}
}
