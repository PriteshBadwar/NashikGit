package practice;

import java.lang.reflect.Array;

import org.bouncycastle.util.Arrays;

public class SwappingOFSmallestAndLargestIElement {
public static void main(String[] args) {
	
	int a[] = {3,4,65,7,87,9,56,23};
	
	int [] b = Arrays.copyOf(a, a.length);
	for(int bb:b)
	{
		System.out.print(bb+" ");
	}
	
	java.util.Arrays.sort(b);
	System.out.println(b);
	System.out.println();
	
	System.out.println("Smallest  Element in b array is "+b[0]);
	
	int lastIndex = b.length-1;
	System.out.println("Largest Element index in b Array is "+b[lastIndex]);
	
	int smallestIndex = 0;
	int largsetIndex  = 0;
	for(int i=0;i<=a.length;i++)
	{
		if(a[i]==b[0])
		{
			System.out.println("Smallest Index Position is "+i);
			smallestIndex = i;
		}
		if(a[i]==b[lastIndex])
		{
			System.out.println("Largest Index Position is "+i);
			largsetIndex = i;
		}
	}
	int c=0;
	  c = a[smallestIndex];
	  a[smallestIndex]= a[largsetIndex];
	  a[largsetIndex]= 0;
	  
	  
	  for(int aa:a)
	  {
		  System.out.println(aa);
	  }
	
	
	
	
	
	
	
}
}
