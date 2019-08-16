import java.util.*;
import java.io.*;

/*
Given a N X N matrix (M) filled with 1, 0, 2, 3. The task is to find whether there is a path possible from source to destination, while traversing through blank cells only. You can traverse up, down, right and left.

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Blank Wall.
Note: there is only single source and single destination.

 

Input:
The first line of input is an integer T denoting the no of testcases. Then T test cases follow. Each test case consists of 2 lines. The first line of each test case contains an integer N denoting the size of the square matrix. Then in the next line are N*N space separated values of the matrix (M).

Output:
For each test case in a new line print 1 if the path exist from source to destination else print 0.

Constraints:
1 <= T <= 20
1 <= N <= 20

Example:
Input:
2
4
3 0 0 0 0 3 3 0 0 1 0 3 0 2 3 3 
3
0 3 2 3 0 0 1 0 0

Output:
1
0

Explanation:
Testcase 1: The matrix for the above given input is:
3 0 0 0
0 3 3 0
0 1 0 3
0 2 3 3
From the matrix we can see that there exists a path from to reach destination 2 from source 1.
*/

class ifPathExist
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine());
	        String str[] = bf.readLine().split(" ");
	        
	        //source index
	        int i = 0;
	        int j = 0;
	        
	        //array
	        int arr[][] = new int[N][N];
	        boolean vis[][] = new boolean[N][N];
	        for(int a=0; a<N; a++)
	        {
	            for(int b=0; b<N; b++)
	            {
	                arr[a][b] = Integer.parseInt(str[a*N+b]);
	                vis[a][b] = false;
	                
	                if(arr[a][b] == 1)
	                {
	                    i = a;
	                    j = b;
	                }
	            }
            }
            
            int ans = checkPath(arr, vis, N, i, j);
            System.out.println(ans);
	    }
	}
	
	static int checkPath(int arr[][], boolean vis[][], int N, int x, int y)
	{
	    int ans = 0;
	    
	    Queue<Path> q = new LinkedList<>();
	    q.add(new Path(x,y));
	    
	    while(!q.isEmpty())
	    {
	        Path p = q.poll();
	        int i = p.i;
	        int j = p.j;
	        
	        vis[i][j] = true;
	        
        //checking neighbours
	        if(i+1>=0 && j>=0 && i+1<N && j<N && arr[i+1][j]>1 && !vis[i+1][j])
	        {
	            if(arr[i+1][j] == 2)
	            {
	                ans = 1;
	                break;
	            }
	            q.add(new Path(i+1, j));
	        }
	        
	        if(i>=0 && j+1>=0 && i<N && j+1<N && arr[i][j+1]>1 && !vis[i][j+1])
	        {
	            if(arr[i][j+1] == 2)
	            {
	                ans = 1;
	                break;
	            }
	            q.add(new Path(i, j+1));
	        }
	        
	        if(i-1>=0 && j>=0 && i-1<N && j<N && arr[i-1][j]>1 && !vis[i-1][j])
	        {
	            if(arr[i-1][j] == 2)
	            {
	                ans = 1;
	                break;
	            }
	            q.add(new Path(i-1, j));
	        }
	        
	        if(i>=0 && j-1>=0 && i<N && j-1<N && arr[i][j-1]>1 && !vis[i][j-1])
	        {
	            if(arr[i][j-1] == 2)
	            {
	                ans = 1;
	                break;
	            }
	            q.add(new Path(i, j-1));
	        }
	    }
	    
	    return ans;
	}
}

class Path
{
    int i;
    int j;
    
    Path(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}