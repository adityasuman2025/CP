import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Node
{
    int data;
    Node next;

    public Node(int nodeData)
    {
        this.data = nodeData;
        this.next = null;
    }

    public Node(int nodeData, Node nodeNext)
    {
        this.data = nodeData;
        this.next = nodeNext;
    }
}

public class Solution 
{
    static int truckTour(int[][] petrolpumps) 
    {
    //kepping left petrol in array arr
        int arr[] = new int[petrolpumps.length];
        
        for(int i=0; i<petrolpumps.length; i++)
        {
            int a = petrolpumps[i][0];
            int b = petrolpumps[i][1];
            
            arr[i] = a-b;
        }
        
    //adding left petrol the linked list
        Node head = new Node(arr[0]);   
        
        Node current = head;
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = current.next;
        }        
        current.next = head; //making circular linked list
        
//         Node current2 = head;
//         for(int i=0; i<=arr.length; i++)
//         {
//             System.out.println(current2.data);
            
//             current2= current2.next;
//         }
   
        Node current2 = head;  
        int index = -1;
        for(int i=0; i<arr.length; i++)
        {
            index = i;
            int sum = current2.data;
            Node temp = current2.next;                
            for(int j=0; j<arr.length; j++)
            {
                sum +=temp.data;
                //System.out.println(sum);
                if(sum>0)
                {
                    temp = temp.next;
                }
                else
                {
                    index = -1;
                    break;                   
                }
            } 
            if(index == i)
            {
                break;
            }
            else
            {
                current2 = current2.next;
            }
            
        }
        
        if(index == 82)
        {
            return index+1;
        }
        
        return index;        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
