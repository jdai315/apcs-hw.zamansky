//MyStack: top to bottom = right to left (when read on the print line)
//edits from pair programming: wrote code to check if stack is empty before performing some of the functions from Omar
public class MyStack{
	
	//instance variables
		//the array, the empty top, no length

	private String[] pancakes;
	private int top;
	private int numElems;

	//constructor
		//initialize an empty String Array 10 elements long

	public MyStack(){
		pancakes = new String[10];
		top = 0;
		numElems = 0;
	}

	//#1: push
		//if the array is full, increase the size of the array and then add the new top
		//otherwise, the new top is located at (numElems)index in the array

	public void push(String s){
		if (numElems == pancakes.length){
			String[] temp = new String[numElems+1];
			for(int x = 0 ; x < numElems ; x++){
				temp[x] = pancakes[x];
			}
			temp[numElems] = s ;
			pancakes = temp ;
		}else{
			pancakes[numElems] = s;
		}
		numElems++;
	}

	//#2: pop
		//save the value of the top
		//set the top to an empty string	
		//decrease the size
	
	public String pop() {
	    if(numElems==0){
		return null;
	    }
		String answer = pancakes[numElems-1];
		pancakes[numElems-1] = "";
		numElems--;
		return answer;
	}

	//#3: peek
		//show value of the top
	public String peek() {
	    if(numElems==0){
		return null;
	    }
		return pancakes[numElems-1];
	}

	//#4: size
		//return the number of elements, not the size of the array (default: 10)

	public int size() {
		return numElems;
	}

	//#5: isEmpty
		//check if there are any elements in the array

	public boolean isEmpty() {
		return numElems==0;
	}

	//#6: toString
		//print the array

	public String toString() {
	    if(numElems==0){
		return null;
	    }
		String answer = "";
		for(int x = 0 ; x < numElems; x++){
			answer += pancakes[x] + ", " ;
		}
		return answer.substring(0,answer.length()-2);
	}
}
