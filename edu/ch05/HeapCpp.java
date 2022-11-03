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
    public void deleteMax();
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
            heapFull(); return;
        } else {
            n++;
        }
        for (int i = n; i >= 1; i /= 2) {
            heap[i] = key;
            if (i == 1) break; // at root
            if (key.compareTo(heap[i / 2]) < 1){
                break;
            }
            // move from parent to i
            heap[i] = heap[i / 2];
            heap[i / 2] = key;
        }
    }

    @Override
    public void deleteMax() {
        int i, j; // i parent, j child
        if (n == 0) {
            heapEmpty(); return;
        }
        Element temp = heap[1];
        heap[1] = heap[n];
        heap[n] = temp; n--;

        for (i = 1, j = 2; j <= n; ) {
            if (j <= n && heap[j].compareTo(heap[j + 1]) < 0) j++;
            // j points to the larger child
            if (j <= n && heap[i].compareTo(heap[j]) < 0) {
                temp = heap[j];
                heap[j] = heap[i];
                heap[i] = temp;
            }
            i = j; j *= 2;
        }
    }
    void display() {
        for(int i = 1; i <= n; i++){
            System.out.print(heap[i].getKey() + " ");
        }
    }
    void heapEmpty() {
        System.out.println("Heap Empty");
    }
    void heapFull() {
        System.out.println("Heap Full");
    }
}

public class HeapCpp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);

        while(true){
            System.out.println();
            System.out.print("(1) insert (2) delete (3) display (4) exit (입력) : ");
            int select = sc.nextInt();

            if(select == 4) break;
            switch (select){
                case 1:
                    System.out.print("insert : ");
                    int insert = sc.nextInt();
                    Element key = new Element(insert);
                    heap.insert(key);
                    break;
                case 2:
                    heap.deleteMax();
                    System.out.println();
                    break;
                case 3:
                    heap.display();
                    System.out.println();
                    break;
            }
        }

    }
}