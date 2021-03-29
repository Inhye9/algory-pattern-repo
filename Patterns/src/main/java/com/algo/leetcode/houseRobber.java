package com.algo.leetcode;

public class houseRobber {
    public static void main(String[] args){
        int[] nums={4,1,2,7,5,3,1}; 
        long before=System.currentTimeMillis(); 
        //int[] nums={183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211}; 
        //int ans=rob1(nums);
        int ans=rob(nums);
        long after=System.currentTimeMillis(); 
        System.out.println("ans:"+ ans +" | time:"+(after-before)%1000.00);
    }
    
    //A2. dynamic programming: accepted 
    public static int rob(int[] nums) {
        if(nums.length==0){
            return 0; 
        }else if(nums.length==1){
            return nums[0]; 
        }else if(nums.length==2){
            return Math.max(nums[0], nums[1]); 
        }else{
            int[] dp = new int[nums.length];
            int pre  = nums[0];
            int cur  = Math.max(nums[0], nums[1]); 
            int temp = 0; 
            for(int i=2; i<nums.length; i++){
                temp = Math.max(pre+nums[i], cur); 
                pre  = cur; 
                cur  = temp; 
            }
            
            return cur;
        }
    }

    //A1. dfs: Time Limit Exceeded 
    public static int rob1(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
     
        int sum1=robbing(nums, 0, 2); 
        int sum2=robbing(nums, 1, 2);
     
        return Math.max(sum1, sum2);
     }
     
     private static int robbing(int[] nums, int start, int gap){
         if(start>nums.length-1) return 0;
         int max=0;
         int sum=0; 
         for(int g=gap; g<nums.length; g++){
              System.out.println("start:"+start+" nums[start]:"+nums[start]+" | gap:"+gap);
              sum=nums[start]+robbing(nums, start+g, 2);
              if(sum>max) max=sum; 
         }        
             
         System.out.println(" max:"+max);
         return max;
     }
}
