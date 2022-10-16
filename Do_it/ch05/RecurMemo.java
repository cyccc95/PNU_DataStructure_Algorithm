import java.util.Scanner;

public class RecurMemo {
    static String[] memo;

    static void recur(int x){
        if (memo[x + 1] != null){
            System.out.print(memo[x + 1]);
        } else {
            if (x > 0) {
                recur(x - 1);
                System.out.println(x);
                recur(x - 2);
                memo[x + 1] = memo[x] + x + "\n" + memo[x - 1];
            } else {
                memo[x + 1] = "";
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요.: ");
        int x = sc.nextInt();

        memo = new String[x + 2];
        recur(x);
    }
}
