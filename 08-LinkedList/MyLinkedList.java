import java.util.ArrayList;
public class MyLinkedList{

    private Node head;
    
    public MyLinkedList(){
	head = null;
    }

    public void add(String d){
	Node temp = new Node(d);
	temp.setNext(head);
	head = temp;
    }

    public String toString(){	
	String answer = "[" ;
	ArrayList nodes = new ArrayList<Node>();
	nodes.add(head);
	Node temp = head.getNext();
	while(temp!=null){	    
	    nodes.add(temp);
	    temp = temp.getNext();
	}
	for(int x = nodes.size()-1 ; x > 0 ; x--){
	    answer+= nodes.get(x).toString() + ", " ;
	}
	answer += nodes.get(0).toString() + "]";
	return answer;
    }

}