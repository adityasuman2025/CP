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
        Node result = null;
        
        if(left ==null)
            return right;
        
        if(right ==null)
            return left;
            
        if(left.data<=right.data)
        {
           result = left;
           result.next = merge(left.next, right);
        }
        else
        {
            result = right;
            result.next = merge(left, right.next);
        }
          
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