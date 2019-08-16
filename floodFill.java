import java.util.*;
import java.io.*;
class floodFill
{
    static int N=0;
	static int M=0;
	    
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        String inp[] = bf.readLine().split(" ");
	        N = Integer.parseInt(inp[0]);
	        M = Integer.parseInt(inp[1]);
	        
	        String str[] = bf.readLine().split(" ");
	        
	        String inp2[] = bf.readLine().split(" ");
	        int X = Integer.parseInt(inp2[0]);
	        int Y = Integer.parseInt(inp2[1]);
	        int K = Integer.parseInt(inp2[2]);
	        
	        int arr[][] = new int[N][M];
	        for(int i=0; i<N; i++)
	        {
	            for(int j=0; j<M; j++)
	                arr[i][j] = Integer.parseInt(str[i*M+j]);
            }
            
            try
            {
                FloodFill(arr, X, Y, K);
            }
            catch (Exception e)
            {}
            
            for(int i=0; i<N; i++)
	        {
	            for(int j=0; j<M; j++)
	                System.out.print(arr[i][j] + " ");
            
	            System.out.println();
	        }
            //System.out.println(N + " " + M);
	    }
	}
	
	static void FloodFill(int arr[][], int X, int Y, int newCol)
	{
	    int oldCol = arr[X][Y];
	    
	    FloodFillRec(arr, X, Y, oldCol, newCol);
	}
	
	static void FloodFillRec(int arr[][], int X, int Y, int oldCol, int newCol)
	{
	    System.out.println(X + " " + Y);
	        
	    if(X<0 || X>=N || Y<0 || Y>=M)
	    {
    	    return;
	    }
	    else if(arr[X][Y] != oldCol)
	    {
	     	return;	        
	    }
	   	
	   	arr[X][Y] = newCol;  	               
        
        FloodFillRec(arr, X+1, Y, oldCol, newCol); 
        FloodFillRec(arr, X-1, Y, oldCol, newCol); 
        FloodFillRec(arr, X, Y+1, oldCol, newCol); 
        FloodFillRec(arr, X, Y-1, oldCol, newCol); 
	}
}