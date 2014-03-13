import java.util.Arrays;
import java.util.Random;

public class Quick{

    //thanks to Ling for explaining swapping

    //find index of an int, ended up not using this
    public static int indexOf(int[]a, int find){
	for(int x = 0 ; x<a.length ; x++){
	    if(a[x]==find){
		return x;
	    }
	}
	return -1;
    }
    
    public static int[] swap(int[]a, int first, int second){
	int b = a[first];
	a[first] = a[second];
	a[second] = b;
	return a;
    }

    public static String toString(int[]a){
	String answer = "[";
	for(int x = 0 ; x < a.length-1 ; x++){
	    answer+= a[x] + ", ";
	}
	answer += a[a.length-1] + "]";
	return answer;
    }

    public static int quickselect(int[] a, int k, int low, int high){
	if(low>=high){
	    System.out.println(toString(a));
	    return a[high] ;
	}else{
	    Random rand = new Random();
	    int pivot = rand.nextInt(a.length-1);
	    for(int x = low ; x < high ; x++){
		if( (a[x] > a[pivot]) &&
		    (x < pivot) ){
		    a= swap(a,pivot,x);
		    pivot = x;
		}else if( (a[x] < a[pivot]) &&
			  (x > pivot) ){
		    a = swap(a,pivot,x);
		    pivot = x;
		}
	    }
	    if (k == pivot){
		return a[pivot];
	    }else if( pivot < k){
		return quickselect(a, k, pivot+1, high);
	    }else{
		return quickselect(a, k, low, pivot-1);
	    }
	}
    }

    public static void main(String[] args){
	int[] p = {3,7,5,6,9,8} ;
	System.out.println(toString(p));
	System.out.println("4th smallest element:");
	System.out.println("answer should be 7");
	System.out.println(quickselect(p, 3, 0 , p.length));
    }
}
