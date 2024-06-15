package string;

public class Eg4 {
	public static void main(String[] args) {
		
		String s ="Hello";
		String reverse = "";
		for(int i=s.length()-1;i>=0;i--)
		{
			reverse = reverse+s.charAt(i);
			System.out.println(reverse);
		}
		System.out.println("***********************");
		for(int i=0;i<=s.length();i++)
		{
			char c = s.charAt(i);
			System.out.println(c);
		}
		
		
		
		
		
		
	}
}
