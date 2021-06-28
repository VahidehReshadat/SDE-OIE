import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import edu.stanford.nlp.util.ArrayUtils;


public class CnvrtComCogWrds {

	
	
	
	public static String[]  pickString() throws IOException
	{
		
		// TODO Auto-generated method stub
		
		String content="";
		String content1="";

		String[] sentences = new String[78];
		String[] sentences1 = new String[97];
		
		int cnt=0;
		int cnt1=0;
		int cnt2=0;

		File txtdoc = new File("D:\\eclipse workspace\\ImproveExtractions\\MyData\\cognitiveWords.txt");
			
        if (txtdoc.isFile() && txtdoc.getName().endsWith(".txt"))
       {
       content = FileUtils.readFileToString(txtdoc);  

        sentences = content.split("\n");
        for(int k=0; k<sentences.length; k++)
        {
        //	System.out.println(sentences[k]);
        //	cnt++;
        }	
      //  System.out.println(cnt);
	}

        File txtdoc1 = new File("D:\\eclipse workspace\\ImproveExtractions\\MyData\\communicationWords.txt");   
        if (txtdoc1.isFile() && txtdoc1.getName().endsWith(".txt"))
        {
        content1 = FileUtils.readFileToString(txtdoc1);  

          sentences1 = content1.split("\n");
         for(int k=0; k<sentences1.length; k++)
         {
        // 	System.out.println(sentences1[k]);
        // 	cnt1++;
        	 
        	 
         }	
       //  System.out.println(cnt1);
 	}
        
        
        String[] both = ArrayUtils.concatenate(sentences, sentences1); 
        
        for(int k=0; k<both.length; k++)
        {
        //	System.out.println(both[k]);
        //	cnt2++;
        }
      //  System.out.println("Kolle araye "+cnt2);
        
        
        return both;

	
	
	}
}
