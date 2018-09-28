import java.util.*;

class Assignment_10_5_1601me01
{	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Stack<Character> st = new Stack<>();

		String str = scanner.nextLine();

		for(int i =0; i<str.length(); i++)
		{
			char val = str.charAt(i);

			if(val == '[' || val == '(' || val == '{')
			{
				st.push(val);
			}

			if(val == ')')
			{
				char temp = st.peek();
				if(temp == '(')
				{
					st.pop();
				}
			}
			else if(val == '}')
			{
				char temp = st.peek();
				if(temp == '{')
				{
					st.pop();
				}
			}
			else if(val == ']')
			{
				char temp = st.peek();
				if(temp == '[')
				{
					st.pop();
				}
			}
		}
		
		if(st.isEmpty())
		{	
			System.out.println("The expression is having balanced symbol");
		}
		else
		{
			System.out.println("The expression is not balanced");	
		}
	}
}