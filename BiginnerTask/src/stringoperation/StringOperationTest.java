package stringoperation;
import customexceptionpackage.CustomException;
import java.util.Scanner;
import java.util.Arrays;
public class StringOperationTest{
public static void main(String [] args){
 Scanner sc=new Scanner(System.in);
boolean value=true;
StringOperation object=new StringOperation();

while(value){
System.out.println("----------------------------------------------");

System.out.println("Enter your caseno :");
int caseno=sc.nextInt();

if(caseno!=22){

switch(caseno){


case 1:
{
try{
System.out.println("Length of the given String :"+object.getLength(args[0]));
}
catch(Exception e){
System.out.println("check the command line");
}//catchblock
break;
}//case1

case 2:{
sc.nextLine();
System.out.println("Enter the String :");
String input2=sc.nextLine();
try{
System.out.println("String to character :"+Arrays.toString(object.stringToCharArray(input2)));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case2

case 3:{
sc.nextLine();
System.out.println("Enter the String :");
String input2=sc.nextLine(); 
try{
System.out.println("Last character of the given string :"+object.getLastCharacter(input2));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case3


case 4:{
sc.nextLine();
System.out.println("Enter the String :");
String input2=sc.nextLine();
System.out.println("Enter a character for check no of Occurrence  :");
char checkChar=sc.next().charAt(0); 
try{
System.out.println("No of occurrrence of "+checkChar+" int a "+input2+" is  :"+object.noOfOccurrence(input2,checkChar));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end ofcase4

case 5:{
sc.nextLine();
System.out.println("Enter the String :");
String input2=sc.nextLine();
System.out.println("Enter the character for find the greatest position :");
char character=sc.next().charAt(0);
try{
System.out.println("Greatest position of a given letter :" +object.greatestPosition(input2,character));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//case 5


case 6:{
sc.nextLine();
System.out.println("Enter the String :");
String input2=sc.nextLine();
System.out.println("Enter the integer:");
int noNeed=sc.nextInt();
try{
System.out.println("substirng of your string :"+object.lastSubString(input2,noNeed));
}
catch(CustomException e){
System.out.println(e.getMessage());
//System.out.println(e);
}
break;
}//end of case 6


case 7:{
sc.nextLine();
System.out.println("Enter the String :");
String input2=sc.nextLine();
System.out.println("Enter the no :");
int noNeed=sc.nextInt();
try{System.out.println("subString :"+object.firstSubString(input2,noNeed));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case7


case 8:{
sc.nextLine();
System.out.println("Enter the String you want to change :");
String input1=sc.nextLine();
System.out.println("Enter the string use to change :");
String input2=sc.nextLine();
try{System.out.println("Changed String : "+object.changingString(input1,input2));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end  of case 8


case 9:{
sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
System.out.println("Enter the string for check the given String is starts with it: ");
String input2=sc.nextLine();
try{
System.out.println("starts with it :"+object.isStarts(input1,input2));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}


case 10:{
sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
System.out.println("Enter the string for check the given String is ends with it: ");
String input2=sc.nextLine();
try{
System.out.println("ends with it :"+object.isEnds(input1,input2));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case10

case 11:{
sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
try{
System.out.println("Uppercase String :"+object.toUpperCase(input1));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}


case 12:{
sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
try{
System.out.println("Lowercase String :"+object.toLowerCase(input1));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}

case 13:{
	sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
try{
System.out.println("Reversed string : "+object.toReverse(input1));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case 13

case 14:{
sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
try{
System.out.println("Multiline string :"+object.multiLineString(input1));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case 14

case 15:{
sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
try{System.out.println("MultiLine string without space :"+object.withOutSpace(input1));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case 15

case 16:{
sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
try{
System.out.println("Multiline String with curly braces :"+Arrays.toString(object.toStringWithCurlyBraces(input1)));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case16

case 17:{
System.out.println("Enter the no of string you want :");
int size=sc.nextInt();
sc.nextLine();
String []array=new String[size];
for(int i=0;i<size;i++){
System.out.println("Enter the String :");
array[i]=sc.nextLine();
}//end of for
try{
System.out.println("String after merge with - :"+object.afterMerge(array));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case 17


case 18:{
sc.nextLine();
System.out.println("Enter the String 1:");
String input1=sc.nextLine();
System.out.println("Enter the String 2 :");
String input2=sc.nextLine();
try{
System.out.println("Given strings are equals :"+object.withCaseSens(input1,input2));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//case 18

case 19:{
sc.nextLine();
System.out.println("Enter the String 1:");
String input1=sc.nextLine();
System.out.println("Enter the String 2 :");
String input2=sc.nextLine();
try{System.out.println("Given strings are equals or not :"+object.withOutCaseSens(input1,input2));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case 19

case 20:{
sc.nextLine();
System.out.println("Enter the String :");
String input1=sc.nextLine();
try{
System.out.println("After the trim operation :"+object.noSpace(input1));
}
catch(CustomException e){
System.out.println(e.getMessage());
}
break;
}//end of case 20

default:{
System.out.println("Enter the valid case ");
break;
}
}//end of switchblock
}//endofif
else{
value=false;
}//else

}//end of while loop
sc.close();
}
}


