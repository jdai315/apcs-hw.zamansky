import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class QuickSort{

    public static int indexOf(int[] L, int find){
	for (int x = 0 ; x < L.length ; x++) {
	    if (L[x] == find){
		return x ;
	    }
	}
	return -1;
    }

    public static int[] swap(int[] L, int first, int second){
	int save = L[first];
	L[first] = L[second];
	L[second] = save;
	return L;
    }

    public static String toString(int[] L){
	String answer = "[";
	if(L.length <= 0 ){
	    return answer + "]";
	}else if(L.length == 1){
	    return answer + L[0] + "]";
	}else{
	    for (int x = 0 ; x <L.length-1 ; x++){
	        answer+= L[x] + ", " ;
	    }
	}
	answer += L[L.length-1] + "]" ;
	return answer;
    }

    public static int[] quicksort(int[] L,  int low, int high){
	if (L.length <= 1){
	    return L ;
	}else{
	    Random rand = new Random();
	    int piv = rand.nextInt(L.length-1); //doesnt pick last index because thats a bad pivot
	    int pivot = L[piv];
	    System.out.println(pivot);
	    System.out.println(piv);
	    for (int x = low ; x < high ; x++){
		if ( (L[x] > L[piv]) &&
		     (x < piv) ) {
		    L = swap(L,piv,x) ;
		    piv = x ;
		}else if( (L[x] < L[piv]) &&
			  (x > piv) ){
			L = swap(L,piv,x);
			piv = x;
		}
		//special case of swap
		if( (x>=1) &&
		    (x<L.length) ){
		    if( (L[x] < L[x-1]) ){
		    	L = swap(L,x-1,x);
		    	piv = x-1;
		    }/*else if( (L[x] > L[x+1]) ){
			L = swap(L,x+1,x);
			piv = x+1;
		    }	*/	
		}
		System.out.println(toString(L));
	    }
	    piv = indexOf(L,pivot);
	    int[] rone = new int[piv] ;
	    int[] rtwo = new int[L.length - piv-1];
	    for (int y = 0 ; y < L.length ; y++){
		int skip = y ;
		if (y < piv) {
		    rone[y] = L[y] ;
		}else if(y > piv){
		    rtwo[y-skip] = L[y] ;
		}
	    }
	    System.out.println(pivot);
	    System.out.println(piv);
	    System.out.println(toString(rone));
	    System.out.println(toString(rtwo));
	    rone = quicksort(rone,0,rone.length);
	    return rone ;
	    /*
	    rtwo = quicksort(rtwo,0,rtwo.length);
	    int[] answer = new int[L.length];
	    for(int z = 0 ; z < L.length ; z++){
		int skip = z;		
		if (z < piv){
		    answer[z] = rone[z] ;
		}else if(z > piv){
		    answer[z] = rtwo[skip - z] ;
		}else{
		    answer[z] = pivot ;
		}
	    }*/
	    //return answer ;
	}
		
    }

    public static void main(String[] args){
	
	int[] p = {3,7,1,4,32,95,47,12,50,41};
	System.out.println(toString(p));
	System.out.println(toString(quicksort(p,0,p.length)));
    }

}
