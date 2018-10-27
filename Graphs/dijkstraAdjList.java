import java.util.*; 

class graph_node
{
	int V; // no of vertex
	LinkedList<Integer> adjList[]; //Adjacency Lists

	graph_node(int V)
	{
		this.V =V;

		adjList = new LinkedList[V];
		for(int i=0; i<V; i++)
		{
			adjList[i] = new LinkedList<>();
		}
	}
}

class dijkstraAdjList
{
	static graph_node graph = new graph_node(9);

	static void addEdge(int src, int dest)
	{
		graph.adjList[src].add(dest);
	}

	static void print()
	{
		for(int i=0; i<graph.V; i++)
		{
			System.out.println("Adjacency list of vertex " + i + " are");

			for(Integer crawl: graph.adjList[i])
			{
				System.out.print(crawl+ " ");
			}

			System.out.println();
		}

	}

	static int findMinDistVertex(int dist[], boolean visited[])
	{
		int V = graph.V;

		int minDistVertex = -1;
		int min = Integer.MAX_VALUE;

		for(int i=0; i<V; i++)
		{
			if(!visited[i] && dist[i]<min)
			{
				min = dist[i];
				minDistVertex = i;
			}
		}

		return minDistVertex;
	}

	static void dijkstra(int src)
	{
		int V = graph.V;

		boolean visited[] = new boolean[V];

		int dist[] = new int[V];

	//intially setting the dist to reach each vertex as infinity and distance to reach the src vertex as 0
		for(int i=0; i<V; i++)
		{
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}

		dist[src] = 0;



	}

	public static void main(String[] args)
	{
		addEdge(0, 1); 
        addEdge(0, 2); 
        addEdge(1, 3); 
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(3, 4);
  		addEdge(4, 5);
        addEdge(3, 5);
  		
  		print();	
	}
}
