import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class findExactOutputs {
	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "11";
	
    public findExactOutputs() {
    
    try {
        String url = "jdbc:mysql://localhost:3306/11";
        String username = "root";
        String password = "root";

    Class.forName("com.mysql.jdbc.Driver").newInstance();
    con = DriverManager.getConnection(url, username, password);
    System.out.println("Database Created...!!!");
       }

    catch (Exception e) {
       e.printStackTrace();
       System.out.println("Error occured while connecting to database");
                 }
    }
    
    public void InsertSentSentIntoTable() throws IOException {
    
    	try {
    	
    		
 	       String sql = "SELECT * FROM penmanubinreverb1";

 	      Statement statement = con.createStatement();
	       java.sql.ResultSet result = statement.executeQuery(sql);
	      

	           while (result.next()){
	           int sentID = result.getInt(1);
	           int gsentID = result.getInt(2);
	           int Snt = result.getInt(2);
	           int gsentID = result.getInt(2);
	           int gsentID = result.getInt(2);
	           int gsentID = result.getInt(2);
	           int gsentID = result.getInt(2);

 	       
 	       
 	       
    		
    		
    	}
    	
	    catch (Exception ex) {
	           System.out.println(ex.getMessage());
                       } 
	
    	
    	
    	
    }
    
    
    
}
