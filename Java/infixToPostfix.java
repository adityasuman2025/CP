import java.util.*;
import java.lang.*;
import java.io.*;

class infixToPostfix
{
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int a=0; a<T; a++)
	    {
	        String input = scanner.nextLine();
	        
	        doInfixToPostfix(input);
	    }
	}
	
	static void doInfixToPostfix(String input)
	{
	    Stack<Character> stack = new Stack<>();
	    
	    String result = "";
	    for(int i=0; i<input.length(); i++)
	    {
	        char c = input.charAt(i);
	        int cInt = (int) c;
	        
	        if((cInt>=65 && c<=90) || (cInt>=97 && c<=122) || (cInt>=48 && c<=57))
	        {
	            result += c;
	        }
	        else
	        {
	            if(stack.empty())
	            {
	                stack.push(c);
	            }
	            else if(c == '(') //opening bracket
				{
					stack.push(c);
				}
				else if(c == ')') //closing bracket
				{
					char top = stack.peek();
					
					while(!stack.empty() && top != '(')
					{
					    result += top;
					    stack.pop();
					    
					    if(!stack.empty())
						{
							top = stack.peek();
						}
					}
					stack.pop(); // lastly to remove open bracket
				}
				else
				{
				    char top = stack.peek();
				    
				    while(!stack.empty() && isLower(c, top))
				    {
				        result += top;
					    stack.pop();
					    
					    if(!stack.empty())
						{
							top = stack.peek();
						}
				    }
				    stack.push(c); //lastly pushing that c
				}
	        }
	    }
	    
    //if some operators are left in stack then popping them	
		while(!stack.empty()) //t is lower than top
		{
			char top = stack.pop();
			result += top;
		}
	    
	    System.out.println(result);
	}
	
	public static int weight(char c) // return the weight of the opeartor
	{
		int weight = -1;
		if( c =='-')
		{
			weight = 1;
		}
		else if( c =='+')
		{
			weight = 1;
		}
		else if( c =='*')
		{
			weight = 2;
		}
		else if( c =='/')
		{
			weight = 3;
		}
		else if( c =='^')
		{
			weight = 4;
		}

		return weight;
	}

	public static boolean isLower(char fi, char sec) // return true if fi has lower presedence than sec
	{
		int a = weight(fi);
		int b = weight(sec);
			
		return (a<=b);
	}

}