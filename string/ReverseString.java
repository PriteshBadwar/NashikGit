package string;

public class ReverseString {
	
	public static void main(String[] args) {
		 
		String a ="Hello";
		String reverse ="";
		for (int i=a.length()-1;i>=0;i--)
		{
				reverse = reverse+a.charAt(i);
			System.out.println("Reverse of the string = "+reverse);
		}
		
		for(int i=0;i<a.length();i++)
		{
			char c= a.charAt(i);
			System.out.println("Sequence of the String is = "+c);
		}
		
		
		
		
		
		
	}

}
