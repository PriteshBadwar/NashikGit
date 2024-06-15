package collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ConversionofArrayintoArrayList {
public static void main(String[] args) {
	
	String a[] = new String[5];
	
	a[0] = "pune";
	a[1] = "mumbai";
	a[2] = "banglore";
	a[3] = "nashik";
	
	ArrayList<String> al = new ArrayList<String>(Arrays.asList(a));
	System.out.println(al);
	
	
	String [] b = new String [5];
	
	al.toArray(b);
	
	for(String bb:b)
	{
		System.out.println(bb);
	}
	
	
	
	
	
}
}
