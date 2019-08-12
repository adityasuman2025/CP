import java.util.*;
import java.io.*;

class stackUsingQueue
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
        if(q2.isEmpty())
            return -1;
        else
            return q2.poll();
    }
	
    /* The method push to push element into the stack */
    void push(int a)
    {
	    q1.add(a);
	    
	    while(!q2.isEmpty())
	    {
	        q1.add(q2.poll());
	    }
	    
    //swapping q1 & q2
	    Queue<Integer> q = q1;
	    q1 = q2;
	    q2 = q;
    }
}