import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Sntlength {

	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";
	
    public Sntlength() {
     		
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
    
    
    public void SntLength() throws IOException, SQLException {
    

		// TODO Auto-generated method stub
		
	 	   String sql = "SELECT * FROM testdatapen111";
	  //  Statement statement = con.createStatement(); 
	 	   PreparedStatement statement = con.prepareStatement(sql);
	     java.sql.ResultSet result = statement.executeQuery(sql);
	 	  // ResultSet result = PreparedStatement.executeQuery(sql);

	    while (result.next()){
	    
	    	 String st = result.getString(3);
	    	 int joinID= result.getInt(11);
	    	
	    		System.out.println(st);

	    		st = st.replace(".","");
	   		   st=st.trim().replaceAll(" +", " ");

	      	System.out.print("string length is: "+ st.length());
		
		
		
		  st=st.replaceAll("\\s+"," ");
		  st = st.replaceAll("\\p{P}", " ");
          String tot = st.trim().replaceAll(" +", " ");	  
          tot = tot.replace(",", "");
          tot = tot.replace(" .", "");
          tot=tot.trim().replaceAll(" +", " ");
	      System.out.println(tot); 
		
		
		
		CountWordBlank cntwb=new CountWordBlank();
		int ss=cntwb.countWords(tot);
		System.out.print("string word count is:"+ ss +"\n");

		
		 String[] countingWord = st.split(" ");
		 
		   // this length give us count of words in string
		 
		   int totalNumberOfWordString = countingWord.length;
		   System.out.print("total Number Of WordString is:"+ totalNumberOfWordString);
		
		   
			 String query = " insert into tftrsntlngth111 (`Snt`, `joinID`, `Sntlngth`)"
						+ " values (?, ?, ?)";

				// create the mysql insert preparedstatement
				PreparedStatement preparedStmt1 = con.prepareStatement(query);
				// preparedStmt.setString (1, words[0]);
				preparedStmt1.setString(1, st);
				preparedStmt1.setInt (2, joinID);
				preparedStmt1.setInt (3, ss);
			
				
				preparedStmt1.execute();
		   
		   
		
	    }
		
		
		
    	
    	
    	
    	
    	
    }
    
	
}
