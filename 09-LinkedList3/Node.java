public class Node{

    private String data; //self
    private Node next; //next node

    public void setData(String data){
	this.data = data;
    }

    public String getData(){
	return data;
    }

    public void setNext(Node next){
	this.next = next;
    }

    public Node getNext(){
	return next;
    }
    
    public String toString(){
	return data;
    }

    public Node(String data){
	this.data = data;
	next = null;
    }

}