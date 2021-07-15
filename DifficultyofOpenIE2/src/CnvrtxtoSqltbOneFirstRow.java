import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;



//////////////// in barname baraye 1 sartr gahi 2 khoorooji darad bejaye inke 1 bar baraye har shomare chap konad, 

//                           rahe halinke bad az darj dar jadval az query zir estefade kardim
//          ALTER IGNORE TABLE `txttestallfeatures3final` ADD UNIQUE INDEX `name` (`SntIDTD`);

public class CnvrtxtoSqltbOneFirstRow {

	
	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "confidencepaper";

    public CnvrtxtoSqltbOneFirstRow() {
    	
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
	
 		 System.out.println("fooooooooooooo: NULL");
 
 		}
 		 
 		
 		else if ((StringUtils.isNumeric(h)))//vaghti ADAD bashad
 		
 		{
 			 System.out.println("wwww meghdare NUMber: "+h); 
 			 
 			 
 			if(h!=null || h!="" || h!=" ") 
 			{ 
 			cntr=h;
 			}
 			
 			// cntr = Integer.parseInt(h);	
 		    System.out.println("KAnter: "+cntr);
 		    
 		   String ms=sentences[k+2];
 		    
 		    if(!(StringUtils.isNumeric(ms))){
 		    		    
 		    int  w=k+2;
 		 
 		   // if(w>=0){
 		
 		   // int w=k+2;
 			 String wh=sentences[w];
      	    wh = wh.replaceAll("(\\r)", " ");
 			wh = wh.replaceAll("@", " ");
 			wh = wh.replaceAll("&", " ");
 			wh = wh.replace("  ", " "); 
 			wh = wh.trim().replaceAll(" +", " ");
      	 

  	//	if(h==null || h=="" || h==" ")//GenericValidator.isBlankOrNull(s)
 			if((wh == null) || (wh.trim().length() == 0) || (wh.equals("")) || wh.isEmpty())	
  		{
  		//int foo = Integer.parseInt(h);	
  		 System.out.println("fooooooooooooo: NULL");
  		 
  		//cntr = Integer.parseInt(h);	
 		// System.out.println(cntr);
  		
  		}
 		    
 			else if (!(StringUtils.isNumeric(wh))){
 				
 				 String[] featuVec = wh.split(",");
 	 			 System.out.println("featuVec   "+Arrays.toString(featuVec));
 	 			 
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
 				preparedStmt.setInt (37, Integer.parseInt(notnull));
 			//	preparedStmt.setInt (37, Integer.parseInt(featuVec[36]));
 				//preparedStmt.setInt (2, Integer.parseInt(words[35]));
 									
 				// execute the preparedstatement
 				preparedStmt.execute();
 				

 				
 			}    
 		    
 		} 
 			
 		}
 		
 		
 	
    	 
	   }
     

     }    
    }    
    	
    }
	