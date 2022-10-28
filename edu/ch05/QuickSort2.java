// 퀵 정렬(비재귀 버전)
package ch05;

import java.util.Scanner;

public class QuickSort2 {

    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    //--- 퀵 정렬(비재귀 버전)---//
    static void quickSort(int[] a, int left, int right) {
    	
    	Stack st = new Stack(a.length);
    	Point p = new Point(left, right);
    	st.push(p);
    	while (st.isEmpty() != true) {
    		Point rt = st.pop();
    		int pl = rt.getX();
    		int pr = rt.getY();
    		int nextPl = pl;
    		int nextPr = pr;
    		int mp = a[(pr + pl)/2];
    		
	        do {
	        	while (a[pl] < mp) pl++;
	          	while (a[pr] > mp) pr--;
	          	if (pl <= pr)
	              swap(a, pl++, pr--);
	        } while (pl <= pr);
	        if (nextPl < pr) {
	        	Point pt2 = new Point(nextPl, pr);
	        	st.push(pt2);
		    }
		    if (pl < nextPr) {
		       	Point pt3 = new Point(pl, nextPr);
		    	st.push(pt3);
		    }
		}
		
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("배열의 크기 입력 : ");
    	int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
       	    double d = Math.random();
       	    a[i] = (int)(d* 20);
        }
        
        System.out.println("---정렬전---");
        for (int i = 0; i < n; i++)
            System.out.print(" " + a[i]);
        System.out.println();

        quickSort(a, 0, n - 1);            // 배열 x를 퀵정렬

        System.out.println("---정렬후---");
        for (int i = 0; i < n; i++)
            System.out.print(" " + a[i]);
    	}
}

