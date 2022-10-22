package customcheck;

import customexceptionpackage.CustomException;

public class CustomCheck {
	
	public static void isNull(Object input) throws CustomException{
		if(input==null) {
			throw new CustomException("Given input should Not Be Null");
		}
}
	
}
	
