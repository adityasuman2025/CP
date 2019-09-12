
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
 
 class BinaryIntoDecimal
{
    Node head;  // head of lisl
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        String s = sc.nextLine();
        while(t>0)
        {
            int n = sc.nextInt();
            String s1 = sc.nextLine();
            LinkedList1 llist = new LinkedList1();
            //int n=Integer.parseInt(br.readLine());
            if (n > 0)
            {
                int a1=sc.nextInt();
                Node head= new Node(a1);
                llist.addToTheLast(head);
            }
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            System.out.println(new gfg().DecimalValue(llist.head));
            t--;
        }
    }
}

class gfg
{
   long DecimalValue(Node head)
   {
        long count = 0;
        long sum = 0;
        
        Node current1 = head;
        while(current1 !=null)
        {
            current1 = current1.next;
            count++;
        }
        //System.out.println(count);
        
        Node current2 = head;
        while(current2 !=null)
        {
            long val = current2.data;
            //System.out.println(count);
            
            sum+= val*(Math.pow(2, count-1));
            
            current2 = current2.next;
            count--;
        }
        return sum%1000000007;
   }
}