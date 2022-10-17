import java.util.Scanner;

class RecurCount {

    static int count;

    //--- 재귀 메서드 ---//
    static void recur(int n) {
        count++;
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur(x);

        System.out.println("메서드를 호출한 회수 : " + count);
    }
}

