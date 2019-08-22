int result(Node*root,Node*prev,int*m,int res)
    {
        if(root==NULL)
            return 0 ;
        int l=result(root->left,root,m,res);
        int r=result(root->right,root,m,res);
        if(root->data==prev->data+1)
            {
                res=l+r+1;
                if(*m<res)
                    *m=res;
            }
        else
            res=0;
        return res;
        
            
    }
int longestConsecutive(Node* root)
{
    int res=0,m=0;
      result(root,root,&m,res);
      
      //result(root->right,root,&m,&res);
      if(m)
        return m+1;
        else
            return -1;
}