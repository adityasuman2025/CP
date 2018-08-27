import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution10 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        //in binary
        String binary_string = Integer.toBinaryString(n);

        String parts[] = binary_string.split("0");
        int parts_length[] = new int[parts.length];

        for(int i=0; i<parts.length; i++)
        {
        	parts_length[i] = String.valueOf(parts[i]).length();
        }

        int max = parts_length[0];
        for(int k=0; k<parts_length.length; k++)
        {
        	if(parts_length[k] > max)
        	{
        		max = parts_length[k];
        	}
        }

        System.out.println(max);
    }
}
