/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonobject;
import java.io.*;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
/**
 *
 * @author baishali
 */
public class JsonObject1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        JSONObject obj=new JSONObject();    
  obj.put("name","sonoo");    
  obj.put("age",new Integer(27));    
  obj.put("salary",new Double(600000));    
   JSONArray list=new JSONArray();
   list.add("jsp");
   list.add("java");
   obj.put("course", list);
   System.out.println(obj);
   try(FileWriter file=new FileWriter("myJson.json"))
   {
        file.write(obj.toJSONString());
        file.flush();
    }
}
}
