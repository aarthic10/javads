package com.practice.drishticon.test.top30Array.javarevisited;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class removeDuplicatesInPlace {

	public static void main(String args[]){
		System.out.println("Length of new array is "+removeDuplicates(new int[]{2,3,6,6,8,9,10,10,10,12,12}));
	}

	private static int removeDuplicates(int[] arr){
		int i=0;
		int j=1;
		while(i<arr.length && j<arr.length){
			if(arr[i]==arr[j]){
				j++;
			}else{
				arr[++i] = arr[j++];
			}
		}
		Integer intArray[] = {2,3,1};
		Arrays.sort(intArray, new removeDuplicatesInPlace.Sort());
		
		/*Vector<String> v = new Vector<String>();
		v.add("1");
		v.add("2");
		
		Enumeration<String> en = Collections.enumeration(v);
		while(en.hasMoreElements()){
			en.nextElement();
			v.add("3");
		}*/
		
		Map<String,String> mp = new TreeMap<String,String>();
		
		mp.put(new String("a"), null);
		Collections.unmodifiableMap(mp);
		mp.put(new String("a"), null);
		
		
		/*Map<String,String> ht = new Hashtable<String,String>();
		ht.put(null, "c");*/
		//ht.put(null, null);
		
	/*	List<String> a = new CopyOnWriteArrayList<String>();
		a.add("1");
		Iterator<String> itr = a.iterator();
		while(itr.hasNext()){
			itr.next();
			a.add("2");
		}*/
		
		Set s = new HashSet();
		s.add("1");
		s.add(2);
		s.add("null");
		s.add("null");
		
		
		/*TreeSet<String> h = new TreeSet<String>();
		h.add(null);*/
		return i;
		
	}
	
	
	static class Sort implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
		
	}
}
