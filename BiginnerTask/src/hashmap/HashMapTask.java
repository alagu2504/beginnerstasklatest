package hashmap;
import customexceptionpackage.CustomException;
import customcheck.CustomCheck;
import java.util.HashMap;
import java.util.Map;

public class HashMapTask {
	
	//create map    
	public Map<Object,Object> createMap(){
	    return new HashMap<Object,Object>();
	}
	public Map<String,String> createStringMap(){
	    return new HashMap<String,String>();
	}
	public Map<Integer,Integer> createIntegerMap(){
	    return new HashMap<Integer,Integer>();
	}
	public Map<String,Integer> createStringIntegerMap(){
	    return new HashMap<String,Integer>();
	}
	public Map<String,Object> createStirngObjectMap(){
	    return new HashMap<String,Object>();
	}
	//get size
	public int getSize(Map hashMap)throws CustomException{
		CustomCheck.isNull(hashMap);
	    return hashMap.size();
	}
	//add keys and values
	public void addStringMethod(Map<String,String> hashMap,String key,String values)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.put(key,values);
	}
	public void addIntegerElement(Map<Integer,Integer> hashMap,Integer key,Integer values)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.put(key,values);
	}
	public void addStringIntegerElement(Map<String,Integer> hashMap,String key,Integer values)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.put(key,values);
	}
	public void addStringObjectElement(Map<String,Object> hashMap,String key,Object values)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.put(key,values);
	}
   //Q8
	public Boolean keyIsAvailable(Map<String,String> hashMap,String key)throws CustomException{
		CustomCheck.isNull(hashMap);
	    return hashMap.containsKey(key);
	}
	//Q9
	public Boolean valuesIsAvailable(Map<String,Integer> hashMap,int value)throws CustomException{
		CustomCheck.isNull(hashMap);
	    return hashMap.containsValue(value);
	}
	//Q10
	public void replaceValues(Map<String,String> hashMap,String key,String values)throws CustomException{
		CustomCheck.isNull(hashMap);
	     hashMap.replace(key,values);
	}
	//Q12 //Q11
	public Integer getValue(Map<String,Integer> hashMap,String key)throws CustomException{
		CustomCheck.isNull(hashMap);
	    return hashMap.get(key);
	}
	//Q13
	public String getDefaultValue(Map<String,String> hashMap,String key,String defaultValue)throws CustomException{
		CustomCheck.isNull(hashMap);
	    return hashMap.getOrDefault(key,defaultValue);
	}
	//Q14
	public void removeKey(Map<String,String> hashMap,String key)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.remove(key);
	}
	//Q15
	public void removeIfMatch(Map<String,String> hashMap,String key,String value)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.remove(key,value);
	}
	//Q16
	public void replaceValue(Map<String,String> hashMap,String key,String value)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.replace(key,value);
	}
	//Q17
	public void replaceIfMatch(Map<String,String> hashMap,String key,String oldValue,String newValue)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.replace(key,oldValue,newValue);
	}
	//Q18 transfer all key&values to another map
	public Map<String,String> transferValues(Map<String,String> hashMap,Map<String,String> hashMap1)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap1.putAll(hashMap);
	    return hashMap1;
	}
	//Q19 iterate over a hashmap
	public void printMethod(Map<String,String> hashMap)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.forEach((key,value)->System.out.println("key  :"+key+"  ;  Value   :"+value));
	}
	//Q20 remove all entries in a hashmap
	public void removeAll(Map<String,String> hashMap)throws CustomException{
		CustomCheck.isNull(hashMap);
	    hashMap.clear();
	}

}
