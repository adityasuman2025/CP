import java.util.*

class NewGraph
{
	int V; //no of vertex
	LinkedList<Integer> list[]; //Adjacency Lists

	NewGraph(int V)
	{
		this.V = V;
		list[] = new LinkedList[V];

		for(int i=0; i<V; i++)
			list[i] = new LinkedList<>();
	}
}

class GraphsNew
{

}