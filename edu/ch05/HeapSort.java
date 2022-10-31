package ch05;

public class HeapSort {
	
	static void makeHeap(int[] a, int count) {
		for(int i = 0; i < count; i++) {
			int j = i;
			while(j >= 0) {
				if(a[j] > a[(j - 1) / 2]) {
					swap(a, j, (j - 1) / 2);
				}
				j--;
			}
		}
		
	}
	
	static void useHeap(int[] a, int count) {
		while(count > 0) {
			swap(a, 0, count - 1);
			count--;
			makeHeap(a, count);
		}
	}
	
	static void swap(int[] a, int idx1, int idx2) {
	     int temp = a[idx1];  
	     a[idx1] = a[idx2];  
	     a[idx2] = temp;
	 }
	public static void main(String[] args) {
		 final int count = 10;
	     int[] a = new int[count];
//		 int[] a = {5,3,6,10,8,7,13,4};
//		 int count = a.length;
	     for (int i = 0; i < a.length; i++) {
	         a[i] = (int)(Math.random() * 30);
	     }
	     System.out.println("---정렬전---");
	     for (int i = 0; i < count; i++) {
	    	 System.out.print(" " + a[i]);
	     }
	     
	     makeHeap(a, count);
	     System.out.println();
	     System.out.println("---makeHeap---");
	     for (int i = 0; i < count; i++) {
	    	 System.out.print(" " + a[i]);
	     }
	     
	     useHeap(a, count);    // 배열 x를 힙정렬
	     System.out.println();
	     System.out.println("---useHeap---");
	     for (int i = 0; i < count; i++) {
	    	 System.out.print(" " + a[i]);
	     }
	}
	

}
