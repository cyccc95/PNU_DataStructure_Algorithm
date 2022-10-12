import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        do {
            n = n/10;
            cnt++;
        } while(n > 0);

        System.out.println("n은 " + cnt + "자리입니다.");
    }
}
