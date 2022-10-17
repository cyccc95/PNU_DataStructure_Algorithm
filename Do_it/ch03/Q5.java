import java.util.Scanner;

public class Q5 {
    static int binSearchX(int[] arr, int n, int key){
        int start = 0;
        int end = n - 1;
        int mid = 0;
        int i = 0;
        for (i = 0; i < n; i++){
            mid = (start + end) / 2;
            if (arr[mid] == key){
                break;
            } else if (arr[mid] < key){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        for (i = 0; i < mid; i++){
            if (arr[i] == key){
                mid = i;
                break;
            }
        }
        return i == n ? -1 : mid;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 크기 입력: "); int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("배열 입력: ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("검색할 key 값 입력: "); int key = sc.nextInt();

        int result = binSearchX(arr,n,key);
        if (result == -1){
            System.out.println("그 key 값은 없습니다.");
        } else {
            System.out.println("그 key 값은 arr[" + result + "]에 있습니다.");
        }
    }
}
