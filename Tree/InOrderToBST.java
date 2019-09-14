class InOrderToBST
{
	//logic is that keep making middle node as root 
	public TreeNode sortedListToBST(ListNode head) 
    {
        int size = size(head);
        
        int start = 0;
        int end = size-1;
        
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(get(head, mid));
        solve(head, root, start, end);
        
        //inOrder(root);
        //System.out.println(get(head, 2));
        return root;
    }
    
    static void solve(ListNode head, TreeNode tempRoot, int start, int end)
    {
        if(start>end)
            return;
            
        int mid = (start+end)/2;
        
        int startLeft = start;
        int endLeft = mid-1;
        int midLeft = (startLeft+endLeft)/2;
        if(startLeft<=endLeft)
        {
            tempRoot.left = new TreeNode(get(head, midLeft));
        }
        
        int startRight = mid+1;
        int endRight = end;
        int midRight = (endRight+startRight)/2;
        if(startRight<=endRight)
        {
            tempRoot.right = new TreeNode(get(head, midRight));
        }
        
        solve(head, tempRoot.left, startLeft, endLeft);
        solve(head, tempRoot.right, startRight, endRight);
    }
    
    static void inOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        if(root.left != null)
        {
            inOrder(root.left);
        }

        System.out.print(root.val + " ");

        if(root.right != null)
        {
            inOrder(root.right);
        }
    }
    
    static int get(ListNode head, int index)
    {
        if(head == null)
            return -1;
            
        int i=0;
        
        while(i<index)
        {
            head = head.next;
            i++;
        }
        
        return head.val;
    }
    
    static int size(ListNode head)
    {
        if(head == null)
            return -1;
            
        int size = 0;
        
        while(head != null)
        {
            head = head.next;
            size++;
        }
        
        return size;
    }
}