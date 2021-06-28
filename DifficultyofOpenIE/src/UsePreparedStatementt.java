import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Statement;


public class UsePreparedStatementt {

	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";
	
    public UsePreparedStatementt() {
    
    	
    	
     		
     	//Use PreparedStatements. – Andy Turner 11 mins ago
    	
    try {
        String url = "jdbc:mysql://localhost:3306/difficultyrelations";
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
	    	
	    	   String sql = "SELECT * FROM alakitestsent";
	     //  Statement statement = con.createStatement();
	    	   PreparedStatement statement = con.prepareStatement(sql);
	        java.sql.ResultSet result = statement.executeQuery(sql);
	    	  // ResultSet result = PreparedStatement.executeQuery(sql);

	       while (result.next()){
	          
	           String sent = result.getString(1);
	           

	           String s = sent;
	           int total1=0;
	       	
	       	for(int i = 0; i < s.length(); i++) {
	       		
	       		if(s.charAt(i) == '"') 
                      total1 += 1;
	       	    
	       	}
	       	
	       	if (total1!=0)
	       	System.out.println(s + " has " + total1 +" poin ");  
	       	
	       	//Taghsim bar 222222222222222222 
	       	
	       	}
	           

	    }
	    
	    catch (Exception ex) {
	           System.out.println(ex.getMessage());
                          } 
	
    } 

    
    
    
    
}


