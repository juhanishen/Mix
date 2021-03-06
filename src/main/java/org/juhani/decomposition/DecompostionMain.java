/**
 * Given an Integer, for example, 11. A decompostion means sum of integer equal to the given
 * number. For example, give by 11, a couple of decompostion is as follows:
 *  11 = 1+10;
 *  11 = 11;
 *  11= 1+3+7;
 *  11=2+8+1;
 *  11 = 5+6;
 *    �
 * An order decompostion means all integer which sums equal to given number is odd number. 
 * For example, 
 *  11 = 1+3+7
 *  11 = 11;
 *  is two odd decompostion. The maximum number of integer is called maixmum odd decompostion.
 *  For example, 11=1+3+7 is maximum odd decompostion since it has 3 integers. 
 *  You are suppose to write a program as follows public int[] solution(int N), to return the 
 *  maximum odd decompostion. There could be several possible maximum odd decompostion, one only
 *  need to return one of them.
 */

package org.juhani.decomposition;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DecompostionMain {
	
	private LinkedHashMap<Integer,LinkedHashMap<Integer,ArrayList<Integer>>> decomp = new LinkedHashMap<>();
	
	public static void main(String[] args){
		new DecompostionMain().solution(5);
	}
	
	private int[] solution(int n){
		LinkedHashMap<Integer,LinkedHashMap<Integer,ArrayList<Integer>>> sol = decompSolution (n);
		dump(sol);
		return null;
	}
	
	private void dump(
		LinkedHashMap<Integer, LinkedHashMap<Integer, ArrayList<Integer>>> sol) {
		Set<Map.Entry<Integer, LinkedHashMap<Integer, ArrayList<Integer>>>> solSet = sol.entrySet();
		for(Map.Entry<Integer, LinkedHashMap<Integer, ArrayList<Integer>>> entry: solSet){
			int key=entry.getKey();
			System.out.println("xxxxKey is:"+key);
			Set<Map.Entry<Integer,ArrayList<Integer>>> combi = entry.getValue().entrySet();
			for(Map.Entry<Integer, ArrayList<Integer>> combin_entry:combi){
			   int combi_key = combin_entry.getKey();
			   System.out.print("----------combination "+combi_key+":");
			   for(Integer j : combin_entry.getValue()){
				   System.out.print(" "+j+", ");				   
			   }
			   System.out.println("");
			} 
		}
		
	}

	private LinkedHashMap<Integer,LinkedHashMap<Integer,ArrayList<Integer>>> decompSolution (int n){
		if(n==1){
			ArrayList<Integer> array = new ArrayList<>();
			array.add(1);
			LinkedHashMap<Integer,ArrayList<Integer>> combi = new LinkedHashMap<>();
            combi.put(1,array);
            decomp.put(1,combi);
            return decomp;
		}else if(n==2){
			ArrayList<Integer> array = new ArrayList<>();
			array.add(2);
			LinkedHashMap<Integer,ArrayList<Integer>> combi = new LinkedHashMap<>();
            combi.put(1,array);
            decomp.put(2,combi);
            return decomp;
			
		}else if(n==3){
			ArrayList<Integer> array = new ArrayList<>();
			array.add(3);
			LinkedHashMap<Integer,ArrayList<Integer>> combi = new LinkedHashMap<>();
            combi.put(1,array);
            ArrayList<Integer> array2 = new ArrayList<>();
			array2.add(1);
			array2.add(2);
            combi.put(2,array2);			
            decomp.put(3,combi);
            return decomp;		
		}
	
		LinkedHashMap<Integer,ArrayList<Integer>> combin=null;
		int setSize=0;
	    for(int i= (n/2+1);i<n;i++){
	    	combin = decompSolution(i).get(i);
	    	Set<Map.Entry<Integer, ArrayList<Integer>>> mapSet = combin.entrySet();
            for(Map.Entry<Integer, ArrayList<Integer>> entry:mapSet ){
            	entry.getValue().add(n-i);
            	setSize ++;
            }    
	    }
		
	    ArrayList<Integer> array = new ArrayList<Integer>();
	    array.add(n);
	    combin.put(setSize++,array);
	    decomp.put(n, combin);
		return decomp;
	}
	
	
}
