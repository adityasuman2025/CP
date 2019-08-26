import java.util.*;
import java.io.*;

/*
Card Rotation
Given a sorted deck of cards numbered 1 to N.

1) We pick up 1 card and put it on the back of the deck.

2) Now, we pick up another card , it turns out to be card numbered 1 , we put it outside the deck.

3) Now we pick up 2 cards and put it on the back of the deck.

4) Now, we pick up another card and it turns out to be card numbered 2 , we put it outside the deck. ...

We perform this step till the last card.

If such arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of N then output -1.

Input:

The first line of the input contains the number of test cases 'T', after that 'T' test cases follow. 
Each line of the test case consists of a single linecontaining an integer 'N'.


Output:

If such arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of n then output -1.

Constraints:

1 <= T <= 100;
1<= N<= 1000; 
 

Example:

Input :

2
4
5

Output :

2 1 4 3
3 1 4 5 2
*/

class CardRotation
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        
	        Queue<Integer> q = new LinkedList<>();
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = 0;
	            q.add(i+1);
	        }
	        
	        for(int i=0; i<N; i++)
	        {
	            int c=i+1;
	            while(c>0)
	            {
	                int top = q.poll();
	                q.add(top);
	                c--;
	            }
	            
	            int front = q.poll();
	            arr[front-1] = (i+1);
	        }
	        
	        StringBuilder str = new StringBuilder();
	        for(int item: arr)
	        {
	            str.append(item + " ");
	        }
	        
	        System.out.println(str.toString());
	    }
	}
}