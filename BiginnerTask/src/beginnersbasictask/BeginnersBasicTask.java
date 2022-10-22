package beginnersbasictask;
import java.util.Properties;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import customexceptionpackage.CustomException;
import customcheck.CustomCheck;

public class BeginnersBasicTask {	
	//create properties object
	public Properties creatProp() {
		return new Properties();
	}
	//write file
	public void writeFile(String file,String inputString) throws IOException, CustomException {
		CustomCheck.isNull(inputString);
		try(FileOutputStream fileOutputStream=new FileOutputStream(file,true)){
		byte[] array=inputString.getBytes();
		fileOutputStream.write(array);
		}
	}
	//read File
	public StringBuilder readFile(String file) throws IOException, CustomException{
		try(FileInputStream fileInputputStream=new FileInputStream(file)){
		int byteValue=0;
		StringBuilder stringBuilder=new StringBuilder();
		while((byteValue= fileInputputStream.read())!=-1) { 
//			System.out.print((char)byteValue);	
			stringBuilder.append((char)byteValue);
		}
		return stringBuilder;
		}
	} //end of read file
	
	public Properties createProperties(String key,String value) {
		Properties propertiesObject=new Properties();
		propertiesObject.setProperty(key, value);
		return propertiesObject;
	}//end of createproperties
	
	public void storePropertiesValues(Properties propertiesObject,String file) throws IOException, CustomException {
		CustomCheck.isNull(propertiesObject);
		try(FileOutputStream fileOutputStream=new FileOutputStream(file)){
		propertiesObject.store(fileOutputStream, "Store properties values in a file");
		}
	}
	//load value
	
	public void loadMethod(Properties propertiesObject,String file) throws IOException, CustomException {
		CustomCheck.isNull(propertiesObject);
		try(FileInputStream fileInputStream=new FileInputStream(file)){
		propertiesObject.load(fileInputStream);
		}
		//return propertiesObject;
	}//end of load method
	
}
