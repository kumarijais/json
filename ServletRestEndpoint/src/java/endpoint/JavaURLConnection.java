package endpoint;


import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author baishali
 */
public class JavaURLConnection 
{ 
    
public String getDateAndTime(String TimeZone,long Unix) throws IOException, ParseException
    //public static void main(String[] args) throws ParseException
{
    //String datetime;
  
        JSONParser parser=new JSONParser();
        URL url=new URL("http://api.timezonedb.com/v2/get-time-zone?key=J6JSH6WSTWMX&format=json&by=zone&zone="+TimeZone+"&time="+Unix);
        //URL url=new URL("http://api.timezonedb.com/v2/get-time-zone?key=J6JSH6WSTWMX&format=json&by=zone&zone=Asia/Taipei&time=1451001055");
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Accept","application/json");
        if(conn.getResponseCode()!=200)
        {
            throw new RuntimeException("failed :http error code:"+conn.getResponseCode());
        }
        Scanner Input=new Scanner(conn.getInputStream());
        //String output;
        System.out.println("output from server");
        Object object=parser.parse(Input.nextLine()) ; 
           JSONObject jsonObject=(JSONObject) object;
           String datetime=(String)jsonObject.get("formatted"); 
           //System.out.println("bxgax"+datetime);
           //conn.disconnect();
        return datetime;
    
   
   
    
}
}
