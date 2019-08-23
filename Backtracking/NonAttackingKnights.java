import java.util.*;
import java.lang.*;
import java.io.*;

/*
How many ways are there to place a black and a white knight on an N * M chessboard such that they do not attack each other? The knights have to be placed on different squares. A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically and one square horizontally (L shaped). The knights attack each other if one can reach the other in one move.

Input:
The first line contains the number of test cases T. Each of the next T lines contains two integers N and M which is size of matrix.

Output:
For each testcase, print the required answer, i.e, number of possible ways to place knights.

Constraints:
1 <= T <= 100
1 <= N, M <= 105

Example:
Input:
3 
2 2 
2 3 
4 5

Output:
12 
26 
312

Explanation:
Testcase 1: We can place a black and a white knight  in 12 possible ways such that none of them attracts each other.
*/

class NonAttackingKnights
{   
    static int row[] = {1,1,2,2,-1,-1,-2,-2};
    static int coloumn[] = {2,-2,1,-1,2,-2,1,-1};
    
    static int moves(int n,int m)
    {
        int count=0;
        int total=n*m;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int moves=1;
                for(int k=0;k<8;k++)
                {
                    int r=i+row[k];
                    int c=j+coloumn[k];
                    
                    if(r>=0 && c>=0 && r<n && c<m )
                        moves++;
                }
                
                count+=(total-moves);
            }
        }
        
        return count;
    }
    
    public static void main (String[] args) throws IOException
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        
        while (t-- > 0) 
        { 
            int n=s.nextInt();
            int m=s.nextInt();
            
            System.out.println(moves(n,m)); 
        }
    }
}