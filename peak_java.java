import java.util.*;
import java.io.*;

//i am using modified Kosaraju’s algorithm to solve this problem 
//as question is asking for longest group of users which are connected with each other with sending and recieving both

class peak_java
{
	static int V; //no of vertex of graph
	static LinkedHashMap<String, ArrayList<String>> adj = new LinkedHashMap<>(); //adjacent list of the graph
	static LinkedHashSet<String> set = new LinkedHashSet<>(); //all unique users of the graph

	static HashSet<ArrayList<String>> ans = new HashSet<>();
	static ArrayList<String> res = new ArrayList<>();

// function to do DFS starting from v 
    static void DFSUtil(String v, HashMap<String, Boolean> visited) 
    { 
        // Mark the current node as visited and print it 
        visited.put(v, true); 
       	res.add(v);
  
        ArrayList<String> i = adj.get(v); 
        for(String n: i)
        {
            if (!visited.get(n)) 
                DFSUtil(n, visited); 
        }        
    } 

//to fill order of traversal in stack
	static void fillOrder(String v, HashMap<String, Boolean> visited, Stack<String> stack) 
    { 
    // Mark the current node as visited
        visited.put(v, true); 
  
        ArrayList<String> i = adj.get(v); 
        for(String n: i)
        {
            if (!visited.get(n)) 
                fillOrder(n, visited, stack); 
        }   
  
    // push v to Stack 
        stack.push(v); 
    } 

// function to find SCC
    static void printSCCs() 
    { 
        Stack<String> stack = new Stack<>(); 
  
    // Mark all the vertices as not visited (For first DFS) 
        HashMap<String, Boolean> visited = new HashMap<>();
        for(String str: set) 
            visited.put(str, false);
  
    // Fill vertices in stack according to their finishing times 
        for(String i: set)
           if (!visited.get(i)) 
                fillOrder(i, visited, stack); 
        
    // Mark all the vertices as not visited (For second DFS) 
       	for(String str: set) 
            visited.put(str, false);
        
    // Now process all vertices in order defined by Stack 
        while (stack.isEmpty() == false) 
        { 
        // Pop a vertex from stack 
            String v = stack.pop(); 

        // Print Strongly connected component of the popped vertex 
            if (!visited.get(v)) 
            { 
                DFSUtil(v, visited); 
               
               	if(res.size()>=3) // N>=3 (no of users in the group)
                	ans.add(res);
                
                res = new ArrayList<>();
            } 
        } 
    } 

// main function
	public static void main(String[] args) throws Exception
	{
		File file = new File("sample.txt"); //reading input from external file
		BufferedReader br = new BufferedReader(new FileReader(file)); 

	//creating directed graph from given input file	
		String st;
		while((st = br.readLine()) != null)
		{
			String arr[] = st.split("\t");
			String e1 = arr[1];
			String e2 = arr[2];

			set.add(e1);
			set.add(e2);

			if(adj.containsKey(e1))
			{
				ArrayList<String> val = adj.get(e1);
				val.add(e2);
				adj.put(e1, val);
			}
			else
			{
				ArrayList<String> val = new ArrayList<>();
				val.add(e2);
				adj.put(e1, val);	
			}			
		}

	//printing groups of users	
		printSCCs();	

		for(ArrayList<String> arr: ans)
		{
			String str = "";
			for(String s: arr)
				str += (s + ", ");

			str = str.substring(0, str.length()-2);
			System.out.println(str);
		}		
	}
}