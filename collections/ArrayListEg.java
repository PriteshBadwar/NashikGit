package collections;

import java.util.ArrayList;

import org.apache.xmlbeans.impl.xb.xsdschema.All;

public class ArrayListEg {

	public static void main(String[] args) {
		
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("pune");
		al.add("mumbai");
		al.add("banglore");
		al.add("nashik");
		System.out.println(al);
		
		al.set(1, "pune");
		System.out.println(al);
		ArrayList<String> al2 = new ArrayList<String>();
		al2.addAll(al);
		System.out.println(al2);
		al2.add("hydrabad");
		System.out.println(al2);
		
		
		
		
	}
}
