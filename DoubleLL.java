public class DoubleLL<E> {
    
    public class Node<E> {
	E data;
	Node<E> next,prev;

	public Node(E d) {
	    this.data = d;
	}
	
	public String toString() {
	    return "" + data;
	}

	public void setData(E d) { data = d;}
	public E getData() { return data;}
	
	public void setNext(Node<E> n) { next = n;}
	public Node<E> getNext() { return next;}
	
	public void setPrev(Node<E> p) { prev = p;}
	public Node<E> getPrev() { return prev;}

    }
    
    private Node<E> current,head,tail;
    private int len;
    
    public void insert(E d) {
	Node<E> n = new Node<E>(d);
	if (current==null) {
	    current = n;
	    head = n;
	    tail = n;
	    head.setNext(tail);
	    head.setPrev(tail);
	    tail.setNext(head);
	    tail.setPrev(head);
	}
	else {
	    n.setNext(head);
	    n.setPrev(tail);
	    tail.setNext(n);
	    head = n;
	}
	len ++;
    }

    public E getCurrent() {
	return current.getData();
    }

    public void forward() {
	if (current.getNext() != null)
	    current = current.getNext();
    }

    public void back() {
	if (current.getPrev() != null)
	    current = current.getPrev();
    }

    public String toString() {
	if (current == null)
	    return "";
	Node<E> tmp = tail;
	String s = "";
	int i = len;
	while (i > 0) {
	    s = s + tmp.getData() + " ";
	    tmp = tmp.getPrev();
	    i--;
	}
	return s;
    }

    public static void main(String[] args) {
	DoubleLL<String> L = new DoubleLL<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
	L.insert("world");
	System.out.println(L);
	L.insert("three");
	System.out.println(L);
	// First test up to here
	/*
	System.out.println(L.getCurrent());
	L.forward();
	L.forward();
	L.back();
	System.out.println(L.getCurrent());
	L.insert("inserted");
	System.out.println(L);
	System.out.println(L.getCurrent());
	// then text again here
	*/
    }
   
}