
package csvtojson;

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
import org.json.simple.*;
public class CsvTojson {

    private static String fileName="SalesJan2009.csv";
            private static String[] values;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File file=new File(fileName);
        
		Scanner take_input=new Scanner(file);
                take_input.nextLine();
                JSONArray Alist = new JSONArray();
                JSONObject json = new JSONObject();
                 //CsvReader products = new CsvReader("SalesJan2009.csv");
		
                //Transaction_date,Product,Price,Payment_Type,Name,City,State,Country,Account_Created,Last_Login,Latitude,Longitude
                
                 try(FileWriter fWrite=new FileWriter("myJson.json"))
                     
                    {
                        while(take_input.hasNextLine())
                            {
                                String data=take_input.nextLine();
                                    values=data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                        for (int i = 0; i < values.length; i++)
                            {
                                if (values[i].contains("\"")) 
                                    {
                                        values[i] = values[i].replaceAll("^\"|\"$", "");
                                        values[i] = values[i].replaceAll(",","");

                                    }
                            }
                        //System.out.println(values[2]);
                            json.put("Transaction_date", values[0]);
                            json.put("Product", values[1]);
                            json.put("Price", new Integer(values[2]));
                            json.put("Payment_Type", values[3]);
                            json.put("Name", values[4]);
                            json.put("City", values[5]);
                            json.put("State", values[6]);
                            json.put("Country", values[7]);
                            json.put("Account_Created", values[8]);
                            json.put("Last_login", values[9]);
                            json.put("Latitude", new Double(values[10]));
                            json.put("Longitude", new Double(values[11]));
                            

                            Alist.add(json);
                            
                            }
       
                        fWrite.write(Alist.toJSONString());
                        fWrite.flush();
                    }
                 System.out.println(json.toJSONString());
                
    }
                
}
    
