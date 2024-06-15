package Array;

import java.util.Arrays;

public class CopyofOneArrayintoAnother {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,56,7,};
		int b[] = Arrays.copyOf(a,a.length);
		for(int bb:b)
		{
			System.out.println(bb);
		}
		
		
		
	}
}
