package regularexpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import customexceptionpackage.CustomException;
import customcheck.CustomCheck;

public class RegularExpressionTask {
	
	public boolean chechIfMatchWithPattern(Pattern givenPattern,String input) {
        Matcher matcherObject = givenPattern.matcher(input);
        return matcherObject.matches();
	}
	
	public Pattern getMobileNumberValidator() {
		return Pattern.compile("^[789]\\d{9}$");
	}
	public Pattern getAlphaNumericPattern() {
		return Pattern.compile("^[a-zA-Z\\d]+$");
	}
	
	public Pattern isStartsWith(String input) {
		return Pattern.compile("^"+input+".*");
	}
	
	public Pattern isContains(String expression) {
		return Pattern.compile(".*\\s"+expression+"\\s*.*");
	}
	
	public Pattern isEndsWith(String expression) {
		return Pattern.compile(".*\\s"+expression+"$");
	}
	
	public Pattern isExactlyMatch(String expression) {
		return Pattern.compile("^"+expression+"$");
	}
	
	public Pattern isMatchWithCaseInsensitive(String expression) {
		return Pattern.compile("^(?i)"+expression+"$");
	}
	public Pattern emailValidation() {
		return Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$");//^[a-z]+[a-z0-9]*@[a-z]+\\.[a-z]
	}
	public boolean isInRange(List<String> stringList) throws CustomException {
		Pattern pattern=Pattern.compile("^[A-Za-z]{1,6}$");
		boolean range=true;
	for(String inputs:stringList) {
        Matcher matcherObject = pattern.matcher(inputs);
        if(matcherObject.find()!=true) {
        	range=false;
        }
	}
		return range;
	}
	public Map<String, List<Integer>> hashMap(List<String> stringList1,List<String> stringList2 ) throws CustomException {
		CustomCheck.isNull(stringList1);
		CustomCheck.isNull(stringList2);
		Map<String,List<Integer>> matchingMap=new HashMap<>();
		for(int i=0;i<stringList2.size();i++) {
			List<Integer> indexValues=new ArrayList<>();
			Pattern pattern=Pattern.compile("^"+stringList2.get(i)+"$");
			for(int j=0;j<stringList1.size();j++) {
				Matcher matchObject=pattern.matcher(stringList1.get(j));
				if(matchObject.find()) {
					indexValues.add(j);
				}
			}
			matchingMap.put(stringList2.get(i), indexValues);
		}
		return matchingMap;
	}
	public List<String> htmlTags(String input){
		List<String> htmlList=new ArrayList<String>();
		Pattern pattern=Pattern.compile("(</?\\w*>)");//(</?[a-z]*>)
		Matcher matchObject=pattern.matcher(input);
        while(matchObject.find()) {
        	htmlList.add(matchObject.group());
        }
        return htmlList;
	}
	
}
