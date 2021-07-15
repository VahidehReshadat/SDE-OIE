import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class WoeFeatures {

	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";
	
    public WoeFeatures() {
    
    	
    	
     		
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

	
	
	public void ifInitCapital() throws SQLException {
/*	//	boolean re = false;'
		String sent = "Check this That answer and you Can find which the keyword that this code";
		int c=0;
		if ( sent != null && sent.length() >= 1 ) {
		//	if ( sent.charAt(0) >= 'A' && sent.charAt(0) <= 'Z' ) {
			if ( sent.charAt(0) >=65 && sent.charAt(0) <=90 ) {
				c++;
			}
		}
		
	     System.out.print(c);

	//	return re;
	}
	
	*/
	
	///////////////////////////// Mojazaa bedoone tekrar??
		
		
		//hameye 
	/*
	public void testCountTheNumberOfUpperCaseCharacters() {
	   // String testStr = "abcdefghijkTYYtyyQ Want yes Or NO";
		String testStr = "In two House races , Representative Olympia J. Snowe defeated the Democrat , Patrick K. McGowan , a Democrat , crushed Linda Bean , a Republican and heiress to the L. L. Bean fortune .";
	    String regEx = "([A-Z])";
	    Pattern pattern = Pattern.compile(regEx);
	    Matcher matcher = pattern.matcher(testStr);
	    int count = 0;
	    while (matcher.find())
	    	count+=matcher.groupCount();
	        System.out.print(count);

	}
	
	*/   
		

 	   String sql = "SELECT * FROM testdatapen111";
  //  Statement statement = con.createStatement(); 
 	   PreparedStatement statement = con.prepareStatement(sql);
     java.sql.ResultSet result = statement.executeQuery(sql);
 	  // ResultSet result = PreparedStatement.executeQuery(sql);

    while (result.next()){
    
    	 String st = result.getString(3);
    	 int joinID= result.getInt(11);
    	
    		System.out.println(st);
    		String s = st.replace(",","");
    		
    	   s = s.replace(",","");
   		   s = s.replace(".","");
   		   s=s.trim().replaceAll(" +", " ");
    		
    		// System.out.println("Trimmmm: "+s);

		// faghat kalamat k AVALESHAN bozorg ast
		//String s = "Check this That answer and you Can find wHich the keyword that this code";	
	    int ct=0;
	    String[] sentences = s.split(" ");
	    
	    for(int k=0; k<sentences.length; k++) {
	    	 System.out.println("S[k]: "+sentences[k]);
	    }
	 
	    for(int k=0; k<sentences.length; k++) {
	        if((sentences[k].charAt(0)>=65) && (sentences[k].charAt(0)<=90))
	        {
	            ct++;

	        }
	    }
	    System.out.println("total  number of words start with capital letters are :"+ct);
	    
	    
	    String query = " insert into tftrcapitalize111 (`Snt`, `joinID`, `CntCap`)"
				+ " values (?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt1 = con.prepareStatement(query);
		// preparedStmt.setString (1, words[0]);
		preparedStmt1.setString(1, s);
		preparedStmt1.setInt (2, joinID);
		preparedStmt1.setInt (3, ct);
		
		
		preparedStmt1.execute();
	    
	    
	    
	}
	
	}
	
	
	//
	
	
	
	
	
	
	
	
}
