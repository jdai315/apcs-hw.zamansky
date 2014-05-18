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
	Node next = root;
	while(next!=null)
	{
	    Node temp = next ;
	    if ( val < next.getData() )	
		{
		    next = next.getLeft();
		    if ( next == null )
		    	{ temp.setLeft(leaf) ; }
		}
	    else
		{
	    	    next = next.getRight();
		    if ( next == null )
		    	{ temp.setRight(leaf) ; }
		}
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

    //delete method (recursive)
	//pretty ugly looking code but it works
	//checks to see if given node is root, as of now returns an error
	//follows description in README 
		//in case 3, a value is supposed to be saved 
		//this implementation saves the node itself instead and doesnt require calling its value
    public void delete(Node c, int x)
    {
	if( (c.getData()==x) )
	    System.out.println("Error");
	else
	    {
		Node l = c.getLeft();
		Node r = c.getRight();
		if ( c.getRight() == null )
		    {
		    if ( c.getLeft().getData() == x )
	    	    	{
			    if ( (c.getLeft().getRight()!=null) 
			       &&(c.getLeft().getLeft()!=null) )
			    	{
				    Node temp = c.getLeft().getRight();
				    while(temp.getLeft()!=null)
				  	{
					    temp = temp.getLeft();
				    	}
				    temp.setLeft(c.getLeft().getLeft());
				    c.setLeft(c.getLeft().getRight());
			    	}		
			    else
			    	c.setLeft(c.getLeft().getLeft());
		    	}
		    }
		else if ( c.getRight().getData() == x )
		    {
			if ( (c.getRight().getRight()!=null) 
			   &&(c.getRight().getLeft()!=null) )
			    {
				Node temp = c.getRight().getRight();
				while(temp.getLeft()!=null)
				    {
					temp = temp.getLeft();
				    }
				temp.setLeft(c.getRight().getLeft());
				c.setRight(c.getRight().getRight());
			    }
			else
			    c.setRight(c.getRight().getRight());	
		    }
		else if (c.getLeft()!=null)
		    {
			if ( c.getLeft().getData() == x )
			    {
				if ( (c.getLeft().getRight()!=null) 
				     &&(c.getLeft().getLeft()!=null) )
				    {
					Node temp = c.getLeft().getRight();
					while(temp.getLeft()!=null)
					    {
						temp = temp.getLeft();
					    }
					temp.setLeft(c.getLeft().getLeft());
					c.setLeft(c.getLeft().getRight());
				    }		
				else
				    c.setLeft(c.getLeft().getLeft());
			    }
		    }
		else
		    {
			if ( c.getLeft() == null )
			    delete(c.getRight(), x); 
			else
			    delete(c.getLeft(), x);
		    }
	     }
    }
    
    public void traverse(Node n)
    {
	if(n==null)
	    return;
	else
	    {
		traverse(n.getLeft());
		System.out.println(n.getData());
		traverse(n.getRight());
	    }
    }
	
}
