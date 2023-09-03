import java.io.*;
import java.util.*;

class BitDifference
{
	static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int a=0; a<T; a++)
	    {
	        int n = scanner.nextInt();
	        
	        int arr[]= new int[n];
            for(int x=0; x<n; x++)
            { 
                arr[x]=scanner.nextInt();
            }   
            
        //calculating the sum of bit difference of possible pairs of integers from the given array
            int sum = 0;
            for(int i=0; i<n; i++)
            {
                for(int j=i+1; j<n; j++)
                {
                    sum += Integer.bitCount(arr[i] ^ arr[j]);
                }
            }
            
            System.out.println(2*sum); //multiplying by 2 becoz alternate pair of integers is also possible
	    }
	}
}