import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CountCammandso {
	

	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";
	
    public CountCammandso() {
     		
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

	
	
	public void cntcomma() throws IOException, SQLException {
		

	 	   String sql = "SELECT * FROM testdatapen222";
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
		
		
	//	String helloWorld = "One,Two,(Three, \" Four!";
	int commas = 0;
	int parantes = 0;
	int qutation = 0;
	int quoto = 0;
	int Semicolon=0;
	
	for(int i = 0; i < st.length(); i++) {
	    if(st.charAt(i) == ',') 
	    	{commas++;}
	    if(st.charAt(i) == '(')
	    	{parantes++;}
	    if(st.charAt(i) == ';') 
	     	{Semicolon++; }
	 //   if(st.charAt(i) == '\'') 
     //   	{quoto++; }
	    
	}
	
/*
	for(char ch : st.toCharArray())
	{
	  if(ch == '"')
			  qutation++;
	}

//	boolean even = qutation % 2 == 0; */
	
	
	Pattern pattern1 = Pattern.compile("'");
	Matcher  matcher1 = pattern1.matcher(st);

	while (matcher1.find()){
		quoto++;}
	
	
	Pattern pattern = Pattern.compile("''");
	Matcher  matcher = pattern.matcher(st);

	while (matcher.find()){
		qutation++;	}
	
	quoto=(quoto-(2*qutation));
		

	System.out.println(st + " has " + commas + " commas!"+parantes +" parantes "+ qutation+ " qutation "+ quoto +" quoto");
	
	 String query = " insert into tftrcammaprntsquto222 (`Snt`, `joinID`, `commas`, `parantes`, `qutation`, `quato`, `Semicolon`)"
				+ " values (?, ?, ?, ?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt1 = con.prepareStatement(query);
		// preparedStmt.setString (1, words[0]);
		preparedStmt1.setString(1, st);
		preparedStmt1.setInt (2, joinID);
		preparedStmt1.setInt (3, commas);
		preparedStmt1.setInt (4, parantes);
		preparedStmt1.setInt (5, qutation);
		preparedStmt1.setInt (6, quoto);
		preparedStmt1.setInt (7, Semicolon);
		
		preparedStmt1.execute();
	
	
	}	
	
	
	
	
/*	public void cntpunct() throws IOException {	
	int  periodCount=0;
	int total1=0;
	int commaCount=0;
	
	String s = "One,Two,Three, \" Four!";
	
	for(int i = 0; i < s.length(); i++) {
	    switch(s.charAt(i)) { 
	     case '.':
	        periodCount++;
	        break;
	     case '"':
	        commaCount++;
	        break;
	   //  ... // similar conditions for others
	    }
	    total1 += 1;
	    
	}
	
	System.out.println(s + " has " + periodCount +" poin "+ commaCount+ " virgol");    
	}
	*/
	
	}	
	
}
