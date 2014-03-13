import java.util.Random;
import java.util.Arrays;
public class Merge{
    
    public static int[] merge(int[] a, int[] b){
	int acount = 0;
	int bcount = 0;
	int[] answer = new int[a.length+b.length];
	for(int count = 0 ; count < a.length+b.length;){
	    if(acount>=a.length){
		answer[count] = b[bcount];
		bcount++;
		count++;
	    }else if(bcount>=b.length){
		answer[count] = a[acount];
		acount++;
		count++;
	    }else{
		int first = a[acount];
		int second = b[bcount];
		if(first > second){
		    answer[count] = second;
		    answer[count+1] = first;
		    bcount++;
		    count += 1;
		}else if(first < second){
		    answer[count] = first;
		    answer[count+1] = second;
		    acount++;
		    count += 1;
		}else{
		    answer[count] = first;
		    answer[count+1] = second;
		    acount++;
		    bcount++;
		    count += 2;
		}
	    }
	}
	return answer;

    }

    public static int[] randArray(){
	Random rand = new Random();
	int length = rand.nextInt(14)+1;
	int[] answer = new int[length];
	for(int x=0 ; x<answer.length; x++){
	    answer[x] = rand.nextInt(100);
	}
	return answer;
    }

    public static int[] randArraySorted(){
	Random rand = new Random();
	int length = rand.nextInt(14)+1;
	int[] answer = new int[length];
	for(int x=0 ; x<answer.length; x++){
	    answer[x] = rand.nextInt(100);
	}
	Arrays.sort(answer);
	return answer;
    }

    public static String toString(int[] a){
	String answer = "[";
	for(int x = 0 ; x < a.length-1; x++){
	    answer += a[x] + ", ";
	}
	answer+= a[a.length-1] + "]\n";
	return answer;
    }

    public static int[] mergesort(int[] L){
	int split = 0;
	if (L.length <= 1){
	    return L;
	}else{
	    split = L.length / 2 ;
	}
	int[] a = new int[split];
	int[] b = new int[L.length-split];
	for(int x = 0; x<a.length ; x++){
	    a[x] = L[x] ;
	}
	for(int y = 0; y<b.length ; y++){
	    b[y] = L[y+split] ;
	}
	a = mergesort(a);
	b = mergesort(b);
	L = merge(a,b);
	return L;
    }

    public static void main(String[]args){
	int[] a = {1,5,8,11,15};
	int[] b = {3,4,7,9,10,13,14,17};
	int[] c = {5,18,20,31,45,45,57,99};
	int[] d = {0,0,3,19,34,37,41,45,49,55,76,81};
	int[] e = randArraySorted();
	int[] f = randArraySorted();
	int[] g = randArray();
	System.out.println("Random Sorted Array 1 :\n");
	System.out.println(toString(e));
	System.out.println("Random Sorted Array 2:\n");
	System.out.println(toString(f));
	System.out.println("Merge method:\n");
	System.out.println(toString(merge(e,f)));
	System.out.println("*----------------------------------*\n");
	System.out.println("Mergesort:\n");
	System.out.println("Random Array:\n");
	System.out.println(toString(g));
	System.out.println(toString(mergesort(g)));
    }
}
