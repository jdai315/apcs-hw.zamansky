import java.util.Scanner;

public class ScannerExample {
	
    public static void main(String[] args)
    {
	//create scanner object
	Scanner scannerObj = new Scanner(System.in);

	//convert user input into string
	System.out.println("hi how r u? : ");
	String response = scannerObj.nextLine();

	//do stuff with the input
	System.out.println(response);
	if(response.equals("hi"))
	    System.out.println("n00b");

	//can make input loops
	boolean loop = true;
	while(loop)
	{
	    System.out.println("wat u say?? : ");
	    String response2 = scannerObj.nextLine();
	    if(response2.equals("stop"))
	    {
		loop = false;
		System.out.println(" ok ");
	    }
	    else
	    	System.out.println(response2 + "-" + response2);
	}
    }

}
