package jdbctask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JdbcTask {
	
    Logger logger=Logger.getLogger(JdbcTask.class.getName());
    
    public 	List< Map<String,Object>> getParentData(String query) throws SQLException, ClassNotFoundException {
		List< Map<String,Object>> listObject=new ArrayList<>();
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			ResultSet resultSet=statement.executeQuery();
			ResultSetMetaData metaData=resultSet.getMetaData();
			int columnCount=metaData.getColumnCount();
			while(resultSet.next()) {
		        Map<String,Object> mapObject=new HashMap<>();
		        for(int i=1;i<=columnCount;i++) {
		        	mapObject.put(metaData.getColumnName(i), resultSet.getObject(i));
		        }
				listObject.add(mapObject);
			}//end of for loop
		}
		return listObject;
    }
    public List< Map<String,Object>> getCommonData(String query) throws SQLException, ClassNotFoundException {
		List< Map<String,Object>> listObject=new ArrayList<>();
  		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
  		 	ResultSet resultSet=statement.executeQuery();
  		 	ResultSetMetaData metaData=resultSet.getMetaData();
			int columnCount=metaData.getColumnCount();
  	  		while(resultSet.next()) {
  	  		 Map<String,Object> mapObject=new HashMap<>();
		        for(int i=1;i<=columnCount;i++) {
		        	mapObject.put(metaData.getColumnName(i), resultSet.getObject(i));
		        }
				listObject.add(mapObject);
  	  		}//end of for loop
  		}
  		return listObject;
      }
        
	public  Connection getConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/incubationDB";
		String driver="com.mysql.cj.jdbc.Driver";
        String userName="alagu";
        String password="mysql2504.";
       
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url, userName, password);
	        logger.log(Level.INFO, "Connected");
	        return connection;
			}//end of getConnection
	
	public void creatTable(String query) throws SQLException, ClassNotFoundException {
        try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
            statement.executeUpdate();
        }
        logger.info( "Table created");
	}//end of createTable
	public String parentQuery() {
		return "CREATE TABLE IF NOT EXISTS Employee(EMPLOYEE_ID int NOT NULL AUTO_INCREMENT,"
		+ "EMPLOYEE_NAME VARCHAR(30) NOT NULL,MOBILE VARCHAR(10) NOT NULL,EMAIL VARCHAR(30),"
		+ "DEPARTMENT VARCHAR(20),PRIMARY KEY (EMPLOYEE_ID))";
	}
	public String dependentQuery() {
            return "CREATE TABLE IF NOT EXISTS EmployeeInfo (ID int NOT NULL AUTO_INCREMENT,NAME VARCHAR(30) NOT NULL, "
			+ "AGE int NOT NULL,RELATIONSHIP VARCHAR(20),EMPLOYEE_ID int, PRIMARY KEY (ID),"
			+ "FOREIGN KEY(EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID) ON DELETE CASCADE)";
	}
	
	public void insertMethodOfParent(String name,String mobileNumber,String emailId,String department) throws ClassNotFoundException, SQLException {
		String query="INSERT INTO Employee(EMPLOYEE_NAME,MOBILE,EMAIL,DEPARTMENT) VALUES(?,?,?,?)";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setString(1, name);
			statement.setString(2, mobileNumber);
			statement.setString(3, emailId);
			statement.setString(4, department);
			statement.executeUpdate();
		}
        logger.info("successfully inserted");
	}//end of insertMethod
	
	public void insertMethodForDependent(String name,int age,String relationShip,int employeeId) throws ClassNotFoundException, SQLException {
		String query="INSERT INTO EmployeeInfo(NAME,AGE,RELATIONSHIP,EMPLOYEE_ID) VALUES(?,?,?,?)";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, relationShip);
			statement.setInt(4, employeeId);
			statement.executeUpdate();
		}
        logger.info("successfully inserted");
	}//end of insertMethod
	public  List< Map<String,Object>>  getInfo(String tableName,String column,String searchInput) throws ClassNotFoundException, SQLException{
		List< Map<String,Object>> listObject=new ArrayList<>();
		String query="SELECT * FROM "+tableName+" WHERE "+column+" = "+"'"+searchInput+"'";
		listObject= getParentData( query);
     return listObject;
	}
	
	public void updateTable(String tableName,int employeeId,String column,String updateValue) throws ClassNotFoundException, SQLException {
		String query="UPDATE "+tableName+" SET "+column+" = ? "+" WHERE EMPLOYEE_ID = ? ";
		try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(query)){
			statement.setString(1, updateValue);
		    statement.setInt(2, employeeId);
			statement.executeUpdate();
		
		}
	}//end of updateTable
	
	public  List< Map<String,Object>> getTableInfoWithLimit(String tableName,int range) throws ClassNotFoundException, SQLException{
		List< Map<String,Object>> listObject=new ArrayList<>();
		String query="SELECT * FROM "+tableName+" LIMIT "+range;
		listObject= getParentData(query);
     return listObject;
	}//end of getFullInfo
	
	public  List< Map<String,Object>> sortTable(String tableName,int range,String column) throws ClassNotFoundException, SQLException{
		List< Map<String,Object>> listObject=new ArrayList<>();
		String query="SELECT * FROM "+tableName+" ORDER BY "+column+" LIMIT "+range;
		listObject= getParentData( query);
     return listObject;
	}//END OF SORT TABLE
	
	public void  deleteRow(int employeeId) throws ClassNotFoundException, SQLException{
		String query="DELETE FROM Employee WHERE EMPLOYEE_ID = ?";
		try(Connection connection=getConnection();PreparedStatement info=connection.prepareStatement(query)){
			info.setInt(1, employeeId);
			info.executeUpdate();
		}
	}
	
	public   List< Map<String,Object>>  getCommonInfo(int employeeId) throws ClassNotFoundException, SQLException{
		List< Map<String,Object>> listObject=new ArrayList<>();
		String query="SELECT Employee.EMPLOYEE_ID,Employee.EMPLOYEE_NAME,EmployeeInfo.ID,EmployeeInfo.NAME,EmployeeInfo.AGE,"
				+ "EmployeeInfo.RELATIONSHIP FROM EmployeeInfo INNER JOIN Employee ON EmployeeInfo.EMPLOYEE_ID=Employee.EMPLOYEE_ID "
				+ "AND EmployeeInfo.EMPLOYEE_ID="+employeeId;
		listObject=getCommonData(query);
        return listObject;  
        }
	public List< Map<String,Object>> getCommonDetailsWithLimit(String employeeIds) throws ClassNotFoundException, SQLException{
		List< Map<String,Object>> listObject=new ArrayList<>();
		String query="SELECT Employee.EMPLOYEE_ID,Employee.EMPLOYEE_NAME,EmployeeInfo.ID,EmployeeInfo.NAME,EmployeeInfo.AGE,"
				+ "EmployeeInfo.RELATIONSHIP FROM EmployeeInfo INNER JOIN Employee ON EmployeeInfo.EMPLOYEE_ID=Employee.EMPLOYEE_ID AND Employee.EMPLOYEE_ID IN ("
				+employeeIds+ ") ORDER BY Employee.EMPLOYEE_NAME ";
		listObject=getCommonData(query);
        return listObject;  
        }
	
public String getEmployeeIds(List< Map<String,Object>> listObject) {
	   StringBuilder stringBuilder=new StringBuilder();
       for(Map<String,Object> mapObj:listObject) {
     	  stringBuilder.append((int)mapObj.get("EMPLOYEE_ID"));
     	  stringBuilder.append(',');
       }
       stringBuilder.deleteCharAt(stringBuilder.length()-1);
       return stringBuilder.toString();
}
	}

