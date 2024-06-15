package Array;

import org.bouncycastle.util.Arrays;

public class SwappingTHeLargestAndSmallestElements {

	
	public static void main(String[] args) {
// coping one array into another array
		int a [] = {10, 56, 1, 82, 96};
		int b[] = Arrays.copyOf(a, a.length);
		for(int bb:b)
		{
		System.out.print(bb+" ");
		}
		System.out.println();
	//Finding Smallest and the Largest elements
		java.util.Arrays.sort(b);
		System.out.println("Smallest Element is "+b[0]);
		
		int largestindexposition = b.length-1;
		System.out.println("Largest Element is "+b[largestindexposition]);
		
	//Finding the Smallest and Largest Index position of eleements in the array
		
		int smallestindex = 0;
		int largestindex = 0;
		for(int i= 0;i<=a.length;i++)
		{
			if(a[i]==b[0])
			{
				System.out.println("Smallest index position = "+i);
				smallestindex = i;	
			}
			if(a[i]==b[largestindexposition])
			{
				System.out.println("Largest index position = "+i);
				largestindex=i;
			}
			
			//Swapping the Smallest and the Largest Elements
			
		int	c=0;
		
		c=a[smallestindex];
		a[smallestindex] = a[largestindex];
		a[largestindex] = c;
		
		//for printing the array

		
		for(int aa:a)
		{
			System.out.print(aa+" ");
		}
		
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
