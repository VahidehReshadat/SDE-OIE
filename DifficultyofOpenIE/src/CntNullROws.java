import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;



public class CntNullROws {

	
	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";

    public CntNullROws() {
    	
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

    public void InsrtoTable() throws IOException, SQLException {
    
    	
 		
 	  	String sql = "SELECT * FROM trainingdataddnytweb1";   
      Statement statement = con.createStatement();
      java.sql.ResultSet result = statement.executeQuery(sql);
      int c=0;
 	    while (result.next()){
 	    	
 	    	int TrSntcid=result.getInt(1);
 	    	int gSntcid=result.getInt(2);
 	    	String Snt = result.getString(3);
 	  		String Rvrb = result.getString(4);
 	  		String Exmplr = result.getString(5);
 	  		String RvbExmp = result.getString(6);
 	  	    String Arg1 = result.getString(7);
 	  	    String Rel = result.getString(8);
 	  	    String Arg2 = result.getString(9);
 	  	    int F1 = result.getInt(10);

 	  	 
 	     	 String h=Rel;
 	     	    h = h.replaceAll("(\\r)", " ");
 				h = h.replaceAll("@", " ");
 				h = h.replaceAll("&", " ");
 				h = h.replace("  ", " "); 
 				h = h.trim().replaceAll(" +", " ");
 	     	 

 	 	//	if(h==null || h=="" || h==" ")//GenericValidator.isBlankOrNull(s)
 				if((h == null) || (h.trim().length() == 0) || (h.equals("")) || h.isEmpty())	
 	 		{
 	 		//int foo = Integer.parseInt(h);	
 	 		 System.out.println("fooooooooooooo: NULL");	 
 			 
 	 		 c++;
 	 		 
 		//	if(h!=null || h!="" || h!=" ") 
 
 		}

 	
	   }
 		 System.out.println("ccccccccc: "+c);	 


     }    
    }    
    	
	