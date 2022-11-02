package ch05;

import java.util.Scanner;

class Element implements Comparable<Element>{
	private int key;

	public Element(int key) {
		this.key = key; 
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public int compareTo(Element o) {
		if (this.key < o.key) return -1;
		else if (this.key > o.key) return 1;
		else return 0;
	}

}

interface MaxPQ {
	public void insert(Element key);
	public Element deleteMax();
}

class MaxHeap implements MaxPQ {
	private Element[] heap;
	private int maxSize;	// Maximum allowable size of MaxHeap
	private int n;			// current size of MaxHeap
	
	public MaxHeap(int size) {
		maxSize = size;
		n = 0;
		heap = new Element[maxSize + 1]; // Don't want to use heap[0]
	}
	
	@Override
	public void insert(Element key) {
		if (n == maxSize) {
			HeapFull(); return;
		} else {
			n++;
		}
		for (int i = n; i >= 1; i /= 2) {
			if (i == 1) break; // at root
			if (key.compareTo(heap[i / 2]) < 1) break;
			// move from parent to i
			heap[i] = heap[i / 2];
			heap[i / 2] = key;
		}
	}
	
	@Override
	public void deleteMax() {
		int i, j;
		if (n == 0) {
			HeapEmpty(); return;
		}
		Element x = heap[1];
		Element k = heap[n]; n--;

		for (i = 1, j = 2; j <= n; ) {
			if (j < n) if (heap[j].key < heap[j + 1].key) j++;
			// j points to the larger child
			if (k.key >= heap[j].key) break;
			heap[i] = heap[j];
			i = j; j *= 2;
		}
		heap[i] = k;

	}
	void display() {
		int i;
		cout << "MaxHeap:: (i, heap[i].key): ";
		for (i = 1; i <= n; i++) cout << "(" << i << ", " << heap[i].key << ") ";
		cout << "\n";
	}
	void HeapEmpty() {
		System.out.println("Heap Empty");
	}
	void HeapFull() {
		System.out.println("Heap Full");
	}
}

public class HeapCpp {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			MaxHeap heap = new MaxHeap(100);  
			
//			MaxHeap heap(20);
//			Element<int> ele;
//			
//			Element<int>* deletedEle = nullptr;
//			
//			do {
//				cout << endl << "Max Tree. Select: 1 insert, 2 display, 3 delete, >=5 exit" << endl;
//				cin >> select;
//				switch (select) {
//				case 1:
//					cout << "input value: ";
//					cin >> data;
//					heap.Insert(Element<int>(data));
//					heap.display();
//					break;
//				case 2:
//					heap.display();
//					break;
//				case 3:
//					deletedEle = heap.DeleteMax(ele);
//					if (deletedEle != nullptr) {
//						cout << "deleted element: " << deletedEle->key << endl;
//					}
//					cout << "current max heap: " << endl;
//					heap.display();
//					break;
//				case 5:
//					exit(1);
//					break;
//					
//				}
//			} while (select < 5);
//			
//			return 0;
	}
}
