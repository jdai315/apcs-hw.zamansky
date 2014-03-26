import java.io.*;
import java.util.*;

public class IDriver{

    public static void main(String[] args){

	MyLinkedList hi = new MyLinkedList();
	hi.add("Jerry");
	hi.add("Bob");
	hi.add("Amy");
	hi.add("David");
	hi.add("No");
	System.out.println(hi);
	
	MyLLIterator it = hi.iterator();

	while(it.hasNext()){
	    System.out.println(it.next());
	}
	System.out.println();

	for(Object s : hi){
	    System.out.println(s);
	}


    }

}
