package com.algo.leetcode;

public class minimumPathSum {
	//A2. dp + recursion 
	public static int[][] val;
    public static int minPathSum2(int[][] grid) {
       val = new int[grid.length][grid[0].length]; 
       
       int min= recursion(grid, grid.length-1, grid[0].length-1); 
       return min;
        
    }
    
    private static int recursion(int[][] grid, int x, int y){
        if(x==0 && y==0) return grid[0][0]; 
        if(val[x][y]!=0) return val[x][y]; 
        
        if(x==0){
            val[0][y]= grid[0][y] + recursion(grid, 0, y-1); 
            return val[0][y];
        }

        if(y==0){
            val[x][0]= grid[x][0] + recursion(grid, x-1, 0);
            return val[x][0]; 
        }

        val[x][y]= grid[x][y] + Math.min(recursion(grid, x-1, y), recursion(grid, x, y-1));  
        return val[x][y]; 
    }
	
	
	//A1. recursion: Time limit exceeded 
	public static int min; 
    public static int minPathSum1(int[][] grid) {
        min=100000; 
        pathdfs(grid, 0, 0, 0); 
        return min;
    }
    
    private static void pathdfs(int[][] grid, int x, int y, int sum){
        if(sum>min) return; 
        
        if(x==grid.length-1 && y==grid.length-1){
            sum+=grid[x][y]; 
            min=Math.min(sum, min); 
            return; 
        }
        else if(x<grid.length && y<grid[0].length){
            sum+=grid[x][y];
            
            pathdfs(grid, x+1, y, sum); 
            pathdfs(grid, x, y+1, sum);
        }
    }
    
    public static void main(String[] args){
        //int[][]grid = {{1,3,1},{1,5,1},{4,2,1}}; 
        //int[][] grid = {{1,2,3},{4,5,6}};
        int[][] grid={{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}};
        int ans=minPathSum2(grid); 
        System.out.println("ans: "+ans); 
    }
}
