package inheritance;

public class Car {
	
	private int yearOfMake;
	private String engineNumber;
	private String type;
	//default constructor
	public Car() {
		
	}
	public Car(String inputString) {
		System.out.println(inputString);
	}//end of constructor
	
public int getYearOfMake() {
	return yearOfMake;
}
public void setYearOfMake(int yearofMakeDate) {
	this.yearOfMake=yearofMakeDate;
}

public String getEngineNumber() {
	return engineNumber;
}
public void setEngineNumber(String engineNo) {
	this.engineNumber=engineNo;
}

public String getType() {
	return type;
}
public void setType(String carType) {
	this.type=carType;
}
//maintenance method
public String maintenance() {
	String output="Car Under maintenance";
	return output;
}


}
