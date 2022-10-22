package beginnersbasictask;

public class Beginner {
	
 private String givenString;
 
public Beginner() {}

public Beginner(String input) {
	givenString=input;
} 

public String toString() {
    return getClass().getName()+"Given String :  "+givenString;
}

}
