import java.util.*;
import java.io.*;

public class DAJA{

	public static void main(String[] args)
	{
		//READ IN A FILE
		Scanner daja = null ;
		try{
			//CHANGE FILE NAME
			daja = new Scanner(new FileReader("dajaplss.txt"));
		}
		catch(Exception e){};


		//WRITE TO A NEW FILE
		PrintWriter dajapls = null;
		try{	
			//CHANGE FILE NAME
	    		dajapls = new PrintWriter(new BufferedWriter(new FileWriter("dajapls.txt")));
		} 
		catch(Exception e){};

		//DO STUFF HERE
		while(daja.hasNext())
		{
			dajapls.write(daja.next() + "\n");
		}

		//CLOSE
		dajapls.close();
		
	}

}
