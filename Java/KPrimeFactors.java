import java.util.*;
import java.io.*;

/*
You are given two integer M and N. You have to find the prime factors of all the numbers in the range[M, N](both inclusive).
Write a program to find the number of times a prime number P comes in the prime factorization of the numbers in the range. Print the answer multiplied by number K.
*/

class KPrimeFactors
{
	static HashMap<Integer, Integer> primeFactor(int num)
	{
		HashMap<Integer, Integer> map = new HashMap<>();	

		while(num%2==0)
		{
			if(map.containsKey(2))
	        {
	            int val = map.get(2);
	            map.put(2, val+1);
	        }
	        else
	        {
	            map.put(2,1);
	        }
			num = num/2;
		}

		for(int i=3; i*i<=num; i+=2)
		{
			while(num%i==0)
			{
				if(map.containsKey(i))
    	        {
    	            int val = map.get(i);
    	            map.put(i, val+1);
    	        }
    	        else
    	        {
    	            map.put(i,1);
    	        }

				num = num/i;
			}
		}

		if(num>2)
			map.put(num,1);

		return map;
	}

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception
	{
			System.out.print("Enter N & M: ");
			String input[] = bf.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			System.out.print("Enter P: ");
			int P = Integer.parseInt(bf.readLine());
			System.out.println();

			int c = 0;
			for(int i=N; i<=M; i++)
			{
				HashMap<Integer, Integer> map = primeFactor(i);
				System.out.println("Number is: " + i + "\n" + map);

				if(map.containsKey(P))
				{
					int val = map.get(P);
					c+=val;
				}
			}
			System.out.println(c);
	}
}