import java.util.*;
import java.io.*;

/*
Game of Death in a circle
There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed. The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise). In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom.
Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive.

Consider if n = 5 and k = 2, then the safe position is 3.
Firstly, the person at position 2 is killed, then person at position 4 is killed, then person at position 1 is killed. Finally, the person at position 5 is killed. So the person at position 3 survives.

Input: 
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. The first and only line of each test case consists of two space separated positive integers denoting n and k.

Output:
Corresponding to each test case, in a new line, print the safe position.

Constraints:
1 ≤ T ≤ 200
1 ≤ n, k ≤ 200

Example:
Input
3
2 1
4 2
50 10

Output
2
1
36

Explanation:
Testcase 1: here n = 2 and k = 1, then safe position is 2 as the person at 1st position will be killed.
*/

class Node
{
    int data;
    Node next = null;
    
    Node(int data)
    {
        this.data = data;
    }
}
class GameOfDeath
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        String str[] = bf.readLine().split(" ");
	        int N = Integer.parseInt(str[0]);
	        int K = Integer.parseInt(str[1]);
	        
        //making circular linked list
	        Node head = new Node(1);
	        Node curr = head;
	        for(int i=2; i<=N; i++)
	        {
	            Node temp = new Node(i);
	            curr.next = temp;
	            curr=temp;
            }
            curr.next = head;
            
        //printing stuff
            // Node curr2 = head;
            // while(curr2!=null)
            // {
            //     System.out.print(curr2.data + " ");
            //     curr2 = curr2.next;
            // }
            
        //task
            int flag = 0;
            Node curr3 = head;
            while(N>1)
            {
                int c = K;
                if(c==1)
                {
                    System.out.println(N); 
                    flag = 1;
                    break;
                }
                else
                {
                    while(c>2)
                    {
                        curr3 = curr3.next;
                        c--;
                    }
                    curr3.next = curr3.next.next;
                    curr3 = curr3.next;
                }
                N--;
            }
            if(flag ==0)
                System.out.println(curr3.data);
	    }
	}
}