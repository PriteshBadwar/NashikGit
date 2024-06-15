package loops;

public class PrintStarPattern2 {
public static void main(String[] args) {
	
	for(int i=1;i<=5;i++)
	{
		for(int j=5;j>=i;j--)
		{
			System.out.print("*");
		}
		System.out.println("");
	}
	
	
//	//
//	for(int i=1;i<=5;i++)
//	{
//		for(int j=5;j>=i;j--)
//		{
//		System.out.println();
//		}
//		for(int k=1;k<=5;k<=i;k++)
//		{
//			System.out.println("*");
//			
//		}
//		System.out.println();
//	}
	
	
	// 2*2 table
	int no = 2;
	for(int i=1;i<=10;i++)
	{
		int value = no*i;
		System.out.println(no+"*"+i+"="+value);
	}
	
	
	
	
}
}
	
