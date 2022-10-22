package beginnersbasictask;

public class SingletonClass {
	
    private static final SingletonClass singletonObject=new SingletonClass();
    
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		return singletonObject;
	}
}
