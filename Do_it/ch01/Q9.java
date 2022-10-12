import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a값: "); int a = sc.nextInt();
        System.out.print("b값: "); int b = sc.nextInt();
        while(b <= a){
            System.out.println("a보다 큰 값을 입력하세요!");
            System.out.print("b값: ");
            b = sc.nextInt();
        }
        System.out.println("b-a는 " + (b-a) + "입니다.");
    }
}
