package com.sort;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		//1. 선택 정렬 
		//selectsorting(arr);
		
		//2. 버블 정렬 
		//bubblesorting(arr);
		
		//3.삽입 정렬
		//insertsorting(arr);
	
		//4.퀵 정렬 
		int[] ans=quicksorting(arr, 0, arr.length-1);
		for(int n : ans) {
			System.out.print(n+ " ");
		}
	}
	
	//4. 퀵 정렬 
	//start: 정렬 수행하는 부분 집합의 첫번째 
	//end  : 정렬 수행하는 부분 집합의 마지막.
	static int[] quicksorting(int[] arr, int start, int end) {
		//원소가 1개인 경우에는 그대로 둔다. 
		if(start>=end) return arr; 
		
		int pivot=start, i=start+1, j=end, temp;  
		
		//i>j로 엇갈릴 때 까지 반복한다. 
		while(i<=j) {
			//start-> end 방향, 키 값보다 큰 값을 만날 때 까지 실행. 
			while(i<=end && arr[i]<=arr[pivot]) i++; 
			//end -> start 방향, 키 값보다 작은 값 만날 때 까지 실행. 
			while(j>start && arr[j]>=arr[pivot]) j--; 
		
			if(i>j) { //엇갈린 상태면 i<->pivot값 교체
				temp=arr[i];
				arr[i]=arr[pivot];
				arr[pivot]=temp; 
			}else {   //엇갈린 상태 아니라면 i<->j 교체 
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}//while(i<=j) 
		
		quicksorting(arr, start, j-1);  //pivot을 기준으로 오른쪽 부분 집합 정렬 수행
		quicksorting(arr, j+1, end);    //pivot을 기준으로 왼쪽 부분 집합 정렬 수행. 
	
		return arr;
	}
	
	//3. 삽입 정렬
	static void insertsorting(int[] arr) {
		int i, j, temp; 
		for(i=0; i<arr.length-1; i++) {
			j=i; //기준점 설정 
			while(j>=0 && arr[j]>arr[j+1]) {
				temp=arr[j+1];
				arr[j+1]=arr[j]; 
				arr[j]=temp;
				j--; 
			}
		}
		
		for(int n: arr) {
			System.out.print(n+" ");
		}
		return;
	}
	
	///2. 버블 정렬 
    static void bubblesorting(int[] arr) {
		int i, j, temp; 
		
		//arr.length-1-j인 이유는 제일 마지막 수는 그 뒤의 수 고려. 
		for(i=0; i<arr.length; i++) {
			for(j=0; j<arr.length-1-i; j++) {
				if(arr[j+1]<arr[j]) {
					temp=arr[j+1]; 
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}//j
		}//i
		
		for(int n : arr) {
			System.out.print(n+" ");
		}
		
		return; 
	}
   
	//1. 선택 정렬 
	static void selectsorting(int[] arr) {
		int i, j, min, temp, index; 
		
		for(i=0; i<arr.length; i++) {
			//min=임의값
			min=9999; 
			index=0;
			//최소값 구하기
			for(j=i; j<arr.length; j++) {
				if(arr[j]<min) {
					min=arr[j]; 
					index=j; 
				}
			}//j
			
			temp=arr[i]; 
			arr[i]=arr[index]; 
			arr[index]=temp;
		}//i
		
		for(int n: arr) {
			System.out.print(n+" ");
		}
		
		return; 
	}

}
