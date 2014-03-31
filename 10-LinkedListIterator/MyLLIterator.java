import java.io.*;
import java.util.*;

public class MyLLIterator<E> implements Iterator<E>{

    private Node<E> currentNode;

    public MyLLIterator (Node<E> n){
	currentNode = n;
    }

    public boolean hasNext(){
	return currentNode!=null;
    }

    public E next() {
	if(hasNext()){
	    E answer = currentNode.getData();
    	    currentNode = currentNode.getNext();
	    return answer;
	}else{
	    return null;
	}
    }

    public void remove(){
	System.out.println("hi");
    }

}
