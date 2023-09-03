import java.util.*;

class jumpingNo
{
	static void bfs(int i, int limit)
	{
		Queue<Integer> q = new LinkedList<>();
		q.add(i);

		while(!q.isEmpty())
		{
			int num = q.poll();

			if(num <=limit)
			{
				System.out.print(num + " ");
				int lastDigit = num %10;

				if(lastDigit ==0)
				{
					q.add(num*10+(lastDigit+1));
				}
				else if(lastDigit == 9)
				{
					q.add(num*10+(lastDigit-1));	
				}
				else
				{
					q.add(num*10+(lastDigit-1));
					q.add(num*10+(lastDigit+1));
				}
			}

			//System.out.println(q);
		}
	}

	static void printJumping(int limit)
	{
		System.out.print(0 + " ");

		for(int i=1; i<=9 && i<=limit; i++)
		{
			bfs(i, limit);
		}
	}

	public static void main(String[] args)
	{
		int x = 40; 
   		printJumping(x); 
	}
}