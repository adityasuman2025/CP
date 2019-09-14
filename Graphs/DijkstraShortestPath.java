class DijkstraShortestPath
{
	static int minDistVertex(int dist[], int visited[])
	{
		int V = dist.length;

		int minDistVertex = -1;
		int minDist = Integer.MAX_VALUE;

		for(int i=0; i<V; i++)
		{
			if(!visited[i] && dist[i]<=minDist)
			{
				minDist = dist[i];
				minDistVertex = i;
			}
		}

		return minDistVertex;
	}

	static void dijkstra(int graph[][], int V, int src)
	{
		int dist[] = new int[V];
		dist[src] = 0;
		for(int i=1; i<V; i++)
			dist[i] = Integer.MAX_VALUE;

		boolean visited[] = new boolean[V];

		for(int v=0; v<V; v++)
		{
			int minDistVertex = minDistVertex(dist, visited);
			visited[minDistVertex] = true;

			for(int i=0; i<V; i++)
			{				
				if(!visited[i] && graph[minDistVertex][i] && dist[minDistVertex] != Integer.MAX_VALUE)
				{
					int newDist = dist[minDistVertex] + graph[minDistVertex][i];
					dist[v] = Math.min(newDist, dist[v]);
				}
			}
		}

	//printing the distance matrix
		System.out.println(Arrays.toString(dist));
	}

	public static void main(String[] args) 
	{
		int adjMat[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                          {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                          {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                          {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                          {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                          {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                          {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                          {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                          {0, 0, 2, 0, 0, 0, 6, 7, 0}}; 

		int src = 0;                        
		dijkstra(adjMat, 9, src);
	}
}