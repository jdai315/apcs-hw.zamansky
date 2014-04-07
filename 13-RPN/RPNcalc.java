import java.util.Scanner;
//RPN Calculator: using stacks
//note: as of now, the calculator performs the basic four operands on integers (which means there is rounding)
public class RPNcalc{

    	public static void main(String[] args){

		//create new variables

		MyStack calculator = new MyStack();
		Scanner scanner = new Scanner(System.in);
		Boolean loop = true;
		System.out.println("Welcome to Jerry's RPN Calculator! (Type 'commands' for a command list)");

		//continually loop calculator inputting unless program is exitted

		while(loop){

			//user input
			String response = scanner.nextLine();	

			//the following are commands that the user can call in the program
			if(response.equals("commands")){
				System.out.println(" 'exit' - exit the program ");
				System.out.println(" 'clear' - clear all memory ");
				System.out.println(" 'show' - show current stack ");
				System.out.println(" '+,-,*,/' - four basic operands ");
			}else if(response.equals("exit")){
				loop = false;
				System.out.println("Goodbye!");
			}else if(response.equals("clear")){
				calculator = new MyStack();
				System.out.println("Output: Memory cleared");
			}else if(response.equals("show")){
				System.out.println(calculator);
				System.out.println("Output: Showing Current Stack");

			//this if statement prevents users from performing operations on a one element stack
			}else if(calculator.size()>1){

				//save top two elements, pop them, perform function on them, push result, show result
				if(response.equals("+")){
					String one = calculator.pop();
					String two = calculator.pop();
					int uno = Integer.parseInt(one);
					int dos = Integer.parseInt(two);
					int sum = uno + dos;
					String answer = "" + sum;
					calculator.push(answer);
					System.out.println("Output: " + answer);
				}else if(response.equals("-")){		
					String one = calculator.pop();
					String two = calculator.pop();
					int uno = Integer.parseInt(one);
					int dos = Integer.parseInt(two);
					int dif = uno - dos;
					String answer = "" + dif;
					calculator.push(answer);
					System.out.println("Output: " + answer);
				}else if(response.equals("*")){
					String one = calculator.pop();
					String two = calculator.pop();
					int uno = Integer.parseInt(one);
					int dos = Integer.parseInt(two);
					int product = uno * dos;
					String answer = "" + product;
					calculator.push(answer);
					System.out.println("Output: " + answer);
				}else if(response.equals("/")){	
					String one = calculator.pop();
					String two = calculator.pop();
					int uno = Integer.parseInt(one);
					int dos = Integer.parseInt(two);
					int quotient = dos / uno;
					String answer = "" + quotient;
					calculator.push(answer);
					System.out.println("Output: " + answer);

			//all of the following code takes in integer inputs to push
			//if any of the above operations failed, the catch blocks will return the exceptions

				}else{		
					try{
						int num = Integer.parseInt(response);
						calculator.push(num+"");
						System.out.println("Output: " + num);
					}
					catch(Exception e){
						System.out.println("Error: Invalid Input");
					}
				}
			}else{
				try{
					int num = Integer.parseInt(response);
					calculator.push(num+"");
					System.out.println("Output: " + num);
				}
				catch(Exception e){
					System.out.println("Error: Invalid Input");
				}
			}
		}
    	}
}
