import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;

public class Saydetect {
  
	
	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "imprelext";
	
    public Saydetect() {
    
    try {
        String url = "jdbc:mysql://localhost:3306/imprelext";
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
	
	
  // protected StanfordCoreNLP pipeline;
 

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


    
    
	public static int FindString(String text,  String strng)
    {
	//String sentence = "Check this answer and you can find keyword with this code" ;
	//String search  = "keyword";
		
		int c=0;
		
		
//	for (int i=0; i<ComCogArray1.length; i++)	
//	{	
		
		String CmCgList=strng;
		//System.out.println(ComCogArray1[i]);
		
		
		text = text.replace(".", "");
		text = text.replace("[", "");
		text = text.replace("]", "");
		text = text.replace(",,", "");
		text = text.replace(",", "");
		text = text.replaceAll("(\\r)", "");
		text = text.replaceAll("@", " ");
		text = text.replaceAll("&", " ");
		text = text.replace("  ", " ");
		

		CmCgList = CmCgList.replace(",,", "");
		CmCgList = CmCgList.replace(",", "");
		CmCgList = CmCgList.replaceAll("(\\r)", "");
		CmCgList = CmCgList.replaceAll("@", " ");
		CmCgList = CmCgList.replaceAll("&", " ");
		CmCgList = CmCgList.replace("  ", " ");
		
		
		   List<String> tokens = new ArrayList<String>();
           
       
           
           tokens.add(CmCgList);
        
        String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
            c++;
        }  

 	 System.out.println("Tekrare SAY is "+c); // Prints 2
	return c;
		
		
		
		
		
		
		

//	if (text.toLowerCase().indexOf(CmCgList.toLowerCase()) != -1 && flag==0) {
        
	// System.out.println(text);
	 
	// flag=1;
	
//	} else {
	// System.out.println("not found");
//	}
	
//	}
	//return flag;
	
	
    }
    
    
    
    
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Starting Stanford Lemmatizer");
        
    //    String content="";
        String text="";
    //    String[] Dbsnts = new String[2];
   //     int cntrsnt=1;
        
        
   //	File txtdoc = new File("D:\\eclipse workspace\\ImproveExtractions\\AllSnts300Ollie.txt");
   			
      
         {
        	//  String mmn=null;
        	text= "She said me. says saying";
        	  System.out.println("jomle asli: "+text);
        	Saydetect slem = new Saydetect();
         //   System.out.println(slem.lemmatize(text));
             
        	text=slem.lemmatize(text).toString();
         
       //     String[] ComCogArray= CnvrtComCogWrds.pickString();
            
            
           // SearchString sstrg=new SearchString();
           int mmn=FindString(text,"say"); 
            System.out.println("tedade Say ha: "+mmn);
            System.out.println("jomle lematize shode: "+text);
            
            if (mmn!=0){
       //     System.out.println("AASSSLLIii:"+text);
   /*       Dbsnts= sentences[k].split("\t");
           int foo = Integer.parseInt(Dbsnts[0]); 
      */       
     	/*   String query = " insert into ollienstsnts (sntnum, Snts)"
	                    + " values (?, ?)";
                                  	             
	                  // create the mysql insert preparedstatement
	                  PreparedStatement preparedStmt1 = con.prepareStatement(query);
	                //  preparedStmt1.setInt(1, depid);
	                  
	           //       preparedStmt1.setInt (1, foo);
	                  preparedStmt1.setInt (1, cntrsnt);
	           //     preparedStmt1.setString (2, Dbsnts[1]); 
	                  preparedStmt1.setString (2, text);
	                  

	                  preparedStmt1.execute();
            
	                  cntrsnt++;  
            
         }
            
            else 
            	
            {
            	//System.out.println("AASSSLLIii:"+sentences[k].toString());
                Dbsnts= sentences[k].split("\t");
               int foo = Integer.parseInt(Dbsnts[0]);
               
         	   String query = " insert into ollienotnested (sntnum, Snts)"
    	                    + " values (?, ?)";
                                      	             
    	                  // create the mysql insert preparedstatement
    	                  PreparedStatement preparedStmt1 = con.prepareStatement(query);
    	                //  preparedStmt1.setInt(1, depid);
    	                  
    	                  preparedStmt1.setInt (1, cntrsnt);
    	              //    preparedStmt1.setString (2, Dbsnts[1]); 
    	                  preparedStmt1.setString (2, text);
    	                  
    	                  preparedStmt1.execute();
                	
    	                  cntrsnt++; */
            }
            
         }
         
         
     //   }
        
       
    }

}