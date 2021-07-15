import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;


public class cntrStopWords {
	
	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "difficultyrelations";
	
    public cntrStopWords() {
     		
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
	
	
    public List<String> lemmatize(String text)
    {
    	Properties props = new Properties();
    	
      	 props.setProperty("annotators", "tokenize, ssplit, pos, lemma");

    	
    	 StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    	 Annotation document = new Annotation(text);
    	
    	 List<String> lemmas = new LinkedList<String>();
    	 
    	 pipeline.annotate(document);
    	
    	 List<CoreMap> sentences = document.get(SentencesAnnotation.class);
    	 
    	 for(CoreMap sentence: sentences) {
    	      // traversing the words in the current sentence
    	      // a CoreLabel is a CoreMap with additional token-specific methods
    	      for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
    	 
    	    	  lemmas.add(token.get(LemmaAnnotation.class));
    	      }
    	 
    	 }
  
        return lemmas;
    }
	
	
	public static int FindString(String text,  String[] ComCogArray1)
    {
	//String sentence = "Check this answer and you can find keyword with this code" ;
	//String search  = "keyword";
		
		int flag=0;
		
		
	for (int i=0; i<ComCogArray1.length; i++)	
	{	
		
		String CmCgList=ComCogArray1[i].toString();
		//System.out.println(ComCogArray1[i]);
		
		
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
		String[] splitedtext = text.split(" ");

		CmCgList = CmCgList.replace(",,", "");
		CmCgList = CmCgList.replace(",", "");
		CmCgList = CmCgList.replaceAll("(\\r)", "");
		CmCgList = CmCgList.replaceAll("@", " ");
		CmCgList = CmCgList.replaceAll("&", " ");
		CmCgList = CmCgList.replaceAll("%", " ");
		CmCgList = CmCgList.replace("  ", " ");
		CmCgList = CmCgList.trim().replaceAll(" +", " ");

		
		for(int s=0; s<splitedtext.length; s++)
		{
			
			splitedtext[s]=(splitedtext[s].toLowerCase());
			
			
			if((splitedtext[s].matches(CmCgList)) && flag==0) {
        
	 System.out.println(text+"     "+CmCgList);
	 
	 flag=1;
	 System.out.println("flagggggg "+flag);
	}
	else {
	 System.out.println("not found");
	}
		}
	
	}
	return flag;
	
	
    }
    
	
	public static int CntStpWrds(String text,  String[] ComCogArray1)
    {
	//String sentence = "Check this answer and you can find keyword with this code" ;
	//String search  = "keyword";
		
		int flag=0;
		int cntrs=0;
		
		
	for (int i=0; i<ComCogArray1.length; i++)	
	{	
		
		String CmCgList=ComCogArray1[i].toString();
		//System.out.println(ComCogArray1[i]);
		
		
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
		String[] splitedtext = text.split(" ");

		CmCgList = CmCgList.replace(",,", "");
		CmCgList = CmCgList.replace(",", "");
		CmCgList = CmCgList.replaceAll("(\\r)", "");
		CmCgList = CmCgList.replaceAll("@", " ");
		CmCgList = CmCgList.replaceAll("&", " ");
		CmCgList = CmCgList.replaceAll("%", " ");
		CmCgList = CmCgList.replace("  ", " ");
		CmCgList = CmCgList.trim().replaceAll(" +", " ");

		
		for(int s=0; s<splitedtext.length; s++)
		{
			
			splitedtext[s]=(splitedtext[s].toLowerCase());
			
			
			if(splitedtext[s].matches(CmCgList)) {
				
				cntrs++;
        
	 System.out.println(text+"     "+CmCgList);
	 
	 flag=1;
	 System.out.println("flagggggg "+flag);
	}
	else {
	 System.out.println("not found");
	}
		}
	
	}
	return cntrs;
	
	
    }
	
	
	
	
	public void SntStopWordCnt() throws IOException, SQLException {
    	
    	String content="";
    

    File txtdoc = new File("D:\\eclipse workspace\\DifficultyofOpenIE\\stopwords_en.txt");  
    
	
 //   if (txtdoc.isFile() && txtdoc.getName().endsWith(".txt"))
  //    {
    
           content = FileUtils.readFileToString(txtdoc);  
           String[] ComCogArray = content.split("\n");

   //   }
           
      //     for (int i=0; i<ComCogArray.length; i++)	
    //   	{
        	   
     //   	   System.out.println("Stop words list: "+ComCogArray[i]);   
        	   
     //  	}

           
           String sql = "SELECT * FROM testdatapen111";
  	       Statement statement = con.createStatement();
  	       java.sql.ResultSet result = statement.executeQuery(sql);

  	       while (result.next()){
  	           
  	         String sent = result.getString(3);
  	         int joinidd = result.getInt(11);
        	 
  	        String text= sent;
        	
           
           
     //   String text= "ago count numbers words a are back";
 /*       
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
		
	      System.out.println("Text trim shodeeeeeee "+text);
	      */
        
        
        cntrStopWords slem = new cntrStopWords();
	    text=slem.lemmatize(text).toString();
        int mmn=FindString(text,ComCogArray); 
        int cntStp=CntStpWrds(text,ComCogArray);
        System.out.println("Cnt of StopWords: "+mmn +"cntrs  "+cntStp+"text lemmatize   "+text);
 

        System.out.println("AASSSLLIii:"+text);
/*       Dbsnts= sentences[k].split("\t");
       int foo = Integer.parseInt(Dbsnts[0]); 
  */       
 	   String query = " insert into tftrcntstpwrds111 (Snt, joinID, ftrcognition, cnts)"
                    + " values (?, ?, ?, ?)";
                              	             
                  // create the mysql insert preparedstatement
                  PreparedStatement preparedStmt1 = con.prepareStatement(query);
                //  preparedStmt1.setInt(1, depid);
                  
           //       preparedStmt1.setInt (1, foo);
               
           //     preparedStmt1.setString (2, Dbsnts[1]); 
                  preparedStmt1.setString (1, sent);
                  preparedStmt1.setInt (2, joinidd);
                  preparedStmt1.setInt (3, mmn);  
                  preparedStmt1.setInt (4, cntStp);

                  preparedStmt1.execute();
        
                //  cntrsnt++;  
      
         
 
          if (mmn!=0){
        	  
                System.out.println("AASSSLLIii:"+text);
 
                      } 

    }
	
	
    
    
	}    
    
    
}
