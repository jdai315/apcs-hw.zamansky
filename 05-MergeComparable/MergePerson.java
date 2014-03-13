import java.util.Random;
import java.util.ArrayList;
public class MergePerson{
    
    //implemented a another parameter to choose whether to sort by name or age
    //sorttype 0 = name
    //sorttype 1 = age

    public static ArrayList merge(ArrayList<Comparable> a, ArrayList<Comparable> b, int sorttype){
	int acount = 0;
	int bcount = 0;
	int type = -1;
	if(sorttype ==0){
	    type = 0 ;
	}else{
	    type = 1 ;
	}
	int length = a.size()+b.size();
	ArrayList answer = new ArrayList<Comparable>();
	for(int count = 0 ; count < length;){
	    if(acount>=a.size()){
		answer.add(b.get(bcount));
		bcount++;
		count++;
	    }else if(bcount>=b.size()){
		answer.add(a.get(acount));
		acount++;
		count++;
	    }else{
		Comparable first = a.get(acount);
		Comparable second = b.get(bcount);
		String fname = first.toString();
		String sname = second.toString();
		if(sorttype==0){
		    if(fname.compareTo(sname)>0){
			answer.add(second);
			bcount++;
			count += 1;
		    }else if(fname.compareTo(sname)<0){
			answer.add(first);
			acount++;	
			count += 1;
		    }else{
			answer.add(first);
			answer.add(second);
			acount++;
			bcount++;
			count += 2;
		    }
		}else{
		    if(first.compareTo(second)>0){
			answer.add(second);
			bcount++;
			count += 1;
		    }else if(first.compareTo(second)<0){
			answer.add(first);
			acount++;	
			count += 1;
		    }else{
			answer.add(first);
			answer.add(second);
			acount++;
			bcount++;
			count += 2;
		    }
		}
	    }
	}
	return answer;

    }

    public static String toString(ArrayList<Comparable> a){
	String answer = "[";
	for(int x = 0 ; x < a.size()-1; x++){
	    answer += a.get(x) + ", ";
	}
	answer+= a.get(a.size()-1) + "]\n";
	return answer;
    }

    public static ArrayList mergesort(ArrayList<Comparable> L, int sorttype){
	int split = 0;
	if (L.size() <= 1){
	    return L;
	}else{
	    split = L.size() / 2 ;
	}
	ArrayList a = new ArrayList<Person>(split);
	ArrayList b = new ArrayList<Person>(L.size()-split);
	for(int x = 0; x < split  ; x++){
	    a.add(L.get(x)) ;
	}
	for(int y = 0; y < L.size()-split; y++){
	    b.add(L.get(y+split));
	}
	a = mergesort(a,sorttype);
	b = mergesort(b,sorttype);
	L = merge(a,b,sorttype);
	return L;
    }

    public static void main(String[]args){
	ArrayList a = new ArrayList<Comparable>();
	ArrayList b = new ArrayList<Comparable>();
	ArrayList c = new ArrayList<Comparable>();
	ArrayList d = new ArrayList<Comparable>();
	ArrayList m = new ArrayList<Comparable>();
	ArrayList n = new ArrayList<Comparable>();

	Person q = new Person("Bob", 13);
	Person w = new Person("Alice", 17);
	Person e = new Person("Mike", 16);
	Person r = new Person("Granny", 83);
	Person t = new Person("David", 45);
	Person y = new Person("John", 23);
	Person u = new Person("Beatrice", 39);	
	Person i = new Person("Genevieve", 29);

	a.add(q);
	a.add(e);
	a.add(y);
	a.add(t);

	b.add(w);
	b.add(i);
	b.add(u);
	b.add(r);

	c.add(w);
	c.add(t);
	c.add(i);
	c.add(e);

	d.add(u);
	d.add(q);
	d.add(r);
	d.add(y);
	
	System.out.println("ArrayList A:\n");
	System.out.println(toString(a));
	System.out.println("ArrayList B:\n");
	System.out.println(toString(b));
	System.out.println("Mergesort (age):\n");
	System.out.println(toString(mergesort(merge(a,b,1),1)));
	System.out.println("*----------------------------------*\n");
	System.out.println("ArrayList C:\n");
	System.out.println(toString(c));
	System.out.println("ArrayList D:\n");
	System.out.println(toString(d));
	System.out.println("Mergesort (name):\n");
	System.out.println(toString(mergesort(merge(c,d,0),0)));
	System.out.println("*----------------------------------*\n");

    }
}
