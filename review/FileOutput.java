//outputting to a file class
//read main method for explanations

import java.io.*;

public class FileOutput {

    //turn this into an object, more convenient to write to from other classes
    private String text;

    public FileOutput(String s)
    {
	text = s;
    }

    public void output()
    {
	PrintWriter out = null;
	try {
	    out = new PrintWriter(new BufferedWriter(new FileWriter("user.txt")));
	}
	catch (Exception e){};
	out.write(text);	
	out.close();
    }

    //-------------------------------------------------------------------------

    public static void main(String[] args){
	//initialize the PrintWriter object outside the try-catch block
	PrintWriter out=null;

	//this creates the file
	try {
	    out = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));
	} 
	catch (Exception e){};

	//write to file here
	//remember to close
	//use write(String s), print(String s), and println(String s)
	out.write("Line1\n");
	out.write("Line2\n");
	out.println("Line3");
	out.print("hello ");
	out.write("n00b");
	out.close();
    }
	

}
