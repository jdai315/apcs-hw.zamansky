public class DriverFixed{

    public static void main(String[] args){
	Node n1 = new Node("Jerry");
	Node n2 = new Node("Amy");
	n1.setNext(n2);
	n1.getNext().setNext( new Node("David"));
	n1.getNext().getNext().setNext(n1);
	MyLinkedListFixed hi = new MyLinkedListFixed();
	hi.add("Jerry");
	hi.add("Bob");
	hi.add("Amy");
	hi.add("David");
	hi.add("No");
	System.out.println(hi);
	System.out.println(hi.size());
	hi.add(1,"Test");
	System.out.println(hi);
	System.out.println(hi.get(1));
	System.out.println(hi.set(1,"Yay"));
	System.out.println(hi);
	System.out.println(hi.remove(1));
	System.out.println(hi);
	System.out.println(hi.find("Bob"));
	System.out.println(hi);
    }

}
