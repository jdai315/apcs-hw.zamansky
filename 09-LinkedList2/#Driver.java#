public class Driver{

    public static void main(String[] args){
	Node n1 = new Node("Jerry");
	Node n2 = new Node("Amy");
	n1.setNext(n2);
	n1.getNext().setNext( new Node("David"));
	n1.getNext().getNext().setNext(n1);
	MyLinkedListV2 hi = new MyLinkedListV2();

	//test basic add
	hi.add("LateNightCoding");
	hi.add("Pizza");
	hi.add("Meatballs");
	hi.add("Hungry");
	hi.add("Potatoes");
	System.out.println(hi);

	//test size of LinkedList
	System.out.println(hi.size());

	//test adding with an index
	hi.add(0,"Add some spice here");
	System.out.println(hi);

	//test the get of the LinkedList
	System.out.println(hi.get(0));

	//test setting new data for elements
	System.out.println(hi.set(5,"Ice Cream"));
	System.out.println(hi);

	//test removing elements
	System.out.println(hi.remove(0));
	System.out.println(hi);

	//test locating element locations
	System.out.println(hi.find("Meatballs"));
	System.out.println(hi);

    }

}
