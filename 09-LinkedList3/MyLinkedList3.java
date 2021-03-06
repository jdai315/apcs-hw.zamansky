import java.util.ArrayList;

//with both head and tail nodes
public class MyLinkedList3{

    private Node head,tail;
    
    public MyLinkedList3(){
	head = null;
	tail = null;
    }

    //sets the element after the last as the tail
    public void resetTail(){
        Node temp = head;
	while(temp.getNext() != null){
	    temp = temp.getNext();
	}
	tail = temp;
    }

    public void addTail(String d){
	tail.setNext(new Node(d));
	tail = tail.getNext();
    }

    public String getTail(){
	return tail.getData();
    }

    public void add(String d){
	Node temp = new Node(d);
	temp.setNext(head);
	head = temp;
	resetTail();
    }

    //#1
    public String toString(){	
	String answer = "[";
	Node temp = head;
	ArrayList<Node> nodes = new ArrayList<Node>();
	while(temp!=null){
	    nodes.add(temp);
	    temp = temp.getNext();
	}
	for(int x = 0 ; x < nodes.size()-1 ; x++){
	    answer+= nodes.get(x).getData() + ", ";
	}
	answer+= nodes.get(nodes.size()-1) + "]" ;
	return answer ;
    }

    //#2
    public void add(int loc, String d){
	try{
	    Node temp = head;
	    for(int x = 0 ; x < loc ; x++){
		if (loc-1==x){
		    Node n = new Node(d);
		    n.setNext(temp.getNext());
		    temp.setNext(n);
		}
		temp = temp.getNext();
	    }
	    resetTail();
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }

    //#3 
    public String get(int loc){
	try{
	    Node temp = head;
	    for(int x = 0 ; x < this.size() ; x++){
		if(loc==x){
		    return temp.getData();
		}
		temp = temp.getNext();
	    }
	    return "Not found";
	
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }

    //#4
    public String set(int loc, String s){
	String old = "";
	try{
	    Node temp = head;
	    for(int x = 0 ; x < this.size() ; x++){
		if(loc==x){
		    old = temp.getData();
		    temp.setData(s);
		    return old ;
		}
		temp = temp.getNext();
	    }
	    return "Index error";
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }
    

    //#5
    public String remove(int loc){
	String old = "" ;
	try{
	    Node temp = head;
	    for(int x = 0 ; x < this.size() ; x++){
		if(loc-1==x){
		    old = temp.getNext().getData();
		    temp.setNext(temp.getNext().getNext());
		    resetTail();
		    return old;
		}
		temp = temp.getNext();
	    }
	    return "Index error";
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }			

    //#6
    public int find(String s){
	try{
	    Node temp = head;
	    for(int x = 0 ; x < this.size() ; x++){
		if(temp.getData().compareTo(s) == 0){
		    return x ;
		}
		temp = temp.getNext();
	    }
	    return -1;
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }

    //#7
    public int size(){
	int answer = 0 ;
	Node temp = head ;
	while(temp!= null){
	    answer++;
	    temp = temp.getNext();
	}
	return answer;
    }

}
