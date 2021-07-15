import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;


public class CnvrtxtoSqltb {

	
	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "confidencepaper";

    public CnvrtxtoSqltb() {
    	
        try {
            String url = "jdbc:mysql://localhost:3306/confidencepaper";
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
    
    	
    	 String cntr="1";
    	 String notnull="1";
 		
 	 /*  	String sql = "SELECT * FROM trainingdataddnytweb1";
 	    
 	    Statement statement = con.createStatement();
 	    java.sql.ResultSet result = statement.executeQuery(sql);

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

 	    }
 	  		
 	        String Arg2 = result.getString(6);
 	        String Arg2Typ = result.getString(7);
 	        String TorF = result.getString(8);
 	        float f1=result.getFloat(9);
 	        float f2=result.getFloat(10);
 	        float f3=result.getFloat(11);
 	        float f4=result.getFloat(12);
 	      	double Cakhod=result.getDouble(13);
 	        double Cvkhod=result.getDouble(14);
 	        double CAAve=result.getDouble(15);
 	        double CvAve=result.getDouble(16); */
 	 /*       
 	        int f1=result.getInt(9);
 	        int f2=result.getInt(10);
 	        int f3=result.getInt(11);
 	        int f4=result.getInt(12);
 	        int f5=result.getInt(13);
 	        int f6=result.getInt(14);
 	        int f7=result.getInt(15);
 	        int f8=result.getInt(16);
 	        int f9=result.getInt(17);
 	        int f10=result.getInt(18);
 	        int f11=result.getInt(19);
 	        int f12=result.getInt(20);
 	        int f13=result.getInt(21);
 	        int f14=result.getInt(22);
 	        int f15=result.getInt(23);
 	        int f16=result.getInt(24);
 	        int f17=result.getInt(25);
 	        int f18=result.getInt(26);
 	        int f19=result.getInt(27);
 	        int f20=result.getInt(28);
 	        int f21=result.getInt(29);
 	        int f22=result.getInt(30);
 	        int f23=result.getInt(31);
 	        int f24=result.getInt(32);
 	        int f25=result.getInt(33);
 	        int f26=result.getInt(34);
 	        int f27=result.getInt(35);
 	        int f28=result.getInt(36);
 	        int f29=result.getInt(37);
 	        int f30=result.getInt(38);
 	        int f31=result.getInt(39);
 	        int f32=result.getInt(40);
 	        int f33=result.getInt(41);
 	        int f34=result.getInt(42);
 	        int f35=result.getInt(43);
 	        float f36=result.getFloat(44);
 	        float f37=result.getFloat(45);
 	        float f38=result.getFloat(46);
 	        float f39=result.getFloat(47);
 	        double f40=result.getDouble(48);
 	        double f41=result.getDouble(49);
 	        double f42=result.getDouble(50);
 	        double f43=result.getDouble(51);
 	        double f44=result.getDouble(52);
 	        double f45=result.getDouble(53);
 	        int wrdcntftr=result.getInt(54);
 	       
 	        int f12=result.getInt(9);
 	        int f21=result.getInt(10);
 	        int f23=result.getInt(11);
 	        int f26=result.getInt(12);
 	        int f32=result.getInt(13);
 	        int f34=result.getInt(14);
 	        int f35=result.getInt(15); 
 	        float mf1=result.getFloat(9);
 	        float mf2=result.getFloat(10);
 	        float mf4=result.getFloat(11);
 	        int wrdftr=result.getInt(12);
 	        int wrdcnt=result.getInt(13);*/
    	
 	   String content="";
     

File txtdoc = new File("D:\\eclipse workspace\\DifficultyofOpenIE\\dataset\\depoe35.txt");

     if (txtdoc.isFile() && txtdoc.getName().endsWith(".txt"))
     {
     content = FileUtils.readFileToString(txtdoc);  

     String[]  sentences = content.split("\n");
     
     
     
     for(int k=0; k<sentences.length; k++)
	   {
		   
    //	 System.out.println("sentences[0]: "+sentences[0]);
     ///	 System.out.println("sentences[1]: "+sentences[1]);
     //	 System.out.println("sentences[2]: "+sentences[2]);
     	 
     	 
     	 String h=sentences[k];
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
 		 
 		//cntr = Integer.parseInt(h);	
		// System.out.println(cntr);
 		
 		}
 		 
	/*		String query = "insert into trainingdataddnytweb11 (`Rf1`, `Rf2`, `Rf3`, `Rf4`, `Rf5`, `Rf6`, `Rf7`, `Rf8`, `Rf9`, `Rf10`, `Rf11`, `Rf12`, `Rf13`, `Rf14`, `Rf15`, `Rf16`, `Rf17`, `Rf18`, `Rf19`, `Rf20`, `Rf21`, `Rf22`, `Rf23`, `Rf24`, `Rf25`, `Rf26`, `Rf27`, `Rf28`, `Rf29`, `Rf30`, `Rf31`, `Rf32`, `Rf33`, `Rf34`, `Rf35`, `Rf36`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// preparedStmt.setString (1, words[0]);
			preparedStmt.setInt (1, (55));
			preparedStmt.setInt (2, (55));
			preparedStmt.setInt (3, (55));
			preparedStmt.setInt (4, (55));
			preparedStmt.setInt (5, (55));
			preparedStmt.setInt (6, (55));
			preparedStmt.setInt (7, (55));
			preparedStmt.setInt (8, (55));
			preparedStmt.setInt (9, (55));
			preparedStmt.setInt (10, (55));
			preparedStmt.setInt (11, (55));
			preparedStmt.setInt (12, (55));
			preparedStmt.setInt (13, (55));
			preparedStmt.setInt (14, (55));
			preparedStmt.setInt (15, (55));
			preparedStmt.setInt (16, (55));
			preparedStmt.setInt (17, (55));
			preparedStmt.setInt (18, (55));
			preparedStmt.setInt (19, (55));
			preparedStmt.setInt (20, (55));
			preparedStmt.setInt (21, (55));
			preparedStmt.setInt (22, (55));
			preparedStmt.setInt (23, (55));
			preparedStmt.setInt (24, (55));
			preparedStmt.setInt (25, (55));
			preparedStmt.setInt (26, (55));
			preparedStmt.setInt (27, (55));
			preparedStmt.setInt (28, (55));
			preparedStmt.setInt (29, (55));
			preparedStmt.setInt (30, (55));
			preparedStmt.setInt (31, (55));
			preparedStmt.setInt (32, (55));
			preparedStmt.setInt (33, (55));
			preparedStmt.setInt (34, (55));
			preparedStmt.setInt (35, (55));
			preparedStmt.setInt (36, (55));
		//	preparedStmt.setInt (37, Integer.parseInt(featuVec[36]));
			//preparedStmt.setInt (2, Integer.parseInt(words[35]));
								
			// execute the preparedstatement
			preparedStmt.execute();
 		 
 		 
 		 
 		 
 		 
 		}*/
 		
 		
 		
 		
 		//|| (sentences[k]==null)
 		
 		else if ((StringUtils.isNumeric(h)))//vaghti ADAD bashad
 		
 		{
 			 System.out.println("wwww meghdare NUMber: "+h); 
 			 
 			 
 			if(h!=null || h!="" || h!=" ") 
 			{ 
 			cntr=h;
 			}
 			
 			
 			// cntr = Integer.parseInt(h);	
 		    System.out.println("KAnter: "+cntr);
 			 
 			 
 			 
 	 	 	/*	{
 	 	 	 		//int foo = Integer.parseInt(h);	
 	 	 	 		 System.out.println("fooooooooooooo: "+h);
 	 	 	 		 
 	 	 				String query = "insert into trainingdataddnytweb11 (`Rf1`, `Rf2`, `Rf3`, `Rf4`, `Rf5`, `Rf6`, `Rf7`, `Rf8`, `Rf9`, `Rf10`, `Rf11`, `Rf12`, `Rf13`, `Rf14`, `Rf15`, `Rf16`, `Rf17`, `Rf18`, `Rf19`, `Rf20`, `Rf21`, `Rf22`, `Rf23`, `Rf24`, `Rf25`, `Rf26`, `Rf27`, `Rf28`, `Rf29`, `Rf30`, `Rf31`, `Rf32`, `Rf33`, `Rf34`, `Rf35`, `Rf36`)"
 	 	 						+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 	 	 				// create the mysql insert preparedstatement
 	 	 				PreparedStatement preparedStmt = con.prepareStatement(query);
 	 	 				// preparedStmt.setString (1, words[0]);
 	 	 				preparedStmt.setInt (1, (99999));
 	 	 				preparedStmt.setInt (2, (99999));
 	 	 				preparedStmt.setInt (3, (99999));
 	 	 				preparedStmt.setInt (4, (99999));
 	 	 				preparedStmt.setInt (5, (99999));
 	 	 				preparedStmt.setInt (6, (99999));
 	 	 				preparedStmt.setInt (7, (99999));
 	 	 				preparedStmt.setInt (8, (99999));
 	 	 				preparedStmt.setInt (9, (99999));
 	 	 				preparedStmt.setInt (10, (99999));
 	 	 				preparedStmt.setInt (11, (99999));
 	 	 				preparedStmt.setInt (12, (99999));
 	 	 				preparedStmt.setInt (13, (99999));
 	 	 				preparedStmt.setInt (14, (99999));
 	 	 				preparedStmt.setInt (15, (99999));
 	 	 				preparedStmt.setInt (16, (99999));
 	 	 				preparedStmt.setInt (17, (99999));
 	 	 				preparedStmt.setInt (18, (99999));
 	 	 				preparedStmt.setInt (19, (99999));
 	 	 				preparedStmt.setInt (20, (99999));
 	 	 				preparedStmt.setInt (21, (99999));
 	 	 				preparedStmt.setInt (22, (99999));
 	 	 				preparedStmt.setInt (23, (99999));
 	 	 				preparedStmt.setInt (24, (99999));
 	 	 				preparedStmt.setInt (25, (99999));
 	 	 				preparedStmt.setInt (26, (99999));
 	 	 				preparedStmt.setInt (27, (99999));
 	 	 				preparedStmt.setInt (28, (999990));
 	 	 				preparedStmt.setInt (29, (99999));
 	 	 				preparedStmt.setInt (30, (99999));
 	 	 				preparedStmt.setInt (31, (99999));
 	 	 				preparedStmt.setInt (32, (99999));
 	 	 				preparedStmt.setInt (33, (99999));
 	 	 				preparedStmt.setInt (34, (99999));
 	 	 				preparedStmt.setInt (35, (999990));
 	 	 				preparedStmt.setInt (36, (99999));
 	 	 			//	preparedStmt.setInt (37, Integer.parseInt(featuVec[36]));
 	 	 				//preparedStmt.setInt (2, Integer.parseInt(words[35]));
 	 	 									
 	 	 				// execute the preparedstatement
 	 	 				preparedStmt.execute();
 	 	 	 		 
 	 	 	 		 
 	 	 	 		 
 	 	 	 		 
 	 	 	 		 
 	 	 	 		}*/
 	 			
 	 			
 	 		//}

 			
 			
 		}
 		
 		
 		else
 		{
 			 String[] featuVec = sentences[k].split(",");
 			 System.out.println("featuVec   "+featuVec);
 			 
 			// cntr=h;
 			 
 			 for(int n=0; n<featuVec.length; n++)
 			 {
 				featuVec[n]=featuVec[n].replaceAll("[()]", "");
 				
 				
 	
 				featuVec[n] = featuVec[n].replaceAll("(\\r)", " ");
 				featuVec[n] = featuVec[n].replaceAll("@", " ");
 				featuVec[n] = featuVec[n].replaceAll("&", " ");
 				featuVec[n] = featuVec[n].replace("  ", " "); 
 				featuVec[n] = featuVec[n].trim().replaceAll(" +", " ");
 				
 				 System.out.println("F ha: "+featuVec[n]);
 				
 			//	featuVec[n]=featuVec[n].replaceAll(")","");
 				if(featuVec[n].equals("false"))
 				{
 					featuVec[n]="0";
 				}
 				else
 				{
 					featuVec[n]="1";
 				}
 				
 				 System.out.println(featuVec[n]);
 			 }
 			
 			    notnull=cntr;
 			 
 			 
				String query = "insert into deptestallfeatures4final (`Rf1`, `Rf2`, `Rf3`, `Rf4`, `Rf5`, `Rf6`, `Rf7`, `Rf8`, `Rf9`, `Rf10`, `Rf11`, `Rf12`, `Rf13`, `Rf14`, `Rf15`, `Rf16`, `Rf17`, `Rf18`, `Rf19`, `Rf20`, `Rf21`, `Rf22`, `Rf23`, `Rf24`, `Rf25`, `Rf26`, `Rf27`, `Rf28`, `Rf29`, `Rf30`, `Rf31`, `Rf32`, `Rf33`, `Rf34`, `Rf35`, `Rf36`, `SntIDTD`)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				// create the mysql insert preparedstatement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// preparedStmt.setString (1, words[0]);
				preparedStmt.setInt (1, Integer.parseInt(featuVec[0]));
				preparedStmt.setInt (2, Integer.parseInt(featuVec[1]));
				preparedStmt.setInt (3, Integer.parseInt(featuVec[2]));
				preparedStmt.setInt (4, Integer.parseInt(featuVec[3]));
				preparedStmt.setInt (5, Integer.parseInt(featuVec[4]));
				preparedStmt.setInt (6, Integer.parseInt(featuVec[5]));
				preparedStmt.setInt (7, Integer.parseInt(featuVec[6]));
				preparedStmt.setInt (8, Integer.parseInt(featuVec[7]));
				preparedStmt.setInt (9, Integer.parseInt(featuVec[8]));
				preparedStmt.setInt (10, Integer.parseInt(featuVec[9]));
				preparedStmt.setInt (11, Integer.parseInt(featuVec[10]));
				preparedStmt.setInt (12, Integer.parseInt(featuVec[11]));
				preparedStmt.setInt (13, Integer.parseInt(featuVec[12]));
				preparedStmt.setInt (14, Integer.parseInt(featuVec[13]));
				preparedStmt.setInt (15, Integer.parseInt(featuVec[14]));
				preparedStmt.setInt (16, Integer.parseInt(featuVec[15]));
				preparedStmt.setInt (17, Integer.parseInt(featuVec[16]));
				preparedStmt.setInt (18, Integer.parseInt(featuVec[17]));
				preparedStmt.setInt (19, Integer.parseInt(featuVec[18]));
				preparedStmt.setInt (20, Integer.parseInt(featuVec[19]));
				preparedStmt.setInt (21, Integer.parseInt(featuVec[20]));
				preparedStmt.setInt (22, Integer.parseInt(featuVec[21]));
				preparedStmt.setInt (23, Integer.parseInt(featuVec[22]));
				preparedStmt.setInt (24, Integer.parseInt(featuVec[23]));
				preparedStmt.setInt (25, Integer.parseInt(featuVec[24]));
				preparedStmt.setInt (26, Integer.parseInt(featuVec[25]));
				preparedStmt.setInt (27, Integer.parseInt(featuVec[26]));
				preparedStmt.setInt (28, Integer.parseInt(featuVec[27]));
				preparedStmt.setInt (29, Integer.parseInt(featuVec[28]));
				preparedStmt.setInt (30, Integer.parseInt(featuVec[29]));
				preparedStmt.setInt (31, Integer.parseInt(featuVec[30]));
				preparedStmt.setInt (32, Integer.parseInt(featuVec[31]));
				preparedStmt.setInt (33, Integer.parseInt(featuVec[32]));
				preparedStmt.setInt (34, Integer.parseInt(featuVec[33]));
				preparedStmt.setInt (35, Integer.parseInt(featuVec[34]));
				preparedStmt.setInt (36, Integer.parseInt(featuVec[35]));
				preparedStmt.setString  (37, notnull);
			//	preparedStmt.setInt (37, Integer.parseInt(featuVec[36]));
				//preparedStmt.setInt (2, Integer.parseInt(words[35]));
									
				// execute the preparedstatement
				preparedStmt.execute();
				

 			
 		}
    	 
	   }
     

     }    
    }    
    	
    }
	