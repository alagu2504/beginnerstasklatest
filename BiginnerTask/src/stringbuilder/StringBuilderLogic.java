package stringbuilder;
import customexceptionpackage.CustomException;
import customcheck.CustomCheck;
public class StringBuilderLogic {
	 
      //getStringBuilder	
	  public StringBuilder getStringBuilder() {
			StringBuilder stringBuilder=new StringBuilder();
			return stringBuilder;
		}
	  //append method
	  public StringBuilder appendMethod(StringBuilder stringBuilder,String...inputs) throws CustomException{
			CustomCheck.isNull(stringBuilder);
			CustomCheck.isNull(inputs);
      for(int i=0;i<inputs.length;i++) {
    	  stringBuilder.append(inputs[i]);
      }
      return stringBuilder;
	  }	
	//isvalid
	public void isValid(int startingIndex,int endingIndex,int length)throws CustomException {
		
		if(startingIndex<0||endingIndex<0||startingIndex>=length||endingIndex<startingIndex||endingIndex>length) {
			throw new CustomException("Enter the valid position");
		}
	}	
	//method1
	public int getLength(StringBuilder stringBuilder)throws CustomException{
		CustomCheck.isNull(stringBuilder);
	return stringBuilder.length();
	}//end of method1
	//method2
	public StringBuilder appendArray(StringBuilder stringBuilder,String[]array,String insertValue) throws CustomException{
		for(int i=0;i<array.length;i++) {
			int length=getLength(stringBuilder);
			if(length!=0) {
				appendMethod(stringBuilder,insertValue);
			}
			appendMethod(stringBuilder,array[i]);
		}
		return stringBuilder;
	}//end of method 2
	//method3
	public StringBuilder insertString(StringBuilder stringBuilder,String insertString,String delimiter)throws CustomException {
		CustomCheck.isNull(insertString);
		int position=firstIndex(stringBuilder,delimiter);
		 stringBuilder=stringBuilder.replace(position,position+1, insertString);
        return stringBuilder;
	}//end of method3
	//method4
	public StringBuilder deleteSubString(StringBuilder stringBuilder,String delimiter)throws CustomException{
		int position=firstIndex(stringBuilder,delimiter);
		stringBuilder=stringBuilder.delete(0, position);
		return stringBuilder;
	}//end of method4
	//method5
	public StringBuilder replaceChar(StringBuilder stringBuilder,char searchSymbol,String replaceSymbol)throws CustomException{
		int length=getLength(stringBuilder);
		for(int i=0;i<length;i++) {
			if(stringBuilder.charAt(i)==searchSymbol) {
				stringBuilder.replace(i, i+1, replaceSymbol);
			}
		}
		return stringBuilder;
	}//end of method5
	//method6
	public StringBuilder reverseStringBuilder(StringBuilder stringBuilder)throws CustomException {
		CustomCheck.isNull(stringBuilder);
		return stringBuilder.reverse();
	}//end of method6
	//method7
	public StringBuilder deleteCharacters(StringBuilder stringBuilder,int startingIndex,int endingIndex)throws CustomException  {
		int length=getLength(stringBuilder);
		isValid(startingIndex,endingIndex,length);
        return stringBuilder.delete(startingIndex, endingIndex+1);
	}//end of method7
	//method8
	public StringBuilder replaceCharacters(StringBuilder stringBuilder,int startingIndex,int endingIndex,String inputString) throws CustomException{
		CustomCheck.isNull(inputString);
		int length=getLength(stringBuilder);
		isValid(startingIndex,endingIndex,length);
        return stringBuilder.replace(startingIndex, endingIndex+1, inputString);
	}//end of method8
	//method9
	public int firstIndex(StringBuilder stringBuilder,String searchCharacter) throws CustomException{
		CustomCheck.isNull(stringBuilder);
		CustomCheck.isNull(searchCharacter);
        return stringBuilder.indexOf(searchCharacter);
	}//end of method9
	//method10
	public int lastIndex(StringBuilder stringBuilder,String searchCharacter)  throws CustomException{
		CustomCheck.isNull(stringBuilder);
		CustomCheck.isNull(searchCharacter);
        return stringBuilder.lastIndexOf(searchCharacter);
	}//end of method10
	
}

