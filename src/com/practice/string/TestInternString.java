package com.practice.string;
public class TestInternString {

    public static void main(String[] args) {
        //literal pool
    	String s1 = "Test";
        String s2 = "Test";
        
        //new object
        String s3 = new String("Test");
        
        //checks in pool and if object is there 
        //it will return existing object
        final String s4 = s3.intern();
        
        //Object Comparison
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        
        //String comparison
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s3.equals(s4));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s3));
    }

}
