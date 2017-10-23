/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regexproject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author baishali
 */
public class DifferentRegexPattern 
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter input:");
        int i=scan.nextInt();
        switch(i)
        {
            case 1:
                System.out.println("Enter street address :  ");
                //String address=scan.nextLine();
                String address="123 abc";
                String pattern1="(\\d*[a-zA-Z\\s]+)";
                Pattern p1=Pattern.compile(pattern1 , Pattern.MULTILINE);
                Matcher matcher=p1.matcher(address);
                //boolean output=matcher.matches();
                //System.out.println("Return True if matches:  "+output);
                while (matcher.find())
                {
                System.out.println("Full match: " + matcher.group(0));
                for (int a = 1; a <= matcher.groupCount(); a++) {
                System.out.println("Group " + a + ": " + matcher.group(a));
                }
                }    
                break;
            case 2:
                System.out.println("different age ");
                scan.nextLine();
                String age=scan.next();
                //String age="345";
                String pattern2="(([1-9]\\d?)|(1[0-2]\\d))";
                Pattern p2=Pattern.compile(pattern2);
                Matcher matcher2=p2.matcher(age);
                //while(matcher2.find())
                //{
                  //  System.out.println("full match : "+matcher2.group());
                //}
                boolean output=matcher2.matches();
                System.out.println("Return true if matches ages:"+output+" "+matcher2.group());
                break;
            case 3:
                System.out.println(" Indian zip code ");
                scan.nextLine();
                System.out.println("Enter the zip code : ");
                String zip=scan.next();
                String pattern3="([1-9]\\d{2}[ -]?\\d{3})";
                Pattern p3=Pattern.compile(pattern3);
                Matcher matcher3=p3.matcher(zip);
                boolean output3=matcher3.matches();
                System.out.println("Return true if matches zipcode : "+output3+" "+matcher3.group());
                break;
            case 4:
                System.out.println("USA zip code ");
                scan.nextLine();
                System.out.println("Enter zip code : ");
                String usaZip=scan.next();
                String pattern4="[1-9](\\d?\\d{3,4})[ -]?(\\d{4})?";
                Pattern p4=Pattern.compile(pattern4);
                Matcher matcher4=p4.matcher(usaZip);
                boolean output4=matcher4.matches();
                System.out.println("Return true if matches zipcode : "+output4);
                break;
            case 5:
                 System.out.println("Email verification ");
                 scan.nextLine();
                 System.out.println("Enter an Email-id: ");
                 String email=scan.next();
                 String pattern5="[_A-Za-z0-9-\\.+]+@[A-Za-z0-9]+[\\.a-zA-Z]+?(\\.[A-Za-z]{2,})$";
                 Pattern p5=Pattern.compile(pattern5);
                 Matcher matcher5=p5.matcher(email);
                 boolean output5=matcher5.matches();
                 System.out.println("Return true for valid Email-id : "+output5+"  "+email);
                 break;
                 
            case 6:
                System.out.println("Telephone number verification ");
                scan.nextLine();
                System.out.println("Enter phone number: ");
                String phone=scan.nextLine();
                String pattern6="(\\d?\\d{2}[- ])?[1-9]\\d{3}[ -]?\\d{4}";
                Pattern p6=Pattern.compile(pattern6);
                Matcher matcher6=p6.matcher(phone);
                boolean output6=matcher6.matches();
                System.out.println("Return true for valid Email-id : "+output6+"  "+phone);
                break;
                
            case 7:
                System.out.println("Phone number verification ");
                scan.nextLine();
                System.out.println("enter mobile number: ");
                String mobile=scan.next();
                String pattern7="(\\+?\\d{1,2}[ -]?)?\\d{10}";
                Pattern p7=Pattern.compile(pattern7);
                Matcher matcher7=p7.matcher(mobile);
                boolean output7=matcher7.matches();
                System.out.println("Return true for valid Email-id : "+output7+"  "+mobile);
                break;
                
                
        
    }
}
}