import java.util.*;
import java.io.*;

class longestValidParenthesis
{
	static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int a=0; a<T; a++)
	    {
	        String input = scanner.nextLine();
	        
	        System.out.println(longestValidChain(input));
	    }
	}
	
	static int longestValidChain(String input)
	{
	    Stack<Integer> stack = new Stack<>();
	    stack.push(-1);
	    
	    int max = 0;
	    for(int i=0; i<input.length(); i++)
	    {
	        char c = input.charAt(i);
	        
	        if(c == '(')
	        {
	            stack.push(i);
	        }
	        else // ')'
	        {
	            stack.pop();
	            
	            if(!stack.empty())
	            {
	                max = Math.max(max, i-stack.peek());   
	            }
	            else
	            {
	                stack.push(i);
	            }
	        }
	    }
	    
	    return max;
	}
}