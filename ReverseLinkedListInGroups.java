class ReverseLinkedListInGroups
{    
    public static Node reverse(Node curr, int k)
    {
        if(node == null || node.next == null)
            return node;
            
        Node prev = null;
        Node curr = node;
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
        
        Node nextHead = reverse(curr, k);
        node.next = nextHead;
        
        return prev;
    }

}