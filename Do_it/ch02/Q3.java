import java.util.Scanner;

public class Q3 {
    static int sumOf(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1,2,3,4,5,6};

        System.out.println(sumOf(a));

    }
}
