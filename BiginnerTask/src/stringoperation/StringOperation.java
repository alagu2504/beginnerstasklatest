package stringoperation;
import customexceptionpackage.CustomException;
import customcheck.CustomCheck;

public class StringOperation{

public void isEmpty(int length)throws CustomException{
if(length==0){
throw new CustomException("Given string is empty");
}
}

public void isLessThan(int inputStringLength,int integerInput)throws CustomException{
if(inputStringLength<integerInput){
throw new CustomException("Given input String length is not enough");
}
}
//method1
public int getLength(String stringValue)throws CustomException{
CustomCheck.isNull(stringValue);
int length=stringValue.length();
return length;
}//end of getLength

//method2
public char[] stringToCharArray(String stringValue)throws CustomException{
CustomCheck.isNull(stringValue);
char[] charArray=stringValue.toCharArray();
return charArray;     
}//end of toCharArray

//method3
public char getLastCharacter(String stringValue)throws CustomException{
int length=getLength(stringValue);
return stringValue.charAt(length-1);
}//end of getLastCharacter

//method4
public int noOfOccurrence(String stringValue,char inputCharacter)throws CustomException{
int count=0;
int length=getLength(stringValue);
for(int i=0;i<length;i++){
if(stringValue.charAt(i)==inputCharacter){
count++;
}
}//end of for loop
return count;
}//end of no oc 

//method5
public int greatestPosition(String stringValue,char inputCharacter)throws CustomException{
CustomCheck.isNull(stringValue);
return stringValue.lastIndexOf(inputCharacter);
}//end of greatest position

//method6
public String lastSubString(String inputString,int inputNo)throws CustomException{
int length=getLength(inputString);
isLessThan(length,inputNo);
int startingPoint=length-inputNo;
String subStr=inputString.substring(startingPoint);
return subStr;
}//end of sub String

//method7
public String firstSubString(String inputString,int inputNo)throws CustomException{
int length=getLength(inputString);
isLessThan(length,inputNo);
String subStr=inputString.substring(0,inputNo);
return subStr;
}//end of first substring method 

//method8
public String changingString(String inputString1,String inputString2)throws CustomException{
int length1=getLength(inputString1);
int length2=getLength(inputString2);
isLessThan(length1,length2);
String subString=inputString1.substring(0,length2);
return inputString1.replaceFirst(subString,inputString2);
}//end of changingString

//method9
public boolean isStarts(String inputString,String searchString)throws CustomException{
int length=getLength(inputString);
int length1=getLength(searchString);
isLessThan(length,length1);
return inputString.startsWith(searchString);
}//end of isStarts


//method10
public boolean isEnds(String inputString,String searchString)throws CustomException{
int length=getLength(inputString);
int length1=getLength(searchString);
isLessThan(length,length1);
return inputString.endsWith(searchString);
}//end of isends meth


//method11
public String toUpperCase(String inputString)throws CustomException{
CustomCheck.isNull(inputString);
return inputString.toUpperCase();
}//end of touppecase

//method12
public String toLowerCase(String inputString)throws CustomException{
CustomCheck.isNull(inputString);
return inputString.toLowerCase();
}//end of lowercase

//method13
public String toReverse(String inputString)throws CustomException{
	CustomCheck.isNull(inputString);
char []characterArray=inputString.toCharArray();
int length=characterArray.length;
int reverseInt=length-1;
for(int i=0;i<length/2;i++,reverseInt--) {
	char temp=characterArray[i];
	characterArray[i]=characterArray[reverseInt];
	characterArray[reverseInt]=temp;
}
String reverseString=String.valueOf(characterArray);
return reverseString;
}//end of reverse

//method14
public String multiLineString(String inputString)throws CustomException{
CustomCheck.isNull(inputString);
return inputString;
}//end of multiline

//method15
public String withOutSpace(String inputString)throws CustomException{
CustomCheck.isNull(inputString);
String stringArray[]=inputString.split(" ");
String opString="";
for(String string : stringArray){
opString=opString+string;
}//end of foreach
return opString;
}//end of withoutspace

//method16
public String[] toStringWithCurlyBraces(String inputString)throws CustomException{
CustomCheck.isNull(inputString);
String [] stringArray=inputString.split(" ");
return stringArray;
}//end of string array

//method17
public String afterMerge(String[] array)throws CustomException{
if(array==null){
throw new CustomException("String array should not be null");
}
String opString="";
return opString.join("-",array);
}//end of afterMerge

//method18
public boolean withCaseSens(String inputString1,String inputString2)throws CustomException{
CustomCheck.isNull(inputString1);
CustomCheck.isNull(inputString2);
return inputString1.equals(inputString2);
}//end of withCaseSens


//method19
public boolean withOutCaseSens(String inputString1,String inputString2)throws CustomException{
CustomCheck.isNull(inputString1);
CustomCheck.isNull(inputString2);
return inputString1.equalsIgnoreCase(inputString2);
}//end of withoutcase

//method20
public String noSpace(String inputString)throws CustomException{
CustomCheck.isNull(inputString);
return inputString.trim();
}//end of method 20

}
