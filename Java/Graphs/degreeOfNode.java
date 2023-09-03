class Graph
{
	int v,e;
	int mat[][];

	Graph(int v, int e)
	{
		this.v = v;
		this.e =e;

		mat = new int[v][v];
	}

	void addEdge(int src, int dest) // for undirected graph
	{
		this.mat[src][dest] = 1;
		this.mat[dest][src] = 1;
	}

	void print()
	{
		for(int i=0; i<v; i++)
		{
			for(int j=0; j<v; j++)
			{
				System.out.print(this.mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	void findDegree(int vertex)
	{
		int deg =0;
		for(int i=0; i<v; i++)
		{
			if(mat[vertex][i] ==1)
			{
				deg++;
			}
		}

		System.out.println("Degree of vertex " + vertex + " is: " + deg);
	}
}


class degreeOfNode
{
	public static void main(String[] args) {
		Graph g = new Graph(4, 5);
		// g.print();
		// System.out.println();

		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		
		g.addEdge(1,3);
		g.addEdge(2,3);

		g.print();
		System.out.println();

		g.findDegree(4);
	}
}
