import java.util.Arrays;
import java.util.Random;

public class QuickSort2{

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

    //im not sure what the return type for partition is
    //doesnt work entirely correctly, sometimes partition will be sorted and then unsort
    public static int partition(int[] a, int L, int R){
	if(L>=R-1){
	    return L;
	}else{
	    Random rand = new Random();
	    int piv = rand.nextInt(R-1);
	    int pivot = a[piv] ;
	    int wall = L ;
	    a = swap(a,piv,R-1);	
	    System.out.println(piv);
	    System.out.println(toString(a) + " - ");
	    for(int x = L ; x < R ; x++ ){
		if(a[x] <= pivot){
		    a = swap(a,wall,x);
		    wall++;
		}
	    }
	    System.out.println(toString(a));
	    swap(a,wall,R-1);
	    System.out.println(L + "," + R + ": " + wall);
	    System.out.println(toString(a));
	    int wallsave = wall ;
	    partition(a,L,wall-1);
	    partition(a,wallsave+1,R-1);
	    return wall;
	}
    }

    public static int[] quicksort2(int[] a){
	int x = partition(a,0, a.length);
	return a;
    }

    public static void main(String[] args){
	int[] b = {3,1,6,4,9,7,11,2,15} ;
	System.out.println(toString(b));
	System.out.println(toString(quicksort2(b)));
    }

}
