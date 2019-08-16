import java.util.*;
import java.io.*;

/*
Given a matrix of dimension r*c where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell 
1 : Cells have fresh oranges 
2 : Cells have rotten oranges

So, we have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. If it is impossible to rot every orange then simply return -1.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains two integers r and c, where r is the number of rows and c is the number of columns in the array a[]. Next line contains space separated r*c elements each in the array a[].

Output:
Print an integer which denotes the minimum time taken to rot all the oranges (-1 if it is impossible).

Constraints:
1 <= T <= 100
1 <= r <= 100
1 <= c <= 100
0 <= a[i] <= 2

Example:
Input:
2
3 5
2 1 0 2 1 1 0 1 2 1 1 0 0 2 1 
3 5
2 1 0 2 1 0 0 1 2 1 1 0 0 2 1

Output:
2
-1

Explanation:
Testcase 1:
2 | 1 | 0 | 2 | 1
1 | 0 | 1 | 2 | 1
1 | 0 | 0 | 2 | 1

Oranges at positions {0,0}, {0, 3}, {1, 3} and {2, 3} will rot oranges at {0, 1}, {1, 0}, {0, 4}, {1, 2}, {1, 4}, {2, 4} during 1st unit time. And, during 2nd unit time, orange at {1, 0} got rotten and will rot orange at {2, 0}. Hence, total 2 unit of time is required to rot all oranges.
*/

class RottenOranges
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
    {
        int T = Integer.parseInt(bf.readLine());
        for(int t=0; t<T; t++)
        {
            String input[] = (bf.readLine().split(" "));
            String str[] = bf.readLine().split(" ");
            
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            
            int arr[][] = new int[N][M];
            boolean vis[][] = new boolean[N][M];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    arr[i][j] = Integer.parseInt(str[i*M+j]);                   
                    vis[i][j] = false;
                }
            }
            
            int flag = 1;
            int c = 0;
            while(flag == 1)
            {
            //adding all the rotten oranges in queue    
                Queue<Path> q = new LinkedList<>();
                
                int anyRotten = 0;
                int notReachable = 0;
                for(int i=0; i<N; i++)
                {
                    for(int j=0; j<M; j++)
                    {
                        if(arr[i][j] == 2 && vis[i][j] == false)
                        {
                            q.add(new Path(i,j));
                            anyRotten = 1;
                        }
                        else if(arr[i][j] == 1)
                        {
                            //System.out.println(c);
                            notReachable = 1; 
                        }
                    }
                }
                
            //if no any oranges are rotten
                if(anyRotten == 0) 
                {
                    if(notReachable == 1)
                    {
                        c = 0;
                    }
                    flag = 0;
                    break;
                }
                
                while(!q.isEmpty())
                {
                    Path p = q.poll();
                    int i = p.i;
                    int j = p.j;
                    
                    vis[i][j] = true;
                    
                    if(i+1>=0 && j>=0 && i+1<N && j<M && arr[i+1][j]==1)
                    {
                        arr[i+1][j] = 2;//rot than orange
                    }
                    
                    if(i-1>=0 && j>=0 && i-1<N && j<M && arr[i-1][j]==1)
                    {
                        arr[i-1][j] = 2;//rot than orange
                    }
                    
                    if(i>=0 && j+1>=0 && i<N && j+1<M && arr[i][j+1]==1)
                    {
                        arr[i][j+1] = 2;//rot than orange
                    }
                    
                    if(i>=0 && j-1>=0 && i<N && j-1<M && arr[i][j-1]==1)
                    {
                        arr[i][j-1] = 2;//rot than orange
                    }
                }
                
                c++;
            }
            
            System.out.println(c-1);
        }
    }
}

class Path
{
    int i, j;
    
    Path(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}