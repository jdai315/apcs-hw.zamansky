public class BST
{
    private Node root;
    
    public BST(Node root)
    {
	this.root = root;
    }

    public Node search(int x)
    {
	Node current = root;
	while( (current!=null) && 
	       (current.getData()!=x)
	       )
	    {
		if ( current.getData() < x )
		    { current = current.getRight(); }
		else
		    { current = current.getLeft(); }
	    }
	return current;
    }

}