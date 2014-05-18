import java.util.*;

public class Driver
{
		
    public static void main(String[] args)
    {
	int size = Integer.parseInt(args[0]);
	double start ;
	double end ;
	double htime = 0.0 ;
	double ttime = 0.0 ;
	HashMap<Integer, Integer>  h = new HashMap<Integer, Integer>();
	TreeMap<Integer, Integer>  t = new TreeMap<Integer, Integer>();

	System.out.println("put() speed test (in milliseconds)");
	for(int k = 0 ; k < size ; k++)
	    {
		start = System.currentTimeMillis();
		h.put(k+1, k);
		end = System.currentTimeMillis();
		htime += end - start ;
	    }
	System.out.println("HashMap: " + htime);
	for(int k = 0 ; k < size ; k++)
	    {
		start = System.currentTimeMillis();
		t.put(k+1, k);
		end = System.currentTimeMillis();
		ttime += end - start ;
	    }
	System.out.println("TreeMap: " + ttime);

	System.out.println("remove() speed test (in milliseconds)");
	for(int k = 0 ; k < size ; k++)
	    {
		start = System.currentTimeMillis();
		t.remove(k+1);
		end = System.currentTimeMillis();
		htime += end - start ;
	    }
	System.out.println("HashMap: " + htime);
	for(int k = 0 ; k < size ; k++)
	    {
		start = System.currentTimeMillis();
		t.remove(k+1);
		end = System.currentTimeMillis();
		ttime += end - start ;
	    }
	System.out.println("TreeMap: " + ttime);

    }
}