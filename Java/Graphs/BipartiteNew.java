import java.util.*;
import java.io.*;

class BipartiteNew
{
	static boolean isBipartite(int graph[][], int V)
	{
		int color[] = new int[];
		Arrays.fill(color, -1);
		color[0] = 1;
		//1: Red
		//0: Green

		for(int i=0; i<V; i++)
		{
			Queue<Integer> q = new LinkedList<>();
			q.add(i);

			while(!q.isEmpty())
			{
				int u = q.poll();

				if(graph[u][u] == 1)
					return false;

				for(int v = 0; v<V; v++)
				{
					if(graph[u][v] == 1 && color[v] == -1)
					{
						color[v] = 1-color[u];
						q.add(v);
					}
					else if(graph[u][v] == 1 && color[v] == color[u])
						return false;
				}
			}
		}

		return true;
	}
}