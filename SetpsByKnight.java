import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/steps-by-knight/0

Steps by Knight
Given a square chessboard of N x N size, the position of Knight and position of a target is given. We need to find out minimum steps a Knight will take to reach the target position.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the square chessboard. The next line contains the X-Y coordinates of the knight. The next line contains the X-Y coordinates of the target. 

Output:
Print the minimum steps the Knight will take to reach the target position.

Constraints:
1<=T<=100
1<=N<=20
1<=knight_pos,targer_pos<=N

Example:
Input:
2
6
4 5
1 1
20
5 7
15 20

Output:
3
9
*/

class Coord
{
    int X, Y;
    int dist;
    Coord(int X, int Y, int dist)
    {
        this.X = X;
        this.Y = Y;
        this.dist = dist;
    }
}
	
class SetpsByKnight
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        
	        String str1[] = bf.readLine().split(" ");
	        int KX = Integer.parseInt(str1[0])-1;
	        int KY = Integer.parseInt(str1[1])-1;
	        
	        String str2[] = bf.readLine().split(" ");
	        int TX = Integer.parseInt(str2[0])-1;
	        int TY = Integer.parseInt(str2[1])-1;
	        
	        int step = solve(N, KX, KY, TX, TY);
	        System.out.println(step);
	    }
	}
	
	static int solve(int N, int kX, int kY, int TX, int TY)
	{
	    boolean visited[][] = new boolean[N][N];
	    
	    Queue<Coord> q = new LinkedList<>();
	    Coord cord = new Coord(kX, kY, 0);
	    q.add(cord);
	        
	    int step = 0;
	    while(!q.isEmpty())
	    {
	        Coord c = q.poll();
	        int KX = c.X;
	        int KY = c.Y;
	        visited[KX][KY] = true;
	        
	        if(KX==TX && KY==TY)
	            return c.dist;
	            
	        if(KX+2<N && KY+1<N && !visited[KX+2][KY+1])
    	    {
    	        Coord t = new Coord(KX+2, KY+1, c.dist+1);
                q.add(t);
                if(KX+2==TX && KY+1==TY)
                    return c.dist+1;
    	    }
    	    
    	    if(KX+2<N && KY-1>=0 && !visited[KX+2][KY-1])
    	    {
    	        Coord t = new Coord(KX+2, KY-1, c.dist+1);
                q.add(t);
                if(KX+2==TX && KY-1==TY)
                    return c.dist+1;
    	    }
    	    
    	    if(KX-2>=0 && KY+1<N && !visited[KX-2][KY+1])
    	    {
    	        Coord t = new Coord(KX-2, KY+1, c.dist+1);
                q.add(t);
                if(KX-2==TX && KY+1==TY)
                    return c.dist+1;
    	    }
    	    
    	    if(KX-2>=0 && KY-1>=0 && !visited[KX-2][KY-1])
    	    {
    	        Coord t = new Coord(KX-2, KY-1, c.dist+1);
                q.add(t);
                if(KX-2==TX && KY+-1==TY)
                    return c.dist+1;
    	    }
    	    
    	    if(KY+2<N && KX+1<N && !visited[KX+1][KY+2])
    	    {
    	        Coord t = new Coord(KX+1, KY+2, c.dist+1);
                q.add(t);
                if(KX+1==TX && KY+2==TY)
                    return c.dist+1;
    	    }
    	    
    	    if(KY+2<N && KX-1>=0 && !visited[KX-1][KY+2])
    	    {
    	        Coord t = new Coord(KX-1, KY+2, c.dist+1);
                q.add(t);
                if(KX-1==TX && KY+2==TY)
                    return c.dist+1;
    	    }
    	    
    	    if(KY-2>=0 && KX+1<N && !visited[KX+1][KY-2])
    	    {
    	        Coord t = new Coord(KX+1, KY-2, c.dist+1);
                q.add(t);
                if(KX+1==TX && KY-2==TY)
                    return c.dist+1;
    	    }
    	    
    	    if(KY-2>=0 && KX-1>=0 && !visited[KX-1][KY-2])
    	    {
    	        Coord t = new Coord(KX-1, KY-2, c.dist+1);
                q.add(t);
                if(KX-1==TX && KY-2==TY)
                    return c.dist+1;
    	    }
	    }
	    
	    return -1;
	}
}