package csc540Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Csc540Main {

	private static final String jdbcURL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl";

	  // Put your oracle ID and password here
	  private static final String user = "rsinghc";
	  private static final String password = "200019758";

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
		      // Loading the driver. This creates an instance of the driver
		      // and calls the registerDriver method to make Oracle Thin
		      // driver, at ora.csc.ncsu.edu, available to clients.
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      
			  Connection connection = null;

		      // Get a connection instance from the first driver in the
		      // DriverManager list that recognizes the URL jdbcURL
		      try {
		    	  
		    	connection = DriverManager.getConnection(jdbcURL, user,password);

		        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		        
		        Statement stmt = connection.createStatement();
		        
		        ResultSet rs = stmt.executeQuery("select table_name from user_tables");
		        
		        while (rs.next())
		        	   System.out.println (rs.getString(1));
		              }
		       finally {
		        close(connection);
		       }	

		    } catch (Exception oops) {
		      System.out.println("Exception running program.");
		      oops.printStackTrace();
		    }
	}
		  static void close(Connection connection) 
		  {
			  if(connection != null) {
				  try { 
					  connection.close(); 
				  } catch(Throwable whatever) {}
			  }
		  }

	

}
