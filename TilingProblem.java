import java.util.*;

public class TilingProblem 
{
	static int ways(int n)
	{
		if(n ==1)
			return 1;
		if(n==2)
			return 2;

		return ways(n-2) + ways(n-1);
	}

	public static void main(String[] args) {
		int ans = ways(10);

		System.out.println(ans);
	}	
}