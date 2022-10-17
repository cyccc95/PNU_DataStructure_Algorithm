import java.util.Scanner;
// 요솟수가 n인 배열 a에서 key와 값이 같은 요소를 보초법으로 선형 검색
public class SeqSearchSen {
    static int seqSearch(int[] x, int num, int key){
        int i = 0;

        x[num] = key;
        while (true){
            if (x[i] == key){
                break;
            }
            i++;
        }
        return i == num ? -1 : i;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num+1];

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

