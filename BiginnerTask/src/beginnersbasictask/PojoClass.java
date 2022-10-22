package beginnersbasictask;

public class PojoClass {
	
private String givenString;
private int integer;

public PojoClass() {}

public PojoClass(String inputString,int givenInt) {
	givenString=inputString;
	integer=givenInt;
}
public void setString(String input) {
	givenString=input;
}
public String getString() {
	return givenString;
}
public void setInt(int input) {
	integer=input;
}
public int getInt() {
	return integer;
}

public String toString() {
    return getClass().getName()+" Given String :  "+givenString+";  GivenInt  :"+integer;
}

}
