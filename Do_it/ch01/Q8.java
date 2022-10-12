package ch01;

import java.util.Scanner;

public class Q8 {
	static int sumof(int a, int b) {
		int min, max;
		if(a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		
		int sum = 0;
		for(int i = a; i <= b; i++) {
			sum += i;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.printf("%d부터 %d까지의 합은 %d입니다.",a,b,sumof(a,b));
	}
}
