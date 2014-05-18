import java.util.*;

public class Median{

    //instance variables
    private PriorityQueue<Integer> max ;
    private PriorityQueue<Integer> min ;

    //constructor
    //create min and max heaps
    public Median(int[] a, int[] b)
    {
	max = new PriorityQueue<Integer>();
	min = new PriorityQueue<Integer>();
	for(int x : a)
	    max.add(x);
	for(int x : b)
	    min.add(x);
    }

    //find end element of minheap
    public int tail()
    {
	Integer[] m = new Integer[min.size()];
	m = min.toArray(m);
	return  m[min.size()-1];
    }

    //add method
    //if value is larger than the head of maxheap, add to maxheap
    //else, add to minheap if value is biggest in minheap
    //otherwise, add to end but swap with the greatest value
    //to fix the two heap balancing, check if size discrepancy is large enough
    //if it is, use the poll() method to move values
    public void add(int x)
    {
	if(x > max.size())
	    max.add(x);
	else
	    {
		if(x < tail())
		    {
			int temp = tail();
			min.remove(temp);
			min.add(x);
			min.add(temp);
		    }
		else
		    min.add(x);
	    }
     	if(max.size() > min.size()+1)
	    {
		min.add(max.poll());
	    }
	else if(min.size() > max.size()-1)
	    {
		int temp = tail();
		min.remove(temp);
		max.add(temp);
	    }
    }

    //median method
    //if size of maxheap = size of minheap + 1, return head of maxheap
    //else, return average of maxheap's head and end value of minheap
    public int findMedian()
    {
	if(max.size() > min.size())
	    return max.peek();
	else
	    {
		return (max.peek() + tail()) / 2 ;
	    }
    }

    //remove the median and return it
    //based on size, remove from the heap that has larger size
    //else remove from both
    public int removeMedian()
    {
	if(max.size()>min.size())
	    return max.poll();
	else if(min.size()>max.size())
	    {
		int t = tail();
		min.remove(t);
		return t;
	    }
	else
	    {
		min.remove(tail());
		return max.poll();
	    }
    }
    //print minheap then maxheap
    public String toString()
    {
	String answer = "";
	for(Integer n : min)
	    answer+= n + " ";
	answer+= "| ";
	for(Integer n : max)
	    answer+= n + " ";
	return answer;
    }

    //main method
    public static void main(String[] args)
    {
	int[] a = {8,7,6,9};
	int[] b = {3,1,4,5};
	Median m = new Median(a, b);
	System.out.println(m + " Median: " + m.findMedian());
	m.add(1);
	m.add(17);
	m.add(2);
	m.add(10);
	m.add(4);
	System.out.println(m + " Median: " + m.findMedian());
	System.out.println(m.removeMedian() + " removed: " + m);
	System.out.println(m.removeMedian() + " removed: " + m);
    }
}