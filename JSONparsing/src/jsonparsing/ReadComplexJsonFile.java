/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.util.Collections.list;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author baishali
 */
public class ReadComplexJsonFile 
{
    public static void main(String[] args) throws IOException, ParseException
    {
        JSONParser parser=new JSONParser();
        List<ReadComplexJsonPojo> addlist=new ArrayList<ReadComplexJsonPojo>();
        try
        {
          Object object=parser.parse(new FileReader("myJson.json")) ;
          
           JSONArray jsonArray=(JSONArray) object;
           Iterator iterator=jsonArray.iterator();
           while(iterator.hasNext())
           {
               JSONObject jsonObject=(JSONObject)iterator.next();
               ReadComplexJsonPojo pojo=new ReadComplexJsonPojo();
               String name=(String)jsonObject.get("name");
               String course=(String)jsonObject.get("course");
               int salary=(int)((long)jsonObject.get("salary"));
               int age=(int)((long)jsonObject.get("age"));
               pojo.setName(name);
               pojo.setCourse(course);
               pojo.setSalary(salary);
               pojo.setAge(age);
               addlist.add(pojo);
               //System.out.println("course :"+iterator.next());
           }
           for(ReadComplexJsonPojo rcjp:addlist)
           {
               System.out.println("name : "+rcjp.getName()+"  "+"course : "+rcjp.getCourse()+"  "+"salary : "+rcjp.getSalary()+"  "+"age : "+rcjp.getAge());
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
