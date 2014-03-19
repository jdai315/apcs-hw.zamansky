public class Driver{

    public static void main(String[] args){
	Node n1 = new Node("Jerry");
	Node n2 = new Node("Amy");
	n1.setNext(n2);
	n1.getNext().setNext( new Node("David"));
	n1.getNext().getNext().setNext(n1);
	MyLinkedList hi = new MyLinkedList();
	hi.add("Jerry");
	hi.add("Bob");
	hi.add("Amy");
	hi.add("David");
	hi.add("No");
	System.out.println(hi);
    }

}