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

    //#1
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

    //#2
    //not working
    public void add(int loc, String d){
	if(loc < this.length()){
	    Node n = new Node(d);
	    Node temp = head ;
	    int x = this.length()-1;
	    while(!(x==loc-1)){
		temp = temp.getNext();
		x--;
	    }
	    Node nn = temp.getNext();
	    temp.setNext(n);
	    n.setNext(nn);
	    for(int y = x ; y > 0 ; y--){
		nn = nn.getNext();
	    }      
	}else{
	    System.out.println("Index out of bounds error");
	}
    }

    //#3 
    public String get(int loc){
	if(loc < this.length()){
	    Node temp = head;
	    for(int x = this.length()-1 ; x > 0 ; x--){
		if(x==loc){
		    return temp.toString();
		}
		temp = temp.getNext();
	    }
	     
	}else{
	    return "Index out of bounds error";
	}
	return "";
    }
    
    //#4
    public String set(int loc, String s){
	String answer = "" ;
	if(loc < this.length()){
	    Node temp = head;
	    for(int x = this.length()-1 ; x > 0 ; x--){
		if(x==loc){
		    answer = temp.toString();
		    temp.setData(s);
		    return answer;
		}
		temp = temp.getNext();
	    }
	}else{
	    return "Index out of bounds error";
	}
	return answer ;
    }
    
    //#5
    public String remove(int loc){
	String answer = "";
	if(loc < this.length()){
	    Node temp = head ;
	    Node temp2 = head ;
	    int x = this.length()-1;
	    while(!(x-1==loc)){
		if(x-1==loc){
		    answer = temp.toString();
		}
		temp = temp.getNext();
		x-- ;
	    }
	    temp2 = temp.getNext().getNext();
	    temp.setNext(temp2);
	    for(x=x;x>1;x--){
		temp2.setNext(temp2.getNext());
		temp2 = temp2.getNext();
	    }
	    return answer;
	}else{
	    return "Index out of bounds error";
	}   
    }

    //#5: Piggy backing pointers
    public String remove(int loc){
	Node temp = head.getNext();
	Node temp2 = head;
	int i = 0;
	while(i<loc-1){
	    temp2 = temp;
	    temp = temp.getNext();
	    i++;
	}
	temp2.setNext(temp.getNext());
    }

    //#6
    public int find(String s){
	try{
	    Node temp = head;
	    for(int x = this.length()-1 ; x > 0 ; x--){
		if(temp.toString().compareTo(s)==0){
		    return x;
		}
		temp = temp.getNext();
	    }
	}
	catch(Exception e){
	    System.out.println("Error: not a valid input") ;
	}
	return -1;
    }

    //#7
    public int length(){
	int answer = 0 ;
	Node temp = head ;
	while(temp!= null){
	    answer++;
	    temp = temp.getNext();
	}
	return answer;
    }


}
