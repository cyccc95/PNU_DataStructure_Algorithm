package ch05;

import java.util.Scanner;

public class QuickSort {
	// 배열 요소 a[idx1]와 a[idx2]의 값을 교환
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	// 퀵 정렬
	static void quickSort(int[] x, int left, int right) {
		int pl = left; 				// 왼쪽 커서
		int pr = right;				// 오른쪽 커서
		int p = x[(pl + pr) / 2];	// 피벗(가운데 요소)
		
		do {
			while(x[pl] < p) pl++; // 피벗보다 앞에 있는데 피벗보다 작으면 교환을 안하고 커서++
			while(x[pr] > p) pr--; // 피벗보다 뒤에 있는데 피벗보다 크면 교환을 안하고 커서--
			if(pl <= pr)
				swap(x,pl++,pr--); // 교환하고 커서 이동
		} while(pl <= pr);
		
		if(left < pr) quickSort(x,left,pr);
		if(pl < right) quickSort(x,pl,right);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이 입력 : ");
		int n = sc.nextInt();
		int[] x = new int[n];
		for(int i = 0; i < n; i++) {
			double d = Math.random();
			x[i] = (int)(d * 20);
		}
		System.out.println("---quick 정렬전---");
		for(int i = 0; i < n; i++) {
			System.out.print(" " + x[i]);
		}
		System.out.println();
		
		quickSort(x,0,n-1);
		
		System.out.println("---quick 정렬후---");
		for(int i = 0; i < n; i++) {
			System.out.print(" " + x[i]);
		}
	}

}
