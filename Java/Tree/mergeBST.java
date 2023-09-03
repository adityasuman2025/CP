class mergeBST
{
	static void print(int val)
    {
        System.out.print(val + " ");
    }
    
    static void merge(Node root1, Node root2)
    {
    //pushing all elements of both the BSTs in seperate stacks    
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        Node c1 = root1, c2 = root2;
        
        while(c1 !=null)
        {
            s1.push(c1);
            c1 = c1.left;
        }
        
        while(c2 !=null)
        {
            s2.push(c2);
            c2 = c2.left;
        }
        
        while(!s1.empty() || !s2.empty())
        {
            c1 = c2 = null;
            
            if(!s1.empty()) 
                c1 = s1.peek();
            if(!s2.empty()) 
                c2 = s2.peek();
            
            if(c1 == null)
            {
                print(c2.data); 
                s2.pop();
            }
            else if(c2 == null)
            {
                print(c1.data); 
                s1.pop();
            }
            else if(c1.data < c2.data)
            {
                print(c1.data); 
                s1.pop(); 
                c2 = null;
            }
            else
            {
                print(c2.data); 
                s2.pop(); 
                c1 = null;
            }
            
            if(c1 !=null && c1.right !=null)
            {
                c1 = c1.right;
                while(c1 !=null)
                {
                    s1.push(c1);
                    c1 = c1.left;
                }
            }
            if(c2 !=null && c2.right !=null)
            {
                c2 = c2.right;
                while(c2 !=null) 
                {
                    s2.push(c2);
                    c2 = c2.left;
                }
            }
        }
    }
}
