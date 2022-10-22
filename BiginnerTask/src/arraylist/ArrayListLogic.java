package arraylist;
import java.util.ArrayList;
import java.util.List;
import customexceptionpackage.CustomException;
import customcheck.CustomCheck;
import java.util.Iterator;

public class ArrayListLogic {
	//isValid
	public void isValid(List arrayList,int position)throws CustomException {
		int size=sizeOfArrayList(arrayList);
		if(position>=size||position<0) {
			throw new CustomException("Enter the valid index value");
		}
	}
	//create list
	public List<Object> creatArrayList(){
		return new ArrayList<Object>();
	}
	//StringList
	public List<String> creatStringList(){
		return new ArrayList<String>();
	}
	//IntegerList
	public List<Integer> creatIntegerList(){
		return new ArrayList<Integer>();
	}
	//DoubleList
	//IntegerList
    public List<Double> creatDoubleList(){
	return new ArrayList<Double>();
	}
	//Longlist
	public List<Long> creatLongList(){
	return new ArrayList<Long>();
	}
	
	
	//add object  method
	public  List<Object> addElement(List<Object> arrayList,Object... input)throws CustomException{
	CustomCheck.isNull(arrayList);
	for(Object input1:input) {
	arrayList.add(input1);
	}
	return arrayList;
	}
	
	//add String  method
	public  List<String> addStringElement(List<String> arrayList,String... input)throws CustomException{
	CustomCheck.isNull(arrayList);
	for(String input1:input) {
	arrayList.add(input1);
	}
	return arrayList;
	}
	//add Decimal  method
	public  List<Double> addDoubleElement(List<Double> arrayList,Double... input)throws CustomException{
	CustomCheck.isNull(arrayList);
	for(Double input1:input) {
	arrayList.add(input1);
	}
	return arrayList;
	}
	//add Long  method
	public  List<Long> addLongElement(List<Long> arrayList,Long... input)throws CustomException{
	CustomCheck.isNull(arrayList);
	for(Long input1:input) {
	arrayList.add(input1);
	}
	return arrayList;
	}	
	//add Long  method
	public  List<Integer> addIntegerElement(List<Integer> arrayList,Integer... input)throws CustomException{
	CustomCheck.isNull(arrayList);
	for(Integer input1:input) {
	arrayList.add(input1);
	}
	return arrayList;
	}
	//Q1
	public int sizeOfArrayList(List arrayList) throws CustomException{
		CustomCheck.isNull(arrayList);
		return arrayList.size();
	}
	
	//Q6
	public int getFirstIndex(List<String> arrayList,String searchValue) throws CustomException{
		CustomCheck.isNull(arrayList);
		return arrayList.indexOf(searchValue);
	}
	//Q7
	public void iteratorMethod(List<String> arrayList)throws CustomException{
		CustomCheck.isNull(arrayList);
		for(Iterator<String> iterator1=arrayList.iterator();iterator1.hasNext();) {
			System.out.println(iterator1.next());
	}
	}
	//Q8
	//print the value at a given index
	public  String getValue(List<String> arrayList,int position)  throws CustomException{
		isValid(arrayList,position);
		return arrayList.get(position);
	}
	// Q9 lastIndex
	public int getLastIndex(List<String> arrayList,String searchValue) throws CustomException{
		CustomCheck.isNull(arrayList);
		return arrayList.lastIndexOf(searchValue);
	}
	//Q10 add string to given position
	public void insertMethod(List<String> arrayList, String insertValue,int position)throws CustomException{
		isValid(arrayList,position);
		arrayList.add(position,insertValue);
		//return arrayList1;
	}
	//Q11 subArraylist
	public List<String> subArrayList(List<String> arrayList,int startingIndex,int endingIndex)throws CustomException{
		int size=sizeOfArrayList(arrayList);
		if(startingIndex<0||endingIndex<0||endingIndex>size||startingIndex>=endingIndex) {
			throw new CustomException("Enter the valid index value");
		}
		List<String> outputSubList=arrayList.subList(startingIndex, endingIndex+1);
		return outputSubList;
	}
	//Q12 addAll
	public List<String> addAllElement(List<String>arrayList,List<String>arrayList1)throws CustomException{
		CustomCheck.isNull(arrayList);
		 arrayList.addAll(arrayList1);
		 return arrayList;
	}

	//Q13 add ArrayList with position
	public List<String> addListWithPosition(List<String> arrayList,List<String> arrayList1,int position)throws CustomException{
		isValid(arrayList,position);
		arrayList.addAll(position, arrayList1);
		return arrayList;
	}
	//Q14 remove element
	public void removeElement(List<Double> arrayList,Double inputToRemove)throws CustomException{
		CustomCheck.isNull(arrayList);
		arrayList.remove(inputToRemove);
	}
	//Q15 remove element at given position
	public void removeElementAtGivenPosition(List<Double> arrayList,int position)throws CustomException{
		isValid(arrayList,position);
        arrayList.remove(position);
	}
	//Q17 remove element which are in the subarraylist
	public void removeSubArrayList(List<String> arrayList,List<String> subArrayList)throws CustomException{
		CustomCheck.isNull(arrayList);
		arrayList.removeAll(subArrayList);
	}
	//Q18 remove element which are not in the sublist
	public void retainMethod(List<String> arrayList,List<String> subArrayList)throws CustomException{
		CustomCheck.isNull(arrayList);
		arrayList.retainAll(subArrayList);
	}
	//Q19 remove All
	public void removeAllElement(List<Long> arrayList)throws CustomException{
		CustomCheck.isNull(arrayList);
        arrayList.clear();
	}
	//Q20 contains method
	public boolean  iscontain(List<String> arrayList,String input)throws CustomException{
		CustomCheck.isNull(arrayList);
		return arrayList.contains(input);

	}
}
