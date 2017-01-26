package controlDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.* ;


/**
 * Created by appie on 2016/12/10.
 */
public class ControlDB {
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	   static final String DB_URL = "jdbc:mysql://localhost:3306/DataInput?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	   // Database credentials
	   static final String USER = "root";
	   static final String PASS = "";

	   public void ControlDB() {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		   //STEP 4: Run a sql script file
		   System.out.println("Creating database...");
		   ScriptRunner runner = new ScriptRunner(conn, false, false);
		   runner.runScript(new BufferedReader(new FileReader("src/main/resources/DataInput.sql")));
	      //runner.runScript(new BufferedReader(new InputStreamReader(new FileInputStream("Resources/DataInput.sql"))));

		   //STEP 2: Register JDBC driver
		   Class.forName(JDBC_DRIVER);

	      //STEP 5: Execute a query
	      System.out.println("Database created successfully...");

	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");

    }
}
