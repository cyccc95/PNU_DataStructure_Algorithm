import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    static void searchIdx(int[] a, int n, int key){
        int count = 0;
        for (int i = 0; i < n; i++){
            if (a[i] == key){
                count++;
            }
        }
        int[] idx = new int[count];
        int j = 0;
        for (int i = 0; i < n; i++){
            if (a[i] == key){
                idx[j] = i;
                j++;
            }
        }
        System.out.println(Arrays.toString(idx));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("배열 a의 크기를 입력하세요: "); int n = sc.nextInt();

        int[] a = new int[n];
        System.out.println("배열 a를 입력하세요.");
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println("배열 a 출력");
        System.out.println(Arrays.toString(a));

        System.out.print("검색할 key 값을 입력하세요: "); int key = sc.nextInt();

        System.out.println("idx 출력");
        searchIdx(a,n,key);


    }
}
