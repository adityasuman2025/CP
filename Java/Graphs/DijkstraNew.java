class DijkstraNew
{
	static int minDistVertex(int dist[], boolean visited[])
	{
		int V = dist.length;

		int minDistVertex = -1;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<v; i++)
		{
			if(!visited[i] && dist[i]<=min)
			{
				min = dist[i];
				minDistVertex = i;
			}
		}

		return minDistVertex;
	}

	static void dijkstra(int graph[][], int V)
	{
		int dist[] = new int[V];		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		boolean visited[] = new boolean[V];

		for(int i = 0; i<V; i++)
		{
			int minDistVertex = minDistVertex(dist, visited);
			visited[minDistVertex] = true;

			for(int v=0; v<V; v++)
			{
				if(graph[minDistVertex][v] != 0 && !visited[v] && dist[minDistVertex] != Integer.MAX_VALUE)
				{
					dist[v] = Math.min(dist[v], dist[minDistVertex] + graph[minDistVertex][v]);
				}
			}
		}

	//printing the distance matrix
		System.out.println(Arrays.toString(dist));
	}
}