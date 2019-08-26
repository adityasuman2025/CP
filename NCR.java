class NCR 
{ 	  
	static int comb(int n , int r)
	{
		if( r== 0 || n == r)
			return 1;
		
		return comb(n-1,r)+comb(n-1,r-1);
	}

	// Driver code 
	public static void main(String[] args) 
	{ 
	    int n = 23, r = 2; 
	    System.out.println(comb(n, r)); 
	} 
} 