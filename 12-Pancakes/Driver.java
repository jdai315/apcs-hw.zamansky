public class Driver{
	public static void main(String[] args){
		MyStack hi = new MyStack();
		MyStack test = new MyStack();
		System.out.println(test.pop());
		System.out.println(hi.isEmpty());
		hi.push("one");
		hi.push("two");
		hi.push("three");	
		hi.push("four");
		hi.push("five");
		hi.push("six");
		hi.push("seven");
		hi.push("eight");
		hi.push("nine");
		hi.push("ten");
		hi.push("eleven");
		System.out.println(hi);
		System.out.println(hi.size());
		System.out.println(hi.isEmpty());	
		System.out.println(hi.peek());
		System.out.println(hi.pop());
		System.out.println(hi);
		System.out.println(hi.size());
	}
}
