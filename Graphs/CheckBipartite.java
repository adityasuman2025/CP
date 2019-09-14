/*
https://www.geeksforgeeks.org/bipartite-graph/

Bipartite Graph
Given an adjacency matrix representation of a graph g having 0 based index your task is to complete the function isBipartite which returns true if the graph is a bipartite graph else returns false.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer v denoting the no of vertices of the graph then in the next line are v*v space separated values of the adjacency matrix representation of the graph g.

Output:
For each test case in a new line output will be 1 if the graph is bipartite else 0.

Constraints:
1<=T<=100
1<=v<=15
0<=g[][]<=1

Example(To be used only for expected output):
Input:
2
4
0 1 0 1 1 0 1 0 0 1 0 1 1 0 1 0
3
0 1 0 0 0 1 1 0 0
Output:
1
0
*/

class CheckBipartite
{
    boolean isBipartite(int G[][], int V)
    {
        int colorArr[] = new int[V]; 
        Arrays.fill(colorArr, -1);
        
        colorArr[0] = 1; //1: color 1, 0: color 2
        
        for(int i=0;i<V;i++) //in case if graph is not connected
        {
            Queue<Integer>q = new LinkedList<>(); 
            q.add(i); 
            
            while(!q.isEmpty())
            {
                int u = q.poll();
                
                if(G[u][u] == 1) //if graph has self loop
                    return false;
                    
                for(int v=0; v<V; ++v) 
                { 
                    if(G[u][v]==1 && colorArr[v]==-1) 
                    { 
                        colorArr[v] = 1-colorArr[u]; 
                        q.add(v); 
                    } 
                    else if(G[u][v]==1 && colorArr[v]==colorArr[u])  //u & v are of same color meaning both nodes are in same set //i.e  they do not belong to different set
                        return false; 
                } 
            }
        }
        
        return true;
    }
}