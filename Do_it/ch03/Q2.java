import java.util.Scanner;

public class Q2 {
    static void print(int n, int[] arr, int key){
        System.out.print("  |");
        for (int i = 0; i < n; i++){
            System.out.printf("%2d",i);
        }
        System.out.print("\n--+");
        for (int i = 0; i < n; i++){
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < n; i++){
            System.out.print("  |");
            for (int j = 0; j < i; j++){
                System.out.print("  ");
            }
            System.out.println(" *");
            System.out.printf("%2d|",i);
            for (int j = 0; j < n; j++){
                System.out.printf("%2d",arr[j]);
            }
            System.out.println();
            if (arr[i] == key){
                System.out.println("그 값은 x[" + i + "]에 있습니다.");
                break;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 길이 입력
        System.out.print("배열의 길이 입력: ");
        int n = sc.nextInt();

        // 배열 생성
        int[] arr = new int[n];

        // 배열 입력
        System.out.println("배열 요소 입력하세요.");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // 찾을 값을 입력
        System.out.print("찾을 값 입력: ");
        int key = sc.nextInt();

        // 출력
        print(n, arr, key);
    }
}
