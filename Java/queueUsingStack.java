import java.util.*;
import java.io.*;

class queueUsingStack
{
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	void add(int a)
	{
		s1.push(a);
	}

	int poll()
	{
		if(s2.empty())
		{
			while(!s1.empty())
			{
				s2.push(s1.pop());
			}
		}

		if(s2.empty())
			return -1
		else
			return s2.pop();
	}
}