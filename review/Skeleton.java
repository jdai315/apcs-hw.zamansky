//imported for convenience
import java.util.*;
import java.io.*;

public class Skeleton {

    //put methods here-------------------------

    private String name;

    public Skeleton(String s)
    {
	name = s ;
    }

    public void helperFxn()
    {
	System.out.println(this.name);
    }

    public String helperFxn2()
    {
	return this.name;
    }

    //-----------------------------------------

    //main method
    public static void main(String[] args)
    {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter name: ");
	Skeleton x = new Skeleton(scan.nextLine());
	x.helperFxn();
	FileOutput y = new FileOutput(x.helperFxn2());
	y.output();
	System.out.println("written to user.txt");
    }

}
