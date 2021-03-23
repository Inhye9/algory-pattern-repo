package com.algo.leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long before = System.currentTimeMillis();
		
		//String s = "babad";
		String s = "cbbd";
		//String s= "aacabdkacaa";
		
		//String res = longestPalindrome(s);
		//String res = longestPalindrome2(s); 
		String res = longestPalindrome3(s);
		
		long after = System.currentTimeMillis(); 
		System.out.println("ans=" + res);
		System.out.println("time="+(before-after)/1000.0000);

	}
	
	//try 1 
    public static String longestPalindrome(String s) {
        if(s.length()==1) return s;
            
        int x=0, y=s.length()-1; 
        int[] point = {-1,-1}; 
        
        while(x<=y && x<s.length()-1){
            if(s.charAt(x)==s.charAt(y)){        
                if(point[0]<0) point[0]=x; 
                if(point[1]<0) point[1]=y; 
                x++; y--;
            }else {
            	if(x==y-1) {
            		x++; y=s.length()-1;
            	} else {
            		y--; 
            	}
            	
            	point[0]=-1;
                point[1]=-1;
            }
        }
        
        if(point[0]==-1) return s.substring(0,1); 
        else 
            return s.substring(point[0], point[1]+1);
    }
    
    
    
    //try 2 
    //substring으로 짤라서 x:0->s.length(), y:s.length()->0; 
    //Wrong Answer: "bacabab"-> expected: "bacab"/output :"aca" 
    public static String longestPalindrome2(String s) {
        String ans="";  
        if(s.length()==1) return s;
        
        
        for(int i=0; i<s.length(); i++){
            String sa=findLongest(s.substring(i, s.length())); 
            if(sa.length()>ans.length()) ans=sa;
        }
        
        return ans;
    }
    
    
    public static String findLongest(String s){
        int x=0, y=s.length()-1; 
        int[] point = {-1, -1}; 
        
        while(x<y){
            if(s.charAt(x)==s.charAt(y)){
                if(point[0]<0) point[0]=x; 
                if(point[1]<0) point[1]=y; 
                x++; y--; 
            }else{
                y--; x=0;
                point[0]=-1; 
                point[1]=-1; 
            }
        }
        
        if(point[0]<0) return s.substring(0,1);
        else 
            return s.substring(point[0], point[1]+1); 
    }

    
    //try 3 
    //중심점을 주고 비교하기. 
    //start, end 계산하는 부분에서 시간이 많이 걸렸다.
    public static String longestPalindrome3(String s) {
       if(s==null || s.length()<1) return "";

       int start=0, end=0; 
       int size1=0, size2=0, size=0;         
        
       for(int i=0; i<s.length(); i++){
           size1=findLongest3(s, i, i); 
           size2=findLongest3(s, i, i+1); 
           
           size=Math.max(size1, size2); 
             
           if(size>end-start){
               start=i-(size-1)/2; 
               end=i+size/2; 
           }
       }
       
       return s.substring(start, end+1);
       
    }
   
    public static int findLongest3(String s, int x, int y){
       //int initx = x;
       while(x<=y && x>=0 && y<s.length()){
           if(s.charAt(x)==s.charAt(y)){
               x--; y++;
           }else{
               break; 
           }
       }
       
       return y-x-1; 
    }//findLongest
      
}
