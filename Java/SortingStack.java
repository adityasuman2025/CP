class SortingStack
{
	public Stack<Integer> sort(Stack<Integer> input)
	{
	    Stack<Integer> tmpStack = new Stack<>();
	    
	    while(!input.isEmpty())
	    {
	        int top = input.pop();
	        
	        while(!tmpStack.isEmpty() && tmpStack.peek()>top)
	        {
	            input.push(tmpStack.pop());
	        }
	        
	        tmpStack.push(top);
	    }
	    
	    return tmpStack;
	}
}