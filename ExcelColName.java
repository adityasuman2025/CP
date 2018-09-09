/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class ExcelColName 
{
    static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int T = Integer.parseInt(scanner.nextLine());
        for(int i =0; i<T; i++)
        {
            int no = Integer.parseInt(scanner.nextLine());
            String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            
            long div = no/26;
            long rem = no%26;
            
            String output = new String();
            for(long j=0; j<div; j++)
            {
                output += alpha.charAt(0);
            }
            
            output += alpha.charAt((int)rem-1);
            System.out.println(output);
        }
	}
}