import java.io.*;
import java.util.*;

public class Node<E>{

    private E data; //self
    private Node<E> next; //next node

    public void setData(E data){
	this.data = data;
    }

    public E getData(){
	return data;
    }

    public void setNext(Node next){
	this.next = next;
    }

    public Node<E> getNext(){
	return next;
    }
    
    public String toString(){
	return "" + data;
    }

    public Node(E data){
	this.data = data;
	next = null;
    }

}
