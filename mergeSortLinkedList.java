class Node
{
    int data;
    int next;

    Node(int data)
    {
        this.data = data;
    }
}

class LinkedList
{
    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null)
            return head;
            
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        
        middle.next = null;
        
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);
        
     // Merge the left and right lists 
        Node sortedlist = merge(left, right); 
        return sortedlist; 
    }
    
    static Node merge(Node left, Node right)
    {
    //method 1    
        Node result = null;
        
        Node curr = result;
        while(left!=null && right!=null)
        {
            if(left.data<right.data)     
            {
                if(curr == null)
                {
                    curr = new Node(left.data);
                    result = curr;
                }
                else
                {
                    curr.next = new Node(left.data);
                    curr = curr.next;
                }
                left = left.next;
            }                
            else
            {
                if(curr == null)
                {
                    curr = new Node(right.data);
                    result = curr;
                }
                else
                {
                    curr.next = new Node(right.data);
                    curr = curr.next;
                }
                right = right.next;
            }
        }

        while(left!=null)
        {
            if(curr == null)
            {
                curr = new Node(left.data);
                result = curr;
            }
            else
            {
                curr.next = new Node(left.data);
                curr = curr.next;
            }
            left = left.next;
        }

        while(right!=null)
        {
            if(curr == null)
            {
                curr = new Node(right.data);
                result = curr;
            }
            else
            {
                curr.next = new Node(right.data);
                curr = curr.next;
            }
            right = right.next;
        }

    //method 2
        // if(left ==null)
        //     return right;
        
        // if(right ==null)
        //     return left;
            
        // if(left.data<=right.data)
        // {
        //    result = left;
        //    result.next = merge(left.next, right);
        // }
        // else
        // {
        //     result = right;
        //     result.next = merge(left, right.next);
        // }
          
        return result;  
    }
    
    static Node getMiddle(Node head)
    {
        if (head == null) 
            return head; 
            
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}