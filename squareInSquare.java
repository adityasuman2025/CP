import java.util.*;
import java.lang.*;
import java.io.*;

class squareInSquare
 {
    static int calc(int n)
    {
        if(n==1)
        {
            return 1;
        }
        
        return n*n + calc(n-1);
    }
    
	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int T = Integer.parseInt(scanner.nextLine());
		
		for(int i=0; i<T; i++)
		{
		    int n = Integer.parseInt(scanner.nextLine());
		    
            int res = calc(n); 
            
            System.out.println(res);
		}
	    
	 }
}