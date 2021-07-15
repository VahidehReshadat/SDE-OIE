import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class TrainingDataCreation {

	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";
	
    public TrainingDataCreation() {
    
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
	    	
	       String dorosghalat="***";
	       String sql = "SELECT * FROM webmanubinreverb1";
	       Statement statement = con.createStatement();
	       java.sql.ResultSet result = statement.executeQuery(sql);
	      

	           while (result.next()){
	           int sentID = result.getInt(1);
	           int gsentID = result.getInt(2);
	           String sent = result.getString(3);
	           String arg1 = result.getString(4);
	           String rel = result.getString(5);
	           String arg2 = result.getString(6);
	           String trfl = result.getString(7);
	           String MissCorrMist=result.getString(8);
	           
	           MissCorrMist= MissCorrMist.replaceAll("(\\r)", "");
	           MissCorrMist= MissCorrMist.replaceAll("@", " ");
	           MissCorrMist= MissCorrMist.replaceAll("&", " ");
	           dorosghalat="***";
	           String sql1 = "SELECT * FROM webmanubinexemplar1 WHERE gSntID="+gsentID;    
	          
		       Statement statement1 = con.createStatement();
		       java.sql.ResultSet result1 = statement1.executeQuery(sql1);
		       
		       if (result1.next()){
		    	   
		    	   int esentID = result1.getInt(1);
		           int egsentID = result1.getInt(2);
		           String esent = result1.getString(3);
		           String earg1 = result1.getString(4);
		           String erel = result1.getString(5);
		           String earg2 = result1.getString(6);
		           String etrfl = result1.getString(7);
		           String eMissCorrMist=result1.getString(8);
		      	           
		           eMissCorrMist= eMissCorrMist.replaceAll("(\\r)", "");
		           eMissCorrMist= eMissCorrMist.replaceAll("@", " ");
		           eMissCorrMist= eMissCorrMist.replaceAll("&", " ");
		           
		           
		           if((MissCorrMist.equals("Correct")) && (eMissCorrMist.equals("Correct")))
		        		   {
		        	   dorosghalat="ReVerb";
		        	   
		        	   
		        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
		  	                    + " values (?, ?, ?, ?, ?)";

		  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
		  	                  preparedStmt.setInt(1, gsentID);
		  	                  preparedStmt.setString(2, sent);
		  	                  preparedStmt.setString(3, MissCorrMist);
		  	                  preparedStmt.setString(4, eMissCorrMist);
		  	                  preparedStmt.setString (5, dorosghalat);		  	                 
		  	                  preparedStmt.execute();
		  	               //   con.close();
		        	   
		        	   
		        		   }
		           else if ((MissCorrMist.equals("Correct")) && (eMissCorrMist.equals("Mistake")))
		           {
		        	   dorosghalat="ReVerb";
		        	   
		        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
		  	                    + " values (?, ?, ?, ?, ?)";

		  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
		  	                  preparedStmt.setInt(1, gsentID);
		  	                  preparedStmt.setString(2, sent);
		  	                  preparedStmt.setString(3, MissCorrMist);
		  	                  preparedStmt.setString(4, eMissCorrMist);
		  	                  preparedStmt.setString (5, dorosghalat);		  	                 
		  	                  preparedStmt.execute();
		  	               //   con.close();
		        	   
		        	   
		        	   
		           }
		           else if ((MissCorrMist.equals("Correct")) && (eMissCorrMist.equals("Missing")))
		           {
		        	   dorosghalat="ReVerb";
		        	   
		        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
		  	                    + " values (?, ?, ?, ?, ?)";

		  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
		  	                  preparedStmt.setInt(1, gsentID);
		  	                  preparedStmt.setString(2, sent);
		  	                  preparedStmt.setString(3, MissCorrMist);
		  	                  preparedStmt.setString(4, eMissCorrMist);
		  	                  preparedStmt.setString (5, dorosghalat);		  	                 
		  	                  preparedStmt.execute();
		  	               //   con.close();
		        	   
		        	   
		           }
		           
		           else if ((MissCorrMist.equals("Mistake")) && (eMissCorrMist.equals("Correct")))
		           {
		        	   dorosghalat="Exemplar";
		        	   
		        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
		  	                    + " values (?, ?, ?, ?, ?)";

		  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
		  	                  preparedStmt.setInt(1, gsentID);
		  	                  preparedStmt.setString(2, sent);
		  	                  preparedStmt.setString(3, MissCorrMist);
		  	                  preparedStmt.setString(4, eMissCorrMist);
		  	                  preparedStmt.setString (5, dorosghalat);		  	                 
		  	                  preparedStmt.execute();
		  	               //   con.close();
		           }
		  	          else if ((MissCorrMist.equals("Mistake")) && (eMissCorrMist.equals("Mistake")))
		 		     {
		 		        dorosghalat="ReVerb";
		 		        	   
		 		        String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
		 		  	                    + " values (?, ?, ?, ?, ?)";

		 		  	          PreparedStatement preparedStmt = con.prepareStatement(query);
		 		  	          preparedStmt.setInt(1, gsentID);
		 		  	          preparedStmt.setString(2, sent);
		 		  	          preparedStmt.setString(3, MissCorrMist);
		  	                  preparedStmt.setString(4, eMissCorrMist);
		 		  	          preparedStmt.setString (5, dorosghalat);		  	                 
		 		  	          preparedStmt.execute();
		 		  	               //   con.close();
		        	   
		        	   
		           } 
		           else if ((MissCorrMist.equals("Mistake")) && (eMissCorrMist.equals("Missing")))
		           {
		        	   dorosghalat="Exemplar";
		        	   
		        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
		  	                    + " values (?, ?, ?, ?, ?)";

		  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
		  	                  preparedStmt.setInt(1, gsentID);
		  	                  preparedStmt.setString(2, sent);
		  	                  preparedStmt.setString(3, MissCorrMist);
		  	                  preparedStmt.setString(4, eMissCorrMist);
		  	                  preparedStmt.setString (5, dorosghalat);		  	                 
		  	                  preparedStmt.execute();
		  	               //   con.close();
		        	   
		        	   
		           } 
		          
		           else if ((MissCorrMist.equals("Missing")) && (eMissCorrMist.equals("Correct")))
		           {
		        	   dorosghalat="Exemplar";
		        	   
		        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
		  	                    + " values (?, ?, ?, ?, ?)";

		  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
		  	                  preparedStmt.setInt(1, gsentID);
		  	                  preparedStmt.setString(2, sent);
		  	                  preparedStmt.setString(3, MissCorrMist);
		  	                  preparedStmt.setString(4, eMissCorrMist);
		  	                  preparedStmt.setString (5, dorosghalat);		  	                 
		  	                  preparedStmt.execute();
		  	               //   con.close();
		        	   
		        	   
		           } 
		           
		           else if ((MissCorrMist.equals("Missing")) && (eMissCorrMist.equals("Mistake")))
		           {
		        	   dorosghalat="ReVerb";
		        	   
		        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
		  	                    + " values (?, ?, ?, ?, ?)";

		  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
		  	                  preparedStmt.setInt(1, gsentID);
		  	                  preparedStmt.setString(2, sent);
		  	                  preparedStmt.setString(3, MissCorrMist);
		  	                  preparedStmt.setString(4, eMissCorrMist);
		  	                  preparedStmt.setString (5, dorosghalat);		  	                 
		  	                  preparedStmt.execute();
		  	               //   con.close();
		        	   
		        	   
		           } 
		           
	           
		       } 
		       
		       if((MissCorrMist.equals("Correct")) && (dorosghalat.equals("***")))
		       {
		    	   dorosghalat="ReVerb";
	        	   
	        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
	  	                    + " values (?, ?, ?, ?, ?)";

	  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
	  	                  preparedStmt.setInt(1, gsentID);
	  	                  preparedStmt.setString(2, sent);
	  	                  preparedStmt.setString(3, MissCorrMist);
	  	                  preparedStmt.setString(4, "***");
	  	                  preparedStmt.setString (5, dorosghalat);		  	                 
	  	                  preparedStmt.execute();
		       }
		       
		       else  if((MissCorrMist.equals("Mistake")) && (dorosghalat.equals("***")))
		       {
		    	   dorosghalat="Exemplar";
	        	   
	        	   String query = " insert into trainingdataweb (gSntID, Snt, ReVerb, Exemplar, RevExmp)"
	  	                    + " values (?, ?, ?, ?, ?)";

	  	                  PreparedStatement preparedStmt = con.prepareStatement(query);
	  	                  preparedStmt.setInt(1, gsentID);
	  	                  preparedStmt.setString(2, sent);
	  	                  preparedStmt.setString(3, MissCorrMist);
	  	                  preparedStmt.setString(4, "***");
	  	                  preparedStmt.setString (5, dorosghalat);		  	                 
	  	                  preparedStmt.execute();
		       }
		       
		       
		    	} 
	    }
	    
	    catch (Exception ex) {
	           System.out.println(ex.getMessage());
                          } 
	
    } 
    
    
    
    
}
