import java.util.*;
import java.io.*;

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