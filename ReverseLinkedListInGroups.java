class ReverseLinkedListInGroups
{    
    public static Node reverse(Node head, int k)
    {
        if(head == null || head.next == null)
            return head;
            
        Node prev = null;
        Node curr = head;
        Node next = null;;
        
        int i = 0;
        while(i<k && curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
            i++;
        }
        
    //head will become last element of that group so head will point to the reverse of the next group
        head.next = reverse(curr, k);
        
        return prev;
    }
}