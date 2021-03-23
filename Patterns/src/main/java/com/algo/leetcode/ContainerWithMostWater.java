package com.algo.leetcode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long before = System.currentTimeMillis();
		int[] height= {1,8,6,2,5,4,8,3,7};
		//int ans=maxArea(height); 
		int ans=maxArea2(height);
		long after = System.currentTimeMillis(); 
		System.out.println("ans=" + ans);
		System.out.println("time="+(before-after)/1000.0000);
		
	}
	
	 public static int maxArea(int[] height) {
        int x=0, y=0, water=0; 
        while(x<=y && x<height.length-1){
            if(y==height.length){
                x++; y=x;
            }

            int area=(y-x)*Math.min(height[x], height[y]);	            
            water = Math.max(water, area);
            y++;
        }//while 
        
        return water;
	}

	 
	 public static int maxArea2(int[] height) {	        
         int x=0, y=height.length-1, water=0; 
         while(x<y && x<height.length-1){   
            int area=(y-x)*Math.min(height[x], height[y]);
            if(area>water) water=area;
            
            if(height[x]<height[y]){
                x++; 
            }else{
                y--; 
            }
        }//while 
        
        return water;
	}
}
