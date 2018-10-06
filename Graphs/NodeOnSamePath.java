import java.util.*;

class graph
{
	int V;
	LinkedList<Integer> adjList[];

	graph(int V)
	{
		this.V = V;
	
		adjList = new LinkedList[V+1];
		for(int i=0; i<=V; i++)
		{
			adjList[i] = new LinkedList<>();
		}
	}
}

public class NodeOnSamePath
{
	static void addEdge(graph g, int src, int dest)
	{
		g.adjList[src].add(dest);
	}

	static void print(graph g)
	{
		for(int i=1; i<=g.V; i++)
		{
			System.out.println("Edges conneted with vertex " + (i) + " are: ");

			for(Integer pCrawl: g.adjList[i]){ 
                System.out.print(pCrawl+ ", "); 
            } 
            System.out.println("\n"); 

		}
	}

//performing modified version of DFS to solve this question problem
	static int inTime[];
	static int outTime[];
	static int timer = 0;
	static boolean visited[];

	static void nodeOnSamePathUtil(graph g, int v)
	{		
		visited[v] = true;
		System.out.print(v+ " ");
		
		timer++;;
		inTime[v] = timer;

		Iterator<Integer> it = g.adjList[v].listIterator();
		while(it.hasNext())
		{
			int n = it.next();
			if(!visited[n])
			{
				nodeOnSamePathUtil(g,n);
			}
		}

		timer++;
		outTime[v] = timer;
	}

	static void nodeOnSamePath(graph g, int v)
	{
		inTime = new int[g.V + 1];
		outTime = new int[g.V + 1];
		visited= new boolean[g.V +1];
		
		nodeOnSamePathUtil(g, v);
		
		System.out.println();
		System.out.println(Arrays.toString(inTime));
		System.out.println(Arrays.toString(outTime));
	}

//query for checking of nodes are on same path or not
	static void checkPath(int u, int v)
	{
		if(inTime[u]< inTime[v] && outTime[u]> outTime[v]) //
		{
			System.out.println("Yes u is above v");
		}
		else if(inTime[u] > inTime[v] && outTime[u]< outTime[v])
		{
			System.out.println("Yes v is above u");
		}
		else
		{
			System.out.println("These nodes are not in the same path");
		}
	}

//main function	
	public static void main(String[] args) 
	{
		graph g = new graph(9);	
		addEdge(g, 1,2);
		addEdge(g, 1,3);
		addEdge(g, 3,6);
		addEdge(g, 2,4);
		addEdge(g, 2,5);
		addEdge(g, 5,7); 
	    addEdge(g, 5,8); 
	    addEdge(g, 5,9); 

		print(g);

		nodeOnSamePath(g, 1);
		checkPath(6,5);
	}
}