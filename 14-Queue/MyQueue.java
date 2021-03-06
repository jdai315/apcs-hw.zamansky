//singlely list
//head and tail pointer
//H -> -> -> T
//empty: H&T = null
//one elem: H&T = same elem

public class MyQueue{

    private Node head,tail;
    private int size;

    //constructor
    public MyQueue(){
	head = null;
	tail = null;
	size = 0;
    }

    //enqueue
    public void enqueue(String s){
	Node n = new Node(s);
	if (tail == null){
	    tail = n;
	    head = n;
	}else{
	    tail.setNext(n);
	    tail = n;
	}
	size++;
    }
    
    //dequeue
    public String dequeue(){
	String s = "";
	if(head==null){
	    s = null;
	}else{
	    s = head.getData();
	    head = head.getNext();
	    size--;
	    if(head==null){
		tail = null;
	    }
	}
	return s;
    }

    //front
    public String front(){
	if(head==null){
	    return null;
	}
	return head.getData();
    }

    public String toString(){
	String answer = "(HEAD):";
	Node temp = head;
	while(temp!=null){
	    answer += temp.getData() + ", ";
	    temp = temp.getNext();
	}
	answer+= ":(TAIL)";
	return answer;
    }
    
}