import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class removeSignsaaa {

	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "aaa3";
	
    public removeSignsaaa() {
    
    try {
        String url = "jdbc:mysql://localhost:3306/aaa3";
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
	    	
	    	   String sql = "SELECT * FROM cnvrtwoepars";
	       Statement statement = con.createStatement();
	       java.sql.ResultSet result = statement.executeQuery(sql);

	       while (result.next()){
	          // int sentID = result.getInt(1);
	           String sent = result.getString(1);
	           String arg1 = result.getString(2);
	           String rel = result.getString(3);
	           String arg2 = result.getString(4);
	           double conf = result.getDouble(5);
	           int trfl = result.getInt(6);
	      
	    	   
	    	/*   int sentID = result.getInt(1);  
	    	   String sent = result.getString(2);
	           String arg1 = result.getString(3);
	           String rel = result.getString(4);
	       */   
	           
	           sent = sent.replace(".", "");
	           sent = sent.replace("[", "");
	           sent = sent.replace("]", "");
	           sent = sent.replace(",,", "");
	           sent = sent.replace(",", "");
	           sent = sent.replace("'", "");
	           sent = sent.replaceAll("(\\r)", "");
	           sent = sent.replaceAll("@", " ");
	           sent = sent.replaceAll("&", " ");
	           sent = sent.replaceAll("%", " ");
	           sent = sent.replace("  ", " ");
	           sent = sent.trim().replaceAll(" +", " ");
	          
	         //  Sent, Arg1, Rel, Arg2, Conf, TrFls
	          //sntnum, Snts, Arg1Nested, Rel1Nested
	           String query = " insert into cnvrtwoepars2 (Sent, Arg1, Rel, Arg2, Conf, TrFls)"
  	                    + " values (?, ?, ?, ?, ?, ?)";
	         //  `SntNum``gSntID``Snt``Arg1``Rel``Arg2``TruFls``MissCorMist`              	             
  	                 // create the mysql insert preparedstatement
  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
  	                 // preparedStmt.setInt(1, sentID);
  	                 // preparedStmt.setInt(2, gSntNum);
  	                  preparedStmt.setString (1, sent);
  	                  preparedStmt.setString (2, arg1);
  	                  preparedStmt.setString (3, rel);
  	                  preparedStmt.setString (4, arg2); 
  	                  preparedStmt.setDouble(5, conf);
  	                  preparedStmt.setInt(6, trfl);
  	                 // preparedStmt.setInt(7, gSntNum);
  	                  preparedStmt.execute();
  	               //   con.close();
	           
	          /*  
  	                 preparedStmt.setInt (1, sentID);
	                  preparedStmt.setString (2, sent);
	                  preparedStmt.setString (3, arg1); 
	                  preparedStmt.setString(4, rel);
	                  preparedStmt.execute();
	           */
	                  
		       }    
		    	} 
	   
	    
	    catch (Exception ex) {
	           System.out.println(ex.getMessage());
                          } 
	
    
    
    } 
    
    
}
