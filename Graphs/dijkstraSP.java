import java.util.*;

public class dijkstraSP
{
	public static int findMinDistVert(int dist[], boolean visited[])
	{
		int V = dist.length;

		int min = Integer.MAX_VALUE;
		int minDistVert = -1;

		for(int i=0; i<V; i++)
		{
			if(!visited[i] && dist[i] <=min)
			{
				min = dist[i];
				minDistVert = i;
			}
		}

		return minDistVert;
	}

	static void dijkstra(int adjMat[][], int src)
	{
		int V = adjMat.length;

	//to keep record wether that vertex has been covered or not
		boolean visited[] = new boolean[V];

	//to track distance of each vertex from a source	
	//we initially set distnace of each vertex as infinity except for the source vertex
		int dist[] = new int[V];
		for(int i=0; i<V; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		dist[src] = 0;

	//To find shortest path for all vertices 
		for(int i=0; i<V; i++)
		{
		// Pick the minimum distance vertex from the set of vertices 
        // not yet processed. u is always equal to src in first 
        // iteration. 
			int minDistVert = findMinDistVert(dist, visited);
			System.out.println("minimum distance vertex choosed is: " + minDistVert);

		// Mark that picked vertex as processed
			visited[minDistVert] = true;

		//update the distance value of the adjacent vertices of the picked vertex
			for(int v=0; v<V; v++)
			{
			// Update dist[v] only if is not in visited, there is an 
            // edge from u to v, and total weight of path from src to 
            // v through u is smaller than current value of dist[v] 
				if(!visited[v] && adjMat[minDistVert][v] != 0 && dist[minDistVert] != Integer.MAX_VALUE)
				{
					int newDist = dist[minDistVert] + adjMat[minDistVert][v];

					if(newDist < dist[v])
					{
						dist[v] = newDist;
					}
				}
			}
		}

	//printing the distance matrix
		System.out.println(Arrays.toString(dist));
	}	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int adjMat[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                          {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                          {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                          {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                          {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                          {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                          {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                          {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                          {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                         }; 

		int src = 0;                        
		dijkstra(adjMat, src);
	}
}