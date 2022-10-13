import java.util.Arrays;

public class Q4 {
    static void copy(int[] a, int[] b){
        for (int i = 0; i < b.length; i++){
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {
        int[] b = {1,2,3,4,5};
        int[] a = new int[b.length];
        copy(a,b);
        System.out.println("a : " + Arrays.toString(a));
        System.out.println("b : " + Arrays.toString(b));
    }
}
