import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class CountWordBlank {

    public int countWords(String s) {
        int counter = 0;
        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            //if the char is letter, word = true.
            if (Character.isLetter(s.charAt(i)) == true && i != endOfLine) {
                word = true;
                //if char isnt letter and there have been letters before (word == true), counter goes up.
            } else if (Character.isLetter(s.charAt(i)) == false && word == true) {
                counter++;
                word = false;
                //last word of String, if it doesnt end with nonLetter it wouldnt count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        CountWordBlank MyClass = new CountWordBlank();
        //MyClass.countWords("hgkgj");
        //  System.out.println(MyClass.countWords("hgkg  + #     jgkjg   j"));
        
        
        //shey az kelase file ejad mishavad va meghdar (sazande shaiad) file ebtedaie ra be an midahad
        //1 shey az Filereader va 1 shey az Bufferreader ejad mikonad va file ejadshode ghabli be onvane 
        //vorudie FileReade ast va khode Bufferreade sheye ejad shode FileReader ra be onvane vorudimigirad 
        //harja moghe ejade shey meghdar midahad be sazandeash meghdar dehi mikonad 
        
        File initfile = new File("data\\init.txt");
        BufferedReader reader = new BufferedReader(new FileReader(initfile));
        String line;
        
        String longSen="";
        String ShortSen="";
        //ArrayList<String> longSen = new ArrayList<String>();
        //ArrayList<String> ShortSen = new ArrayList<String>();
        
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            int wordCount = MyClass.countWords(line);
            System.out.println(MyClass.countWords(line));
            if (wordCount < 4) {
                ShortSen+=line+"#";
     //           ShortSen.add(line);
            }
            if (wordCount >= 4) {
       //         longSen.add(line);
                 longSen+=line+"#";
            }

        }
        FileUtils.writeStringToFile(new File("longSen.txt"), longSen);
        FileUtils.writeStringToFile(new File("ShortSen.txt"), ShortSen);
        reader.close();
        
        



    }
}
