package com.clinicia.clinic.controllers;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

	
    static int twoCharaters(String s) {
        List<Character> distiinctChars = getDistinctChars(s);
        int maxResult = 0 ;
        for(int i = 0 ; i < distiinctChars.size() ; i++)
        {
        	for(int j = i+1 ; j < distiinctChars.size() ; j++)
        	{
        		String result =  removeOtherChars(s,distiinctChars.get(i), distiinctChars.get(j));
        		if(maxResult < result.length() && isValid(result) )
        		{
        			maxResult = result.length() ;
        		}
        	}
        }
    	return maxResult;
        
    }
    
    private static boolean isValid(String s)
    {
    	for(int i = 1 ; i < s.length(); i++)
    	{
    		if(s.charAt(i-1) == s.charAt(i))
    		{
    			return false ;
    		}
    	}
    	return true ;
    }
    
    static List<Character> getDistinctChars(String string)
    {
    	List<Character> charList = new ArrayList<>();
    	for(int i = 0 ; i < string.length() ; i++)
    	{
    		if(!charList.contains(string.charAt(i))){
    			charList.add(string.charAt(i));
    		}
    	}
    	return charList;
    }
    static String removeOtherChars(String s , Character c1 , Character c2)
    {
    	StringBuffer strBuffer = new StringBuffer();
    	for(int i = 0 ; i < s.length() ;i++)
    	{
    		if(s.charAt(i) == c1 || s.charAt(i) == c2 )
    		{
    			strBuffer.append(s.charAt(i));
    		}
    	}
    	return  strBuffer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharaters(s);
        System.out.println(result);
        in.close();
    }
}
