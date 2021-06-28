import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class FindSntID {

	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";
	
    public FindSntID() {
    
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
	    	
	    	   String sql = "SELECT * FROM webmanubinexemplar";
	       Statement statement = con.createStatement();
	       java.sql.ResultSet result = statement.executeQuery(sql);

	       while (result.next()){
	           int sentID = result.getInt(1);
	           String sent = result.getString(2);
	           String arg1 = result.getString(3);
	           String rel = result.getString(4);
	           String arg2 = result.getString(5);
	           String trfl = result.getString(6);
	           String MissCorrMist=result.getString(7);

		    	
		      // String sql1 = "SELECT Confdn FROM cnvrtrev1itslfextraction WHERE SentID="+sentID+" AND Arg1="+Marg1+" AND Rel="+Mrel+" AND Arg2="+Marg2;
		    	   
		    //   Statement statement1 = con.createStatement();
		   //    java.sql.ResultSet result1 = statement.executeQuery(sql1);
	           
	           String sql1 = "SELECT * FROM webmanubingroundtruth WHERE Snt="+"\""+sent+"\"";
	          
		       Statement statement1 = con.createStatement();
		       java.sql.ResultSet result1 = statement1.executeQuery(sql1);
		       
		       if (result1.next()){
		       int gSntNum = result1.getInt(1);
		       String gSent = result1.getString(2);
		       String gArg1 = result1.getString(3);
		       String gRel = result1.getString(4);
		       String gArg2 = result1.getString(5);
		      
	           //int y=Marg1.length(); `SntNum``Snt``Arg1``Rel``Arg2`
		       
	          // String s= Marg11;
	           
		       
	           String query = " insert into webmanubinexemplar1 (SntNum, gSntID, Snt, Arg1, Rel, Arg2, TruFls, MissCorMist)"
  	                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";
	         //  `SntNum``gSntID``Snt``Arg1``Rel``Arg2``TruFls``MissCorMist`              	             
  	                  // create the mysql insert preparedstatement
  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
  	                  preparedStmt.setInt(1, sentID);
  	                  preparedStmt.setInt(2, gSntNum);
  	                  preparedStmt.setString (3, sent);
  	                  preparedStmt.setString (4, arg1);
  	                  preparedStmt.setString (5, rel);
  	                  preparedStmt.setString (6, arg2); 
  	                  preparedStmt.setString (7, trfl);
  	                  preparedStmt.setString(8, MissCorrMist);
  	                  preparedStmt.execute();
  	               //   con.close();
		       }    
		    	} 
	    }
	    
	    catch (Exception ex) {
	           System.out.println(ex.getMessage());
                          } 
	
    } 
    
    
    
    
}
