import java.util.Scanner;

public class Q3 {
    static int gcd(int x, int y){
        if(y == 0){
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
    static int gcdArray(int[] a,int start, int n){
        if (n == 1){
            return a[start];
        } else if (n == 2) {
            return gcd(a[start], a[start + 1]);
        } else {
            return gcd(a[start], gcdArray(a, start + 1, n - 1));
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 크기 입력: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        System.out.println("배열 a 입력");
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println("배열 a의 모든 요소의 gcd는 " + gcdArray(a,0,n) + "입니다.");

    }
}
