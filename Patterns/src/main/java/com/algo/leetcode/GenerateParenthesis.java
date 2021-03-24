package com.algo.leetcode;

import java.util.*; 

public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis gp = new GenerateParenthesis(); 
		List<String> list=gp.generateParenthesis(3);
		System.out.println(list.toString());
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>(); 
        makeParenthesis(new char[n*2], 0, ans); 
        return ans;
        
    }
    
    public void makeParenthesis(char[] par, int index, List<String> ans){
        if(index==par.length){
            if(checkParenthesis(par)){
                ans.add(new String(par));
                //return ans;
            }
        }else{
           par[index]='('; 
           makeParenthesis(par, index+1, ans); 
           par[index]=')'; 
           makeParenthesis(par, index+1, ans);    
        }
    }
    
    public boolean checkParenthesis(char[] par){
        int sum=0; 
        for(int i=0; i<par.length; i++){
            if(par[i]=='(') sum+=1; 
            else sum+=-1;
            if(sum<0) return false;
        }
        
        return sum==0; 
    }

}
