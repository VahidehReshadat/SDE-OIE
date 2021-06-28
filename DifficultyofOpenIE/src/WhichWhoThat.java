import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WhichWhoThat {

	public void WhichThatWho() throws IOException {
	
	 String Str = new String("Welcome to TutorIalSpoint.com");
     System.out.print("Return Value :");
	 System.out.println(Str.toLowerCase());
	 
	 
	// Tekrarrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr nashmorimmmmmmm

	 String sentence = "Check this that answer and you can find which the keyword that this code";
	 String search  = "which";
	 String search1  = "that";
	 String search2  = "who";
 
	 
	 
	 int c1=0;

	 if ( sentence.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {

	    c1++;
	    System.out.println("I found the keyword which "+c1);


	 } else {

	    System.out.println("not found which");

	 }
	 
	int c2=0;
	
	 if ( sentence.toLowerCase().indexOf(search1.toLowerCase()) != -1 ) {

		    c2++;
		    System.out.println("I found the keyword that "+c2);


		 }
	else {

		    System.out.println("not found that");

		 } 
    int c3=0;
	 
	 if ( sentence.toLowerCase().indexOf(search2.toLowerCase()) != -1 ) {

		    c3++;
		    System.out.println("I found the keyword who "+c3);


		 } else {

		    System.out.println("not found who");

		 } 
	 
	 String in = "Check this that answer and you can find which the keyword that this code";
	 int i = 0;
	 Pattern p = Pattern.compile("that");
	 Matcher m = p.matcher( in );
	 while (m.find()) {
	     i++;
	 }
	 System.out.println(i); // Prints 2
	 
	 
	}
	
}

////////////////////////////////         equals

/*String in = "i have a male cat. the color of male cat is Black";
int i = 0;
Pattern p = Pattern.compile("male cat");
Matcher m = p.matcher( in );
while (m.find()) {
    i++;
}
System.out.println(i); // Prints 2

*/



