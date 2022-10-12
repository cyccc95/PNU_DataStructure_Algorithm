import java.util.Scanner;

public class Q14 {
    static void triangleLB(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleLU(int n){
        for (int i = 1; i <= n; i++){
            for (int j = n; j >= i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleRU(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j < i; j++){
                System.out.print(" ");
            }
            for (int j = n; j >= i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleRB(int n){
        for (int i = 1; i <= n; i++){
            for (int j = n; j >= i; j--){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        triangleLB(5);
        triangleLU(5);
        triangleRU(5);
        triangleRB(5);
    }
}
