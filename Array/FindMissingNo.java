package Array;

public class FindMissingNo {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,6,7};
		for(int i=0;i<=a.length;i++)
		{
			boolean isequals = a[i]+1==a[i+1];
			if(!isequals)
			{
				System.out.println(a[i]+1);
			}
		}
		
		
		
	}
}
