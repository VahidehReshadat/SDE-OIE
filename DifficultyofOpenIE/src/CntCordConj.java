	import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.stanford.nlp.util.StringUtils;


	public class CntCordConj {
		static Connection con;
	    String username = "root";
	    String password = "root";
	    String dbName = "difficultyrelations";
		
	    public CntCordConj() {
	    
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
		//*/
	    public void ReadWriteCnj() throws IOException {
	    
	    	 try {
	    
	    
	       String sql = "SELECT * FROM testdatapen222";
	       
	       Statement statement = con.createStatement();
	       java.sql.ResultSet result = statement.executeQuery(sql);
	    
	       while (result.next()){
		    	  
	           String Snts = result.getString(3);
	           int joinId = result.getInt(11);
	         
	       
	       int c=0;
	       int ftrcog=0;

	           
	         //  String text = "I will come and meet you but atbut the woods 123woods and alland the woods";
	       String text=Snts;
	       
	       
	        text = text.replace(".", "");
			text = text.replace("[", "");
			text = text.replace("]", "");
			text = text.replace(",,", "");
			text = text.replace(",", "");
			text = text.replaceAll("(\\r)", "");
			text = text.replaceAll("@", " ");
			text = text.replaceAll("&", " ");
			text = text.replaceAll("%", " ");
			text = text.replace("  ", " ");
			text = text.trim().replaceAll(" +", " ");
		//	String[] splitedtext = text.split(" ");
	       
	       
	           
	       List<String> tokens = new ArrayList<String>();
	           
	           //COORDINATING CONJUNCTIONS
	           
             //   tokens.add("say");

	        //   tokens.add("there");
	           
	      /*      
	           tokens.add("and");
	           tokens.add("but");
	           tokens.add("for");
	           tokens.add("or");
	           tokens.add("nor");
	           tokens.add("so");
	           tokens.add("yet");
*/
	       /////// RELATIVE PRONOUNS
  /* */
	           tokens.add("that");
	           tokens.add("which");
	           tokens.add("whichever");
	           tokens.add("who");
	           tokens.add("whoever");
	           tokens.add("whom");
	           tokens.add("whose");
	           tokens.add("whosever");
	            
	        ///////  A nominal clause 
	            
	      /*    tokens.add("that");*/
	         // tokens.add("if");
	         //  tokens.add("wheather");
	          
	          
	       ////adjective clause or relative clause)
	       
	    /*      
	           tokens.add("who");
	           tokens.add("whom");
	           tokens.add("that");
	           tokens.add("whose");
	           tokens.add("which");  
          
	       */    
	           
	           String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
	           Pattern pattern = Pattern.compile(patternString);
	           Matcher matcher = pattern.matcher(text);

	           while (matcher.find()) {
	               System.out.println(matcher.group(1));
	               c++;
	           }  

	    	 System.out.println("i is "+c); // Prints 2
	    	 
	    	 if(c!=0)	 
	    	 {
	    		 ftrcog=1;
	    		 
	    	 }
	    	 	    	 
		       	  
	        	  String query = " insert into tftrrelativepro222 (Snt, joinID, ftrcognition, cnts)"
  	                    + " values (?, ?, ?, ?)";
                                    	             
  	                  // create the mysql insert preparedstatement
  	                  PreparedStatement preparedStmt1 = con.prepareStatement(query);
  	                //  preparedStmt1.setInt(1, depid);
  	                  
  	                  preparedStmt1.setString (1, Snts);
  	                  preparedStmt1.setInt (2,joinId); 
  	                  preparedStmt1.setInt (3, ftrcog);
  	                  preparedStmt1.setInt (4, c);
  	                  
  	                  preparedStmt1.execute();
	        	  
	        	  
	        	  
	         /**/
	           
	    //       }     
	           
	       
	       }
	    	 }
	       catch (Exception ex) {
	           System.out.println(ex.getMessage());
                     } 
	       }

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		CntCordConj fn=new CntCordConj();
		fn.ReadWriteCnj();

	}

}
