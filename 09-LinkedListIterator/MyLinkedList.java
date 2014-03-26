import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class MyLinkedList<E> implements Iterable<E>{

    private Node<E> head;
    
    public MyLLIterator<E> iterator(){
	MyLLIterator<E> it = new MyLLIterator<E>(head);
	return it;
    }

    public MyLinkedList(){
	head = null;
    }

    public void add(E d){
	Node<E> temp = new Node<E>(d);
	temp.setNext(head);
	head = temp;
    }

    //#1
    public String toString(){	
	String answer = "[";
	Node<E> temp = head;
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
    public void add(int loc, E d){
	try{
	    Node temp = head;
	    for(int x = 0 ; x < loc ; x++){
		if (loc-1==x){
		    Node<E> n = new Node<E>(d);
		    n.setNext(temp.getNext());
		    temp.setNext(n);
		    return;
		}
		temp = temp.getNext();
	    }
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }

    //#3 
    public E get(int loc){
	try{
	    Node<E> temp = head;
	    for(int x = 0 ; x < this.size() ; x++){
		if(loc==x){
		    return temp.getData();
		}
		temp = temp.getNext();
	    }
	    return null;
	
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }

    //#4
    public E set(int loc, E s){
	E old;
	try{
	    Node<E> temp = head;
	    for(int x = 0 ; x < this.size() ; x++){
		if(loc==x){
		    old = temp.getData();
		    temp.setData(s);
		    return old ;
		}
		temp = temp.getNext();
	    }
	    return null;
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }
    

    //#5
    public E remove(int loc){
	E old;
	try{
	    Node<E> temp = head;
	    for(int x = 0 ; x < this.size() ; x++){
		if(loc-1==x){
		    old = temp.getNext().getData();
		    temp.setNext(temp.getNext().getNext());
		    return old;
		}
		temp = temp.getNext();
	    }
	    return null;
	}
	catch(Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }			

    //#6
    public int find(E s){
	try{
	    Node<E> temp = head;
	    for(int x = 0 ; x < this.size() ; x++){
		if(temp.getData().equals(s)){
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
	Node<E> temp = head ;
	while(temp!= null){
	    answer++;
	    temp = temp.getNext();
	}
	return answer;
    }

}
