package beginnersbasictask.reflection;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReflectionTest {

	
public static void main(String args[])  {
	Logger logger=Logger.getLogger(ReflectionTest.class.getName());
		ReflectionTask reflectionObject=new ReflectionTask();
		
try(Scanner sc=new Scanner(System.in)){
		logger.log(Level.INFO, "Enter the FullyQualified Name of the class :");
		String fullQualifiedName=sc.next();//beginnersbasictask.PojoClass
			Class<?> loadedClass=reflectionObject.loadClass(fullQualifiedName);
			Object object=reflectionObject.getObject(loadedClass);
			
			logger.log(Level.INFO, "Enter the method name :");
			String methodName1=sc.next();//setString
			Method method=reflectionObject.loadSetStringMethod(loadedClass, methodName1);
			logger.log(Level.INFO, "Enter the String input :");
	        String input=sc.next();
			reflectionObject.invokeSetStringMethod(method, object, input);
			
			logger.log(Level.INFO, "Enter the method name :");
			String methodName2=sc.next();//getString
			Method method2=reflectionObject.loadGetMethod(loadedClass, methodName2);
			logger.log(Level.INFO, ""+reflectionObject.invokeGetMethod(method2, object));
			
			logger.log(Level.INFO, "Enter the String value :");
			String inputString=sc.next();
			logger.log(Level.INFO, "Enter the Int value :");
	        int intValue=sc.nextInt();
	       Object overLoadObject=reflectionObject.getOverLoadedObject(loadedClass, inputString, intValue)	;
			logger.log(Level.INFO, "Given String :"+reflectionObject.invokeGetMethod(method2, overLoadObject));
			
			logger.log(Level.INFO, "Enter the method name :");
			String methodName3=sc.next();//getInt
			Method getIntMethod=reflectionObject.loadGetMethod(loadedClass, methodName3);
			logger.log(Level.INFO, "Given Integer  :"+reflectionObject.invokeGetIntMethod(getIntMethod, overLoadObject));
          }//end of try
		catch (Exception e) {
	        logger.log(Level.INFO, e.toString());
		}
}
}
