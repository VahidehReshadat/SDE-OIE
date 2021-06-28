import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.commons.io.FileUtils;

public class CnvrtPerltoSql {
	static Connection con;
	String username = "root";
	String password = "root";
	String dbName = "difficultyrelations";

	public CnvrtPerltoSql() {

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

	public void convertanalysisql() throws IOException {
		
		String content = "";
		String arg1="";
		String rel="";
		String arg2="";
		int SentID=9000;
		String sentenceid="";
		String sentence="";
		String trfl="";
		String misscoremist="";
		
		
		File txtdoc = new File("D:\\eclipse workspace\\DifficultyofOpenIE\\dataset\\myExemplarOutput2.txt");

		if (txtdoc.isFile() && txtdoc.getName().endsWith(".txt")) {
			content = FileUtils.readFileToString(txtdoc);

			String[] sentences = content.split("\n");
			
			
			for (int k = 0; k < sentences.length; k = k + 1) {
				
				String st = sentences[k].toString();   //sjomare satr
				
				System.out.println(st);
				
				if(st.contains("\t"))
				{
				String[] sntIDee=st.split("\t");
				sentenceid=sntIDee[0];
				sentenceid=sentenceid.replaceAll("(\\r)", "");
				sentenceid=sentenceid.replaceAll("@", " ");
				sentenceid=sentenceid.replaceAll("&", " ");
				sentenceid=sentenceid.replaceAll("﻿", "");
				//sentenceid=sentenceid.replaceAll(" ", " ");
				SentID = Integer.parseInt(sentenceid);
				sentence=sntIDee[1];
				arg1=sntIDee[2];
				rel=sntIDee[3];
				arg2=sntIDee[4];
			 	trfl=sntIDee[5];
				misscoremist=sntIDee[6];
				}
				
				
					try {
						
						
						 arg1=arg1.replaceAll("(\\r)", "");
						 arg1=arg1.replaceAll("@", " ");
						 arg1=arg1.replaceAll("&", " ");	
						 
						 
						 rel=rel.replaceAll("(\\r)", "");
						 rel=rel.replaceAll("@", " ");
						 rel=rel.replaceAll("&", " ");	
						 
						 
						 
						 arg2=arg2.replaceAll("(\\r)", "");
						 arg2=arg2.replaceAll("@", " ");
						 arg2=arg2.replaceAll("&", " ");	
						
					//	String query = " insert into penmanubingroundtruth (`SntNum`, `Snt`, `Arg1`, `Rel`, `Arg2`)"
						//		+ " values (?, ?, ?, ?, ?)";

						
						String query = " insert into webmanubinexemplar (`SntNum`, `Snt`, `Arg1`, `Rel`, `Arg2`, `TruFls`, `MissCorMist`)"
								+ " values (?, ?, ?, ?, ?, ?, ?)";
						
						// create the mysql insert preparedstatement
						PreparedStatement preparedStmt = con.prepareStatement(query);
						// preparedStmt.setString (1, words[0]);
						preparedStmt.setInt(1, SentID);
						preparedStmt.setString (2, sentence);
						preparedStmt.setString (3, arg1);
						preparedStmt.setString (4, rel);
						preparedStmt.setString (5, arg2);
						preparedStmt.setString (6, trfl);
						preparedStmt.setString (7, misscoremist);
											
						// execute the preparedstatement
						preparedStmt.execute();
					}
				catch (Exception ex) {
						System.out.println(ex.getMessage());
					}


			}
		}

	}
}
