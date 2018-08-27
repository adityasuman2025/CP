import java.io.*;
import java.util.*;

public class Solution6 {

    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String S[] = new String[T];
        
        for(int i=0; i<T; i++)
        { 
            S[i] = scanner.next();
        }

        for(int i=0; i<T; i++)
        {
            char string_into_char[] = S[i].toCharArray();

         // printing even indices
            for(int k =0; k<string_into_char.length; k++)
            {
                if(k % 2 == 0) // printing even indices
                {
                    System.out.print(string_into_char[k]);
                }
            }

        //to spaces in between even indices and odd indices
            System.out.print(" ");

        // printing odd indices
            for(int k =0; k<string_into_char.length; k++)
            {
                if(k % 2 != 0) // printing odd indices
                {
                    System.out.print(string_into_char[k]);
                }
            }

            System.out.println("");
        }
    }
}