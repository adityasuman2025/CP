import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) 
    {
        int lc=0,uc=0,no=0,sc=0;
        int sum=0;
        
        String lowercase = "[a-z]+";
        String uppercase = ".*[A-Z]+.*";
        String num = ".*[0-9]+.*";
        String specialchar = ".*[-!@#$%^&*()+]+.*"; 
        //Regex for pattern matching
        
        if(!(password.matches(lowercase)))
        {
            System.out.println("not match");
            lc++; 
        }
        //if there is no match to a lowercase,"lc" is increased by 1.
    
        if(!(password.matches(uppercase)))
            uc++; 
        //if there is no match to an uppercase,"uc" is increased by 1.
    
        if(!(password.matches(num)))
            no++; 
        //if there is no match to a number,"no" is increased by 1.
    
        if(!(password.matches(specialchar)))
            sc++; 
        //if there is no match to a specialCharacter,"sc" is increased by 1.
        
        
        sum=lc+uc+sc+no;
        
        return (sum>(6-n))?sum:(6-n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(answer);
        // bufferedWriter.write(String.valueOf(answer));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
