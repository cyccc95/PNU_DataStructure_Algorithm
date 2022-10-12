package ch01;

public class Q5 {
	static int med3(int a, int b, int c) {
		if((b >= a && c <= a) || (b <=a && c>= a)) {
			return a;
		} else if((a > b && c < b) || (a < b && c > b)) {
			return b;
		} else {
			return c;
		}
	}
}

// or 연산자를 기준으로 뒤집은 판단(동일한 판단)이
// 반복되어 효율이 나빠진다.
