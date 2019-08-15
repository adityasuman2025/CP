import java.util.*;

class isNumberFibonacci
{
	static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());

	    String ans = "no";   
	    if(isFibonacci(T))
        {
            ans = "yes";   
        }
        
        System.out.println(ans);	    
	}
	
	public static boolean isFibonacci(int n)
	{
	    return isPerfectSquare((5*n*n) + 4) || isPerfectSquare((5*n*n) - 4);
	}
	
	public static boolean isPerfectSquare(int n)
	{
	    int sqr_root = (int)Math.sqrt(n);
	    
	    return (sqr_root*sqr_root == n);
	}
}