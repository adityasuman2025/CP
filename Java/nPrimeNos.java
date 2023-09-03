import java.util.*;

class Prime 
{
	static boolean isPrime(int n)
    {
        if(n<=1)
            return false;
        if(n <=3)
            return true;
            
        if(n%2 == 0 || n%3 == 0)
            return false;
            
        for(int i=5; i*i<=n; i+=6)
        {
            if(n%i == 0 || n%(i+2) == 0)
                return false;
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
			if(isPrime(x))
			{
				System.out.print(x + " ");
				N--;
			}
			x++;
		}
    }
}