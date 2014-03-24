import java.util.ArrayList;

//the dummy node version (Piggy Backing for days)
public class MyLinkedListV2{

    //VARIABLES

    private Node head;
    
    //CONSTRUCTOR

	//instead of null , set the head to dummy

    public MyLinkedListV2(){
	head = new Node("dummy");
    }

    //BASIC ADD METHOD

	// new add method
	// since the head is now a node, to get the null you have to call head.getNext()
	// temp.getNext() is set to null while the head.getNext() is set to temp

    public void add(String d){
	Node temp = new Node(d);
	temp.setNext(head.getNext());
	head.setNext(temp);
    }

    //#1 TOSTRING() METHOD

	// same as before, excempt temp is moved one element over to account for the dummy node

    public String toString(){	
	String answer = "[";
	Node temp = head.getNext();
	ArrayList<Node> nodes = new ArrayList<Node>();
	while(temp!=null){
	    nodes.add(temp);
	    temp = temp.getNext();
	}
	for(int x = 0 ; x < nodes.size()-1 ; x++){
	    answer+= nodes.get(x).getData() + ", ";
	}
	answer+= nodes.get(nodes.size()-1) + "]" ;
	return answer;
    }

    //#2 ADD(INDEX,STRING)

	// very similar to the remove function below
	// uses the Piggy Backing Pointer method by Mr.Z
	// keep track of two nodes so that you can now use the dummy node to prevent urself from going out of bounds
	// insert the new element after the lagging temp
	// reconnect to the link list using the temp that is ahead

    public void add(int loc, String d){
	try{
	    Node temp = head.getNext(); //first actual element
	    Node temp2 = head; //null
	    Node n = new Node(d);
	    int i = 0;
	    while(i<loc){
		temp2 = temp; // first actual element
		temp = temp.getNext(); //next actual element
		i++;
	    }
	    temp2.setNext(n);
	    n.setNext(temp);
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }

    //#3 GET(INDEX) METHOD

	// same as before, except temp is moved one element over to account for the dummy node

    public String get(int loc){
	try{
	    Node temp = head.getNext();
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

    //#4 SET(INDEX,STRING) METHOD

	// same as before, except temp is moved one element over to account for the dummy node
   
    public String set(int loc, String s){
	String old = "";
	try{
	    Node temp = head.getNext();
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
    
    //#5 REMOVE(INDEX) METHOD

	// uses Piggy Backing Pointers method by Mr.Z
	// same as add except instead of inserting a new element and relinking the list, 
	// tell the lagging temp to relink by skipping the temp that is ahead

    public String remove(int loc){
	Node temp = head.getNext();
	Node temp2 = head;
	int i = 0;
	while(i<loc){
	    temp2 = temp;
	    temp = temp.getNext();
	    i++;
	}
	temp2.setNext(temp.getNext());
	return temp.getData();
    }		

    //#6 FIND(STRING) METHOD

	// same as before, except temp is moved one element over to account for the dummy node

    public int find(String s){
	try{
	    Node temp = head.getNext();
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

    //#7: SIZE() METHOD

	// renamed from length to mimic ArrayList
	// same as before, except temp is moved one element over to account for the dummy node

    public int size(){
	int answer = 0 ;
	Node temp = head.getNext() ;
	while(temp!= null){
	    answer++;
	    temp = temp.getNext();
	}
	return answer;
    }

}
