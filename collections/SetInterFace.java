package collections;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.TreeSet;

public class SetInterFace {

	public static void main(String[] args) {
		
		HashSet<Integer> hsi = new HashSet<Integer>();
		hsi.add(50);
		hsi.add(70);
		hsi.add(12);
		hsi.add(100);
		hsi.add(null);
		System.out.println(hsi);
		
		LinkedHashSet<Integer> lhsi = new LinkedHashSet<Integer>();
		
		lhsi.add(50);
		lhsi.add(70);
		lhsi.add(12);
		lhsi.add(100);
		lhsi.add(null);
		System.out.println(lhsi);
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		ts.add(50);
		ts.add(70);
		ts.add(12);
		ts.add(100);
	    ts.add(89);
	    System.out.println(ts);
		
		NavigableSet<Integer> dec = ts.descendingSet();
		System.out.println(dec);
		
	}
	
}
