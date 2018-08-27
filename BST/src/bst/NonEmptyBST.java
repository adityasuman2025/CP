package bst;

class NonEmptyBST<D extends Comparable> implements Tree<D> {
    D data;
    Tree<D> left;
    Tree<D> right;
    
    public NonEmptyBST(D elt)
    {
        data = elt;
        left = new EmptyBST<D>();
        right = new EmptyBST<D>();
    }
        
}
