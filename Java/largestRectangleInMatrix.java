class largestRectangleInMatrix
{
    public int maxArea(int A[][],int m,int n)
    {
       int result = maxHist(A[0]); 
       
   	//for making each row of the matrix a histogram
        for (int i = 1; i < m; i++) 
        { 
            for (int j = 0; j < n; j++) 
            {
                if (A[i][j] == 1) 
                    A[i][j] += A[i - 1][j]; 
       
            }
            result = Math.max(result, maxHist(A[i])); 
        } 
       
        return result; 
    }
    
    static int maxHist(int arr[])
	{
	    int n = arr.length;
	    
	    Stack<Integer> stack = new Stack<>();
	    
	    int area = 0;
	    int maxArea = 0;
	    
	    int i = 0;
	    while(i<n)
	    {
	        if(stack.empty() || arr[i] >= arr[stack.peek()]) //if stack is empty or 
	        {
	            stack.push(i); // stack.push(i++);
	            i++;
	        }
	        else
	        {
	            int top = stack.pop();
	            
	            if(stack.empty())
	            {
	                area = arr[top]*i;
	            }
	            else
	            {
	                area = arr[top]*(i-stack.peek()-1);
	            }
	            
            //updating max area
	            if(area > maxArea)
	            {
                    maxArea = area;
                }
	        }
	    }
	    
	    while(!stack.empty())
	    {
	        int top = stack.pop();
	            
            if(stack.empty())
            {
                area = arr[top]*i;
            }
            else
            {
                area = arr[top]*(i-stack.peek()-1);
            }
            
        //updating max area
            if(area > maxArea)
            {
                maxArea = area;
            }
	    }
	    
	    return maxArea;
	}
}