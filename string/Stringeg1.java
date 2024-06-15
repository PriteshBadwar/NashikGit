package string;

public class Stringeg1 {

	public static void main(String[] args) {
		
		   String aa ="Hello";
		   String reverse = "";
		   for(int i=aa.length()-1;i>=0;i--)
		   {
			    reverse = reverse+aa.charAt(i);
			    System.out.println("Reverse of the String is = "+reverse );
		   }
		   
		   for(int i=0;i<=aa.length();i++)
		   {
			   char c =aa.charAt(i);
			   System.out.println("Sequence is = "+c);
		   }
		
		
		
	}
}
