package org.juhani.fib;


public class FibMain{

    public static void main(String[] args){
    	
       long start = System.nanoTime();	
	   System.out.println("sum is:"+fib(40));
	   double duration = ((double) (System.nanoTime()-start)) /1000/1000;
	   System.out.println("duration is (milli seconds): "+duration);
    }
    
    public static int fib(int n){    	
        if(n==0 ) {
        	return 1;
        }else if(n==1){
        	return 1;        	
        }
        return fib(n-1)+fib(n-2);
    }
    
}
    