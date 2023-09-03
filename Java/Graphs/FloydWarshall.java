import java.util.*;
import java.io.*;

/*
Floyd Warshall
The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph. The Graph is represented as Adjancency Matrix, and the Matrix denotes the weight of the edegs (if it exists) else INF (1e7).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains an integer V denoting the size of the adjacency matrix. The next V lines contain V space separated values of the matrix (graph). All input will be integer type.

Output:
For each test case output will be V*V space separated integers where the i-jth integer denote the shortest distance of ith vertex from jth vertex. For INT_MAX integers output INF.

Constraints:
1 <= T <= 20 
1 <= V <= 100
1 <= graph[][] <= 500

Example:
Input
2
2
0 25
INF 0
3
0 1 43
1 0 6
INF INF 0

Output
0 25
INF 0 
0 1 7
1 0 6
INF INF 0 
*/

class FloydWarshall
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        
	        int graph[][] = new int[N][N];
	        for(int i=0; i<N; i++)
	        {
	            String str[] = bf.readLine().split(" ");
	            for(int j=0; j<N; j++)
                    graph[i][j] = Integer.parseInt(str[j]);
            }
            
	        int V=N;
	        int dist[][] = new int[V][V]; 
            int i, j, k; 
  
            for (i = 0; i < V; i++) 
                for (j = 0; j < V; j++) 
                    dist[i][j] = graph[i][j]; 
                    
            for (k = 0; k < V; k++) 
            { 
                for (i = 0; i < V; i++) 
                { 
                    for (j = 0; j < V; j++) 
                    { 
                        if (dist[i][k] + dist[k][j] < dist[i][j]) 
                            dist[i][j] = dist[i][k] + dist[k][j]; 
                    } 
                } 
            } 
            
            for (int x=0; x<V; ++x) 
            { 
                for (int y=0; y<V; ++y) 
                { 
                    if (dist[x][y]==10000000) 
                        System.out.print("INF "); 
                    else
                        System.out.print(dist[x][y] + " "); 
                } 
                System.out.println(); 
            } 
	    }
	}
}