import java.util.*;

class simpleInfixPostfix
{
	public static int weight(char c)
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

		return weight;
	}

	public static boolean isLower(char fi, char sec) // return true if fi has lower presedence than sec
	{
		int a = weight(fi);
		int b = weight(sec);
		
		if(a<=b)
		{
			return true;
		}

		return false;
	}

	public static void main(String[] args) 
	{
		Stack<Character> stack = new Stack<>();				
		String in = "A*B+C*E/F-G-H+I/J*L";
		String out = "";

		for(int i=0; i< in.length(); i++)
		{
			int t = (int)in.charAt(i);

			if((t >=65 && t<=90) || (t>=97 && t<=122) || (t>=48 && t<=57)) //if we find any operand
			{
				out += (char)t;
			}
			else //if we find any operator
			{
				if(stack.empty())
				{
					stack.push((char)t);
				}
				else
				{
					char top = stack.peek();

					while(!stack.empty() && isLower((char)t, top)) //t is lower than top
					{
						out += top;
						stack.pop();

						if(!stack.empty())
						{
							top = stack.peek();
						}
					}
					stack.push((char)t);					
				}
			}
		}	

		while(!stack.empty()) //t is lower than top
		{
			char top = stack.pop();
			out += top;
		}

		System.out.println(out);
		System.out.println(stack);
	}
}