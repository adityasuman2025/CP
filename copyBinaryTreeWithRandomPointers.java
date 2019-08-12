/*
class Tree
{
	int data;
	Tree left,right,random;
	
	Tree(int d)
	{
		data=d;
		left=null;
		right=null;
		random=null;
	}
}
*/

class copyBinaryTreeWithRandomPointers
{
	public static Tree cloneTree(Tree tree)
    {
        Tree curr = tree;
        Tree copiedTree = null;
        
        Queue<Tree> q = new LinkedList<>();
        q.add(curr);
        
        HashMap<Tree, Tree> map = new HashMap<>();
        while(!q.isEmpty())
        {
            Tree temp = q.poll();
            
            copiedTree = new Tree(temp.data);
            
            map.put(temp, copiedTree);
            
            if(temp.left != null)
            {
                q.add(temp.left);
            }
            
            if(temp.right != null)
            {
                q.add(temp.right);
            }
        }
        
        curr = tree;
        
        q.add(curr);
        while(!q.isEmpty())
        {
            Tree temp = q.poll();
            
            if(temp.left != null)
            {
                q.add(temp.left);
            }
            
            if(temp.right != null)
            {
                q.add(temp.right);
            }
            
            copiedTree = map.get(temp);
            copiedTree.left = map.get(temp.left);
            copiedTree.right = map.get(temp.right);
            copiedTree.random = map.get(temp.random);
        }
        
        return map.get(tree);
    }
}