package beginnersbasictask.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTask {

	public Class<?> loadClass(String fullQualifiedName) throws ClassNotFoundException {
		return Class.forName(fullQualifiedName);
	}//end of loadclass
	
	public Object getObject(Class<?> loadedClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		 Object object=loadedClass.getConstructor().newInstance();
		 return object;
	}//end of getObject
	
	public Method loadSetStringMethod(Class<?> loadedClass,String methodName) throws NoSuchMethodException, SecurityException {
		return loadedClass.getDeclaredMethod(methodName, String.class);
	}
	
	public void invokeSetStringMethod(Method methodName,Object object,String input ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		methodName.invoke(object, input);
	}
	
	public Method loadGetMethod(Class<?> loadedClass,String methodName) throws NoSuchMethodException, SecurityException {
		return loadedClass.getDeclaredMethod(methodName);
	}
	
	public String invokeGetMethod(Method methodName,Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return (String) methodName.invoke(object);
	}
	
	public Object getOverLoadedObject(Class<?> loadedClass,String stringInput,int intValue) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		 Object object=loadedClass.getConstructor(String.class,int.class).newInstance(stringInput,intValue);
		 return object;
	}//end of getObject
	
	public int invokeGetIntMethod(Method methodName,Object overLoadedObject) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return (int) methodName.invoke(overLoadedObject);
	}
}
