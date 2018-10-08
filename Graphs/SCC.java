import java.util.*;

class Graph
{
	int V;
	LinkedList<Integer> adjList[];

	Graph(int V)
	{
		this.V = V;
		adjList = new LinkedList[V];

		for(int i=0; i<V; i++)
		{
			adjList[i] = new LinkedList<>();
		}
	}

//function to add edge in the directed graph
	void addEdge(int src, int dest)
	{
		adjList[src].add(dest);
	}

//function to get transpose of that graph
	Graph getTranspose()
	{
		Graph g = new Graph(V);

		for(int i=0; i<V; i++)
		{
			Iterator<Integer> it = adjList[i].iterator();
			while(it.hasNext())
			{
				int v = it.next();
				g.adjList[v].add(i);
			}
		}

		return g;
	}

//first DFS to get the stack ready
	void firstDFS(int i, boolean visited[], Stack<Integer> stack)
	{
		visited[i] = true;

		Iterator<Integer> it = adjList[i].iterator();
		while(it.hasNext())
		{
			int v = it.next();

			if(!visited[v])
			{
				firstDFS(v, visited, stack);
			}
		}

		stack.push(i);
	}

//second DFS to get the strongly connected component
	void secondDFS(int i, boolean visited[])
	{
		visited[i] = true;
		System.out.print(i + ", ");

		Iterator<Integer> it = adjList[i].iterator();
		while(it.hasNext())
		{
			int v = it.next();

			if(!visited[v])
			{
				secondDFS(v, visited);
			}
		}
	}

//function to print the Strongly connected component of a graph
	void getSCC(Graph gr)
	{
		boolean visited[] = new boolean[V];
		Stack<Integer> stack = new Stack<>();

	//fiiling the stack with vertices by using first DFS
		for(int i=0; i<V; i++)
		{
			if(!visited[i])
			{
				firstDFS(i, visited, stack);
			}
		}

	//getting the transpose of the given graph and emptying the visited array
		for (int i = 0; i < V; i++) 
        {
        	visited[i] = false; 
        }

        //System.out.println(stack);
    //proccesing the vertices fill in the stack using second DFS
        while(!stack.empty())
        {
        	int v = stack.pop();

        	if(!visited[v])
        	{
        		gr.secondDFS(v, visited);
        	}
			System.out.println();
        }
	}	

//function to print the graph
	void print()
	{
		for(int i=0; i<V; i++)
		{
			System.out.println("Adjacency list of vertex "+ i); 

            for(Integer pCrawl: adjList[i]){ 
                System.out.print(pCrawl+ ", "); 
            } 
            System.out.println("\n"); 
		}
	}
}

public class SCC
{
	public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g = new Graph(5); 
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(3, 4); 

        System.out.println("The given graph"); 
  		g.print();

  		System.out.println(); 
  		System.out.println(); 
  		Graph gr = g.getTranspose();
  		System.out.println("Transpose of that graph"); 
  		gr.print();

        System.out.println("Following are strongly connected components "+ 
                           "in given graph "); 
        g.getSCC(gr); 
    } 
}