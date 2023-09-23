package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class DataBaseLibrary {
	Driver driverRef;
	public Connection con;
	
	
	/**
	 * This method is used to connect java program to the database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		
		 driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
	con = DriverManager.getConnection(IConstants.dbURL, IConstants.dbUName, IConstants.dbPwd);
		
	}
	
	/**
	 * This method is used to read the data from database and validate it
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	
	public String readDataFromDBandValidate(String query, int columnIndex, String expData) throws SQLException {
		 ResultSet result = con.createStatement().executeQuery(query);
		 boolean flag=false;
		 while(result.next()) {
			 if(result.getString(columnIndex).equalsIgnoreCase(expData)) {
				 flag=true;
				 break;
			 }
		 }
		
		 if(flag==true) {
			 System.out.println("Data Verified");
			 return expData;
		 }
		 
		 else {
			 System.out.println("data not verified/present");
			 return "";
		 }
		 
	}
	
	/**
	 * This below method is used to close the database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}
	
	
	public void readMultipleDataInRMG(String query) throws SQLException {
		  ResultSet result = con.createStatement().executeQuery(query);		  
		  while(result.next()) {
			for(int i=1;i<=4;i++) {
				System.out.println(result.getString(i));	
			}
//			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)); 
//				  System.out.println(result.getString(1+" ")); 
		  }	
	}
	
}