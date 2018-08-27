package queuey;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queuey {

    LinkedList queue;
    
//making the queue instance
    public Queuey()
    {
        queue = new LinkedList();
    }
    
//is queue empty
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
    
//size of queue
    public int size()
    {
        return queue.size();
    }
    
//addding element in the queue
    public void enqueue(int n)
    {
        queue.addLast(n);
    }
   
//removing element from the queue
    public int dequeue()
    {
        return (int)queue.remove(0);
    }
    
//peek at the first element
    public int peek()
    {
        return (int)queue.get(0);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
//        Queuey numberQueue = new Queuey();
//        numberQueue.enqueue(5);
//        numberQueue.enqueue(7);
//        numberQueue.enqueue(6);
//
//        System.out.println("First out: " +  numberQueue.dequeue());
//        System.out.println("Peek at 2nd item: " +  numberQueue.peek());
//        System.out.println("Second out: " +  numberQueue.dequeue());
//        System.out.println("Third out: " +  numberQueue.dequeue());


        Stack<String> stacky = new Stack();
        stacky.push(" there");
        stacky.push("hi");
    
        System.out.println("Peek: " + stacky.peek());
        System.out.print(stacky.pop());
        
        System.out.println(stacky.pop());
        //System.out.println("Peek: " + stacky.peek());
        
//        Queue<String> que = new Queue();
//        que.add("Hello");
//        que.add(" World!");
//        
//        System.out.println(que.remove());
//        System.out.print(que.peek());
    }

  
}
