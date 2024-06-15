package string;

public class Practiceeg1 {

	public static void main(String[] args) {
		
		String a = "Hello";
		String reverse = "";
		for(int i=a.length()-1;i>=0;i--)
		{
			 reverse =reverse+a.charAt(i);
					
				System.out.println("Reverse of th string "+a+ " is "+reverse);	
				
		}
		System.out.println("******************");
		
		for(int i=0;i>=a.length();i++)
		{
			char c = a.charAt(i);
			System.out.println("Sequence of String is "+c);
		}
		
		
		
		
		
		
		
	}
	
}
