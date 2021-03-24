package com.algo.leetcode;

public class maximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {5,4,-1,7,8};
		//int ans=maxSubArray(nums);
		int ans=maxSubArray2(nums);
		System.out.println("ans:"+ans);
	}
	
	/* try 1: accepted
	 * runtime : 215ms, 5.07% faster than 
     * memory  : 39.3mb, 26.13% less than  
	 */
	public static int maxSubArray(int[] nums) {         
        if(nums.length==1) return nums[0];
        
        int x=0, y=0, sum=0, max=-100000; 
        while(x<=y && x<nums.length){
            if(y==nums.length){
                x++; y=x; sum=0; 
            }
            if(x==nums.length){
                break;
            }
            
            sum+=nums[y]; 
            y++; 

            if(sum>max) max=sum; 
        }
        
        return max;
	 }//maxSubArray

	/* try 2: accepted
	 * runtime : 0ms, 100% faster than 
     * memory  : 39.4mb, 20.90% less than  
	 * etc     : 답안 참고 
	 */
	public static int maxSubArray2(int[] nums) {
		int max=0, sum=0; 
		for(int i=0; i<nums.length; i++) {
			sum+=nums[i];
			max=Math.max(max, sum);
			if(sum<0) sum=0;
		}
		
		return max;
	}
}
