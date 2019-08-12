public int evalTree(Node root)
{   
    if (root == null)
        return 0;

    if(root.left == null && root.right == null)
    {
        return Integer.parseInt(root.data);
    }

    if(root.data.equals("+"))
    {
        return evalTree(root.left) + evalTree(root.right);
    }
    else if(root.data.equals("-"))
    {
        return evalTree(root.left) - evalTree(root.right);
    }
    else if(root.data.equals("*"))
    {
        return evalTree(root.left) * evalTree(root.right);
    }
    else
    {
        return evalTree(root.left) / evalTree(root.right);
    } 
}