import java.util.*;
import java.io.*;
/*
Number of paths in a matrix with k coins
Given a N x N matrix where every cell has some number of coins. Count number of ways to reach bottom right cell of matrix from top left cell with exactly K coins. We can move to (i+1, j) or (i, j+1) from a cell (i, j).

Input:
First line contains number of test cases T. For each test case, first line contains the integer value 'X' denoting coins, second line contains an integer 'N' denoting the order of square matrix. Last line contains N x N elements in a single line in row-major order.

Output:
Output the number of paths possible.

Constraints:
1 <=T<= 500
1 <= K <= 200
1 <= N <= 200
1 <= Ai <= 200

Example:
Input:
2
16
3
1 2 3 4 6 5 9 8 7
12
3
1 2 3 4 6 5 3 2 1

Output:
0
2

Explanation:
Testcase 2: There are 2 possible paths with exactly K coins, which are (1 + 4 + 3 + 2 + 1) and (1 + 2 + 6 + 2 + 1).
*/

class PathInMatrixWithKCoins
{
    static int c = 0;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int a=0; a<T; a++)
	    {
	        int K = Integer.parseInt(bf.readLine().trim());
	        
	        int N = Integer.parseInt(bf.readLine().trim());
	        String str[] = bf.readLine().split(" ");
	        
            c = 0;
            int sum = 0;
            
            solve(str, N, 0, 0, sum, K);
            System.out.println(c);
	    }
	}
	
	static void solve(String arr[], int N, int i, int j, int sum, int K)
	{
	    sum = sum+ Integer.parseInt(arr[i*N+j]);
	    if(sum>K)
	        return;
	        
	    if(i==N-1 && j==N-1 && sum==K)
        {
            c++;
            return;
        }
        
        if(i+1<N && j<N)
            solve(arr, N, i+1, j, sum, K);
        
        if(i<N && j+1<N)
            solve(arr, N, i, j+1, sum, K);
	}
}