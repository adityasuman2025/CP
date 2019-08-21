class CatalanNumber
{
	public static void main(String[] args) 
    {
        System.out.println(catlan(4));    
    }
    
    static int catlan(int n)
    {
        if(n<=1)
            return 1;
        
        int res = 0;
        
        for(int i=0; i<n; i++)
        {
            res += catlan(i)* catlan(n-i-1);
        }
        
        return res; 
    }
}