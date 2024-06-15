package string;

public class MethodsofString {
	
	
	
	public static void main(String[] args) {
		// Methods of the String
		// 1.Length
		String s1 = "Hello";
		int length = s1.length();
		System.out.println(length);
		
		// 2.charAt  no
		char c = s1.charAt(3);
		System.out.println(c);
		
		// 3.equals
		String m1 = "Mumbai";
		String m2 = "mumabi";
		boolean b = m1.equals(m2);
		System.out.println(b);
		
		//4.equalsIgnoreCase
		boolean b1 = m1.equalsIgnoreCase(m2);
		System.out.println(b1);
		
		//5.lowerCase
		
		String s3 = "BanGloRe";
		String s4 = s3.toLowerCase();
		System.out.println(s4);
		
		// 6. Upper Case
		 String s5 = s3.toUpperCase();
		 System.out.println(s5);
		
		 //7.SubString,starting point only
		 
		 String s6 = "Ahemednagar";
		 String s7 = s6.substring(6);
		 System.out.println(s7);
		 
		 // 8.SubString   starting to end point ;
		 String s8 = "Banglore";
		 String s9 = s8.substring(0, 4);
		 System.out.println(s9);
		
		 // 9.Replace the char;
		 
		 String s10 = "Vishakaphatanam";
		 String s11 = s10.replace("a", "A");
		 System.out.println(s11);
		 
		 //10.Replace the String;
		 String s12 = "Ahemadabaad";
		 String s13 = s12.replace("Ahemada", "Auranga");
		 System.out.println(s13);
		 
		 //T11. Trim
		 
		 String s14 = "           Hello      World";
		 String s15 = s14.trim();
		 System.out.println(s15);
		 
		 //String Reverse
		 String s16 = "Hello";
		 String reverse = "";
		 for(int i=s16.length()-1;i>=0;i--)
		 {
			 reverse = reverse+s16.charAt(i);
			 System.out.println("Reverse of the string = "+reverse);
		  }
//		 //12.String in line
//		 for(int i=0; i<=s16.length();i++)
//		 {
//			char ch = s16.charAt(i);
//			System.out.println(ch);
//		 }
		 
		 //13.Index position
		 
		 String s17 = "qwertyu";
		 int s18 = s17.indexOf('q');
		 System.out.println(s18);
		 
	//	 14.Split.
		 String s19 = "This is String";
		 String[] s20 = s19.split(" ");
		 for(String ss:s20)
		 {
			 System.out.println(ss);
		 }
		 
		 //15.Starts With
		 
		 String s21 = "Denver";
		 boolean s22 = s21.startsWith("Den");
		 System.out.println(s22);
		
		 //16 Ends With 
		 boolean s23 = s21.endsWith("ver");
		 System.out.println(s23);
		
		 //17 change primttive into Non Primittive
		 
		 int s24 = 12;
		 String  s26 = String.valueOf(s24);
		 System.out.println(s26+2);
		 
		 //18.converting  Non Primittive into Primittive
		 String s27 = "60";
		 int s28 = Integer.parseInt(s27);
		 System.out.println(s28);
		 
		 //19.converting point value into integer
		 
		 String s29 = "54.44";
		  double s30 = Double.parseDouble(s29);
		 System.out.println(s30);
		 
		 //20.CharArray
		 String s31 = "Maharashtra";
		 char[] s32 = s31.toCharArray();
		 for(char cc:s32)
		 {
			System.out.println(cc); 
		 }
		//21 character is digit verify
		 
		 char s33 = '4';
		 boolean s34 = Character.isDigit(s33);
		 System.out.println(s34);
		 
		 //22.character is alphabetic .
		 
		 char s35 = 'r';
		 boolean s36 = Character.isAlphabetic(s35);
		 
		 System.out.println(s36);
		 
		 //23. Replace All
		 
		 String s37 = "Mahableshwar" ;
		 String s38 = s37.replaceAll("[A-Z]", "a");
		 System.out.println(s38);
		 
		 String s39 = "MahABlesHwaR";
		 String s40 = s39.replaceAll("[A-Z]","");
		 
		  System.out.println(s40);
		 
		 String s41 = "uuiy$r$f455f4@G%Y^U";
		 String s42 = s41.replaceAll("[^a-z]", "");
		 System.out.println(s42);
		 
		 String s43 = "A3cce#$n^tu)(3r(e";
		 String s44 = s43.replaceAll("[^A-Za-z]", "");
		 System.out.println(s44);
		   
		 
		
		
		
		
		
		
	}
	}
	
