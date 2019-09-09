import java.util.*;
import java.lang.*;
import java.io.*;

class squareInSquare
{
	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int T = Integer.parseInt(scanner.nextLine());		
		for(int i=0; i<T; i++)
		{
		    int N = Integer.parseInt(scanner.nextLine());
		    
            int ans = 0;
	        for(int i=N; i>=1; i--)
	        {
	            ans += (i*i);
	        }
	        System.out.println(ans);
		}	    
	}
}