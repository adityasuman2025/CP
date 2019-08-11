import java.util.*;

class Assignment_10_2_1601me01
{
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
		
		if(a<=b)
		{
			return true;
		}

		return false;
	}

	public static float perform(float a, float b, char action)
	{
		float ans = 0;
		if(action == '+')
		{
			ans = a+b;
		}
		else if(action == '-') 
		{
			ans =  a-b;	
		}
		else if(action == '*')
		{
			ans =  a*b;
		}
		else if(action == '/')
		{
			ans =  a/b;
		}
		else if(action == '^')
		{
			ans =  (float)Math.pow(a, b);
		}

		System.out.println(Float.toString(a) + " " + action + " " + Float.toString(b) + " = " + ans);
		return ans;
	}

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
	//infix to postfix conversion
		Stack<Character> stack = new Stack<>();				
		String in = scanner.nextLine();
		String out = "";

		for(int i=0; i< in.length(); i++)
		{
			int t = (int)in.charAt(i);

			if((t >=65 && t<=90) || (t>=97 && t<=122)) //if we find any operand
			{
				out += (char)t;
				System.out.println("Reading " + (char)t + ", current_op-string = " + out);
			}
			else //if we find any operator
			{
				if(stack.empty())
				{
					stack.push((char)t);
				}
				else if(t == '(')
				{
					stack.push((char)t);
				}
				else if(t == ')')
				{
					char top = stack.peek();

					while(!stack.empty() && top !='(') //t is lower than top
					{
						out += top;
						stack.pop();

						if(!stack.empty())
						{
							top = stack.peek();
						}
					}
					stack.pop();
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
					System.out.println("Reading " + (char)t + ", Pushing " + (char)t + " in Stack");					
				}
			}
		}	

	//if some operators are left in stack then popping them	
		while(!stack.empty()) //t is lower than top
		{
			char top = stack.pop();
			out += top;
		}

		System.out.println();
		System.out.println("Postfix expression is: " + out);
		System.out.println();

	//mathematical calculation from the expression
		System.out.println("Performing mathematical operation");
		Stack<Float> op = new Stack<>();
		
		for(int i=0; i<out.length(); i++)
		{
			int t = (int)out.charAt(i);
			if((t >=65 && t<=90) || (t>=97 && t<=122)) //if we find any operand
			{
				op.push((float)(t-64));
			}
			else //if we find any operator
			{
				float s = op.pop();
				float f = op.pop();

				float res = perform(f, s, (char)t);

				op.push(res);
			}
		}	

		System.out.println("Answer is: " + op.peek());
	}
}