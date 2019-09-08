import java.util.*; 

class graph
{
	int V; // no of vertex
	LinkedList<Integer> adjList[]; //Adjacency Lists

	graph(int V)
	{
		this.V =V;

		adjList = new LinkedList[V];
		for(int i=0; i<V; i++)
		{
			adjList[i] = new LinkedList<>();
		}
	}
}

public class Graphs
{
	static int v = 6;
	static graph g = new graph(v);

//function to add edge in the directed graph
	static void addEdge(int src, int dest)
	{
		g.adjList[src].add(dest);
	}

//function to add edge in the undirected graph
	// static void addEdge(int src, int dest)
	// {
	// 	g.adjList[src].add(dest);
	// 	g.adjList[dest].add(src);
	// }

//function to print the graph
	static void print()
	{
		for(int i=0; i<g.V; i++)
		{
			System.out.println("Adjacency list of vertex "+ i); 

            for(Integer pCrawl: g.adjList[i]){ 
                System.out.print(pCrawl+ ", "); 
            } 
            System.out.println("\n"); 
		}
	}

//function to do BFS of the graph from a vertex onwards
	static void BFS(int start_vertex)
	{
		boolean visited[] = new boolean[g.V];
		Queue<Integer> q = new LinkedList<>();

		visited[start_vertex] = true;
		q.add(start_vertex);

		while(!q.isEmpty())
		{
			start_vertex = q.poll();
			System.out.println(start_vertex);

			Iterator<Integer> i = g.adjList[start_vertex].listIterator(); 
			while(i.hasNext())
			{
				int temp_vertex = i.next();

				if(!visited[temp_vertex])
				{
					visited[temp_vertex] = true;
					q.add(temp_vertex);
				}
			}
		}
	}

//recursive DFS from a vertex onwards
	static void DFSUtil(int v, boolean visited[])
	{
		visited[v] = true;
		System.out.println(v);

		Iterator<Integer> i = g.adjList[v].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				DFSUtil(n, visited);
			}
		}
	}

	static void DFS(int v)
	{
		boolean visited[] = new boolean[g.V];

	//the recursive function to perform DFS
		DFSUtil(v, visited);
	}

//iterative function to do DFS
	static void itDFSUtil(int i, boolean visited[])
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(i);

		while(!stack.empty())
		{
			int s = stack.pop();

			if(!visited[s])
			{
				System.out.println(s);
				visited[s] = true;
			}

		//getting the adjacent vertex of the popped item and pushing it into the stack if it is not visited
			Iterator<Integer> it = g.adjList[s].listIterator();
			while(it.hasNext())
			{
				int v = it.next();

				if(!visited[v])
				{
					stack.push(v);
				}
			}
		}
	}

	static void ItDFS()
	{
		boolean visited[] = new boolean[g.V];

		for(int i=0; i<g.V; i++)
		{
			if(!visited[i])
			{
				itDFSUtil(i, visited);
			}
		}
	}

//function to do topological sorting
	static void topSortUtil(int v, boolean visited[], Stack<Integer> stack)
	{
		visited[v] = true;

	//recursive call to all vertices adjacent to this vertex
		Iterator<Integer> i = g.adjList[v].listIterator();
		while(i.hasNext())
		{
			int n = i.next();

			if(!visited[n])
			{
				topSortUtil(n, visited, stack);
			}
		}

		stack.push(v);
		//System.out.println(stack); 
	}

	static void topSort()
	{
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[g.V];

	//going to each vertex one by one to check for topological sort
		for(int i=0; i<g.V; i++)
		{
			if(!visited[i])
			{
				topSortUtil(i, visited, stack);
			}
		}

	//printing the stack i.e the topological sorted list
		while(!stack.empty())
		{
			System.out.print(stack.pop() + ", ");	
		}		

		System.out.println(); 
		System.out.println(); 
	}

//function to get shortest path(minimum edges required) between two vertices
//we are using here BFS, which is used for the case of when all edges has length =1
//when edges have different lengths, we need to use dijkstra algorithm to get shortest path in that case
	static int[] pathBFSUtil(int start)
	{
		boolean visited[] = new boolean[g.V];
		int dist[] = new int[g.V];

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		dist[start] = 0;

		while(!q.isEmpty())
		{
			start = q.poll();

			Iterator<Integer> it = g.adjList[start].iterator();
			while(it.hasNext())
			{
				int temp = it.next();

				if(!visited[temp])
				{
					visited[temp] = true;
					dist[temp] = dist[start] +1;
					q.add(temp);
				}
			}
		}

		return dist;
	}

	static void getPath(int src, int desc) // src vertex, dest vertex
	{
		System.out.println("Minimum distance of edges(Shortest Path) between source " + src + " and destination " + desc + " is: " + pathBFSUtil(src)[desc]);
	}

//finding the mother vertex of the graph
	static void DFSUtil2(int v, boolean visited[])
	{
		visited[v] = true;
		
		Iterator<Integer> i = g.adjList[v].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				DFSUtil2(n, visited);
			}
		}
	}

	static void findMother()
	{
		boolean visited[] = new boolean[g.V];
		int lastFinishedVertex = -1;

	//getting the last finished vertex from the depth first search
		for(int i=0; i<g.V; i++)
		{
			if(!visited[i])
			{
				DFSUtil2(i, visited);

				lastFinishedVertex = i;
			}
		}
		
	//checking if the lastfinishedvertex is really a mother vertex or not
		for(int i=0; i<g.V; i++)
		{
			visited[i] = false;
		}

		DFSUtil2(lastFinishedVertex, visited);
		
		for(int i=0; i<g.V; i++)
		{
			if(visited[i] == false)
			{
				System.out.println("DNE");
				return;
			}
		}

		System.out.println(lastFinishedVertex);
	}

//detect cycle in directed graph
	static boolean detectCycleUtil(int i, boolean visited[], boolean stack[])
	{
		if(stack[i])
		{
			return true;
		}

		if(visited[i]) 
        {
       		return false; 
        }   

        visited[i] = true;
        stack[i] = true;

        Iterator<Integer> it = g.adjList[i].listIterator();
		while(it.hasNext())
		{
			int n = it.next();
			if(detectCycleUtil(n, visited, stack))
			{
				return true;
			}
		}
		stack[i] = false;

		return false;
	}

	static boolean detectCycle()
	{
		boolean visited[] = new boolean[g.V];
		boolean stack[] = new boolean[g.V];

	//calling the recursive function to detect cycle in different DFS of the given graph
		for(int i=0; i<g.V; i++)
		{
			if(detectCycleUtil(i, visited, stack))
			{
				return true;
			}			
		}
		return false;
	}

//detect cycle in undirected graph
	static boolean isCyclicUnDirected()
    {
       boolean visited[] = new boolean[V];
       
       for(int i=0; i<g.V; i++)
       {
           if(!visited[i])
                if(is(i, visited, -1))
                    return true;
       }
       
       return false;
    }
    
    static boolean is(int i, boolean visited[], int parent)
    {
        visited[i] = true;
        
        Iterator<Integer> it = g.adjList[i].listIterator();
		while(it.hasNext())
		{
			int c = it.next();

            if(!visited[c])
            {
                if(is(c, visited, i))
                    return true;
            }
            else
            {
                if(c != parent)
                    return true;
            }
        }
        
        return false;
    }

//to check if undirected graph is tree or not
//there should not be cycle and should be connected
	static boolean isCyclic(int i, boolean visited[], int parent)
	{
		visited[i] = true;

		Iterator<Integer> it = g.adjList[i].listIterator();
		while(it.hasNext())
		{
			int v = it.next();

			if(!visited[v])
			{
				if(isCyclic(v, visited, i))
				{
					return true;
				}
			}
			else
			{
				if(v != parent)
				{
					return true;
				}
			}			
		}

		return false;
	}

	static boolean isTree()
	{
		boolean visited[] = new boolean[g.V];

	//checking for cycle
		if(isCyclic(0, visited, -1))
		{
			System.out.println("is cyclic: yes");		
			return false;
		}
		else
		{
			System.out.println("is cyclic: no");		
		}

	//checking for reachability
		for(int i=0; i<g.V; i++)
		{
			if(!visited[i])
			{
				return false;
			}
		}

	//if the graph is tree
		return true;
	}

//main function
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

        System.out.println("Following is a Topological sort of the given graph"); 
        topSort();

        System.out.println("Following is a Breadth First Search of the given graph"); 
        BFS(0);

        System.out.println("Following is a Depth First Search of the given graph"); 
        ItDFS();
       
       	System.out.println();
       	getPath(3, 3);

        // System.out.print("Mother of the graph is: "); 
        // findMother();

        // System.out.println("Graph contains cycle: " + detectCycle());
        // System.out.println("Is graph a tree: " + isTree());
	}
}