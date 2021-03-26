package com.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {	
	public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        List<List<Integer>> ans = combinationSum2(candidates, 7); 
        System.out.println(ans.toString());
    }
	
	
	//A2.
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); 
        Arrays.sort(candidates); 
        comb(candidates, target, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    public static void comb(int[] candis, int target, int pivot, List<Integer> one, List<List<Integer>> ans){
        if(target<0){
            return;
        }else if(target==0){
            ans.add(new ArrayList<>(one));
            return; 
        }
            
        for(int i=pivot; i<candis.length; i++){
            if(candis[i]> target) return; 
            
            one.add(candis[i]);
            comb(candis, target-candis[i], i, one, ans);
            one.remove(one.size()-1); 
        }
    } 
    
    //A1.  
    /* public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); 
        
        Arrays.sort(candidates); 
         
        for(int i=candidates.length-1; i>=0; i--){
            makeSum(candidates, target, i, ans);
        }
        
        return ans;
    }//combinationSum 

    public static void makeSum(int[] candis, int target, int pivot, List<List<Integer>> ans){
        if(candis[pivot]>target) return;
        int x=pivot, y=pivot, sum=0; 
        
        //dfs 구문에서 new ArrayList<>() 선언 -> HeapMemory OOM 발생. 
        //int[] nums = new int[200]; 
        List<Integer> arr = new ArrayList<>(); 
        
        while(y<=x && x>=0 && y>=0){
            if(sum>target){
                sum-=candis[y];
                //nums[candis[y]]--; 
                arr.remove(arr.size()-1); 
                y--;
            }else if(sum==target){
                ans.add(arr); 
                
            }else{
                sum+=candis[y];  
                //nums[candis[y]]++; 
                arr.add(candis[y]); 
                System.out.println("y:"+y+" candis[y]:"+candis[y] +" sum:"+sum);
            }            
        }//while
    }//makeSum */ 
}
