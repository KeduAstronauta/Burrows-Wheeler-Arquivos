package burrowarquivos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class BurrowWheeler {
	
	public static String transformViaSa(String msg) {
		String result = "";
		ArrayList<Integer> arr = suffixArray(msg);
		
		for(int e : arr) {
			int idx = e -1;
			if(idx < 0) {
				idx = idx + msg.length();
			}
			result += msg.charAt(idx);
		}
		
		return result;
	}
	
	public static String reverseBWT(String msg) {
		ArrayList<Integer> r = new ArrayList<>();
		TreeMap<Character,Integer> t = new TreeMap<>();
		buildRanks(t, r, msg);
		
		String result = "$";
		int idx = 0;
		while(msg.charAt(idx) != '$') {
			char c = msg.charAt(idx);
			result = c + result;
			idx = t.get(c) + r.get(idx);
		}
		
		return result;
	}
	
	private static void buildRanks(TreeMap<Character,Integer> letter_idx, ArrayList<Integer> ranks, String msg) {
		TreeMap<Character, Integer> letter_count = new TreeMap<>();
		char[] cs = msg.toCharArray();
		for(Character c : cs) {
			if(!letter_count.containsKey(c)) letter_count.put(c, 0);
			ranks.add(letter_count.get(c));
			letter_count.replace(c, letter_count.get(c)+1);
		}
		
		Character last_c = null;
		Iterator<Character> i = letter_count.navigableKeySet().iterator();
		while(i.hasNext()) {
			Character c = i.next();
			if(last_c == null) {
				letter_idx.put(c, 0);
			} else {
				letter_idx.put(c, letter_count.get(last_c)+letter_idx.get(last_c));
			}
			last_c = c;
		}
	}
	
	private static ArrayList<Integer> suffixArray(String msg) {
		ArrayList<Pair> aux = new ArrayList<>();
		for(int i = 0; i<msg.length(); i++) {
			aux.add(new BurrowWheeler.Pair(msg.substring(i), i));
		}
		Collections.sort(aux);
		
		ArrayList<Integer> result = new ArrayList<>();
		for(Pair p : aux) {
			result.add(p.i);
		}
		return result;
	}
	
	// Classe auxiliar
	private static class Pair implements Comparable<Pair>{
		public String c;
		public Integer i;
		
		public Pair(String c, Integer i) {
			this.c = c;
			this.i = i;
		}
		
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.c.compareTo(o.c);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.c + " : " + this.i;
		}
	}
	
	public static void main(String[] args) {
		String msg = BurrowWheeler.transformViaSa("Tomorrow_and_tomorrow_and_tomorrow$");
		System.out.println(msg);
		msg = BurrowWheeler.reverseBWT(msg);
		System.out.println(msg);
		
//		System.out.println(bw.transformViaSa("Tomorrow_and_tomorrow_and_tomorrow$"));
//		System.out.println(bw.transformViaSa("banana$"));
//		System.out.println(bw.transformViaSa("abracadabra$"));
//		System.out.println(bw.suffixArray("banana$"));
	}
}
