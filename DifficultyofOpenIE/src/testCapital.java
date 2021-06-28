
public class testCapital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int ct=0;
		  String s="What fun , what with the costumes , the music , the pageantry , the pride , starting last evening with Italian night as the ethnically diverse Mets  met the equally diverse  Dodgers .";
		  
		  s = s.replace(",","");
		  s = s.replace(".","");
		  s=s.trim().replaceAll(" +", " ");
				  
		  System.out.println("Trimmmm: "+s);
		  
		  String[] sentences = s.split(" ");
		 
		  for(int k=0; k<sentences.length; k++) {
			  System.out.println("S[k] "+sentences[k]);
		  }
		  
	    for(int k=0; k<sentences.length; k++) {
	        if((sentences[k].charAt(0)>=65) && (sentences[k].charAt(0)<=90))
	        {
	            ct++;

	        }
    
	    }
		
	    System.out.println("total  number of words start with capital letters are :"+ct);  
		
		
	}

}
