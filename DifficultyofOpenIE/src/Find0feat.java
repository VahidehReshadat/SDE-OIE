import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class Find0feat {
	
	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";
	
    public Find0feat() {
    
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
	    	
	    	   String sql = "SELECT * FROM testdatapen";
	       Statement statement = con.createStatement();
	       java.sql.ResultSet result = statement.executeQuery(sql);

	       while (result.next()){
	           int sentID = result.getInt(1);
	           int gsentID=result.getInt(2);
	           String sent = result.getString(3);
	           String Rev = result.getString(4);
	           String Exmp = result.getString(5);
	           String RevExmp = result.getString(6);
	        //   String Arg1 = result.getString(7);
	          // String Rel = result.getString(8);
	           //String Arg2 = result.getString(9);
	           //int feat=result.getInt(10);

		    	
		      // String sql1 = "SELECT Confdn FROM cnvrtrev1itslfextraction WHERE SentID="+sentID+" AND Arg1="+Marg1+" AND Rel="+Mrel+" AND Arg2="+Marg2;
		    	   
		    //   Statement statement1 = con.createStatement();
		   //    java.sql.ResultSet result1 = statement.executeQuery(sql1);
	           
	           String sql1 = "SELECT * FROM testdatapen1 WHERE TDSntID="+sentID;
	          
		       Statement statement1 = con.createStatement();
		       java.sql.ResultSet result1 = statement1.executeQuery(sql1);
		       
		       if (result1.next()){
		    	   int sentID3 = result1.getInt(1);
		           int gsentID3=result1.getInt(2);
		           String sent3 = result1.getString(3);
		           String Rev3 = result1.getString(4);
		           String Exmp3 = result1.getString(5);
		           String RevExmp3 = result1.getString(6);
		           String Arg13 = result1.getString(7);
			       String Rel3 = result1.getString(8);
			       String Arg23 = result1.getString(9);
			       int feat3=result1.getInt(10);

		          
		      
	           //int y=Marg1.length(); `SntNum``Snt``Arg1``Rel``Arg2`
		       
	          // String s= Marg11;
		        System.out.println("HAst");
	           
		       
	           String query = " insert into testdatapen11 (TDSntID, gSntID, Snt, ReVerb, Exemplar, RevExmp, Arg1, Rel, Arg2, feature1)"
  	                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	         //  `SntNum``gSntID``Snt``Arg1``Rel``Arg2``TruFls``MissCorMist`              	             
  	                  // create the mysql insert preparedstatement
  	                  PreparedStatement preparedStmt2 = con.prepareStatement(query);
  	                  preparedStmt2.setInt(1, sentID3);
  	                  preparedStmt2.setInt(2, gsentID3);
  	                  preparedStmt2.setString (3, sent3);
  	                  preparedStmt2.setString (4, Rev3);
  	                  preparedStmt2.setString (5, Exmp3);
  	                  preparedStmt2.setString (6, RevExmp3); 
  	                  preparedStmt2.setString (7, Arg13);
  	                  preparedStmt2.setString(8, Rel3);
  	                  preparedStmt2.setString(9, Arg23);
  	                  preparedStmt2.setInt(10, feat3);
  	                  preparedStmt2.execute();
  	               //   con.close();
  	                  
		       } 
		       
		       else
		       {
		    		       
		           String query = " insert into testdatapen11 (TDSntID, gSntID, Snt, ReVerb, Exemplar, RevExmp, Arg1, Rel, Arg2, feature1)"
	  	                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		         //  `SntNum``gSntID``Snt``Arg1``Rel``Arg2``TruFls``MissCorMist`              	             
	  	                  // create the mysql insert preparedstatement
	  	                  PreparedStatement preparedStmt3 = con.prepareStatement(query);
	  	                  preparedStmt3.setInt(1, sentID);
	  	                  preparedStmt3.setInt(2, gsentID);
	  	                  preparedStmt3.setString (3, sent);
	  	                  preparedStmt3.setString (4, Rev);
	  	                  preparedStmt3.setString (5, Exmp);
	  	                  preparedStmt3.setString (6, RevExmp); 
	  	                  preparedStmt3.setString (7, "");
	  	                  preparedStmt3.setString(8, "");
	  	                  preparedStmt3.setString(9, "");
	  	                  preparedStmt3.setInt(10, 0);
	  	                  preparedStmt3.execute();
	  	               //   con.close(); 
		    	   
		    	   
		    	   
		       }
		       
		    	} 
	    }
	    
	    catch (Exception ex) {
	           System.out.println(ex.getMessage());
                          } 
    }

    
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Find0feat fn=new Find0feat();
		fn.InsertSentSentIntoTable();
		
	}

}
