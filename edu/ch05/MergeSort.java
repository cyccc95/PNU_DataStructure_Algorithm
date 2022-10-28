package ch05;

import java.util.Scanner;

public class MergeSort {
	private static int[] sorted; // 합치는 과정에서 정렬하여 원소를 담을 임시 배열
	
	static void mergeSort(int[] arr) {
		sorted = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1);
		sorted = null;
	}
	
	static void mergeSort(int[] a, int left, int right) {
		if(left == right) return;
		// left == right, 부분 리스트가 1개의 원소만 가지면
		// 더이상 쪼갤 수 없으므로 return
		
		int mid = (left + right) / 2; // 중간 위치
		
		mergeSort(a, left, mid); // 절반 중 왼쪽 부분리스트(left ~ mid)
		mergeSort(a, mid + 1, right); // 절반 중 오른쪽 부분리스트(mid + 1 ~ right)
		
		merge(a,left,mid,right);	// 병합 작업
	}
	
	static void merge(int[] arr, int left, int mid, int right) {
		int l = left; // 왼쪽 부분리스트 시작점
		int r = mid + 1; // 오른쪽 부분리스트 시작점
		int idx = left;	// 채워넣을 배열의 인덱스
		
		while(l <= mid && r <= right) {
			if(arr[l] <= arr[r]) {	// 왼쪽 부분리스트가 오른쪽보다 작을 경우
				sorted[idx] = arr[l];
				idx++; l++;
			} else {				// 오른쪽이 더 작을 경우
				sorted[idx] = arr[r];
				idx++; r++;
			}
			
		}
		if(l > mid) {	// 왼쪽 부분리스트가 먼저 다 채워지고 오른쪽만 남은 경우
			while(r <= right) {
				sorted[idx] = arr[r];
				idx++; r++;
			}
		} else {		// 오른쪽 부분리스트가 먼저 다 채워지고 왼쪽만 남은 경우
			while(l <= mid) {
				sorted[idx] = arr[l];
				idx++; l++;
			}
		}
		for(int i = left; i <= right; i++) { // 정렬된 배열을 기존의 배열에 복사
			arr[i] = sorted[i];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 크기 입력 : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < arr.length; i++) {
			double d = Math.random();
			arr[i] = (int)(d * 20);
		}
		
		System.out.println("---정렬전---");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();

		mergeSort(arr);
		
		System.out.println("---정렬후---");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}

}
