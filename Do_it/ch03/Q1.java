import java.util.Scanner;

public class Q1 {
    static int binSearchFor(int[] x, int num, int key){
        int start = 0; // 검색 범위의 첫 인덱스
        int end = num - 1; // 검색 범위의 끝 인덱스
        x[num] = key;
        int i;
        int mid = 0;

        for (i = 0; i < num; i++){
            mid = (start + end) / 2;
            if (x[mid] == key){
                break;
            } else if (x[mid] < key){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return i == num ? -1 : mid;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num+1];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: "); // 첫 요소 입력
        x[0] = sc.nextInt();

        for (int i = 1; i < num; i++){
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = sc.nextInt();
            } while(x[i] < x[i-1]); // 오름차순이 아니면 다시 입력
        }

        System.out.print("검색할 값: ");
        int key = sc.nextInt();

        int idx = binSearchFor(x,num,key);

        if (idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}

