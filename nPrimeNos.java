import java.util.*;

class Prime 
{
	public static boolean isPrime(int N)
	{
		if(N ==1)
		{
			return false;
		}
		if(N ==2)
		{
			return true;
		}
		
		for(int i=2; i*i<=N; i++)
		{
			if(N%i ==0)
			{
				return false;
			}
		}

		return true;
	}


    static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int N = scanner.nextInt();
        
        int x=1;
		while(N>0)
		{
			// System.out.print(x + " ");
			// x++;
			// N--;

			if(isPrime(x))
			{
				System.out.print(x + " ");
				N--;
			}
			x++;
		}
    }
}