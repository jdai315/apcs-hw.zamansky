public class BST
{
    //instance variables
    private Node root;
    
    //constructors
    public BST()
    {
	root = null;
    }

    public BST(Node root)
    {
	this.root = root;
    }

    //insert method
	//uses piggybacking pointers
	//checks the value of left and right nodes of the current
	//inserts at end of the branch (when the next is null)
    public void insert(Node leaf)
    {
	int val = leaf.getData();
	Node piggy = root;
	Node next = root;
	while(next!=null)
	{
	    Node temp = next ;
	    if ( val < next.getData() )	
		{
		    next = next.getLeft();
		    if ( next == null )
		    	{ piggy.setLeft(leaf) ; }
		}
	    else
		{
	    	    next = next.getRight();
		    if ( next == null )
		    	{ piggy.setRight(leaf) ; }
		}
	    piggy = temp;
	}
    }

    //search method (non-recursive)
    	//takes an int and goes through the nodes to find one that contains the int as a data value
    	//if the no node exits with the int as that data, null is returned
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

    //search method (recursive)
	//checks if data of c is <,>,= to x
	//returns either null if the node is not found or c if c is the correct node
    public Node search2(Node c, int x)
    {
	if ( c == null )
	    return null ;
	if ( x < c.getData() )
	    return search2(c.getLeft() , x) ;
	else if ( x > c.getData() )
   	    return search2(c.getRight() , x) ;
	else
	    return c ;
    }

}
