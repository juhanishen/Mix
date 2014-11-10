package org.juhani.fib;

import java.util.HashMap;


public class FibMain{

	private static HashMap<Integer,Integer> fibCache = new HashMap<>();
	
    public static void main(String[] args){
       int n=40;	
    	
       long startNormal = System.nanoTime();	
       int normalAlgorithm = fib(n);
	   System.out.println("sum of normal algorithm is:"+normalAlgorithm);
	   double durationNormal = ((double) (System.nanoTime()-startNormal)) /1000/1000;
	   System.out.println("normal algorithm duration is (milli seconds): "+durationNormal);
	   
	   long startEnhanced = System.nanoTime();	
       int enhancedAlgorithm = fibEnhanced(n);
	   System.out.println("sum of enhanced algorithm is:"+enhancedAlgorithm);
	   double durationEnhanced = ((double) (System.nanoTime()-startEnhanced)) /1000/1000;
	   System.out.println("enhanced algorithm duration is (milli seconds): "+durationEnhanced);
       
	   assert(normalAlgorithm == enhancedAlgorithm);
    }
    
    public static int fib(int n){    	
        if(n==0 ) {
        	return 1;
        }else if(n==1){
        	return 1;        	
        }
        return fib(n-1)+fib(n-2);
    }
    
    
    public static int fibEnhanced(int n){
    	if(n==0){
    		fibCache.put(0,1);
    		return 1;
    	}else if(n==1){
    		fibCache.put(1,1);
    		return 1;
    	}
    	if(fibCache.keySet().contains(n-2) && fibCache.keySet().contains(n-1)){
    		int sum = fibCache.get(n-2)+fibCache.get(n-1);
    		fibCache.put(n,sum);
    		return sum;
    	}else if(fibCache.keySet().contains(n-2) && (!fibCache.keySet().contains(n-1))){
    		int sum = fibCache.get(n-2)+fibEnhanced(n-1);
    		fibCache.put(n,sum);
    		return sum;     		
    	}else if(!fibCache.keySet().contains(n-2)){
    		int sum = fibEnhanced(n-2)+fibEnhanced(n-1);
    		fibCache.put(n,sum);
    		return sum;     		
    	}
    	return -1;
    }
}
    