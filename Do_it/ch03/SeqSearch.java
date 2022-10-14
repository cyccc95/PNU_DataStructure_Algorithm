import java.util.Scanner;

public class SeqSearch {
    static int seqSearch(int[] x, int num, int key){
//        int i = 0;
//        while (true){
//            if(i == num){
//                return -1; // 검색 실패(-1 반환)
//            }
//            if (x[i] == key){
//                return i; // 검색 성공(인덱스 반환)
//            }
//            i++;
//        }
        for (int i = 0; i < num; i++){
            if (x[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num];

        // x 배열 입력
        for (int i = 0; i < num; i++){
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        // 키값 입력
        System.out.print("검색할 값: ");
        int key = sc.nextInt();

        int idx = seqSearch(x,num,key);

        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
