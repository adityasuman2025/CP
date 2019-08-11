public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
{
    Stack<Integer> stack = new Stack<Integer>(); 
    
    for(int i=0; i<k; i++)
    {
        int val = q.poll();
        stack.push(val);
    }
    
    Queue<Integer> newQ = new LinkedList<Integer>();
    
    while(!stack.empty())
    {
        int val = stack.pop();
        newQ.add(val);
    }
    
    while(!q.isEmpty())
    {
        int val = q.poll();
        newQ.add(val);
    }
    
    return newQ;
}