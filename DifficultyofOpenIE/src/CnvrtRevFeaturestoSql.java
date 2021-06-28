import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.commons.io.FileUtils;

public class CnvrtRevFeaturestoSql {
	static Connection con;
	String username = "root";
	String password = "root";
	String dbName = "difficultyrelations";

	public CnvrtRevFeaturestoSql() {

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
		// File txtdoc = new
		// File("D:/eclipse workspace/ConvertTestDataToDb/reverb_emnlp2011_data/sentences");
		File txtdoc = new File("D:\\eclipse workspace\\MyLogisticRegression\\dataset\\abc2Testdata.txt");

		if (txtdoc.isFile() && txtdoc.getName().endsWith(".txt")) {
			content = FileUtils.readFileToString(txtdoc);

			// System.out.println(listOfFiles[i].getName());
			// String str1=txtdoc.getName();
			// System.out.println(str1);
			
		//	int SentID=-1;

			String[] sentences = content.split("\n");
			
			
			for (int k = 0; k < sentences.length; k = k + 3) {
				
				String st = sentences[k].toString();   //sjomare satr
				String sent = sentences[k+2].toString(); ///features vector
				
				System.out.println(st);
				
		/*		if(st.contains("\t"))
				{
				String[] sntIDee=st.split("\t");
				String sentenceid=sntIDee[1];
				SentID = Integer.parseInt(sentenceid);
				}
		*/		
				System.out.println(st);
				System.out.println(sent);
				String[] sntIDee=st.split("\t");

				//if ((sent.contains("\t")) && (st.contains("\t"))) {
				
				if ((sent.contains(","))) {

					String[] words = sent.split(",");
				//	String[] sntIDee=st.split("\t");
					
					for(int i=0;i<=35;i++)
					{
						if(words[i].equals("false"))
						{
							words[i]="0";
						}
						else
						{
							words[i]="1";
						}
						
					}
					

					System.out.println(words[0]);
					System.out.println(words[1]);
					System.out.println(words[2]);
				    System.out.println(words[3]);
					System.out.println(words[4]);
					System.out.println(words[5]);
					System.out.println(words[6]);
					System.out.println(words[2]);
					System.out.println(words[2]);
					System.out.println(words[2]);
					System.out.println(words[2]);
					
					
					try {
						
						
						// Arg1=Arg1.replaceAll("(\\r)", "");
						//words[0] = words[0].replaceAll("(\\r)", "");
						//words[1] = words[1].replaceAll("(\\r)", "");
						//words[2] = words[2].replaceAll("(\\r)", "");
						for(int j=0;j<=35;j++)
						{	
						words[j] = words[j].replaceAll("(\\r)", "");
						}
						
						sntIDee[0] = sntIDee[0].replaceAll("(\\r)", "");
						
						// words[3]=words[3].replaceAll("(\\r)", "");
						// words[4]=words[4].replaceAll("(\\r)", "");
						// words[5]=words[5].replaceAll("(\\r)", "");

					//	double cvtpc = Int.parseDouble(words[j]);
					//	int SentID = Integer.parseInt(sntIDee[1]);

						// the mysql insert statement
						
						
						String query = " insert into revtestfeatures (`SntID`, `Rf1`, `Rf2`, `Rf3`, `Rf4`, `Rf5`, `Rf6`, `Rf7`, `Rf8`, `Rf9`, `Rf10`, `Rf11`, `Rf12`, `Rf13`, `Rf14`, `Rf15`, `Rf16`, `Rf17`, `Rf18`, `Rf19`, `Rf20`, `Rf21`, `Rf22`, `Rf23`, `Rf24`, `Rf25`, `Rf26`, `Rf27`, `Rf28`, `Rf29`, `Rf30`, `Rf31`, `Rf32`, `Rf33`, `Rf34`, `Rf35`)"
								+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

						
						
						
						// create the mysql insert preparedstatement
						PreparedStatement preparedStmt = con.prepareStatement(query);
						// preparedStmt.setString (1, words[0]);
						preparedStmt.setInt(1, Integer.parseInt(sntIDee[0]));
						preparedStmt.setInt (2, Integer.parseInt(words[0]));
						preparedStmt.setInt (3, Integer.parseInt(words[1]));
						preparedStmt.setInt (4, Integer.parseInt(words[2]));
						preparedStmt.setInt (5, Integer.parseInt(words[3]));
						preparedStmt.setInt (6, Integer.parseInt(words[4]));
						preparedStmt.setInt (7, Integer.parseInt(words[5]));
						preparedStmt.setInt (8, Integer.parseInt(words[6]));
						preparedStmt.setInt (9, Integer.parseInt(words[7]));
						preparedStmt.setInt (10, Integer.parseInt(words[8]));
						preparedStmt.setInt (11, Integer.parseInt(words[9]));
						preparedStmt.setInt (12, Integer.parseInt(words[10]));
						preparedStmt.setInt (13, Integer.parseInt(words[11]));
						preparedStmt.setInt (14, Integer.parseInt(words[12]));
						preparedStmt.setInt (15, Integer.parseInt(words[13]));
						preparedStmt.setInt (16, Integer.parseInt(words[14]));
						preparedStmt.setInt (17, Integer.parseInt(words[15]));
						preparedStmt.setInt (18, Integer.parseInt(words[16]));
						preparedStmt.setInt (19, Integer.parseInt(words[17]));
						preparedStmt.setInt (20, Integer.parseInt(words[18]));
						preparedStmt.setInt (21, Integer.parseInt(words[19]));
						preparedStmt.setInt (22, Integer.parseInt(words[20]));
						preparedStmt.setInt (23, Integer.parseInt(words[21]));
						preparedStmt.setInt (24, Integer.parseInt(words[22]));
						preparedStmt.setInt (25, Integer.parseInt(words[23]));
						preparedStmt.setInt (26, Integer.parseInt(words[24]));
						preparedStmt.setInt (27, Integer.parseInt(words[25]));
						preparedStmt.setInt (28, Integer.parseInt(words[26]));
						preparedStmt.setInt (29, Integer.parseInt(words[27]));
						preparedStmt.setInt (30, Integer.parseInt(words[28]));
						preparedStmt.setInt (31, Integer.parseInt(words[29]));
						preparedStmt.setInt (32, Integer.parseInt(words[30]));
						preparedStmt.setInt (33, Integer.parseInt(words[31]));
						preparedStmt.setInt (34, Integer.parseInt(words[32]));
						preparedStmt.setInt (35, Integer.parseInt(words[33]));
						preparedStmt.setInt (36, Integer.parseInt(words[34]));
						//preparedStmt.setInt (2, Integer.parseInt(words[35]));
						
						
						// preparedStmt.setString (3, words[2]);
						// preparedStmt.setString (4, words[3]);
						// preparedStmt.setString (5, words[4]);
						// preparedStmt.setString (6, words[5]);
						// preparedStmt.setString (7, words[6]);
						// preparedStmt.setInt (5, 5000);

						// execute the preparedstatement
						preparedStmt.execute();
					}
				catch (Exception ex) {
						System.out.println(ex.getMessage());
					}

					// firstWord= sent.substring(0, sent.indexOf("\t"));
					// lastWords= sent.substring(sent.indexOf("\t"),sent.ind);

					// String sentId=firstWord;
					// String sentinst=lastWords;

					// String sentId = sent.substring(0,3);

				}
				// System.out.println(sentinst);

			}
		}

	}
}
