/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparsing;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.*;
import org.codehaus.jackson.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author baishali
 */
public class ReadSimpleJsonFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException
    {
        // TODO code application logic here
        JSONParser parser=new JSONParser();
        try
        {
          Object object=parser.parse(new FileReader("objectArray.json")) ; 
           JSONObject jsonObject=(JSONObject) object;
           String name=(String)jsonObject.get("name"); 
           System.out.println("name is: "+name);
           long age = (long) jsonObject.get("age");
           System.out.println("age is: "+age);
           JSONArray jsonArray=(JSONArray)jsonObject.get("course");
           Iterator<String> iterator=jsonArray.iterator();
           while(iterator.hasNext())
           {
               System.out.println("course :"+iterator.next());
           }
           
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
         catch(IOException e)
        {
            e.printStackTrace();
        }
         catch(ParseException e)
        {
            e.printStackTrace();
        }
        
    }
    
}
