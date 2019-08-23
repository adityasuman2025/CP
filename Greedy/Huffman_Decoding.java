void decode(String S, Node root)
{
    String string = "";
    Node c = root;
    for (int i = 0; i < S.length(); i++) 
    {
        c = S.charAt(i) == '1' ? c.right : c.left;
        if (c.left == null && c.right == null) 
        {
            string += c.data;
            c = root;
        }
    }
    System.out.print(string);
}