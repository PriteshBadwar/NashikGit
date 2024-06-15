package practice;

public class ReplceString {
public static void main(String[] args) {
	
	
	String s= "Maharashtra";
	String t = s.replace('a', 'A');
	System.out.println(t);
	
	
	String s1 = "Ahemadabaad";
	String t1 = s1.replaceAll("Ahemad", "Hyder");
	System.out.println(t1);
	
	String s2 = "This is String";
	String[] t2 = s2.split(" ");
	for(String t22:t2) {
	System.out.println(t22);
	}
	
	String s3 = "Maharashtra";
	char [] c = s3.toCharArray();
	for (char cc:c)
	{
		System.out.println(cc);
	}
	String s4 = "60";
	int t4 = Integer.parseInt(s4);
	System.out.println(t4);
	
	int s5  = 60;
	String t5  = String.valueOf(s5);
	System.out.println(t5);
	
	String s6 = "34.43";
	double t6 = Double.parseDouble(s6);
	System.out.println(t6);
	
	
	char a = '2';
	boolean  a1 = Character.isDigit(a);
	System.out.println(a1);
	
	char b = 'e';
	boolean b1 = Character.isAlphabetic(b);
	System.out.println(b1);
	
	String s8 = "Mahabaleshwar";
	String t8 =s8.replaceAll("[A-Z]", "a");
	System.out.println(t8);
	
	
}

}
