
package regexproject;
import java.util.Scanner;
import java.util.regex.*;
/**
 *
 * @author baishali
 */
public class SingleStringMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the numberical values :");
        int i=scan.nextInt();
        switch(i)
        {
            case 1:
                String content1="this book is for programming";
                String pattern1=".*books.*";
                boolean isMatch = Pattern.matches(pattern1, content1);
                System.out.println("Given string==book is :"+isMatch);
                break;
            case 2:
                System.out.println("return true if string matches exactly baishu:");
                System.out.println(Pattern.matches("[bB]aishu|[jJ]jaiswal", "Baishu"));
                System.out.println("return false if it not matches eaxcatly baishu:");
                System.out.println(Pattern.matches("[nN]", "baishu"));
                System.out.println("it will check weather it has jaiswal or baishu "+Pattern.matches("[bB]aishu.*|[jJ]aiswal.*", "jaiswal has baishu"));
                System.out.println("It will return false it is not matching exactly:  "+Pattern.matches("[bB]aishu|[jJ]jaiswal", "singlevalue"));
                break;
            case 3:
                System.out.println("Use of negate function: ");
                System.out.println("It will return true if the starting point is not a digit : "+Pattern.matches("^[^\\d].*", "abcd1234"));
                System.out.println("It will return false if the starting point is a digit  : "+Pattern.matches("^[^\\d].*", "1232abcd"));
                break;
            case 4:
                System.out.println("Matches exact three letters. ");
                System.out.println("Return true if matches : "+Pattern.matches("[a-zA-Z][a-zA-Z][a-zA-Z]", "aVz"));
                break;
            case 5:
                System.out.println("True if all are not digit : "+Pattern.matches("\\D*", "abcdhvs"));
                System.out.println("false if all are  digit : "+Pattern.matches("\\D*", "123abcdhvs"));
                break;
            case 6:
                System.out.println("return true is matches string : "+Pattern.matches("^good$", "good"));
                System.out.println("false : "+Pattern.matches("^good$", "she is a good girl"));
                break;
                
        }
    }
    
}
