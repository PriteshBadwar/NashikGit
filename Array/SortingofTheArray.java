package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingofTheArray {
	public static void main(String[] args) {
		
		 int[]a = {34,56,8,39,0,74};
		 for(int aa:a)
		 {
			System.out.println(aa); 
		 }
		 System.out.println("********************");
		Arrays.sort(a);;
		for(int i=0;i<a.length;i++)
		System.out.println(a[i]);
		
		
	}

}
