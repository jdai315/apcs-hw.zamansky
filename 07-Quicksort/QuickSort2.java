import java.util.Arrays;
import java.util.ArrayList;
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

    public static void swap(int[] L, int first, int second){
	if(! ( (first > L.length) || (second > L.length) ) ){
	    int save = L[first];
	    L[first] = L[second];
	    L[second] = save;
	}
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

    public static int[] convertInt(Integer[] a){
	int[] answer = new int[a.length];
	for(int x = 0 ; x< a.length ; x++) {
	    answer[x] = (int)(a[x]) ;
	}
	return answer;
    }

    public static int partition(int[] L, int low, int high){
	if (low>=high){
	    return low ;
	}else{
		// partition
	    Random rand = new Random();
	    int pivot = rand.nextInt(L.length-1); //doesnt pick last index because thats a bad pivot
	    int wall = low ;
	    swap(L,pivot,high-1);
	    for (int x = low ; x < high ; x++){
		if( L[x] <= L[high-1] ){
		    swap(L,x,wall) ;
		    wall++;
		}
	    }
	
//i dont know why but this weird special case when the pivot picked is the largest element in the list is fixed by this statement
	    int rwall = 0;
	    int temp = 0;
	    

	    int idk = 0 ;
	    if(wall >= L.length){
		wall = L.length-1 ;
		rwall = wall;
		temp = L[rwall];
	        idk = 1;
	    }
           
	    swap(L,wall,high-1);

	    if(idk == 1){
		wall++ ;
	    }
	 
	    rwall = wall;
	    temp = L[rwall];
	    L[wall] = L[high-1];
	    L[high-1] = temp;
	    rwall++;

	    for (int i = rwall + 1 ; i < high ; i++){
		if(L[i] == L[high-1]){
		    swap(L,i,rwall);
		    rwall++;
		}
	    }
	    return (rwall+wall)/2 ;
	}	
    }

    public static int[] quicksort(int[] L, int low, int high){
	if (L.length<=1){
	    return L ;
	}else{
		// partition
	    int wall = partition(L,low,high);
		// finish partition
	    if(wall-1 > 1){
		quicksort(L,1,wall-1);
	    }
	    if(wall+1 < high-1){
		quicksort(L,wall+1,high);
	    }
	    return L;
	    /*
		//split list into two

	    ArrayList<Integer> first = new ArrayList<Integer>();
	    ArrayList<Integer> second = new ArrayList<Integer>();
	    for (int y = 0 ; y < L.length ; y++ ){
		if(y<wall-1){
		    first.add(L[y]);
		}else if(y>=wall){
	  	    second.add(L[y]);
		}
	    }

	    Integer[] one = first.toArray(new Integer[first.size()]);
	    Integer[] two = second.toArray(new Integer[second.size()]);

		// recursive partition of two arrays

	    int[] pone = quicksort(convertInt(one),wall,0,one.length);
	    int[] ptwo = quicksort(convertInt(two),wall,0,two.length);
	
		// combine arrays

	    ArrayList<Integer> answer = new ArrayList<Integer>();

		//add first array
	    for(int i = 0 ; i < pone.length ; i++){
		answer.add(pone[i]);
	    }
		//dont forget the pivot
	    answer.add(L[wall-1]);
	
		//add second array
	    for(int k = 0 ; k < ptwo.length ; k++){
		answer.add(ptwo[k]);
	    }
	    Integer[] ans = answer.toArray(new Integer[]{});
		// return combined list
	    return convertInt(ans);
	    */
	}
    }

    // quick sort with two walls
    /*
      given a list L, 0 and the length
      1. partition the list normaly with the one wall method
      2. submit L,0, length, output of partition to a main quicksort
      this mainquicksort is the rightwall value
    */
  	
    public static void main(String[] args){
	int[] o = {3,1,2,2,4};
	int[] p = {3,7,1,4,32,95,47,12,50,41};
	System.out.println(toString(o));
	System.out.println(toString(quicksort(o,0,o.length)));
    }

}
