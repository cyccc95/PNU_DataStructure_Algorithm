import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] arr = new int[num];

        System.out.print("배열 입력: ");
        for (int i = 0; i < num; i++){
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        System.out.print("검색할 값: ");
        int key = sc.nextInt();

        int idx = Arrays.binarySearch(arr,key);

        if(idx < 0){
            System.out.println("그 값의 요소가 없습니다. 삽입 포인트의 idx: " + idx);
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
