import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution28 
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String desired_name[] = new String[N];

        for (int NItr = 0; NItr < N; NItr++) 
        {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            String email_provider1[] = emailID.split("@|\\.");

            if(email_provider1.length >3)
            {
                if(email_provider1[2].equals("gmail"))
                {
                    //System.out.println("gud");           
                    desired_name[NItr] = firstName;              
                }      
                else
                {
                    desired_name[NItr] = "#";   
                }  
            }
            else
            {
                if(email_provider1[1].equals("gmail"))
                {
                    //System.out.println("gud");           
                    desired_name[NItr] = firstName;              
                }      
                else
                {
                    desired_name[NItr] = "#";   
                }  
            }             
        }

        Arrays.sort(desired_name);
       
        for(String e:desired_name)
        {
            if(e !="#")
            {
                System.out.println(e);
            }
         
        }

        scanner.close();
    }
}
