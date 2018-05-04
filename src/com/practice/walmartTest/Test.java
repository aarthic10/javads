package com.practice.walmartTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String args[]){
		BigDecimal decimal = new BigDecimal(53.99);
		Double doube = decimal.doubleValue()*100;
		System.out.println(doube.intValue());
		
		Map<String,Integer> hm = new HashMap<String,Integer>();
		hm.entrySet().iterator();
		hm.put("key", 12);
		
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		
		
		Map<String, Integer> chm = new ConcurrentHashMap<String, Integer>();
		Iterator it = chm.entrySet().iterator();
		
	}
}
