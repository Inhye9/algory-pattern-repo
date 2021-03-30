package com.algo.leetcode;

public class rotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = {{1,2}, {3,4}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; 
		//int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
	    //int[][] matrix={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		rotate(matrix); 
		for(int[] m : matrix) {
			for(int mm : m) {
				System.out.println(mm+" ");
			}
			System.out.println();
		}
		
	}
	
	
	public static void rotate(int[][] matrix) {
        int n=matrix.length; 

        System.out.println("n/2: "+n/2);
        System.out.println("(n+1)/2: "+(n+1)/2);
        
        //A2.
        for(int i=0; i<(n+1)/2; i++){
            for(int j=0; j<n/2; j++) {
            	System.out.println("i:"+i +" j:"+j);
               int temp = matrix[i][j];
               matrix[i][j] = matrix[n-1-j][i]; 
               matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; 
               matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
               matrix[j][n-1-i] = temp;       
            }
        }
        
        //A1.
        /*if(matrix.length==2) {
        	int temp = matrix[0][0];
        	matrix[0][0] = matrix[1][1]; 
        	matrix[1][1] = temp; 
        	
        	temp = matrix[0][1];
        	matrix[0][1] = matrix[1][0];
        	matrix[1][0] = temp;
        }else {
        	for(int i=0; i<n/2; i++){
                //for(int j=i; j<(n-i)/2)+1; j++){
                for(int j=i; j<n/2+1; j++) {
        		   System.out.println("i:"+i +" j:"+j);
                   int temp = matrix[i][j];
                   matrix[i][j] = matrix[n-1-j][i]; 
                   matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; 
                   matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                   matrix[j][n-1-i] = temp;       
                }
            }
        }*/
         
        
    }

}
