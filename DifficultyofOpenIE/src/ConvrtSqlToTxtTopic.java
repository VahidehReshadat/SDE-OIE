import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;


public class ConvrtSqlToTxtTopic {
	
	static Connection con;
    String username = "root";
    String password = "root";
    String dbName = "0";

    public ConvrtSqlToTxtTopic() {
    	
        try {
            String url = "jdbc:mysql://localhost:3306/0";
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
    
    
    public void CnvrSqlTTxt() throws IOException {
    	
    try{
    	
    String sql = "SELECT * FROM trainingdataddnytweb222finalrefinmentrmv";
    Statement statement = con.createStatement();
    java.sql.ResultSet result = statement.executeQuery(sql);
    
    String yesnoSen="";
    int c=0;

    while (result.next()){
  
    	int gSid=result.getInt(1);
    	int TdSid = result.getInt(2);
  		String Snt = result.getString(3);
  		String Rev = result.getString(4);
  		String Exmp = result.getString(5);
  		String RevExmpTrFl = result.getString(6);
  		String Arg1 = result.getString(7);
        String Rel1 = result.getString(8);
        String arg2 = result.getString(9);
        int feature1 = result.getInt(10);
        int joinId = result.getInt(11);
     /*   float ftr1=result.getFloat(9);
        float ftr2=result.getFloat(10);
        float ftr3=result.getFloat(11);
        float ftr4=result.getFloat(12);
        double Cakhod=result.getDouble(13);
        double Cvkhod=result.getDouble(14);
        double CAAve=result.getDouble(15);
        double CvAve=result.getDouble(16);
       */
        
     // /*  
        int ftr1=result.getInt(12);
        int ftr2=result.getInt(13);
        int ftr3=result.getInt(14);
        int ftr4=result.getInt(15);
        int ftr5=result.getInt(16);
        int ftr6=result.getInt(17);
        int ftr7=result.getInt(18);
        int ftr8=result.getInt(19);
        int ftr9=result.getInt(20);
        int ftr10=result.getInt(21);
        int ftr11=result.getInt(22);
        int ftr12=result.getInt(23);
        int ftr13=result.getInt(24);
        int ftr14=result.getInt(25);
        int ftr15=result.getInt(26);
        int ftr16=result.getInt(27);
        int ftr17=result.getInt(28);
        int ftr18=result.getInt(29);
        int ftr19=result.getInt(30);
        int ftr20=result.getInt(31);
        int ftr21=result.getInt(32);
        int ftr22=result.getInt(33);
        int ftr23=result.getInt(34);
        int ftr24=result.getInt(35);
        int ftr25=result.getInt(36);
        int ftr26=result.getInt(37);
        int ftr27=result.getInt(38);
        int ftr28=result.getInt(39);
        int ftr29=result.getInt(40);
        int ftr30=result.getInt(41);
        int ftr31=result.getInt(42);
        int ftr32=result.getInt(43);
        int ftr33=result.getInt(44);
        int ftr34=result.getInt(45);
        int ftr35=result.getInt(46);
      
        int ftr36=result.getInt(47);
        int ftr37=result.getInt(48);
       
        int ftr38=result.getInt(49);
        int ftr39=result.getInt(50);
        
        int ftr40=result.getInt(51);
        int ftr41=result.getInt(52);
        
        int ftr42=result.getInt(53);
        int ftr43=result.getInt(54);
       
        int ftr44=result.getInt(55);
        int ftr45=result.getInt(56);

       
       int ftr46=result.getInt(57);
       
       int ftr47=result.getInt(58);
       int ftr48=result.getInt(59);
       int ftr49=result.getInt(60);
       int ftr50=result.getInt(61);
       int ftr51=result.getInt(62);
       int ftr52=result.getInt(63);
       int ftr53=result.getInt(64);
       int ftr54=result.getInt(65);
       int ftr55=result.getInt(66);
       int ftr56=result.getInt(67);
       int ftr57=result.getInt(68);
       int ftr58=result.getInt(69);
       int ftr59=result.getInt(70);
       int ftr60=result.getInt(71);

       
     //    */
        
        
        //++++++++++++++++++++++++++++
   /*     int ftr12=result.getInt(9);
        int ftr21=result.getInt(10);
        int ftr23=result.getInt(11);
        int ftr26=result.getInt(12);
        int ftr32=result.getInt(13);
        int ftr34=result.getInt(14);
        int ftr35=result.getInt(15);
     
        float mf1=result.getFloat(9);
        float mf2=result.getFloat(10);
        float mf4=result.getFloat(11);
        
        int wrdcf=result.getInt(12);
        int wrdcn=result.getInt(13);
        */
        
        int m=Integer.parseInt(RevExmpTrFl);
        
       
  // 	yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf4+","+"?"+"\n";

//  yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"?"+"\n";

   //     yesnoSen+=ftr6+","+ftr12+","+ftr21+","+ftr23+","+ftr32+","+myf1+","+myf2+","+myf4+","+ftr30+","+wrdcntftr+","+"?"+"\n";  


      //   yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+CAAve+","+CvAve+","+"?"+"\n";
   //    c++;
        
    //    yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+Cakhod+","+Cvkhod+","+"?"+"\n";
        
        // yesnoSen+=ftr1+","+ftr2+","+ftr4+","+CvAve+","+"?"+"\n";
      //  yesnoSen+=ftr1+","+ftr2+","+ftr4+","+Cvkhod+","+"?"+"\n";
        
    //  yesnoSen+=ftr12+","+ftr21+","+ftr23+","+ftr26+","+ftr32+","+ftr34+","+ftr35+","+wrdcf+","+"?"+"\n";  
   //   yesnoSen+=myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uci+","+wrdcntftr+","+"?"+"\n";
  //     yesnoSen+=myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"?"+"\n";

  //    yesnoSen+=ftr12+","+ftr21+","+ftr23+","+ftr26+","+ftr32+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf4+","+wrdcntftr+","+"?"+"\n";  
   	// yesnoSen+=feature1+myf1+","+myf2+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"?"+"\n";

 //  yesnoSen+=feature1+","+ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+ftr36+","+ftr37+","+ftr38+","+ftr39+","+ftr40+","+ftr41+","+ftr42+","+ftr43+","+ftr44+","+ftr45+","+ftr46+","+ftr47+","+ftr48+","+ftr49+","+ftr50+","+ftr51+","+ftr52+","+ftr53+","+ftr54+","+ftr55+","+ftr56+","+ftr57+","+ftr58+","+ftr59+","+ftr60+","+"?"+"\n";

        //   testdatapen111final **** trainingdataddnytweb111finalrefinment  ***  trainnytweb2refine ***  trainnytweb2
     //  yesnoSen+=ftr59+","+ftr5+","+ftr41+","+ftr4+","+feature1+","+ftr46+","+ftr1+","+ftr55+","+ftr38+","+ftr17+","+ftr30+","+ftr58+","+ftr31+","+"?"+"\n";
  
   
        //*** testdatapen222final  *****  trainingdataddnytweb222finalrefinment  *** trainnytweb1refine**** trainnytweb1
 //  yesnoSen+=ftr59+","+ftr41+","+ftr5+","+feature1+","+ftr46+","+ftr38+","+ftr4+","+ftr55+","+ftr1+","+ftr58+","+ftr17+","+ftr2+","+ftr11+","+"?"+"\n";
  
        
 //  c++;
        
     //   /*
      
        if(m==0)
        {
        
        	
        	//yesnoSen+=ftr1+","+ftr2+","+ftr4+","+CvAve+","+"no"+"\n";
        //	yesnoSen+=ftr1+","+ftr2+","+ftr4+","+Cvkhod+","+"no"+"\n";
 	
        //	yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+Cakhod+","+Cvkhod+","+"no"+"\n";
        	
         //	yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+CAAve+","+CvAve+","+"no"+"\n";
	
      //	yesnoSen+=feature1+","+ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+ftr36+","+ftr37+","+ftr38+","+ftr39+","+ftr40+","+ftr41+","+ftr42+","+ftr43+","+ftr44+","+ftr45+","+ftr46+","+ftr47+","+ftr48+","+ftr49+","+ftr50+","+ftr51+","+ftr52+","+ftr53+","+ftr54+","+ftr55+","+ftr56+","+ftr57+","+ftr58+","+ftr59+","+ftr60+","+"no"+"\n";

        	
        	
        	
        	  //   testdatapen111final **** trainingdataddnytweb111finalrefinment  ***  trainnytweb2refine ***  trainnytweb2
        //    yesnoSen+=ftr59+","+ftr5+","+ftr41+","+ftr4+","+feature1+","+ftr46+","+ftr1+","+ftr55+","+ftr38+","+ftr17+","+ftr30+","+ftr58+","+ftr31+","+"no"+"\n";
        
         
              //*** testdatapen222final  *****  trainingdataddnytweb222finalrefinment  *** trainnytweb1refine**** trainnytweb1
        yesnoSen+=ftr59+","+ftr41+","+ftr5+","+feature1+","+ftr46+","+ftr38+","+ftr4+","+ftr55+","+ftr1+","+ftr58+","+ftr17+","+ftr2+","+ftr11+","+"no"+"\n";
        
        	
         	
        	
        	
        	
    ////*****
     //   	yesnoSen+=feature1+","+ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+ftr36+","+ftr37+","+ftr38+","+ftr39+","+ftr40+","+ftr41+","+ftr42+","+ftr43+","+ftr44+","+ftr45+","+ftr46+","+ftr47+","+ftr48+","+ftr49+","+ftr50+","+ftr51+","+ftr52+","+ftr53+","+ftr54+","+ftr55+","+ftr56+","+ftr57+","+ftr58+","+ftr59+","+ftr60+","+"no"+"\n";
        
    // 	yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uciAve+","+wrdcntftr+","+"no"+"\n";

       //	yesnoSen+=ftr12+","+ftr21+","+ftr23+","+ftr26+","+ftr32+","+ftr34+","+ftr35+","+"no"+"\n"; 
   //   yesnoSen+=ftr12+","+ftr21+","+ftr23+","+ftr26+","+ftr32+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf4+","+wrdcntftr+","+"no"+"\n";  

       //	 yesnoSen+=mf1+","+mf2+","+mf4+","+wrdcf+","+"no"+"\n";
        //   yesnoSen+=myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"no"+"\n";
      //	  yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"no"+"\n";
     //   	 yesnoSen+=myf1+","+myf2+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"no"+"\n";
        	c++;
           	
        }
        
        if (m==1){
        	
        	//yesnoSen+=ftr1+","+ftr2+","+ftr4+","+CvAve+","+"yes"+"\n";
        //   yesnoSen+=ftr1+","+ftr2+","+ftr4+","+Cvkhod+","+"yes"+"\n";
        	
        //  	yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+Cakhod+","+Cvkhod+","+"yes"+"\n";
        	
        //  yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+CAAve+","+CvAve+","+"yes"+"\n";
        
        ///**** 
        //	yesnoSen+=feature1+","+ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+ftr36+","+ftr37+","+ftr38+","+ftr39+","+ftr40+","+ftr41+","+ftr42+","+ftr43+","+ftr44+","+ftr45+","+ftr46+","+ftr47+","+ftr48+","+ftr49+","+ftr50+","+ftr51+","+ftr52+","+ftr53+","+ftr54+","+ftr55+","+ftr56+","+ftr57+","+ftr58+","+ftr59+","+ftr60+","+"yes"+"\n";
	
        	
        
        	
        	
      	  //   testdatapen111final **** trainingdataddnytweb111finalrefinment  ***  trainnytweb2refine ***  trainnytweb2
        //   yesnoSen+=ftr59+","+ftr5+","+ftr41+","+ftr4+","+feature1+","+ftr46+","+ftr1+","+ftr55+","+ftr38+","+ftr17+","+ftr30+","+ftr58+","+ftr31+","+"yes"+"\n";
        
         
              //*** testdatapen222final  *****  trainingdataddnytweb222finalrefinment  *** trainnytweb1refine**** trainnytweb1
         yesnoSen+=ftr59+","+ftr41+","+ftr5+","+feature1+","+ftr46+","+ftr38+","+ftr4+","+ftr55+","+ftr1+","+ftr58+","+ftr17+","+ftr2+","+ftr11+","+"yes"+"\n";
        
        	
        	

        	
        //	yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+"yes"+"\n";
	
        //	yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf4+","+"yes"+"\n";
	
        //	yesnoSen+=ftr12+","+ftr21+","+ftr23+","+ftr26+","+ftr32+","+ftr34+","+ftr35+","+"yes"+"\n"; 
        	
       	// yesnoSen+=mf1+","+mf2+","+mf4+","+"yes"+"\n";
       //     yesnoSen+=ftr12+","+ftr21+","+ftr23+","+ftr26+","+ftr32+","+ftr34+","+ftr35+","+wrdcf+","+"yes"+"\n";  
     //  	 yesnoSen+=mf1+","+mf2+","+mf4+","+wrdcf+","+"yes"+"\n";
        //	yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uciAve+","+wrdcntftr+","+"yes"+"\n";

         //   yesnoSen+=ftr6+","+ftr12+","+ftr21+","+ftr23+","+ftr32+","+myf1+","+myf2+","+myf4+","+ftr30+","+wrdcntftr+","+"yes"+"\n";  
          //  yesnoSen+=myf1+","+myf2+","+myf4+","+caAve+","+cvAve+","+uci+","+wrdcntftr+","+"yes"+"\n";
         //   yesnoSen+=myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"yes"+"\n";
        //    yesnoSen+=ftr12+","+ftr21+","+ftr23+","+ftr26+","+ftr32+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf4+","+wrdcntftr+","+"yes"+"\n";  

        	//  yesnoSen+=ftr1+","+ftr2+","+ftr3+","+ftr4+","+ftr5+","+ftr6+","+ftr7+","+ftr8+","+ftr9+","+ftr10+","+ftr11+","+ftr12+","+ftr13+","+ftr14+","+ftr15+","+ftr16+","+ftr17+","+ftr18+","+ftr19+","+ftr20+","+ftr21+","+ftr22+","+ftr23+","+ftr24+","+ftr25+","+ftr26+","+ftr27+","+ftr28+","+ftr29+","+ftr30+","+ftr31+","+ftr32+","+ftr33+","+ftr34+","+ftr35+","+myf1+","+myf2+","+myf3+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"yes"+"\n";
        	// yesnoSen+=myf1+","+myf2+","+myf4+","+caAve+","+cvAve+","+uciAve+","+"yes"+"\n";
        	
             	c++;
        }
//*/
    } 
   
    
 //   FileUtils.writeStringToFile(new File("MyTestData.txt"), yesnoSen);
    FileUtils.writeStringToFile(new File("trainnytweb1refinrmvdelbest.txt"),yesnoSen);
    System.out.println("tedade satrha: "+c);
    
    } 
    
    
    catch (Exception ex) {
        System.out.println(ex.getMessage());
    } 
}
}
