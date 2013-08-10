/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

 * Note:

 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
 * The solution set must not contain duplicate triplets.
 *   For example, given array S = {-1 0 1 2 -1 -4},

 *   A solution set is:
 *   (-1, 0, 1)
 *   (-1, -1, 2)
 */
package info.mitcc.leetcode;

import java.util.*;

public class ThreeSum {
	/*public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 2; i++) {
        	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        	for(int j = i + 1; j < num.length; j++) {
        		if(map.containsKey(num[j])) {
        			int index = map.get(num[j]);
        			if(index < j) {
        				ArrayList<Integer> list = new ArrayList<Integer>();
        				list.add(num[i]);
        				list.add(num[index]);
        				list.add(num[j]); 
        				Collections.sort(list);
        				if(!result.contains(list)) 
        					result.add(list);
        			}
        		}
        		if(!map.containsKey(num[j]))
        			map.put(0 - num[i] - num[j], j);
        	}
        }
        return result;
    }*/
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length<3){
            return output;
        }
        HashSet<ArrayList<Integer>> pairsFound = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            ArrayList<ArrayList<Integer>> result = twoSum(num, 0-num[i]);
            for(ArrayList<Integer> pair:result){
                if(pair.get(0)!=i && pair.get(1)!=i){
                    int[] temp = new int[3];
                    temp[0] = i;
                    temp[1] = pair.get(0);
                    temp[2] = pair.get(1);
                    Arrays.sort(temp);
                    ArrayList<Integer> newTriple = new ArrayList<Integer>();
                    for(int j=0;j<temp.length;j++){
                        newTriple.add(num[temp[j]]);
                    }
                    if(!pairsFound.contains(newTriple)){
                        pairsFound.add(newTriple);
                        output.add(newTriple);
                    }
                }
            }
        }
        return output;
    }
 
    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int sum){
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        int j = num.length-1;
        while(i<j){
            if(num[i]+num[j]==sum){
                ArrayList<Integer> newPair = new ArrayList<Integer>();
                newPair.add(i);
                newPair.add(j);
                output.add(newPair);
                i++;
                j--;
            }else if(num[i]+num[j]>sum){
                j--;
            }else{
                i++;
            }
        }
        return output;
    }
    
	public static void main(String[] args) {
		int[] s = {-2, 0, 1, 1, 2};
		System.out.println(new ThreeSum().threeSum(s));
	}
}