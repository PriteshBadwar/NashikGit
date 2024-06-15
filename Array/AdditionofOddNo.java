package Array;

public class AdditionofOddNo {
	
	public static void main(String[] args) {
		
		
	int a [] = {1, 2, 3, 5, 6, 7};
		
//		addition of odd index position
		int sum = 0;
		for(int i=0; i<a.length; i++)
		{
			if(i%2!=0)
			{
				sum = sum + a[i];
			}
		}
		
		System.out.println(sum);
		
		

	}

}
