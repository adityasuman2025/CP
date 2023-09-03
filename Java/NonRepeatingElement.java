import java.util.*;
import java.io.*;

public class NonRepeatingElement
{
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        String str[] = bf.readLine().split(" ");
	        
	        int sum = 0;
	        for(int i=0; i<N; i++)
	        {
	            sum = Integer.parseInt(str[i])^sum;
            }
            System.out.println(sum);
	    }
	}
}