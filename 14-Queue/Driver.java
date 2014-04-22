public class Driver{

    public static void main(String[] args){
	MyQueue hi = new MyQueue();
	System.out.println(hi);
	System.out.println("head: " + hi.front());
	hi.enqueue("one");
	System.out.println(hi);
	hi.enqueue("two");
	System.out.println(hi);
	hi.enqueue("three");
	System.out.println(hi);
	System.out.println("head: " + hi.front());
	System.out.println(hi.dequeue());
	System.out.println(hi);
	System.out.println("head: " + hi.front());
    }
}