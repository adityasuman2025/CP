import java.util.*;

class NewGraph
{
	private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists 
  
    // Constructor 
    NewGraph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList<>(); 
    } 
  
    // Function which adds an edge from v -> w 
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    } 

	void print()
	{
		for(int i=0; i<V; i++)
		{
			System.out.println("Adjacency list of vertex " + i + " is: ");
			for(Integer vertex: adj[i])
			{
				System.out.print(vertex + ", "); 
			}
			System.out.println(""); 
		}
	}
}

class GraphsNew
{
	public static void main(String[] args) 
	{
		int V = 6;
		NewGraph graph = new NewGraph(V);

		graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
  		graph.addEdge(4, 5);
        graph.addEdge(3, 5);
  		
  		graph.print();
	}
}