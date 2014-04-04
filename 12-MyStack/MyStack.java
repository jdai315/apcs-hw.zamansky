public class MyStack{

    private Node top;
    private int numElems;

    // constructor
    public MyStack(){
	top = null;
	numElems = 0;
    }

    //push
    public void push(String s){
	Node n = new Node(s);
	n.setNext(top);
	top = n;
	numElems++;
    }

    // pop
    public String pop(){
	String ret = top.getData() + "";
	top = top.getNext();
	numElems--;
	return ret;
    }

    // peek
    public String peek(){
	return top.getData() + "";
    }

    // size
    public int size(){
	return numElems;
    }

    // isEmpty
    public boolean isEmpty(){
	return top==null;
    }

    // toString
    public String toString(){
	String s = "" ;
	Node tmp = top ;
	while(tmp!=null){
	    s = s + tmp.getData() + ", " ;
	    tmp = tmp.getNext() ;
	}
	return s.substring(0,s.length()-2);
    }

}